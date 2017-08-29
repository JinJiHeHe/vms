package com.et.terminalserver.protocols.protocols.common;

import com.et.terminalserver.protocols.protocols.MessageHeader;
import com.et.terminalserver.protocols.protocols.util.SequenceUtil;

/**
 * @Project CNPC_VMS
 * @Title CommonMessageHeader
 * @Description 公共消息头
 * @author guanhl
 * @date 2014年8月7日 上午9:29:00
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public abstract class CommonMessageHeader implements
		MessageHeader {

	protected Object messageID;
	protected String protocolName;
	protected int messageType; // 0上报,1响应
	protected String version;

	/**
	 * 获取ID
	 */
	public Object getMessageID() {
		return messageID;
	}

	/**
	 * 设置ID
	 */
	public void setMessageID(Object messageID) {
		this.messageID = messageID;
	}

	

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	@Override
	public int getMessageType() {
		return messageType;
	}

	@Override
	public String getProtocolVersion() {
		return version;
	}

	@Override
	public int getOpts() {
		return SequenceUtil.getSequenceValue(protocolName);
	}

}
