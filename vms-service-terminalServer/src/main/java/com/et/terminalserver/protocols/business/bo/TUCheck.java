package com.et.terminalserver.protocols.business.bo;

public class TUCheck extends BusinessObject {

	private String authCode;

	@Override
	public int getBusinessCode() {
		return TU_CHECK;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

}
