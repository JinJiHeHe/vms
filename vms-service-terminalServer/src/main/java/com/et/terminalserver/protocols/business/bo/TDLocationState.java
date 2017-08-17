package com.et.terminalserver.protocols.business.bo;

/**
 * @Description 位置状态
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月9日 下午11:10:33
 * @mail terrorbladeyang@gmail.com
 */
public class TDLocationState extends BusinessObject{
   
	
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
