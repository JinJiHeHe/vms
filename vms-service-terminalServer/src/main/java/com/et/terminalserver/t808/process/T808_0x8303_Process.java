package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8303;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8303_Process
 * @Description: 信息点播/取消协议解析类
 * @author: lijz
 * @date: 2014年4月21日 下午6:40:34
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8303_Process extends T808_Process<T808_MessageHeader, T808_0x8303> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8303> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8303> message) {
		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x83;
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
		// 消息头
		int lengths = 1;
		T808_0x8303 body = (T808_0x8303) message.getMessageBody();

		// 消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte setType = BytesUtil.parseIntToByte(body.getSetType());// 设置类型
		byte infoItemCount = 1;
		byte[] result = null;
		byte[] mes = null;
		if (setType != 0) {
			infoItemCount = BytesUtil.parseIntToByte(body.getInfoItemCount());// 信息项总数

			// 传输过来多个ID，进行处理
			List<String> list = body.getInfoList();// 信息项列表
			for (int i = 0; i < list.size(); i++) {
				result = infoItemsList(list.get(i));
				try {
					bos.write(result);
				} catch (IOException e) {
				}
			}
			result = bos.toByteArray();
			lengths += 1 + result.length;
		}
		// 获取body的长度
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
				bos.write(infoItemCount);
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
	 * @Description:解析信息项列表的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private byte[] infoItemsList(String keyString) {
		String[] keyList = keyString.split(",");
		// 信息类型
		byte infoType = BytesUtil.parseIntToByte(Integer.parseInt(keyList[0]));
		// 信息名称长度
		byte[] infoNames = null;
		try {
			infoNames = keyList[1].getBytes("GBK");// 字符串的字节数
		} catch (UnsupportedEncodingException e) {
		}
		// 信息名称
		byte[] infoNamesLengths = BytesUtil.int2bytes2(infoNames.length);
		// byte[] keyContentsLengths = shortToByteBig((short)
		// keyContents.length);
		byte[] result = new byte[3 + infoNames.length];
		result[0] = infoType;
		result[1] = infoNamesLengths[0];
		result[2] = infoNamesLengths[1];
		for (int i = 0; i < infoNames.length; i++)
			result[3 + i] = infoNames[i];

		return result;
	}

}
