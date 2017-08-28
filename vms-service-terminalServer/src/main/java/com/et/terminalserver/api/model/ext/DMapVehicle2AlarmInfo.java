package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description 车辆报警信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:50:39
 * @mail terrorbladeyang@gmail.com
 */
public class DMapVehicle2AlarmInfo implements Serializable {
	private static final long serialVersionUID = -2224983156826621882L;
	/**
	 * 车辆ID
	 */

	private int vehicleId;
	/**
	 * 车牌号
	 */

	private String plate;
	/**
	 * 报警编号
	 */

	private String alarmId;
	/**
	 * 报警类型
	 */

	private String alarmType;
	/**
	 * 报警级别
	 */

	private int alarmLevel;
	/**
	 * 报警属性
	 */

	private int alarm;
	/**
	 * 中文地理位置
	 */

	private String address;
	/**
	 * 报警时间
	 */

	private Timestamp gpstime;

	/**
	 * 高度
	 */

	private float altitude;
	/**
	 * 报警是否达到最高级别，0不是，1是。
	 */

	private int isMax;
	/**
	 * 开始时间
	 */

	private Timestamp startTime;
	/**
	 * 经度
	 */

	private double longitude;
	/**
	 * 纬度
	 */

	private double latitude;
	/**
	 * 超速
	 */

	private float speed;
	/**
	 * 方向
	 */

	private int direction;
	/**
	 * 描述
	 */

	private String description;
	/**
	 * 组织机构编号
	 */

	private String orgCode;
	/**
	 * 组织机构名称
	 */

	private String orgName;

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	/**
	 * 车辆ID
	 */
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * 车辆ID
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * 车牌号
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * 车牌号
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
	 * 报警编号
	 */
	public String getAlarmId() {
		return alarmId;
	}

	/**
	 * 报警编号
	 */
	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	/**
	 * 报警类型
	 */
	public String getAlarmType() {
		return alarmType;
	}

	/**
	 * 报警类型
	 */
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	/**
	 * 报警级别
	 */
	public int getAlarmLevel() {
		return alarmLevel;
	}

	/**
	 * 报警级别
	 */
	public void setAlarmLevel(int alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	/**
	 * 报警属性
	 */
	public int getAlarm() {
		return alarm;
	}

	/**
	 * 报警属性
	 */
	public void setAlarm(int alarm) {
		this.alarm = alarm;
	}

	/**
	 * 中文地理位置
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 中文地理位置
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 报警时间
	 */
	public Timestamp getGpstime() {
		return gpstime;
	}

	/**
	 * 报警时间
	 */
	public void setGpstime(Timestamp gpstime) {
		this.gpstime = gpstime;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 报警是否达到最高级别，0不是，1是。
	 */
	public int getIsMax() {
		return isMax;
	}

	/**
	 * 报警是否达到最高级别，0不是，1是。
	 */
	public void setIsMax(int isMax) {
		this.isMax = isMax;
	}

	/**
	 * 起始报警时间
	 * 
	 * @return
	 */
	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * 起始报警时间
	 */
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "DMapVehicle2AlarmInfo [vehicleId=" + vehicleId + ", plate=" + plate + ", alarmId=" + alarmId
				+ ", alarmType=" + alarmType + ", alarmLevel=" + alarmLevel + ", alarm=" + alarm + ", address="
				+ address + ", gpstime=" + gpstime + ", altitude=" + altitude + ", isMax=" + isMax + ", startTime="
				+ startTime + ", longitude=" + longitude + ", latitude=" + latitude + ", speed=" + speed
				+ ", direction=" + direction + ", description=" + description + ", orgCode=" + orgCode + ", orgName="
				+ orgName + "]";
	}

}
