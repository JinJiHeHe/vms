package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.Arrays;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0700
 * @Description: 行驶记录数据上传类
 * @author: lijz
 * @date: 2014年5月27日 下午6:26:37
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0700 extends T808_MessageBody {
	private int serialNumber;// 流水号
	private byte cmdID;// 命令字
	private int dBlockLength;// 数据块总长度
	private int pDataLength;// 包数据长度
	private String content;// 记录仪内容
	private byte[] orginalData;// 原始数据

	/**
	 * @Description 获得 serialNumber
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @Description:设置 serialNumber
	 */
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @Description 获得 cmdID
	 */
	public byte getCmdID() {
		return cmdID;
	}

	/**
	 * @Description:设置 cmdID
	 */
	public void setCmdID(byte cmdID) {
		this.cmdID = cmdID;
	}

	/**
	 * @Description 获得 dBlockLength
	 */
	public int getdBlockLength() {
		return dBlockLength;
	}

	/**
	 * @Description:设置 dBlockLength
	 */
	public void setdBlockLength(int dBlockLength) {
		this.dBlockLength = dBlockLength;
	}

	/**
	 * @Description 获得 pDataLength
	 */
	public int getpDataLength() {
		return pDataLength;
	}

	/**
	 * @Description:设置 pDataLength
	 */
	public void setpDataLength(int pDataLength) {
		this.pDataLength = pDataLength;
	}

	/**
	 * @Description 获得 content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @Description:设置 content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @Description 获得 orginalData
	 */
	public byte[] getOrginalData() {
		return orginalData;
	}

	/**
	 * @Description:设置 orginalData
	 */
	public void setOrginalData(byte[] orginalData) {
		this.orginalData = orginalData;
	}

	@Override
	public String toString() {
		return "T808_0x0700 [serialNumber=" + serialNumber + ", cmdID=" + cmdID
				+ ", dBlockLength=" + dBlockLength + ", pDataLength="
				+ pDataLength + ", content=" + content + ", orginalData="
				+ Arrays.toString(orginalData) + "]";
	}


}
