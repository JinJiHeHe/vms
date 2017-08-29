package com.et.terminalserver.protocols.business.bo;

/**
 * @Project: CNPC_VMS车辆管理系统
 * @Title: TerminalParameterInfo
 * @Description: 参数列表(部标808、华强、天琴、ET08和欧亚北斗终端参数等等(0104)列表)
 * @author: lijz
 * @date :2014年10月19日 下午1:00:01
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class BoTerminalParameterInfo {
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
	private Integer positionReturnPolicy;// 位置汇报策略，0定时汇报，1定距汇报，2定时定距汇报
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

	/**
	 * @Description 获得 heartBeatTime
	 */
	public Integer getHeartBeatTime() {
		return heartBeatTime;
	}

	/**
	 * @Description:设置 heartBeatTime
	 */
	public void setHeartBeatTime(Integer heartBeatTime) {
		this.heartBeatTime = heartBeatTime;
	}

	/**
	 * @Description 获得 tcpResponseTime
	 */
	public Integer getTcpResponseTime() {
		return tcpResponseTime;
	}

	/**
	 * @Description:设置 tcpResponseTime
	 */
	public void setTcpResponseTime(Integer tcpResponseTime) {
		this.tcpResponseTime = tcpResponseTime;
	}

	/**
	 * @Description 获得 tcpReCon
	 */
	public Integer getTcpReCon() {
		return tcpReCon;
	}

	/**
	 * @Description:设置 tcpReCon
	 */
	public void setTcpReCon(Integer tcpReCon) {
		this.tcpReCon = tcpReCon;
	}

	/**
	 * @Description 获得 udpResponseTime
	 */
	public Integer getUdpResponseTime() {
		return udpResponseTime;
	}

	/**
	 * @Description:设置 udpResponseTime
	 */
	public void setUdpResponseTime(Integer udpResponseTime) {
		this.udpResponseTime = udpResponseTime;
	}

	/**
	 * @Description 获得 udpReCon
	 */
	public Integer getUdpReCon() {
		return udpReCon;
	}

	/**
	 * @Description:设置 udpReCon
	 */
	public void setUdpReCon(Integer udpReCon) {
		this.udpReCon = udpReCon;
	}

	/**
	 * @Description 获得 smsResponseTime
	 */
	public Integer getSmsResponseTime() {
		return smsResponseTime;
	}

	/**
	 * @Description:设置 smsResponseTime
	 */
	public void setSmsResponseTime(Integer smsResponseTime) {
		this.smsResponseTime = smsResponseTime;
	}

	/**
	 * @Description 获得 smsReCon
	 */
	public Integer getSmsReCon() {
		return smsReCon;
	}

	/**
	 * @Description:设置 smsReCon
	 */
	public void setSmsReCon(Integer smsReCon) {
		this.smsReCon = smsReCon;
	}

	/**
	 * @Description 获得 mainApn
	 */
	public String getMainApn() {
		return mainApn;
	}

	/**
	 * @Description:设置 mainApn
	 */
	public void setMainApn(String mainApn) {
		this.mainApn = mainApn;
	}

	/**
	 * @Description 获得 mainwirelessUser
	 */
	public String getMainwirelessUser() {
		return mainwirelessUser;
	}

	/**
	 * @Description:设置 mainwirelessUser
	 */
	public void setMainwirelessUser(String mainwirelessUser) {
		this.mainwirelessUser = mainwirelessUser;
	}

	/**
	 * @Description 获得 mainwirelesspassword
	 */
	public String getMainwirelesspassword() {
		return mainwirelesspassword;
	}

	/**
	 * @Description:设置 mainwirelesspassword
	 */
	public void setMainwirelesspassword(String mainwirelesspassword) {
		this.mainwirelesspassword = mainwirelesspassword;
	}

	/**
	 * @Description 获得 mainIP
	 */
	public String getMainIP() {
		return mainIP;
	}

	/**
	 * @Description:设置 mainIP
	 */
	public void setMainIP(String mainIP) {
		this.mainIP = mainIP;
	}

	/**
	 * @Description 获得 backupApn
	 */
	public String getBackupApn() {
		return backupApn;
	}

	/**
	 * @Description:设置 backupApn
	 */
	public void setBackupApn(String backupApn) {
		this.backupApn = backupApn;
	}

	/**
	 * @Description 获得 backupwirelessUser
	 */
	public String getBackupwirelessUser() {
		return backupwirelessUser;
	}

	/**
	 * @Description:设置 backupwirelessUser
	 */
	public void setBackupwirelessUser(String backupwirelessUser) {
		this.backupwirelessUser = backupwirelessUser;
	}

	/**
	 * @Description 获得 backupwirelesspassword
	 */
	public String getBackupwirelesspassword() {
		return backupwirelesspassword;
	}

	/**
	 * @Description:设置 backupwirelesspassword
	 */
	public void setBackupwirelesspassword(String backupwirelesspassword) {
		this.backupwirelesspassword = backupwirelesspassword;
	}

	/**
	 * @Description 获得 backupIP
	 */
	public String getBackupIP() {
		return backupIP;
	}

	/**
	 * @Description:设置 backupIP
	 */
	public void setBackupIP(String backupIP) {
		this.backupIP = backupIP;
	}

	/**
	 * @Description 获得 tcpport
	 */
	public Integer getTcpport() {
		return tcpport;
	}

	/**
	 * @Description:设置 tcpport
	 */
	public void setTcpport(Integer tcpport) {
		this.tcpport = tcpport;
	}

	/**
	 * @Description 获得 udpport
	 */
	public Integer getUdpport() {
		return udpport;
	}

	/**
	 * @Description:设置 udpport
	 */
	public void setUdpport(Integer udpport) {
		this.udpport = udpport;
	}

	/**
	 * @Description 获得 positionReturnPolicy
	 */
	public Integer getPositionReturnPolicy() {
		return positionReturnPolicy;
	}

	/**
	 * @Description:设置 positionReturnPolicy
	 */
	public void setPositionReturnPolicy(Integer positionReturnPolicy) {
		this.positionReturnPolicy = positionReturnPolicy;
	}

	/**
	 * @Description 获得 positionReMethod
	 */
	public Integer getPositionReMethod() {
		return positionReMethod;
	}

	/**
	 * @Description:设置 positionReMethod
	 */
	public void setPositionReMethod(Integer positionReMethod) {
		this.positionReMethod = positionReMethod;
	}

	/**
	 * @Description 获得 driverNotLogtime
	 */
	public Integer getDriverNotLogtime() {
		return driverNotLogtime;
	}

	/**
	 * @Description:设置 driverNotLogtime
	 */
	public void setDriverNotLogtime(Integer driverNotLogtime) {
		this.driverNotLogtime = driverNotLogtime;
	}

	/**
	 * @Description 获得 sleepTime
	 */
	public Integer getSleepTime() {
		return sleepTime;
	}

	/**
	 * @Description:设置 sleepTime
	 */
	public void setSleepTime(Integer sleepTime) {
		this.sleepTime = sleepTime;
	}

	/**
	 * @Description 获得 emergencytime
	 */
	public Integer getEmergencytime() {
		return emergencytime;
	}

	/**
	 * @Description:设置 emergencytime
	 */
	public void setEmergencytime(Integer emergencytime) {
		this.emergencytime = emergencytime;
	}

	/**
	 * @Description 获得 defaulttime
	 */
	public Integer getDefaulttime() {
		return defaulttime;
	}

	/**
	 * @Description:设置 defaulttime
	 */
	public void setDefaulttime(Integer defaulttime) {
		this.defaulttime = defaulttime;
	}

	/**
	 * @Description 获得 defaultdistance
	 */
	public Integer getDefaultdistance() {
		return defaultdistance;
	}

	/**
	 * @Description:设置 defaultdistance
	 */
	public void setDefaultdistance(Integer defaultdistance) {
		this.defaultdistance = defaultdistance;
	}

	/**
	 * @Description 获得 driverNotLogdistance
	 */
	public Integer getDriverNotLogdistance() {
		return driverNotLogdistance;
	}

	/**
	 * @Description:设置 driverNotLogdistance
	 */
	public void setDriverNotLogdistance(Integer driverNotLogdistance) {
		this.driverNotLogdistance = driverNotLogdistance;
	}

	/**
	 * @Description 获得 sleepDistance
	 */
	public Integer getSleepDistance() {
		return sleepDistance;
	}

	/**
	 * @Description:设置 sleepDistance
	 */
	public void setSleepDistance(Integer sleepDistance) {
		this.sleepDistance = sleepDistance;
	}

	/**
	 * @Description 获得 emergencyDistance
	 */
	public Integer getEmergencyDistance() {
		return emergencyDistance;
	}

	/**
	 * @Description:设置 emergencyDistance
	 */
	public void setEmergencyDistance(Integer emergencyDistance) {
		this.emergencyDistance = emergencyDistance;
	}

	/**
	 * @Description 获得 inflectionPoint
	 */
	public Integer getInflectionPoint() {
		return InflectionPoint;
	}

	/**
	 * @Description:设置 inflectionPoint
	 */
	public void setInflectionPoint(Integer inflectionPoint) {
		InflectionPoint = inflectionPoint;
	}

	/**
	 * @Description 获得 platphoneNum
	 */
	public String getPlatphoneNum() {
		return platphoneNum;
	}

	/**
	 * @Description:设置 platphoneNum
	 */
	public void setPlatphoneNum(String platphoneNum) {
		this.platphoneNum = platphoneNum;
	}

	/**
	 * @Description 获得 resetPhoneNum
	 */
	public String getResetPhoneNum() {
		return resetPhoneNum;
	}

	/**
	 * @Description:设置 resetPhoneNum
	 */
	public void setResetPhoneNum(String resetPhoneNum) {
		this.resetPhoneNum = resetPhoneNum;
	}

	/**
	 * @Description 获得 restorefactoryPhoneNum
	 */
	public String getRestorefactoryPhoneNum() {
		return restorefactoryPhoneNum;
	}

	/**
	 * @Description:设置 restorefactoryPhoneNum
	 */
	public void setRestorefactoryPhoneNum(String restorefactoryPhoneNum) {
		this.restorefactoryPhoneNum = restorefactoryPhoneNum;
	}

	/**
	 * @Description 获得 platSMSnum
	 */
	public String getPlatSMSnum() {
		return platSMSnum;
	}

	/**
	 * @Description:设置 platSMSnum
	 */
	public void setPlatSMSnum(String platSMSnum) {
		this.platSMSnum = platSMSnum;
	}

	/**
	 * @Description 获得 recieveTerminalSMSnum
	 */
	public String getRecieveTerminalSMSnum() {
		return recieveTerminalSMSnum;
	}

	/**
	 * @Description:设置 recieveTerminalSMSnum
	 */
	public void setRecieveTerminalSMSnum(String recieveTerminalSMSnum) {
		this.recieveTerminalSMSnum = recieveTerminalSMSnum;
	}

	/**
	 * @Description 获得 terminalphonePolicy
	 */
	public Integer getTerminalphonePolicy() {
		return terminalphonePolicy;
	}

	/**
	 * @Description:设置 terminalphonePolicy
	 */
	public void setTerminalphonePolicy(Integer terminalphonePolicy) {
		this.terminalphonePolicy = terminalphonePolicy;
	}

	/**
	 * @Description 获得 perMaxphonetime
	 */
	public Integer getPerMaxphonetime() {
		return perMaxphonetime;
	}

	/**
	 * @Description:设置 perMaxphonetime
	 */
	public void setPerMaxphonetime(Integer perMaxphonetime) {
		this.perMaxphonetime = perMaxphonetime;
	}

	/**
	 * @Description 获得 perMonthMaxphonetime
	 */
	public Integer getPerMonthMaxphonetime() {
		return perMonthMaxphonetime;
	}

	/**
	 * @Description:设置 perMonthMaxphonetime
	 */
	public void setPerMonthMaxphonetime(Integer perMonthMaxphonetime) {
		this.perMonthMaxphonetime = perMonthMaxphonetime;
	}

	/**
	 * @Description 获得 monitorPhoneNum
	 */
	public String getMonitorPhoneNum() {
		return monitorPhoneNum;
	}

	/**
	 * @Description:设置 monitorPhoneNum
	 */
	public void setMonitorPhoneNum(String monitorPhoneNum) {
		this.monitorPhoneNum = monitorPhoneNum;
	}

	/**
	 * @Description 获得 monitorplatMessageNum
	 */
	public String getMonitorplatMessageNum() {
		return monitorplatMessageNum;
	}

	/**
	 * @Description:设置 monitorplatMessageNum
	 */
	public void setMonitorplatMessageNum(String monitorplatMessageNum) {
		this.monitorplatMessageNum = monitorplatMessageNum;
	}

	/**
	 * @Description 获得 alarmshield
	 */
	public Integer getAlarmshield() {
		return alarmshield;
	}

	/**
	 * @Description:设置 alarmshield
	 */
	public void setAlarmshield(Integer alarmshield) {
		this.alarmshield = alarmshield;
	}

	/**
	 * @Description 获得 alarmSMS
	 */
	public Integer getAlarmSMS() {
		return alarmSMS;
	}

	/**
	 * @Description:设置 alarmSMS
	 */
	public void setAlarmSMS(Integer alarmSMS) {
		this.alarmSMS = alarmSMS;
	}

	/**
	 * @Description 获得 alarmPhoto
	 */
	public Integer getAlarmPhoto() {
		return alarmPhoto;
	}

	/**
	 * @Description:设置 alarmPhoto
	 */
	public void setAlarmPhoto(Integer alarmPhoto) {
		this.alarmPhoto = alarmPhoto;
	}

	/**
	 * @Description 获得 alarmphotoSave
	 */
	public Integer getAlarmphotoSave() {
		return alarmphotoSave;
	}

	/**
	 * @Description:设置 alarmphotoSave
	 */
	public void setAlarmphotoSave(Integer alarmphotoSave) {
		this.alarmphotoSave = alarmphotoSave;
	}

	/**
	 * @Description 获得 importantFlag
	 */
	public Integer getImportantFlag() {
		return importantFlag;
	}

	/**
	 * @Description:设置 importantFlag
	 */
	public void setImportantFlag(Integer importantFlag) {
		this.importantFlag = importantFlag;
	}

	/**
	 * @Description 获得 maxSpeed
	 */
	public Integer getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @Description:设置 maxSpeed
	 */
	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * @Description 获得 overspeedTime
	 */
	public Integer getOverspeedTime() {
		return overspeedTime;
	}

	/**
	 * @Description:设置 overspeedTime
	 */
	public void setOverspeedTime(Integer overspeedTime) {
		this.overspeedTime = overspeedTime;
	}

	/**
	 * @Description 获得 maxoverDriveTime
	 */
	public Integer getMaxoverDriveTime() {
		return maxoverDriveTime;
	}

	/**
	 * @Description:设置 maxoverDriveTime
	 */
	public void setMaxoverDriveTime(Integer maxoverDriveTime) {
		this.maxoverDriveTime = maxoverDriveTime;
	}

	/**
	 * @Description 获得 maxoverDrivePerday
	 */
	public Integer getMaxoverDrivePerday() {
		return maxoverDrivePerday;
	}

	/**
	 * @Description:设置 maxoverDrivePerday
	 */
	public void setMaxoverDrivePerday(Integer maxoverDrivePerday) {
		this.maxoverDrivePerday = maxoverDrivePerday;
	}

	/**
	 * @Description 获得 minResttime
	 */
	public Integer getMinResttime() {
		return minResttime;
	}

	/**
	 * @Description:设置 minResttime
	 */
	public void setMinResttime(Integer minResttime) {
		this.minResttime = minResttime;
	}

	/**
	 * @Description 获得 maxParktime
	 */
	public Integer getMaxParktime() {
		return maxParktime;
	}

	/**
	 * @Description:设置 maxParktime
	 */
	public void setMaxParktime(Integer maxParktime) {
		this.maxParktime = maxParktime;
	}

	/**
	 * @Description 获得 imageQuality
	 */
	public Integer getImageQuality() {
		return imageQuality;
	}

	/**
	 * @Description:设置 imageQuality
	 */
	public void setImageQuality(Integer imageQuality) {
		this.imageQuality = imageQuality;
	}

	/**
	 * @Description 获得 brightness
	 */
	public Integer getBrightness() {
		return brightness;
	}

	/**
	 * @Description:设置 brightness
	 */
	public void setBrightness(Integer brightness) {
		this.brightness = brightness;
	}

	/**
	 * @Description 获得 contrast
	 */
	public Integer getContrast() {
		return contrast;
	}

	/**
	 * @Description:设置 contrast
	 */
	public void setContrast(Integer contrast) {
		this.contrast = contrast;
	}

	/**
	 * @Description 获得 saturation
	 */
	public Integer getSaturation() {
		return saturation;
	}

	/**
	 * @Description:设置 saturation
	 */
	public void setSaturation(Integer saturation) {
		this.saturation = saturation;
	}

	/**
	 * @Description 获得 color
	 */
	public Integer getColor() {
		return color;
	}

	/**
	 * @Description:设置 color
	 */
	public void setColor(Integer color) {
		this.color = color;
	}

	/**
	 * @Description 获得 odometerReading
	 */
	public Integer getOdometerReading() {
		return odometerReading;
	}

	/**
	 * @Description:设置 odometerReading
	 */
	public void setOdometerReading(Integer odometerReading) {
		this.odometerReading = odometerReading;
	}

	/**
	 * @Description 获得 provinceId
	 */
	public Integer getProvinceId() {
		return provinceId;
	}

	/**
	 * @Description:设置 provinceId
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @Description 获得 cityId
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @Description:设置 cityId
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @Description 获得 carNum
	 */
	public String getCarNum() {
		return carNum;
	}

	/**
	 * @Description:设置 carNum
	 */
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	/**
	 * @Description 获得 carColor
	 */
	public Integer getCarColor() {
		return carColor;
	}

	/**
	 * @Description:设置 carColor
	 */
	public void setCarColor(Integer carColor) {
		this.carColor = carColor;
	}

	/**
	 * @Description 获得 electricFenceRadius
	 */
	public Integer getElectricFenceRadius() {
		return electricFenceRadius;
	}

	/**
	 * @Description:设置 electricFenceRadius
	 */
	public void setElectricFenceRadius(Integer electricFenceRadius) {
		this.electricFenceRadius = electricFenceRadius;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParaList [heartBeatTime=" + heartBeatTime + ", tcpResponseTime=" + tcpResponseTime + ", tcpReCon=" + tcpReCon + ", udpResponseTime="
				+ udpResponseTime + ", udpReCon=" + udpReCon + ", smsResponseTime=" + smsResponseTime + ", smsReCon=" + smsReCon + ", mainApn="
				+ mainApn + ", mainwirelessUser=" + mainwirelessUser + ", mainwirelesspassword=" + mainwirelesspassword + ", mainIP=" + mainIP
				+ ", backupApn=" + backupApn + ", backupwirelessUser=" + backupwirelessUser + ", backupwirelesspassword=" + backupwirelesspassword
				+ ", backupIP=" + backupIP + ", tcpport=" + tcpport + ", udpport=" + udpport + ", positionReturnPolicy=" + positionReturnPolicy
				+ ", positionReMethod=" + positionReMethod + ", driverNotLogtime=" + driverNotLogtime + ", sleepTime=" + sleepTime
				+ ", emergencytime=" + emergencytime + ", defaulttime=" + defaulttime + ", defaultdistance=" + defaultdistance
				+ ", driverNotLogdistance=" + driverNotLogdistance + ", sleepDistance=" + sleepDistance + ", emergencyDistance=" + emergencyDistance
				+ ", InflectionPoint=" + InflectionPoint + ", platphoneNum=" + platphoneNum + ", resetPhoneNum=" + resetPhoneNum
				+ ", restorefactoryPhoneNum=" + restorefactoryPhoneNum + ", platSMSnum=" + platSMSnum + ", recieveTerminalSMSnum="
				+ recieveTerminalSMSnum + ", terminalphonePolicy=" + terminalphonePolicy + ", perMaxphonetime=" + perMaxphonetime
				+ ", perMonthMaxphonetime=" + perMonthMaxphonetime + ", monitorPhoneNum=" + monitorPhoneNum + ", monitorplatMessageNum="
				+ monitorplatMessageNum + ", alarmshield=" + alarmshield + ", alarmSMS=" + alarmSMS + ", alarmPhoto=" + alarmPhoto
				+ ", alarmphotoSave=" + alarmphotoSave + ", importantFlag=" + importantFlag + ", maxSpeed=" + maxSpeed + ", overspeedTime="
				+ overspeedTime + ", maxoverDriveTime=" + maxoverDriveTime + ", maxoverDrivePerday=" + maxoverDrivePerday + ", minResttime="
				+ minResttime + ", maxParktime=" + maxParktime + ", imageQuality=" + imageQuality + ", brightness=" + brightness + ", contrast="
				+ contrast + ", saturation=" + saturation + ", color=" + color + ", odometerReading=" + odometerReading + ", provinceId="
				+ provinceId + ", cityId=" + cityId + ", carNum=" + carNum + ", carColor=" + carColor + ", electricFenceRadius="
				+ electricFenceRadius + "]";
	}

}
