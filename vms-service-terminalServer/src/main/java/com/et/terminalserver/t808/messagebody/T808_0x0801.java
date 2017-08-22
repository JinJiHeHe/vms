package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.Arrays;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0801
 * @Description: 多媒体数据上传类
 * @author: lijz
 * @date: 2014年5月7日 下午7:42:33
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0801 extends T808_MessageBody {

	private int packageCount;// 总包数
	private int packageNum;// 当前包
	private int multiMediaID;// 多媒体数据ID
	private int type;// 多媒体类型
	private int format;// 多媒体格式编码
	private int event;// 事件项编码
	private int channelID;// 通道ID
	private int positionInfoReport;// 位置信息汇报
	private int alarmSign;// 报警标志
	private int status;// 状态
	private double latitude;// 纬度
	private double longitude;// 经度
	private double altitude;// 高度
	private double speed;// 速度
	private int direction;// 方向
	private Date time;// 时间
	private byte[] multimediaData;// 多媒体数据

	/**
	 * @Description 获得 packageCount
	 */
	public int getPackageCount() {
		return packageCount;
	}

	/**
	 * @Description:设置 packageCount
	 */
	public void setPackageCount(int packageCount) {
		this.packageCount = packageCount;
	}

	/**
	 * @Description 获得 packageNum
	 */
	public int getPackageNum() {
		return packageNum;
	}

	/**
	 * @Description:设置 packageNum
	 */
	public void setPackageNum(int packageNum) {
		this.packageNum = packageNum;
	}

	/**
	 * @Description 获得 multiMediaID
	 */
	public int getMultiMediaID() {
		return multiMediaID;
	}

	/**
	 * @Description:设置 multiMediaID
	 */
	public void setMultiMediaID(int multiMediaID) {
		this.multiMediaID = multiMediaID;
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

	/**
	 * @Description 获得 positionInfoReport
	 */
	public int getPositionInfoReport() {
		return positionInfoReport;
	}

	/**
	 * @Description:设置 positionInfoReport
	 */
	public void setPositionInfoReport(int positionInfoReport) {
		this.positionInfoReport = positionInfoReport;
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

	/**
	 * @Description 获得 multimediaData
	 */
	public byte[] getMultimediaData() {
		return multimediaData;
	}

	/**
	 * @Description:设置 multimediaData
	 */
	public void setMultimediaData(byte[] multimediaData) {
		this.multimediaData = multimediaData;
	}

	@Override
	public String toString() {
		return "T808_0x0801 [packageCount=" + packageCount + ", packageNum="
				+ packageNum + ", multiMediaID=" + multiMediaID + ", type="
				+ type + ", format=" + format + ", event=" + event
				+ ", channelID=" + channelID + ", positionInfoReport="
				+ positionInfoReport + ", alarmSign=" + alarmSign + ", status="
				+ status + ", latitude=" + latitude + ", longitude="
				+ longitude + ", altitude=" + altitude + ", speed=" + speed
				+ ", direction=" + direction + ", time=" + time
				+ ", multimediaData=" + Arrays.toString(multimediaData) + "]";
	}


}
