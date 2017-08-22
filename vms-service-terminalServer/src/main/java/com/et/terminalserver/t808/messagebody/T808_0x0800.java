package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0800
 * @Description: 多媒体事件信息上传
 * @author: lijz
 * @date: 2014年8月6日 下午6:53:06
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0800 extends T808_MessageBody {

	private int mutiMideoID;// 0 多媒体数据ID DWORD >0
	private int type;// 4 多媒体类型 BYTE 0：图像；1：音频；2：视频
	private int format;// 5 多媒体格式编码 BYTE 0：JPEG；1：TIF；2：MP3；3：WAV；4：WMV；其他保留
	private int event;// 6 事件项编码 BYTE 0：平台下发指令；1：定时动作；2：抢劫报警触发；3：碰撞侧翻报警触发；其他保留
	private int channelID;// 7 通道ID BYTE

	/**
	 * @Description 获得 mutiMideoID
	 */
	public int getMutiMideoID() {
		return mutiMideoID;
	}

	/**
	 * @Description:设置 mutiMideoID
	 */
	public void setMutiMideoID(int mutiMideoID) {
		this.mutiMideoID = mutiMideoID;
	}

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
	 * @Description 获得 format
	 */
	public int getFormat() {
		return format;
	}

	/**
	 * @Description:设置 format
	 */
	public void setFormat(int format) {
		this.format = format;
	}

	/**
	 * @Description 获得 event
	 */
	public int getEvent() {
		return event;
	}

	/**
	 * @Description:设置 event
	 */
	public void setEvent(int event) {
		this.event = event;
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

	@Override
	public String toString() {
		return "T808_0x0800 [mutiMideoID=" + mutiMideoID + ", type=" + type
				+ ", format=" + format + ", event=" + event + ", channelID="
				+ channelID + "]";
	}

}
