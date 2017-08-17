package com.et.terminalserver.protocols.business.bo;

public class TDTravelDataRecorder extends BusinessObject{

	private int command;// 0 命令字 BYTE 命令字列表见GB/T19056中相关要求

	/**
	 * @Description 获得 command
	 */
	public int getCommand() {
		return command;
	}

	/**
	 * @Description:设置 command
	 */
	public void setCommand(int command) {
		this.command = command;
	}

	@Override
	public int getBusinessCode() {
		return PD_TRAVELDATARECORDER;
	}
}
