package com.et.terminalserver.api.model;

/**
 * @Description 车辆信息
 * @author maple
 * @version V1.0
 * @Date 2016年4月7日下午8:23:29
 * @mail rw222222@126.com
 */
public class VehicleInfo {

	/** 通道名称 vms_zwnet_channel_vehicelinfo */

	/**
	 * 车辆ID
	 */
	String vechileId; // 关系参照 车辆ID
	/**
	 * 终端编码
	 */
	String terminalCode; // 关系参照 终端编码
	/**
	 * 组织编号
	 */
	String gcode; // 组织编号
	/**
	 * 上传数据类型
	 */
	int uplopadType; // 上传数据类型 0:终端接入 1:平台转发
	/**
	 * 终端ID
	 */
	String terminalId; // 终端ID
	/**
	 * 驾驶员ID
	 */
	String driverId; // 驾驶员ID
	/**
	 * 车牌号
	 */
	String plate; // 车牌号
	
	/**
	 * 车辆颜色
	 * */
	String vehicleColor;
	

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getVechileId() {
		return vechileId;
	}

	public void setVechileId(String vechileId) {
		this.vechileId = vechileId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getGcode() {
		return gcode;
	}

	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	public int getUplopadType() {
		return uplopadType;
	}

	public void setUplopadType(int uplopadType) {
		this.uplopadType = uplopadType;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

}
