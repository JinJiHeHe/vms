package com.et.terminalserver.protocols.business.bo;

public class TUMedia extends BusinessObject{

	private int mediaId;
	
	private int sum;

	private int num;

	private String type;

	private byte[] data;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	
	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
		return TU_MUTI_MEDIA;
	}

}
