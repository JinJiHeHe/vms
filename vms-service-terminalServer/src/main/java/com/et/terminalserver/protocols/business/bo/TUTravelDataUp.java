package com.et.terminalserver.protocols.business.bo;

public class TUTravelDataUp extends BusinessObject{

	private int serialNumber;// 流水号
	private byte cmdID;// 命令字
	private int dBlockLength;// 数据块总长度
	private int pDataLength;// 包数据长度
	private String content;// 记录仪内容
	private byte[] orginalData;// 原始数据

	/**额外添加的字段*/
	//是否拆包
	private boolean split_flag;
	
	private int packageCounts;
	
	private int packageNum;
	
	
	
	public int getPackageCounts() {
		return packageCounts;
	}

	public void setPackageCounts(int packageCounts) {
		this.packageCounts = packageCounts;
	}

	public int getPackageNum() {
		return packageNum;
	}

	public void setPackageNum(int packageNum) {
		this.packageNum = packageNum;
	}

	public boolean isSplit_flag() {
		return split_flag;
	}

	public void setSplit_flag(boolean split_flag) {
		this.split_flag = split_flag;
	}

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
	public int getBusinessCode() {
		return TR_TRAVELDATA;
	}
}
