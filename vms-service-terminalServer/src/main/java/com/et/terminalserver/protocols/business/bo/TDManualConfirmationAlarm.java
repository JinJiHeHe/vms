package com.et.terminalserver.protocols.business.bo;

public class TDManualConfirmationAlarm extends BusinessObject{

	
	//报警消息流水号
	int alarmMessageSeq;
	//人工确认报警类型
	int alarmType;
	
	@Override
	public int getBusinessCode() {
		return BusinessObject.PD_MANUALCONFIRMATIONALARM;
	}

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
