package com.et.terminalserver.api.model;

/**
 * @Description sim卡信息对象
 * @author maple
 * @version V1.0
 * @Date 2016年4月7日下午5:22:09
 * @mail rw222222@126.com
 */
public class SimCardInfo {

	/** 通道名称 vms_zwnet_channel_siminfo */

	/**
	 * 关系参照 sim卡号
	 */
	private String simNum; // 关系参照 sim卡号

	/**
	 * 关系参照 终端编号
	 */
	private String terminalCode;// 关系参照 终端编号

	/**
	 * 提供商
	 */
	private String provider;// 提供商

	/**
	 * 组织机构
	 */
	private String gcode; // 组织机构

	/**
	 * 卡id
	 */
	private String simCardId; // 卡id

	/**
	 * 終端id
	 */
	private String terminalId; // 終端id

	public String getGcode() {
		return gcode;
	}

	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	public String getSimCardId() {
		return simCardId;
	}

	public void setSimCardId(String simCardId) {
		this.simCardId = simCardId;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getSimNum() {
		return simNum;
	}

	public void setSimNum(String simNum) {
		this.simNum = simNum;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

}
