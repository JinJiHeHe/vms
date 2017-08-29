package com.et.terminalserver.t808.process;

import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0200;
import com.et.terminalserver.t808.messagebody.T808_0x0704;
import com.et.terminalserver.t808.util.T808_Util;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class T808_0x0704_Process extends
		T808_Process<T808_MessageHeader, T808_0x0704> {
	// 初始化log4j
	private static Log log = LogFactory.getLog(T808_0x0200_Process.class);

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
	public Message<T808_MessageHeader, T808_0x0704> unpackData(byte[] data) {
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_REQUEST);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;

		T808_0x0704 body0704 = new T808_0x0704();
		// 基础位置信息和附加信息分段
		// byte[] localtionInformations = BytesUtil.cutBytes(0, 28, data);
		// 报警标志
		byte[] dataNums = BytesUtil.getWord(0 + bodyindex, data);// word--2字节
		int dataNum = BytesUtil.parseBytesToInt(dataNums);

		byte dataTypes = BytesUtil.getByte(2 + bodyindex, data);
		int dataType = (int) dataTypes;

		byte[] dataLengths = BytesUtil.getWord(3 + bodyindex, data);
		int dataLength = BytesUtil.parseBytesToInt(dataLengths);

		byte[] alarmSigns = BytesUtil.getDWord(5 + bodyindex, data);
		int alarmSign = BytesUtil.parseBytesToInt(alarmSigns);
		// 状态
		byte[] statues = BytesUtil.getDWord(9 + bodyindex, data);
		int status = BytesUtil.parseBytesToInt(statues);

		boolean isLocated = BytesUtil.getBooleanValue(3, 6, statues);
		body0704.setPositionFlag(isLocated);
		// 纬度

		byte[] latitudes = BytesUtil.getDWord(13 + bodyindex, data);
		double latitude = BytesUtil.parseBytesToInt(latitudes) / 1000000.00;
		// 经度
		byte[] longitudes = BytesUtil.getDWord(17 + bodyindex, data);
		double longitude = BytesUtil.parseBytesToInt(longitudes) / 1000000.00;
		// 高程
		byte[] altitudes = BytesUtil.getWord(21 + bodyindex, data);
		double altitude = BytesUtil.parseBytesToInt(altitudes);
		// 速度
		byte[] speeds = BytesUtil.getWord(23 + bodyindex, data);
		float speed = (float) (BytesUtil.parseBytesToInt(speeds) / 10.00);
		// 方向
		byte[] directions = BytesUtil.getWord(25 + bodyindex, data);
		int direction = BytesUtil.parseBytesToInt(directions);

		// 时间
		Date time = null;
		byte[] times = BytesUtil.cutBytes(27 + bodyindex, 6, data);
		try {
			time = formatTL.get().parse(BytesUtil.bcdToStr(times));
		} catch (Exception e) {
			log.warn("", e);
		}
		body0704.setAlarmSign(alarmSign);// 报警标志位
		body0704.setStatus(status);// 状态元数据
		body0704.setLatitude(latitude);// 纬度
		body0704.setLongitude(longitude);// 精度
		body0704.setAltitude(altitude);// 海拔
		body0704.setSpeed(speed);// 速度
		body0704.setDirection(direction);// 方向
		body0704.setTime(time);// 时间
		body0704.setDataType(dataType);
		body0704.setDataLength(dataLength);
		body0704.setDataItemNum(dataNum);

		// // *****状态位解析******
		body0704.setAccFlag(BytesUtil.getBooleanValues(7, statues[3]));//
		// 实例化对象
		log.debug("lat:" + body0704.getLatitude() + "|lon:"
				+ body0704.getLongitude() + "|alt:" + body0704.getAltitude()
				+ "|speed:" + body0704.getSpeed() + "|dir:"
				+ body0704.getDirection() + "|time"
				+ body0704.getTime().toString() + "|acc:"
				+ body0704.isAccFlag());

		return new T808_Message<T808_MessageHeader, T808_0x0704>(header,
				body0704);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0704> message) {
		// TODO Auto-generated method stub
		return null;
	}
}
