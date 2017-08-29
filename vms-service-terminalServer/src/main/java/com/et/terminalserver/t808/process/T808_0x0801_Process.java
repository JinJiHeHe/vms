package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0801;
import com.et.terminalserver.t808.util.T808_Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0801_Process
 * @Description: 多媒体数据上传协议解析类
 * @author: lijz
 * @date: 2014年5月7日 下午7:43:08
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0801_Process extends
		T808_Process<T808_MessageHeader, T808_0x0801> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0801> unpackData(byte[] data) {

		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_REQUEST);
		
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		

		T808_0x0801 body = new T808_0x0801();
		if (header.getSubpackage()) {
			int packageNum = ((T808_MessageHeader) header).getPackageNum();
			if (packageNum == 1) {
				byte[] mutilMediaIDs = BytesUtil.getDWord(0 + bodyindex, data);
				int mutilMediaID = BytesUtil.parseBytesToInt(mutilMediaIDs);
				byte type = BytesUtil.getByte(4 + bodyindex, data);
				byte format = BytesUtil.getByte(5 + bodyindex, data);
				byte event = BytesUtil.getByte(6 + bodyindex, data);
				byte channelID = BytesUtil.getByte(7 + bodyindex, data);
				// 报警标志
				byte[] alarmSigns = BytesUtil.getDWord(8 + bodyindex, data);
				int alarmSign = BytesUtil.parseBytesToInt(alarmSigns);
				// 状态
				byte[] statues = BytesUtil.getDWord(12 + bodyindex, data);
				int status = BytesUtil.parseBytesToInt(statues);
				// 纬度
				byte[] latitudes = BytesUtil.getDWord(16 + bodyindex, data);
				double latitude = BytesUtil.parseBytesToInt(latitudes) / 1000000.00;
				// 经度
				byte[] longitudes = BytesUtil.getDWord(20 + bodyindex, data);
				double longitude = BytesUtil.parseBytesToInt(longitudes) / 1000000.00;
				// 高程
				byte[] altitudes = BytesUtil.getWord(24 + bodyindex, data);
				double altitude = BytesUtil.parseBytesToInt(altitudes);
				// 速度
				byte[] speeds = BytesUtil.getWord(26 + bodyindex, data);
				double speed = BytesUtil.parseBytesToInt(speeds) / 10.00;
				// 方向
				byte[] directions = BytesUtil.getWord(28 + bodyindex, data);
				int direction = BytesUtil.parseBytesToInt(directions);
				// 时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
				Date time = null;
				byte[] times = BytesUtil.cutBytes(30 + bodyindex, 6, data);
				try {
					time = sdf.parse(BytesUtil.bcdToStr(times));
				} catch (ParseException e) {
				}

				body.setMultiMediaID(mutilMediaID);
				body.setType(type);
				body.setFormat(format);
				body.setEvent(event);
				body.setChannelID(channelID);
				body.setAlarmSign(alarmSign);// 报警标志
				body.setStatus(status);// 状态元数据
				body.setLatitude(latitude);// 纬度
				body.setLongitude(longitude);// 精度
				body.setAltitude(altitude);// 海拔
				body.setSpeed(speed);// 速度
				body.setDirection(direction);// 方向
				body.setTime(time);// 时间
				byte[] mediadata = BytesUtil.cutBytes(36 + bodyindex,
						data.length - 36 - bodyindex-2, data);
				body.setMultimediaData(mediadata);

			} else {
				byte[] mediadata = BytesUtil.cutBytes(0 + bodyindex,
						data.length - bodyindex-2, data);
				body.setMultimediaData(mediadata);
			}
		}

		return new T808_Message<T808_MessageHeader, T808_0x0801>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0801> message) {
		return null;
	}

}
