package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0302
 * @Description: 提问应答
 * @author: lijz
 * @date: 2014年4月16日 下午3:35:34
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0302 extends T808_MessageBody {

	private int replyID;// 0 应答流水号 WORD 对应的提问下发消息的流水号
	private int resultID;// 2 答案ID BYTE 提问下发中附带的答案ID

	/**
	 * @Description 获得 replyID
	 */
	public int getReplyID() {
		return replyID;
	}

	/**
	 * @Description:设置 replyID
	 */
	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}

	/**
	 * @Description 获得 resultID
	 */
	public int getResultID() {
		return resultID;
	}

	/**
	 * @Description:设置 resultID
	 */
	public void setResultID(int resultID) {
		this.resultID = resultID;
	}

	public T808_0x0302() {
	}
}
