package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8700
 * @Description: 行驶记录仪数据采集命令
 * @author: lijz
 * @date: 2014年8月6日 下午9:13:37
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8700 extends T808_MessageBody {
	private int command;// 0 命令字 BYTE 命令字列表见GB/T19056中相关要求

	/**
	 * @Description 获得 command
	 */
	public int getCommand() {
		return command;
	}

	/**
	 * @Description:设置 command
	 */
	public void setCommand(int command) {
		this.command = command;
	}

	public T808_0x8700() {
		super();
	}

}
