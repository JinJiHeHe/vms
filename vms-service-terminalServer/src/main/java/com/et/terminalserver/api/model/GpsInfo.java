package com.et.terminalserver.api.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description gps信息对象，推送到前台redis
 * @author maple
 * @version V1.0
 * @Date 2016年4月7日下午5:21:35
 * @mail rw222222@126.com
 */
public class GpsInfo implements Serializable {

	/** 通道名称: vms_zwnet_channel_gpsinfo */

	private static final long serialVersionUID = -7828629241650146592L;
	/** 车辆ID */
	private String vehicleID;
	/** 组织编号 */
	private String gCode;
	/** 采集时间 */
	private Date gTime;
	/** 经度 */
	private double lon;
	/** 纬度 */
	private double lat;
	/** 海拔 */
	private double alt;
	/** 方向 */
	private int direction;
	/** 速度 */
	private float speed;
	/** 通讯卡号 */
	private String sim;
	/** 终端号 */
	private String terminalID;
	/** 里程 */
	private double mileage;
	/** 状态 */
	private String status;

	private int state;
	/** 中文位置名称 */
	private String locatoinName;
	/** 加密经度 */
	private double elon;
	/** 加密纬度 */
	private double elat;
	/** 油量 */
	private double fuel;
	/** 行驶记录仪速度 */
	private float driveSpeed;
	/** 终端类型 */
	private String terminalType;
	/** 报警标识 */
	private int alarmTag;
	/** 主驾驶员编号 */
	private int driverId;
	/** 主驾驶员姓名 */
	private int driverName;
	/** 车牌号 */
	private String vehicleNumber;
	/** 仰角 */
	private int elevation;
	/** 上传数据类型 */
	private int uploadType; // 0.终端上传 1.平台转发上传
	/** 上/下线标识 */
	private int onOffLineFlag; // 0.正常 1.上线 -1.离线
	/** 是否飘点标识 */
	private int areawarnFlag; // 0.正常 1.飘点 历史轨迹不显示

	private int holdTime; // 在线时长

	/**
	 * @Description:HBase入库字符串 车辆ID|时间|加密后经度|加密后纬度|海拔|速度|里程|仰角|方向|上传数据类型|车辆报警类型
	 *                         |车辆状态类型|原始经度|原始纬度|油量|飘点标识|行驶记录仪速度|组织编号|终端类型|中文地址
	 *                         共20个字段
	 */
	public String toHBaseString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		DecimalFormat decFormat = new DecimalFormat("#0.000000");
		StringBuilder builder = new StringBuilder();

		return builder.append(this.getVehicleID()).append("|") // 车辆ID
				.append(dateFormat.format(this.getgTime())).append("|")// 时间
				.append(decFormat.format(this.getElon())).append("|")// 加密后经度
				.append(decFormat.format(this.getElat())).append("|")// 加密后纬度
				.append(this.getAlt()).append("|")// 海拔
				.append(this.getSpeed()).append("|")// 速度
				.append(this.getMileage()).append("|")// 里程
				.append(this.getElevation()).append("|")// 仰角
				.append(this.getDirection()).append("|")// 方向
				.append(this.getUploadType()).append("|")// 上传数据类型
				.append(this.getAlarmTag()).append("|")// 车辆报警类型
				.append(this.getStatus()).append("|")// 车辆状态类型
				.append(decFormat.format(this.getLon())).append("|")// 原始经度
				.append(decFormat.format(this.getLat())).append("|")// 原始纬度
				.append(this.getFuel()).append("|")// 油量
				.append(this.getAreawarnFlag()).append("|") // 是否飘点 0.正常 1.飘点
															// 历史轨迹不显示
				.append(this.getDriveSpeed()).append("|")// 行驶记录仪速度
				.append(this.getgCode()).append("|") // 组织编号
				.append(this.getTerminalType()).append("|") // 终端类型
				.append(this.getLocatoinName()).append("|").toString(); // 中文地址
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getgCode() {
		return gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public Date getgTime() {
		return gTime;
	}

	public void setgTime(Date gTime) {
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

	public int getDriverName() {
		return driverName;
	}

	public void setDriverName(int driverName) {
		this.driverName = driverName;
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

	public int getOnOfflineflag() {
		return onOffLineFlag;
	}

	public void setOnOfflineflag(int onofflineflag) {
		this.onOffLineFlag = onofflineflag;
	}

	public int getOnOffLineFlag() {
		return onOffLineFlag;
	}

	public void setOnOffLineFlag(int onOffLineFlag) {
		this.onOffLineFlag = onOffLineFlag;
	}

	public int getAreawarnFlag() {
		return areawarnFlag;
	}

	public void setAreawarnFlag(int areawarnFlag) {
		this.areawarnFlag = areawarnFlag;
	}

	public int getHoldTime() {
		return holdTime;
	}

	public void setHoldTime(int holdTime) {
		this.holdTime = holdTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
