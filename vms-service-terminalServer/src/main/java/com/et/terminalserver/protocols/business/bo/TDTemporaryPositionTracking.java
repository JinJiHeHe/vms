package com.et.terminalserver.protocols.business.bo;

/**
 * @Description 临时位置跟踪
 * @author jakiro
 * @version V1.0
 * @Date 2016年7月28日 上午12:58:49
 * @mail terrorbladeyang@gmail.com
 */
public class TDTemporaryPositionTracking extends BusinessObject{

	private int interval;// 0 时间间隔 WORD 单位为秒(s),0则停止跟踪。停止跟踪无需带后继字段
	private int validity; // 2 位置跟踪有效期 DWORD
							// 单位为秒(S)，终端在接收到位置跟踪控制消息后，在有效期截止时问之前，依据消息中的时间间隔发送位置汇报

	/**
	 * @Description 获得 interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @Description:设置 interval
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	/**
	 * @Description 获得 validity
	 */
	public int getValidity() {
		return validity;
	}

	/**
	 * @Description:设置 validity
	 */
	public void setValidity(int validity) {
		this.validity = validity;
	}
	
	@Override
	public int getBusinessCode() {
		
		return PD_TEMPORARYPOSITIONTRACKING;
	}
}
