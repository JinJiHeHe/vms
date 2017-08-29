package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 下级自动执行上级命令的结果反馈
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:43:57
 * @mail terrorbladeyang@gmail.com
 */
public class DAutoResponse implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -8210203381345437686L;
	/**
	 * 指令流水号
	 */
	private long commandId;
	/**
	 * 指令代码
	 */
	private int command;
	/**
	 * 上报时间
	 */
	private java.sql.Timestamp time;
	/**
	 * 上报平台
	 */
	private String plateForm;
	/**
	 * 上报类型
	 */
	private String reportType;

	/**
	 * 指令内容
	 */
	private String cmdContent;
	/**
	 * 反馈结果
	 */
	private String result;

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
	 * 指令内容
	 * 
	 * @return
	 */
	public String getCmdContent() {
		return cmdContent;
	}

	/**
	 * 指令内容
	 * 
	 * @param cmdContent
	 */
	public void setCmdContent(String cmdContent) {
		this.cmdContent = cmdContent;
	}

	/**
	 * 反馈结果
	 * 
	 * @return
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 反馈结果
	 * 
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "DAutoResponse [commandId=" + commandId + ", command=" + command + ", time=" + time + ", plateForm="
				+ plateForm + ", reportType=" + reportType + ", cmdContent=" + cmdContent + ", result=" + result + "]";
	}

}
