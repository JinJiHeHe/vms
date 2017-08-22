package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8203;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class T808_0x8203_Process extends T808_Process<T808_MessageHeader, T808_0x8203> {

	public T808_0x8203_Process() {
		
	}
	
	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x8203> message) {
		
		// 获取消息头
		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x82;
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
		byte[] body = new byte[6];
		// 报警消息流水号
		byte[] alarmSeq = BytesUtil.int2bytes2(((T808_0x8203) message.getMessageBody()).getAlarmMessageSeq());
		body[0] = alarmSeq[0];
		body[1] = alarmSeq[1];

		//人工确认报警类型
		byte[] validity = BytesUtil.int2bytes4(((T808_0x8203) message.getMessageBody()).getAlarmType());
		body[2] = validity[3];
		body[3] = validity[2];
		body[4] = validity[1];
		body[5] = validity[0];

//				log.debug("messageID:0x8202|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//						+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|Interval:"
//						+ ((T808_0x8202) message.getMessageBody()).getInterval() + "|Validity:" + ((T808_0x8202) message.getMessageBody()).getValidity());

		// 消息头
		byte[] length = BytesUtil.int2bytes2(6);
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

				return mes;
	}
	
	@Override
	public Message<T808_MessageHeader, T808_0x8203> unpackData(byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}
}
