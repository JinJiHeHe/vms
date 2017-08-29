package com.et.terminalserver.protocols.business.bo;

public class TDRecord extends BusinessObject {

	/** 1.停止录音 / 0.开始录音 */
	private int recordCommand = 0;

	private int recordTime = 30;

	private int saveFlag = 0;

	private int camcorderType = 1;

	@Override
	public int getBusinessCode() {
		return PD_RECORD;
	}

	public int getRecordCommand() {
		return recordCommand;
	}

	public void setRecordCommand(int recordCommand) {
		this.recordCommand = recordCommand;
	}

	public int getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(int recordTime) {
		this.recordTime = recordTime;
	}

	public int getSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(int saveFlag) {
		this.saveFlag = saveFlag;
	}

	public int getCamcorderType() {
		return camcorderType;
	}

	public void setCamcorderType(int camcorderType) {
		this.camcorderType = camcorderType;
	}

}
