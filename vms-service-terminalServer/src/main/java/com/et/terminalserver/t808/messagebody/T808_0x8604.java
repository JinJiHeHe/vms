package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8604
 * @Description: 设置多边形区域
 * @author: lijz
 * @date: 2014年8月6日 下午9:09:54
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8604 extends T808_MessageBody {
	// 0 区域ID DWORD
	// 1 区域属性 WORD 区域属性定义见表47
	// 6 起始时间 BCD[6] 同圆形区域中时间范围设定
	// 12 结束时间 BCD[6] 同圆形区域中时间范围设定
	// 18 最高速度 WORD 单位为公里每小时(Km/h)，若区域属性1位为0则没有该字段
	// 20 超速持续时间 BYTE 单位为秒(s)，若区域属性1位为0则没有该字段
	// 21 区域总定点数 WORD
	// 23 包顶点数 BYTE 当前数据包中顶点个数
	// 24 顶点数 多边形区域的顶点项数据格式见表53
	// 　　表53多边形区域的顶点项数据格式
	// 起始字节 字段 数据类型 描述及要求
	// 0 顶点纬度 DWORD 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
	// 4 顶点经度 DWORD 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
	private int areaID;// 区域ID
	private int areaAttribute;// 区域属性
	private String beginTime;// 起始时间
	private String endTime;// 结束时间
	private int highestSpeed;// 最高速度
	private int overspeedContinueTime;// 超速持续时间
	private int areaPointsCount;// 区域总定点数
	private int packageVertexNumber;// 包顶点数
	private Map<Integer, Integer> vertexMap;// Map<顶点纬度,顶点经度>

	// private int vertexLat;
	// private int vertexLon;

	/**
	 * @Description 获得 overspeedContinueTime
	 */
	public Map<Integer, Integer> getVertexMap() {
		return vertexMap;
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

	/**
	 * @Description 获得 areaPointsCount
	 */
	public int getAreaPointsCount() {
		return areaPointsCount;
	}

	/**
	 * @Description:设置 areaPointsCount
	 */
	public void setAreaPointsCount(int areaPointsCount) {
		this.areaPointsCount = areaPointsCount;
	}

	/**
	 * @Description 获得 packageVertexNumber
	 */
	public int getPackageVertexNumber() {
		return packageVertexNumber;
	}

	/**
	 * @Description:设置 packageVertexNumber
	 */
	public void setPackageVertexNumber(int packageVertexNumber) {
		this.packageVertexNumber = packageVertexNumber;
	}

	public T808_0x8604() {
		vertexMap = new HashMap<Integer, Integer>();
	}

}
