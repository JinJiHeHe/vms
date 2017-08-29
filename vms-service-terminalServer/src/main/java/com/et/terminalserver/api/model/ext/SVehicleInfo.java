package com.et.terminalserver.api.model.ext;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Description 车辆基本信息表
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午4:06:00
 * @mail terrorbladeyang@gmail.com
 */

public class SVehicleInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5509275048569955468L;
	/**
	 * 组织机构编号
	 */

	private String orgCode;
	/**
	 * 车辆ID，为了保持整洁，统一8位，从10000000开始计算
	 */

	private Integer vehicleId;
	/**
	 * 终端编号
	 */

	// TODO LONG
	private Integer terminalId;
	/**
	 * 车牌号
	 */

	private String idNumber;
	/**
	 * #车辆种类，字典项
	 */

	private Integer typeId;
	/**
	 * #车型，字典项
	 */

	private Integer modelId;
	/**
	 * 用途
	 */

	private Integer usageId;
	/**
	 * 品牌
	 */

	private Integer trademarkId;
	/**
	 * 车辆类型
	 */

	private String pattern;
	/**
	 * 地域属性
	 */

	private Integer regionProperty;
	/**
	 * 车身颜色
	 */

	private String colorId;
	/**
	 * 车牌颜色
	 */

	private String colorIdNumberId;
	/**
	 * 引擎类型
	 */

	private String engineType;
	/**
	 * 引擎编号
	 */

	private String engineNumber;
	/**
	 * 车辆识别代号
	 */

	private String frameNumber;
	/**
	 * 是否进口
	 */

	private Integer isImport;
	/**
	 * 燃油类型
	 */

	private Integer fuelType;
	/**
	 * 排量
	 */

	private Integer displacement;
	/**
	 * 发动机功率
	 */

	private String displacementEnginepower;
	/**
	 * 生产厂家
	 */

	private String factoryId;
	/**
	 * 总质量
	 */

	private Integer totalmass;
	/**
	 * 核定载质量Kg标记吨位
	 */

	private Integer authorizedPayMass;
	/**
	 * 空车质量Kg
	 */

	private Integer payLoad;
	/**
	 * 空车质量Kg
	 */

	private Integer kerbWeight;
	/**
	 * 是否报废
	 */

	private Integer scrapped;
	/**
	 * 营运性质
	 */

	private Integer serviceType;

	/**
	 * 初期里程
	 */

	private Integer initWorkLoad;
	/**
	 * 罐体材质
	 */

	private String tinmaterial;
	/**
	 * 核定载客
	 */

	private Integer authorizedCapacity;
	/**
	 * 驾驶室载客
	 */

	private Integer cabCapacity;
	/**
	 * 罐体容积（立方米）
	 */

	private Integer oilCanCapacity;
	/**
	 * 车属性质
	 */

	private Integer transportType;
	/**
	 * 车挂号
	 */

	private String tractorNumber;
	/**
	 * 油料重车定额
	 */

	private Integer loadingFuel;
	/**
	 * 油料空车定额
	 */

	private Integer unloadingFuel;
	/**
	 * 行使证号
	 */

	private String travelLicence;
	/**
	 * 行使证号
	 */

	private Timestamp travelExpired;
	/**
	 * 有效时间，行使证有效结束时间
	 */

	private String travelPhotoUrls;
	/**
	 * 有效时间，行使证有效结束时间
	 */

	private Timestamp productDate;
	/**
	 * 行使证小图
	 */

	private Timestamp buyDate;
	/**
	 * 出厂时间
	 */

	private Integer vehicleExpired;
	/**
	 * 最近年检时间
	 */

	private Timestamp yearInspection;
	/**
	 * 年检有效期
	 */

	private Timestamp yearInspectExpired;
	/**
	 * 最近交强险时间
	 */

	private Timestamp payHighInsuranceDate;
	/**
	 * 交强险有效期
	 */

	private Timestamp payHighInsuranceExpired;
	/**
	 * 最近商业险时间
	 */

	private Timestamp businessInsuranceDate;
	/**
	 * 商业险有效期
	 */

	private Timestamp businessInsuranceExpired;
	/**
	 * 带下装油系统（是/否）
	 */

	private Integer withPump;
	/**
	 * 终端型号
	 */

	private String gpsModel;
	/**
	 * 车牌助记号
	 */

	private String shortCode;
	/**
	 * 是否带泵
	 */

	private Integer withOilPump;
	/**
	 * 发证机构
	 */

	private String issuingOrgans;
	/**
	 * 道路运输许可证
	 */

	private String transportPermits;
	/**
	 * 有效时间，运输许可证有效结束时间
	 */

	private Timestamp transportExpired;
	/**
	 * 运输许可证小图
	 */

	private String transportPhotoUrls;
	/**
	 * 运输行业类别
	 */

	private Integer transportationType;
	/**
	 * #车辆状态，0不在线；1在线
	 */

	private Integer vehicleStatus;
	/**
	 * 回传时间，单位：秒,缺省默认30秒
	 */

	private Integer rinterval;
	/**
	 * 预警限速值，单位：公里/秒
	 */

	private Double warningSpeed;
	/**
	 * 主驾ID
	 */

	private Integer pDriverId;
	/**
	 * 副驾ID
	 */

	private Integer sDriverId;

	/**
	 * 报警限速值，单位：公里/秒
	 */
	private Double speed;
	/**
	 * 押运员ID
	 */

	private String supercargoId;
	/**
	 * #数据来源：V-车辆终端；F-地区平台
	 */

	private String dataFrom;
	/**
	 * 备注
	 */

	private String remark;
	/**
	 * #标志位：A-审核，经过了审核，可以正常使用； N-新的，新增加的数据，需要审批数据，开始都是N； D-删除，被假删除数据；
	 */

	private String tag;
	/**
	 * 车库信息，主要为回车登记时一个比对用，来自业务点
	 */

	private Integer parkingId;

	// from other table...
	/**
	 * 单位名称
	 */

	private String orgName;
	/**
	 * 终端编号
	 */

	private String terminalCode;
	/**
	 * SIM编号
	 */

	private String simNum;
	/**
	 * 主驾驶员
	 */

	private String driverName;
	/**
	 * 功能编码
	 */

	private String functionCode;
	// 终端类型名

	private String terminalName;
	// 驾驶员手机号

	private String driverPhone;

	// 终端报警限速

	private Double TerAlarmSpeed;

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Integer terminalId) {
		this.terminalId = terminalId;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getUsageId() {
		return usageId;
	}

	public void setUsageId(Integer usageId) {
		this.usageId = usageId;
	}

	public Integer getTrademarkId() {
		return trademarkId;
	}

	public void setTrademarkId(Integer trademarkId) {
		this.trademarkId = trademarkId;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Integer getRegionProperty() {
		return regionProperty;
	}

	public void setRegionProperty(Integer regionProperty) {
		this.regionProperty = regionProperty;
	}

	public String getColorIdNumberId() {
		return colorIdNumberId;
	}

	public void setColorIdNumberId(String colorIdNumberId) {
		this.colorIdNumberId = colorIdNumberId;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getFrameNumber() {
		return frameNumber;
	}

	public void setFrameNumber(String frameNumber) {
		this.frameNumber = frameNumber;
	}

	public Integer getIsImport() {
		return isImport;
	}

	public void setIsImport(Integer isImport) {
		this.isImport = isImport;
	}

	public Integer getFuelType() {
		return fuelType;
	}

	public void setFuelType(Integer fuelType) {
		this.fuelType = fuelType;
	}

	public Integer getDisplacement() {
		return displacement;
	}

	public void setDisplacement(Integer displacement) {
		this.displacement = displacement;
	}

	public String getDisplacementEnginepower() {
		return displacementEnginepower;
	}

	public void setDisplacementEnginepower(String displacementEnginepower) {
		this.displacementEnginepower = displacementEnginepower;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public Integer getTotalmass() {
		return totalmass;
	}

	public void setTotalmass(Integer totalmass) {
		this.totalmass = totalmass;
	}

	public Integer getAuthorizedPayMass() {
		return authorizedPayMass;
	}

	public void setAuthorizedPayMass(Integer authorizedPayMass) {
		this.authorizedPayMass = authorizedPayMass;
	}

	public Integer getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(Integer payLoad) {
		this.payLoad = payLoad;
	}

	public Integer getKerbWeight() {
		return kerbWeight;
	}

	public void setKerbWeight(Integer kerbWeight) {
		this.kerbWeight = kerbWeight;
	}

	public Integer getScrapped() {
		return scrapped;
	}

	public void setScrapped(Integer scrapped) {
		this.scrapped = scrapped;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getInitWorkLoad() {
		return initWorkLoad;
	}

	public void setInitWorkLoad(Integer initWorkLoad) {
		this.initWorkLoad = initWorkLoad;
	}

	public String getTinmaterial() {
		return tinmaterial;
	}

	public void setTinmaterial(String tinmaterial) {
		this.tinmaterial = tinmaterial;
	}

	public Integer getAuthorizedCapacity() {
		return authorizedCapacity;
	}

	public void setAuthorizedCapacity(Integer authorizedCapacity) {
		this.authorizedCapacity = authorizedCapacity;
	}

	public Integer getCabCapacity() {
		return cabCapacity;
	}

	public void setCabCapacity(Integer cabCapacity) {
		this.cabCapacity = cabCapacity;
	}

	public Integer getOilCanCapacity() {
		return oilCanCapacity;
	}

	public void setOilCanCapacity(Integer oilCanCapacity) {
		this.oilCanCapacity = oilCanCapacity;
	}

	public Integer getTransportType() {
		return transportType;
	}

	public void setTransportType(Integer transportType) {
		this.transportType = transportType;
	}

	public String getTractorNumber() {
		return tractorNumber;
	}

	public void setTractorNumber(String tractorNumber) {
		this.tractorNumber = tractorNumber;
	}

	public Integer getLoadingFuel() {
		return loadingFuel;
	}

	public void setLoadingFuel(Integer loadingFuel) {
		this.loadingFuel = loadingFuel;
	}

	public Integer getUnloadingFuel() {
		return unloadingFuel;
	}

	public void setUnloadingFuel(Integer unloadingFuel) {
		this.unloadingFuel = unloadingFuel;
	}

	public String getTravelLicence() {
		return travelLicence;
	}

	public void setTravelLicence(String travelLicence) {
		this.travelLicence = travelLicence;
	}

	public Timestamp getTravelExpired() {
		return travelExpired;
	}

	public void setTravelExpired(Timestamp travelExpired) {
		this.travelExpired = travelExpired;
	}

	public String getTravelPhotoUrls() {
		return travelPhotoUrls;
	}

	public void setTravelPhotoUrls(String travelPhotoUrls) {
		this.travelPhotoUrls = travelPhotoUrls;
	}

	public Timestamp getProductDate() {
		return productDate;
	}

	public void setProductDate(Timestamp productDate) {
		this.productDate = productDate;
	}

	public Timestamp getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Timestamp buyDate) {
		this.buyDate = buyDate;
	}

	public Integer getVehicleExpired() {
		return vehicleExpired;
	}

	public void setVehicleExpired(Integer vehicleExpired) {
		this.vehicleExpired = vehicleExpired;
	}

	public Timestamp getYearInspection() {
		return yearInspection;
	}

	public void setYearInspection(Timestamp yearInspection) {
		this.yearInspection = yearInspection;
	}

	public Timestamp getYearInspectExpired() {
		return yearInspectExpired;
	}

	public void setYearInspectExpired(Timestamp yearInspectExpired) {
		this.yearInspectExpired = yearInspectExpired;
	}

	public Timestamp getPayHighInsuranceDate() {
		return payHighInsuranceDate;
	}

	public void setPayHighInsuranceDate(Timestamp payHighInsuranceDate) {
		this.payHighInsuranceDate = payHighInsuranceDate;
	}

	public Timestamp getPayHighInsuranceExpired() {
		return payHighInsuranceExpired;
	}

	public void setPayHighInsuranceExpired(Timestamp payHighInsuranceExpired) {
		this.payHighInsuranceExpired = payHighInsuranceExpired;
	}

	public Timestamp getBusinessInsuranceDate() {
		return businessInsuranceDate;
	}

	public void setBusinessInsuranceDate(Timestamp businessInsuranceDate) {
		this.businessInsuranceDate = businessInsuranceDate;
	}

	public Timestamp getBusinessInsuranceExpired() {
		return businessInsuranceExpired;
	}

	public void setBusinessInsuranceExpired(Timestamp businessInsuranceExpired) {
		this.businessInsuranceExpired = businessInsuranceExpired;
	}

	public Integer getWithPump() {
		return withPump;
	}

	public void setWithPump(Integer withPump) {
		this.withPump = withPump;
	}

	public String getGpsModel() {
		return gpsModel;
	}

	public void setGpsModel(String gpsModel) {
		this.gpsModel = gpsModel;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public Integer getWithOilPump() {
		return withOilPump;
	}

	public void setWithOilPump(Integer withOilPump) {
		this.withOilPump = withOilPump;
	}

	public String getIssuingOrgans() {
		return issuingOrgans;
	}

	public void setIssuingOrgans(String issuingOrgans) {
		this.issuingOrgans = issuingOrgans;
	}

	public String getTransportPermits() {
		return transportPermits;
	}

	public void setTransportPermits(String transportPermits) {
		this.transportPermits = transportPermits;
	}

	public Timestamp getTransportExpired() {
		return transportExpired;
	}

	public void setTransportExpired(Timestamp transportExpired) {
		this.transportExpired = transportExpired;
	}

	public String getTransportPhotoUrls() {
		return transportPhotoUrls;
	}

	public void setTransportPhotoUrls(String transportPhotoUrls) {
		this.transportPhotoUrls = transportPhotoUrls;
	}

	public Integer getTransportationType() {
		return transportationType;
	}

	public void setTransportationType(Integer transportationType) {
		this.transportationType = transportationType;
	}

	public Integer getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(Integer vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public Integer getRinterval() {
		return rinterval;
	}

	public void setRinterval(Integer rinterval) {
		this.rinterval = rinterval;
	}

	public Double getWarningSpeed() {
		return warningSpeed;
	}

	public void setWarningSpeed(Double warningSpeed) {
		this.warningSpeed = warningSpeed;
	}

	public Integer getPDriverId() {
		return pDriverId;
	}

	public void setPDriverId(Integer pDriverId) {
		this.pDriverId = pDriverId;
	}

	public Integer getSDriverId() {
		return sDriverId;
	}

	public void setSDriverId(Integer sDriverId) {
		this.sDriverId = sDriverId;
	}

	public String getSupercargoId() {
		return supercargoId;
	}

	public void setSupercargoId(String supercargoId) {
		this.supercargoId = supercargoId;
	}

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getParkingId() {
		return parkingId;
	}

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public String getColorId() {
		return colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public String getSimNum() {
		return simNum;
	}

	public void setSimNum(String simNum) {
		this.simNum = simNum;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/**
	 * 功能编码
	 */
	public String getFunctionCode() {
		return functionCode;
	}

	/**
	 * 功能编码
	 */
	public void setFunctionCode(String functionCode) {
		// 2进制转16进制
		this.functionCode = functionCode;

		// this.functionCode = StartMgrUtil.binToHex(functionCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SVehicleInfo [orgCode=" + orgCode + ", vehicleId=" + vehicleId + ", terminalId=" + terminalId
				+ ", idNumber=" + idNumber + ", typeId=" + typeId + ", modelId=" + modelId + ", usageId=" + usageId
				+ ", trademarkId=" + trademarkId + ", pattern=" + pattern + ", regionProperty=" + regionProperty
				+ ", colorId=" + colorId + ", colorIdNumberId=" + colorIdNumberId + ", engineType=" + engineType
				+ ", engineNumber=" + engineNumber + ", frameNumber=" + frameNumber + ", isImport=" + isImport
				+ ", fuelType=" + fuelType + ", displacement=" + displacement + ", displacementEnginepower="
				+ displacementEnginepower + ", factoryId=" + factoryId + ", totalmass=" + totalmass
				+ ", authorizedPayMass=" + authorizedPayMass + ", payLoad=" + payLoad + ", kerbWeight=" + kerbWeight
				+ ", scrapped=" + scrapped + ", serviceType=" + serviceType + ", initWorkLoad=" + initWorkLoad
				+ ", tinmaterial=" + tinmaterial + ", authorizedCapacity=" + authorizedCapacity + ", cabCapacity="
				+ cabCapacity + ", oilCanCapacity=" + oilCanCapacity + ", transportType=" + transportType
				+ ", tractorNumber=" + tractorNumber + ", loadingFuel=" + loadingFuel + ", unloadingFuel="
				+ unloadingFuel + ", travelLicence=" + travelLicence + ", travelExpired=" + travelExpired
				+ ", travelPhotoUrls=" + travelPhotoUrls + ", productDate=" + productDate + ", buyDate=" + buyDate
				+ ", vehicleExpired=" + vehicleExpired + ", yearInspection=" + yearInspection + ", yearInspectExpired="
				+ yearInspectExpired + ", payHighInsuranceDate=" + payHighInsuranceDate + ", payHighInsuranceExpired="
				+ payHighInsuranceExpired + ", businessInsuranceDate=" + businessInsuranceDate
				+ ", businessInsuranceExpired=" + businessInsuranceExpired + ", withPump=" + withPump + ", gpsModel="
				+ gpsModel + ", shortCode=" + shortCode + ", withOilPump=" + withOilPump + ", issuingOrgans="
				+ issuingOrgans + ", transportPermits=" + transportPermits + ", transportExpired=" + transportExpired
				+ ", transportPhotoUrls=" + transportPhotoUrls + ", transportationType=" + transportationType
				+ ", vehicleStatus=" + vehicleStatus + ", rinterval=" + rinterval + ", warningSpeed=" + warningSpeed
				+ ", pDriverId=" + pDriverId + ", sDriverId=" + sDriverId + ", speed=" + speed + ", supercargoId="
				+ supercargoId + ", dataFrom=" + dataFrom + ", remark=" + remark + ", tag=" + tag + ", parkingId="
				+ parkingId + ", orgName=" + orgName + ", terminalCode=" + terminalCode + ", simNum=" + simNum
				+ ", driverName=" + driverName + ", functionCode=" + functionCode + ", terminalName=" + terminalName
				+ ", driverPhone=" + driverPhone + ", TerAlarmSpeed=" + TerAlarmSpeed + "]";
	}

	/**
	 * 终端报警限速
	 * 
	 * @return the terAlarmSpeed
	 */
	public Double getTerAlarmSpeed() {
		return TerAlarmSpeed;
	}

	/**
	 * 
	 * 终端报警限速
	 * 
	 * @param terAlarmSpeed
	 *            the terAlarmSpeed to set
	 */
	public void setTerAlarmSpeed(Double terAlarmSpeed) {
		TerAlarmSpeed = terAlarmSpeed;
	}

}
