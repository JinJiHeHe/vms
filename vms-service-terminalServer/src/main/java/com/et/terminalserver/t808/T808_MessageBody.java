package com.et.terminalserver.t808;

import com.et.terminalserver.protocols.protocols.common.CommonMessageBody;

/**
 * @Project CNPC_VMS
 * @Title CommonMessageBody
 * @Description 公共消息体
 * @author guanhl
 * @date 2014年8月7日 上午9:28:43
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public class T808_MessageBody extends CommonMessageBody {

	// 消息ID
	protected Object messageID;

	/**
	 * 获取ID
	 */
	public Object getMessageID() {
		return messageID;
	}

	public void setMessageID(Object messageID) {
		this.messageID = messageID;
	}
}
