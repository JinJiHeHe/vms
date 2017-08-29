package com.et.terminalserver.t808.process;

import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0001;
import com.et.terminalserver.t808.util.T808_Util;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0001_Process
 * @Description: 终端通用应答
 * @author: guanhl
 * @date: 2014年8月6日 下午9:34:07
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0001_Process extends
		T808_Process<T808_MessageHeader, T808_0x0001> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0001> unpackData(byte[] data) {
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_RESPONSE);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		// 获取消息体
		T808_0x0001 body = new T808_0x0001();
		// 获取回应流水号
		byte[] responseSeqs = BytesUtil.getWord(0 + bodyindex, data);
		short responseSeq = BytesUtil.parseBytesToShort(responseSeqs);
		// 获取回应ID
		byte[] responseIDs = BytesUtil.getWord(2 + bodyindex, data);
		int responseID = BytesUtil.parseBytesToInt(responseIDs);
		// 返回结果
		byte result = BytesUtil.getByte(4 + bodyindex, data);
		body.setResponseSeq(responseSeq);
		body.setResponseID(responseID);
		body.setResult(result);

		return new T808_Message<T808_MessageHeader, T808_0x0001>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0001> message) {
		return null;
	}

}
