package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8001;
import com.et.terminalserver.t808.util.T808_Util;

import java.nio.ByteBuffer;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8001_Process
 * @Description: 平台通用应答协议解析类
 * @author: guanhl
 * @date: 2014年6月13日 下午3:49:52
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8001_Process extends T808_Process<T808_MessageHeader, T808_0x8001> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8001> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8001> message) {

		// if(((T808_0x8001) message.getMessageBody()).getResponseID()==0x0200){
		// return null;
		// }
		// 获取消息头
		byte[] head = T808_Util.getInitNoPackHeadr();

		head[0] = (byte) 0x80;
		head[1] = 0x01;
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

		// 获取消息体
		byte[] body = new byte[5];
		byte[] replynum = BytesUtil.int2bytes2(((T808_0x8001) message.getMessageBody()).getRunningNum());// 应答流水号
		body[0] = replynum[0];
		body[1] = replynum[1];
		// 应答流水号
		byte[] replyid = BytesUtil.int2bytes2(((T808_0x8001) message.getMessageBody()).getResponseID());
		body[2] = replyid[0];
		body[3] = replyid[1];
		body[4] = (byte) ((T808_0x8001) message.getMessageBody()).getResult();

		// log.debug("messageID:0x8001|sim:"
		// + ((T808_MessageHeader)message.getMessageHeader()).getSimNum() +
		// "|runningNum:"
		// + ((T808_MessageHeader)message.getMessageHeader()).getRunningNum() +
		// "|answerNum:"
		// + ((T808_0x8001) message.getMessageBody()).getRunningNum()
		// + "|responseID:"
		// + ((T808_0x8001) message.getMessageBody()).getResponseID()
		// + "|result:" + ((T808_0x8001) message.getMessageBody()).getResult());

		byte[] length = BytesUtil.int2bytes2(5);
		head[2] = length[0];
		head[3] = length[1];

		// 创建ByteBuffer
		ByteBuffer bb = ByteBuffer.allocate(100);

		byte[] mes = null;
		bb.put((byte) 0x00);
		bb.put(head);
		bb.put(body);
		bb.put((byte) 0x00);
		bb.put((byte) 0x00);
		int i = bb.position();
		byte[] bosBytes = new byte[i];
		bb.flip();
		bb.get(bosBytes);

		byte check = T808_Util.check(bosBytes);
		bosBytes[bosBytes.length - 2] = check;
		mes = T808_Util.escapeData(bosBytes);
		mes[0] = 0x7e;
		mes[mes.length - 1] = 0x7e;

		return mes;
	}

	public static void main(String[] args) {
		byte[] bytes = { 80, 01, 00, 05, 01, 23, 45, 67, 00, 02, 00, 01, 00, 02, 01, 02, 00, 86 };
	}

}
