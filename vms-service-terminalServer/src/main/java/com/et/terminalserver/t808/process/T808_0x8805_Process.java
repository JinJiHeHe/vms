package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8805;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8805_Process
 * @Description: 单条存储多媒体数据检索上传命令协议解析类
 * @author: lijz
 * @date: 2014年5月6日 上午9:09:02
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8805_Process extends T808_Process<T808_MessageHeader, T808_0x8805> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8805> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8805> message) {

		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x88;
		head[1] = 0x05;

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
		byte[] body = new byte[5];
		// 多媒体 ID
		byte[] multimediaID = BytesUtil.int2bytes4(((T808_0x8805) message.getMessageBody()).getMultimediaID());// 多媒体ID
		body[0] = multimediaID[3];
		body[1] = multimediaID[2];
		body[2] = multimediaID[1];
		body[3] = multimediaID[0];
		// 删除标志
		byte deleteSign = BytesUtil.parseIntToByte(((T808_0x8805) message.getMessageBody()).getDeleteSign());// 删除标志
		body[4] = deleteSign;

//		// 打印log
//		log.debug("messageID:0x8805|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|MultimediaID:"
//				+ ((T808_0x8805) message.getMessageBody()).getMultimediaID() + "|DeleteSign:"
//				+ ((T808_0x8805) message.getMessageBody()).getDeleteSign());

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
				try {
					bos.close();
				} catch (IOException e) {
				}
			}
		}

		//log.debug("data hex answer " + BytesUtil.bytesToHexString(mes));
		return mes;
	}

}