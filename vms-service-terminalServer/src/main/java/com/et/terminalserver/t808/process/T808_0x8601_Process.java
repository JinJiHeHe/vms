package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8601;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8601_Process
 * @Description: 删除圆形区域协议解析类
 * @author: lijz
 * @date: 2014年5月6日 下午5:00:23
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8601_Process extends T808_Process<T808_MessageHeader, T808_0x8601> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8601> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8601> message) {
		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x86;
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
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		byte[] result = null;
		// 传输过来多个ID，进行处理
		List<Integer> list = ((T808_0x8601) message.getMessageBody()).getList();// 区域ID
		int areaNumbers = list.size();// 区域ID个数
		byte areaNumber = BytesUtil.parseIntToByte(areaNumbers);
		for (int i = 0; i < list.size(); i++) {
			result = areaIDCounts(list.get(i));
			try {
				bos.write(result);
			} catch (IOException e) {
			}
		}
		result = bos.toByteArray();

		// 打印log

		// 消息头 消息体长度:1 + 4 * list.size()
		byte[] length = BytesUtil.int2bytes2(1 + 4 * list.size());
		head[2] = length[0];
		head[3] = length[1];

		// 合成消息体
		try {
			bos.reset();
			bos.write(0x00);
			bos.write(head);
			bos.write(areaNumber);
			bos.write(result);

			bos.write(0x00);
			bos.write(0x00);
			byte check = T808_Util.check(bos.toByteArray());
			byte[] bosBytes = bos.toByteArray();
			bosBytes[bosBytes.length - 2] = check;
			mes = T808_Util.escapeData(bosBytes);
			mes[0] = 0x7e;
			mes[mes.length - 1] = 0x7e;
			bos.close();
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
		return mes;
	}

	/**
	 * @Description:面积Id总数的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private byte[] areaIDCounts(Integer values) {
		byte[] areas = new byte[4];
		byte[] result = new byte[4];

		areas = BytesUtil.int2bytes4(values);// 区域ID长度

		result[0] = areas[3];
		result[1] = areas[2];
		result[2] = areas[1];
		result[3] = areas[0];

		return result;

	}
}