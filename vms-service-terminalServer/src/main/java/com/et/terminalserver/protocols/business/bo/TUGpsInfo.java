package com.et.terminalserver.protocols.business.bo;

import java.util.Date;

public class TUGpsInfo extends BusinessObject {
	/**
	 * 车辆ID
	 */
	private String vehicleID;
	/**
	 * 组织编号
	 */
	private String gCode;
	/**
	 * 采集时间
	 */
	private Date gTime;
	/**
	 * 经度
	 */
	private double lon;
	/**
	 * 纬度
	 */
	private double lat;
	/**
	 * 海拔
	 */
	private double alt;
	/**
	 * 方向
	 */
	private int direction;
	/**
	 * 速度
	 */
	private float speed;
	/**
	 * 通讯卡号
	 */
	private String sim;
	/**
	 * 终端号
	 */
	private String terminalID;
	/**
	 * 里程
	 */
	private double mileage;
	/**
	 * 状态
	 */
	private String status;
	
	
	private int state;
	/**
	 * 位置名称
	 */
	private String locatoinName;
	/**
	 * 加密经度
	 */
	private double elon;
	/**
	 * 加密纬度
	 */
	private double elat;
	/**
	 * 油量
	 */
	private double fuel;
	/**
	 * 行驶记录仪速度
	 */
	private float driveSpeed;
	/**
	 * 终端类型
	 */
	private String terminalType;
	/**
	 * 报警标识
	 */
	private int alarmTag;
	/**
	 * 主驾驶员编号
	 */
	private int driverId;
	/**
	 * 车牌号
	 */
	private String vehicleNumber;
	/**
	 * 仰角
	 */
	private int elevation;
	/**
	 * 上传数据类型
	 */
	private int uploadType;
	/**
	 * 服务器时间
	 */
	private Date serverTime;
	/**
	 * 上/下线标识
	 */
	private int onOffLineFlag;// 0.正常 1.上线 -1.离线

	
	private int holdTime;

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getGCode() {
		return gCode;
	}

	public void setGCode(String gCode) {
		this.gCode = gCode;
	}

	public Date getGTime() {
		return gTime;
	}

	public void setGTime(Date gTime) {
		this.gTime = gTime;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getLocatoinName() {
		return locatoinName;
	}

	public void setLocatoinName(String locatoinName) {
		this.locatoinName = locatoinName;
	}

	public double getElon() {
		return elon;
	}

	public void setElon(double elon) {
		this.elon = elon;
	}

	public double getElat() {
		return elat;
	}

	public void setElat(double elat) {
		this.elat = elat;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public float getDriveSpeed() {
		return driveSpeed;
	}

	public void setDriveSpeed(float driveSpeed) {
		this.driveSpeed = driveSpeed;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public int getAlarmTag() {
		return alarmTag;
	}

	public void setAlarmTag(int alarmTag) {
		this.alarmTag = alarmTag;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public int getElevation() {
		return elevation;
	}

	public void setElevation(int elevation) {
		this.elevation = elevation;
	}

	public int getUploadType() {
		return uploadType;
	}

	public void setUploadType(int uploadType) {
		this.uploadType = uploadType;
	}

	public Date getServerTime() {
		return serverTime;
	}

	public void setServerTime(Date serverTime) {
		this.serverTime = serverTime;
	}

	public int getOnOffLineFlag() {
		return onOffLineFlag;
	}

	public void setOnOffLineFlag(int onOffLineFlag) {
		this.onOffLineFlag = onOffLineFlag;
	}

	public int getHoldTime() {
		return holdTime;
	}

	public void setHoldTime(int holdTime) {
		this.holdTime = holdTime;
	}

	@Override
	public int getBusinessCode() {
		return TU_RECEIVE_GPS;
	}
}
