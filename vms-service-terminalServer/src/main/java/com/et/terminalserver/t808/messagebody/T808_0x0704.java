package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.Date;

public class T808_0x0704 extends T808_MessageBody {

	private int alarmSign;// 报警标志
	private int status;// 状态
	private double latitude;// 纬度
	private double longitude;// 经度
	private double altitude;// 高程
	private float speed;// 速度
	private int direction;// 方向
	private Date time;// 时间
	private boolean accFlag;// acc状态
	private boolean positionFlag;// 定位状态
	private int latdirectFlag;// 纬度状态
	private int londirectFlag;// 经度状态
	// private boolean activestatuFlag;// 运营&停运状态
	// private boolean encryptFlag;// 纬经度加密状态
	// private boolean vehicleoilFlag;// 车辆油量状态
	// private boolean vehiclecircuitFlag;// 车辆电路状态
	// private boolean doorunlockFlag;// 车门解加锁状态
	private boolean emergenalarmFlag;// 紧急报警状态
	// private boolean overspeedalarmFlag;// 超速报警状态
	// private boolean fatiguedrivingFlag;// 疲劳驾驶状态
	// private boolean earlywarningFlag;// 预警状态
	// private boolean gnssbreakFlag;// GNSS模块发生故障状态
	// private boolean gnssantennacutFlag;// GNSS天线未接或被剪断状态
	// private boolean gnssantennashortFlag;// GNSS天线短路状态
	// private boolean terminalundervoltageFlag;// 终端主电源欠压状态
	// private boolean terminalacdumpFlag;// 终端主电源掉电状态
	// private boolean terminallcdbreakFlag;// 终端LCD或显示器故障状态
	// private boolean ttsbreakFlag;// TTS模块故障状态
	// private boolean camerabreakFlag;// 摄像头故障状态
	// private boolean drivingtimeoutFlag;// 当天累计驾驶超时状态
	// private boolean overtimeparkingFlag;// 超时停车状态
	// private boolean importregionFlag;// 进出区域状态
	// private boolean importrouteFlag;// 进出路线状态
	// private boolean linktraveltimeFlag;// 路段行驶时间不足/过长状态
	// private boolean lanedeparturealarmFlag;// 路线偏离报警状态
	// private boolean vehiclevssbreakFlag;// 车辆VSS故障状态
	// private boolean vehicleoilquantityFlag;// 车辆油量异常状态
	// private boolean stolencarFlag;// 车辆被盗(通过车辆防盗器)状态
	// private boolean vehicleillegalfireFlag;// 车辆非法点火状态
	private double mileage;// 里程
	private double oil;// 油量
	private float speedAquare;// 行驶记录功能获取的速度，WORD，1/10km/h
	private int alarmEventID;// 需要人工确认报警事件的 ID，WORD，从 1 开始计数
	private String overSpeedAdditional;// 超速报警附加信息见表21
	private String turnoverAdditional;// 进出区域/路线报警附加信息见表22
	private String timeoverAdditional;// 路段行驶时间不足/过长报警附加信息见表23
	private boolean vehicleillegalshiftFlag;// 车辆非法位移
	private int dataItemNum; // 数据项个数
	private int dataType; // 数据类型
	private int dataLength; // 位置汇报数据体长度

	public int getDataLength() {
		return dataLength;
	}

	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}

	public int getAlarmSign() {
		return alarmSign;
	}

	public void setAlarmSign(int alarmSign) {
		this.alarmSign = alarmSign;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public boolean isAccFlag() {
		return accFlag;
	}

	public void setAccFlag(boolean accFlag) {
		this.accFlag = accFlag;
	}

	public boolean isPositionFlag() {
		return positionFlag;
	}

	public void setPositionFlag(boolean positionFlag) {
		this.positionFlag = positionFlag;
	}

	public int getLatdirectFlag() {
		return latdirectFlag;
	}

	public void setLatdirectFlag(int latdirectFlag) {
		this.latdirectFlag = latdirectFlag;
	}

	public int getLondirectFlag() {
		return londirectFlag;
	}

	public void setLondirectFlag(int londirectFlag) {
		this.londirectFlag = londirectFlag;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getOil() {
		return oil;
	}

	public void setOil(double oil) {
		this.oil = oil;
	}

	public float getSpeedAquare() {
		return speedAquare;
	}

	public void setSpeedAquare(float speedAquare) {
		this.speedAquare = speedAquare;
	}

	public int getAlarmEventID() {
		return alarmEventID;
	}

	public void setAlarmEventID(int alarmEventID) {
		this.alarmEventID = alarmEventID;
	}

	public String getOverSpeedAdditional() {
		return overSpeedAdditional;
	}

	public void setOverSpeedAdditional(String overSpeedAdditional) {
		this.overSpeedAdditional = overSpeedAdditional;
	}

	public String getTurnoverAdditional() {
		return turnoverAdditional;
	}

	public void setTurnoverAdditional(String turnoverAdditional) {
		this.turnoverAdditional = turnoverAdditional;
	}

	public String getTimeoverAdditional() {
		return timeoverAdditional;
	}

	public void setTimeoverAdditional(String timeoverAdditional) {
		this.timeoverAdditional = timeoverAdditional;
	}

	public boolean isVehicleillegalshiftFlag() {
		return vehicleillegalshiftFlag;
	}

	public void setVehicleillegalshiftFlag(boolean vehicleillegalshiftFlag) {
		this.vehicleillegalshiftFlag = vehicleillegalshiftFlag;
	}

	public int getDataItemNum() {
		return dataItemNum;
	}

	public void setDataItemNum(int dataItemNum) {
		this.dataItemNum = dataItemNum;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return "T808_0x0704 [alarmSign=" + alarmSign + ", status=" + status
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", altitude=" + altitude + ", speed=" + speed
				+ ", direction=" + direction + ", time=" + time + ", mileage="
				+ mileage + ", oil=" + oil + ", dataItemNum=" + dataItemNum
				+ ", dataType=" + dataType + ", dataLength=" + dataLength + "]";
	}

}
