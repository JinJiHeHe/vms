package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0701;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.UnsupportedEncodingException;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0701_Process
 * @Description: 电子运单上报
 * @author: lijz
 * @date: 2014年8月6日 下午9:32:19
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0701_Process extends T808_Process<T808_MessageHeader, T808_0x0701> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0701> unpackData(byte[] data) {
		
		// 获取消息体
		T808_0x0701 body = new T808_0x0701();
		
		
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_REQUEST);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		
		byte[] length = BytesUtil.getDWord(bodyindex, data);
		// 设置原始长度
		body.setOrderLength(BytesUtil.parseBytesToInt(length));
		try {// GBK一个汉字占2个字节 一个字母占1个字节
			body.setContent(new String(BytesUtil.cutBytes(bodyindex+4, data.length - 4-bodyindex, data), "GBK"));
		} catch (UnsupportedEncodingException e) {
		}
		return new T808_Message<T808_MessageHeader, T808_0x0701>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0701> message) {
		//
		return null;
	}

}
