package com.et.terminalserver.protocols.business.bo;

public class TUTakePhotoResponse extends BusinessObject {

	private int runningNum;// 0 应答流水号 WORD 对应的终端消息的流水号
	private int responseID;// 2 应答ID WORD 对应的终端消息的ID
	private int result; // 4 结果 BYTE 0：成功/确认；1：失败；2：消息有误；3：不支持

	public int getRunningNum() {
		return runningNum;
	}

	public void setRunningNum(int runningNum) {
		this.runningNum = runningNum;
	}

	public int getResponseID() {
		return responseID;
	}

	public void setResponseID(int responseID) {
		this.responseID = responseID;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public int getBusinessCode() {
		return PD_TAKEPHOTO;
	}

}
