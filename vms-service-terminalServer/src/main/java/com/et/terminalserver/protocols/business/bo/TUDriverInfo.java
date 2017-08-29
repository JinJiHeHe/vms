package com.et.terminalserver.protocols.business.bo;

import java.util.Date;

/**
 * @Description 驾驶员信息上报实体类
 * @author jakiro
 * @version V1.0
 * @Date 2016年7月18日 下午10:11:50
 * @mail terrorbladeyang@gmail.com
 */
public class TUDriverInfo extends BusinessObject {

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
	
	private String vid;

	public String getICardTime() {
		return ICardTime;
	}

	public void setICardTime(String iCardTime) {
		ICardTime = iCardTime;
	}

	public String getECardTime() {
		return ECardTime;
	}

	public void setECardTime(String eCardTime) {
		ECardTime = eCardTime;
	}

	public int getDriverNameLength() {
		return driverNameLength;
	}

	public void setDriverNameLength(int driverNameLength) {
		this.driverNameLength = driverNameLength;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverIdCode() {
		return driverIdCode;
	}

	public void setDriverIdCode(String driverIdCode) {
		this.driverIdCode = driverIdCode;
	}

	public String getQualificationCode() {
		return qualificationCode;
	}

	public void setQualificationCode(String qualificationCode) {
		this.qualificationCode = qualificationCode;
	}

	public int getCertificationOrgLength() {
		return certificationOrgLength;
	}

	public void setCertificationOrgLength(int certificationOrgLength) {
		this.certificationOrgLength = certificationOrgLength;
	}

	public String getCertificationOrg() {
		return certificationOrg;
	}

	public void setCertificationOrg(String certificationOrg) {
		this.certificationOrg = certificationOrg;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getVechile(){
		return vid;
	}
	
	public void setVechile(String vid){
		this.vid = vid;
	}
	
	@Override
	public int getBusinessCode() {
		return TD_DRIVERINFO;
	}
}
