package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8201
 * @Description: 位置信息查询类
 * @author: lijz
 * @date: 2014年5月29日 上午6:19:10
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8201 extends T808_MessageBody {
	private int params;// 新增属性，用于判断是请求位置还是

	/**
	 * @Description 获得 params
	 */
	public int getParams() {
		return params;
	}

	/**
	 * @Description:设置 params
	 */
	public void setParams(int params) {
		this.params = params;
	}

	public T808_0x8201() {
	}
}
