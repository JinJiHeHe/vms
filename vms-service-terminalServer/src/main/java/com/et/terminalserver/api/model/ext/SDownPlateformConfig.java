package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

public class SDownPlateformConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4329789729152217223L;

	private int plateformId;

	private String plateformName;

	private String lowerIp;

	private int lowerPort;

	private int user;

	private String password;

	private String status;

	private int enterId;

	public int getEnterId() {
		return enterId;
	}

	public void setEnterId(int enterId) {
		this.enterId = enterId;
	}

	public int getPlateformId() {
		return plateformId;
	}

	public void setPlateformId(int plateformId) {
		this.plateformId = plateformId;
	}

	public String getPlateformName() {
		return plateformName;
	}

	public void setPlateformName(String plateformName) {
		this.plateformName = plateformName;
	}

	public String getLowerIp() {
		return lowerIp;
	}

	public void setLowerIp(String lowerIp) {
		this.lowerIp = lowerIp;
	}

	public int getLowerPort() {
		return lowerPort;
	}

	public void setLowerPort(int lowerPort) {
		this.lowerPort = lowerPort;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SDownPlateformConfig [plateformId=" + plateformId + ", plateformName=" + plateformName + ", lowerIp="
				+ lowerIp + ", lowerPort=" + lowerPort + ", user=" + user + ", password=" + password + ", status="
				+ status + ", enterId=" + enterId + "]";
	}

}
