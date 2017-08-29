package com.et.terminalserver.protocols.business.bo;

public class TUOrder extends BusinessObject {

	String content;

	String vid;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int getBusinessCode() {
		return TD_ORDER;
	}

	public String getVehicleID() {
		return vid;
	}
	
	public void setVehicleID(String vid){
		this.vid = vid;
	}
	
	
}
