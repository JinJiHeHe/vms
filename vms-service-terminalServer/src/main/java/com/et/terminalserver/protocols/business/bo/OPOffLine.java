package com.et.terminalserver.protocols.business.bo;

/**
 * @Description 离线对象
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月9日 下午11:00:59
 * @mail terrorbladeyang@gmail.com
 */
public class OPOffLine extends BusinessObject {

	private String vid;
	private String terminalKey;
	
	@Override
	public int getBusinessCode() {
		return BusinessObject.OP_OFFLINE;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getTerminalKey() {
		return terminalKey;
	}

	public void setTerminalKey(String terminalKey) {
		this.terminalKey = terminalKey;
	}

	
}
