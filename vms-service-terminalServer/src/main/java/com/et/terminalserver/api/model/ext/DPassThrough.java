package com.et.terminalserver.api.model.ext;

public class DPassThrough {

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
	
	
}
