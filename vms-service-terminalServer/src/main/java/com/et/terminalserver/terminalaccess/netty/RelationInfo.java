package com.et.terminalserver.terminalaccess.netty;

import com.et.terminalserver.api.model.SimCardInfo;
import com.et.terminalserver.api.model.TerminalInfo;
import com.et.terminalserver.api.model.VehicleInfo;

/**
 * @Description 
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月8日 上午10:20:03
 * @mail terrorbladeyang@gmail.com
 */
public class RelationInfo {

	private String terminalKey;
	private String vehicleID;
	private String terminalID;
	private String sinNum;
	
	private SimCardInfo simInfo;
	private TerminalInfo terminalInfo;
	private VehicleInfo vehicleInfo;

	public String getTerminalKey() {
		return terminalKey;
	}

	public void setTerminalKey(String terminalKey) {
		this.terminalKey = terminalKey;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}



	public String getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	public String getSinNum() {
		return sinNum;
	}

	public void setSinNum(String sinNum) {
		this.sinNum = sinNum;
	}

	public SimCardInfo getSimInfo() {
		return simInfo;
	}

	public void setSimInfo(SimCardInfo simInfo) {
		this.simInfo = simInfo;
	}

	public TerminalInfo getTerminalInfo() {
		return terminalInfo;
	}

	public void setTerminalInfo(TerminalInfo terminalInfo) {
		this.terminalInfo = terminalInfo;
	}

	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}

	public void setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	
}
