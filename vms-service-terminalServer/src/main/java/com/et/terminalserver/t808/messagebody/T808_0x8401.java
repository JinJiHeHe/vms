package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8401
 * @Description: 设置电话本
 * @author: lijz
 * @date: 2014年4月16日 下午6:07:42
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8401 extends T808_MessageBody {

	// 3 联系人项 电话本联系人项数据格式见表41
	// 表41电话本联系人项数据格式
	// 起始字节 字段 数据类型 描述及要求

	private int setType;// 0 设置类型 BYTE 0：删除终端上所有存储的联系人；
	// 1：表示更新电话本(删除终端中已有全部联系人并追加消息，户的联系人)；
	// 2：表示追加电话本；
	// 3：表示修改电话本(以联系人为索引)
	private int contactsTotality;// 1 联系人总数 BYTE
	private int packageContactsNumber;// 2 包联系人个数 BYTE 当前数据包中联系人个数
	private List<String> contactsList;// 联系人项

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
	 * @Description 获得 contactsTotality
	 */
	public int getContactsTotality() {
		return contactsTotality;
	}

	/**
	 * @Description:设置 contactsTotality
	 */
	public void setContactsTotality(int contactsTotality) {
		this.contactsTotality = contactsTotality;
	}

	/**
	 * @Description 获得 packageContactsNumber
	 */
	public int getPackageContactsNumber() {
		return packageContactsNumber;
	}

	/**
	 * @Description:设置 packageContactsNumber
	 */
	public void setPackageContactsNumber(int packageContactsNumber) {
		this.packageContactsNumber = packageContactsNumber;
	}

	/**
	 * @Description 获得 contactsList
	 */
	public List<String> getContactsList() {
		return contactsList;
	}
	

	public void setContactsList(List<String> contactsList) {
		this.contactsList = contactsList;
	}

	public T808_0x8401() {
		this.contactsList = new ArrayList<String>();
	}

}
