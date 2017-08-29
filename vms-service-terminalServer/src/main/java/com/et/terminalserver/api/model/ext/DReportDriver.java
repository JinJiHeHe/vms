package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * 
 * 上报驾驶员信息
 */

public class DReportDriver implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5919594555716036750L;

	private String vehicleNo;

	private Byte vehicleColor;

	private String driverName;

	private String driverId;

	private String license;

	private String orgName;

	/**
	 * 车牌号
	 * 
	 * @return
	 */
	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	/**
	 * 车牌颜色
	 * 
	 * @return
	 */
	public Byte getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(Byte vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	/**
	 * 驾驶员姓名
	 * 
	 * @return
	 */
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * 驾驶员编号
	 * 
	 * @return
	 */
	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	/**
	 * 从业资格证号（备用）
	 * 
	 * @return
	 */
	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	/**
	 * 发证机构名称（备用）
	 * 
	 * @return
	 */
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "DReportDriverInfo [vehicleNo=" + vehicleNo + ", vehicleColor=" + vehicleColor + ", driverName="
				+ driverName + ", driverId=" + driverId + ", license=" + license + ", orgName=" + orgName + "]";
	}
}
