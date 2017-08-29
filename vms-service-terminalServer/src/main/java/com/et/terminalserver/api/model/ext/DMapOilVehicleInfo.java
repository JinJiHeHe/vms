package com.et.terminalserver.api.model.ext;

import java.sql.Timestamp;

/**
 * @Description 油罐车信息
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:50:14
 * @mail terrorbladeyang@gmail.com
 */

public class DMapOilVehicleInfo {

	// 车辆ID

	private int VEHICLE_ID;

	// 车牌号

	private String ID_NUMBER;

	// 终端编号

	private int TERMINAL_ID;

	// 运单编号

	private int WAYBILL_CODE;

	// 所属单位

	private String ORG_CODE;

	// 车速

	private int SPEED;

	// 经度

	private int LON;

	// 纬度

	private int LAT;

	// 油品种类

	private String GASOLINE_TYPE;

	// 仓编号

	private int STORE_NUMBER;

	// 油压

	private int OIL_PRESSURE;

	// 油温

	private int OIL_TEMPERATURE;

	// 胎压

	private int TIRE_PRESSURE;

	// 液位

	private int LIQUID_LEVEL;

	// 阀门状态

	private String VALVE_STATE;

	// 电子铅封状态

	private String ELECTRONIC_SEALING_STATE;

	// 最近一次施封时间

	private Timestamp LAST_SEALING_TIME;

	// 最近一次解封时间

	private Timestamp LAST_DEBLOCKING_TIME;

	// 最近一次到达的业务点的名称

	private String LAST_BUSINESSPOINT;

	// 设备状况

	private String EQUIPMENT_STATUS;

	// 故障信息

	private String FAULT_INFO;

	public int getVEHICLE_ID() {
		return VEHICLE_ID;
	}

	public void setVEHICLE_ID(int vEHICLE_ID) {
		VEHICLE_ID = vEHICLE_ID;
	}

	public String getID_NUMBER() {
		return ID_NUMBER;
	}

	public void setID_NUMBER(String iD_NUMBER) {
		ID_NUMBER = iD_NUMBER;
	}

	public int getTERMINAL_ID() {
		return TERMINAL_ID;
	}

	public void setTERMINAL_ID(int tERMINAL_ID) {
		TERMINAL_ID = tERMINAL_ID;
	}

	public int getWAYBILL_CODE() {
		return WAYBILL_CODE;
	}

	public void setWAYBILL_CODE(int wAYBILL_CODE) {
		WAYBILL_CODE = wAYBILL_CODE;
	}

	public String getORG_CODE() {
		return ORG_CODE;
	}

	public void setORG_CODE(String oRG_CODE) {
		ORG_CODE = oRG_CODE;
	}

	public int getSPEED() {
		return SPEED;
	}

	public void setSPEED(int sPEED) {
		SPEED = sPEED;
	}

	public int getLON() {
		return LON;
	}

	public void setLON(int lON) {
		LON = lON;
	}

	public int getLAT() {
		return LAT;
	}

	public void setLAT(int lAT) {
		LAT = lAT;
	}

	public String getGASOLINE_TYPE() {
		return GASOLINE_TYPE;
	}

	public void setGASOLINE_TYPE(String gASOLINE_TYPE) {
		GASOLINE_TYPE = gASOLINE_TYPE;
	}

	public int getSTORE_NUMBER() {
		return STORE_NUMBER;
	}

	public void setSTORE_NUMBER(int sTORE_NUMBER) {
		STORE_NUMBER = sTORE_NUMBER;
	}

	public int getOIL_PRESSURE() {
		return OIL_PRESSURE;
	}

	public void setOIL_PRESSURE(int oIL_PRESSURE) {
		OIL_PRESSURE = oIL_PRESSURE;
	}

	public int getOIL_TEMPERATURE() {
		return OIL_TEMPERATURE;
	}

	public void setOIL_TEMPERATURE(int oIL_TEMPERATURE) {
		OIL_TEMPERATURE = oIL_TEMPERATURE;
	}

	public int getTIRE_PRESSURE() {
		return TIRE_PRESSURE;
	}

	public void setTIRE_PRESSURE(int tIRE_PRESSURE) {
		TIRE_PRESSURE = tIRE_PRESSURE;
	}

	public int getLIQUID_LEVEL() {
		return LIQUID_LEVEL;
	}

	public void setLIQUID_LEVEL(int lIQUID_LEVEL) {
		LIQUID_LEVEL = lIQUID_LEVEL;
	}

	public String getVALVE_STATE() {
		return VALVE_STATE;
	}

	public void setVALVE_STATE(String vALVE_STATE) {
		VALVE_STATE = vALVE_STATE;
	}

	public String getELECTRONIC_SEALING_STATE() {
		return ELECTRONIC_SEALING_STATE;
	}

	public void setELECTRONIC_SEALING_STATE(String eLECTRONIC_SEALING_STATE) {
		ELECTRONIC_SEALING_STATE = eLECTRONIC_SEALING_STATE;
	}

	public Timestamp getLAST_SEALING_TIME() {
		return LAST_SEALING_TIME;
	}

	public void setLAST_SEALING_TIME(Timestamp lAST_SEALING_TIME) {
		LAST_SEALING_TIME = lAST_SEALING_TIME;
	}

	public Timestamp getLAST_DEBLOCKING_TIME() {
		return LAST_DEBLOCKING_TIME;
	}

	public void setLAST_DEBLOCKING_TIME(Timestamp lAST_DEBLOCKING_TIME) {
		LAST_DEBLOCKING_TIME = lAST_DEBLOCKING_TIME;
	}

	public String getLAST_BUSINESSPOINT() {
		return LAST_BUSINESSPOINT;
	}

	public void setLAST_BUSINESSPOINT(String lAST_BUSINESSPOINT) {
		LAST_BUSINESSPOINT = lAST_BUSINESSPOINT;
	}

	public String getEQUIPMENT_STATUS() {
		return EQUIPMENT_STATUS;
	}

	public void setEQUIPMENT_STATUS(String eQUIPMENT_STATUS) {
		EQUIPMENT_STATUS = eQUIPMENT_STATUS;
	}

	public String getFAULT_INFO() {
		return FAULT_INFO;
	}

	public void setFAULT_INFO(String fAULT_INFO) {
		FAULT_INFO = fAULT_INFO;
	}

	@Override
	public String toString() {
		return "DMapOilVehicleInfo [VEHICLE_ID=" + VEHICLE_ID + ", ID_NUMBER=" + ID_NUMBER + ", TERMINAL_ID="
				+ TERMINAL_ID + ", WAYBILL_CODE=" + WAYBILL_CODE + ", ORG_CODE=" + ORG_CODE + ", SPEED=" + SPEED
				+ ", LON=" + LON + ", LAT=" + LAT + ", GASOLINE_TYPE=" + GASOLINE_TYPE + ", STORE_NUMBER="
				+ STORE_NUMBER + ", OIL_PRESSURE=" + OIL_PRESSURE + ", OIL_TEMPERATURE=" + OIL_TEMPERATURE
				+ ", TIRE_PRESSURE=" + TIRE_PRESSURE + ", LIQUID_LEVEL=" + LIQUID_LEVEL + ", VALVE_STATE=" + VALVE_STATE
				+ ", ELECTRONIC_SEALING_STATE=" + ELECTRONIC_SEALING_STATE + ", LAST_SEALING_TIME=" + LAST_SEALING_TIME
				+ ", LAST_DEBLOCKING_TIME=" + LAST_DEBLOCKING_TIME + ", LAST_BUSINESSPOINT=" + LAST_BUSINESSPOINT
				+ ", EQUIPMENT_STATUS=" + EQUIPMENT_STATUS + ", FAULT_INFO=" + FAULT_INFO + "]";
	}

}
