package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8602
 * @Description: 设置矩形区域
 * @author: lijz
 * @date: 2014年4月30日 下午2:36:31
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8602 extends T808_MessageBody {

	private int setAttribute;// 0 设置属性 BYTE 0：更新区域；
	// 1：追加区域；
	// 2：修改区域
	private int areaCount;// 1 区域总数 BYTE
	private int packageAreaNumber;// 2 包区域数 BYTE 当前数据包中区域个数
	private int areaID; // 0 区域ID DWORD
	private int areaAttribute;// 4 区域属性 WORD 区域属性定义见表47
	private int upperLeftLon; // 6 左上点纬度 DWORD 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
	private int upperLeftLat;// 10 左上点经度 DWORD 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
	private int lowerRightLon;// 14 右下点纬度 DWORD 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
	private int lowerRightLat;// 18 右下点经度 DWORD 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
	private String beginTime;// 22 起始时间 BCD[6] 同圆形区域中时间范围设定
	private String endTime;// 28 结束时间 BCD[6] 同圆形区域中时间范围设定
	private int highesSpeed;// 34 最高速度 WORD 单位为公里每小时(km/h)，若区域属性1位为没有该字段
	private int overspeedContinueTime;// 36 超速持续时间 BYTE 单位为秒(S),若区域属性1位为0则没有该字段

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
	 * @Description 获得 areaCount
	 */
	public int getAreaCount() {
		return areaCount;
	}

	/**
	 * @Description:设置 areaCount
	 */
	public void setAreaCount(int areaCount) {
		this.areaCount = areaCount;
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
	 * @Description 获得 upperLeftLon
	 */
	public int getUpperLeftLon() {
		return upperLeftLon;
	}

	/**
	 * @Description:设置 upperLeftLon
	 */
	public void setUpperLeftLon(int upperLeftLon) {
		this.upperLeftLon = upperLeftLon;
	}

	/**
	 * @Description 获得 upperLeftLat
	 */
	public int getUpperLeftLat() {
		return upperLeftLat;
	}

	/**
	 * @Description:设置 upperLeftLat
	 */
	public void setUpperLeftLat(int upperLeftLat) {
		this.upperLeftLat = upperLeftLat;
	}

	/**
	 * @Description 获得 lowerRightLon
	 */
	public int getLowerRightLon() {
		return lowerRightLon;
	}

	/**
	 * @Description:设置 lowerRightLon
	 */
	public void setLowerRightLon(int lowerRightLon) {
		this.lowerRightLon = lowerRightLon;
	}

	/**
	 * @Description 获得 lowerRightLat
	 */
	public int getLowerRightLat() {
		return lowerRightLat;
	}

	/**
	 * @Description:设置 lowerRightLat
	 */
	public void setLowerRightLat(int lowerRightLat) {
		this.lowerRightLat = lowerRightLat;
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
	 * @Description 获得 highesSpeed
	 */
	public int getHighesSpeed() {
		return highesSpeed;
	}

	/**
	 * @Description:设置 highesSpeed
	 */
	public void setHighesSpeed(int highesSpeed) {
		this.highesSpeed = highesSpeed;
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

	public T808_0x8602() {
	}

}
