package com.et.terminalserver.api.model.ext;
import java.sql.Timestamp;

/**
 * 报警扩展信息
 * 
 */
public class ExtendedAlarm {

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
	/**
	 * 车辆类型
	 */
	private String vehicletype;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
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

	public int getAlarm() {
		return alarm;
	}

	public void setAlarm(int alarm) {
		this.alarm = alarm;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getGpstime() {
		return gpstime;
	}

	public void setGpstime(Timestamp gpstime) {
		this.gpstime = gpstime;
	}

	public float getAltitude() {
		return altitude;
	}

	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}

	public int getIsMax() {
		return isMax;
	}

	public void setIsMax(int isMax) {
		this.isMax = isMax;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	@Override
	public String toString() {
		return "ExtendedAlarm [vehicleId=" + vehicleId + ", plate=" + plate + ", alarmId=" + alarmId + ", alarmType="
				+ alarmType + ", alarmLevel=" + alarmLevel + ", alarm=" + alarm + ", address=" + address + ", gpstime="
				+ gpstime + ", altitude=" + altitude + ", isMax=" + isMax + ", startTime=" + startTime + ", longitude="
				+ longitude + ", latitude=" + latitude + ", speed=" + speed + ", direction=" + direction
				+ ", description=" + description + ", orgCode=" + orgCode + ", orgName=" + orgName + ", vehicletype="
				+ vehicletype + "]";
	}

	public ExtendedAlarm(DMapVehicle2AlarmInfo alarm) {
		this.address = alarm.getAddress();
		this.alarm = alarm.getAlarm();
		this.alarmId = alarm.getAlarmId();
		this.alarmLevel = alarm.getAlarmLevel();
		this.alarmType = alarm.getAlarmType();
		this.altitude = alarm.getAltitude();
		this.description = alarm.getDescription();
		this.direction = alarm.getDirection();
		this.gpstime = alarm.getGpstime();
		this.isMax = alarm.getIsMax();
		this.latitude = alarm.getLatitude();
		this.longitude = alarm.getLongitude();
		this.orgCode = alarm.getOrgCode();
		this.orgName = alarm.getOrgName();
		this.plate = alarm.getPlate();
		this.speed = alarm.getSpeed();
		this.startTime = alarm.getStartTime();
		this.vehicleId = alarm.getVehicleId();

	}

}
