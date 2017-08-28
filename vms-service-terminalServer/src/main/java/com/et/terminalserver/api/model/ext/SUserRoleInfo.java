package com.et.terminalserver.api.model.ext;

/**
 * 用户角色信息
 * @author Administrator
 *
 */
public class SUserRoleInfo {
	/**
	 * 用户角色ID
	 */
	private Integer userRoleId;
	/**
	 * 用户ID
	 */
	private Integer userId;
	/**
	 * 用户编号
	 */
	private String userCode;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 角色编号
	 */
	private String orgCode;
	/**
	 * 角色名
	 */
	private String orgName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 密码过期
	 */
	private Long passwordExpire;
	/**
	 * 角色ID
	 */
	private Integer roleId;
	/**
	 * 角色名
	 */
	private String roleName;
	/**
	 * 司机ID
	 */
	private Integer driverId;
	/**
	 * 权限ID
	 */
	private String rightCode;
	
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPasswordExpire() {
		return passwordExpire;
	}
	public void setPasswordExpire(Long passwordExpire) {
		this.passwordExpire = passwordExpire;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getDriverId() {
		return driverId;
	}
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	public String getRightCode() {
		return rightCode;
	}
	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}
}
