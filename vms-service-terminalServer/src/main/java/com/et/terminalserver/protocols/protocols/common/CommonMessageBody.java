package com.et.terminalserver.protocols.protocols.common;

import com.et.terminalserver.protocols.protocols.MessageBody;

/**
 * @Description 公共消息体
 * @author jakiro
 * @version V1.0
 * @Date 2016年3月31日 下午10:39:23
 * @mail terrorbladeyang@gmail.com
 */
public abstract class CommonMessageBody implements MessageBody {

	protected Object messageID;

	public Object getMessageID() {
		return messageID;
	}

	public void setMessageID(Object messageID) {
		this.messageID = messageID;
	}
	
}
