package com.et.terminalserver.common.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project CNPC_VMS
 * @Title LocalCacheManager
 * @Description 本地缓存，这是一个静态类
 * @author guanhl
 * @date 2014年10月3日 下午5:05:05
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public class LocalCacheManager  {

	// private static Log log = LogFactory.getLog(LocalCacheManager.class);
	private static ConcurrentHashMap<String, LocalCache> managedMap = new ConcurrentHashMap<String, LocalCache>();

	/**
	 * @Description 获取缓存
	 * @param name 缓存名
	 * @return {@link LocalCache} 返回本地缓存
	 */
	public synchronized static LocalCache getCache(String name) {

		/* 该方法保证线程安全 */

		// 如果存在该缓存返回该缓存
		if (managedMap.containsKey(name)) {
			return managedMap.get(name);
		} else {
			// 如果不存在则新建一个缓存
			LocalCache cache = new LocalCache();
			managedMap.put(name, cache);
			return cache;
		}
	}
}
