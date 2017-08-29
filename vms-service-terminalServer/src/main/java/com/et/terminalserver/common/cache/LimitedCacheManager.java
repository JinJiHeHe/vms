package com.et.terminalserver.common.cache;

import java.util.concurrent.ConcurrentHashMap;

public class LimitedCacheManager {

	public final static ConcurrentHashMap<String, LimitedCache> caches = new ConcurrentHashMap<String, LimitedCache>();

	public static LimitedCache createLimitedCache(String name, int maxsize,
			int keeptime, RemoveLimited removeHandler) {
		LimitedCache cache = new LimitedCache(maxsize, keeptime, removeHandler);
		caches.put(name, cache);
		return cache;
	}

	public static LimitedCache getLimitedCache(String name) {
		return caches.get(name);
	}

}