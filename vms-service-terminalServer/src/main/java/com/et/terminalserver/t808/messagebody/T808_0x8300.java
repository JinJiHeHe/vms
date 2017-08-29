package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8300
 * @Description: 文本信息下发
 * @author: lijz
 * @date: 2014年4月17日 上午9:40:39
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8300 extends T808_MessageBody {

	private int mark;// 0 标志 BYTE 文本信息标志位含义见表27
	private String textMessage;// 1 文本信息 STRING 最长为102字节，经GBK编码

	/**
	 * @Description 获得 mark
	 */
	public int getMark() {
		return mark;
	}

	/**
	 * @Description:设置 mark
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}

	/**
	 * @Description 获得 textMessage
	 */
	public String getTextMessage() {
		return textMessage;
	}

	/**
	 * @Description:设置 textMessage
	 */
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public T808_0x8300() {
		super();
		messageID = 0x8300;
	}

}
