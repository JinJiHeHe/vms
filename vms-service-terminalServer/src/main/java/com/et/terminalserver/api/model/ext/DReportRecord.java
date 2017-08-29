package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * 
 * 809 上报记录
 */

public class DReportRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966806858454415961L;

	private long commandId;

	private int command;

	private java.sql.Timestamp time;

	private String plateForm;

	private String reportType;

	private String dataSource;

	private String params;

	private int vehicleId;

	/**
	 * 数据来源
	 * 
	 * @return
	 */
	public String getDataSource() {
		return dataSource;
	}

	/**
	 * 数据来源
	 * 
	 * @param dataSource
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
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
	 * 车辆ID
	 * 
	 * @param vehicleId
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * 指令流水号
	 * 
	 * @return
	 */
	public long getCommandId() {
		return commandId;
	}

	/**
	 * 指令流水号
	 * 
	 * @param commandId
	 */
	public void setCommandId(long commandId) {
		this.commandId = commandId;
	}

	/**
	 * 指令代码
	 * 
	 * @return
	 */
	public int getCommand() {
		return command;
	}

	/**
	 * 指令代码
	 * 
	 * @param command
	 */
	public void setCommand(int command) {
		this.command = command;
	}

	/**
	 * 上报时间
	 * 
	 * @return
	 */
	public java.sql.Timestamp getTime() {
		return time;
	}

	/**
	 * 上报时间
	 * 
	 * @param time
	 */
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	/**
	 * 上报平台
	 * 
	 * @return
	 */
	public String getPlateForm() {
		return plateForm;
	}

	/**
	 * 上报平台
	 * 
	 * @param plateForm
	 */
	public void setPlateForm(String plateForm) {
		this.plateForm = plateForm;
	}

	/**
	 * 上报类型
	 * 
	 * @return
	 */
	public String getReportType() {
		return reportType;
	}

	/**
	 * 上报类型
	 * 
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	/**
	 * 参数
	 * 
	 * @return
	 */
	public String getParams() {
		return params;
	}

	/**
	 * 参数
	 * 
	 * @return
	 */
	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "DReportRecord [commandId=" + commandId + ", command=" + command + ", time=" + time + ", plateForm="
				+ plateForm + ", reportType=" + reportType + ", dataSource=" + dataSource + ", params=" + params
				+ ", vehicleId=" + vehicleId + "]";
	}

}
