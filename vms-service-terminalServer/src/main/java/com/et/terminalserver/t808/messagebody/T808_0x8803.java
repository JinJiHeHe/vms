package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8803
 * @Description: 存储多媒体数据检索应答
 * @author: lijz
 * @date: 2014年8月6日 下午9:14:48
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8803 extends T808_MessageBody {

	private int multimediaType;// 0 多媒体类型 BYTE 0:图像;1:音频;2:视频
	private int channelID;// 1 通道ID BYTE
	private int eventItemCode;// 2 事件项编码 BYTE
								// 0：平台下发指令;1:定时动作;2:抢劫报警触发;3:碰撞侧翻报警触发;其他保留
	private String beginTime;// 3 起始时间 BCD[6] YY-MM-DD-hh-mm-ss
	private String endTime; // 9 结束时间 BCD[6] YY-MM-DD-hh-mm-ss
	private int deleteSign;// 15 删除标志 BYTE 0:保留;1:删除;

	/**
	 * @Description 获得 multimediaType
	 */
	public int getMultimediaType() {
		return multimediaType;
	}

	/**
	 * @Description:设置 multimediaType
	 */
	public void setMultimediaType(int multimediaType) {
		this.multimediaType = multimediaType;
	}

	/**
	 * @Description 获得 channelID
	 */
	public int getChannelID() {
		return channelID;
	}

	/**
	 * @Description:设置 channelID
	 */
	public void setChannelID(int channelID) {
		this.channelID = channelID;
	}

	/**
	 * @Description 获得 eventItemCode
	 */
	public int getEventItemCode() {
		return eventItemCode;
	}

	/**
	 * @Description:设置 eventItemCode
	 */
	public void setEventItemCode(int eventItemCode) {
		this.eventItemCode = eventItemCode;
	}

	/**
	 * @Description 获得 beginTime
	 */
	public String getBeginTime() {
		return beginTime;
	}

	/**
	 * @Description:设置 beginTime
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @Description 获得 endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @Description:设置 endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public T808_0x8803() {
	}

}
