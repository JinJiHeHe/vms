package com.et.terminalserver.protocols.business.bo;

/**
 * @Description 终端参数查询
 * @author jakiro
 * @version V1.0
 * @Date 2016年7月27日 下午5:00:37
 * @mail terrorbladeyang@gmail.com
 */
public class TDQueryTerminalParam extends BusinessObject{
	
	@Override
	public int getBusinessCode() {
		
		return BusinessObject.PD_QUERYTERMINALPARAM;
	}
	
}
