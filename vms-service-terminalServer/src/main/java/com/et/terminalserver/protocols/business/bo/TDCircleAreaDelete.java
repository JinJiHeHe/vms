package com.et.terminalserver.protocols.business.bo;

public class TDCircleAreaDelete extends BusinessObject{

	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getBusinessCode() {
		return PD_CIRCLE_AREA_DELETE;
	}

}
