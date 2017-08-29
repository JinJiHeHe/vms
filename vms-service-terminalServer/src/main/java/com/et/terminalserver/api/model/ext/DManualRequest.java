package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 需要人工反馈的指令
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:49:24
 * @mail terrorbladeyang@gmail.com
 */
public class DManualRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7398756246996659934L;

	private long commandId;

	private int command;

	private String plateForm;

	private java.sql.Timestamp time;

	private String reportType;

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
	 * 下发时间
	 * 
	 * @return
	 */
	public java.sql.Timestamp getTime() {
		return time;
	}

	/**
	 * 下发时间
	 * 
	 * @param time
	 */
	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	/**
	 * 指令内容
	 * 
	 * @return
	 */
	public String getReportType() {
		return reportType;
	}

	/**
	 * 指令内容
	 * 
	 * @param reportType
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	@Override
	public String toString() {
		return "DManualRequest [commandId=" + commandId + ", command=" + command + ", plateForm=" + plateForm
				+ ", time=" + time + ", reportType=" + reportType + "]";
	}

}
