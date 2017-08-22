package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8301
 * @Description: 事件设置
 * @author: lijz
 * @date: 2014年4月16日 下午4:07:21
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class CopyOfT808_0x8301 extends T808_MessageBody {
	// 0 设置类型 BYTE 0：删除终端现有所有事件，该命令后不带后继字节
	// 1：更新事件。 2：追加事件。 3:修改事件。
	// 4：删除特定几项事件，之后事件项中无需带事件内容
	// 1 设置总数 BYTE
	// 2 包设置个数 BYTE 当前数据包中的事件项个数
	// 3 事件项列表 事件项组成数据格式见表29
	// 表29事件项组成数据格式
	// 起始字节 字段 数据类型 描述及要求
	// 0 事件ID BYTE 若终端已有同ID的事件，则被覆盖
	// 1 事件内容长度 BYTE 后继事件内容字段字节长度
	// 2 事件内容 STRING 事件内容，经GBK编码

	private int setType;// 设置类型
	private int setCount;// 设置总数
	private int packageSNumber;// 包设置个数
	private int eventID;// 事件ID
	private int eventContentLength;// 事件内容长度
	private String eventContent;// 事件内容
	private Map<String, String> map;

	/**
	 * @Description 获得 setType
	 */
	public int getSetType() {
		return setType;
	}

	/**
	 * @Description:设置 setType
	 */
	public void setSetType(int setType) {
		this.setType = setType;
	}

	/**
	 * @Description 获得 setCount
	 */
	public int getSetCount() {
		return setCount;
	}

	/**
	 * @Description:设置 setCount
	 */
	public void setSetCount(int setCount) {
		this.setCount = setCount;
	}

	/**
	 * @Description 获得 packageSNumber
	 */
	public int getPackageSNumber() {
		return packageSNumber;
	}

	/**
	 * @Description:设置 packageSNumber
	 */
	public void setPackageSNumber(int packageSNumber) {
		this.packageSNumber = packageSNumber;
	}

	/**
	 * @Description 获得 eventID
	 */
	public int getEventID() {
		return eventID;
	}

	/**
	 * @Description:设置 eventID
	 */
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	/**
	 * @Description 获得 eventContentLength
	 */
	public int getEventContentLength() {
		return eventContentLength;
	}

	/**
	 * @Description:设置 eventContentLength
	 */
	public void setEventContentLength(int eventContentLength) {
		this.eventContentLength = eventContentLength;
	}

	/**
	 * @Description 获得 eventContent
	 */
	public String getEventContent() {
		return eventContent;
	}

	/**
	 * @Description:设置 eventContent
	 */
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	/**
	 * @Description 获得 map
	 */
	public Map<String, String> getMap() {
		return map;
	}

	/**
	 * @Description:设置 map
	 */
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public CopyOfT808_0x8301() {
		map = new TreeMap<String, String>();
	}

}
