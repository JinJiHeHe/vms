package com.et.terminalserver.api.model.ext;
import java.io.Serializable;

/**
 * 驾驶员信息
 *
 */
public class SDriverInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7871599932465886139L;

	private Integer userId;

	private Integer status;

	private String phone;

	private String mobilePhone;

	private String email;

	private Integer driverId;

	private String orgCode;

	private String driverIdCode;

	private String driverName;

	private String qualificationCode;

	private String qualificationOrg;

	private Integer flag;

	/**
	 * userId
	 * 
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Status:#状态，如果添加了叫在职，如果删除叫离职，实现假删除
	 * 
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Status:#状态，如果添加了叫在职，如果删除叫离职，实现假删除
	 * 
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Phone:办公电话
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Phone:办公电话
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * MobilePhone:移动电话
	 * 
	 * @return
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * MobilePhone:移动电话
	 * 
	 * @param mobilePhone
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * Email:EMAIL
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Email:EMAIL
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * DriverId:驾驶人员id
	 * 
	 * @return
	 */
	public Integer getDriverId() {
		return driverId;
	}

	/**
	 * DriverId:驾驶人员id
	 * 
	 * @param driverId
	 */
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	/**
	 * OrgCode:组织机构号
	 * 
	 * @return
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * OrgCode:组织机构号
	 * 
	 * @param orgCode
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * DriverIdCode:身份证号
	 * 
	 * @return
	 */
	public String getDriverIdCode() {
		return driverIdCode;
	}

	/**
	 * DriverIdCode:身份证号
	 * 
	 * @param driverIdCode
	 */
	public void setDriverIdCode(String driverIdCode) {
		this.driverIdCode = driverIdCode;
	}

	/**
	 * DriverName:驾驶员姓名
	 * 
	 * @return
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * DriverName:驾驶员姓名
	 * 
	 * @param driverName
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * QualificationCode:从业资格证编号
	 * 
	 * @return
	 */
	public String getQualificationCode() {
		return qualificationCode;
	}

	/**
	 * QualificationCode:从业资格证编号
	 * 
	 * @param qualificationCode
	 */
	public void setQualificationCode(String qualificationCode) {
		this.qualificationCode = qualificationCode;
	}

	/**
	 * QulificationOrg:从业资格证颁发机构
	 * 
	 * @return
	 */
	public String getQualificationOrg() {
		return qualificationOrg;
	}

	/**
	 * QulificationOrg:从业资格证颁发机构
	 * 
	 * @param qualificationOrg
	 */
	public void setQualificationOrg(String qualificationOrg) {
		this.qualificationOrg = qualificationOrg;
	}

	/**
	 * 是否是黑名单 0：不属于黑名单；1：属于黑名单
	 * 
	 * @return
	 */
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "SDriverInfo [userId=" + userId + ", status=" + status + ", phone=" + phone + ", mobilePhone="
				+ mobilePhone + ", email=" + email + ", driverId=" + driverId + ", orgCode=" + orgCode
				+ ", driverIdCode=" + driverIdCode + ", driverName=" + driverName + ", qualificationCode="
				+ qualificationCode + ", qualificationOrg=" + qualificationOrg + ",flag=" + flag + "]";
	}

}
