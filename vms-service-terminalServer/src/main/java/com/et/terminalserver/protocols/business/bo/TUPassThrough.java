package com.et.terminalserver.protocols.business.bo;

public class TUPassThrough extends BusinessObject{

	private int type = 0;
	
	private byte[] data ;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	@Override
	public int getBusinessCode() {
		return 0x0900;
	}
	
}
