package com.et.terminalserver.api.model.ext;
import java.io.Serializable;


/**
 * @Description 罐体数据内容
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:59:07
 * @mail terrorbladeyang@gmail.com
 */

public class DTankData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 52674970163963083L;
	/**
	 * 舱体ID byte
	 */

	private int cabinID;
	/**
	 * 运输物型号 dword
	 */

	private int transportationType;
	/**
	 * 罐体压力 dword
	 */

	private int tankPressure;
	/**
	 * 罐体温度 dword
	 */

	private int tankTemperature;
	/**
	 * 罐体液位 dword
	 */

	private int tankLiquid;

	/**
	 * 灌入容积 dword
	 */

	private int pumpingVolume;
	/**
	 * 灌出容积 dword
	 */

	private int outerVolume;
	/**
	 * 流量 dword
	 */

	private int flowRate;
	/**
	 * 电磁阀 byte
	 */

	private int solenoidValve;
	/**
	 * 灌入电控锁 byte
	 */

	private int intoElectronicLock;

	/**
	 * 灌出电控锁 byte
	 */

	private int outElectronicLock;

	/**
	 * @return the cabinID
	 */
	public int getCabinID() {
		return cabinID;
	}

	/**
	 * @param cabinID
	 *            the cabinID to set
	 */
	public void setCabinID(int cabinID) {
		this.cabinID = cabinID;
	}

	/**
	 * @return the transportationType
	 */
	public int getTransportationType() {
		return transportationType;
	}

	/**
	 * @param transportationType
	 *            the transportationType to set
	 */
	public void setTransportationType(int transportationType) {
		this.transportationType = transportationType;
	}

	/**
	 * @return the tankPressure
	 */
	public int getTankPressure() {
		return tankPressure;
	}

	/**
	 * @param tankPressure
	 *            the tankPressure to set
	 */
	public void setTankPressure(int tankPressure) {
		this.tankPressure = tankPressure;
	}

	/**
	 * @return the tankTemperature
	 */
	public int getTankTemperature() {
		return tankTemperature;
	}

	/**
	 * @param tankTemperature
	 *            the tankTemperature to set
	 */
	public void setTankTemperature(int tankTemperature) {
		this.tankTemperature = tankTemperature;
	}

	/**
	 * @return the tankLiquid
	 */
	public int getTankLiquid() {
		return tankLiquid;
	}

	/**
	 * @param tankLiquid
	 *            the tankLiquid to set
	 */
	public void setTankLiquid(int tankLiquid) {
		this.tankLiquid = tankLiquid;
	}

	/**
	 * @return the pumpingVolume
	 */
	public int getPumpingVolume() {
		return pumpingVolume;
	}

	/**
	 * @param pumpingVolume
	 *            the pumpingVolume to set
	 */
	public void setPumpingVolume(int pumpingVolume) {
		this.pumpingVolume = pumpingVolume;
	}

	/**
	 * @return the outerVolume
	 */
	public int getOuterVolume() {
		return outerVolume;
	}

	/**
	 * @param outerVolume
	 *            the outerVolume to set
	 */
	public void setOuterVolume(int outerVolume) {
		this.outerVolume = outerVolume;
	}

	/**
	 * @return the flowRate
	 */
	public int getFlowRate() {
		return flowRate;
	}

	/**
	 * @param flowRate
	 *            the flowRate to set
	 */
	public void setFlowRate(int flowRate) {
		this.flowRate = flowRate;
	}

	/**
	 * @return the solenoidValve
	 */
	public int getSolenoidValve() {
		return solenoidValve;
	}

	/**
	 * @param solenoidValve
	 *            the solenoidValve to set
	 */
	public void setSolenoidValve(int solenoidValve) {
		this.solenoidValve = solenoidValve;
	}

	/**
	 * @return the intoElectronicLock
	 */
	public int getIntoElectronicLock() {
		return intoElectronicLock;
	}

	/**
	 * @param intoElectronicLock
	 *            the intoElectronicLock to set
	 */
	public void setIntoElectronicLock(int intoElectronicLock) {
		this.intoElectronicLock = intoElectronicLock;
	}

	/**
	 * @return the outElectronicLock
	 */
	public int getOutElectronicLock() {
		return outElectronicLock;
	}

	/**
	 * @param outElectronicLock
	 *            the outElectronicLock to set
	 */
	public void setOutElectronicLock(int outElectronicLock) {
		this.outElectronicLock = outElectronicLock;
	}

	@Override
	public String toString() {
		return "DTankData [cabinID=" + cabinID + ", transportationType=" + transportationType + ", tankPressure="
				+ tankPressure + ", tankTemperature=" + tankTemperature + ", tankLiquid=" + tankLiquid
				+ ", pumpingVolume=" + pumpingVolume + ", outerVolume=" + outerVolume + ", flowRate=" + flowRate
				+ ", solenoidValve=" + solenoidValve + ", intoElectronicLock=" + intoElectronicLock
				+ ", outElectronicLock=" + outElectronicLock + "]";
	}

}
