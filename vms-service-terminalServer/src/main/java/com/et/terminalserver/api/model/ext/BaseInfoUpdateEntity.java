package com.et.terminalserver.api.model.ext;

/**
 * @Description 基础数据更新对象
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:42:41
 * @mail terrorbladeyang@gmail.com
 */
public class BaseInfoUpdateEntity {

	/**
	 * 一场战役 开始了 接招吧 摸摸扎
	 * 
	 * 序言:
	 * 
	 * 话说 这次做的跟2.0不特么一样了 以前都是一下全update过来 经常有SIM卡终端号傻傻分不清楚的时候 最后还得问前台到底是谁少了谁
	 * 
	 * 现在呢 牛逼了 是业务单向绑定(Vehicle-->Terminal-->SIM)
	 * 本地静态对象里关系双向绑定(SIM里有[terminalID,terminalCode
	 * ],Terminal里有[SIMCARDID,SIMNUMBER,VID], SIM里有[terminalCode,terminalID])
	 * 互相都能拿到 每一次绑定和解绑 都要在本地缓存里边即使分清 出毛病好看
	 * 
	 * 我集合我3个静态信息对象的所有字段 万剑归宗于这个类 不要怕 并不多 你根据不同情况给我推
	 * */

	/** 组织机构 */
	private String orgCode = "";
	// 车牌号
	private String idNumber = "";
	// 终端编号
	private String terminalCode = "";
	// 终端ID
	private String terminalID = "";
	// 类型ID 终端上传/平台转发 标识 type_ID
	private String typeID = "";
	// 车辆ID
	private String vid = "";
	// SIM卡ID
	private String simCardID = "";
	// SIM卡号
	private String simNum = "";
	// TTYPE_ID 什么类型的终端
	private String terminalType = "";
	// DEPTCODE
	private String Provider = "";
	// 增删改差标识 这个是字段之外的
	private String OperationType = "";
	
	//车辆颜色 2016.7.18
	private String vehicleColor="";

	/**
	 * 下面开始分个类
	 * 
	 * 1.快速添加
	 * 
	 * !!!!简单直接，字段全赋的满满的,操作类型"INSERT"
	 * 
	 * 2.SIM卡相关操作
	 * 
	 * 添加一个:
	 * 
	 * !!!!需填字段 gcode provider simNum SimID好说 呵呵 操作类型"INSERTSIM"
	 * 
	 * 删除SIM 分俩情况
	 * 
	 * a.没有被绑定
	 * 
	 * 字段 simNum 操作类型 "DELSIM"
	 * 
	 * b.这个SIM被一个终端绑定了
	 * 
	 * 字段 simNum terminalCode 类型 "DELSIM"
	 * 
	 * 综上所述!!! 字段 simNum terminalCode(有就传,没有就空) "DELSIM"
	 * 
	 * 3.TERMINAL
	 * 
	 * 添加终端/更新终端信息
	 * 
	 * 字段 gcode terminalCode terminalID terminalType
	 * [SimCardID,SimNum](如果有就填,表示上来就绑定了一个SIM卡) "INSERTTERMINAL"
	 * 
	 * 解绑的话或者换号的话 SimCardID,SimNum 变成空就好了
	 * 
	 * 删除终端
	 * 
	 * !!!!字段 terminalCode terminalID vid(如果有) [SimNum SimCard](如果有)
	 * "DELTERMINAL"
	 * 
	 * 4.Vehicle
	 * 
	 * 添加车辆/更新车辆信息
	 * 
	 * 字段 orgCode idNumber [terminalCode,terminalID](如果有) typeID vid 类型:
	 * "INSERTVEHICLE"
	 * 
	 * 解绑或者换终端的话 terminalCode,terminalID 变成空
	 * 
	 * 删除车辆
	 * 
	 * !!!!字段 vid [terminalCode,terminalID] 如果有的话 类型:"DELVEHICLE"
	 * 
	 * 
	 * */

	public String getIdNumber() {
		return idNumber;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	public String getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getSimCardID() {
		return simCardID;
	}

	public void setSimCardID(String simCardID) {
		this.simCardID = simCardID;
	}

	public String getSimNum() {
		return simNum;
	}

	public void setSimNum(String simNum) {
		this.simNum = simNum;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getProvider() {
		return Provider;
	}

	public void setProvider(String provider) {
		Provider = provider;
	}

	public String getOperationType() {
		return OperationType;
	}

	public void setOperationType(String operationType) {
		OperationType = operationType;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

}
