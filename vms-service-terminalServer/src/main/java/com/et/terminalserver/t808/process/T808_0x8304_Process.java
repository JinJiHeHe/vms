package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8304;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8304_Process
 * @Description: 信息服务协议解析
 * @author: lijz
 * @date: 2014年4月28日 下午5:26:12
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8304_Process extends T808_Process<T808_MessageHeader, T808_0x8304> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8304> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8304> message) {
		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x83;
		head[1] = 0x04;

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
		byte infoType = BytesUtil.parseIntToByte(((T808_0x8304) message.getMessageBody()).getInfoType());// 信息类型

		byte[] infoContent = null;// 信息内容
		try {
			String infoContentStr = ((T808_0x8304) message.getMessageBody()).getInfoContent();
			infoContent = infoContentStr.getBytes("GBK");// 字符串的字节数
		} catch (UnsupportedEncodingException e) {
		}

		byte[] infoLength = BytesUtil.int2bytes2(infoContent.length);// 信息总长度

//		log.debug("messageID:0x8304|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|InfoType:"
//				+ ((T808_0x8304) message.getMessageBody()).getInfoType() + "|InfoContent:"
//				+ ((T808_0x8304) message.getMessageBody()).getInfoContent());

		// 求body的长度
		int len = 3;
		if (null != infoContent) {
			len += infoContent.length;
		}

		byte[] length = BytesUtil.int2bytes2(len);
		head[2] = length[0];
		head[3] = length[1];

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		try {
			bos.write(0x00);
			bos.write(head);
			bos.write(infoType);
			bos.write(infoLength);
			if (null != infoContent) {
				bos.write(infoContent);
			}
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

		return mes;
	}

}