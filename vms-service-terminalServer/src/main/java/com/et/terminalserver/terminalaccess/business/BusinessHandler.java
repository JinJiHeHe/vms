package com.et.terminalserver.terminalaccess.business;

import com.et.terminalserver.api.GisCompute;
import com.et.terminalserver.api.model.SimCardInfo;
import com.et.terminalserver.api.model.TerminalInfo;
import com.et.terminalserver.api.model.VehicleInfo;
import com.et.terminalserver.common.bus.BusManager;
import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.common.cache.ICache;
import com.et.terminalserver.common.cache.LocalCacheManager;
import com.et.terminalserver.common.util.LngLatUtil;
import com.et.terminalserver.common.util.LonLat;
import com.et.terminalserver.protocols.business.bo.*;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.terminalaccess.baseinfo.BaseInfo;
import com.et.terminalserver.terminalaccess.netty.Packet;
import com.et.terminalserver.terminalaccess.netty.RelationInfo;
import com.et.terminalserver.terminalaccess.util.BusConnectName;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: ProtocolHandler
 * @Description: 协议处理
 * @author: yangjl
 * @date: 2014年8月21日 下午4:11:36
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

public class BusinessHandler implements Business {

//	// 报警计算接口

	// 日志
	private static Log log = LogFactory.getLog(BusinessHandler.class);
//	AlarmCompute alarm;

	// 静态信息接口
	BaseInfo baseinfo;

	// gis计算接口
	GisCompute gis;

	// 车辆上一个点的缓存
	ICache lastGps = LocalCacheManager.getCache("_lastGps");

	private static final String CENTERAUTHCODE = "auth_right";

	/**
	 * 终端下线
	 */
	@Override
	public TUGpsInfo terminalOffLine(OPOffLine offLine) {
		TUGpsInfo gpsInfo = (TUGpsInfo) lastGps.get(offLine.getVid());
		Command command = null;
		if (null != gpsInfo) {
			// 下线状态
			gpsInfo.setOnOffLineFlag(-1);
			// 创建指令
			command = new Command();
			command.setCode(BusinessObject.OP_OFFLINE);
			command.setParam(gpsInfo);
			// 推送到页面，跳到web.pushgps包里
			BusManager.sendCommand(BusConnectName.PUSHGPS2WEB, command);
		} else {
			log.warn("It seems that no gps has receive of vechile "
					+ offLine.getVid());
		}
		return gpsInfo;
	}

	/**
	 * 填充gps信息
	 * 
	 * @param info
	 * @param packet
	 * @return
	 */
	private TUGpsInfo fillGpsInfo(TUGpsInfo info, Packet packet) {

		packet = fillRelationInfo(packet);
		if (packet == null) {
			return null;
		}

		VehicleInfo vechileInfo = packet.getChannelWapper().getRelationInfo()
				.getVehicleInfo();
		SimCardInfo simCardInfo = packet.getChannelWapper().getRelationInfo()
				.getSimInfo();
		TerminalInfo terminalinfo = packet.getChannelWapper().getRelationInfo()
				.getTerminalInfo();
		// 驾驶员id
		try {
			info.setDriverId(Integer.valueOf(vechileInfo.getDriverId()));
		} catch (NumberFormatException e) {
			info.setDriverId(0);
		}
		// 组织机构
		info.setgCode(vechileInfo.getGcode());
		// sim卡
		info.setSim(simCardInfo.getSimNum());
		// 终端编号
		info.setTerminalID(terminalinfo.getTerminalCode());
		// 终端类型
		info.setTerminalType(terminalinfo.getTerminalType());
		// 车辆id
		info.setVehicleID(vechileInfo.getVechileId());
		// 车牌
		info.setVehicleNumber(vechileInfo.getPlate());
		// 上传方式
		info.setUploadType(vechileInfo.getUplopadType());
		// 车辆状态 停车or行驶
		info.setStatus(info.getSpeed() > 5 ? "行驶中" : "停车");
		return info;
	}

	/**
	 * 接收GPS信息
	 */
	@Override
	public TUGpsInfo receiveGpsInfo(TUGpsInfo info, Packet packet) {

		// 填充已有信息
		info = fillGpsInfo(info, packet);
		if (null == info) {
			return null;
		}
		// 经纬度加密
		LonLat lonLat = new LonLat();
		LngLatUtil.transform(info.getLat(), info.getLon(), lonLat);
		info.setElat(lonLat.getLatitude());
		info.setElon(lonLat.getLongitude());
		// 中文位置
		info.setLocatoinName(gis.getLocaltionName(lonLat.getLatitude(),
				lonLat.getLongitude()));
		// 服务器时间
		info.setServerTime(new Date());
		// 平台报警计算
		// info.setAlarmTag(alarm.alarmCompute(info));
		info.setHoldTime(packet.getHoldTime());
		// 上下线状态
		info.setOnOffLineFlag(packet.getChannelState());

		if (lastGps.containsKey(info.getVehicleID())) {
			if (((TUGpsInfo) lastGps.get(info.getVehicleID())).getgTime()
					.getTime() >= info.getgTime().getTime()) {
				// 已接受
				info.setAcceptState(BusinessObject.S_UNACCEPT);
				return info;
			}
		}
		info.setAcceptState(BusinessObject.S_ACCEPT);
		
		// 创建指令
		Command push_command = new Command();
		push_command.setCode(BusinessObject.TU_RECEIVE_GPS);
		push_command.setParam(info);
		// 推送到页面
		BusManager.sendCommand(BusConnectName.PUSHGPS2WEB, push_command);
		// 推送到hbase
//		BusManager.sendCommand(BusConnectName.PUSHGPS2HBASE, push_command);

		// 创建指令
		Command response_command = new Command();
		response_command.setCode(BusinessObject.TU_RECEIVE_GPS);
		response_command.setParam(packet);
		// 推送到响应处理 - encode包
		BusManager.sendCommand(BusConnectName.ENCODER, response_command);

		// 存入最后一条 gps
		lastGps.put(info.getVehicleID(), info);
		return info;

	}

	public Packet fillRelationInfo(Packet packet) {
		String terminalKey = packet.getTerminalKey();
		if (packet.getChannelState() == 1) {
			String simNum = null;
			String terminalCode = null;
			String vehicleID = null;
			SimCardInfo siminfo = null;
			TerminalInfo terminalInfo = null;
			VehicleInfo vehicleInfo = null;
			if (null != baseinfo.getSimCardInfo(terminalKey)) {
				siminfo = baseinfo.getSimCardInfo(terminalKey);
				terminalCode = siminfo.getTerminalCode();
				if (null == terminalCode) {
					// 这就是没人搭理这张sim卡，奈何一个人的孤单，无尽的夜孤枕难眠
					log.warn("No Terminal installed the simcard "
							+ siminfo.getSimNum());
					return null;
				}
				terminalInfo = baseinfo.getTerminalInfo(terminalCode);
				if (null != terminalInfo) {
					vehicleID = terminalInfo.getVechileId();
					if (null == vehicleID) {
						// 这是没有被任何车辆安装的终端
						log.warn("No vechile installed the terminal "
								+ terminalCode);
						return null;
					}
					// 缓存取车辆信息
					vehicleInfo = baseinfo.getVechileInfo(vehicleID);
					// 算是防空验证
					if (null == vehicleInfo) {
						log.warn("No vechile " + vehicleID + " in cache");
						return null;
					}
					simNum = terminalInfo.getSimNum();
					packet.setChannelState(BusinessObject.S_ACCEPT);
				} else {
					// 这是没有被任何车辆安装的终端
					log.warn("No terminal " + terminalCode + " in cache");
					return null;
				}
			} else {
				if (null != baseinfo.getTerminalInfo(terminalKey)) {
					terminalCode = terminalKey;
					terminalInfo = baseinfo.getTerminalInfo(terminalKey);
					vehicleID = terminalInfo.getVechileId();
					if (null == vehicleID) {
						// 这是没有被任何车辆安装的终端
						log.warn("No vechile installed the terminal "
								+ terminalCode);
						return null;
					}
					// 缓存取车辆信息
					vehicleInfo = baseinfo.getVechileInfo(vehicleID);
					// 算是防空验证
					if (null == vehicleInfo) {
						log.warn("No vechile " + vehicleID + " in cache");
						return null;
					}
					simNum = terminalInfo.getSimNum();
					if (null != simNum)
						siminfo = baseinfo.getSimCardInfo(simNum);
					else {
						log.warn("No simCard " + simNum + "in cache");
						return null;
					}
					packet.setChannelState(BusinessObject.S_ACCEPT);
				} else {
					log.warn("No terminal and simCard in cache like "
							+ terminalKey);
					return null;
				}
			}

			// 刷新链路状态
			// 创建指令
			Command fill_command = new Command();
			fill_command.setCode(BusinessObject.OP_FILLINFO);
			RelationInfo relation = new RelationInfo();
			relation.setTerminalKey(terminalKey);
			// relation.setVehicleID(vehicleID);
			// relation.setTerminalID(terminalCode);
			// relation.setSinNum(simNum);
			relation.setSimInfo(siminfo);
			relation.setTerminalInfo(terminalInfo);
			relation.setVehicleInfo(vehicleInfo);
			fill_command.setParam(relation);
			packet.getChannelWapper().setRelationInfo(relation);
			BusManager.sendCommand(BusConnectName.NETTY_WRITER, fill_command);
			return packet;
		}
		return packet;
	}

	/**
	 * 注册
	 */
	@Override
	public TURegister registerTerminal(TURegister register, Packet packet) {
		packet = fillRelationInfo(packet);
		if (packet == null) {
			return null;
		}
		register.setAuthCode(CENTERAUTHCODE);
		Command command = new Command();
		command.setCode(BusinessObject.TU_REGISTER);
		command.setParam(packet);
		BusManager.sendCommand(BusConnectName.ENCODER, command);
		return register;
	}

	/**
	 * 鉴权
	 */
	@Override
	public TUCheck checkTerminal(TUCheck check, Packet packet) {
		packet = fillRelationInfo(packet);
		if (packet == null) {
			return null;
		}
		if (!CENTERAUTHCODE.equals(check.getAuthCode())) {
			log.warn("AuthCode is " + check.getAuthCode() + " of terminal "
					+ packet.getTerminalKey());

		}
		check.setAcceptState(BusinessObject.S_ACCEPT);
		Command command = new Command();
		command.setCode(BusinessObject.TU_CHECK);
		command.setParam(packet);
		BusManager.sendCommand(BusConnectName.ENCODER, command);
		return check;
	}

	/**
	 * 心跳
	 */
	@Override
	public TUHeart receiveHeart(TUHeart heart, Packet packet) {
		packet = fillRelationInfo(packet);
		if (packet == null) {
			return null;
		}
		heart.setAcceptState(BusinessObject.S_ACCEPT);
		Command command = new Command();
		command.setCode(BusinessObject.TU_HEART);
		command.setParam(packet);
		BusManager.sendCommand(BusConnectName.ENCODER, command);
		return heart;
	}

//	public AlarmCompute getAlarm() {
//		return alarm;
//	}

//	public void setAlarm(AlarmCompute alarm) {
//		this.alarm = alarm;
//	}

	public BaseInfo getBaseinfo() {
		return baseinfo;
	}

	public void setBaseinfo(BaseInfo baseinfo) {
		this.baseinfo = baseinfo;
	}

	public GisCompute getGis() {
		return gis;
	}

	public void setGis(GisCompute gis) {
		this.gis = gis;
	}

	@Override
	public TUPassThrough passThrough(TUPassThrough passThrough,
			Packet packet_passthrough) {

		Command push_command = new Command();
		push_command.setCode(BusinessObject.TU_PASSTHROUGH);
		push_command.setParam(passThrough);

		// 推送到页面
		BusManager.sendCommand(BusConnectName.PUSHPASSTHROUGH, push_command);

		Command pushstr_command = new Command();
		String vid = packet_passthrough.getChannelWapper().getRelationInfo()
				.getVehicleInfo().getVechileId();
		pushstr_command.setCode(BusinessObject.TU_PASSTHROUGH);
		pushstr_command.setParam(vid + ";" + passThrough.getType() + ";"
				+ BytesUtil.bytesToHexString(passThrough.getData()));
		// 推送到hbase
		BusManager.sendCommand(BusConnectName.PUSHGPS2HBASE, pushstr_command);

		// 通用应答
		Command command = new Command();
		command.setCode(BusinessObject.TU_PASSTHROUGH);
		command.setParam(packet_passthrough);
		BusManager.sendCommand(BusConnectName.ENCODER, command);
		return passThrough;
	}

	// @Override
	// public TUOrder receiveOrder(TUOrder order, Packet packet) {
	//
	// return null;
	// }
	//
	//
	// /**
	// * 处理驾驶员上报 目前还不知道要干啥 可以确定的是 要传给809服务
	// * */
	// @Override
	// public TUDriverInfo receiveDriverInfo(TUDriverInfo driverInfo, Packet
	// packet) {
	//
	// // 构建参数传递对象
	// BusinessParam param_driveInfo = new BusinessParam();
	// param_driveInfo.setCommandID(0x0702);
	// param_driveInfo.setSeq(packet.getOpts());
	// HashMap<String, String> paramMap = new HashMap<String, String>();
	// param_driveInfo.setParam(paramMap);
	// // param_driveInfo.set
	// // providerTo809.pub(object);
	// return null;
	// }

}
