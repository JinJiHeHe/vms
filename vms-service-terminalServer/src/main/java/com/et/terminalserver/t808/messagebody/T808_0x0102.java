package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0102
 * @Description: 终端鉴权
 * @author: guanhl
 * @date: 2014年8月6日 下午6:50:26
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0102 extends T808_MessageBody {

	private String code;// 0 鉴权码 STRING

	/**
	 * @Description 获得 code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @Description:设置 code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "T808_0x0102 [code=" + code + "]";
	}

}
