package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0900
 * @Description: 数据上行透传
 * @author: guanhl
 * @date: 2014年8月6日 下午6:53:58
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0900 extends T808_MessageBody {

	private int type; // 0 透传消息类型 BYTE
	private int length; // 1 信息总长度 DWORD 整条透传消息的总长度
	private int packLength; // 5 包信息长度 WORD 本条消息的长度
	private byte[] content; // 7 透传消息内容

	/**
	 * @Description 获得 type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @Description:设置 type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @Description 获得 length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @Description:设置 length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @Description 获得 packLength
	 */
	public int getPackLength() {
		return packLength;
	}

	/**
	 * @Description:设置 packLength
	 */
	public void setPackLength(int packLength) {
		this.packLength = packLength;
	}

	/**
	 * @Description 获得 content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * @Description:设置 content
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}

	public T808_0x0900() {
	}

}
