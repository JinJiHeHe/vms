package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 808 事件报告
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:47:57
 * @mail terrorbladeyang@gmail.com
 */
public class DEWayBill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5919594555716036750L;

	private String vehicleNo;

	private Byte vehicleColor;

	private String eWayBillInfo;

	/**
	 * 车牌号
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
	 * 电子运单数据内容
	 * 
	 * @return
	 */
	public String geteWayBillInfo() {
		return eWayBillInfo;
	}

	public void seteWayBillInfo(String eWayBillInfo) {
		this.eWayBillInfo = eWayBillInfo;
	}

	@Override
	public String toString() {
		return "DEWayBillInfo [vehicleNo=" + vehicleNo + ", vehicleColor=" + vehicleColor + ", eWayBillInfo="
				+ eWayBillInfo + "]";
	}
}
