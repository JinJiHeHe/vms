package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0901;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0901_Process
 * @Description: 数据压缩上报
 * @author: lijz
 * @date: 2014年8月6日 下午9:30:47
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0901_Process extends T808_Process<T808_MessageHeader, T808_0x0901> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0901> unpackData(byte[] data) {
		// 获取消息体
		T808_0x0901 body = new T808_0x0901();
		byte[] length = BytesUtil.getDWord(0, data);
		byte[] zipfile = BytesUtil.cutBytes(4, data.length - 4, data);
		// 压缩消息长度
		body.setLength(BytesUtil.parseBytesToInt(length));
		// 压缩消息体
		body.setZipfile(zipfile);

		// 打印log
		return null;
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0901> message) {
		//
		return null;
	}

}
