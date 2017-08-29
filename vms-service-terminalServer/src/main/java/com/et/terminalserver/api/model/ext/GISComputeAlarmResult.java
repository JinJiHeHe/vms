package com.et.terminalserver.api.model.ext;
import java.io.Serializable;
import java.util.Date;

/**
 * @Project: CNPC_VMS知识点运用
 * @Title: GISComputeAlarmResult
 * @Description: gis计算结果的实体类
 * @author: ronglj
 * @date :2015年1月28日 上午11:13:21
 * @Copyright: Copyright (c) 2014
 * @version V3.0
 */

public class GISComputeAlarmResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2218172381354446943L;
	/**
	 * 车辆ID，为了保持整洁，统一8位，从10000000开始计算
	 */

	private Integer vehicleId;
	/**
	 * 车牌号
	 */

	private String car_Number;
	/**
	 * 产生报警(三规一限)的地址信息
	 */

	private String address;
	/**
	 * 产生报警(三规一限)的时间
	 */

	private Date generateAlarmTime;
	/**
	 * 如果产生报警数据，针对不同报警的描述，流程中此字段内容可能会变化
	 */

	private String description;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getCar_Number() {
		return car_Number;
	}

	public void setCar_Number(String car_Number) {
		this.car_Number = car_Number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getGenerateAlarmTime() {
		return generateAlarmTime;
	}

	public void setGenerateAlarmTime(Date generateAlarmTime) {
		this.generateAlarmTime = generateAlarmTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GISComputeAlarmResult [vehicleId=" + vehicleId + ", car_Number=" + car_Number + ", address=" + address
				+ ", generateAlarmTime=" + generateAlarmTime + ", description=" + description + "]";
	}

}
