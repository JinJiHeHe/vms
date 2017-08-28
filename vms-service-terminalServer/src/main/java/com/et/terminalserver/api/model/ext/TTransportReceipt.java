package com.et.terminalserver.api.model.ext;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: 运单信息
 * @Description: TTransportReceipt：运单信息
 * @author: chengjx
 * @date: 2015年06月28日 16:39:50
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V3.0
 */

public class TTransportReceipt {

	private Integer receiptid;

	private String erpReceiptid;

	private String vehicleid;

	private String receiptcode;

	private Date receiptdate;

	private Date statisticsdate;

	private String vehiclecode;

	private String motorcadecode;

	private String ownedmotorcadecode;

	private String partyacode;

	private String receipttypecode;

	private String partybcode;

	private String partyccode;

	private String partydcode;

	private String usagetypecode;

	private String drivercode;

	private String vicedrivercode;

	private String escortcode;

	private String cadrelevelcode;

	private String trailercode;

	private String referencereceiptno;

	private String outsetdistributorcode;

	private String startingdistributorcode;

	private String endingdistributorcode;

	private String retrievedistributorcode;

	private Integer roundnumber;

	private Integer loadingorder;

	private Integer disembarkorder;

	private Integer deleted;

	private String calculatedtypename;

	private String transporttypecode;

	private String disputetreatmentstatus;

	private Date begintime;

	private Date endtime;

	private Date retrievedate;

	private Date createtime;

	private Date updatetime;

	private String vendorcode;

	private Integer driverrenttype;

	private Integer islongtrip;

	private Integer ischargeagainst;

	private Integer onduty;

	private Integer forprivateuse;

	private Integer isoversea;

	private Integer totaltransportexpense;

	private Integer netvalue;

	private Integer totaltax;

	private String currencycode;

	private Integer standardtotaltransportexpense;

	private Integer standardnetvalue;

	private Integer standardtotaltax;

	private Integer fuel;

	private Integer loadingfuel;

	private Integer unloadingfuel;

	private String distanceunitcode;

	private String worktimeunitcode;

	private Integer pricecalculateddistance;

	private Integer adjusteddistance;

	private Integer actualdistance;

	private Integer adjustedactualdistances;

	private Integer pricecalculatedworktime;

	private Integer adjustedworktime;

	private Integer actualworktime;

	private Integer actualcapacity;

	private Integer conversionrate;

	private Integer displacement;

	private Integer lightdistance;

	private Integer displacementadjustment;

	private Integer lightdistanceadjustment;

	private Integer pricecalculatedtonnage;

	private String pricecalculatedtonnageunit;

	private Integer totaldistance;

	private Integer actualturnover;

	private Integer pricecalculatedturnover;

	private Integer passengerturnover;

	private Integer machineturnover;

	private Integer totalweight;

	private String comments;

	private Date receiptstatus1;

	private Date receiptstatus2;

	private Date receiptstatus3;

	private Date receiptstatus4;

	private Date trafficstatus1;

	private Date trafficstatus2;

	private Date trafficstatus3;

	private Date trafficstatus4;

	private Date trafficstatus5;

	private Date trafficstatus6;

	private String disputecurrencycode;

	private Integer disputeamount;

	private Integer datasource;

	private String distributeid;

	private String routeid;

	/**
	 * @return the routeid
	 */
	public String getRouteid() {
		return routeid;
	}

	/**
	 * @param routeid
	 *            the routeid to set
	 */
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}

	public Integer getReceiptid() {
		return this.receiptid;
	}

	public void setReceiptid(Integer receiptid) {
		this.receiptid = receiptid;
	}

	public String getErpReceiptid() {
		return this.erpReceiptid;
	}

	public void setErpReceiptid(String erpReceiptid) {
		this.erpReceiptid = erpReceiptid;
	}

	public String getVehicleid() {
		return this.vehicleid;
	}

	public void setVehicleid(String vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getReceiptcode() {
		return this.receiptcode;
	}

	public void setReceiptcode(String receiptcode) {
		this.receiptcode = receiptcode;
	}

	public Date getReceiptdate() {
		return this.receiptdate;
	}

	public void setReceiptdate(Date receiptdate) {
		this.receiptdate = receiptdate;
	}

	public Date getStatisticsdate() {
		return this.statisticsdate;
	}

	public void setStatisticsdate(Date statisticsdate) {
		this.statisticsdate = statisticsdate;
	}

	public String getVehiclecode() {
		return this.vehiclecode;
	}

	public void setVehiclecode(String vehiclecode) {
		this.vehiclecode = vehiclecode;
	}

	public String getMotorcadecode() {
		return this.motorcadecode;
	}

	public void setMotorcadecode(String motorcadecode) {
		this.motorcadecode = motorcadecode;
	}

	public String getOwnedmotorcadecode() {
		return this.ownedmotorcadecode;
	}

	public void setOwnedmotorcadecode(String ownedmotorcadecode) {
		this.ownedmotorcadecode = ownedmotorcadecode;
	}

	public String getPartyacode() {
		return this.partyacode;
	}

	public void setPartyacode(String partyacode) {
		this.partyacode = partyacode;
	}

	public String getReceipttypecode() {
		return this.receipttypecode;
	}

	public void setReceipttypecode(String receipttypecode) {
		this.receipttypecode = receipttypecode;
	}

	public String getPartybcode() {
		return this.partybcode;
	}

	public void setPartybcode(String partybcode) {
		this.partybcode = partybcode;
	}

	public String getPartyccode() {
		return this.partyccode;
	}

	public void setPartyccode(String partyccode) {
		this.partyccode = partyccode;
	}

	public String getPartydcode() {
		return this.partydcode;
	}

	public void setPartydcode(String partydcode) {
		this.partydcode = partydcode;
	}

	public String getUsagetypecode() {
		return this.usagetypecode;
	}

	public void setUsagetypecode(String usagetypecode) {
		this.usagetypecode = usagetypecode;
	}

	public String getDrivercode() {
		return this.drivercode;
	}

	public void setDrivercode(String drivercode) {
		this.drivercode = drivercode;
	}

	public String getVicedrivercode() {
		return this.vicedrivercode;
	}

	public void setVicedrivercode(String vicedrivercode) {
		this.vicedrivercode = vicedrivercode;
	}

	public String getEscortcode() {
		return this.escortcode;
	}

	public void setEscortcode(String escortcode) {
		this.escortcode = escortcode;
	}

	public String getCadrelevelcode() {
		return this.cadrelevelcode;
	}

	public void setCadrelevelcode(String cadrelevelcode) {
		this.cadrelevelcode = cadrelevelcode;
	}

	public String getTrailercode() {
		return this.trailercode;
	}

	public void setTrailercode(String trailercode) {
		this.trailercode = trailercode;
	}

	public String getReferencereceiptno() {
		return this.referencereceiptno;
	}

	public void setReferencereceiptno(String referencereceiptno) {
		this.referencereceiptno = referencereceiptno;
	}

	public String getOutsetdistributorcode() {
		return this.outsetdistributorcode;
	}

	public void setOutsetdistributorcode(String outsetdistributorcode) {
		this.outsetdistributorcode = outsetdistributorcode;
	}

	public String getStartingdistributorcode() {
		return this.startingdistributorcode;
	}

	public void setStartingdistributorcode(String startingdistributorcode) {
		this.startingdistributorcode = startingdistributorcode;
	}

	public String getEndingdistributorcode() {
		return this.endingdistributorcode;
	}

	public void setEndingdistributorcode(String endingdistributorcode) {
		this.endingdistributorcode = endingdistributorcode;
	}

	public String getRetrievedistributorcode() {
		return this.retrievedistributorcode;
	}

	public void setRetrievedistributorcode(String retrievedistributorcode) {
		this.retrievedistributorcode = retrievedistributorcode;
	}

	public Integer getRoundnumber() {
		return this.roundnumber;
	}

	public void setRoundnumber(Integer roundnumber) {
		this.roundnumber = roundnumber;
	}

	public Integer getLoadingorder() {
		return this.loadingorder;
	}

	public void setLoadingorder(Integer loadingorder) {
		this.loadingorder = loadingorder;
	}

	public Integer getDisembarkorder() {
		return this.disembarkorder;
	}

	public void setDisembarkorder(Integer disembarkorder) {
		this.disembarkorder = disembarkorder;
	}

	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getCalculatedtypename() {
		return this.calculatedtypename;
	}

	public void setCalculatedtypename(String calculatedtypename) {
		this.calculatedtypename = calculatedtypename;
	}

	public String getTransporttypecode() {
		return this.transporttypecode;
	}

	public void setTransporttypecode(String transporttypecode) {
		this.transporttypecode = transporttypecode;
	}

	public String getDisputetreatmentstatus() {
		return this.disputetreatmentstatus;
	}

	public void setDisputetreatmentstatus(String disputetreatmentstatus) {
		this.disputetreatmentstatus = disputetreatmentstatus;
	}

	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getRetrievedate() {
		return this.retrievedate;
	}

	public void setRetrievedate(Date retrievedate) {
		this.retrievedate = retrievedate;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getVendorcode() {
		return this.vendorcode;
	}

	public void setVendorcode(String vendorcode) {
		this.vendorcode = vendorcode;
	}

	public Integer getDriverrenttype() {
		return this.driverrenttype;
	}

	public void setDriverrenttype(Integer driverrenttype) {
		this.driverrenttype = driverrenttype;
	}

	public Integer getIslongtrip() {
		return this.islongtrip;
	}

	public void setIslongtrip(Integer islongtrip) {
		this.islongtrip = islongtrip;
	}

	public Integer getIschargeagainst() {
		return this.ischargeagainst;
	}

	public void setIschargeagainst(Integer ischargeagainst) {
		this.ischargeagainst = ischargeagainst;
	}

	public Integer getOnduty() {
		return this.onduty;
	}

	public void setOnduty(Integer onduty) {
		this.onduty = onduty;
	}

	public Integer getForprivateuse() {
		return this.forprivateuse;
	}

	public void setForprivateuse(Integer forprivateuse) {
		this.forprivateuse = forprivateuse;
	}

	public Integer getIsoversea() {
		return this.isoversea;
	}

	public void setIsoversea(Integer isoversea) {
		this.isoversea = isoversea;
	}

	public Integer getTotaltransportexpense() {
		return this.totaltransportexpense;
	}

	public void setTotaltransportexpense(Integer totaltransportexpense) {
		this.totaltransportexpense = totaltransportexpense;
	}

	public Integer getNetvalue() {
		return this.netvalue;
	}

	public void setNetvalue(Integer netvalue) {
		this.netvalue = netvalue;
	}

	public Integer getTotaltax() {
		return this.totaltax;
	}

	public void setTotaltax(Integer totaltax) {
		this.totaltax = totaltax;
	}

	public String getCurrencycode() {
		return this.currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public Integer getStandardtotaltransportexpense() {
		return this.standardtotaltransportexpense;
	}

	public void setStandardtotaltransportexpense(Integer standardtotaltransportexpense) {
		this.standardtotaltransportexpense = standardtotaltransportexpense;
	}

	public Integer getStandardnetvalue() {
		return this.standardnetvalue;
	}

	public void setStandardnetvalue(Integer standardnetvalue) {
		this.standardnetvalue = standardnetvalue;
	}

	public Integer getStandardtotaltax() {
		return this.standardtotaltax;
	}

	public void setStandardtotaltax(Integer standardtotaltax) {
		this.standardtotaltax = standardtotaltax;
	}

	public Integer getFuel() {
		return this.fuel;
	}

	public void setFuel(Integer fuel) {
		this.fuel = fuel;
	}

	public Integer getLoadingfuel() {
		return this.loadingfuel;
	}

	public void setLoadingfuel(Integer loadingfuel) {
		this.loadingfuel = loadingfuel;
	}

	public Integer getUnloadingfuel() {
		return this.unloadingfuel;
	}

	public void setUnloadingfuel(Integer unloadingfuel) {
		this.unloadingfuel = unloadingfuel;
	}

	public String getDistanceunitcode() {
		return this.distanceunitcode;
	}

	public void setDistanceunitcode(String distanceunitcode) {
		this.distanceunitcode = distanceunitcode;
	}

	public String getWorktimeunitcode() {
		return this.worktimeunitcode;
	}

	public void setWorktimeunitcode(String worktimeunitcode) {
		this.worktimeunitcode = worktimeunitcode;
	}

	public Integer getPricecalculateddistance() {
		return this.pricecalculateddistance;
	}

	public void setPricecalculateddistance(Integer pricecalculateddistance) {
		this.pricecalculateddistance = pricecalculateddistance;
	}

	public Integer getAdjusteddistance() {
		return this.adjusteddistance;
	}

	public void setAdjusteddistance(Integer adjusteddistance) {
		this.adjusteddistance = adjusteddistance;
	}

	public Integer getActualdistance() {
		return this.actualdistance;
	}

	public void setActualdistance(Integer actualdistance) {
		this.actualdistance = actualdistance;
	}

	public Integer getAdjustedactualdistances() {
		return this.adjustedactualdistances;
	}

	public void setAdjustedactualdistances(Integer adjustedactualdistances) {
		this.adjustedactualdistances = adjustedactualdistances;
	}

	public Integer getPricecalculatedworktime() {
		return this.pricecalculatedworktime;
	}

	public void setPricecalculatedworktime(Integer pricecalculatedworktime) {
		this.pricecalculatedworktime = pricecalculatedworktime;
	}

	public Integer getAdjustedworktime() {
		return this.adjustedworktime;
	}

	public void setAdjustedworktime(Integer adjustedworktime) {
		this.adjustedworktime = adjustedworktime;
	}

	public Integer getActualworktime() {
		return this.actualworktime;
	}

	public void setActualworktime(Integer actualworktime) {
		this.actualworktime = actualworktime;
	}

	public Integer getActualcapacity() {
		return this.actualcapacity;
	}

	public void setActualcapacity(Integer actualcapacity) {
		this.actualcapacity = actualcapacity;
	}

	public Integer getConversionrate() {
		return this.conversionrate;
	}

	public void setConversionrate(Integer conversionrate) {
		this.conversionrate = conversionrate;
	}

	public Integer getDisplacement() {
		return this.displacement;
	}

	public void setDisplacement(Integer displacement) {
		this.displacement = displacement;
	}

	public Integer getLightdistance() {
		return this.lightdistance;
	}

	public void setLightdistance(Integer lightdistance) {
		this.lightdistance = lightdistance;
	}

	public Integer getDisplacementadjustment() {
		return this.displacementadjustment;
	}

	public void setDisplacementadjustment(Integer displacementadjustment) {
		this.displacementadjustment = displacementadjustment;
	}

	public Integer getLightdistanceadjustment() {
		return this.lightdistanceadjustment;
	}

	public void setLightdistanceadjustment(Integer lightdistanceadjustment) {
		this.lightdistanceadjustment = lightdistanceadjustment;
	}

	public Integer getPricecalculatedtonnage() {
		return this.pricecalculatedtonnage;
	}

	public void setPricecalculatedtonnage(Integer pricecalculatedtonnage) {
		this.pricecalculatedtonnage = pricecalculatedtonnage;
	}

	public String getPricecalculatedtonnageunit() {
		return this.pricecalculatedtonnageunit;
	}

	public void setPricecalculatedtonnageunit(String pricecalculatedtonnageunit) {
		this.pricecalculatedtonnageunit = pricecalculatedtonnageunit;
	}

	public Integer getTotaldistance() {
		return this.totaldistance;
	}

	public void setTotaldistance(Integer totaldistance) {
		this.totaldistance = totaldistance;
	}

	public Integer getActualturnover() {
		return this.actualturnover;
	}

	public void setActualturnover(Integer actualturnover) {
		this.actualturnover = actualturnover;
	}

	public Integer getPricecalculatedturnover() {
		return this.pricecalculatedturnover;
	}

	public void setPricecalculatedturnover(Integer pricecalculatedturnover) {
		this.pricecalculatedturnover = pricecalculatedturnover;
	}

	public Integer getPassengerturnover() {
		return this.passengerturnover;
	}

	public void setPassengerturnover(Integer passengerturnover) {
		this.passengerturnover = passengerturnover;
	}

	public Integer getMachineturnover() {
		return this.machineturnover;
	}

	public void setMachineturnover(Integer machineturnover) {
		this.machineturnover = machineturnover;
	}

	public Integer getTotalweight() {
		return this.totalweight;
	}

	public void setTotalweight(Integer totalweight) {
		this.totalweight = totalweight;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getReceiptstatus1() {
		return this.receiptstatus1;
	}

	public void setReceiptstatus1(Date receiptstatus1) {
		this.receiptstatus1 = receiptstatus1;
	}

	public Date getReceiptstatus2() {
		return this.receiptstatus2;
	}

	public void setReceiptstatus2(Date receiptstatus2) {
		this.receiptstatus2 = receiptstatus2;
	}

	public Date getReceiptstatus3() {
		return this.receiptstatus3;
	}

	public void setReceiptstatus3(Date receiptstatus3) {
		this.receiptstatus3 = receiptstatus3;
	}

	public Date getReceiptstatus4() {
		return this.receiptstatus4;
	}

	public void setReceiptstatus4(Date receiptstatus4) {
		this.receiptstatus4 = receiptstatus4;
	}

	public Date getTrafficstatus1() {
		return this.trafficstatus1;
	}

	public void setTrafficstatus1(Date trafficstatus1) {
		this.trafficstatus1 = trafficstatus1;
	}

	public Date getTrafficstatus2() {
		return this.trafficstatus2;
	}

	public void setTrafficstatus2(Date trafficstatus2) {
		this.trafficstatus2 = trafficstatus2;
	}

	public Date getTrafficstatus3() {
		return this.trafficstatus3;
	}

	public void setTrafficstatus3(Date trafficstatus3) {
		this.trafficstatus3 = trafficstatus3;
	}

	public Date getTrafficstatus4() {
		return this.trafficstatus4;
	}

	public void setTrafficstatus4(Date trafficstatus4) {
		this.trafficstatus4 = trafficstatus4;
	}

	public Date getTrafficstatus5() {
		return this.trafficstatus5;
	}

	public void setTrafficstatus5(Date trafficstatus5) {
		this.trafficstatus5 = trafficstatus5;
	}

	public Date getTrafficstatus6() {
		return this.trafficstatus6;
	}

	public void setTrafficstatus6(Date trafficstatus6) {
		this.trafficstatus6 = trafficstatus6;
	}

	public String getDisputecurrencycode() {
		return this.disputecurrencycode;
	}

	public void setDisputecurrencycode(String disputecurrencycode) {
		this.disputecurrencycode = disputecurrencycode;
	}

	public Integer getDisputeamount() {
		return this.disputeamount;
	}

	public void setDisputeamount(Integer disputeamount) {
		this.disputeamount = disputeamount;
	}

	public Integer getDatasource() {
		return this.datasource;
	}

	public void setDatasource(Integer datasource) {
		this.datasource = datasource;
	}

	public String getDistributeid() {
		return this.distributeid;
	}

	public void setDistributeid(String distributeid) {
		this.distributeid = distributeid;
	}

}
