package com.et.terminalserver.protocols.business.bo;

public class TUMediaEvent extends BusinessObject {

	private int mediaId;
	private String type;
	private int eventCode;
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getEventCode() {
		return eventCode;
	}
	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}
	
	@Override
	public int getBusinessCode() {
		return TU_MUTI_MEDIA_EVENT;
	}
	
	
}
