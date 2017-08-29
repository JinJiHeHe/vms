package com.et.terminalserver.terminalaccess.baseinfo;

import com.et.terminalserver.api.model.SimCardInfo;
import com.et.terminalserver.api.model.TerminalInfo;
import com.et.terminalserver.api.model.VehicleInfo;
import com.et.terminalserver.api.model.ext.BaseInfoUpdateEntity;
import com.et.terminalserver.api.model.ext.UpperList;

import java.util.List;

public interface BaseInfo {

	/**
	 * 以车辆id为key来索引车辆数据
	 * 
	 * @param vid
	 *            车辆id
	 * @return 车辆信息
	 */
	VehicleInfo getVechileInfo(String vid);

	/**
	 * 以终端编号为key来索引终端信息
	 * 
	 * @param terminalCode
	 *            终端编号
	 * @return 終端信息
	 */
	TerminalInfo getTerminalInfo(String terminalCode);

	/**
	 * 以电话号为key来索引sim卡信息
	 * 
	 * @param simNum
	 *            电话号
	 * @return  sim卡信息
	 */
	SimCardInfo getSimCardInfo(String simNum);
	
	
	int BaseInfoUpdate(BaseInfoUpdateEntity baseinfoEntity);
	
	/**
	 *  车辆和上级平台的关系更新
	 * */
	int vehicleToPlateUpdate(UpperList upperList);
	
	/**
	 *  通过vid得到转发平台列表
	 * */
	List<String> getVechileToPlatforms(String vid);
	
	/**
	 *  服务启动去缓存加载车辆和转发平台列表
	 * */
	int loadVehicleToPlateForms();
		
}
