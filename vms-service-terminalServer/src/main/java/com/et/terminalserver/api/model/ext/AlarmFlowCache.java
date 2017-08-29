package com.et.terminalserver.api.model.ext;

import java.util.Arrays;

/**
 * @Description 报警工作流信息
 * @author maple
 * @version V1.0
 * @Date 2016年4月7日下午8:27:26
 * @mail rw222222@126.com
 */
public class AlarmFlowCache implements java.io.Serializable {
	private static final long serialVersionUID = 6410137202538223923L;
	/**
	 * 单位流程
	 */
	private String orgFlow;
	/**
	 * 总等级
	 */
	private String totalLevel;
	/**
	 * 明细
	 */
	private String[] details;
	/**
	 * 升级时间
	 */
	private long[] levelTime;

	/**
	 * 单位流程
	 */
	public String getOrgFlow() {
		return orgFlow;
	}

	/**
	 * 单位流程
	 */
	public void setOrgFlow(String orgFlow) {
		this.orgFlow = orgFlow;
	}

	/**
	 * 总等级
	 */
	public String getTotalLevel() {
		return totalLevel;
	}

	/**
	 * 总等级
	 */
	public void setTotalLevel(String totalLevel) {
		this.totalLevel = totalLevel;
	}

	/**
	 * 明细
	 */
	public String[] getDetails() {
		return details;
	}

	/**
	 * 明细
	 */
	public void setDetails(String[] details) {
		this.details = details;
	}

	/**
	 * 升级时间
	 */
	public long[] getLevelTime() {
		return levelTime;
	}

	/**
	 * 升级时间
	 */
	public void setLevelTime(long[] levelTime) {
		this.levelTime = levelTime;
	}

	@Override
	public String toString() {
		return "AlarmFlowCache [orgFlow=" + orgFlow + ", totalLevel="
				+ totalLevel + ", details=" + details + ", levelTime="
				+ Arrays.toString(levelTime) + "]";
	}

}
