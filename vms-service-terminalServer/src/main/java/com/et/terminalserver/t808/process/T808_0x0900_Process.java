package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0900;
import com.et.terminalserver.t808.util.T808_Util;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0900_Process
 * @Description: 数据上行透传
 * @author: lijz
 * @date: 2014年8月6日 下午9:31:10
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0900_Process extends T808_Process<T808_MessageHeader, T808_0x0900> {

	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0900> unpackData(byte[] data) {
		T808_MessageHeader header = T808_Util.getHeader(data);
		// 获取消息体
		T808_0x0900 body = new T808_0x0900();
		byte type = BytesUtil.getByte(0, data);
		byte[] length = BytesUtil.getDWord(1, data);
		byte[] packLength = BytesUtil.getWord(5, data);
		byte[] content = BytesUtil.cutBytes(7, data.length - 7, data);
		// 透传消息类型
		body.setType(type);
		// 信息总长度
		body.setLength(BytesUtil.parseBytesToInt(length));
		// 包信息长度
		body.setPackLength(BytesUtil.parseBytesToInt(packLength));
		// 透传消息内容
		body.setContent(content);

		// 打印log
		return new T808_Message<T808_MessageHeader, T808_0x0900>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0900> message) {
		//
		return null;
	}

}
