package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

public class DSerSrvInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8022125967451539815L;
	// 服务器信息实体类id

	private Integer serversId;
	// 服务器信息实体类服务器名称

	private String serversName;
	// 服务器信息实体类服务器IP

	private String serversIp;
	// 服务器信息实体类服务器端口

	private Integer serversProt;
	// 服务器信息实体类服务器用户名

	private String serversUserName;
	// 服务器信息实体类服务器密码

	private String serversPassword;
	// 服务器信息实体类服务器硬盘

	private String serversDisk;
	// 服务器信息实体类服务器内存

	private String serversMemory;
	// 服务器信息实体类服务器CPU

	private String serversCpu;

	public Integer getServersId() {
		return serversId;
	}

	public void setServersId(Integer serversId) {
		this.serversId = serversId;
	}

	public String getServersName() {
		return serversName;
	}

	public void setServersName(String serversName) {
		this.serversName = serversName;
	}

	public String getServersIp() {
		return serversIp;
	}

	public void setServersIp(String serversIp) {
		this.serversIp = serversIp;
	}

	public Integer getServersProt() {
		return serversProt;
	}

	public void setServersProt(Integer serversProt) {
		this.serversProt = serversProt;
	}

	public String getServersUserName() {
		return serversUserName;
	}

	public void setServersUserName(String serversUserName) {
		this.serversUserName = serversUserName;
	}

	public String getServersPassword() {
		return serversPassword;
	}

	public void setServersPassword(String serversPassword) {
		this.serversPassword = serversPassword;
	}

	public String getServersDisk() {
		return serversDisk;
	}

	public void setServersDisk(String serversDisk) {
		this.serversDisk = serversDisk;
	}

	public String getServersMemory() {
		return serversMemory;
	}

	public void setServersMemory(String serversMemory) {
		this.serversMemory = serversMemory;
	}

	public String getServersCpu() {
		return serversCpu;
	}

	public void setServersCpu(String serversCpu) {
		this.serversCpu = serversCpu;
	}

	@Override
	public String toString() {
		return "DSerSrvInfo [serversId=" + serversId + ", serversName=" + serversName + ", serversIp=" + serversIp
				+ ", serversProt=" + serversProt + ", serversUserName=" + serversUserName + ", serversPassword="
				+ serversPassword + ", serversDisk=" + serversDisk + ", serversMemory=" + serversMemory
				+ ", serversCpu=" + serversCpu + "]";
	}

}
