package com.et.terminalserver.protocols.business.bo;

public class TUResponse extends BusinessObject{

	private int cmdID;
	private int seqID;
	private int result;
	private String content;
	private String vid;

	public int getCmdID() {
		return cmdID;
	}

	public void setCmdID(int cmdID) {
		this.cmdID = cmdID;
	}


	public int getSeqID() {
		return seqID;
	}

	public void setSeqID(int seqID) {
		this.seqID = seqID;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	@Override
	public int getBusinessCode() {
		return TR_COMMON_RESPONSE;
	}
}
