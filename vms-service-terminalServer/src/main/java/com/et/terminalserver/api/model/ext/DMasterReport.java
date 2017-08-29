package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Project: CNPC_VMS
 * @Title: module_name
 * @Description:
 * @author: libin
 * @date: 2014年9月24日 下午4:25:22
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

public class DMasterReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4490088399573185190L;

	private Long commandId;

	private Integer command;

	private java.sql.Timestamp time;

	private String palateform;

	private String reportType;

	private String datasource;

	private String params;

	public Long getCommandId() {
		return commandId;
	}

	public void setCommandId(Long commandId) {
		this.commandId = commandId;
	}

	public Integer getCommand() {
		return command;
	}

	public void setCommand(Integer command) {
		this.command = command;
	}

	public java.sql.Timestamp getTime() {
		return time;
	}

	public void setTime(java.sql.Timestamp time) {
		this.time = time;
	}

	public String getPalateform() {
		return palateform;
	}

	public void setPalateform(String palateform) {
		this.palateform = palateform;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "DMasterReport [commandId=" + commandId + ", command=" + command + ", time=" + time + ", palateform="
				+ palateform + ", reportType=" + reportType + ", datasource=" + datasource + ", params=" + params + "]";
	}

}
