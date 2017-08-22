package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0802
 * @Description: 存储多媒体数据检索类
 * @author: lijz
 * @date: 2014年5月7日 下午7:43:37
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0802 extends T808_MessageBody {

	private int replyStream;// 0 应答流水 WORD 对应的多媒体数据检索消息的流水号
	private int multimediaDataCount;// 2 多媒体数据总项数 WORD 满足检索条们的多媒体数据总项数
	private int packageNumber; // 4 包项数 WORD 当前数据包中多媒体数据个数
	private int multimediaID; // 6 检索项 多媒体检索项数据格式见表71
	private int multimediaType; // 0 多媒体类型 BYTE 0：图像；1：音频；2：视频
	private int channelID; // 1 通道ID BYTE
	private int eventItemCode;// 2 事件项编码 BYTE
								// 0：平台下发指令；1：定时动作；2：抢劫报警触发；3：碰撞侧翻报警触发；其他保留
	private int alarmSign; // 13 报警标志 DWORD
	private int status; // 17状态 DWORD
	private double latitude;// 21纬度 DWORD
	private double longitude; // 24 经度 DWORD
	private double altitude;// 28 高程 WORD
	private double speed;// 30 速度 WORD
	private int direction;// 32 方向 WORD
	private Date time;// 34 时间 BCD[6]

	/**
	 * @Description 获得 replyStream
	 */
	public int getReplyStream() {
		return replyStream;
	}

	/**
	 * @Description:设置 replyStream
	 */
	public void setReplyStream(int replyStream) {
		this.replyStream = replyStream;
	}

	/**
	 * @Description 获得 multimediaDataCount
	 */
	public int getMultimediaDataCount() {
		return multimediaDataCount;
	}

	/**
	 * @Description:设置 multimediaDataCount
	 */
	public void setMultimediaDataCount(int multimediaDataCount) {
		this.multimediaDataCount = multimediaDataCount;
	}

	/**
	 * @Description 获得 packageNumber
	 */
	public int getPackageNumber() {
		return packageNumber;
	}

	/**
	 * @Description:设置 packageNumber
	 */
	public void setPackageNumber(int packageNumber) {
		this.packageNumber = packageNumber;
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
	 * @Description 获得 alarmSign
	 */
	public int getAlarmSign() {
		return alarmSign;
	}

	/**
	 * @Description:设置 alarmSign
	 */
	public void setAlarmSign(int alarmSign) {
		this.alarmSign = alarmSign;
	}

	/**
	 * @Description 获得 status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @Description:设置 status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @Description 获得 latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @Description:设置 latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @Description 获得 longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @Description:设置 longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @Description 获得 altitude
	 */
	public double getAltitude() {
		return altitude;
	}

	/**
	 * @Description:设置 altitude
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	/**
	 * @Description 获得 speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @Description:设置 speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @Description 获得 direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @Description:设置 direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * @Description 获得 time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @Description:设置 time
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	public T808_0x0802() {
	}

}
