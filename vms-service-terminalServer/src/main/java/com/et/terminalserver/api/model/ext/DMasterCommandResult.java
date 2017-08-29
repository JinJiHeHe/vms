package com.et.terminalserver.api.model.ext;

import java.io.Serializable;


/**
 * @Description DMasterCommandResult
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:51:01
 * @mail terrorbladeyang@gmail.com
 */
public class DMasterCommandResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5478237478397167310L;

	private long commandId;

	private int command;

	private String params;

	private String result;

	public long getCommandId() {
		return commandId;
	}

	public void setCommandId(long commandId) {
		this.commandId = commandId;
	}

	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "DMasterCommandResult [commandId=" + commandId + ", command=" + command + ", params=" + params
				+ ", result=" + result + "]";
	}

}
