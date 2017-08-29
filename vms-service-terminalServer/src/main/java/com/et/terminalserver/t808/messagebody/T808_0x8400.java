package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8400
 * @Description: 电话回拨
 * @author: lijz
 * @date: 2014年4月16日 下午5:09:09
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8400 extends T808_MessageBody {

	private int sign;// 0 标志 BYTE 0：普通通话；1：监听
	private String phoneNumber;// 1 电话号码 STRING 最长为20字节

	/**
	 * @Description 获得 sign
	 */
	public int getSign() {
		return sign;
	}

	/**
	 * @Description:设置 sign
	 */
	public void setSign(int sign) {
		this.sign = sign;
	}

	/**
	 * @Description 获得 phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @Description:设置 phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public T808_0x8400() {
	}

}
