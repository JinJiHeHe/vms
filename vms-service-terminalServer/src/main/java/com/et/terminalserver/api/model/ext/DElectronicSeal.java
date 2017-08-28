package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description DElectronicSeal
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:47:21
 * @mail terrorbladeyang@gmail.com
 */
public class DElectronicSeal implements Serializable {
	private static final long serialVersionUID = 2124019070523190110L;
	
	private int vehicleId;
	
	private int terminalId;
	
	private String electronicSealState;
	
	private String lastServicePoint;
	
	private Date lastLockTime;
	
	private Date lastUnlockTime;
	
	private String deviceCode;
	
	private String deviceChipCode;
	
	private String powerState;
	
	private int batteryVoltage;
	
	private int mainboardTemperature;
	
	private String mainboardTimeValidMark;
	
	private String EEPROMReadWriteNormalMark;
	
	private Date mainboardLocalTime;
	
	private String mainboardCoverState;
	
	private int unlockRange;
	
	private Date orderInvalidTime;
	
	private String onlineOffLineState;

	public DElectronicSeal() {
	}

	public DElectronicSeal(int vehicleId, int terminalId, String electronicSealState, String lastServicePoint,
			Date lastLockTime, Date lastUnlockTime, String deviceCode, String deviceChipCode, String powerState,
			int batteryVoltage, int mainboardTemperature, String mainboardTimeValidMark,
			String eEPROMReadWriteNormalMark, Date mainboardLocalTime, String mainboardCoverState, int unlockRange,
			Date orderInvalidTime, String onlineOffLineState) {
		super();
		this.vehicleId = vehicleId;
		this.terminalId = terminalId;
		this.electronicSealState = electronicSealState;
		this.lastServicePoint = lastServicePoint;
		this.lastLockTime = lastLockTime;
		this.lastUnlockTime = lastUnlockTime;
		this.deviceCode = deviceCode;
		this.deviceChipCode = deviceChipCode;
		this.powerState = powerState;
		this.batteryVoltage = batteryVoltage;
		this.mainboardTemperature = mainboardTemperature;
		this.mainboardTimeValidMark = mainboardTimeValidMark;
		EEPROMReadWriteNormalMark = eEPROMReadWriteNormalMark;
		this.mainboardLocalTime = mainboardLocalTime;
		this.mainboardCoverState = mainboardCoverState;
		this.unlockRange = unlockRange;
		this.orderInvalidTime = orderInvalidTime;
		this.onlineOffLineState = onlineOffLineState;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}

	public String getElectronicSealState() {
		return electronicSealState;
	}

	public void setElectronicSealState(String electronicSealState) {
		this.electronicSealState = electronicSealState;
	}

	public String getLastServicePoint() {
		return lastServicePoint;
	}

	public void setLastServicePoint(String lastServicePoint) {
		this.lastServicePoint = lastServicePoint;
	}

	public Date getLastLockTime() {
		return lastLockTime;
	}

	public void setLastLockTime(Date lastLockTime) {
		this.lastLockTime = lastLockTime;
	}

	public Date getLastUnlockTime() {
		return lastUnlockTime;
	}

	public void setLastUnlockTime(Date lastUnlockTime) {
		this.lastUnlockTime = lastUnlockTime;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getDeviceChipCode() {
		return deviceChipCode;
	}

	public void setDeviceChipCode(String deviceChipCode) {
		this.deviceChipCode = deviceChipCode;
	}

	public String getPowerState() {
		return powerState;
	}

	public void setPowerState(String powerState) {
		this.powerState = powerState;
	}

	public int getBatteryVoltage() {
		return batteryVoltage;
	}

	public void setBatteryVoltage(int batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	public int getMainboardTemperature() {
		return mainboardTemperature;
	}

	public void setMainboardTemperature(int mainboardTemperature) {
		this.mainboardTemperature = mainboardTemperature;
	}

	public String getMainboardTimeValidMark() {
		return mainboardTimeValidMark;
	}

	public void setMainboardTimeValidMark(String mainboardTimeValidMark) {
		this.mainboardTimeValidMark = mainboardTimeValidMark;
	}

	public String getEEPROMReadWriteNormalMark() {
		return EEPROMReadWriteNormalMark;
	}

	public void setEEPROMReadWriteNormalMark(String eEPROMReadWriteNormalMark) {
		EEPROMReadWriteNormalMark = eEPROMReadWriteNormalMark;
	}

	public Date getMainboardLocalTime() {
		return mainboardLocalTime;
	}

	public void setMainboardLocalTime(Date mainboardLocalTime) {
		this.mainboardLocalTime = mainboardLocalTime;
	}

	public String getMainboardCoverState() {
		return mainboardCoverState;
	}

	public void setMainboardCoverState(String mainboardCoverState) {
		this.mainboardCoverState = mainboardCoverState;
	}

	public int getUnlockRange() {
		return unlockRange;
	}

	public void setUnlockRange(int unlockRange) {
		this.unlockRange = unlockRange;
	}

	public Date getOrderInvalidTime() {
		return orderInvalidTime;
	}

	public void setOrderInvalidTime(Date orderInvalidTime) {
		this.orderInvalidTime = orderInvalidTime;
	}

	public String getOnlineOffLineState() {
		return onlineOffLineState;
	}

	public void setOnlineOffLineState(String onlineOffLineState) {
		this.onlineOffLineState = onlineOffLineState;
	}

	@Override
	public String toString() {
		return "ElectronicSeal [vehicleId=" + vehicleId + ", terminalId=" + terminalId + ", electronicSealState="
				+ electronicSealState + ", lastServicePoint=" + lastServicePoint + ", lastLockTime=" + lastLockTime
				+ ", lastUnlockTime=" + lastUnlockTime + ", deviceCode=" + deviceCode + ", deviceChipCode="
				+ deviceChipCode + ", powerState=" + powerState + ", batteryVoltage=" + batteryVoltage
				+ ", mainboardTemperature=" + mainboardTemperature + ", mainboardTimeValidMark="
				+ mainboardTimeValidMark + ", EEPROMReadWriteNormalMark=" + EEPROMReadWriteNormalMark
				+ ", mainboardLocalTime=" + mainboardLocalTime + ", mainboardCoverState=" + mainboardCoverState
				+ ", unlockRange=" + unlockRange + ", orderInvalidTime=" + orderInvalidTime + ", onlineOffLineState="
				+ onlineOffLineState + "]";
	}

}
