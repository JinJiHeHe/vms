package com.et.terminalserver.protocols.protocols;

/**
 * @Project: CNPC_VMS
 * @Title: IMessageHeader
 * @Description: 消息头接口
 * @author: guanhl
 * @date: 2014年4月3日 下午11:46:24
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public interface MessageHeader {

	
	Object getMessageID();

	String getProtocolName();

	int getMessageType();

	String getProtocolVersion();

	int getOpts();

	String getTerminalKey();
	
	void setTerminalKey(String terminalKey);

	String getChannelKey();

}
