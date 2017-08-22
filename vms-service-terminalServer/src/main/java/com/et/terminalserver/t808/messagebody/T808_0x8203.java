package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

public class T808_0x8203 extends T808_MessageBody{

	//报警消息流水号
	int alarmMessageSeq;
	//人工确认报警类型
	int alarmType;
	
	public int getAlarmMessageSeq() {
		return alarmMessageSeq;
	}
	public void setAlarmMessageSeq(int alarmMessageSeq) {
		this.alarmMessageSeq = alarmMessageSeq;
	}
	public int getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}
	
	
}
