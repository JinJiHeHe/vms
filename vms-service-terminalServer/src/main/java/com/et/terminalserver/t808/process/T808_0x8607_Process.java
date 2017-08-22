package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8607;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8607_Process
 * @Description: 删除路线协议解析类
 * @author: lijz
 * @date: 2014年5月6日 下午5:34:41
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8607_Process extends T808_Process<T808_MessageHeader, T808_0x8607> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8607> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8607> message) {
		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x86;
		head[1] = 0x07;

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
		List<Integer> list = ((T808_0x8607) message.getMessageBody()).getList();
		// 路线数
		int lineNumbers = list.size();
		// 路线ID1
		byte lineNumber = BytesUtil.parseIntToByte(lineNumbers);
		byte[] mes = null;
		byte[] result = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		for (int i = 0; i < list.size(); i++) {
			result = lineIDCounts(list.get(i));
			try {
				bos.write(result);
			} catch (IOException e) {
			}
		}
		result = bos.toByteArray();

//		// 打印log
//		log.debug("messageID:0x8607|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|lineNumber:" + lineNumbers + "|LineIDCounts:" + list.size());

		// 消息头
		byte[] length = BytesUtil.int2bytes2(1 + list.size() * 4);
		head[2] = length[0];
		head[3] = length[1];

		// 合成消息体
		try {
			bos.reset();
			bos.write(0x00);
			bos.write(head);
			bos.write(lineNumber);
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
//			log.warn("", e);
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
	//				log.warn("", e);
				}
			}
		}
		//log.debug("data hex answer " + BytesUtil.bytesToHexString(mes));
		return mes;
	}

	/**
	 * @Description:设置路线的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private byte[] lineIDCounts(Integer values) {
		byte[] lineID = new byte[4];
		byte[] result = new byte[4];

		lineID = BytesUtil.int2bytes4(values);

		result[0] = lineID[3];
		result[1] = lineID[2];
		result[2] = lineID[1];
		result[3] = lineID[0];

		return result;
	}

}