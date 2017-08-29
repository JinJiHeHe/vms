package com.et.terminalserver.common.util;

/**
 * @Project: CNPC_VMS
 * @Title: 经纬度实体
 * @Description: 经纬度实体
 * @author: guanhl
 * @date: 2014年4月23日 上午9:59:15
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class LonLat {
	/**
	 * 经度
	 */
	private double longitude;
	/**
	 * 纬度
	 */
	private double latitude;

	/**
	 * @Description 构造方法
	 * @param longitude - 经度
	 * @param latitude - 纬度
	 */
	public LonLat(double longitude, double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	/**
	 * @Description 构造方法
	 */
	public LonLat() {

	}

	/**
	 * @Description 获取经度
	 * @return 经度
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @Description 设置经度
	 * @param longitude 经度
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @Description 设置纬度
	 * @return 纬度
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @Description 设置纬度
	 * @param longitude 纬度
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}
