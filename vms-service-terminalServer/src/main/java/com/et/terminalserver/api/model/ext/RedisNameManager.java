package com.et.terminalserver.api.model.ext;

public class RedisNameManager {

	/**传送GPS实时数据*/
	final public static String GPSINFO_CHANNEL="vms_zwnet_channel_gpsinfo";
	/**静态数据对象--terminal信息*/
	final public static String TERMINALINFO_CHANNEL="vms_zwnet_channel_terminalinfo";
	/**静态数据对象--vehicle信息 */
	final public static String VEHICELINFO_CHANNEL="vms_zwnet_channel_vehicelinfo";
	/**静态数据对象--SIM信息*/
	final public static String SIMINFO_CHANNEL="vms_zwnet_channel_siminfo";
	/**指令响应通道*/
	final public static String COMMANDRESPONSE_CHANNEL="vms_zwnet_channel_commandResponse";
	/**指令请求通道*/
	final public static String COMMANDREQUEST_CHANNEL="vms_zwnet_channel_commandRequest";
	/**基础信息更新通道*/
	final public static String BASEINFOUPDATE_CHANNEL="vms_zwnet_channel_baseInfoUpdate";
	/**报警参数通道*/
	final public static String ALARMPARAM_CHANNEL="vms_zwnet_channel_alarmParam";
	/**报警参数存储缓存*/
	final public static String ALARMPARAM_CACHE="vms_zwnet_cache_alarmParam";
	/**其他组织机构车辆*/
	final public static String OTHERVEHICLE_CACHE="vms_wy_cahce_otherVehicle";
	/**报警类型  key:alarmTypeId value:SAlarmType (json)*/
	final public static String ALARMTYPE_CACHE="vms_wy_cahce_alarmType";
	/**组织机构缓存 key:orgCode value:SOrgInfo (json)*/
	final public static String ORG_CHACHE="vms_wy_cahce_org";
	/**车辆对应驾驶员缓存*/
	final public static String VEHICLE2USER_CACHE="static-vms-vehicle2users";
	/**车辆信息缓存 key:terminalId value:STerminalInfo*/
	final public static String STATICTERMINAL_CACHE="static-vms-terminalInfo";
	/**万恶的5点缓存*/
	final public static String GPSHIS_CACHE="vms_wy_cahce_gps_his";
	/**车牌对应vid* /
	final public static String PLATE2VID_CACHE="static-plateNumber2vid";
	/**用户静态信息 key:USER_ID value:SUserInfo*/
	final public static String USERINFO_CACHE="static-vms-userInfo";
	/**组织机构对应vid*/
	final public static String ORG2VID_CACHE="static-orgCode2vid";
	/**系统参数*/
	final public static String SYSCONFIG_CACHE="vms_wy_cahce_sysconfig";
	/**GPS-JSON*/
	final public static String GPSJSON_CACHE="vms_wy_cahce_gps_json";
	/**驾驶员信息 key:driverId value:SDriverInfo*/
	final public static String DRIVER_CACHE="static-vms-driver";
	/**车辆静态信息 key:vehicleId value:SVehicleInfo*/ 
	final public static String VEHICLE_CACHE="static-vms-vehicleInfo";
	/**系统函数 key:URL value:SSysFunction(json)*/
	final public static String SYSFUN_CACHE="vms_wy_cahce_sysFunction";
	/**上级平台列表 key:plateformId value:SUpPlateformConfig(json)*/
	final public static String UPPERLIST_CACHE="vms_wy_cahce_upperlist";
	/**组织机构静态信息 key:orgCode value:DOrgTreeInfo (json)*/
	final public static String ORGINFO_CACHE="vms_wy_cahce_orgstatic";
	/**上级平台上报车辆更新通道*/
	final public static String UPPER_VEHICLES_CHANNEL = "vms_zwnet_channel_809vidMapPlates";
	/**圈车缓存 车辆对应上级平台列表*/
	final public static String VEHICLE_TO_PLATES="vms_zwent_cache_vehicleToPlates";
	/**809前台至后台消息通道*/
	public static final String COMMAND_WEB_TO_809_CHANNEL = "vms_zwent_channel_dataforwardwebTo809";	
	/**809后台至前台消息通道*/
	public static final String COMMAND_809_TO_WEB_CHANNEL = "vms_zwent_channel_dataforward809Toweb";
	
	
}
