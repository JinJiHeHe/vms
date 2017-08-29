package com.et.terminalserver.api.model.ext;

import java.io.Serializable;


/**
 * @Description 809 人工指令反馈
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:49:43
 * @mail terrorbladeyang@gmail.com
 */

public class DManualResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7964672811728914207L;

	private long commandId;

	private int command;

	private String plateForm;

	private String params;

	/**
	 * commandId
	 * 
	 * @return
	 */
	public long getCommandId() {
		return commandId;
	}

	/**
	 * commandId
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
	 * 反馈内容
	 * 
	 * @return
	 */
	public String getParams() {
		return params;
	}

	/**
	 * 反馈内容
	 * 
	 * @param params
	 */
	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "DManualResponse [commandId=" + commandId + ", command=" + command + ", plateForm=" + plateForm
				+ ", params=" + params + "]";
	}

}
