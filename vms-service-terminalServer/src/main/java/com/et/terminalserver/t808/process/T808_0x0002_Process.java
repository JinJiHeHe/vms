package com.et.terminalserver.t808.process;

import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0002;
import com.et.terminalserver.t808.util.T808_Util;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0002_Process
 * @Description: 终端心跳
 * @author: guanhl
 * @date: 2014年8月6日 下午9:33:43
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0002_Process extends
		T808_Process<T808_MessageHeader, T808_0x0002> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0002> unpackData(byte[] data) {
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_REQUEST);
		T808_0x0002 body = new T808_0x0002();
		return new T808_Message<T808_MessageHeader, T808_0x0002>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0002> message) {
		return null;
	}

}
