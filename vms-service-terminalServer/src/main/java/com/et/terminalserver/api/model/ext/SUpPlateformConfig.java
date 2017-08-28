package com.et.terminalserver.api.model.ext;
import java.io.Serializable;
import java.util.HashSet;


/**
 * @Description 上级平台配置实体类
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:05:09
 * @mail terrorbladeyang@gmail.com
 */

public class SUpPlateformConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2338018198197198847L;

	private Integer plateformId;

	private String plateformName;

	private String upperIp;

	private Integer upperPort;

	private String user;

	private String password;

	private String status;

	private String localIp;

	private Integer localPort;

	private HashSet<Integer> vehicleIdList;

	private String accessCode;

	private Integer encryptM1;

	private Integer encryptIA1;

	private Integer encryptIC1;

	/**
	 * 平台ID
	 * 
	 * @return
	 */

	/**
	 * 平台名
	 * 
	 * @return
	 */
	public String getPlateformName() {
		return plateformName;
	}

	public void setPlateformName(String plateformName) {
		this.plateformName = plateformName;
	}

	/**
	 * 用户名
	 * 
	 * @return
	 */
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 密码
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 连接状态
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 上报车辆列表
	 * 
	 * @return
	 */
	public HashSet<Integer> getVehicleIdList() {
		return vehicleIdList;
	}

	public void setVehicleIdList(HashSet<Integer> vehicleIdList) {
		this.vehicleIdList = vehicleIdList;
	}

	/**
	 * 上级平台ip
	 * 
	 * @return
	 */
	public String getUpperIp() {
		return upperIp;
	}

	public void setUpperIp(String upperIp) {
		this.upperIp = upperIp;
	}

	/**
	 * 上级平台端口
	 * 
	 * @return
	 */

	/**
	 * 本地平台IP
	 * 
	 * @return
	 */
	public String getLocalIp() {
		return localIp;
	}

	public Integer getPlateformId() {
		return plateformId;
	}

	public void setPlateformId(Integer plateformId) {
		this.plateformId = plateformId;
	}

	public Integer getUpperPort() {
		return upperPort;
	}

	public void setUpperPort(Integer upperPort) {
		this.upperPort = upperPort;
	}

	public Integer getLocalPort() {
		return localPort;
	}

	public void setLocalPort(Integer localPort) {
		this.localPort = localPort;
	}

	public void setLocalIp(String localIp) {
		this.localIp = localIp;
	}

	/**
	 * 本地平台端口
	 * 
	 * @return
	 */

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public Integer getEncryptM1() {
		return encryptM1;
	}

	public void setEncryptM1(Integer encryptM1) {
		this.encryptM1 = encryptM1;
	}

	public Integer getEncryptIA1() {
		return encryptIA1;
	}

	public void setEncryptIA1(Integer encryptIA1) {
		this.encryptIA1 = encryptIA1;
	}

	public Integer getEncryptIC1() {
		return encryptIC1;
	}

	public void setEncryptIC1(Integer encryptIC1) {
		this.encryptIC1 = encryptIC1;
	}

	@Override
	public String toString() {
		return "SUpPlateformConfig [plateformId=" + plateformId + ", plateformName=" + plateformName + ", upperIp="
				+ upperIp + ", upperPort=" + upperPort + ", user=" + user + ", password=" + password + ", status="
				+ status + ", localIp=" + localIp + ", localPort=" + localPort + ", vehicleIdList=" + vehicleIdList
				+ ", accessCode=" + accessCode + ", encryptM1=" + encryptM1 + ", encryptIA1=" + encryptIA1
				+ ", encryptIC1=" + encryptIC1 + "]";
	}

}
