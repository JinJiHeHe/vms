package com.et.terminalserver.api.model.ext;

/**
 * @Description 终端信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:04:56
 * @mail terrorbladeyang@gmail.com
 */

public class STerminalInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4046761147520642810L;
	/**
	 * 终端编号
	 */
	private Integer terminalId;
	/**
	 * sim卡号
	 */

	private Integer simId;
	/**
	 * 终端类型ID
	 */

	private Integer tTypeId;
	/**
	 * 终端名
	 */

	private String terminalName;
	/**
	 * 鉴权码，系统发送的鉴权码
	 */

	private String authenticationCode;
	/**
	 * 开户状态
	 */

	private Integer accountFlag;
	/**
	 * 终端回传时间
	 */

	private Integer rinterval;
	/**
	 * 主ip
	 */

	private String ip;
	/**
	 * 主port
	 */

	private String port;
	/**
	 * 从ip
	 */

	private String sip;
	/**
	 * 从port
	 */

	private String sport;
	/**
	 * 终端编号
	 */

	private String terminalCode;

	public Integer getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Integer terminalId) {
		this.terminalId = terminalId;
	}

	public Integer getSimId() {
		return simId;
	}

	public void setSimId(Integer simId) {
		this.simId = simId;
	}

	public Integer getTTypeId() {
		return tTypeId;
	}

	public void setTTypeId(Integer tTypeId) {
		this.tTypeId = tTypeId;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getAuthenticationCode() {
		return authenticationCode;
	}

	public void setAuthenticationCode(String authenticationCode) {
		this.authenticationCode = authenticationCode;
	}

	public Integer getAccountFlag() {
		return accountFlag;
	}

	public void setAccountFlag(Integer accountFlag) {
		this.accountFlag = accountFlag;
	}

	public Integer getRinterval() {
		return rinterval;
	}

	public void setRinterval(Integer rinterval) {
		this.rinterval = rinterval;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSip() {
		return sip;
	}

	public void setSip(String sip) {
		this.sip = sip;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	@Override
	public String toString() {
		return "STerminalInfo [terminalId=" + terminalId + ", simId=" + simId
				+ ", tTypeId=" + tTypeId + ", terminalName=" + terminalName
				+ ", authenticationCode=" + authenticationCode
				+ ", accountFlag=" + accountFlag + ", rinterval=" + rinterval
				+ ", ip=" + ip + ", port=" + port + ", sip=" + sip + ", sport="
				+ sport + ", terminalCode=" + terminalCode + "]";
	}

}
