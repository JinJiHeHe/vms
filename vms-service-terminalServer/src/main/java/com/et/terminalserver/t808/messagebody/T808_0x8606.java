package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8606
 * @Description: 设置路线
 * @author: lijz
 * @date: 2014年8月6日 下午9:10:39
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8606 extends T808_MessageBody {
	// 0 路线ID DWORD
	// 4 路线属性 WORD 路线属性数据格式见表56
	// 6 起始时间 BCD[6] 同圆形区域中时间范围设定
	// 12 结束时间 BCD[6] 同圆形区域中时间范围设定
	// 18 路线总拐点数 WORD
	// 20 包拐点数 BYTE
	// 21 拐点项 路线拐点项数据格式见表57
	// 　　表56路线属性数据格式
	// 位 标志
	// 0 1：根据时间
	// 1 保留
	// 2 1：进路线报警给驾驶员
	// 3 1：进路线报警给平台
	// 4 1：出路线报警给驾驶员
	// 5 1：出路线报警给平台
	// 6-15 保留
	// 　　表57路线拐点项数据格式
	// 起始字节 字段 数据类型 描述及要求
	// 0 路段ID DWORD
	// 4 拐点纬度 DWORD 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
	// 8 拐点经度 DWORD 以度为单位的纬度值乘以10的6次方，精确到百万分之一度
	// 12 路段宽度 BYTE 单位为米(m),路段为该拐点到下一拐点
	// 13 路段属性 BYTE 路段属性数据格式见表58
	// 14 路段行驶时长 WORD 单位为秒(S)，若路段属性0位为0则没有该字段
	// 16 路段最高速度 WORD 单位为公里每小时(km/h ),若路段属性1位为0则没有该字段
	// 18 路段超速持续时问 BYTE 单位为秒(S),若路段属性1位为0则没有该字段
	// 　　表58路段属性数据格式
	// 位 标志
	// 0 1：行驶时间
	// 1 1：限速
	// 2 0：北纬；1：南纬
	// 3 0：东经；1：西经
	// 4-7 保留
	private int lineID;// 路线ID
	private int lineAttribute;// 路线属性
	private String beginTime;// 起始时间
	private String endTime;// 结束时间
	private int lineInflexionCount;// 路线总拐点数
	private int packageInflexionCount;// 包拐点数
	private List<String> inflexionListItems;// 21 拐点项 路线拐点项数据格式见表57

	/*
	 * private int roadID; private int inflexionLat; private int inflexionLot;
	 * private int roadWeight; private int roadAttribute; private int
	 * roadRunningTime; private int roadHighestSpeed; private int
	 * roadOverspeedContinueTime;
	 */

	// public int getRoadID() {
	// return roadID;
	// }
	//
	// public void setRoadID(int roadID) {
	// this.roadID = roadID;
	// }
	//
	// public int getInflexionLat() {
	// return inflexionLat;
	// }
	//
	// public void setInflexionLat(int inflexionLat) {
	// this.inflexionLat = inflexionLat;
	// }
	//
	// public int getInflexionLot() {
	// return inflexionLot;
	// }
	//
	// public void setInflexionLot(int inflexionLot) {
	// this.inflexionLot = inflexionLot;
	// }
	//
	// public int getRoadWeight() {
	// return roadWeight;
	// }
	//
	// public void setRoadWeight(int roadWeight) {
	// this.roadWeight = roadWeight;
	// }
	//
	// public int getRoadAttribute() {
	// return roadAttribute;
	// }
	//
	// public void setRoadAttribute(int roadAttribute) {
	// this.roadAttribute = roadAttribute;
	// }
	//
	// public int getRoadRunningTime() {
	// return roadRunningTime;
	// }
	//
	// public void setRoadRunningTime(int roadRunningTime) {
	// this.roadRunningTime = roadRunningTime;
	// }
	//
	// public int getRoadHighestSpeed() {
	// return roadHighestSpeed;
	// }
	//
	// public void setRoadHighestSpeed(int roadHighestSpeed) {
	// this.roadHighestSpeed = roadHighestSpeed;
	// }
	//
	// public int getRoadOverspeedContinueTime() {
	// return roadOverspeedContinueTime;
	// }
	//
	// public void setRoadOverspeedContinueTime(int roadOverspeedContinueTime) {
	// this.roadOverspeedContinueTime = roadOverspeedContinueTime;
	// }

	public T808_0x8606() {
		inflexionListItems = new ArrayList<String>();
	}

	/**
	 * @Description 获得 lineID
	 */
	public int getLineID() {
		return lineID;
	}

	/**
	 * @Description:设置 lineID
	 */
	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	/**
	 * @Description 获得 lineAttribute
	 */
	public int getLineAttribute() {
		return lineAttribute;
	}

	/**
	 * @Description:设置 lineAttribute
	 */
	public void setLineAttribute(int lineAttribute) {
		this.lineAttribute = lineAttribute;
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
	 * @Description 获得 lineInflexionCount
	 */
	public int getLineInflexionCount() {
		return lineInflexionCount;
	}

	/**
	 * @Description:设置 lineInflexionCount
	 */
	public void setLineInflexionCount(int lineInflexionCount) {
		this.lineInflexionCount = lineInflexionCount;
	}

	/**
	 * @Description 获得 packageInflexionCount
	 */
	public int getPackageInflexionCount() {
		return packageInflexionCount;
	}

	/**
	 * @Description:设置 packageInflexionCount
	 */
	public void setPackageInflexionCount(int packageInflexionCount) {
		this.packageInflexionCount = packageInflexionCount;
	}

	/**
	 * @Description 获得 inflexionListItems
	 */
	public List<String> getInflexionListItems() {
		return inflexionListItems;
	}

}
