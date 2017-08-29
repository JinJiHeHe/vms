package com.et.terminalserver.protocols.business.bo;

public class TDRectangleAreaDelete extends BusinessObject{

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getBusinessCode() {
		return PD_RECTANGLE_AREA_DELETE;
	}

}
