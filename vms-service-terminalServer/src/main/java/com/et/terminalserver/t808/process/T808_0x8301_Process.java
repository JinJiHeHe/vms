package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8301;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8301_Process
 * @Description: 事件设置协议解析
 * @author: lijz
 * @date: 2014年4月17日 上午10:12:53
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8301_Process extends T808_Process<T808_MessageHeader, T808_0x8301> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8301> unpackData(byte[] data) {
		return null;
	}

	/**
	 * @Description:打包消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x8301> message) {

		// 获取消息头
		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x83;
		head[1] = 0x01;

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
		// 消息体
		T808_0x8301 body = (T808_0x8301) message.getMessageBody();
		// 消息头
		int lengths = 1;
		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		// 设置类型
		byte setType = BytesUtil.parseIntToByte(body.getSetType());
		byte setCount = 1;
		byte[] result = null;
		byte[] mes = null;
		if (setType != 0) {
			// 设置总数
			setCount = BytesUtil.parseIntToByte(body.getSetCount());

			// 联系人项
			List<String> list = body.getEventItemList();
			for (int i = 0; i < list.size(); i++) {
				result = eventItemList(list.get(i));
				try {
					bos.write(result);
				} catch (IOException e) {
				}
			}
			result = bos.toByteArray();
			lengths += 1 + result.length;
		}

		// 生成log
//		log.debug("messageID:0x8301|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|SetType:"
//				+ ((T808_0x8301) message.getMessageBody()).getSetType() + "|SetCount:" + ((T808_0x8301) message.getMessageBody()).getSetCount());

		byte[] length = BytesUtil.int2bytes2(lengths);
		head[2] = length[0];
		head[3] = length[1];

		try {
			bos.reset();
			bos.write(0x00);
			bos.write(head);
			if (setType == 0)
				bos.write(setType);
			else {
				bos.write(setType);
				bos.write(setCount);
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
	 * @Description:事件内容方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private byte[] eventItemList(String eventItemList) {
		String[] eventItems = eventItemList.split(",");
		byte eventID = 0;
		// 事件内容
		byte[] eventContents = null;
		// 事件内容长度
		byte eventContentsLength = 0;
		int lengths = 1;
		if (eventItems.length == 1) {
			// 事件ID
			eventID = BytesUtil.parseIntToByte(Integer.parseInt(eventItems[0]));
		} else {
			// 事件ID
			eventID = BytesUtil.parseIntToByte(Integer.parseInt(eventItems[0]));
			try {
				if (null != eventItems[1]) {
					String eventItemsStr = eventItems[1];// 电话号码
					eventContents = eventItemsStr.getBytes("GBK");
				}
			} catch (Exception e) {
			}
			eventContentsLength = BytesUtil.parseIntToByte(eventContents.length);
			lengths += 1 + eventContents.length;
		}

		// 创建数据并赋值
		byte[] result = new byte[lengths];
		if (lengths == 1) {
			result[0] = eventID;
		} else {
			result[0] = eventID;
			result[1] = eventContentsLength;
			int length = eventContents.length;
			for (int i = 0; i < length; i++)
				result[2 + i] = eventContents[i];
		}

		return result;
	}

	private byte[] eventItemList1(String key, String eventContents) {

		int eventContentLength = 0;

		byte[] eventContent = null;
		try {
			if (null != eventContents) {
				eventContent = eventContents.getBytes("GBK");
			}
		} catch (Exception e) {
		}
		eventContentLength = eventContent.length;
		/**
		 * 必须先初始化
		 */
		byte[] result = new byte[2 + eventContentLength];
		result[0] = BytesUtil.parseIntToByte(Integer.parseInt(key));
		result[1] = BytesUtil.parseIntToByte(eventContentLength);
		for (int i = 0; i < eventContentLength; i++) {
			result[2 + i] = eventContent[i];
		}

		return result;
	}

}
