package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0100
 * @Description: 终端注册
 * @author: guanhl
 * @date: 2014年8月6日 下午6:49:34
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0100 extends T808_MessageBody {

	private int provinceID;// 省域ID WORD
	private int cityID;// 市县域ID WORD
	private String providerID;// 制造商ID BYTE[5]
	private String terminalVersion;// 终端型号 BYTE[20]
	private String terminalID;// 终端ID BYTE[7]
	private int color;// 车牌颜色 BYTE
	private String licensePlate;// 车牌 STRING

	/**
	 * @Description 获得 provinceID
	 */
	public int getProvinceID() {
		return provinceID;
	}

	/**
	 * @Description:设置 provinceID
	 */
	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}

	/**
	 * @Description 获得 cityID
	 */
	public int getCityID() {
		return cityID;
	}

	/**
	 * @Description:设置 cityID
	 */
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}

	/**
	 * @Description 获得 providerID
	 */
	public String getProviderID() {
		return providerID;
	}

	/**
	 * @Description:设置 providerID
	 */
	public void setProviderID(String providerID) {
		this.providerID = providerID;
	}

	/**
	 * @Description 获得 terminalVersion
	 */
	public String getTerminalVersion() {
		return terminalVersion;
	}

	/**
	 * @Description:设置 terminalVersion
	 */
	public void setTerminalVersion(String terminalVersion) {
		this.terminalVersion = terminalVersion;
	}

	/**
	 * @Description 获得 terminalID
	 */
	public String getTerminalID() {
		return terminalID;
	}

	/**
	 * @Description:设置 terminalID
	 */
	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	/**
	 * @Description 获得 color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @Description:设置 color
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * @Description 获得 licensePlate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * @Description:设置 licensePlate
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return "T808_0x0100 [provinceID=" + provinceID + ", cityID=" + cityID
				+ ", providerID=" + providerID + ", terminalVersion="
				+ terminalVersion + ", terminalID=" + terminalID + ", color="
				+ color + ", licensePlate=" + licensePlate + "]";
	}

}
