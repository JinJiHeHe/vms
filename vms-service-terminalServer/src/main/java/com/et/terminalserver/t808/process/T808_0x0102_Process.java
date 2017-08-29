package com.et.terminalserver.t808.process;

import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0102;
import com.et.terminalserver.t808.util.T808_Util;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0102_Process
 * @Description: 鉴权消息处理类
 * @author: guanhl
 * @date: 2014年3月31日 上午1:28:29
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0102_Process extends
		T808_Process<T808_MessageHeader, T808_0x0102> {

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0102> unpackData(byte[] data) {

		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_REQUEST);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		// 获取消息体
		T808_0x0102 body = new T808_0x0102();
		byte[] code = BytesUtil.cutBytes(bodyindex,
				data.length - 2 - bodyindex, data);
		// 设置校验码
		body.setCode(new String(code));
		return new T808_Message<T808_MessageHeader, T808_0x0102>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0102> message) {
		// ·
		return null;
	}

}
