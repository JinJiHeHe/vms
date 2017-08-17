package com.et.terminalserver.common.cache;

import cn.xhpl.vms.api.GsonUtil;
import cn.xhpl.vms.common.redis.RedisConnectionManager;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Description RedisCache
 * @author jakiro
 * @version V1.0
 * @Date 2015年7月15日 上午10:40:50
 * @mail terrorbladeyang@gmail.com
 */
public class RedisCache implements ICache {

	private final static Log log = LogFactory.getLog(RedisCache.class);
	// String类型的缓存key名字
	private String cacheName;

	private Class<?> classed;

	private Gson gson = GsonUtil.getGson();

	private JedisCluster jedis;

	/**
	 * @Description:Redis的构造方法
	 * @param :argss
	 * @return
	 * @throws Exception
	 */
	public RedisCache(String cacheName, RedisConnectionManager connection,
			Class<?> classed) {
		this.cacheName = cacheName;
		this.classed = classed;
		this.jedis = connection.getConnection();
	}

	@Override
	public int size() {
		return jedis.hgetAll(cacheName).size();

	}

	@Override
	public boolean isEmpty() {

		return jedis.hgetAll(cacheName).isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {

		return jedis.hget(cacheName, key.toString()) == null ? true : false;

	}

	@Override
	public boolean containsValue(Object value) {

		return false;
	}

	@Override
	public Object put(Object key, Object value) {

		if (value instanceof Class<?>) {
			return jedis.hset(cacheName, key.toString(), gson.toJson(value));
		} else {
			log.error("Put error type for the redis cache!!");
			return null;
		}
	}

	@Override
	public Object remove(Object key) {

		return jedis.hdel(cacheName, key.toString());

	}

	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {

	}

	@Override
	public void clear() {

		jedis.hgetAll(cacheName).clear();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set keySet() {
		return jedis.hkeys(cacheName);
	}

	@Override
	public Collection<Object> values() {

		Collection<Object> collection = new ArrayList<Object>();
		for (String value : jedis.hgetAll(cacheName).values()) {
			collection.add(gson.fromJson(value, classed));
		}
		return collection;
	}

	@Deprecated
	@Override
	public Set<Entry<Object, Object>> entrySet() {

		// Jedis jedis = redisPool.getresource();
		// Set<java.util.Map.Entry<Object, Object>> set=new
		// HashSet<Map.Entry<Object,Object>>();
		// try {
		// for (java.util.Map.Entry<String, String>
		// entry:jedis.hgetAll(cacheName).entrySet()) {
		// Object obj = gson.fromJson(entry.getValue(),classed);
		// entry.setValue((String) obj);
		// }
		// return null;
		// } finally {
		// redisPool.returnResource(jedis);
		// }
		System.out.println("呵呵 不好使");
		return null;

	}

	@Override
	public Object get(Object key) {

		return gson.fromJson(jedis.hget(cacheName, key.toString()), classed);
	}

	public Class<?> getClassed() {
		return classed;
	}

	public void setClassed(Class<?> classed) {
		this.classed = classed;
	}

}
