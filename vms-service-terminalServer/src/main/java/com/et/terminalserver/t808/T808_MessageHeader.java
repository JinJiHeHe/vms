package com.et.terminalserver.t808;

import com.et.terminalserver.protocols.protocols.common.CommonMessageHeader;

/**
 * @Project: CNPC_VMS
 * @Title: 808协议消息头
 * @Description: 808协议消息头
 * @author: lijz
 * @date: 2014年4月24日 下午12:45:54
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_MessageHeader extends CommonMessageHeader {

	// ***************【消息体属性】****************
	// 消息体长度
	private int bodyLength;
	// 加密类型RSA/OFF
	private int encrypt;
	// 是否分包
	private boolean subpackage;
	// ***************【终端手机号】****************
	private String simNum;
	// ***************【流水号】********************
	private int runningNum;
	// ***************【消息包封装项】***************
	// 分包数
	private int packageCounts;
	// 包序号
	private int packageNum;

	private String channelKey;

	public T808_MessageHeader() {
		protocolName = "T808";
		version = "2013";
	}

	/**
	 * @Description 获得 bodyLength
	 */
	public int getBodyLength() {

		return bodyLength;
	}

	/**
	 * @Description:设置 bodyLength
	 */
	public void setBodyLength(int bodyLength) {
		this.bodyLength = bodyLength;
	}

	/**
	 * @Description 获得 encrypt
	 */
	public int getEncrypt() {
		return encrypt;
	}

	/**
	 * @Description:设置 encrypt
	 */
	public void setEncrypt(int encrypt) {
		this.encrypt = encrypt;
	}

	/**
	 * @Description 获得 subpackage
	 */
	public boolean getSubpackage() {
		return subpackage;
	}

	/**
	 * @Description:设置 subpackage
	 */
	public void setSubpackage(boolean subpackage) {
		this.subpackage = subpackage;
	}

	/**
	 * @Description 获得 simNum
	 */
	public String getSimNum() {
		return simNum;
	}

	/**
	 * @Description:设置 simNum
	 */
	public void setSimNum(String simNum) {
		this.simNum = simNum;
	}

	/**
	 * @Description 获得 runningNum
	 */
	public int getRunningNum() {
		return runningNum;
	}

	/**
	 * @Description:设置 runningNum
	 */
	public void setRunningNum(int runningNum) {
		this.runningNum = runningNum;
	}

	/**
	 * @Description 获得 packageCounts
	 */
	public int getPackageCounts() {
		return packageCounts;
	}

	/**
	 * @Description:设置 packageCounts
	 */
	public void setPackageCounts(int packageCounts) {
		this.packageCounts = packageCounts;
	}

	/**
	 * @Description 获得 packageNum
	 */
	public int getPackageNum() {
		return packageNum;
	}

	/**
	 * @Description:设置 packageNum
	 */
	public void setPackageNum(int packageNum) {
		this.packageNum = packageNum;
	}

	@Override
	public String getTerminalKey() {
		return this.simNum;
	}

	@Override
	public String getChannelKey() {
		return channelKey;
	}

	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}

	@Override
	public int getOpts() {
		return this.runningNum;
	}

	@Override
	public String toString() {
		return "T808_MessageHeader [bodyLength=" + bodyLength + ", encrypt="
				+ encrypt + ", subpackage=" + subpackage + ", simNum=" + simNum
				+ ", runningNum=" + runningNum + ", packageCounts="
				+ packageCounts + ", packageNum=" + packageNum
				+ ", channelKey=" + channelKey + ", messageID=" + messageID
				+ ", protocolName=" + protocolName + ", messageType="
				+ messageType + ", version=" + version + "]";
	}

	@Override
	public void setTerminalKey(String terminalKey) {
		this.simNum = terminalKey;
	}

}
