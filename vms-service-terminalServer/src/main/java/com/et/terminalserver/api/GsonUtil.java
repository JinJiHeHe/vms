package com.et.terminalserver.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Description json工具类，获取gson对象
 * @author maple
 * @version V1.0
 * @Date 2016年4月7日下午4:37:58
 * @mail rw222222@126.com
 */
public class GsonUtil {

	/**
	 * gson对象
	 */
	private static Gson gson = new GsonBuilder()
			.serializeNulls()
			.setDateFormat("yyyy-MM-dd HH:mm:ss")
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.create();

	/**
	 * 构造方法
	 */
	private GsonUtil() {

	}

	/**
	 * 获取gson对象
	 * 
	 * @return gson对象
	 */
	public static Gson getGson() {
		return gson;
	}
}