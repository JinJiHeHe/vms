package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0802;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0802_Process
 * @Description: 存储多媒体数据检索应答协议解析
 * @author: lijz
 * @date: 2014年5月14日 下午2:05:30
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0802_Process extends T808_Process<T808_MessageHeader, T808_0x0802> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0802> unpackData(byte[] data) {
		// 获取消息体
		T808_0x0802 body = new T808_0x0802();
		// 应答流水
		byte[] replyStream = BytesUtil.getWord(0, data);
		// 多媒体数据总项数
		byte[] multimediaDataCount = BytesUtil.getWord(2, data);
		// 包项数
		byte[] packageNumber = BytesUtil.getWord(4, data);
		// 多媒体ID
		byte[] mutilmediaID = BytesUtil.getDWord(6, data);
		byte multimediaType = BytesUtil.getByte(10, data);
		byte channelID = BytesUtil.getByte(11, data);
		byte eventItemCode = BytesUtil.getByte(12, data);

		// 基础位置信息和附加信息分段
		// byte[] localtionInformations = BytesUtil.cutBytes(0, 28, data);
		// 报警标志
		byte[] alarmSigns = BytesUtil.getDWord(13, data);
		int alarmSign = BytesUtil.parseBytesToInt(alarmSigns);
		// 状态
		byte[] statues = BytesUtil.getDWord(17, data);
		int status = BytesUtil.parseBytesToInt(statues);
		// 纬度
		byte[] latitudes = BytesUtil.getDWord(21, data);
		double latitude = BytesUtil.parseBytesToInt(latitudes) / 1000000.00;
		// 经度
		byte[] longitudes = BytesUtil.getDWord(25, data);
		double longitude = BytesUtil.parseBytesToInt(longitudes) / 1000000.00;
		// 高程
		byte[] altitudes = BytesUtil.getWord(29, data);
		double altitude = BytesUtil.parseBytesToInt(altitudes);
		// 速度
		byte[] speeds = BytesUtil.getWord(31, data);
		double speed = BytesUtil.parseBytesToInt(speeds) / 10.00;
		// 方向
		byte[] directions = BytesUtil.getWord(33, data);
		int direction = BytesUtil.parseBytesToInt(directions);
		// 时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Date time = null;
		byte[] times = BytesUtil.cutBytes(34, 6, data);
		try {
			time = sdf.parse(BytesUtil.bcdToStr(times));
		} catch (ParseException e) {
		}

		body.setReplyStream(BytesUtil.parseBytesToInt(replyStream));
		body.setMultimediaDataCount(BytesUtil.parseBytesToInt(multimediaDataCount));
		body.setPackageNumber(BytesUtil.parseBytesToInt(packageNumber));
		body.setMultimediaID(BytesUtil.parseBytesToInt(mutilmediaID));
		body.setMultimediaType(multimediaType);
		body.setChannelID(channelID);
		body.setEventItemCode(eventItemCode);

		// 位置信息汇报(0x0200)消息体解析
		body.setAlarmSign(alarmSign);// 报警标志
		body.setStatus(status);// 状态元数据
		body.setLatitude(latitude);// 纬度
		body.setLongitude(longitude);// 精度
		body.setAltitude(altitude);// 海拔
		body.setSpeed(speed);// 速度
		body.setDirection(direction);// 方向
		body.setTime(time);// 时间
		// 打印log
//		log.debug("ReplyStream : " + body.getReplyStream() + "| MultimediaDataCount : " + body.getMultimediaDataCount() + "| PackageNumber : "
//				+ body.getPackageNumber() + "| MultimediaID : " + body.getMultimediaID() + "| MultimediaType : " + body.getMultimediaType()
//				+ "| ChannelID : " + body.getChannelID() + "| EventItemCode : " + body.getEventItemCode() + "| AlarmSign : " + body.getAlarmSign()
//				+ "| Status: " + body.getStatus() + "| Latitude : " + body.getLatitude() + "| Longitude : " + body.getLongitude() + "| Altitude : "
//				+ body.getAltitude() + "| Speed : " + body.getSpeed() + "| Direction : " + body.getDirection() + "| Time : " + body.getTime());

		return null;
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0802> message) {
		//
		return null;
	}

}
