package com.et.terminalserver.api.model.ext;
import java.io.Serializable;
import java.util.Date;

/**
 * @Project: CNPC_VMS知识点运用
 * @Title: DWaybillInfo
 * @Description: 平台发送电子运单对象的实体类
 * @author: ronglj
 * @date :2015年1月21日 下午10:54:23
 * @Copyright: Copyright (c) 2014
 * @version V3.0
 */

public class DWaybillInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8029880111076398399L;
	/**
	 * 车辆ID，为了保持整洁，统一8位，从10000000开始计算
	 */

	private Integer vehicleId;
	/**
	 * 运单ID
	 */

	private int waybill_ID;
	/**
	 * 车牌号
	 */

	private String car_Number;
	/**
	 * 驾驶员
	 */

	private String driver;
	/**
	 * 运单编号
	 */

	private String waybill_Code;
	/**
	 * 运单开始时间
	 */

	private Date transport_Start_Time;
	/**
	 * 运单结束时间
	 */

	private Date transport_End_Time;
	/**
	 * 状态
	 */

	private String status;
	/**
	 * 运输线路编号
	 */

	private int tranroute_ID;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getWaybill_ID() {
		return waybill_ID;
	}

	public void setWaybill_ID(int waybill_ID) {
		this.waybill_ID = waybill_ID;
	}

	public String getCar_Number() {
		return car_Number;
	}

	public void setCar_Number(String car_Number) {
		this.car_Number = car_Number;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getWaybill_Code() {
		return waybill_Code;
	}

	public void setWaybill_Code(String waybill_Code) {
		this.waybill_Code = waybill_Code;
	}

	public Date getTransport_Start_Time() {
		return transport_Start_Time;
	}

	public void setTransport_Start_Time(Date transport_Start_Time) {
		this.transport_Start_Time = transport_Start_Time;
	}

	public Date getTransport_End_Time() {
		return transport_End_Time;
	}

	public void setTransport_End_Time(Date transport_End_Time) {
		this.transport_End_Time = transport_End_Time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTranroute_ID() {
		return tranroute_ID;
	}

	public void setTranroute_ID(int tranroute_ID) {
		this.tranroute_ID = tranroute_ID;
	}

	public DWaybillInfo() {
		super();
	}

	public DWaybillInfo(int waybill_ID, String car_Number, String driver, String waybill_Code,
			Date transport_Start_Time, Date transport_End_Time, String status, int tranroute_ID) {
		super();
		this.waybill_ID = waybill_ID;
		this.car_Number = car_Number;
		this.driver = driver;
		this.waybill_Code = waybill_Code;
		this.transport_Start_Time = transport_Start_Time;
		this.transport_End_Time = transport_End_Time;
		this.status = status;
		this.tranroute_ID = tranroute_ID;
	}

}
