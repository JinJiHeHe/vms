package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8600
 * @Description: 设置圆形区域
 * @author: lijz
 * @date: 2014年4月16日 下午7:18:17
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8600 extends T808_MessageBody {

	private int setAttribute;// 0 设置属性 BYTE 0：更新区域；
	// 1：追加区域；
	// 2：修改区域
	private int areaTotality;// 1 区域总数 BYTE
	private int packageAreaNumber;// 2 包区域数 BYTE 当前数据包中区域个数
	private int areaID;// 0 区域ID DWORD
	private int areaAttribute;// 4 区域属性 WORD 区域属性定义见表47
	private int centerLat;// 6 中心点纬度 DWORD 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
	private int centerLon;// 10 中心点经度 DWORD 以度为单位的经度值乘以10的6次方，精确到百万分之一度
	private int radius;// 14 半径 DWORD 单位为米(m)，路段为该拐点到下一拐点
	private String beginTime;// 18 起始时间 BCD[6] YY-MM-DD-hh-mm-ss
								// ,若区域属性0位为0则没有该字段
	private String endTime;// 24 结束时间 BCD[6] YY-MM-DD-hh-mm-ss ,若区域属性0位为0则没有该字段
	private int highestSpeed;// 30 最高速度 WORD Km/h，若区域属性1位为0则没有该字段
	private int overspeedContinueTime;// 32 超速持续时间 BYTE
										// 单位为秒(s)(类似表述，同前修改)，若区域属性1位为0则没有该字段

	/**
	 * @Description 获得 setAttribute
	 */
	public int getSetAttribute() {
		return setAttribute;
	}

	/**
	 * @Description:设置 setAttribute
	 */
	public void setSetAttribute(int setAttribute) {
		this.setAttribute = setAttribute;
	}

	/**
	 * @Description 获得 areaTotality
	 */
	public int getAreaTotality() {
		return areaTotality;
	}

	/**
	 * @Description:设置 areaTotality
	 */
	public void setAreaTotality(int areaTotality) {
		this.areaTotality = areaTotality;
	}

	/**
	 * @Description 获得 packageAreaNumber
	 */
	public int getPackageAreaNumber() {
		return packageAreaNumber;
	}

	/**
	 * @Description:设置 packageAreaNumber
	 */
	public void setPackageAreaNumber(int packageAreaNumber) {
		this.packageAreaNumber = packageAreaNumber;
	}

	/**
	 * @Description 获得 areaID
	 */
	public int getAreaID() {
		return areaID;
	}

	/**
	 * @Description:设置 areaID
	 */
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}

	/**
	 * @Description 获得 areaAttribute
	 */
	public int getAreaAttribute() {
		return areaAttribute;
	}

	/**
	 * @Description:设置 areaAttribute
	 */
	public void setAreaAttribute(int areaAttribute) {
		this.areaAttribute = areaAttribute;
	}

	/**
	 * @Description 获得 centerLat
	 */
	public int getCenterLat() {
		return centerLat;
	}

	/**
	 * @Description:设置 centerLat
	 */
	public void setCenterLat(int centerLat) {
		this.centerLat = centerLat;
	}

	/**
	 * @Description 获得 centerLon
	 */
	public int getCenterLon() {
		return centerLon;
	}

	/**
	 * @Description:设置 centerLon
	 */
	public void setCenterLon(int centerLon) {
		this.centerLon = centerLon;
	}

	/**
	 * @Description 获得 radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @Description:设置 radius
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * @Description 获得 beginTime
	 */
	public String getBeginTime() {
		return beginTime;
	}

	/**
	 * @Description:设置 beginTime
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @Description 获得 endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @Description:设置 endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @Description 获得 highestSpeed
	 */
	public int getHighestSpeed() {
		return highestSpeed;
	}

	/**
	 * @Description:设置 highestSpeed
	 */
	public void setHighestSpeed(int highestSpeed) {
		this.highestSpeed = highestSpeed;
	}

	/**
	 * @Description 获得 overspeedContinueTime
	 */
	public int getOverspeedContinueTime() {
		return overspeedContinueTime;
	}

	/**
	 * @Description:设置 overspeedContinueTime
	 */
	public void setOverspeedContinueTime(int overspeedContinueTime) {
		this.overspeedContinueTime = overspeedContinueTime;
	}

	public T808_0x8600() {
	}

}
