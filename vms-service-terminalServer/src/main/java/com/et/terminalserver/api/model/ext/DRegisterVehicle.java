package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * 
 * 车辆注册
 */

public class DRegisterVehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5919594555716036750L;

	private String vehicleNo;

	private Byte vehicleColor;

	private String producerId;

	private String terminalModelType;

	private String terminalId;

	private String terminalSimCode;

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
	 * 车载终端厂商唯一编码
	 * 
	 * @return
	 */
	public String getProducerId() {
		return producerId;
	}

	public void setProducerId(String producerId) {
		this.producerId = producerId;
	}

	/**
	 * 终端型号
	 * 
	 * @return
	 */
	public String getTerminalModelType() {
		return terminalModelType;
	}

	public void setTerminalModelType(String terminalModelType) {
		this.terminalModelType = terminalModelType;
	}

	/**
	 * 终端编号
	 * 
	 * @return
	 */
	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * 车载终端SIM卡电话号码
	 * 
	 * @return
	 */
	public String getTerminalSimCode() {
		return terminalSimCode;
	}

	public void setTerminalSimCode(String terminalSimCode) {
		this.terminalSimCode = terminalSimCode;
	}

	@Override
	public String toString() {
		return "DRegisterVehicle [vehicleNo=" + vehicleNo + ", vehicleColor=" + vehicleColor + ", producerId="
				+ producerId + ", terminalModelType=" + terminalModelType + ", terminalId=" + terminalId
				+ ", terminalSimCode=" + terminalSimCode + "]";
	}
}
