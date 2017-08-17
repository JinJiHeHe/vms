package com.et.terminalserver.protocols.protocols;

/**
 * @Project: CNPC_VMS
 * @Title: IMessage
 * @Description: 消息接口，提供获取消息头，消息体，消息ID
 * @author: guanhl
 * @date: 2014年4月3日 下午11:48:23
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public interface Message<A extends MessageHeader,B extends MessageBody> {

	/**
	 * @Description:取头
	 * @return 消息头
	 * @throws Exception
	 */
	A getMessageHeader();

	/**
	 * @Description:取体
	 * @return 消息体
	 * @throws Exception
	 */
	B getMessageBody();

}
