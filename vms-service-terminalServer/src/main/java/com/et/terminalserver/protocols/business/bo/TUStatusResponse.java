package com.et.terminalserver.protocols.business.bo;

import java.util.Date;


/**
 * 状态检测反馈
 * */
public class TUStatusResponse extends BusinessObject{
	
	
	private int platformSerialNumber;// 平台流水号
	private int alarmSign;// 报警状态
	private int status;// 车辆状态
	private double latitude;// 纬度
	private double longitude;// 经度
	private double altitude;// 高度
	private double speed;// 速度
	private int direction;// 方向
	private Date time;// 时间

	/**
	 * @Description 获得 platformSerialNumber
	 */
	public int getPlatformSerialNumber() {
		return platformSerialNumber;
	}

	/**
	 * @Description:设置 platformSerialNumber
	 */
	public void setPlatformSerialNumber(int platformSerialNumber) {
		this.platformSerialNumber = platformSerialNumber;
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
	
	
	@Override
	public int getBusinessCode() {
		return TR_STATUS_RESPONSE;
	}

}
