package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8400;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8400_Process
 * @Description: 电话回拨协议解析
 * @author: lijz
 * @date: 2014年4月16日 下午5:35:20
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8400_Process extends T808_Process<T808_MessageHeader, T808_0x8400> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8400> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8400> message) {
		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x84;
		head[1] = 0x00;

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
		byte sign = BytesUtil.parseIntToByte(((T808_0x8400) message.getMessageBody()).getSign());// 标志

		byte[] phoneNumber = null;
		int pLength = 20;
		try {
			String phoneNumberStr = ((T808_0x8400) message.getMessageBody()).getPhoneNumber();// 电话号码
			// 截取电话号码最长为20字节的方法
			while (phoneNumberStr.getBytes("GBK").length > 20) {
				phoneNumberStr = phoneNumberStr.substring(0, pLength--);
			}
			phoneNumber = phoneNumberStr.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
		}

//		log.debug("messageID:0x8400|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|Sign:" + ((T808_0x8400) message.getMessageBody()).getSign()
//				+ "|PhoneNumber:" + ((T808_0x8400) message.getMessageBody()).getPhoneNumber());

		int len = 1;// body的长度
		if (null != phoneNumber) {
			len += phoneNumber.length;
		}

		// 消息头
		byte[] length = BytesUtil.int2bytes2(len);
		head[2] = length[0];
		head[3] = length[1];

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		try {
			bos.write(0x00);
			bos.write(head);
			bos.write(sign);
			bos.write(phoneNumber);
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

		// 打印log
		return mes;
	}

}
