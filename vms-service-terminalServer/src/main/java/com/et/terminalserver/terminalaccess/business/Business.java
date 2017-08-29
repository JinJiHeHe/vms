package com.et.terminalserver.terminalaccess.business;


import com.et.terminalserver.api.GisCompute;
import com.et.terminalserver.protocols.business.bo.*;
import com.et.terminalserver.terminalaccess.baseinfo.BaseInfo;
import com.et.terminalserver.terminalaccess.netty.Packet;

/**
 * 业务接口
 * */
public interface Business {

	/**
	 * 终端离线
	 * */
	TUGpsInfo terminalOffLine(OPOffLine opOffLine);

	/**
	 * 接收gps信息
	 * */
	TUGpsInfo receiveGpsInfo(TUGpsInfo info, Packet packet);

	/**
	 * 终端注册
	 * */
	TURegister registerTerminal(TURegister register, Packet packet);

	/**
	 * 检测终端
	 * */
	TUCheck checkTerminal(TUCheck check, Packet packet);

	/**
	 * 心跳
	 * */
	TUHeart receiveHeart(TUHeart heart, Packet packet);

//	/**
//	 * 报警计算依赖
//	 *
//	 * @param alarm
//	 */
//	void setAlarm(AlarmCompute alarm);

	/**
	 * 基础信息依赖
	 * 
	 * @param baseinfo
	 */
	void setBaseinfo(BaseInfo baseinfo);

	/**
	 * gis功能依赖
	 * 
	 * @param gis
	 */
	void setGis(GisCompute gis);
	/**
	 * 透传数据
	 * @param passThrough
	 * @param packet_passthrough
	 * @return
	 */
	TUPassThrough passThrough(TUPassThrough passThrough, Packet packet_passthrough);
	
//	TUOrder receiveOrder(TUOrder order,Packet packet);
//	
//
//	TUDriverInfo receiveDriverInfo(TUDriverInfo driver, Packet packet_driver);
	
}
