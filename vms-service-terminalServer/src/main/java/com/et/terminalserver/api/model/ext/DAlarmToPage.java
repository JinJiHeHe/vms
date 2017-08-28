package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * @Description 页面报警推送实体类
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:43:21
 * @mail terrorbladeyang@gmail.com
 */
public class DAlarmToPage implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -5942070385219318763L;

	/**
	 * 组织机构
	 */
	private String orgCode; // 报警车辆的组织机构
	/**
	 * 报警信息
	 */
	private TreeMap<String, String> alarmMap;

	
	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public TreeMap<String, String> getAlarmMap() {
		return alarmMap;
	}

	public void setAlarmMap(TreeMap<String, String> alarmMap) {
		this.alarmMap = alarmMap;
	}

	@Override
	public String toString() {
		return "DAlarmToPage [orgCode=" + orgCode + ", alarmMap=" + alarmMap
				+ "]";
	}

}
