package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageBody;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8900;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8900_Process
 * @Description: 数据下行透传
 * @author: lijz
 * @date: 2014年8月6日 下午9:24:05
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8900_Process extends T808_Process<T808_MessageHeader,T808_MessageBody> {
	
	

	@Override
	public Message<T808_MessageHeader,T808_MessageBody> unpackData(byte[] data) {
		return null;
	}

	/**
	 * @Description:打包消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_MessageBody> message) {
		
		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x88;
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
		// 0 透传消息类型 BYTE
		// 1 信息总长度 DWORD 整条透传消息的总长度
		// 5 包信息长度 WORD 本条消息的长度
		// 7 透传消息内容
		/*
		 * private int transferMessageType; private int MessageLength; private
		 * int packageMessageLength; private int transferMessageContent;
		 */
		// 消息体
		byte[] body = new byte[7];
		// 透传消息类型
		byte transferMessageType = BytesUtil.parseIntToByte(((T808_0x8900) message.getMessageBody()).getTransferMessageType());// 透传消息类型
		body[0] = transferMessageType;
		// 信息总长度
		byte[] messageLength = BytesUtil.int2bytes4(((T808_0x8900) message.getMessageBody()).getMessageLength());// 信息总长度
		body[1] = messageLength[0];
		body[2] = messageLength[1];
		body[3] = messageLength[2];
		body[4] = messageLength[3];
		// 包信息长度
		byte[] packageMessageLength = BytesUtil.int2bytes2(((T808_0x8900) message.getMessageBody()).getPackageMessageLength());// 包信息长度
		body[5] = packageMessageLength[0];
		body[6] = packageMessageLength[1];

		// 透传消息内容还没有实现
		byte transferMessageContent = BytesUtil.parseIntToByte(((T808_0x8900) message.getMessageBody()).getTransferMessageContent());// 透传消息内容
//
//		// 打印log
//		log.debug("messageID:0x8900|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|TransferMessageType:"
//				+ ((T808_0x8900) message.getMessageBody()).getTransferMessageType() + "|MessageLength:"
//				+ ((T808_0x8900) message.getMessageBody()).getMessageLength() + "|PackageMessageLength:"
//				+ ((T808_0x8900) message.getMessageBody()).getPackageMessageLength() + "|TransferMessageContent:"
//				+ ((T808_0x8900) message.getMessageBody()).getTransferMessageContent());

		// 消息头
		byte[] length = BytesUtil.int2bytes2(5);
		head[2] = length[0];
		head[3] = length[1];

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		try {
			bos.write(0x00);
			bos.write(head);
			bos.write(body);
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
				try {// 关闭流
					bos.close();
				} catch (IOException e) {
				}
			}
		}

		// 打印log
//		log.debug("data hex answer " + BytesUtil.bytesToHexString(mes));
		return mes;
	}

	

}
