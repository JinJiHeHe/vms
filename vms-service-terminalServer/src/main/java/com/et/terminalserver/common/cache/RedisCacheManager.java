package com.et.terminalserver.common.cache;

import cn.xhpl.vms.common.redis.RedisConnectionManager;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description RedisCacheManager 管理redisCache
 * @author jakiro
 * @version V1.0
 * @Date 2015年7月16日 上午1:20:52
 * @mail terrorbladeyang@gmail.com
 */
public class RedisCacheManager {

	// 存储管理WebCache实例的Map，用来实现进程下的单例
	private ConcurrentHashMap<String, RedisCache> managedMap = new ConcurrentHashMap<String, RedisCache>();

	private RedisConnectionManager redisConnection;

	/**
	 * @Description:同redis的CacheFactory来获取RedisCache的实例，
	 * @param name
	 * 
	 * @return RedisCache 单例的RedisCache
	 * @throws Exception
	 */
	public synchronized RedisCache getCache(String name,Class<?> classed) {
		// 为了保证是单例的，方法加锁也是为保证多线程下的单例
		if (managedMap.containsKey(name)) {
			return managedMap.get(name);
		} else {
			// 第一次使用此WebCache，创建一个WebCache，并放入到managedMap中
			RedisCache redisCache = new RedisCache(name, redisConnection,classed);
			managedMap.put(name, redisCache);
			return redisCache;
		}
	}

	public RedisConnectionManager getRedisConnection() {
		return redisConnection;
	}

	public void setRedisConnection(RedisConnectionManager redisConnection) {
		this.redisConnection = redisConnection;
	}

}
