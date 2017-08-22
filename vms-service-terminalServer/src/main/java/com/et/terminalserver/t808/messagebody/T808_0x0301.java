package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0301
 * @Description: 事件报告
 * @author: lijz
 * @date: 2014年4月16日 下午3:09:30
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0301 extends T808_MessageBody {

	private int eventID;// 0 事件ID BYTE

	/**
	 * @Description 获得 eventID
	 */
	public int getEventID() {
		return eventID;
	}

	/**
	 * @Description:设置 eventID
	 */
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	@Override
	public String toString() {
		return "T808_0x0301 [eventID=" + eventID + "]";
	}

}
