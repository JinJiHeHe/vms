package com.et.terminalserver.api.model;

/**
 * @Description 终端信息
 * @author maple
 * @version V1.0
 * @Date 2016年4月7日下午5:26:02
 * @mail rw222222@126.com
 */
public class TerminalInfo {

	/** 通道名称 vms_zwnet_channel_terminalinfo */

	/**
	 * 关系参照 车辆id
	 */
	private String vechileId;// 关系参照 车辆id

	/**
	 * 关系参照 sim卡号
	 */
	private String simNum; // 关系参照 sim卡号

	/**
	 * 关系参照 终端编号
	 */
	private String terminalCode; // 关系参照 终端编号

	/**
	 * 终端类型，现只有部标
	 */
	private String terminalType; // "部标"

	/**
	 * 组织编号
	 */
	private String gcode; // 组织编号

	/**
	 * 终端ID
	 */
	private String terminalId; // 终端ID

	/**
	 * sim卡id
	 */
	private String simCardId; // sim卡

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getVechileId() {
		return vechileId;
	}

	public void setVechileId(String vechileId) {
		this.vechileId = vechileId;
	}

	public String getSimCardId() {
		return simCardId;
	}

	public void setSimCardId(String simCardId) {
		this.simCardId = simCardId;
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

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getGcode() {
		return gcode;
	}

	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

}
