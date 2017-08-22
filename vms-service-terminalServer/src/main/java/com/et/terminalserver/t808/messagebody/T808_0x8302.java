package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8302
 * @Description: 提问下发
 * @author: lijz
 * @date: 2014年4月17日 上午11:48:04
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8302 extends T808_MessageBody {

	private int mark; // 0 标志 BYTE 提问下发标志喂定义见表32
	private String questionData;// 2 问题 STRING 问题文本，经GBK编码，长度为N
	private List<String> listKey;// 2-N 候选答案列友 候选答案消息组成见表33

	/**
	 * @Description 获得 mark
	 */
	public int getMark() {
		return mark;
	}

	/**
	 * @Description:设置 mark
	 */
	public void setMark(int mark) {
		this.mark = mark;
	}

	/**
	 * @Description 获得 problem
	 */
	public String getQuestionData() {
		return questionData;
	}

	/**
	 * @Description:设置 problem
	 */
	public void setQuestionData(String questionData) {
		this.questionData = questionData;
	}

	/**
	 * @Description 获得 listKey
	 */
	public List<String> getListKey() {
		return listKey;
	}

	public T808_0x8302() {
		this.listKey = new ArrayList<String>();
	}

}
