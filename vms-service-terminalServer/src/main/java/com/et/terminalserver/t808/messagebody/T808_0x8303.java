package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8303
 * @Description: 信息点播菜单设置
 * @author: lijz
 * @date: 2014年4月17日 上午11:06:35
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8303 extends T808_MessageBody {

	private int setType;// 0 设置类型 BYTE 0：删除终端现有信息项；1：更新菜单；2：追加菜单；3：修改菜单
	private int infoItemCount;// 1 信息项总数 BYTE
	private int packageInfoNumber;// 2 包消息数 BYTE
	private List<String> infoList;// 信息项列表

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
	 * @Description 获得 infoItemCount
	 */
	public int getInfoItemCount() {
		return infoItemCount;
	}

	/**
	 * @Description:设置 infoItemCount
	 */
	public void setInfoItemCount(int infoItemCount) {
		this.infoItemCount = infoItemCount;
	}

	/**
	 * @Description 获得 packageInfoNumber
	 */
	public int getPackageInfoNumber() {
		return packageInfoNumber;
	}

	/**
	 * @Description:设置 packageInfoNumber
	 */
	public void setPackageInfoNumber(int packageInfoNumber) {
		this.packageInfoNumber = packageInfoNumber;
	}

	/**
	 * @Description 获得 infoList
	 */
	public List<String> getInfoList() {
		return infoList;
	}

	public T808_0x8303() {
		this.infoList = new ArrayList<String>();
	}

}
