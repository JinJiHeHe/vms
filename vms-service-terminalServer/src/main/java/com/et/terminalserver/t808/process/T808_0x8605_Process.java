package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8605;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8605_Process
 * @Description: 删除多边形区域
 * @author: lijz
 * @date: 2014年5月6日 下午5:13:31
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8605_Process extends T808_Process<T808_MessageHeader, T808_0x8605> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8605> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8605> message) {
		// 获取消息体
		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x86;
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
		byte[] mes = null;
		byte[] result = null;

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		List<Integer> list = ((T808_0x8605) message.getMessageBody()).getList();
		int areaNumbers = list.size();
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
//		log.debug("messageID:0x8605|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|AreaNumber:" + areaNumber + "|AreaIDCounts:" + list.size());

		// 消息头
		byte[] length = BytesUtil.int2bytes2(1 + list.size() * 4);
		head[2] = length[0];
		head[3] = length[1];

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
	 * @Description:合成面积ID
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private byte[] areaIDCounts(Integer values) {
		byte[] areaID = new byte[4];
		byte[] result = new byte[4];

		areaID = BytesUtil.int2bytes4(values);
		result[0] = areaID[3];
		result[1] = areaID[2];
		result[2] = areaID[1];
		result[3] = areaID[0];

		return result;
	}

}