package com.et.terminalserver.t808.process;

import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0200;
import com.et.terminalserver.t808.util.T808_Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0200_Process
 * @Description: 位置数据解析类
 * @author: guanhl
 * @date: 2014年3月31日 上午00:58:40
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public final class T808_0x0200_Process extends
		T808_Process<T808_MessageHeader, T808_0x0200> {

	Log log = LogFactory.getLog(T808_0x0200_Process.class);
	/**
	 * @Project: CNPC_VMS车辆管理系统
	 * @Title: ThreadLocal
	 * @Description: 本地线程：为了让时间准确
	 * @author: lijz
	 * @date :2014年10月6日 上午11:03:10
	 * @Copyright: Copyright (c) 2014
	 * @version V2.0
	 */
	private static ThreadLocal<SimpleDateFormat> formatTL = new ThreadLocal<SimpleDateFormat>() {
		/**
		 * @Description:格式化时间：为了线程安全
		 * @param :args
		 * @return
		 * @throws Exception
		 */
		protected synchronized SimpleDateFormat initialValue() {

			return new SimpleDateFormat("yyMMddHHmmss");

		}

	};

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0200> unpackData(byte[] data) {
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_REQUEST);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		// 实例化对象
		T808_0x0200 body0200 = new T808_0x0200();
		// 基础位置信息和附加信息分段
		// byte[] localtionInformations = BytesUtil.cutBytes(0, 28, data);
		// 报警标志
		byte[] alarmSigns = BytesUtil.getDWord(0 + bodyindex, data);
		int alarmSign = BytesUtil.parseBytesToInt(alarmSigns);
		// 状态
		byte[] statues = BytesUtil.getDWord(4 + bodyindex, data);
		int status = BytesUtil.parseBytesToInt(statues);
		// 纬度
		byte[] latitudes = BytesUtil.getDWord(8 + bodyindex, data);
		double latitude = BytesUtil.parseBytesToInt(latitudes) / 1000000.00;
		// 经度
		byte[] longitudes = BytesUtil.getDWord(12 + bodyindex, data);
		double longitude = BytesUtil.parseBytesToInt(longitudes) / 1000000.00;
		// 高程
		byte[] altitudes = BytesUtil.getWord(16 + bodyindex, data);
		double altitude = BytesUtil.parseBytesToInt(altitudes);
		// 速度
		byte[] speeds = BytesUtil.getWord(18 + bodyindex, data);
		float speed = (float) (BytesUtil.parseBytesToInt(speeds) / 10.0);
		// 方向
		byte[] directions = BytesUtil.getWord(20 + bodyindex, data);
		int direction = BytesUtil.parseBytesToInt(directions);

		// 时间
		Date time = null;
		byte[] times = BytesUtil.cutBytes(22 + bodyindex, 6, data);
		try {
			time = formatTL.get().parse(BytesUtil.bcdToStr(times));
		} catch (Exception e) {
		}
		body0200.setAlarmSign(alarmSign);// 报警标志位
		body0200.setStatus(status);// 状态元数据
		body0200.setLatitude(latitude);// 纬度
		body0200.setLongitude(longitude);// 精度
		body0200.setAltitude(altitude);// 海拔
		body0200.setSpeed(speed);// 速度
		body0200.setDirection(direction);// 方向
		body0200.setTime(time);// 时间

		if (data.length > (28 + bodyindex)) {
			// // int num = 0; 得到exInfos的字节数据
			byte[] exInfos = BytesUtil.cutBytes((28 + bodyindex), data.length
					- (28 + bodyindex), data);

			// int infoID = BytesUtil.getByte(0, exInfos);// 求每个数组的值起始值
			// int infoLength = BytesUtil.getByte(1 + 0, exInfos);// 求长度
			// if (infoID == 0x01) {
			// byte[] mileage = BytesUtil.getDWord(2, exInfos);// (4位)
			// body0200.setMileage(BytesUtil.parseBytesToInt(mileage) / 10.0);
			// }
			// 先记录一下总长度
			int total_length = exInfos.length;
			for (int length = 0; total_length - length > 2;) {
				int exinfo_length = exInfos.length;
				int infoID = BytesUtil.getByte(0, exInfos);
				if (infoID > 4 || infoID < 0)
					break;
				int infoLength = BytesUtil.getByte(1 + 0, exInfos);// 求长度
				getExInfo(exInfos, 2, infoLength, infoID, body0200);
				length += infoLength + 2;
				exInfos = BytesUtil.cutBytes(infoLength + 2, exinfo_length
						- infoLength - 2, exInfos);

			}
		}

		// log日志
		log.debug("sim:" + header.getSimNum() + "|lat:"
				+ body0200.getLatitude() + "|lon:" + body0200.getLongitude()
				+ "|alt:" + body0200.getAltitude() + "|speed:"
				+ body0200.getSpeed() + "|dir:" + body0200.getDirection()
				+ "|time" + body0200.getTime().toString() + "|mileage:"
				+ body0200.getMileage() + "|oil:" + body0200.getOil()+"alarm:"+body0200.getAlarmSign());

		return new T808_Message<T808_MessageHeader, T808_0x0200>(header,
				body0200);
	}

	/**
	 * @Description:获取扩展数据(附加信息)
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private void getExInfo(byte[] exInfos, int byteIndex, int length, int id,
			T808_0x0200 mes) {

		switch (id) {
		case 0x01:// 里程
			byte[] mileage = BytesUtil.getDWord(byteIndex, exInfos);// (4位)
			mes.setMileage(BytesUtil.parseBytesToInt(mileage) / 10.0);
			break;
		case 0x02:// 油量
			byte[] oil = BytesUtil.getWord(byteIndex, exInfos);
			mes.setOil(BytesUtil.parseBytesToInt(oil) / 10.0);
			break;
		case 0x03:// 行驶记录功能获取的速度
			byte[] speed = BytesUtil.getWord(byteIndex, exInfos);
			mes.setSpeedAquare((float) (BytesUtil.parseBytesToInt(speed) / 10.0));
			break;
		case 0x04:// 需要人工确认报警事件的 ID
			byte[] alarmEventID = BytesUtil.getWord(byteIndex, exInfos);
			mes.setSpeedAquare(BytesUtil.parseBytesToInt(alarmEventID));
			break;
		case 0x11:// 超速报警附加信息
			byte type = BytesUtil.getByte(byteIndex, exInfos);
			if (type == 0) {
				mes.setOverSpeedAdditional("0");
			} else {
				byte[] roadID = BytesUtil.getBigDWord(byteIndex + 1, exInfos);
				mes.setOverSpeedAdditional(type + ","
						+ BytesUtil.parseBytesToInt(roadID));
			}
			break;
		case 0x12:// 进出区域/路线报警附加信息
			byte regionType = BytesUtil.getByte(byteIndex, exInfos);
			byte[] regionID = BytesUtil.getDWord(byteIndex + 1, exInfos);
			byte way = BytesUtil.getByte(byteIndex + 5, exInfos);
			mes.setTurnoverAdditional(regionType + ","
					+ BytesUtil.parseBytesToInt(regionID) + "," + way);
			break;
		case 0x13:// 路段行驶时间不足/过长报警附加信息
			byte[] roadId = BytesUtil.getDWord(byteIndex, exInfos);
			byte[] time = BytesUtil.getWord(byteIndex + 4, exInfos);
			byte[] result = BytesUtil.getWord(byteIndex + 5, exInfos);
			mes.setTimeoverAdditional(BytesUtil.parseBytesToInt(roadId) + ","
					+ BytesUtil.parseBytesToInt(time) + ","
					+ BytesUtil.parseBytesToInt(result));
			break;
		default:
			break;
		}

	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0200> message) {
		//
		return null;
	}

}
