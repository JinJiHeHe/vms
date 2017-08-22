package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0500
 * @Description: 车辆控制应答类
 * @author: lijz
 * @date: 2014年5月14日 下午4:13:51
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0500 extends T808_MessageBody {

	private int replaySerialNumber; // 0 应答流水号 WORD 对应的车辆控制消息的流水号
	private T808_0x0200 t808_0x0200;// 位置信息汇报消息体

	/**
	 * @Description 获得 replaySerialNumber
	 */
	public int getReplaySerialNumber() {
		return replaySerialNumber;
	}

	/**
	 * @Description:设置 replaySerialNumber
	 */
	public void setReplaySerialNumber(int replaySerialNumber) {
		this.replaySerialNumber = replaySerialNumber;
	}

	/**
	 * @Description 获得 t808_0x0200
	 */
	public T808_0x0200 getT808_0x0200() {
		return t808_0x0200;
	}

	/**
	 * @Description:设置 t808_0x0200
	 */
	public void setT808_0x0200(T808_0x0200 t808_0x0200) {
		this.t808_0x0200 = t808_0x0200;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "T808_0x0500 [replaySerialNumber=" + replaySerialNumber + ", t808_0x0200=" + t808_0x0200 + "]";
	}

	public T808_0x0500() {
	}

}
