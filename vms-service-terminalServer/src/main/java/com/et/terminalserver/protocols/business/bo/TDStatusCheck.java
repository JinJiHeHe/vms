package com.et.terminalserver.protocols.business.bo;

/**
 * 状态检测
 * 
 * */
public class TDStatusCheck extends BusinessObject {

	private int params;// 新增属性

	/**
	 * @Description 获得 params
	 */
	public int getParams() {
		return params;
	}

	/**
	 * @Description:设置 params
	 */
	public void setParams(int params) {
		this.params = params;
	}


	@Override
	public int getBusinessCode() {
		return PD_LOCATIONSTATE;
	}

}
