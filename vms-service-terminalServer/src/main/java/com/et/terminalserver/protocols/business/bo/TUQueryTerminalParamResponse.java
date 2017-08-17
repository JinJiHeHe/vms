package com.et.terminalserver.protocols.business.bo;


/**
 * @Description 上传的查询终端参数响应
 * @author jakiro
 * @version V1.0
 * @Date 2016年7月27日 下午10:10:11
 * @mail terrorbladeyang@gmail.com
 */
public class TUQueryTerminalParamResponse extends BusinessObject{

	private int replaySerialNumber;// 应答流水号
	private int packageParamsNumber;// 包参数个数
//	private BoTerminalParameterInfo paraList;// 参数项(实体类)
	private Integer heartBeatTime;// 终端心跳发送间隔
	private Integer tcpResponseTime;// TCP消息应答超时时间
	private Integer tcpReCon;// TCP重连次数
	private Integer udpResponseTime;// UDP消息应答超时时间
	private Integer udpReCon;// UDP重连次数
	private Integer smsResponseTime;// SMS消息应答超时时间
	private Integer smsReCon;// SMS重传次数
	private String mainApn;// 主服务器APN,无线通信拨号访问点
	private String mainwirelessUser;// 主服务器无线通信拨号用户名
	private String mainwirelesspassword;// 主服务器无线通信拨号密码
	private String mainIP;// 主服务器地址，IP或域名
	private String backupApn;// 备用服务器APN,无线通信拨号访问点
	private String backupwirelessUser;// 备用服务器无线通信拨号用户名
	private String backupwirelesspassword;// 备用服务器无线通信拨号密码
	private String backupIP;// 备用服务器地址，IP或域名
	private Integer tcpport;// TCP端口
	private Integer udpport;// UDP端口
	private Integer positionReturnPolicy;// 策略，0定时汇报，1定距汇报，2定时定距汇报
	private Integer positionReMethod;// 位置汇报方案，0根据ACC状态，1根据登录和ACC状态
	private Integer driverNotLogtime;// 驾驶员未登录回报时间间隔
	private Integer sleepTime;// 休眠时汇报时间间隔
	private Integer emergencytime;// 紧急报警时汇报时间间隔
	private Integer defaulttime;// 缺省时间汇报间隔
	private Integer defaultdistance;// 缺省距离汇报间隔
	private Integer driverNotLogdistance;// 驾驶员未登录汇报距离间隔
	private Integer sleepDistance;// 休眠时汇报距离间隔
	private Integer emergencyDistance;// 紧急报警时汇报距离间隔
	private Integer InflectionPoint;// 拐点补传角度
	private String platphoneNum;// 监控平台电话号码
	private String resetPhoneNum;// 复位电话号码
	private String restorefactoryPhoneNum;// 恢复出厂设置电话号码
	private String platSMSnum;// 监控平台SMS号码
	private String recieveTerminalSMSnum;// 接收终端SMS文本报警号码
	private Integer terminalphonePolicy;// 终端电话接听策略 0自动接听，1ACC ON自动接听，OFF手动接听
	private Integer perMaxphonetime;// 每次最长通话时间
	private Integer perMonthMaxphonetime;// 当月最长通话时间
	private String monitorPhoneNum;// 监听电话号码
	private String monitorplatMessageNum;// 监管平台特权短信号码
	private Integer alarmshield;// 报警屏蔽子
	private Integer alarmSMS;// 报警发送文本SMS开关
	private Integer alarmPhoto;// 报警拍摄开关
	private Integer alarmphotoSave;// 报警拍摄存储标志
	private Integer importantFlag;// 关键标志
	private Integer maxSpeed;// 最高速度
	private Integer overspeedTime;// 超速持续时间
	private Integer maxoverDriveTime;// 连续驾驶时间门限
	private Integer maxoverDrivePerday;// 当天累计驾驶时间门限
	private Integer minResttime;// 最小休息时间
	private Integer maxParktime;// 最长停车时间
	private Integer imageQuality;// 图像视频质量
	private Integer brightness;// 亮度0-255
	private Integer contrast;// 对比度0-127
	private Integer saturation;// 饱和度0-127
	private Integer color;// 色度0-255
	private Integer odometerReading;// 车辆里程表读数
	private Integer provinceId;// 省域ID
	private Integer cityId;// 市域ID
	private String carNum;// 车牌号
	private Integer carColor;// 车牌颜色
	private Integer electricFenceRadius;// 电子围栏半径
	
	@Override
	public int getBusinessCode() {
		
		return BusinessObject.TR_QUERYTERMINALPARAMRESPONSE;
		
	}

	public int getReplaySerialNumber() {
		return replaySerialNumber;
	}

	public void setReplaySerialNumber(int replaySerialNumber) {
		this.replaySerialNumber = replaySerialNumber;
	}

	public int getPackageParamsNumber() {
		return packageParamsNumber;
	}

	public void setPackageParamsNumber(int packageParamsNumber) {
		this.packageParamsNumber = packageParamsNumber;
	}

	public Integer getHeartBeatTime() {
		return heartBeatTime;
	}

	public void setHeartBeatTime(Integer heartBeatTime) {
		this.heartBeatTime = heartBeatTime;
	}

	public Integer getTcpResponseTime() {
		return tcpResponseTime;
	}

	public void setTcpResponseTime(Integer tcpResponseTime) {
		this.tcpResponseTime = tcpResponseTime;
	}

	public Integer getTcpReCon() {
		return tcpReCon;
	}

	public void setTcpReCon(Integer tcpReCon) {
		this.tcpReCon = tcpReCon;
	}

	public Integer getUdpResponseTime() {
		return udpResponseTime;
	}

	public void setUdpResponseTime(Integer udpResponseTime) {
		this.udpResponseTime = udpResponseTime;
	}

	public Integer getUdpReCon() {
		return udpReCon;
	}

	public void setUdpReCon(Integer udpReCon) {
		this.udpReCon = udpReCon;
	}

	public Integer getSmsResponseTime() {
		return smsResponseTime;
	}

	public void setSmsResponseTime(Integer smsResponseTime) {
		this.smsResponseTime = smsResponseTime;
	}

	public Integer getSmsReCon() {
		return smsReCon;
	}

	public void setSmsReCon(Integer smsReCon) {
		this.smsReCon = smsReCon;
	}

	public String getMainApn() {
		return mainApn;
	}

	public void setMainApn(String mainApn) {
		this.mainApn = mainApn;
	}

	public String getMainwirelessUser() {
		return mainwirelessUser;
	}

	public void setMainwirelessUser(String mainwirelessUser) {
		this.mainwirelessUser = mainwirelessUser;
	}

	public String getMainwirelesspassword() {
		return mainwirelesspassword;
	}

	public void setMainwirelesspassword(String mainwirelesspassword) {
		this.mainwirelesspassword = mainwirelesspassword;
	}

	public String getMainIP() {
		return mainIP;
	}

	public void setMainIP(String mainIP) {
		this.mainIP = mainIP;
	}

	public String getBackupApn() {
		return backupApn;
	}

	public void setBackupApn(String backupApn) {
		this.backupApn = backupApn;
	}

	public String getBackupwirelessUser() {
		return backupwirelessUser;
	}

	public void setBackupwirelessUser(String backupwirelessUser) {
		this.backupwirelessUser = backupwirelessUser;
	}

	public String getBackupwirelesspassword() {
		return backupwirelesspassword;
	}

	public void setBackupwirelesspassword(String backupwirelesspassword) {
		this.backupwirelesspassword = backupwirelesspassword;
	}

	public String getBackupIP() {
		return backupIP;
	}

	public void setBackupIP(String backupIP) {
		this.backupIP = backupIP;
	}

	public Integer getTcpport() {
		return tcpport;
	}

	public void setTcpport(Integer tcpport) {
		this.tcpport = tcpport;
	}

	public Integer getUdpport() {
		return udpport;
	}

	public void setUdpport(Integer udpport) {
		this.udpport = udpport;
	}

	public Integer getPositionReturnPolicy() {
		return positionReturnPolicy;
	}

	public void setPositionReturnPolicy(Integer positionReturnPolicy) {
		this.positionReturnPolicy = positionReturnPolicy;
	}

	public Integer getPositionReMethod() {
		return positionReMethod;
	}

	public void setPositionReMethod(Integer positionReMethod) {
		this.positionReMethod = positionReMethod;
	}

	public Integer getDriverNotLogtime() {
		return driverNotLogtime;
	}

	public void setDriverNotLogtime(Integer driverNotLogtime) {
		this.driverNotLogtime = driverNotLogtime;
	}

	public Integer getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(Integer sleepTime) {
		this.sleepTime = sleepTime;
	}

	public Integer getEmergencytime() {
		return emergencytime;
	}

	public void setEmergencytime(Integer emergencytime) {
		this.emergencytime = emergencytime;
	}

	public Integer getDefaulttime() {
		return defaulttime;
	}

	public void setDefaulttime(Integer defaulttime) {
		this.defaulttime = defaulttime;
	}

	public Integer getDefaultdistance() {
		return defaultdistance;
	}

	public void setDefaultdistance(Integer defaultdistance) {
		this.defaultdistance = defaultdistance;
	}

	public Integer getDriverNotLogdistance() {
		return driverNotLogdistance;
	}

	public void setDriverNotLogdistance(Integer driverNotLogdistance) {
		this.driverNotLogdistance = driverNotLogdistance;
	}

	public Integer getSleepDistance() {
		return sleepDistance;
	}

	public void setSleepDistance(Integer sleepDistance) {
		this.sleepDistance = sleepDistance;
	}

	public Integer getEmergencyDistance() {
		return emergencyDistance;
	}

	public void setEmergencyDistance(Integer emergencyDistance) {
		this.emergencyDistance = emergencyDistance;
	}

	public Integer getInflectionPoint() {
		return InflectionPoint;
	}

	public void setInflectionPoint(Integer inflectionPoint) {
		InflectionPoint = inflectionPoint;
	}

	public String getPlatphoneNum() {
		return platphoneNum;
	}

	public void setPlatphoneNum(String platphoneNum) {
		this.platphoneNum = platphoneNum;
	}

	public String getResetPhoneNum() {
		return resetPhoneNum;
	}

	public void setResetPhoneNum(String resetPhoneNum) {
		this.resetPhoneNum = resetPhoneNum;
	}

	public String getRestorefactoryPhoneNum() {
		return restorefactoryPhoneNum;
	}

	public void setRestorefactoryPhoneNum(String restorefactoryPhoneNum) {
		this.restorefactoryPhoneNum = restorefactoryPhoneNum;
	}

	public String getPlatSMSnum() {
		return platSMSnum;
	}

	public void setPlatSMSnum(String platSMSnum) {
		this.platSMSnum = platSMSnum;
	}

	public String getRecieveTerminalSMSnum() {
		return recieveTerminalSMSnum;
	}

	public void setRecieveTerminalSMSnum(String recieveTerminalSMSnum) {
		this.recieveTerminalSMSnum = recieveTerminalSMSnum;
	}

	public Integer getTerminalphonePolicy() {
		return terminalphonePolicy;
	}

	public void setTerminalphonePolicy(Integer terminalphonePolicy) {
		this.terminalphonePolicy = terminalphonePolicy;
	}

	public Integer getPerMaxphonetime() {
		return perMaxphonetime;
	}

	public void setPerMaxphonetime(Integer perMaxphonetime) {
		this.perMaxphonetime = perMaxphonetime;
	}

	public Integer getPerMonthMaxphonetime() {
		return perMonthMaxphonetime;
	}

	public void setPerMonthMaxphonetime(Integer perMonthMaxphonetime) {
		this.perMonthMaxphonetime = perMonthMaxphonetime;
	}

	public String getMonitorPhoneNum() {
		return monitorPhoneNum;
	}

	public void setMonitorPhoneNum(String monitorPhoneNum) {
		this.monitorPhoneNum = monitorPhoneNum;
	}

	public String getMonitorplatMessageNum() {
		return monitorplatMessageNum;
	}

	public void setMonitorplatMessageNum(String monitorplatMessageNum) {
		this.monitorplatMessageNum = monitorplatMessageNum;
	}

	public Integer getAlarmshield() {
		return alarmshield;
	}

	public void setAlarmshield(Integer alarmshield) {
		this.alarmshield = alarmshield;
	}

	public Integer getAlarmSMS() {
		return alarmSMS;
	}

	public void setAlarmSMS(Integer alarmSMS) {
		this.alarmSMS = alarmSMS;
	}

	public Integer getAlarmPhoto() {
		return alarmPhoto;
	}

	public void setAlarmPhoto(Integer alarmPhoto) {
		this.alarmPhoto = alarmPhoto;
	}

	public Integer getAlarmphotoSave() {
		return alarmphotoSave;
	}

	public void setAlarmphotoSave(Integer alarmphotoSave) {
		this.alarmphotoSave = alarmphotoSave;
	}

	public Integer getImportantFlag() {
		return importantFlag;
	}

	public void setImportantFlag(Integer importantFlag) {
		this.importantFlag = importantFlag;
	}

	public Integer getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Integer getOverspeedTime() {
		return overspeedTime;
	}

	public void setOverspeedTime(Integer overspeedTime) {
		this.overspeedTime = overspeedTime;
	}

	public Integer getMaxoverDriveTime() {
		return maxoverDriveTime;
	}

	public void setMaxoverDriveTime(Integer maxoverDriveTime) {
		this.maxoverDriveTime = maxoverDriveTime;
	}

	public Integer getMaxoverDrivePerday() {
		return maxoverDrivePerday;
	}

	public void setMaxoverDrivePerday(Integer maxoverDrivePerday) {
		this.maxoverDrivePerday = maxoverDrivePerday;
	}

	public Integer getMinResttime() {
		return minResttime;
	}

	public void setMinResttime(Integer minResttime) {
		this.minResttime = minResttime;
	}

	public Integer getMaxParktime() {
		return maxParktime;
	}

	public void setMaxParktime(Integer maxParktime) {
		this.maxParktime = maxParktime;
	}

	public Integer getImageQuality() {
		return imageQuality;
	}

	public void setImageQuality(Integer imageQuality) {
		this.imageQuality = imageQuality;
	}

	public Integer getBrightness() {
		return brightness;
	}

	public void setBrightness(Integer brightness) {
		this.brightness = brightness;
	}

	public Integer getContrast() {
		return contrast;
	}

	public void setContrast(Integer contrast) {
		this.contrast = contrast;
	}

	public Integer getSaturation() {
		return saturation;
	}

	public void setSaturation(Integer saturation) {
		this.saturation = saturation;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Integer getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(Integer odometerReading) {
		this.odometerReading = odometerReading;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Integer getCarColor() {
		return carColor;
	}

	public void setCarColor(Integer carColor) {
		this.carColor = carColor;
	}

	public Integer getElectricFenceRadius() {
		return electricFenceRadius;
	}

	public void setElectricFenceRadius(Integer electricFenceRadius) {
		this.electricFenceRadius = electricFenceRadius;
	}

	/** 
	 * @Title: toText 
	 * @Description: 转化成指令回复字符串
	 * @return 
	 */
	public String toInstrResponseText(){
		String instrresponsetext  = "终端心跳间隔:" + this.getHeartBeatTime() + "\r\n" + "TCP消息应答超时时间:" + this.getTcpResponseTime() + "\r\n"
				+ "TCP重连次数:" + this.getTcpReCon() + "\r\n" + "UDP消息应答超时时间:" + this.getUdpResponseTime() + "\r\n" + "UDP重连次数:"
				+ this.getUdpReCon() + "\r\n" + "SMS消息应答超时时间:" + this.getSmsResponseTime() + "\r\n" + "SMS重传次数:"
				+ this.getSmsReCon() + "\r\n" + "主服务器APN,无线通信拨号访问点:"
				+ (null == this.getMainApn() ? "":this.getMainApn())
				+ "\r\n"
				+ "主服务器无线通信拨号用户名:"
				+ (null == this.getMainwirelessUser() ? "":this.getMainwirelessUser())
				+ "\r\n"
				+ "主服务器无线通信拨号密码:"
				+ (null == this.getMainwirelesspassword() ? "":this.getMainwirelesspassword())
				+ "\r\n"
				+ "主服务器地址，IP或域名:"
				+ (null == this.getMainIP() ? "":this.getMainIP())
				+ "\r\n"
				+ "备用服务器APN,无线通信拨号访问点:"
				+ (null == this.getBackupApn() ?"":this.getBackupApn())
				+ "\r\n"
				+ "备用服务器无线通信拨号用户名:"
				+ (null == this.getBackupwirelessUser() ?"":this.getBackupApn())
				+ "\r\n"
				+ "备用服务器无线通信拨号密码:"
				+ (null == this.getBackupwirelesspassword() ?"":this.getBackupwirelesspassword())
				+ "\r\n"
				+ "备用服务器地址，IP或域名:"
				+ (null == this.getBackupIP() ?"":this.getBackupIP())
				+ "\r\n"
				+ "TCP端口:"
				+ this.getTcpport()
				+ "\r\n"
				+ "UDP端口:"
				+ this.getUdpport()
				+ "\r\n"
				+ "位置汇报策略:"
				+ (null == this.getPositionReturnPolicy()? "":this.getPositionReturnPolicy())
				+ "\r\n"
				+ "位置汇报方案:"
				+ this.getPositionReMethod()
				+ "\r\n"
				+ "驾驶员未登录回报时间间隔:"
				+ this.getDriverNotLogtime()
				+ "\r\n"
				+ "休眠时汇报时间间隔:"
				+ this.getSleepTime()
				+ "\r\n"
				+ "紧急报警时汇报时间间隔:"
				+ this.getEmergencytime()
				+ "\r\n"
				+ "缺省时间汇报间隔:"
				+ this.getDefaulttime()
				+ "\r\n"
				+ "缺省距离汇报间隔:"
				+ this.getDefaultdistance()
				+ "\r\n"
				+ "驾驶员未登录汇报距离间隔:"
				+ this.getDriverNotLogdistance()
				+ "\r\n"
				+ "休眠时汇报距离间隔:"
				+ this.getSleepDistance()
				+ "\r\n"
				+ "紧急报警时汇报距离间隔:"
				+ this.getEmergencyDistance()
				+ "\r\n"
				+ "拐点补传角度:"
				+ this.getInflectionPoint()
				+ "\r\n"
				+ "监控平台电话号码:"
				+ (null == this.getPlatphoneNum() ?"": this.getPlatphoneNum() )
				+ "\r\n"
				+ "复位电话号码:"
				+ (null == this.getResetPhoneNum() ?"": this.getResetPhoneNum())
				+ "\r\n"
				+ "恢复出厂设置电话号码:"
				+ (null == this.getRestorefactoryPhoneNum()?"": this.getRestorefactoryPhoneNum())
				+ "\r\n"
				+ //
				"监控平台SMS号码:"
				+ (null == this.getPlatSMSnum() ?"":this.getPlatSMSnum())
				+ "\r\n"
				+ "接收终端SMS文本报警号码:"
				+ (null == this.getRecieveTerminalSMSnum()?"":this.getRecieveTerminalSMSnum())
				+ "\r\n"
				+ "终端电话接听策略:"
				+ this.getTerminalphonePolicy()
				+ "\r\n"
				+ // 0自动接听，1ACC ON自动接听，OFF手动接听
				"每次最长通话时间:"
				+ this.getPerMaxphonetime()
				+ "\r\n"
				+ //
				"当月最长通话时间:" + this.getPerMonthMaxphonetime() + "\r\n" + "监听电话号码:" + (null ==this.getMonitorPhoneNum()?"": this.getMonitorPhoneNum())+ "\r\n"
				+ "监管平台特权短信号码:" + (null ==this.getMonitorplatMessageNum() ?"":this.getMonitorplatMessageNum())+ "\r\n" + "报警屏蔽子:" + this.getAlarmshield() + "\r\n"
				+ "报警发送文本SMS开关:" + this.getAlarmSMS() + "\r\n" + "报警拍摄开关:" + this.getAlarmPhoto() + "\r\n" + "报警拍摄存储标志:"
				+ this.getAlarmphotoSave() + "\r\n" + "关键标志:" + this.getImportantFlag() + "\r\n" + "最高速度:"
				+ this.getMaxSpeed() + "\r\n" + "超速持续时间:" + this.getOverspeedTime() + "\r\n" + "连续驾驶时间门限:"
				+ this.getMaxoverDriveTime() + "\r\n" + "当天累计驾驶时间门限:" + this.getMaxoverDrivePerday() + "\r\n" + "最小休息时间:"
				+ this.getMinResttime() + "\r\n" + "最长停车时间:" + this.getMaxParktime() + "\r\n" + "图像视频质量:"
				+ this.getImageQuality() + "\r\n" + "亮度0-255:" + this.getBrightness() + "\r\n" + "对比度0-127:"
				+ this.getContrast() + "\r\n" + "饱和度0-127:" + this.getSaturation() + "\r\n" + "色度0-255:"
				+ this.getColor() + "\r\n" + "车辆里程表读数:" + this.getOdometerReading() + "\r\n" + "省域ID:"
				+ this.getProvinceId() + "\r\n" + "市域ID:" + this.getCityId() + "\r\n" + "车牌号:" + this.getCarNum()
				+ "\r\n" + "车牌颜色:" + this.getCarColor() + "\r\n" + "电子围栏半径:" + this.getElectricFenceRadius() + "\r\n"
				+ "备份端口:" + this.getTcpport();		
		
		return instrresponsetext;
	}	
}
