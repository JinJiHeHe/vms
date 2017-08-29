package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0200
 * @Description: 位置信息汇报
 * @author: guanhl
 * @date: 2014年8月6日 下午6:51:20
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0200 extends T808_MessageBody {

	private int alarmSign;// 报警标志
	private int status;// 状态
	private double latitude;// 纬度
	private double longitude;// 经度
	private double altitude;// 高程
	private float speed;// 速度
	private int direction;// 方向
	private Date time;// 时间
	private double mileage;// 里程
	private double oil;// 油量
	private float speedAquare;// 行驶记录功能获取的速度，WORD，1/10km/h
	private int alarmEventID;// 需要人工确认报警事件的 ID，WORD，从 1 开始计数
	private String overSpeedAdditional;// 超速报警附加信息见表21
	private String turnoverAdditional;// 进出区域/路线报警附加信息见表22
	private String timeoverAdditional;// 路段行驶时间不足/过长报警附加信息见表23
	private boolean vehicleillegalshiftFlag = false;// 车辆非法位移

	public T808_0x0200() {
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
	public float getSpeed() {
		return speed;
	}

	/**
	 * @Description:设置 speed
	 */
	public void setSpeed(float speed) {
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
	 * @Description 获得 mileage
	 */
	public double getMileage() {
		return mileage;
	}

	/**
	 * @Description:设置 mileage
	 */
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	/**
	 * @Description 获得 oil
	 */
	public double getOil() {
		return oil;
	}

	/**
	 * @Description:设置 oil
	 */
	public void setOil(double oil) {
		this.oil = oil;
	}

	/**
	 * @Description 获得 speedAquare
	 */
	public float getSpeedAquare() {
		return speedAquare;
	}

	/**
	 * @Description:设置 speedAquare
	 */
	public void setSpeedAquare(float speedAquare) {
		this.speedAquare = speedAquare;
	}

	/**
	 * @Description 获得 alarmEventID
	 */
	public int getAlarmEventID() {
		return alarmEventID;
	}

	/**
	 * @Description:设置 alarmEventID
	 */
	public void setAlarmEventID(int alarmEventID) {
		this.alarmEventID = alarmEventID;
	}

	/**
	 * @Description 获得 overSpeedAdditional
	 */
	public String getOverSpeedAdditional() {
		return overSpeedAdditional;
	}

	/**
	 * @Description:设置 overSpeedAdditional
	 */
	public void setOverSpeedAdditional(String overSpeedAdditional) {
		this.overSpeedAdditional = overSpeedAdditional;
	}

	/**
	 * @Description 获得 turnoverAdditional
	 */
	public String getTurnoverAdditional() {
		return turnoverAdditional;
	}

	/**
	 * @Description:设置 turnoverAdditional
	 */
	public void setTurnoverAdditional(String turnoverAdditional) {
		this.turnoverAdditional = turnoverAdditional;
	}

	/**
	 * @Description 获得 timeoverAdditional
	 */
	public String getTimeoverAdditional() {
		return timeoverAdditional;
	}

	/**
	 * @Description:设置 timeoverAdditional
	 */
	public void setTimeoverAdditional(String timeoverAdditional) {
		this.timeoverAdditional = timeoverAdditional;
	}

	/**
	 * @Description 获得 vehicleillegalshiftFlag
	 */
	public boolean isVehicleillegalshiftFlag() {
		return vehicleillegalshiftFlag;
	}

	/**
	 * @Description:设置 vehicleillegalshiftFlag
	 */
	public void setVehicleillegalshiftFlag(boolean vehicleillegalshiftFlag) {
		this.vehicleillegalshiftFlag = vehicleillegalshiftFlag;
	}

	@Override
	public String toString() {
		return "T808_0x0200 [alarmSign=" + alarmSign + ", status=" + status
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", altitude=" + altitude + ", speed=" + speed
				+ ", direction=" + direction + ", time=" + time + ", mileage="
				+ mileage + ", oil=" + oil + ", speedAquare=" + speedAquare
				+ ", vehicleillegalshiftFlag=" + vehicleillegalshiftFlag + "]";
	}

}
