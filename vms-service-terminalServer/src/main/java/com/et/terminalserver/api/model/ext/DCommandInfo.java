package com.et.terminalserver.api.model.ext;

import java.io.Serializable;

/**
 * @Description 指令信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:44:56
 * @mail terrorbladeyang@gmail.com
 */
public class DCommandInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1908364544323172864L;
	/**
	 * 流水号
	 */
	private int seqID;
	/**
	 * 指令编号
	 */
	private int cmdID;
	/**
	 * 指令参数
	 */
	private String cmdContent;

	/**
	 * 车辆id
	 */
	private String vehicleId;

	/**
	 * 指令状态
	 */
	private Integer status;

	/**
	 * 指令来源
	 * */
	private int commandSourceCode=0;
	


	public int getSeqID() {
		return seqID;
	}

	public void setSeqID(int seqID) {
		this.seqID = seqID;
	}

	/**
	 * 指令编号
	 */
	public int getCmdID() {
		return cmdID;
	}

	/**
	 * 指令编号
	 */
	public void setCmdID(int cmdID) {
		this.cmdID = cmdID;
	}

	/**
	 * 指令参数
	 */
	public String getCmdContent() {
		return cmdContent;
	}

	/**
	 * 指令参数
	 */
	public void setCmdContent(String cmdContent) {
		this.cmdContent = cmdContent;
	}

	/**
	 * 车辆id
	 */
	public String getVehicleId() {
		return vehicleId;
	}

	/**
	 * 车辆id
	 */
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * 指令状态
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 指令状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	public int getCommandSourceCode() {
		return commandSourceCode;
	}

	public void setCommandSourceCode(int commandSourceCode) {
		this.commandSourceCode = commandSourceCode;
	}

	@Override
	public String toString() {
		return "DCommandInfo [seqID=" + seqID + ", cmdID=" + cmdID + ", cmdContent=" + cmdContent + ", vehicleId="
				+ vehicleId + ", status=" + status + "]";
	}

}
