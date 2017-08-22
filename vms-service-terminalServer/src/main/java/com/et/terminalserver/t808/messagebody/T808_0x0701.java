package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0701
 * @Description: 电子运单上报
 * @author: lijz
 * @date: 2014年8月6日 下午6:52:32
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0701 extends T808_MessageBody {

	private int orderLength;// 0 电子运单长度 DWORD
	private String content;// 4 电子运单内容 电子运单数据包

	/**
	 * @Description 获得 orderLength
	 */
	public int getOrderLength() {
		return orderLength;
	}

	/**
	 * @Description:设置 orderLength
	 */
	public void setOrderLength(int orderLength) {
		this.orderLength = orderLength;
	}

	/**
	 * @Description 获得 content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @Description:设置 content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public T808_0x0701() {
	}

}
