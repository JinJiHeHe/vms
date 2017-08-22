package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0303
 * @Description: 信息点播/取消
 * @author: lijz
 * @date: 2014年4月17日 上午11:29:00
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0303 extends T808_MessageBody {

	private int type; // 0 信息类型 BYTE
	private int play;// 1 点播/取消标志 BYTE 0：取消；1：点播

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
	 * @Description 获得 play
	 */
	public int getPlay() {
		return play;
	}

	/**
	 * @Description:设置 play
	 */
	public void setPlay(int play) {
		this.play = play;
	}

	public T808_0x0303() {
	}

}
