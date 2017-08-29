package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8100
 * @Description: 终端注册应答
 * @author: guanhl
 * @date: 2014年8月6日 下午6:56:13
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8100 extends T808_MessageBody {

	private int runningNum;// 0 应答流水号 WORD 对应的终端注册消息的流水号
	private int result;// 2 结果 BYTE 0：成功；1：车辆已被注册；2：数据库中无该车辆；3：终端已被注册；4：数据库中无该终端
	private String authCode; // 3 鉴权码 STRING 只有在成功后才有该字段

	/**
	 * @Description 获得 runningNum
	 */
	public int getRunningNum() {
		return runningNum;
	}

	/**
	 * @Description:设置 runningNum
	 */
	public void setRunningNum(int runningNum) {
		this.runningNum = runningNum;
	}

	/**
	 * @Description 获得 result
	 */
	public int getResult() {
		return result;
	}

	/**
	 * @Description:设置 result
	 */
	public void setResult(int result) {
		this.result = result;
	}

	/**
	 * @Description 获得 authCode
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @Description:设置 authCode
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public T808_0x8100() {
	}

}
