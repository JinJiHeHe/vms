package com.et.terminalserver.api.model.ext;


/**
 * @Description 监管配置
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:58:36
 * @mail terrorbladeyang@gmail.com
 */

@Deprecated
public class DRegulatoryConf implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8532015159562567066L;

	private Integer regulatoryId;// 监管编号

	private String superiorplatformIp;// 接入上级平台IP

	private Integer superiorplatformPort;// 接入上级平台端口号

	private int operator;// 操作类型 0 为断开， 1 为连接

	public Integer getRegulatoryId() {
		return regulatoryId;
	}

	public void setRegulatoryId(Integer regulatoryId) {
		this.regulatoryId = regulatoryId;
	}

	public String getSuperiorplatformIp() {
		return superiorplatformIp;
	}

	public void setSuperiorplatformIp(String superiorplatformIp) {
		this.superiorplatformIp = superiorplatformIp;
	}

	public Integer getSuperiorplatformPort() {
		return superiorplatformPort;
	}

	public void setSuperiorplatformPort(Integer superiorplatformPort) {
		this.superiorplatformPort = superiorplatformPort;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "DRegulatoryConf [regulatoryId=" + regulatoryId + ", superiorplatformIp=" + superiorplatformIp
				+ ", superiorplatformPort=" + superiorplatformPort + ", operator=" + operator + "]";
	}

}
