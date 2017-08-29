package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8800;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8800_Process
 * @Description: 多媒体数据上传应答
 * @author: lijz
 * @date: 2014年8月6日 下午9:25:38
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8800_Process extends T808_Process<T808_MessageHeader, T808_0x8800> {

	@Override
	public Message<T808_MessageHeader, T808_0x8800> unpackData(byte[] data) {
		//
		return null;
	}

	/**
	 * @Description:打包消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x8800> message) {

		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x88;
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
		byte[] body = new byte[4];
		// 应答流水号 2位
		// byte[] replySerialNumber =
		// BytesUtil.int2bytes2(Integer.parseInt(((T808_0x8800)
		// message.getMessageBody()).getReplySerialNumber()));
		// 多媒体ID 4位//
		byte[] multimediaID = BytesUtil.int2bytes4(((T808_0x8800) message.getMessageBody()).getMultimediaID());
		// byte[] multimediaID = BytesUtil.int2bytes4(1);
		body[0] = multimediaID[3];
		body[1] = multimediaID[2];
		body[2] = multimediaID[1];
		body[3] = multimediaID[0];
		// 重传包总数 1位
		byte repackageCount = BytesUtil.parseIntToByte(((T808_0x8800) message.getMessageBody()).getRepackageCount());
       
		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		byte[] result = null;
		if(repackageCount != 0){
		// 透传消息内容还没有实现
		// 传输过来多个ID，进行处理
		// 重传包ID列表
		Set<Integer> list = ((T808_0x8800) message.getMessageBody()).getRepackageIDItem();// 区域ID
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			result = repackageIDItem((Integer) iterator.next());
			try {
				bos.write(result);
			} catch (IOException e) {
			}
		}
		result = bos.toByteArray();
		}
		// 打印log
//		log.debug("messageID:0x8800|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|ReplySerialNumber:"
//				+ ((T808_0x8800) message.getMessageBody()).getReplySerialNumber() + "|MultimediaID:"
//				+ ((T808_0x8800) message.getMessageBody()).getMultimediaID() + "|RepackageCount:"
//				+ ((T808_0x8800) message.getMessageBody()).getRepackageCount() + "|RepackageIDItem:"
//				+ ((T808_0x8800) message.getMessageBody()).getRepackageIDItem());

		// 消息头
		int lengths = 5;
		if(repackageCount != 0)
			lengths = result.length;
		byte[] length = BytesUtil.int2bytes2(lengths);
		head[2] = length[0];
		head[3] = length[1];

		try {
			bos.reset();
			bos.write(0x00);
			bos.write(head);
			bos.write(body);
			bos.write(repackageCount);
			if (repackageCount != 0) {
				bos.write(result);
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

	/**
	 * @Description:重传包ID列表的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private byte[] repackageIDItem(Integer values) {
		byte[] result = new byte[2];
		byte[] areas = BytesUtil.int2bytes2(values);// 区域ID长度
		result[0] = areas[0];
		result[1] = areas[1];
		return result;
	}

}
