package com.et.terminalserver.api.model.ext;

/**
 * @Description UserInfo
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:05:42
 * @mail terrorbladeyang@gmail.com
 */

public class SUserInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4434693069127340323L;
	/**
	 * 用户编号
	 */

	private String userCode;
	/**
	 * 用户ERP编号
	 */

	private String userErpCode;
	/**
	 * 单位编号
	 */

	private String orgCode;
	/**
	 * 单位ERP编号
	 */

	private String gerpCode;
	/**
	 * 真实姓名
	 */

	private String userName;
	/**
	 * 用户类型
	 */

	private String userType;
	/**
	 * 状态
	 */

	private Integer status;
	/**
	 * 办公电话
	 */

	private String phone;
	/**
	 * 移动电话
	 */

	private String mobilePhone;
	/**
	 * EMAIL
	 */

	private String email;
	/**
	 * 用户ID
	 */

	private Integer userId;
	/**
	 * 单位ID
	 */

	private Integer orgId;
	/**
	 * 单位名称
	 */

	private String orgName;
	
	/**
	 * 密码
	 */
	private String password;
	

	private String serialNo;
	
	/**
	 * 司机ID
	 */
	private String driverId;
	
	/**
	 * 密码过期时间
	 */
	private long passwdExpire;
	
	/**
	 * 用户编号
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 用户编号
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 用户ERP编号
	 */
	public String getUserErpCode() {
		return userErpCode;
	}

	/**
	 * 用户ERP编号
	 */
	public void setUserErpCode(String userErpCode) {
		this.userErpCode = userErpCode;
	}

	/**
	 * 单位编号
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * 单位编号
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * 单位ERP编号
	 */
	public String getGerpCode() {
		return gerpCode;
	}

	/**
	 * 单位ERP编号
	 */
	public void setGerpCode(String gerpCode) {
		this.gerpCode = gerpCode;
	}

	/**
	 * 真实姓名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 真实姓名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 用户类型
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 用户类型
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * 状态
	 * 
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 状态
	 * 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 办公电话
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 办公电话
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 移动电话
	 * 
	 * @return
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * 移动电话
	 * 
	 * @param mobilePhone
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * Email
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * USER ID
	 * 
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * USER ID
	 * 
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * ORG ID
	 * 
	 * @return
	 */
	public Integer getOrgId() {
		return orgId;
	}

	/**
	 * ORG ID
	 * 
	 * @param orgId
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	/**
	 * ORG NAME
	 * 
	 * @return
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * ORG NAME
	 * 
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	
	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public long getPasswdExpire() {
		return passwdExpire;
	}

	public void setPasswdExpire(long passwdExpire) {
		this.passwdExpire = passwdExpire;
	}

	@Override
	public String toString() {
		return "SUserInfo [userCode=" + userCode + ", userErpCode=" + userErpCode + ", orgCode=" + orgCode
				+ ", gerpCode=" + gerpCode + ", userName=" + userName + ", userType=" + userType + ", status=" + status
				+ ", phone=" + phone + ", mobilePhone=" + mobilePhone + ", email=" + email + ", userId=" + userId
				+ ", orgId=" + orgId + ", orgName=" + orgName + "]";
	}

}
