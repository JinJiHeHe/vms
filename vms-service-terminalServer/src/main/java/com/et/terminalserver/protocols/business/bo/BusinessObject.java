package com.et.terminalserver.protocols.business.bo;

public abstract class BusinessObject {

	/**
	 * OP是内部操作，S是状态，PR是平台响应，PD是下发指令，TU是终端上报，TR是终端响应 <=0 的码全都是指令要回复的那些乱七八糟的，要传给前台
	 */

	/** 下线 */
	public static final int OP_OFFLINE = 0x2002;
	/** 发送数据 */
	public static final int OP_SEND_DATA = 0x2000;
	/** 指令下发 */
	public static final int OP_COMMAND = 0x2001;

	/** 填充信息 */
	public static final int OP_FILLINFO = 0x2003;

	public static final int OP_UPDATE = 0x2004;

	/** 平台响应 */
	public static final int PR_PLANT_RESPONSE = 0x8001;
	/** 注册应答 */
	public static final int PR_REGISTER_RESPONSE = 0x8100;
	/** 不给予响应的信息 */
	public static final int PR_NO_RESPONSE = -0x0000;
	/** 多媒体上报应答 */
	public static final int PR_MUTI_MEDIA_RESPONSE = -0x8800;

	/**
	 * --------------------------处理状态标识-----------------------------------------
	 */

	/** 接收了 */
	public static final int S_ACCEPT = 0;
	/** 没接收 */
	public static final int S_UNACCEPT = -1;

	/**
	 * --------------------------业务对象BusinussCode------------------------------
	 * ---
	 */
	/** 注销 */
	public static final int TU_UNREGISTER = 0x0003;
	/** 接入GPS数据 */
	public static final int TU_RECEIVE_GPS = 0x0200;

	/** 注册 */
	public static final int TU_REGISTER = 0x0100;
	/** 鉴权 */
	public static final int TU_CHECK = 0x0102;
	/** 心跳 */
	public static final int TU_HEART = 0x0002;
	/** 多媒体上报 */
	public static final int TU_MUTI_MEDIA = 0x0801;
	/** 多媒体事件 */
	public static final int TU_MUTI_MEDIA_EVENT = 0x0800;

	/** 驾驶员身份信息采集上报 */
	public static final int TD_DRIVERINFO = 0x0702;
	/** 电子运单 */
	public static final int TD_ORDER = 0x0701;
	

	/** 通用应答 */
	public static final int TR_COMMON_RESPONSE = 0x0001;
	/** 位置响应 */
	public static final int TR_POSITION_RESPONSE = 0x0201;
	/** 状态检测响应 */
	public static final int TR_STATUS_RESPONSE = 0x0202;
	/** 行驶记录仪上传数据 */
	public static final int TR_TRAVELDATA = 0x0700;
	/** 查询终端参数应答 */
	public static final int TR_QUERYTERMINALPARAMRESPONSE = 0x0104;
	/** 多媒体上报响应 */
	public static final int TR_MUTI_MEDIA_RESPONSE = 0x8800;
	/** 文本下发 */
	public static final int PD_TEXT = 0x8300;
	/** 电话回拨 */
	public static final int PD_CALLBACK = 0x8400;
	/** 点名|位置检测 */
	public static final int PD_LOCATIONSTATE = 0x8201;
	/** 立即拍照 */
	public static final int PD_TAKEPHOTO = 0x8801;
	/** 终端参数设置(好几个都走这个类) */
	public static final int PD_TERMINALPARAMSET = 0x8103;
	/** 终端控制 */
	public static final int PD_TERMINALCONTROL = 0x8105;
	/** 定时回报设置 */
	public static final int PD_RETURNBYTIME = 0x0020;
	/** 设置IP和端口 */
	public static final int PD_SETIPANDPORT = 0x0013;
	/** 电话本 */
	public static final int PD_TELEPHONEBOOK = 0x8401;
	/** 设置中心号码 */
	public static final int PD_MAINNUMBERSET = 0x0040;
	/** 设置IP和端口 */
	public static final int PD_SETIPANDPORT2 = 0x0014;
	/** 终端心跳间隔 */
	public static final int PD_HEARTBEATINTERVAL = 0x0001;
	/** 定距离回传 */
	public static final int PD_SETUPBYDISTANCE = 0x0029;
	/** 定时定距回传 */
	public static final int PD_SETUPBYDISTANCEANDTIME = 0x0030;
	/** TCP消息应答超时时间 */
	public static final int PD_SETTCPTIMEOUT = 0x0002;
	/** TCP消息重连次数 */
	public static final int PD_SETTCPRECONNECT = 0x0003;
	/** SMS超时时间 */
	public static final int PD_SMSTIMEOUT = 0x0006;
	/** SMS消息重传次数 */
	public static final int PD_SMSRECONNECT = 0x0007;
	/** 超速报警速度设置 */
	public static final int PD_SETALARMSPEED = 0x0055;
	/** 超速报警持续时间设置 */
	public static final int PD_SETALARMSPEEDTIME = 0x0056;
	/** 车门控制 */
	public static final int PD_DOORCONTROL = 0x8500;
	/** 录音 */
	public static final int PD_RECORD = 0x8804;
	/** 行驶记录仪采集 */
	public static final int PD_TRAVELDATARECORDER = 0x8700;

	public static final int TU_PASSTHROUGH = 0x0900;
	/** 查询终端参数 */
	public static final int PD_QUERYTERMINALPARAM = 0x8104;
	/** 临时位置跟踪 */
	public static final int PD_TEMPORARYPOSITIONTRACKING = 0x8202;
	/** 人工确认报警 */
	public static final int PD_MANUALCONFIRMATIONALARM = 0x8203;
	
	/**  */
	public static final int PD_CIRCLE_AREA = 0x8600;
	
	public static final int PD_RECTANGLE_AREA = 0x8602;
	
	public static final int PD_POLYGON_AREA = 0x8604;
	
	public static final int PD_CIRCLE_AREA_DELETE = 0x8601;
	
	public static final int PD_RECTANGLE_AREA_DELETE = 0x8603;
	
	public static final int PD_POLYGON_AREA_DELETE = 0x8605;

	public static final int PD_LIMITPHONE = 0x0057;

	public static final int PD_CLOSEALARM = 0x0050;
	/** 响应值 */
	private int responseCode;
	/** 终端唯一标识 */
	private String terminalKey;
	/** 接收状态 */
	private int acceptState;

	public abstract int getBusinessCode();

	public void setResponseCode(int code) {
		this.responseCode = code;
	}

	public int getResponseCode() {
		return this.responseCode;
	}

	public void setTerminalKey(String terminalKey) {
		this.terminalKey = terminalKey;
	}

	public String getTerminalKey() {
		return this.terminalKey;
	}

	public void setAcceptState(int state) {
		this.acceptState = state;
	}

	public int getAcceptState() {
		return this.acceptState;
	}
}
