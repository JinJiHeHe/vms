package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0104
 * @Description: 查询终端参数应答
 * @author: guanhl
 * @date: 2014年8月6日 下午6:50:50
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0104 extends T808_MessageBody {
	private int replaySerialNumber;// 应答流水号
	private int packageParamsNumber;// 包参数个数
	private TerminalParameterInfo paraList;// 参数项(实体类)

	/**
	 * @Description 获得 replaySerialNumber
	 */
	public int getReplaySerialNumber() {
		return replaySerialNumber;
	}

	/**
	 * @Description:设置 replaySerialNumber
	 */
	public void setReplaySerialNumber(int replaySerialNumber) {
		this.replaySerialNumber = replaySerialNumber;
	}

	/**
	 * @Description 获得 packageParamsNumber
	 */
	public int getPackageParamsNumber() {
		return packageParamsNumber;
	}

	/**
	 * @Description:设置 packageParamsNumber
	 */
	public void setPackageParamsNumber(int packageParamsNumber) {
		this.packageParamsNumber = packageParamsNumber;
	}

	/**
	 * @Description 获得 paraList
	 */
	public TerminalParameterInfo getParaList() {
		return paraList;
	}

	/**
	 * @Description:设置 paraList
	 */
	public void setParaList(TerminalParameterInfo paraList) {
		this.paraList = paraList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "T808_0x0104 [replaySerialNumber=" + replaySerialNumber + ", packageParamsNumber=" + packageParamsNumber + ", paraList=" + paraList
				+ "]";
	}

	public T808_0x0104() {
	}

}
