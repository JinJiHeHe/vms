package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8001
 * @Description: 平台通用应答类
 * @author: guanhl
 * @date: 2014年6月13日 下午3:49:52
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8001 extends T808_MessageBody {

	public T808_0x8001() {
	}

	private int runningNum;// 0 应答流水号 WORD 对应的终端消息的流水号
	private int responseID;// 2 应答ID WORD 对应的终端消息的ID
	private int result; // 4 结果 BYTE 0：成功/确认；1：失败；2：消息有误；3：不支持

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
	 * @Description 获得 responseID
	 */
	public int getResponseID() {
		return responseID;
	}

	/**
	 * @Description:设置 responseID
	 */
	public void setResponseID(int responseID) {
		this.responseID = responseID;
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

}
