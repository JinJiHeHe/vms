package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8804
 * @Description: 录音开始命令
 * @author: lijz
 * @date: 2014年4月28日 下午4:06:39
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

public class T808_0x8804 extends T808_MessageBody {

	private int recordCommand;// 0 录音命令 BYTE 0：停止录音；0x01:开始录音
	private int recordTime;// 1 录音时间 WORD 单位为秒(s)，0表示一直录音
	private int saveSign;// 3 保存标志 BYTE 0：实时长传；1：保存
	private int frequencySamplingRate;// 4 音频采样率 BYTE
										// 0：8k；1:11k；2:23K；3：32K；其他保留

	/**
	 * @Description 获得 recordCommand
	 */
	public int getRecordCommand() {
		return recordCommand;
	}

	/**
	 * @Description:设置 recordCommand
	 */
	public void setRecordCommand(int recordCommand) {
		this.recordCommand = recordCommand;
	}

	/**
	 * @Description 获得 recordTime
	 */
	public int getRecordTime() {
		return recordTime;
	}

	/**
	 * @Description:设置 recordTime
	 */
	public void setRecordTime(int recordTime) {
		this.recordTime = recordTime;
	}

	/**
	 * @Description 获得 saveSign
	 */
	public int getSaveSign() {
		return saveSign;
	}

	/**
	 * @Description:设置 saveSign
	 */
	public void setSaveSign(int saveSign) {
		this.saveSign = saveSign;
	}

	/**
	 * @Description 获得 frequencySamplingRate
	 */
	public int getFrequencySamplingRate() {
		return frequencySamplingRate;
	}

	/**
	 * @Description:设置 frequencySamplingRate
	 */
	public void setFrequencySamplingRate(int frequencySamplingRate) {
		this.frequencySamplingRate = frequencySamplingRate;
	}

	public T808_0x8804() {
	}

}
