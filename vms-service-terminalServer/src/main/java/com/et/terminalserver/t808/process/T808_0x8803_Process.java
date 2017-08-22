package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8803;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8803_Process
 * @Description: 存储多媒体数据上传
 * @author: lijz
 * @date: 2014年8月6日 下午9:24:43
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8803_Process extends T808_Process<T808_MessageHeader, T808_0x8803> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8803> unpackData(byte[] data) {
		//
		return null;
	}

	/**
	 * @Description:打包消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x8803> message) {

		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x88;
		head[1] = 0x03;

		// 终端手机号
		byte[] phone = BytesUtil.strToBcd(((T808_MessageHeader) message.getMessageHeader()).getSimNum());
		head[4] = phone[0];
		head[5] = phone[1];
		head[6] = phone[2];
		head[7] = phone[3];
		head[8] = phone[4];
		head[9] = phone[5];

		// 消息流水号
		byte[] seiralnum = BytesUtil.int2bytes2(((T808_MessageHeader) message.getMessageHeader()).getRunningNum());
		head[10] = seiralnum[0];
		head[11] = seiralnum[1];

		// 消息体
		byte multimediaType = BytesUtil.parseIntToByte(((T808_0x8803) message.getMessageBody()).getMultimediaType());// 多媒体类型

		byte channelID = BytesUtil.parseIntToByte(((T808_0x8803) message.getMessageBody()).getChannelID());// 通道ID

		byte eventItemCode = BytesUtil.parseIntToByte(((T808_0x8803) message.getMessageBody()).getChannelID());// 事件项编码

		byte[] beginTime = null;// 开始时间
		try {
			String beginTimeStr = ((T808_0x8803) message.getMessageBody()).getBeginTime();
			if (null != beginTimeStr) {
				beginTime = BytesUtil.strToBcd(beginTimeStr);
			}
		} catch (Exception e) {
		}

		byte[] endTime = null;// 结束时间
		try {
			String endTimeStr = ((T808_0x8803) message.getMessageBody()).getEndTime();
			if (null != endTimeStr) {
				endTime = BytesUtil.strToBcd(endTimeStr);
			}
		} catch (Exception e) {
		}
		// 删除标志
		byte deleteSign = BytesUtil.parseIntToByte(((T808_0x8803) message.getMessageBody()).getDeleteSign());// 删除标识位

//		// 打印log
//		log.debug("messageID:0x8803|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|MultimediaType:"
//				+ ((T808_0x8803) message.getMessageBody()).getMultimediaType() + "|ChannelID:"
//				+ ((T808_0x8803) message.getMessageBody()).getChannelID() + "|EventItemCode:"
//				+ ((T808_0x8803) message.getMessageBody()).getEventItemCode() + "|BeginTime:"
//				+ ((T808_0x8803) message.getMessageBody()).getBeginTime() + "|EndTime:" + ((T808_0x8803) message.getMessageBody()).getEndTime()
//				+ "|DeleteSign:" + ((T808_0x8803) message.getMessageBody()).getDeleteSign());

		// 消息头
		byte[] length = BytesUtil.int2bytes2(16);
		head[2] = length[0];
		head[3] = length[1];

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		try {
			bos.write(0x00);
			bos.write(head);
			bos.write(multimediaType);
			bos.write(channelID);
			bos.write(eventItemCode);
			bos.write(beginTime);
			bos.write(endTime);
			bos.write(deleteSign);
			bos.write(0x00);
			bos.write(0x00);
			byte check = T808_Util.check(bos.toByteArray());
			byte[] bosBytes = bos.toByteArray();
			bosBytes[bosBytes.length - 2] = check;
			mes = T808_Util.escapeData(bosBytes);
			mes[0] = 0x7e;
			mes[mes.length - 1] = 0x7e;
		} catch (IOException e) {
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
				}
			}
		}

	//	log.debug("data hex answer " + BytesUtil.bytesToHexString(mes));
		return mes;
	}

}
