package com.et.terminalserver.api.model.ext;

/**
 * @Description 组织机构信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:04:08
 * @mail terrorbladeyang@gmail.com
 */

public class SOrgInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7499808892580882799L;
	/**
	 * 地址
	 */

	private String address;
	/**
	 * 所在城市编码
	 */

	private int cityId;
	/**
	 * 联系人
	 */

	private String contacter;
	/**
	 * 单位ERP中编号
	 */

	private String gerpCode;
	/**
	 * 单位名称
	 */

	private String orgName;
	/**
	 * 单位编号
	 */

	private String orgCode;
	/**
	 * 单位ID
	 */

	private long orgId;
	/**
	 * 经度
	 */

	private double lat;
	/**
	 * 纬度
	 */

	private double lon;
	/**
	 * 排序号
	 */

	private int indexId;

	/**
	 * 是否隐藏
	 * 
	 * @return
	 */

	private Integer isHide;

	/**
	 * 父单位ID
	 */
	private long fOrgId;
	/**
	 * 联系人手机号
	 */
	private String phone;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContacter() {
		return contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
	}

	public String getGerpCode() {
		return gerpCode;
	}

	public void setGerpCode(String gerpCode) {
		this.gerpCode = gerpCode;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	public int getIsHide() {
		return isHide;
	}

	public void setIsHide(int isHide) {
		this.isHide = isHide;
	}

	public long getfOrgId() {
		return fOrgId;
	}

	public void setfOrgId(long fOrgId) {
		this.fOrgId = fOrgId;
	}

	public void setIsHide(Integer isHide) {
		this.isHide = isHide;
	}
	
	@Override
	public boolean equals(Object obj){
		return this.orgId==((SOrgInfo)obj).orgId;
	}

	@Override
	public int hashCode(){
		return this.toString().hashCode();
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "SOrgInfo [address=" + address + ", cityId=" + cityId + ", contacter=" + contacter + ", gerpCode="
				+ gerpCode + ", orgName=" + orgName + ", orgCode=" + orgCode + ", orgId=" + orgId + ", lat=" + lat
				+ ", lon=" + lon + ", indexId=" + indexId + ", isHide=" + isHide + ", fOrgId=" + fOrgId + "]";
	}

	

}
