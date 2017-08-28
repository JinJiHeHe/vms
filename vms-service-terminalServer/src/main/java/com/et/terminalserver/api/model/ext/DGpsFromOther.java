package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 申请交换车辆GPS信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:48:08
 * @mail terrorbladeyang@gmail.com
 */

public class DGpsFromOther implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8823478635635744674L;

	private String plate;
	/**
	 * 蓝色1，黄色2，黑色3，白色4，其他9
	 */

	private int color;

	private int excrypt;

	private java.sql.Timestamp gpstime;

	private double longitude;

	private double latitude;

	private float speedVec1;

	private float speedVec2;

	private float miles;

	private int direction;

	private float altitude;

	private String status;

	private int alarm;

	/**
	 * 车牌号
	 * 
	 * @return
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * 车牌号
	 * 
	 * @param plate
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
	 * 车牌号颜色：蓝色1，黄色2，黑色3，白色4，其他9
	 * 
	 * @return
	 */
	public int getColor() {
		return color;
	}

	/**
	 * 车牌号颜色：蓝色1，黄色2，黑色3，白色4，其他9
	 * 
	 * @param color
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * 是否加密：0加密，1加密
	 * 
	 * @return
	 */
	public int getExcrypt() {
		return excrypt;
	}

	/**
	 * 是否加密：0加密，1加密
	 * 
	 * @param excrypt
	 */
	public void setExcrypt(int excrypt) {
		this.excrypt = excrypt;
	}

	/**
	 * GPS上传时间
	 * 
	 * @return
	 */
	public java.sql.Timestamp getGpstime() {
		return gpstime;
	}

	/**
	 * GPS上传时间
	 * 
	 * @param gpstime
	 */
	public void setGpstime(java.sql.Timestamp gpstime) {
		this.gpstime = gpstime;
	}

	/**
	 * 经度
	 * 
	 * @return
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * 经度
	 * 
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * 纬度
	 * 
	 * @return
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * 纬度
	 * 
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * 卫星检测速度
	 * 
	 * @return
	 */
	public float getSpeedVec1() {
		return speedVec1;
	}

	/**
	 * 卫星检测速度
	 * 
	 * @param speedVec1
	 */
	public void setSpeedVec1(float speedVec1) {
		this.speedVec1 = speedVec1;
	}

	/**
	 * 行驶记录仪速度
	 * 
	 * @return
	 */
	public float getSpeedVec2() {
		return speedVec2;
	}

	/**
	 * 行驶记录仪速度
	 * 
	 * @param speedVec2
	 */
	public void setSpeedVec2(float speedVec2) {
		this.speedVec2 = speedVec2;
	}

	/**
	 * 里程
	 * 
	 * @return
	 */
	public float getMiles() {
		return miles;
	}

	/**
	 * 里程
	 * 
	 * @param miles
	 */
	public void setMiles(float miles) {
		this.miles = miles;
	}

	/**
	 * 方向
	 * 
	 * @return
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * 方向
	 * 
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * 海拔
	 * 
	 * @return
	 */
	public float getAltitude() {
		return altitude;
	}

	/**
	 * 海拔
	 * 
	 * @param altitude
	 */
	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	/**
	 * 车辆状态
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 车辆状态
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 报警状态：0 无报警，1 报警
	 * 
	 * @return
	 */
	public int getAlarm() {
		return alarm;
	}

	/**
	 * 报警状态：0无报警，1报警
	 * 
	 * @param alarm
	 */
	public void setAlarm(int alarm) {
		this.alarm = alarm;
	}

	@Override
	public String toString() {
		return "DGpsFromOther [plate=" + plate + ", color=" + color + ", excrypt=" + excrypt + ", gpstime=" + gpstime
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", speedVec1=" + speedVec1 + ", speedVec2="
				+ speedVec2 + ", miles=" + miles + ", direction=" + direction + ", altitude=" + altitude + ", status="
				+ status + ", alarm=" + alarm + "]";
	}

}
