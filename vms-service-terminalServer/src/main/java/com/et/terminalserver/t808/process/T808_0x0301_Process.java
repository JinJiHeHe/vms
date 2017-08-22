package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0301;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0301_Process
 * @Description: 事件报告消息解析类
 * @author: guanhl
 * @date: 2014年3月31日 上午1:30:44
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0301_Process extends T808_Process<T808_MessageHeader, T808_0x0301> {

	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0301> unpackData(byte[] data) {
		// 获取消息体
		T808_0x0301 body = new T808_0x0301();
		// 事件ID
		int eventID = BytesUtil.getByte(0, data);
		body.setEventID(eventID);
		return null;
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0301> message) {
		return null;
	}

}
