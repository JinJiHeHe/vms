package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * @Description 系统配置信息实体类
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:04:23
 * @mail terrorbladeyang@gmail.com
 */

public class SSysconfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 配置名称
	 */

	private String configName="";
	/**
	 * 配置值
	 */

	private String configValue="";
	/**
	 * 配置注释
	 */

	private String configComment="";
	/**
	 * 配置组
	 */

	private String configGroup="";
	/**
	 * 记录时间
	 */

	private java.sql.Timestamp recordTime;
	/**
	 * 系统配置ID
	 */

	private Integer sysConfigureId=0;

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getConfigComment() {
		return configComment;
	}

	public void setConfigComment(String configComment) {
		this.configComment = configComment;
	}

	public String getConfigGroup() {
		return configGroup;
	}

	public void setConfigGroup(String configGroup) {
		this.configGroup = configGroup;
	}

	public java.sql.Timestamp getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(java.sql.Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	public Integer getSysConfigureId() {
		return sysConfigureId;
	}

	public void setSysConfigureId(Integer sysConfigureId) {
		this.sysConfigureId = sysConfigureId;
	}

	@Override
	public String toString() {
		return "SSysconfig [configName=" + configName + ", configValue=" + configValue + ", configComment="
				+ configComment + ", configGroup=" + configGroup + ", recordTime=" + recordTime + ", sysConfigureId="
				+ sysConfigureId + "]";
	}

}
