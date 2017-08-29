package com.et.terminalserver.protocols.business.bo;

public class TDText extends BusinessObject {

	private int mark;// 0 标志 BYTE 文本信息标志位含义见表27
	private String textMessage;// 1 文本信息 STRING 最长为102字节，经GBK编码
	
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	@Override
	public int getBusinessCode() {
		
		return PD_TEXT;
	}


}
