package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8302;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8302_Process
 * @Description: 提问下发协议解析
 * @author: lijz
 * @date: 2014年4月28日 下午4:04:55
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

public class T808_0x8302_Process extends T808_Process<T808_MessageHeader, T808_0x8302> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8302> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8302> message) {
		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x83;
		head[1] = 0x02;

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
		T808_0x8302 body = (T808_0x8302) message.getMessageBody();
		byte mark = BytesUtil.parseIntToByte(body.getMark());// 标志

		byte[] questionDatas = null;// 问题
		String questionData = null;
		try {
			questionData = body.getQuestionData();
			questionDatas = questionData.getBytes("GBK");// 字符串的字节数
		} catch (UnsupportedEncodingException e) {
		}

		int questionLength = questionDatas.length;
		byte questionLengths = BytesUtil.parseIntToByte(questionLength);

		// 消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		byte[] result = null;
		// 传输过来多个ID，进行处理
		List<String> list = body.getListKey();// 候选答案列表
		for (int i = 0; i < list.size(); i++) {
			result = parseKeyCounts(list.get(i));
			try {
				bos.write(result);
			} catch (IOException e) {
			}
		}
		result = bos.toByteArray();

		// 消息头 消息体长度
		byte[] length = BytesUtil.int2bytes2(2 + questionDatas.length + result.length);
		head[2] = length[0];
		head[3] = length[1];

//		log.debug("messageID:0x8302|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|Mark:" + ((T808_0x8302) message.getMessageBody()).getMark());

		try {
			bos.reset();
			bos.write(0x00);
			bos.write(head);
			bos.write(mark);
			bos.write(questionLengths);
			bos.write(questionDatas);
			bos.write(result);
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
	 * @Description:解析候选答案列表的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private byte[] parseKeyCounts(String keyString) {
		String[] keyList = keyString.split(",");
		// 答案ID
		byte keyID = BytesUtil.parseIntToByte(Integer.parseInt(keyList[0]));
		// 答案内容
		byte[] keyContents = null;
		try {
			keyContents = keyList[1].getBytes("GBK");// 字符串的字节数
		} catch (UnsupportedEncodingException e) {
		}
		// 答案内容长度
		byte[] keyContentsLengths = BytesUtil.int2bytes2(keyContents.length);
		// byte[] keyContentsLengths = shortToByteBig((short)
		// keyContents.length);
		byte[] result = new byte[3 + keyContents.length];
		result[0] = keyID;
		result[1] = keyContentsLengths[0];
		result[2] = keyContentsLengths[1];
		for (int i = 0; i < keyContents.length; i++)
			result[3 + i] = keyContents[i];

		return result;
	}
    //之前用这个调试的，现在用不到了，等出现问题了再用
	public static byte[] shortToByteBig(short source) {
		int temp = source;
		if (temp < 0) {
			temp += 65536;
		}
		byte[] b = new byte[2];
		for (int i = 0; i < b.length; i++) {
			b[1 - i] = new Integer(temp & 0xff).byteValue();
			temp = temp >>> 8;
		}
		return b;
	}
}
