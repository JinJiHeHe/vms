package com.et.terminalserver.protocols.business.bo;

import java.util.Map;
import java.util.TreeMap;

public class TDTerminalParamSet extends BusinessObject {

	public static int ID_0x0001 = 0x0001;
	public static int ID_0x0002 = 0x0002;
	public static int ID_0x0003 = 0x0003;
	public static int ID_0x0004 = 0x0004;
	public static int ID_0x0005 = 0x0005;
	public static int ID_0x0006 = 0x0006;
	public static int ID_0x0007 = 0x0007;
	public static int ID_0x0018 = 0x0018;
	public static int ID_0x0019 = 0x0019;
	public static int ID_0x0020 = 0x0020;
	public static int ID_0x0021 = 0x0021;
	public static int ID_0x0022 = 0x0022;
	public static int ID_0x0027 = 0x0027;
	public static int ID_0x0028 = 0x0028;
	public static int ID_0x0029 = 0x0029;
	public static int ID_0x002C = 0x002C;
	public static int ID_0x002D = 0x002D;
	public static int ID_0x002E = 0x002E;
	public static int ID_0x002F = 0x002F;
	public static int ID_0x0030 = 0x0030;
	public static int ID_0x0045 = 0x0045;
	public static int ID_0x0046 = 0x0046;
	public static int ID_0x0047 = 0x0047;
	public static int ID_0x0050 = 0x0050;
	public static int ID_0x0051 = 0x0051;
	public static int ID_0x0052 = 0x0052;
	public static int ID_0x0053 = 0x0053;
	public static int ID_0x0054 = 0x0054;
	public static int ID_0x0055 = 0x0055;
	public static int ID_0x0056 = 0x0056;
	public static int ID_0x0057 = 0x0057;
	public static int ID_0x0058 = 0x0058;
	public static int ID_0x0059 = 0x0059;
	public static int ID_0x005A = 0x005A;
	public static int ID_0x0070 = 0x0070;
	public static int ID_0x0071 = 0x0071;
	public static int ID_0x0072 = 0x0072;
	public static int ID_0x0073 = 0x0073;
	public static int ID_0x0074 = 0x0074;
	public static int ID_0x0080 = 0x0080;
	public static int ID_0x0081 = 0x0081;
	public static int ID_0x0082 = 0x0082;
	public static int ID_0x0083 = 0x0083;
	public static int ID_0x0084 = 0x0084;
	public static int ID_0x0010 = 0x0010;
	public static int ID_0x0011 = 0x0011;
	public static int ID_0x0012 = 0x0012;
	public static int ID_0x0013 = 0x0013;
	public static int ID_0x0014 = 0x0014;
	public static int ID_0x0015 = 0x0015;
	public static int ID_0x0016 = 0x0016;
	public static int ID_0x0017 = 0x0017;
	public static int ID_0x0040 = 0x0040;
	public static int ID_0x0041 = 0x0041;
	public static int ID_0x0042 = 0x0042;
	public static int ID_0x0043 = 0x0043;
	public static int ID_0x0044 = 0x0044;
	public static int ID_0x0048 = 0x0048;
	public static int ID_0x0049 = 0x0049;

	private int paramCount;// 参数总数
	private int packageCount;// 包参数个数

	// ID表示参数ID Value表示这个参数代表的内容
	private Map<String, String[]> settings;

	/**
	 * @Description 获得 paramCount
	 */
	public int getParamCount() {
		return paramCount;
	}

	/**
	 * @Description:设置 paramCount
	 */
	public void setParamCount(int paramCount) {
		this.paramCount = paramCount;
	}

	/**
	 * @Description 获得 packageCount
	 */
	public int getPackageCount() {
		return packageCount;
	}

	/**
	 * @Description:设置 packageCount
	 */
	public void setPackageCount(int packageCount) {
		this.packageCount = packageCount;
	}

	/**
	 * @Description 获得 settings
	 */
	public Map<String, String[]> getSettings() {
		return settings;
	}

	/**
	 * @Description:设置 settings
	 */
	public void setSettings(Map<String, String[]> settings) {
		this.settings = settings;
	}

	public TDTerminalParamSet() {
		super();
		this.settings = new TreeMap<String, String[]>();
	}

	@Override
	public int getBusinessCode() {
		return PD_TERMINALPARAMSET;
	}
}
