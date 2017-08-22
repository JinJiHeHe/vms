package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8401;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8401_Process
 * @Description: 设置电话本协议解析
 * @author: lijz
 * @date: 2014年4月16日 下午6:09:32
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8401_Process extends T808_Process<T808_MessageHeader, T808_0x8401> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8401> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8401> message) {
		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x84;
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
		T808_0x8401 body = (T808_0x8401) message.getMessageBody();
		int lengths = 1;
		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		// 设置类型
		byte setType = BytesUtil.parseIntToByte(body.getSetType());
		byte contactsTotality = 1;
		byte[] result = null;
		byte[] mes = null;
		if (setType != 0) {
			contactsTotality = BytesUtil.parseIntToByte(body.getContactsTotality());// 联系人总数

			// byte packageContactsNumber =
			// BytesUtil.parseIntToByte(body.getPackageContactsNumber());//
			// 联系人总数

			// 联系人项
			List<String> list = body.getContactsList();// 联系人项
			for (int i = 0; i < list.size(); i++) {
				result = contactsItemsList(list.get(i));
				try {
					bos.write(result);
				} catch (IOException e) {
				}
			}
			result = bos.toByteArray();
			lengths += 1 + result.length;
		}

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
				bos.write(contactsTotality);
				// bos.write(packageContactsNumber);
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
	 * @Description:联系人项方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private byte[] contactsItemsList(String contactsList) {
		String[] contactList = contactsList.split(",");
		// 标志
		byte signs = BytesUtil.parseIntToByte(Integer.parseInt(contactList[0]));
		// 电话号码
		byte[] phoneNumber = null;
		try {
			String phoneNumberStr = contactList[1];// 电话号码
			phoneNumber = phoneNumberStr.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
		}
		// 电话号码长度
		byte phoneLength = BytesUtil.parseIntToByte(phoneNumber.length);

		// 联系人
		byte[] contacts = null;// 联系人
		try {
			String contactsStr = contactList[2];
			contacts = contactsStr.getBytes("GBK");// 字符串的字节数
		} catch (UnsupportedEncodingException e) {
		}
		// 联系人长度
		byte contactsLength = BytesUtil.parseIntToByte(contacts.length);
		// 创建数据并赋值
		byte[] result = new byte[3 + phoneNumber.length + contacts.length];
		result[0] = signs;
		result[1] = phoneLength;
		int length = phoneNumber.length;
		for (int i = 0; i < length; i++)
			result[2 + i] = phoneNumber[i];
		result[2 + length] = contactsLength;
		for (int j = 0; j < contacts.length; j++)
			result[3 + length + j] = contacts[j];

		return result;
	}

}
