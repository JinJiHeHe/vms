package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Description DOBD
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:52:22
 * @mail terrorbladeyang@gmail.com
 */

public class DOBD implements Serializable {
	private static final long serialVersionUID = -4234634826299187649L;
	/**
	 * ����Id
	 */

	private int vehicleId;
	/**
	 * �ն�Id
	 */

	private int terminalId;
	/**
	 * ��ƿ��ѹ
	 */

	private int batteryVoltage;
	/**
	 * ������ת��
	 */

	private int engineSpeed;
	/**
	 * ��ʻʱ��
	 */

	private int drivingSpeed;
	/**
	 * ����������
	 */

	private int engineLoad;
	/**
	 * ˲ʱ�ͺ�
	 */

	private int oilConsumption;
	/**
	 * ��ȴҺ�¶�
	 */

	private int coolantTemperature;
	/**
	 * �����¶�
	 */

	private int environmentalTemperature;
	/**
	 * ������ˮ��
	 */

	private int engineTemperature;
	/**
	 * �����
	 */

	private int totalMileage;
	/**
	 * ���ͺ�
	 */

	private int totalOilConsumption;
	/**
	 * ������
	 */

	private String troubleCode;

	public DOBD() {
	}

	public DOBD(int vehicleId, int terminalId, int batteryVoltage, int engineSpeed, int drivingSpeed, int engineLoad,
			int oilConsumption, int coolantTemperature, int environmentalTemperature, int engineTemperature,
			int totalMileage, int totalOilConsumption, String troubleCode) {
		super();
		this.vehicleId = vehicleId;
		this.terminalId = terminalId;
		this.batteryVoltage = batteryVoltage;
		this.engineSpeed = engineSpeed;
		this.drivingSpeed = drivingSpeed;
		this.engineLoad = engineLoad;
		this.oilConsumption = oilConsumption;
		this.coolantTemperature = coolantTemperature;
		this.environmentalTemperature = environmentalTemperature;
		this.engineTemperature = engineTemperature;
		this.totalMileage = totalMileage;
		this.totalOilConsumption = totalOilConsumption;
		this.troubleCode = troubleCode;
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

	public int getBatteryVoltage() {
		return batteryVoltage;
	}

	public void setBatteryVoltage(int batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	public int getEngineSpeed() {
		return engineSpeed;
	}

	public void setEngineSpeed(int engineSpeed) {
		this.engineSpeed = engineSpeed;
	}

	public int getDrivingSpeed() {
		return drivingSpeed;
	}

	public void setDrivingSpeed(int drivingSpeed) {
		this.drivingSpeed = drivingSpeed;
	}

	public int getEngineLoad() {
		return engineLoad;
	}

	public void setEngineLoad(int engineLoad) {
		this.engineLoad = engineLoad;
	}

	public int getOilConsumption() {
		return oilConsumption;
	}

	public void setOilConsumption(int oilConsumption) {
		this.oilConsumption = oilConsumption;
	}

	public int getCoolantTemperature() {
		return coolantTemperature;
	}

	public void setCoolantTemperature(int coolantTemperature) {
		this.coolantTemperature = coolantTemperature;
	}

	public int getEnvironmentalTemperature() {
		return environmentalTemperature;
	}

	public void setEnvironmentalTemperature(int environmentalTemperature) {
		this.environmentalTemperature = environmentalTemperature;
	}

	public int getEngineTemperature() {
		return engineTemperature;
	}

	public void setEngineTemperature(int engineTemperature) {
		this.engineTemperature = engineTemperature;
	}

	public int getTotalMileage() {
		return totalMileage;
	}

	public void setTotalMileage(int totalMileage) {
		this.totalMileage = totalMileage;
	}

	public int getTotalOilConsumption() {
		return totalOilConsumption;
	}

	public void setTotalOilConsumption(int totalOilConsumption) {
		this.totalOilConsumption = totalOilConsumption;
	}

	public String getTroubleCode() {
		return troubleCode;
	}

	public void setTroubleCode(String troubleCode) {
		this.troubleCode = troubleCode;
	}

	@Override
	public String toString() {
		return "OBD [vehicleId=" + vehicleId + ", terminalId=" + terminalId + ", batteryVoltage=" + batteryVoltage
				+ ", engineSpeed=" + engineSpeed + ", drivingSpeed=" + drivingSpeed + ", engineLoad=" + engineLoad
				+ ", oilConsumption=" + oilConsumption + ", coolantTemperature=" + coolantTemperature
				+ ", environmentalTemperature=" + environmentalTemperature + ", engineTemperature=" + engineTemperature
				+ ", totalMileage=" + totalMileage + ", totalOilConsumption=" + totalOilConsumption + ", troubleCode="
				+ troubleCode + "]";
	}

}
