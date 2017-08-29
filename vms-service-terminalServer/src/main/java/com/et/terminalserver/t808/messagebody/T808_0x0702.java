package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0702
 * @Description: 驾驶员身份信息采集上报
 * @author: guanhl
 * @date: 2014年7月28日 下午5:53:35
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0702 extends T808_MessageBody {
	// 0 驾驶员姓名长度 BYTE
	// 1 驾驶员姓名 STRING 驾驶员姓名，长度n
	// 1+n 驾驶员身份证编码 STRING 长度20位
	// 21+n 从业资格证编码 STRING 长度40位
	// 61+n 发证机构名称民度 BYTE 长度m
	// 61+n+m 发证机构名称 STRING 从业资格证发证机构名称
	private String ICardTime;// 插卡时间
	private String ECardTime;// 拔卡时间
	private int driverNameLength;// 驾驶员姓名长度
	private String driverName;// 驾驶员姓名
	private String driverIdCode;// 驾驶员身份证编码
	private String qualificationCode;// 从业资格证编码
	private int certificationOrgLength;// 发证机构名称民度(长度)
	private String certificationOrg;// 发证机构名称
	private Date time;// 上传时间
	private String validDate;
	

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	/**
	 * @Description 获得 iCardTime
	 */
	public String getICardTime() {
		return ICardTime;
	}

	/**
	 * @Description:设置 iCardTime
	 */
	public void setICardTime(String iCardTime) {
		ICardTime = iCardTime;
	}

	/**
	 * @Description 获得 eCardTime
	 */
	public String getECardTime() {
		return ECardTime;
	}

	/**
	 * @Description:设置 eCardTime
	 */
	public void setECardTime(String eCardTime) {
		ECardTime = eCardTime;
	}

	/**
	 * @Description 获得 driverNameLength
	 */
	public int getDriverNameLength() {
		return driverNameLength;
	}

	/**
	 * @Description:设置 driverNameLength
	 */
	public void setDriverNameLength(int driverNameLength) {
		this.driverNameLength = driverNameLength;
	}

	/**
	 * @Description 获得 driverName
	 */
	public String getDriverName() {
		return driverName;
	}

	/**
	 * @Description:设置 driverName
	 */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * @Description 获得 driverIdCode
	 */
	public String getDriverIdCode() {
		return driverIdCode;
	}

	/**
	 * @Description:设置 driverIdCode
	 */
	public void setDriverIdCode(String driverIdCode) {
		this.driverIdCode = driverIdCode;
	}

	/**
	 * @Description 获得 qualificationCode
	 */
	public String getQualificationCode() {
		return qualificationCode;
	}

	/**
	 * @Description:设置 qualificationCode
	 */
	public void setQualificationCode(String qualificationCode) {
		this.qualificationCode = qualificationCode;
	}

	/**
	 * @Description 获得 certificationOrgLength
	 */
	public int getCertificationOrgLength() {
		return certificationOrgLength;
	}

	/**
	 * @Description:设置 certificationOrgLength
	 */
	public void setCertificationOrgLength(int certificationOrgLength) {
		this.certificationOrgLength = certificationOrgLength;
	}

	/**
	 * @Description 获得 certificationOrg
	 */
	public String getCertificationOrg() {
		return certificationOrg;
	}

	/**
	 * @Description:设置 certificationOrg
	 */
	public void setCertificationOrg(String certificationOrg) {
		this.certificationOrg = certificationOrg;
	}

	/**
	 * @Description 获得 time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @Description:设置 time
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	public T808_0x0702() {
	}

}
