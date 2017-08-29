package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0200;
import com.et.terminalserver.t808.messagebody.T808_0x0500;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0500_Process
 * @Description: 车辆控制应答协议解析类
 * @author: lijz
 * @date: 2014年5月14日 下午4:08:57
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0500_Process extends T808_Process<T808_MessageHeader, T808_0x0500> {

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
	public Message<T808_MessageHeader, T808_0x0500> unpackData(byte[] data) {
		// 实例化对象
		T808_0x0500 body = new T808_0x0500();

		// 应答流水号
		byte[] replaySerialNumbers = BytesUtil.getWord(0, data);
		int replaySerialNumber = BytesUtil.parseBytesToInt(replaySerialNumbers);
		body.setReplaySerialNumber(replaySerialNumber);
		byte[] datas = BytesUtil.cutBytes(2, data.length - 2, data);

		// 实例化对象
		T808_0x0200 body0200 = new T808_0x0200();
		// 基础位置信息和附加信息分段
		// byte[] localtionInformations = BytesUtil.cutBytes(0, 28, data);
		// 报警标志
		byte[] alarmSigns = BytesUtil.getDWord(0, datas);
		int alarmSign = BytesUtil.parseBytesToInt(alarmSigns);
		// 状态
		byte[] statues = BytesUtil.getDWord(4, datas);
		int status = BytesUtil.parseBytesToInt(statues);
		// 纬度
		byte[] latitudes = BytesUtil.getDWord(8, datas);
		double latitude = BytesUtil.parseBytesToInt(latitudes) / 1000000.00;
		// 经度
		byte[] longitudes = BytesUtil.getDWord(12, datas);
		double longitude = BytesUtil.parseBytesToInt(longitudes) / 1000000.00;
		// 高程
		byte[] altitudes = BytesUtil.getWord(16, datas);
		double altitude = BytesUtil.parseBytesToInt(altitudes);
		// 速度
		byte[] speeds = BytesUtil.getWord(18, datas);
		float speed = (float) (BytesUtil.parseBytesToInt(speeds) / 10.00);
		// 方向
		byte[] directions = BytesUtil.getWord(20, datas);
		int direction = BytesUtil.parseBytesToInt(directions);

		// 时间
		Date time = null;
		byte[] times = BytesUtil.cutBytes(22, 6, datas);
		try {
			time = formatTL.get().parse(BytesUtil.bcdToStr(times));
		} catch (Exception e) {
		}
		body0200.setAlarmSign(alarmSign);// 报警标志
		body0200.setStatus(status);// 状态元数据
		body0200.setLatitude(latitude);// 纬度
		body0200.setLongitude(longitude);// 精度
		body0200.setAltitude(altitude);// 海拔
		body0200.setSpeed(speed);// 速度
		body0200.setDirection(direction);// 方向
		body0200.setTime(time);// 时间
		body.setT808_0x0200(body0200);

//		log.debug("SetPlatformSerialNumber : " + body.getReplaySerialNumber() + "T808_0x0200 :" + body.getT808_0x0200().toString());

		return null;
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0500> message) {
		return null;
	}

}
