package com.et.terminalserver.common.cache;

import com.et.terminalserver.common.util.conllection.IListenerSupport;
import com.et.terminalserver.common.util.conllection.SizeRemoveListener;
import com.et.terminalserver.common.util.conllection.TimerRemoveListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project CNPC_VMS
 * @Title LocalCache
 * @Description 本地缓存，就是包裹了一个{@link ConcurrentHashMap},实现{@link ICache}、
 *              {@link IListenerSupport}接口
 * @author guanhl
 * @date 2014年10月3日 下午5:08:34
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public class LocalCache implements ICache, IListenerSupport {

	static Log log = LogFactory.getLog(LocalCache.class);

	// 缓存的实际map对象
	private ConcurrentHashMap<Object, Object> cacheMap = new ConcurrentHashMap<Object, Object>();

	// // 监听器的容器
	// private ConcurrentHashMap<TimerRemoveListener<LocalCache>, Timer>
	// listeners = new ConcurrentHashMap<TimerRemoveListener<LocalCache>,
	// Timer>();
	// 创建时间时间监听实例Map实例，存放监听
	private ConcurrentHashMap<TimerRemoveListener<LocalCache>, Timer> timerListeners = new ConcurrentHashMap<TimerRemoveListener<LocalCache>, Timer>();

	// 创建集合大小监听Set实例，存放监听
	private Set<SizeRemoveListener<LocalCache>> sizeListeners = Collections
			.synchronizedSet(new HashSet<SizeRemoveListener<LocalCache>>());

	// 判断有没有size监听标识
	private volatile boolean isSizeRemove;

	// BatchList 的大小计数
	private volatile int size = 0;

	private ReentrantLock lock = new ReentrantLock();

	/**
	 * @Description 检查集合大小
	 */
	private void checkSize() {
		// 遍历集合size监听
		for (SizeRemoveListener<LocalCache> lis : sizeListeners) {
			// 如果集合的大小大于等于指定大小，触发监听事件

			if (lis.getSize() <= size) {
				// 新建Vector实例
				ConcurrentHashMap<Object, Object> newCache = null;
				try {
					lock.lock();
					newCache = new ConcurrentHashMap<Object, Object>(cacheMap);
					// 清空旧集合
					cacheMap.clear();
					// size清0
					size = 0;
					// 执行监听方法
				} finally {
					lock.unlock();
				}
				lis.onSizeRemove(new LocalCache(newCache));
			}
		}
	}

	/**
	 * @Description 构造方法
	 */
	public LocalCache() {
	}

	public LocalCache(ConcurrentHashMap<Object, Object> newCache) {
		this.cacheMap = newCache;
	}

	/**
	 * @Description 键值存储
	 * @param key
	 *            - 键
	 * @param value
	 *            - 值
	 * @return 前一个key映射的值,没有则返空
	 */
	@Override
	public Object put(Object key, Object value) {
		// synchronized (cacheMap) {

		Object result = null;
		if (null != value) {
			result = cacheMap.put(key, value);
			if (null == result) {
				size++;
				if (isSizeRemove) { // 如果存在size监听 运行checkSize
					checkSize();
				}
			}
		} else {
			log.debug(key + " value is null");
		}
		// }
		return result;
	}

	/**
	 * @Description 按键取值
	 * @param key
	 *            - 键
	 * @return 值
	 */
	@Override
	public Object get(Object key) {
		return cacheMap.get(key);
	}

	/**
	 * @Description 按键删值
	 * @param key
	 *            - 键
	 * @return 值
	 */
	@Override
	public Object remove(Object key) {
		Object result;
		try {
			lock.lock();

			// synchronized (cacheMap) {
			result = cacheMap.remove(key);
			if (null != result) {
				size--;
			}
		} finally {
			lock.unlock();
		}
		// }
		return result;

	}

	/**
	 * @Description 缓存大小
	 * @return 缓存大小
	 */
	@Override
	public int size() {
		return cacheMap.size();
	}

	/**
	 * @Description 判断空
	 * @return 是否空
	 */
	@Override
	public boolean isEmpty() {
		return cacheMap.isEmpty();
	}

	/**
	 * @Description 判断键包含
	 * @param key
	 *            - 键
	 * @return 是否包含
	 */
	@Override
	public boolean containsKey(Object key) {
		return cacheMap.containsKey(key);
	}

	/**
	 * @Description 判断值包含
	 * @param value
	 *            - 值
	 * @return 是否包含
	 */
	@Override
	public boolean containsValue(Object value) {
		return cacheMap.containsValue(value);
	}

	/**
	 * @Description 批量存储,迭代实现比较慢
	 * @param m
	 *            - map集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {
		Set<Object> set = (Set<Object>) m.keySet();
		try {
			lock.lock();
			for (Object object : set) {
				Object put = cacheMap.put(object, m.get(object));
				if (null == put) {
					size++;
				}

			}
		} finally {
			lock.unlock();
		}
		if (isSizeRemove) { // 如果存在size监听 运行checkSize
			checkSize();
		}
	}

	/**
	 * @Description 清空缓存
	 */
	@Override
	public void clear() {
		// synchronized (cacheMap) {
		try {
			lock.lock();
			cacheMap.clear(); // 清空list数据
			size = 0; // 集合大小变为0
		} finally {
			lock.unlock();
		}
		// }
	}

	/**
	 * @Description 获取键集
	 * @return 键的set集合
	 */
	@Override
	public Set<Object> keySet() {
		return cacheMap.keySet();
	}

	/**
	 * @Description 获取值集
	 * @return 值的集合
	 */
	@Override
	public Collection<Object> values() {
		return cacheMap.values();
	}

	/**
	 * @Description 获取键值对象集
	 * @return 键值对象集合
	 */
	@Override
	public Set<Entry<Object, Object>> entrySet() {
		return cacheMap.entrySet();
	}

	/**
	 * @Description 时间监听任务线程类，线程形式持续监听
	 */
	private class NewTimerTask extends TimerTask {

		TimerRemoveListener<LocalCache> listener; // 实例化时间监听实例

		/**
		 * @Description 构造方法
		 * @param 时间监听移除实例
		 */
		public NewTimerTask(TimerRemoveListener<LocalCache> listener) {
			this.listener = listener;
		}

		/**
		 * @Description 线程类默认实现的run方法
		 * @param argType
		 * @return return_type
		 * @throws Exception
		 */
		@Override
		public void run() {
			ConcurrentHashMap<Object, Object> newCache = null;
			try {
				// synchronized (cacheMap) { // 对list加锁
				lock.lock();
				newCache = new ConcurrentHashMap<Object, Object>(cacheMap); // 创建Vector实例
				cacheMap.clear(); // list清空
				size = 0; // list计数清0
			} finally {
				lock.unlock();
			}
			try {
				((TimerRemoveListener<LocalCache>) listener)
						.onTimeRemove(new LocalCache(newCache));// 对list启动时间监听
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * @Description 移除监听方法,到指定时间对监听器做一次清空操 作，同时也检查SizeRemoveListener类型的监听
	 */
	@Override
	public void removeListener(Object listener) {
		if (listener instanceof TimerRemoveListener) { // 判断监听类型是否是TimerRemoveListener
			// synchronized (timerListeners) { // 对监听进行加锁
			Timer timer = timerListeners.remove(listener); // 去掉已使用过的监听
			timer.cancel(); // 清除监听器
			timer.purge(); // timer实例销毁
			// }
		} else if (listener instanceof SizeRemoveListener) { // 判断是否是SizeRemoveListener类型的监听器
			// synchronized (sizeListeners) { // 对集合大小监听器加锁
			sizeListeners.remove(listener); // 移除已经使用过的监听器
			if (sizeListeners.size() == 0) { // 判断监听器数量
				isSizeRemove = false; // 如果满足条件 是否有判断监听器标识位清0
			}
			// }
		}
	}

	@Override
	public String toString() {
		return cacheMap.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addListener(Object listener) {

		if (listener instanceof TimerRemoveListener) { // 判断是否是TimerRemoveListener类型的监听
			// synchronized (timerListeners) { // 锁定时间监听器
			Timer timer = new Timer(); // 创建监听器
			timerListeners.put((TimerRemoveListener<LocalCache>) listener,
					timer);// 放入时间监听实例 以及监听器对象
			timer.schedule(
					new NewTimerTask((TimerRemoveListener<LocalCache>) listener) { // 创建时间监听任务
					}, ((TimerRemoveListener<LocalCache>) listener).getDelay(),
					((TimerRemoveListener<LocalCache>) listener).getPeriod()); // 获取时间延迟和间隔时间
			// }
		} else if (listener instanceof SizeRemoveListener) { // 判断listener是否是大小监听类型的监听器
			// synchronized (sizeListeners) { // 对大小计数器加锁
			sizeListeners.add((SizeRemoveListener<LocalCache>) listener); // 监听器加入大小监听器实例
			isSizeRemove = true; // 是否有监听的判断表示位变为true
			// }
		}
	}

	public ConcurrentHashMap<Object, Object> getCacheMap() {
		return this.cacheMap;
	}
}
