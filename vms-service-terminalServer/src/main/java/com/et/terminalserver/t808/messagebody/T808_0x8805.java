package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8805
 * @Description: 单条存储多媒体数据检索上传命令
 * @author: lijz
 * @date: 2014年5月6日 上午9:07:44
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8805 extends T808_MessageBody {

	private int multimediaID;// 0 多媒体 ID DWORD >0
	private int deleteSign;// 4 删除标志 BYTE 0：保留；1：删除；

	/**
	 * @Description 获得 multimediaID
	 */
	public int getMultimediaID() {
		return multimediaID;
	}

	/**
	 * @Description:设置 multimediaID
	 */
	public void setMultimediaID(int multimediaID) {
		this.multimediaID = multimediaID;
	}

	/**
	 * @Description 获得 deleteSign
	 */
	public int getDeleteSign() {
		return deleteSign;
	}

	/**
	 * @Description:设置 deleteSign
	 */
	public void setDeleteSign(int deleteSign) {
		this.deleteSign = deleteSign;
	}

	public T808_0x8805() {
	}

}
