package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0201;
import com.et.terminalserver.t808.util.T808_Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0201_Process
 * @Description: 位置信息查询应答协议解析类
 * @author: lijz
 * @date: 2014年5月13日 上午9:49:58
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0201_Process extends T808_Process<T808_MessageHeader, T808_0x0201> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	
	public static void main(String[] args) {
		byte[] aa = new byte[]{(byte) 0xf8, 0x73};
		System.out.println(BytesUtil.parseBytesToInt(aa));
	}
	@Override
	public Message<T808_MessageHeader, T808_0x0201> unpackData(byte[] data) {
		
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_RESPONSE);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		
		// 实例化对象
		T808_0x0201 body = new T808_0x0201();

		// 平台流水号
		byte[] platformSerialNumbers = BytesUtil.getWord(0+bodyindex, data);
		int platformSerialNumber = BytesUtil.parseBytesToInt(platformSerialNumbers);
		// 报警标志
		byte[] alarmSigns = BytesUtil.getDWord(2+bodyindex, data);
		int alarmSign = BytesUtil.parseBytesToInt(alarmSigns);
		// 状态
		byte[] statues = BytesUtil.getDWord(6+bodyindex, data);
		int status = BytesUtil.parseBytesToInt(statues);
		// 纬度
		byte[] latitudes = BytesUtil.getDWord(10+bodyindex, data);
		double latitude = BytesUtil.parseBytesToInt(latitudes) / 1000000.00;
		// 经度
		byte[] longitudes = BytesUtil.getDWord(14+bodyindex, data);
		double longitude = BytesUtil.parseBytesToInt(longitudes) / 1000000.00;
		// 高程
		byte[] altitudes = BytesUtil.getWord(18+bodyindex, data);
		double altitude = BytesUtil.parseBytesToInt(altitudes);
		// 速度
		byte[] speeds = BytesUtil.getWord(20+bodyindex, data);
		double speed = BytesUtil.parseBytesToInt(speeds) / 10.00;
		// 方向
		byte[] directions = BytesUtil.getWord(22+bodyindex, data);
		int direction = BytesUtil.parseBytesToInt(directions);
		// 时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Date time = null;
		byte[] times = BytesUtil.cutBytes(24+bodyindex, 6, data);
		try {
			time = sdf.parse(BytesUtil.bcdToStr(times));
		} catch (ParseException e) {
		}
		body.setPlatformSerialNumber(platformSerialNumber);// 平台流水号
		body.setAlarmSign(alarmSign);// 报警标志
		body.setStatus(status);// 状态元数据
		body.setLatitude(latitude);// 纬度
		body.setLongitude(longitude);// 精度
		body.setAltitude(altitude);// 海拔　阿道夫
		body.setSpeed(speed);// 速度
		body.setDirection(direction);// 方向
		body.setTime(time);// 时间

//		log.debug("SetPlatformSerialNumber : " + body.getPlatformSerialNumber() + "| AlarmSign : " + body.getAlarmSign() + "| Status : "
//				+ body.getStatus() + " | Latitude : " + body.getLatitude() + " | Longitude :" + body.getLongitude() + " | Altitude : "
//				+ body.getAltitude() + " | Speed : " + body.getSpeed());

		return new T808_Message<T808_MessageHeader, T808_0x0201>(header,body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0201> message) {
		return null;
	}

}
