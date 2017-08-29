package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0001
 * @Description: 终端通用应答
 * @author: guanhl
 * @date: 2014年3月31日 上午9:00:37
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0001 extends T808_MessageBody {

	/**
	 * 对应的平台消息的流水号
	 */
	private short responseSeq;
	/**
	 * 对应的平台消息的ID
	 */
	private int responseID;
	/**
	 * 0：成功/确认；1：失败；2：消息有误；3：不支持
	 */
	private byte result;

	/**
	 * @Description 获得 responseSeq
	 */
	public short getResponseSeq() {
		return responseSeq;
	}

	/**
	 * @Description:设置 responseSeq
	 */
	public void setResponseSeq(short responseSeq) {
		this.responseSeq = responseSeq;
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
	public byte getResult() {
		return result;
	}

	/**
	 * @Description:设置 result
	 */
	public void setResult(byte result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "T808_0x0001 [responseSeq=" + responseSeq + ", responseID="
				+ responseID + ", result=" + result + "]";
	}

}
