package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 809 报警预警/运行提示
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:49:09
 * @mail terrorbladeyang@gmail.com
 */
public class DInformTips implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966806858454415961L;

	private String vehicleNo;

	private Byte vehicleColor;

	private Byte warnSrc;

	private int warType;

	private String warnTime;

	private String warnContent;

	private String platformId;

	/**
	 * 车牌号码
	 * 
	 * @return
	 */
	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	/**
	 * 车牌颜色
	 * 
	 * @return
	 */
	public Byte getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(Byte vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	/**
	 * 报警信息来源
	 * 
	 * @return
	 */
	public Byte getWarnSrc() {
		return warnSrc;
	}

	public void setWarnSrc(Byte warnSrc) {
		this.warnSrc = warnSrc;
	}

	/**
	 * 报警类型
	 * 
	 * @return
	 */
	public int getWarType() {
		return warType;
	}

	public void setWarType(int warType) {
		this.warType = warType;
	}

	/**
	 * 报警时间
	 * 
	 * @return
	 */
	public String getWarnTime() {
		return warnTime;
	}

	public void setWarnTime(String warnTime) {
		this.warnTime = warnTime;
	}

	/**
	 * 报警描述
	 * 
	 * @return
	 */
	public String getWarnContent() {
		return warnContent;
	}

	public void setWarnContent(String warnContent) {
		this.warnContent = warnContent;
	}

	/**
	 * 平台ID
	 * 
	 * @return
	 */
	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	@Override
	public String toString() {
		return "DInformTips [vehicleNo=" + vehicleNo + ", vehicleColor=" + vehicleColor + ", warnSrc=" + warnSrc
				+ ", warType=" + warType + ", warnTime=" + warnTime + ", warnContent=" + warnContent + ", platformId="
				+ platformId + "]";
	}
}
