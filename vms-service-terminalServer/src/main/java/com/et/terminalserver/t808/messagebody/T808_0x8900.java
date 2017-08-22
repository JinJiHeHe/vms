package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8900
 * @Description: 数据下行透传
 * @author: lijz
 * @date: 2014年8月6日 下午9:23:31
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8900 extends T808_MessageBody {

	private int transferMessageType;// 0 透传消息类型 BYTE
	private int messageLength; // 1 信息总长度 DWORD 整条透传消息的总长度
	private int packageMessageLength;// 5 包信息长度 WORD 本条消息的长度
	private int transferMessageContent;// 7 透传消息内容

	/**
	 * @Description 获得 transferMessageType
	 */
	public int getTransferMessageType() {
		return transferMessageType;
	}

	/**
	 * @Description:设置 transferMessageType
	 */
	public void setTransferMessageType(int transferMessageType) {
		this.transferMessageType = transferMessageType;
	}

	/**
	 * @Description 获得 messageLength
	 */
	public int getMessageLength() {
		return messageLength;
	}

	/**
	 * @Description:设置 messageLength
	 */
	public void setMessageLength(int messageLength) {
		this.messageLength = messageLength;
	}

	/**
	 * @Description 获得 packageMessageLength
	 */
	public int getPackageMessageLength() {
		return packageMessageLength;
	}

	/**
	 * @Description:设置 packageMessageLength
	 */
	public void setPackageMessageLength(int packageMessageLength) {
		this.packageMessageLength = packageMessageLength;
	}

	/**
	 * @Description 获得 transferMessageContent
	 */
	public int getTransferMessageContent() {
		return transferMessageContent;
	}

	/**
	 * @Description:设置 transferMessageContent
	 */
	public void setTransferMessageContent(int transferMessageContent) {
		this.transferMessageContent = transferMessageContent;
	}

	public T808_0x8900() {
	}

}
