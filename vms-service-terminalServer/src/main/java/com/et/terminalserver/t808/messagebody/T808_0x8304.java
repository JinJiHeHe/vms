package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8304
 * @Description: 信息服务
 * @author: lijz
 * @date: 2014年4月17日 上午11:44:52
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8304 extends T808_MessageBody {

	private int infoType;// 0 信息类型 BYTE
	private String infoContent;// 5 信息内容 STRING 经GBK编码

	/**
	 * @Description 获得 infoType
	 */
	public int getInfoType() {
		return infoType;
	}

	/**
	 * @Description:设置 infoType
	 */
	public void setInfoType(int infoType) {
		this.infoType = infoType;
	}

	/**
	 * @Description 获得 infoContent
	 */
	public String getInfoContent() {
		return infoContent;
	}

	/**
	 * @Description:设置 infoContent
	 */
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public T808_0x8304() {
	}

}
