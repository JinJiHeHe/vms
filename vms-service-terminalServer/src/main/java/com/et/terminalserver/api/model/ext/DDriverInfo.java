package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 驾驶员身份识别信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:45:57
 * @mail terrorbladeyang@gmail.com
 */
public class DDriverInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5919594555716036750L;

	private String driverName;
	private String driverIdCode;
	private String qualificationCode;
	private String certificationOrg;
	private int vehicleId;
	private java.sql.Timestamp time;
	private int result;

	/**
	 * 驾驶员姓名
	 * 
	 * @return
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * 驾驶员姓名
	 * 
	 * @param driverName
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * 驾驶员身份识别
	 * 
	 * @return
	 */
	public String getDriverIdCode() {
		return driverIdCode;
	}

	/**
	 * 驾驶员身份识别
	 * 
	 * @param driverIdCode
	 */
	public void setDriverIdCode(String driverIdCode) {
		this.driverIdCode = driverIdCode;
	}

	/**
	 * 从业资格证编号
	 * 
	 * @return
	 */
	public String getQualificationCode() {
		return qualificationCode;
	}

	/**
	 * 从业资格证编号
	 * 
	 * @param qualificationCode
	 */
	public void setQualificationCode(String qualificationCode) {
		this.qualificationCode = qualificationCode;
	}

	/**
	 * 颁发机构
	 * 
	 * @return
	 */
	public String getCertificationOrg() {
		return certificationOrg;
	}

	/**
	 * 颁发机构
	 * 
	 * @param certificationOrg
	 */
	public void setCertificationOrg(String certificationOrg) {
		this.certificationOrg = certificationOrg;
	}

	/**
	 * 车辆Id
	 * 
	 * @return
	 */
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * 车辆Id
	 * 
	 * @param vehicleId
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * 识别时间
	 * 
	 * @return
	 */
	public java.sql.Timestamp getTime() {
		return time;
	}

	/**
	 * 识别时间
	 * 
	 * @param time
	 */
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	/**
	 * 识别结果
	 * 
	 * @return
	 */
	public int getResult() {
		return result;
	}

	/**
	 * 识别结果
	 * 
	 * @param result
	 */
	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "DDriverInfo [driverName=" + driverName + ", driverIdCode=" + driverIdCode + ", qualificationCode="
				+ qualificationCode + ", certificationOrg=" + certificationOrg + ", vehicleId=" + vehicleId + ", time="
				+ time + ", result=" + result + "]";
	}

}
