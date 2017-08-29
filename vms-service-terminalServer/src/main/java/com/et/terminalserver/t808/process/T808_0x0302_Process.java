package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0302;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0302_Process
 * @Description: 提问应答消息解析类
 * @author: lijz
 * @date: 2014年4月16日 下午3:37:47
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0302_Process extends T808_Process<T808_MessageHeader, T808_0x0302> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0302> unpackData(byte[] data) {
		// 获取消息体
		T808_0x0302 body = new T808_0x0302();
		byte[] replyID = BytesUtil.getWord(0, data);
		byte resultID = BytesUtil.getByte(2, data);
		// 应答流水号
		body.setReplyID(BytesUtil.parseBytesToInt(replyID));// 解析字bytes成int
		// 答案ID
		body.setResultID(resultID);
		return null;
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0302> message) {
		//
		return null;
	}

}
