package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.HashSet;
import java.util.Set;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8800
 * @Description: 多媒体数据上传应答
 * @author: lijz
 * @date: 2014年4月21日 上午8:54:50
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8800 extends T808_MessageBody {

	private String replySerialNumber; // 0 应答流水号 WORD 对应的多媒体数据上传消息的流水号
	private int multimediaID;// 2 多媒体ID DWORD >0
	private int repackageCount;// 6 重传包总数 BYTE
	private Set<Integer> repackageIDItem;// 7 重传包ID列表 不超过125项，无该宇段则表明己收到个部数据包

	/**
	 * @Description 获得 replySerialNumber
	 */
	public String getReplySerialNumber() {
		return replySerialNumber;
	}

	/**
	 * @Description:设置 replySerialNumber
	 */
	public void setReplySerialNumber(String replySerialNumber) {
		this.replySerialNumber = replySerialNumber;
	}

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
	 * @Description 获得 repackageCount
	 */
	public int getRepackageCount() {
		return repackageCount;
	}

	/**
	 * @Description:设置 repackageCount
	 */
	public void setRepackageCount(int repackageCount) {
		this.repackageCount = repackageCount;
	}

	/**
	 * @Description 获得 repackageIDItem
	 */
	public Set<Integer> getRepackageIDItem() {
		return repackageIDItem;
	}

	/**
	 * @Description:设置 repackageIDItem
	 */
	public void setRepackageIDItem(Set<Integer> repackageIDItem) {
		this.repackageIDItem = repackageIDItem;
	}

	public T808_0x8800() {
		this.repackageIDItem = new HashSet<Integer>();
	}

}
