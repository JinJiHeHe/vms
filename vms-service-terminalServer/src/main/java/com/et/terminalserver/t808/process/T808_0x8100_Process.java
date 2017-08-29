package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8100;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8100_Process
 * @Description: 终端注册应答
 * @author: guanhl
 * @date: 2014年8月6日 下午9:30:16
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8100_Process extends T808_Process<T808_MessageHeader, T808_0x8100> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8100> unpackData(byte[] data) {
		return null;
	}

	/**
	 * @Description:打包消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x8100> message) {
		// 获取消息头
		byte[] head = T808_Util.getInitNoPackHeadr();

		head[0] = (byte) 0x81;
		head[1] = 0x00;

		// 拼接电话号码
		byte[] phone = BytesUtil.strToBcd(((T808_MessageHeader) message.getMessageHeader()).getSimNum());// 终端手机号
		head[4] = phone[0];
		head[5] = phone[1];
		head[6] = phone[2];
		head[7] = phone[3];
		head[8] = phone[4];
		head[9] = phone[5];
		// 获取流水号
		byte[] seiralnum = BytesUtil.int2bytes2(((T808_MessageHeader) message.getMessageHeader()).getRunningNum());// 消息流水号
		head[10] = seiralnum[0];
		head[11] = seiralnum[1];

		// 应答流水号
		byte[] answerNum = BytesUtil.int2bytes2(((T808_0x8100) message.getMessageBody()).getRunningNum());
		// 结果
		byte result = (byte) ((T808_0x8100) message.getMessageBody()).getResult();
		// 鉴权码
		byte[] authCode = null;
		try {
			String authCodeStr = ((T808_0x8100) message.getMessageBody()).getAuthCode();
			if (null != authCodeStr) {
				authCode = authCodeStr.getBytes("GBK");
			}
		} catch (UnsupportedEncodingException e) {
		}

		// 打印log
//		log.debug("messageID:0x8100|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|answerNum:"
//				+ ((T808_0x8100) message.getMessageBody()).getRunningNum() + "|result:" + ((T808_0x8100) message.getMessageBody()).getResult()
//				+ "|authCode:" + ((T808_0x8100) message.getMessageBody()).getAuthCode());

		int len = 3;
		if (null != authCode) {
			len += authCode.length;
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
			bos.write(answerNum);
			bos.write(result);
			if (null != authCode) {
				bos.write(authCode);
			}
			bos.write(0x00);
			bos.write(0x00);
			byte check = T808_Util.check(bos.toByteArray());
			byte[] bosBytes = bos.toByteArray();
			bosBytes[bosBytes.length - 2] = check;
			mes = T808_Util.escapeData(bosBytes);
			mes[0] = 0x7E;
			mes[bosBytes.length - 1] = 0x7E;
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
	//	log.debug("data hex answer " + BytesUtil.bytesToHexString(mes));
		return mes;
	}

}
