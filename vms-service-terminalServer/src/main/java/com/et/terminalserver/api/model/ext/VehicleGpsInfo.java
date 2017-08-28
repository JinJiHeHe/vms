package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description VehicleGpsInfo
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:06:54
 * @mail terrorbladeyang@gmail.com
 */

public class VehicleGpsInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3446839391311135842L;
	/**
	 * 车辆ID
	 */

	private Integer vehicleId;
	/**
	 * 车牌号
	 */

	private String idNumber;
	/**
	 * 终端ID
	 */

	private String terminalID;
	/**
	 * SIM
	 */

	private String sim;
	/**
	 * 经度
	 */

	private double longitude;
	/**
	 * 纬度
	 */

	private double latitude;
	/**
	 * 报警限速值，单位：公里/秒
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
	/***
	 * 油量
	 */

	private float oil;
	/**
	 * 里程
	 */

	private double mileage;
	/**
	 * 有效报警
	 */

	private int hasAlarm;
	/**
	 * 报警类型
	 */

	private String alarmType;
	/**
	 * 报警等级
	 */

	private int alarmLevel;
	/**
	 * 报警
	 */

	private int alarm;
	/**
	 * acc
	 */

	private int acc;
	/**
	 * 状态
	 */

	private String status;
	/**
	 * gps时间
	 */

	private Timestamp gpsTime;
	/**
	 * 驾驶员ID
	 */

	private String driverId;
	/**
	 * 驾驶员时间
	 */

	private String tDriverName;
	/**
	 * 驾照号
	 */

	private String driveCode;
	/**
	 * 驾驶员身份证号
	 */

	private Integer driverIdCode;
	/**
	 * 中文地理位置
	 */

	private String address;
	/**
	 * 中文地理编号
	 */

	private int geoCode;
	/**
	 * 单位编号
	 */

	private String orgCode;
	/**
	 * 单位名称
	 */

	private String orgName;
	/**
	 * 车辆类型ID
	 */

	private Integer typeId;
	/**
	 * gps系统
	 */

	private int gpsSystem;
	/**
	 * 持有时间
	 */

	private int holdTime;
	/**
	 * 车身颜色
	 */

	private String plateColorId;

	private Integer blackFlag;
	/**
	 * 车辆终端功能代码（16进制从左到右为小到大）
	 */

	private String functionCode;
	// 终端类型名

	private String terminalName;
	// 驾驶员手机号

	private String driverPhone;

	// 终端报警限速

	private Double terAlarmSpeed;

	// 平台报警限速

	private Double plateAlarmSpeed;

	// 终端回传时间

	private Integer returnInterval;

	// 平台预警限速

	private Double plateWarnSpeed;

	// 终端类型

	private String terminalType;
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
	 * 车辆静态数据来源
	 */

	private String dataFrom;

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}

	/**
	 * @return the terAlarmSpeed
	 */
	public Double getTerAlarmSpeed() {
		return terAlarmSpeed;
	}

	/**
	 * @param terAlarmSpeed
	 *            the terAlarmSpeed to set
	 */
	public void setTerAlarmSpeed(Double terAlarmSpeed) {
		this.terAlarmSpeed = terAlarmSpeed;
	}

	/**
	 * @return the plateAlarmSpeed
	 */
	public Double getPlateAlarmSpeed() {
		return plateAlarmSpeed;
	}

	/**
	 * @param plateAlarmSpeed
	 *            the plateAlarmSpeed to set
	 */
	public void setPlateAlarmSpeed(Double plateAlarmSpeed) {
		this.plateAlarmSpeed = plateAlarmSpeed;
	}

	public Integer getReturnInterval() {
		return returnInterval;
	}

	public void setReturnInterval(Integer returnInterval) {
		this.returnInterval = returnInterval;
	}

	/**
	 * @return the plateWarnSpeed
	 */
	public Double getPlateWarnSpeed() {
		return plateWarnSpeed;
	}

	/**
	 * @param plateWarnSpeed
	 *            the plateWarnSpeed to set
	 */
	public void setPlateWarnSpeed(Double plateWarnSpeed) {
		this.plateWarnSpeed = plateWarnSpeed;
	}

	/**
	 * @return the terminalType
	 */
	public String getTerminalType() {
		return terminalType;
	}

	/**
	 * @param terminalType
	 *            the terminalType to set
	 */
	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public VehicleGpsInfo(String orgCode, String orgName, String idNumber, Integer typeId, Integer mainDriverId,
			Integer vehicleId, String sim, String terminalID, GpsInfoFromTerminal gps, String plateColor,
			Integer blackFlag, String driver, String functionCode, String driverPhone, String terminalName,
			Double terAlarmS, Double plateAS, Double plateWS, Integer rInt, String dataFrom) {
		super();
		this.orgCode = orgCode;
		this.orgName = orgName;
		this.idNumber = idNumber;
		this.typeId = typeId;
		this.driverIdCode = mainDriverId;
		this.vehicleId = vehicleId;
		this.sim = sim;
		this.terminalID = terminalID;
		this.plateColorId = plateColor;
		this.blackFlag = blackFlag;
		this.tDriverName = driver;
		this.functionCode = functionCode;
		this.driverPhone = driverPhone;
		this.terminalName = terminalName;
		this.terAlarmSpeed = terAlarmS;
		this.plateAlarmSpeed = plateAS;
		this.plateWarnSpeed = plateWS;
		this.returnInterval = rInt;
		this.dataFrom = dataFrom;
		if (null != gps) {
			this.gpsTime = null != gps.getGpsTime() ? gps.getGpsTime() : null;
			this.longitude = gps.getLongitude();
			this.latitude = gps.getLatitude();
			this.speed = gps.getSpeed();
			this.direction = gps.getDirection();
			this.altitude = gps.getAltitude();
			this.oil = gps.getOil();
			this.mileage = gps.getMileage();
			this.status = gps.getStatus();
			this.hasAlarm = gps.getHasAlarm();
			this.sim = gps.getSim();
			this.terminalID = gps.getTerminalCode();
			this.address = gps.getAddress();
			this.alarmType = gps.getAlarmType();
			this.alarmLevel = gps.getAlarmLevel();
			this.acc = gps.getAcc();
			this.alarm = gps.getAlarm();
			// this.driverIdCode = gps.getDriverIdCode();
			this.driveCode = gps.getDriveCode();
			this.gpsSystem = gps.getGpsSystem();
			this.holdTime = gps.getHoldTime();
			this.dayMileAge = gps.getDayMileAge();
			this.dayOilConsum = gps.getDayOilConsum();
			this.allOilConsum = gps.getAllOilConsum();
		}
	}

	/**
	 * 
	 * @param orgCode
	 * @param orgName
	 * @param idNumber
	 * @param typeId
	 * @param mainDriverId
	 * @param vehicleId
	 * @param gpsTime
	 * @param longitude
	 * @param latitude
	 * @param speed
	 * @param direction
	 * @param altitude
	 * @param oil
	 * @param mileage
	 * @param status
	 * @param alarm
	 * @param sim
	 * @param terminalID
	 * @param plateColorId
	 * @param blackFlag
	 * @deprecated
	 */
	@Deprecated
	public VehicleGpsInfo(String orgCode, String orgName, String idNumber, Integer typeId, String mainDriverId,
			Integer vehicleId, Timestamp gpsTime, double longitude, double latitude, float speed, int direction,
			float altitude, float oil, double mileage, int status, int alarm, String sim, String terminalID,
			String plateColorId, Integer blackFlag) {
		super();
		this.orgCode = orgCode;
		this.orgName = orgName;
		this.idNumber = idNumber;
		this.typeId = typeId;
		this.driverId = mainDriverId;
		this.vehicleId = vehicleId;

		this.sim = sim;
		this.terminalID = terminalID;
		this.plateColorId = plateColorId;
		this.blackFlag = blackFlag;
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

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getMainDriverId() {
		return this.driverId;
	}

	public void setMainDriverId(String mainDriverId) {
		this.driverId = mainDriverId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
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

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDriveCode() {
		return driveCode;
	}

	public void setDriveCode(String driveCode) {
		this.driveCode = driveCode;
	}

	public Integer getDriverIdCode() {
		return driverIdCode;
	}

	public void setDriverIdCode(Integer driverIdCode) {
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

	public String getTDriverName() {
		return tDriverName;
	}

	public void setTDriverName(String tDriverName) {
		this.tDriverName = tDriverName;
	}

	public void setGpsSystem(int gpsSystem) {
		this.gpsSystem = gpsSystem;
	}

	public int getGpsSystem() {
		return gpsSystem;
	}

	public int getHoldTime() {
		return holdTime;
	}

	public void setHoldTime(int holdTime) {
		this.holdTime = holdTime;
	}

	/**
	 * 车牌号颜色
	 * 
	 * @return
	 */
	public String getPlateColorId() {
		return plateColorId;
	}

	/**
	 * 车牌号颜色
	 * 
	 * @param plateColorId
	 */
	public void setPlateColorId(String plateColorId) {
		this.plateColorId = plateColorId;
	}

	public Integer getBlackFlag() {
		return blackFlag;
	}

	public void setBlackFlag(Integer blackFlag) {
		this.blackFlag = blackFlag;
	}

	/**
	 * 功能编码
	 * 
	 * @return
	 */
	public String getFunctionCode() {
		return functionCode;
	}

	/**
	 * 功能编码
	 * 
	 * @return
	 */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
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

	@Override
	public String toString() {
		return "VehicleGpsInfo [vehicleId=" + vehicleId + ", idNumber=" + idNumber + ", terminalID=" + terminalID
				+ ", sim=" + sim + ", longitude=" + longitude + ", latitude=" + latitude + ", speed=" + speed
				+ ", direction=" + direction + ", altitude=" + altitude + ", oil=" + oil + ", mileage=" + mileage
				+ ", hasAlarm=" + hasAlarm + ", alarmType=" + alarmType + ", alarmLevel=" + alarmLevel + ", alarm="
				+ alarm + ", acc=" + acc + ", status=" + status + ", gpsTime=" + gpsTime + ", driverId=" + driverId
				+ ", tDriverName=" + tDriverName + ", driveCode=" + driveCode + ", driverIdCode=" + driverIdCode
				+ ", address=" + address + ", geoCode=" + geoCode + ", orgCode=" + orgCode + ", orgName=" + orgName
				+ ", typeId=" + typeId + ", gpsSystem=" + gpsSystem + ", holdTime=" + holdTime + ", plateColorId="
				+ plateColorId + ", blackFlag=" + blackFlag + ", functionCode=" + functionCode + ", terminalName="
				+ terminalName + ", driverPhone=" + driverPhone + ", terAlarmSpeed=" + terAlarmSpeed
				+ ", plateAlarmSpeed=" + plateAlarmSpeed + ", returnInterval=" + returnInterval + ", plateWarnSpeed="
				+ plateWarnSpeed + ", terminalType=" + terminalType + ", dayMileAge=" + dayMileAge + ", dayOilConsum="
				+ dayOilConsum + ", allOilConsum=" + allOilConsum + ", dataFrom=" + dataFrom + "]";
	}

}
