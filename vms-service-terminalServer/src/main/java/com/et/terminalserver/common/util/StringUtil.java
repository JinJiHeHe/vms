package com.et.terminalserver.common.util;

/**
 * @Project CNPC_VMS
 * @Title StringUtil
 * @Description 字符串小工具
 * @author guanhl
 * @date 2014年10月8日 下午10:19:33
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public class StringUtil {

	/**
	 * @Description:字符串左边填充
	 */
	public static String padding(String str, String charc, int len) {
		StringBuffer sbf = new StringBuffer("");

		// 放左边
		for (int i = 0; i < len - str.length(); i++) {
			sbf.append(charc);
		}
		return sbf.toString() + str;
	}
}
