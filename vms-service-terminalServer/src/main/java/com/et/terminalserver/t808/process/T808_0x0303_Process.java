package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0303;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0303_Process
 * @Description: 信息点播/取消协议解析
 * @author: lijz
 * @date: 2014年4月17日 上午11:29:41
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0303_Process extends T808_Process<T808_MessageHeader, T808_0x0303> {

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0303> unpackData(byte[] data) {
		// 获取消息体
		T808_0x0303 body = new T808_0x0303();
		// 信息类型
		body.setType(BytesUtil.getByte(0, data));
		// 点播/取消标志
		body.setPlay(BytesUtil.getByte(1, data));
		return null;
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0303> message) {
		//
		return null;
	}

}
