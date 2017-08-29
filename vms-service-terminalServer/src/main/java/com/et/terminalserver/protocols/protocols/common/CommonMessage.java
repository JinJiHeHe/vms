package com.et.terminalserver.protocols.protocols.common;

import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.MessageBody;
import com.et.terminalserver.protocols.protocols.MessageHeader;

/**
 * @Project CNPC_VMS
 * @Title CommonMessage
 * @Description 公共消息类
 * @author guanhl
 * @date 2014年8月7日 上午9:28:34
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public abstract class CommonMessage<A extends MessageHeader,B extends MessageBody> implements Message<A,B> {

	/**
	 * @Description 构造方法
	 * @param messageID 消息id
	 * @param header 消息头
	 * @param body 消息体
	 */
	public CommonMessage( A header, B body) {
		this.messageHeader = header;
		this.messageBody = (B) body;
	}

	// 消息头
	private A messageHeader;

	// 消息体
	private B messageBody;


	/**
	 * @Description 获取messageHeader属性
	 */
	public A getMessageHeader() {
		return messageHeader;
	}

	/**
	 * @Description 设置messageHeader属性
	 */
	public void setMessageHeader(A messageHeader) {
		this.messageHeader = messageHeader;
	}

	/**
	 * @Description 获取messageBody属性
	 */
	public B getMessageBody() {
		return messageBody;
	}

	/**
	 * @Description 设置messageBody属性
	 */
	public void setMessageBody(B messageBody) {
		this.messageBody = messageBody;
	}


}
