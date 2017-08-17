package com.et.terminalserver.protocols.business.bo;

/**
 * @Description 
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月9日 下午11:01:16
 * @mail terrorbladeyang@gmail.com
 */
public class TDCall extends BusinessObject{
   
	private int sign;// 0 标志 BYTE 0：普通通话；1：监听
	private String phoneNumber;// 1 电话号码 STRING 最长为20字节

	/**
	 * @Description 获得 sign
	 */
	public int getSign() {
		return sign;
	}

	/**
	 * @Description:设置 sign
	 */
	public void setSign(int sign) {
		this.sign = sign;
	}

	/**
	 * @Description 获得 phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @Description:设置 phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int getBusinessCode() {
		return PD_CALLBACK;
	}

	
}
