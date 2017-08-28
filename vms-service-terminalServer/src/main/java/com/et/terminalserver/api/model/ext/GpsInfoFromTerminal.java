package com.et.terminalserver.api.model.ext;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 * @Project: CNPC_VMS
 * @Title: GPS终端信息
 * @Description: TODO
 * @author: libin
 * @date: 2014年8月16日 下午4:26:08
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

/**
 * @Project: CNPC_VMS
 * @Title: 实时GPS信息
 * @Description: TODO
 * @author: libin
 * @date: 2014年8月7日 上午9:03:31
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

public class GpsInfoFromTerminal implements Serializable {
	private static final long serialVersionUID = 8017400356027389649L;
	/**
	 * 车辆编号
	 */

	private int vehicleId;
	/**
	 * 车牌号
	 */

	private String plain;
	/**
	 * 终端号
	 */

	private String terminalCode;
	/**
	 * SIM卡
	 */

	private String sim;
	/**
	 * GPS时间
	 */

	private Timestamp gpsTime;
	/**
	 * 经度
	 */

	private double longitude;
	/**
	 * 纬度
	 */

	private double latitude;
	/**
	 * 速度
	 */

	private float speed;
	/**
	 * 方向
	 */

	private int direction;
	/**
	 * 海拔
	 */

	private float altitude;
	/**
	 * 油量
	 */

	private float oil;
	/**
	 * 历程
	 */

	private double mileage;
	/**
	 * 是否报警
	 */

	private int hasAlarm;
	/**
	 * 报警类型
	 */

	private String alarmType;
	/**
	 * 报警级别
	 */

	private int alarmLevel;
	/**
	 * 车辆状态
	 */

	private String status;
	/**
	 * 报警属性
	 */

	private int alarm;
	/**
	 * ACC状态
	 */

	private int acc;
	/**
	 * 驾驶员
	 */

	private String driver;
	/**
	 * 驾照号
	 */

	private String driveCode;
	/**
	 * 驾驶员身份证号
	 */

	private String driverIdCode;
	/**
	 * 中文地理位置
	 */

	private String address;
	/**
	 * 中文地理编号
	 */

	private int geoCode;
	/**
	 * gps系统（ 0：北斗，1：GPS）
	 */

	private int gpsSystem;
	/**
	 * 离线/在线时长
	 */

	private int holdTime;
	/**
	 * 原始状态
	 */

	private int oriStatus;
	/**
	 * 日里程
	 */

	private double dayMileAge;
	/**
	 * 日油耗
	 */

	private double dayOilConsum;
	/**
	 * 总油耗
	 */

	private double allOilConsum;

	/**
	 * 超速报警区域类型
	 */

	private Integer speedAlarmAreaType;

	/**
	 * 超速报警区域ID
	 */

	private Integer speedAlarmAreaId;

	/**
	 * 进出区域类型
	 */

	private Integer inOutAreaType;

	/**
	 * 进出区域ID
	 */

	private Integer inOutAreaId;

	/**
	 * 进去区域方向
	 */

	private Integer inOutDirection;

	/**
	 * 路段报警ID
	 */

	private Integer sectionAlarmId;

	/**
	 * 行驶时间
	 */

	private Integer driveTime;

	/**
	 * 结果
	 */

	private Integer result;

	/**
	 * 记录仪速度
	 */

	private Float speedRecord;

	/**
	 * 车辆状态信息
	 */

	private Integer vehicleStatus;

	/**
	 * 人工确认报警事件ID
	 */

	private Integer alarmEventId;

	public GpsInfoFromTerminal() {

	}

	public GpsInfoFromTerminal(int vehicleId, String plain, String terminalCode, String sim, Timestamp gpsTime,
			double longitude, double latitude, float speed, int direction, float altitude, float oil, double mileage,
			int hasAlarm, String alarmType, int alarmLevel, String status, int alarm, int acc, String driver,
			String driveCode, String driverIdCode, String address, int geoCode) {
		super();
		this.vehicleId = vehicleId;
		this.plain = plain;
		this.terminalCode = terminalCode;
		this.sim = sim;
		this.gpsTime = gpsTime;
		this.longitude = longitude;
		this.latitude = latitude;
		this.speed = speed;
		this.direction = direction;
		this.altitude = altitude;
		this.oil = oil;
		this.mileage = mileage;
		this.hasAlarm = hasAlarm;
		this.alarmType = alarmType;
		this.alarmLevel = alarmLevel;
		this.status = status;
		this.alarm = alarm;
		this.acc = acc;
		this.driver = driver;
		this.driveCode = driveCode;
		this.driverIdCode = driverIdCode;
		this.address = address;
		this.geoCode = geoCode;
		this.speedAlarmAreaType = 0;
		this.speedAlarmAreaId = 0;
		this.inOutAreaType = 0;
		this.inOutAreaId = 0;
		this.inOutDirection = 0;
		this.sectionAlarmId = 0;
		this.driveTime = 0;
		this.result = 0;
		this.speedRecord = 0f;
		this.vehicleStatus = 0;
		this.alarmEventId = 0;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPlain() {
		return plain;
	}

	public void setPlain(String plain) {
		this.plain = plain;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public Timestamp getGpsTime() {
		return gpsTime;
	}

	public void setGpsTime(Timestamp gpsTime) {
		this.gpsTime = gpsTime;
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

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	public float getOil() {
		return oil;
	}

	public void setOil(float oil) {
		this.oil = oil;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public int getHasAlarm() {
		return hasAlarm;
	}

	public void setHasAlarm(int hasAlarm) {
		this.hasAlarm = hasAlarm;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public int getAlarmLevel() {
		return alarmLevel;
	}

	public void setAlarmLevel(int alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAlarm() {
		return alarm;
	}

	public void setAlarm(int alarm) {
		this.alarm = alarm;
	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDriveCode() {
		return driveCode;
	}

	public void setDriveCode(String driveCode) {
		this.driveCode = driveCode;
	}

	public String getDriverIdCode() {
		return driverIdCode;
	}

	public void setDriverIdCode(String driverIdCode) {
		this.driverIdCode = driverIdCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGeoCode() {
		return geoCode;
	}

	public void setGeoCode(int geoCode) {
		this.geoCode = geoCode;
	}

	public int getGpsSystem() {
		return gpsSystem;
	}

	public void setGpsSystem(int gpsSystem) {
		this.gpsSystem = gpsSystem;
	}

	public int getHoldTime() {
		return holdTime;
	}

	public void setHoldTime(int holdTime) {
		this.holdTime = holdTime;
	}

	public int getOriStatus() {
		return oriStatus;
	}

	public void setOriStatus(int oriStatus) {
		this.oriStatus = oriStatus;
	}

	public double getDayMileAge() {
		return dayMileAge;
	}

	public void setDayMileAge(double dayMileAge) {
		this.dayMileAge = dayMileAge;
	}

	public double getDayOilConsum() {
		return dayOilConsum;
	}

	public void setDayOilConsum(double dayOilConsum) {
		this.dayOilConsum = dayOilConsum;
	}

	public double getAllOilConsum() {
		return allOilConsum;
	}

	public void setAllOilConsum(double allOilConsum) {
		this.allOilConsum = allOilConsum;
	}

	public Integer getSpeedAlarmAreaType() {
		return speedAlarmAreaType;
	}

	public void setSpeedAlarmAreaType(Integer speedAlarmAreaType) {
		this.speedAlarmAreaType = speedAlarmAreaType;
	}

	public Integer getSpeedAlarmAreaId() {
		return speedAlarmAreaId;
	}

	public void setSpeedAlarmAreaId(Integer speedAlarmAreaId) {
		this.speedAlarmAreaId = speedAlarmAreaId;
	}

	public Integer getInOutAreaType() {
		return inOutAreaType;
	}

	public void setInOutAreaType(Integer inOutAreaType) {
		this.inOutAreaType = inOutAreaType;
	}

	public Integer getInOutAreaId() {
		return inOutAreaId;
	}

	public void setInOutAreaId(Integer inOutAreaId) {
		this.inOutAreaId = inOutAreaId;
	}

	public Integer getInOutDirection() {
		return inOutDirection;
	}

	public void setInOutDirection(Integer inOutDirection) {
		this.inOutDirection = inOutDirection;
	}

	public Integer getSectionAlarmId() {
		return sectionAlarmId;
	}

	public void setSectionAlarmId(Integer sectionAlarmId) {
		this.sectionAlarmId = sectionAlarmId;
	}

	public Integer getDriveTime() {
		return driveTime;
	}

	public void setDriveTime(Integer driveTime) {
		this.driveTime = driveTime;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Float getSpeedRecord() {
		return speedRecord;
	}

	public void setSpeedRecord(Float speedRecord) {
		this.speedRecord = speedRecord;
	}

	public Integer getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(Integer vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public Integer getAlarmEventId() {
		return alarmEventId;
	}

	public void setAlarmEventId(Integer alarmEventId) {
		this.alarmEventId = alarmEventId;
	}

	@Override
	public String toString() {
		return "GpsInfoFromTerminal [vehicleId=" + vehicleId + ", plain=" + plain + ", terminalCode=" + terminalCode
				+ ", sim=" + sim + ", gpsTime=" + gpsTime + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", speed=" + speed + ", direction=" + direction + ", altitude=" + altitude + ", oil=" + oil
				+ ", mileage=" + mileage + ", hasAlarm=" + hasAlarm + ", alarmType=" + alarmType + ", alarmLevel="
				+ alarmLevel + ", status=" + status + ", alarm=" + alarm + ", acc=" + acc + ", driver=" + driver
				+ ", driveCode=" + driveCode + ", driverIdCode=" + driverIdCode + ", address=" + address + ", geoCode="
				+ geoCode + ", gpsSystem=" + gpsSystem + ", holdTime=" + holdTime + ", oriStatus=" + oriStatus
				+ ", dayMileAge=" + dayMileAge + ", dayOilConsum=" + dayOilConsum + ", allOilConsum=" + allOilConsum
				+ ", speedAlarmAreaType=" + speedAlarmAreaType + ", speedAlarmAreaId=" + speedAlarmAreaId
				+ ", inOutAreaType=" + inOutAreaType + ", inOutAreaId=" + inOutAreaId + ", inOutDirection="
				+ inOutDirection + ", sectionAlarmId=" + sectionAlarmId + ", driveTime=" + driveTime + ", result="
				+ result + ", speedRecord=" + speedRecord + ", vehicleStatus=" + vehicleStatus + ", alarmEventId="
				+ alarmEventId + "]";
	}

}
