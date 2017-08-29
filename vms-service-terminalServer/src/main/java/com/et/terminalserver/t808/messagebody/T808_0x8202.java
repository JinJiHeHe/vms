package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8202
 * @Description: 临时位置跟踪控制
 * @author: lijz
 * @date: 2014年4月16日 下午2:25:16
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8202 extends T808_MessageBody {

	private int interval;// 0 时间间隔 WORD 单位为秒(s),0则停止跟踪。停止跟踪无需带后继字段
	private int validity; // 2 位置跟踪有效期 DWORD
							// 单位为秒(S)，终端在接收到位置跟踪控制消息后，在有效期截止时问之前，依据消息中的时间间隔发送位置汇报

	/**
	 * @Description 获得 interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @Description:设置 interval
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	/**
	 * @Description 获得 validity
	 */
	public int getValidity() {
		return validity;
	}

	/**
	 * @Description:设置 validity
	 */
	public void setValidity(int validity) {
		this.validity = validity;
	}

	public T808_0x8202() {
	}

}
