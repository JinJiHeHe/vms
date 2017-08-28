package com.et.terminalserver.api.model.ext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_TankDatasAndTyreStatus
 * @Description: 传感器状态记录
 * @author: ronglj
 * @date :2015年4月14日 下午3:01:01
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

public class DVehicleSensorStatusRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -625279992671894346L;
	/**
	 * 罐体个数 byte
	 */

	private int tankNumber;
	/**
	 * 罐体数据内容
	 */

	private DTankData[] tankData;

	/**
	 * 轮胎状态记录
	 */

	private DTyreStatusRecord[] tyreStatusRecord;

	/**
	 * 时间戳
	 */

	private Long timeStamp;

	/**
	 * 车牌号
	 */

	private String vehicleNo;

	/**
	 * 车牌颜色
	 */

	private Byte vehicleColor;

	/**
	 * @return the tankNumber
	 */
	public int getTankNumber() {
		return tankNumber;
	}

	/**
	 * @param tankNumber
	 *            the tankNumber to set
	 */
	public void setTankNumber(int tankNumber) {
		this.tankNumber = tankNumber;
	}

	/**
	 * @return the tankData
	 */
	public DTankData[] getTankData() {
		return tankData;
	}

	/**
	 * @param tankData
	 *            the tankData to set
	 */
	public void setTankData(DTankData[] tankData) {
		this.tankData = tankData;
	}

	/**
	 * @return the tyreStatusRecord
	 */
	public DTyreStatusRecord[] getTyreStatusRecord() {
		return tyreStatusRecord;
	}

	/**
	 * @param tyreStatusRecord
	 *            the tyreStatusRecord to set
	 */
	public void setTyreStatusRecord(DTyreStatusRecord[] tyreStatusRecord) {
		this.tyreStatusRecord = tyreStatusRecord;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Byte getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(Byte vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	@Override
	public String toString() {
		return "DVehicleSensorStatusRecord [tankNumber=" + tankNumber + ", tankData=" + Arrays.toString(tankData)
				+ ", tyreStatusRecord=" + Arrays.toString(tyreStatusRecord) + ", timeStamp=" + timeStamp
				+ ", vehicleNo=" + vehicleNo + ", vehicleColor=" + vehicleColor + "]";
	}
}
