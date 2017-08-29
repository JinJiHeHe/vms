package com.et.terminalserver.protocols.business.bo;

public class TDSetIPPort extends BusinessObject {

	private String ip;
	private int port;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public int getBusinessCode() {
		return PD_SETIPANDPORT;
	}

}
