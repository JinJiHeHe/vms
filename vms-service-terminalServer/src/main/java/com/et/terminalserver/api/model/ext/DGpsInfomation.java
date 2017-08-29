package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 定位信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:48:49
 * @mail terrorbladeyang@gmail.com
 */
public class DGpsInfomation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5475326023128186893L;

	private int Status;// 状态

	private int Alarm;// 报警标志

	private double Latitude = 0;// 纬度

	private double Longtitude = 0;// 经度 Longitude

	private int height = 0;

	private double Speed = 0;// 车速

	private int Direction = 0;// 方向角

	private Date GpsTime;// gps时间

	/**
	 * @Description 获得 status
	 */
	public int getStatus() {
		return Status;
	}

	/**
	 * @Description:设置 status
	 */
	public void setStatus(int status) {
		Status = status;
	}

	/**
	 * @Description 获得 alarm
	 */
	public int getAlarm() {
		return Alarm;
	}

	/**
	 * @Description:设置 alarm
	 */
	public void setAlarm(int alarm) {
		Alarm = alarm;
	}

	/**
	 * @Description 获得 latitude
	 */
	public double getLatitude() {
		return Latitude;
	}

	/**
	 * @Description:设置 latitude
	 */
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	/**
	 * @Description 获得 longtitude
	 */
	public double getLongtitude() {
		return Longtitude;
	}

	/**
	 * @Description:设置 longtitude
	 */
	public void setLongtitude(double longtitude) {
		Longtitude = longtitude;
	}

	/**
	 * @Description 获得 height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @Description:设置 height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @Description 获得 speed
	 */
	public double getSpeed() {
		return Speed;
	}

	/**
	 * @Description:设置 speed
	 */
	public void setSpeed(double speed) {
		Speed = speed;
	}

	/**
	 * @Description 获得 direction
	 */
	public int getDirection() {
		return Direction;
	}

	/**
	 * @Description:设置 direction
	 */
	public void setDirection(int direction) {
		Direction = direction;
	}

	/**
	 * @Description 获得 gpsTime
	 */
	public Date getGpsTime() {
		return GpsTime;
	}

	/**
	 * @Description:设置 gpsTime
	 */
	public void setGpsTime(Date gpsTime) {
		GpsTime = gpsTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GpsInfomation [Status=" + Status + ", Alarm=" + Alarm + ", Latitude=" + Latitude + ", Longtitude="
				+ Longtitude + ", height=" + height + ", Speed=" + Speed + ", Direction=" + Direction + ", GpsTime="
				+ GpsTime + "]";
	}

}
