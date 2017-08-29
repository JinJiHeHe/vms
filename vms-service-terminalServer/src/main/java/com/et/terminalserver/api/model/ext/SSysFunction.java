package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 系统功能信息实体类
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:04:38
 * @mail terrorbladeyang@gmail.com
 */

public class SSysFunction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 622749626847013665L;
	/**
	 * 功能编号
	 */

	private BigDecimal functionId;
	/**
	 * 功能名称
	 */

	private String functionName;
	/**
	 * url
	 */

	private String url;
	/**
	 * 父功能编号
	 */

	private BigDecimal fFunctionId;
	/**
	 * 操作序号
	 */

	private BigDecimal operation;
	/**
	 * 是否记录日志
	 */

	private BigDecimal isLog;
	/**
	 * 是否是子功能
	 */

	private BigDecimal isSon;

	public BigDecimal getFunctionId() {
		return functionId;
	}

	public void setFunctionId(BigDecimal functionId) {
		this.functionId = functionId;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getfFunctionId() {
		return fFunctionId;
	}

	public void setfFunctionId(BigDecimal fFunctionId) {
		this.fFunctionId = fFunctionId;
	}

	public BigDecimal getOperation() {
		return operation;
	}

	public void setOperation(BigDecimal operation) {
		this.operation = operation;
	}

	public BigDecimal getIsLog() {
		return isLog;
	}

	public void setIsLog(BigDecimal isLog) {
		this.isLog = isLog;
	}

	public BigDecimal getIsSon() {
		return isSon;
	}

	public void setIsSon(BigDecimal isSon) {
		this.isSon = isSon;
	}

	@Override
	public String toString() {
		return "SSysFunction [functionId=" + functionId + ", functionName=" + functionName + ", url=" + url
				+ ", fFunctionId=" + fFunctionId + ", operation=" + operation + ", isLog=" + isLog + ", isSon=" + isSon
				+ "]";
	}
}
