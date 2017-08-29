package com.et.terminalserver.api.model.ext;

import java.io.Serializable;


/**
 * @Description DMasterCommand
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:50:49
 * @mail terrorbladeyang@gmail.com
 */
public class DMasterCommand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8377811229246343333L;

	private String lowerPlateform;

	private int command;

	private long commandId;

	private String params;

	public String getLowerPlateform() {
		return lowerPlateform;
	}

	public void setLowerPlateform(String lowerPlateform) {
		this.lowerPlateform = lowerPlateform;
	}

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	public long getCommandId() {
		return commandId;
	}

	public void setCommandId(long commandId) {
		this.commandId = commandId;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "DMasterCommand [lowerPlateform=" + lowerPlateform + ", command=" + command + ", commandId=" + commandId
				+ ", params=" + params + "]";
	}

}
