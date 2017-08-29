package com.et.terminalserver.protocols.business.bo;

/**
 * @Description 车门控制
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月9日 下午11:10:00
 * @mail terrorbladeyang@gmail.com
 */
public class TDDoorControl extends BusinessObject{

	
	private int controlSign;// 0 控制标志 BYTE 控制指令标志位数据格式见表43

	// 表43控制指令标志位数据格式
	// 位 标志
	// 0 0：车门解锁；1：车门加锁
	// 1-7 保留

	/**
	 * @Description 获得 controlSign
	 */
	public int getControlSign() {
		return controlSign;
	}

	/**
	 * @Description:设置 controlSign
	 */
	public void setControlSign(int controlSign) {
		this.controlSign = controlSign;
	}

	@Override
	public int getBusinessCode() {
		
		return PD_DOORCONTROL;
	}
}
