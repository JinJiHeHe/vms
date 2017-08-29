package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8500
 * @Description: 车辆控制
 * @author: lijz
 * @date: 2014年4月16日 下午6:53:50
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8500 extends T808_MessageBody {

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

	public T808_0x8500() {
	}

}
