
package com.et.terminalserver.api.model.ext;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: 车辆监控模块
 * @Description: InstrBack:指令反馈信息实体类（使用工具生成）
 * @author: xingxu
 * @date: 2014年3月14日 下午3:37:40
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

public  class InstrBack implements java.io.Serializable
{

	// 反馈ID
	private Integer backId;
	// sim编码
	private String simId; 
	// 反馈内容
	private String content;
	// 记录时间
	private Date recordTime;
	// 状态
	private String sendStatus;
	// 任务ID
	private Integer instrTaskId;
	// 指令的消息ID
	private String instrMsgId;
	// 车辆ID，为了保持整洁，统一8位，从10000000开始计算
	private Integer vehicleId;
	// 单位编号
	private String orgCode;
	// 文件ID，拍照和录音指令有用
	private String fileId;
	// 存储位置，拍照和录音指令有用
	private String filePath;
	// 行标功能编号
	private Integer termalFunctionId;
	// 操作时间
	private Date sendTime;
	// 指令类型
	private Integer orderType;
	// 回拨电话
	private String callbackPhone;
	// 消息流水号
	private Integer msgSerial;
	// 消息类型
	private String msgType;
	// 车辆点名记录id
	private Integer vehicleRollCallId;
	// 反馈状态
	private String backStatus;
	// 用户编号
	private String userCode;
	// 子级指令
	private String instructTypeChildId;


	public InstrBack()
	{
	}

	public InstrBack(Integer backId)
	{
		this.backId= backId;
	}

	public InstrBack(Integer backId,String simId,String content,Date recordTime,
			String sendStatus,Integer instrTaskId,String instrMsgId,Integer 
			vehicleId,String orgCode,String fileId,String filePath,
			Integer termalFunctionId,Date sendTime,Integer orderType,
			String callbackPhone,Integer msgSerial,String msgType,Integer vehicleRollCallId,String backStatus,String userCode)
	{	
		this.backId= backId;

		this.simId= simId;

		this.content= content;

		this.recordTime= recordTime;

		this.sendStatus= sendStatus;

		this.instrTaskId= instrTaskId;

		this.instrMsgId= instrMsgId;

		this.vehicleId= vehicleId;

		this.orgCode= orgCode;

		this.fileId= fileId;

		this.filePath= filePath;

		this.termalFunctionId= termalFunctionId;

		this.sendTime= sendTime;

		this.orderType= orderType;

		this.callbackPhone= callbackPhone;

		this.msgSerial= msgSerial;

		this.msgType= msgType;

		this.vehicleRollCallId= vehicleRollCallId;

		this.backStatus = backStatus;

		this.userCode = userCode;
	}



	/**
	 *反馈ID
	 */	
	 public  Integer getBackId()
	 {
		 return this.backId;
	 }

	 /**
	  *反馈ID
	  */

	 public void setBackId(Integer  backId)
	 {
		 this.backId= backId;
	 }


	 /**
	  *sim编码
	  */	
	 public  String getSimId()
	 {
		 return this.simId;
	 }

	 /**
	  *sim编码
	  */

	 public void setSimId(String  simId)
	 {
		 this.simId= simId;
	 }


	 /**
	  *反馈内容
	  */	
	 public  String getContent()
	 {
		 return this.content;
	 }

	 /**
	  *反馈内容
	  */

	 public void setContent(String  content)
	 {
		 this.content= content;
	 }


	 /**
	  *记录时间
	  */	
	 public  Date getRecordTime()
	 {
		 return this.recordTime;
	 }

	 /**
	  *记录时间
	  */
	 public void setRecordTime(Date  recordTime)
	 {
		 this.recordTime= recordTime;
	 }


	 /**
	  *#状态
	  */	
	 public  String getSendStatus()
	 {
		 return this.sendStatus;
	 }

	 /**
	  *#状态
	  */

	 public void setSendStatus(String  sendStatus)
	 {
		 this.sendStatus= sendStatus;
	 }


	 /**
	  *任务ID
	  */	
	 public  Integer getInstrTaskId()
	 {
		 return this.instrTaskId;
	 }

	 /**
	  *任务ID
	  */

	 public void setInstrTaskId(Integer  instrTaskId)
	 {
		 this.instrTaskId= instrTaskId;
	 }


	 /**
	  *指令的消息ID
	  */	
	 public  String getInstrMsgId()
	 {
		 return this.instrMsgId;
	 }

	 /**
	  *指令的消息ID
	  */

	 public void setInstrMsgId(String  instrMsgId)
	 {
		 this.instrMsgId= instrMsgId;
	 }


	 /**
	  *车辆ID，为了保持整洁，统一8位，从10000000开始计算
	  */	
	 public  Integer getVehicleId()
	 {
		 return this.vehicleId;
	 }

	 /**
	  *车辆ID，为了保持整洁，统一8位，从10000000开始计算
	  */

	 public void setVehicleId(Integer  vehicleId)
	 {
		 this.vehicleId= vehicleId;
	 }


	 /**
	  *单位编号
	  */	
	 public  String getOrgCode()
	 {
		 return this.orgCode;
	 }

	 /**
	  *单位编号
	  */

	 public void setOrgCode(String  orgCode)
	 {
		 this.orgCode= orgCode;
	 }


	 /**
	  *文件ID，拍照和录音指令有用
	  */	
	 public  String getFileId()
	 {
		 return this.fileId;
	 }

	 /**
	  *文件ID，拍照和录音指令有用
	  */

	 public void setFileId(String  fileId)
	 {
		 this.fileId= fileId;
	 }


	 /**
	  *存储位置，拍照和录音指令有用
	  */	
	 public  String getFilePath()
	 {
		 return this.filePath;
	 }

	 /**
	  *存储位置，拍照和录音指令有用
	  */

	 public void setFilePath(String  filePath)
	 {
		 this.filePath= filePath;
	 }


	 /**
	  *行标功能编号
	  */	
	 public  Integer getTermalFunctionId()
	 {
		 return this.termalFunctionId;
	 }

	 /**
	  *行标功能编号
	  */

	 public void setTermalFunctionId(Integer  termalFunctionId)
	 {
		 this.termalFunctionId= termalFunctionId;
	 }


	 /**
	  *操作时间
	  */	
	 public  Date getSendTime()
	 {
		 return this.sendTime;
	 }

	 /**
	  *操作时间
	  */
	 public void setSendTime(Date  sendTime)
	 {
		 this.sendTime= sendTime;
	 }


	 /**
	  *指令类型
	  */	
	 public  Integer getOrderType()
	 {
		 return this.orderType;
	 }

	 /**
	  *指令类型
	  */

	 public void setOrderType(Integer  orderType)
	 {
		 this.orderType= orderType;
	 }


	 /**
	  *回拨电话
	  */	
	 public  String getCallbackPhone()
	 {
		 return this.callbackPhone;
	 }

	 /**
	  *回拨电话
	  */

	 public void setCallbackPhone(String  callbackPhone)
	 {
		 this.callbackPhone= callbackPhone;
	 }


	 /**
	  *消息流水号
	  */	
	 public  Integer getMsgSerial()
	 {
		 return this.msgSerial;
	 }

	 /**
	  *消息流水号
	  */

	 public void setMsgSerial(Integer  msgSerial)
	 {
		 this.msgSerial= msgSerial;
	 }


	 /**
	  *消息类型
	  */	
	 public  String getMsgType()
	 {
		 return this.msgType;
	 }

	 /**
	  *消息类型
	  */

	 public void setMsgType(String  msgType)
	 {
		 this.msgType= msgType;
	 }

	 /**
	  *VehicleRollCallid:车辆点名记录id
	  */
	 public Integer getVehicleRollCallId() {
		 return vehicleRollCallId;
	 }

	 /**
	  *VehicleRollCallid:车辆点名记录id
	  */
	 public void setVehicleRollCallId(Integer rollcallid) {
		 this.vehicleRollCallId = rollcallid;
	 }
	 /**
	  *InstructTypeChildId:子级指令ID
	  */
	 public String getInstructTypeChildId() {
		 return instructTypeChildId;
	 }

	 /**
	  *InstructTypeChildId:车辆点名记录id
	  */
	 public void setInstructTypeChildId(String instructTypeChildId) {
		 this.instructTypeChildId = instructTypeChildId;
	 }
	 /**
	  *反馈状态
	  */	
	 public  String getBackStatus()
	 {
		 return this.backStatus;
	 }

	 /**
	  *反馈状态
	  */

	 public void setBackStatus(String  backStatus)
	 {
		 this.backStatus= backStatus;
	 }
	 /**
	  *用户编码
	  */	
	 public String getUserCode() {
		 return userCode;
	 }
	 /**
	  *用户编码
	  */	
	 public void setUserCode(String userCode) {
		 this.userCode = userCode;
	 }



}

