package com.et.terminalserver.api;


import com.et.terminalserver.api.model.GpsInfo;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * @Description 报警工具类，描述了部标终端报警类型和其对应编号
 * @author maple
 * @version V1.0
 * @Date 2016年4月7日
 * @mail rw222222@126.com
 */
public class AlarmUtil {

	/** 紧急报警 */
	public static int Emergency_Alarm = 0;
	/** 终端超速报警 */
	public static int Speed_Alarm_Terminal = 1;
	/** 疲劳驾驶 */
	public static int Fatigue_Driving = 2;
	/** 预警 */
	public static int Early_Alarm = 3;
	/** GNSS模块发生故障报警 */
	public static int GNSS_Model_Alarm = 4;
	/** GNSS天线未接或被剪断 */
	public static int GNSS_AirWire_Alarm = 5;
	/** GNSS天线短路 */
	public static int GNSS_AirWireShort_Alarm = 6;
	/** 终端主电源欠压 */
	public static int Terminal_Main_Power_Supply = 7;
	/** 终端主电源掉电 */
	public static int Power_Off_The_Main_Power_Supply = 8;
	/** 终端LCD或显示器故障 */
	public static int Terminal_LCD_Or_Monitor_Failure = 9;
	/** TTS模块故障 */
	public static int TTS_Model_Alarm = 10;
	/** 摄像头故障 */
	public static int Camera_Alarm = 11;
	/** 平台超速报警 */
	public static int Speed_Alarm_Platform = 12;
	/** 平台疲劳驾驶报警 */
	public static int FatigueDrivingAlarm_Platform = 13;
	/** 禁止驶入报警 */
	public static int NotArriveIn_Platform = 14;
	/** 禁止驶出报警 */
	public static int NotArriveOut_Platform = 15;
	/** 偏离路线报警 */
	public static int DeviationRoute_Platform = 16;
	/** 当天累计驾驶超时 */
	public static int Day_Dumulative_Driving_Timeout = 18;
	/** 超时停车 */
	public static int Timeout_Parking = 19;
	/** 进出区域 */
	public static int Out_And_Out_Area = 20;
	/** 进出路线 */
	public static int Out_And_Out_Line = 21;
	/** 路段行驶时间不足/过长 */
	public static int Road_Running_Time_Insufficient_Or_Long = 22;
	/** 路线偏离报警 */
	public static int DeviationRoute = 23;
	/** 车辆VSS故障 */
	public static int VihecleVSS_Alarm = 24;
	/** 车辆油量异常 */
	public static int VihecleOil_Alarm = 25;
	/** 车辆被盗 */
	public static int Vehicle_Theft_Alarm = 26;
	/** 车辆非法点火 */
	public static int Vehicle_Ignition = 27;
	/** 车辆非法位移 */
	public static int Vehicle_Illegal_Displacement = 28;

	private static String[] strAlarm = { "紧急报警", // 0
			"超速报警", // 1
			"疲劳驾驶", // 2
			"危险预警", // 3
			"GNSS模块发生故障", // 4
			"GNSS天线未接或被剪断", // 5
			"GNSS天线短路", // 6
			"终端主电源欠压", // 7
			"终端主电源掉电", // 8
			"终端LCD或显示器故障", // 9
			"TTS模块故障", // 10
			"摄像头故障", // 11
			"道路运输证IC卡模块故障", // 12
			"超速预警", // 13
			"疲劳驾驶预警", // 14
			"", // 15
			"", // 16
			"", // 17
			"当天累计驾驶超时", // 18
			"超时停车", // 19
			"进出区域", // 20
			"进出路线", // 21
			"路段行驶时间不足/过长", // 22
			"路线偏离报警", // 23
			"车辆VSS故障", // 24
			"车辆油量异常", // 25
			"车辆被盗", // 26
			"车辆非法点火", // 27
			"车辆非法位移", // 28
			"碰撞预警", // 29
			"侧翻预警", // 30
			"非法开门报警",// 31
	};

	/**
	 * 根据编号获取报警名称
	 */
	public static String getAlarmName(int i) {
		if (i >= 28) {
			return "";
		} else {
			return strAlarm[i];
		}
	}

	/**
	 * 根据gps定位信息，判断对应的报警类型
	 * 
	 * @param info
	 *            定位信息
	 */
	public static List<Integer> analysisAlarmTag(GpsInfo info) {
		List<Integer> list = new ArrayList<Integer>();
		if (info.getAlarmTag() > 0) {
			// 根据报警标志位逐个报警进行判断
			BitSet bs = BitSet.valueOf(new long[] { info.getAlarmTag() });
			for (int i = bs.nextSetBit(0); i >= 0; i = bs.nextSetBit(i + 1)) {
				list.add(i);
			}
		}
		return list;
	}

	// public static void listener(String[] args) {
	// GpsInfo info = new GpsInfo();
	// info.setAlarmTag(1073823745);
	// System.out.println(analysisAlarmTag(info));
	// }
}
