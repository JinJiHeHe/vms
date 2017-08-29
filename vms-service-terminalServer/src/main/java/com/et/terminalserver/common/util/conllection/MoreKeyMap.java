package com.et.terminalserver.common.util.conllection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class MoreKeyMap<K, V> implements ICollection {

	//主Key - value
	ConcurrentHashMap<K, RelationEntry<K, V>> valueMap = new ConcurrentHashMap<K, RelationEntry<K, V>>();
	//从Key - 主key
	ConcurrentHashMap<K, K> keyMap = new ConcurrentHashMap<K, K>();
	ReentrantLock lock = new ReentrantLock();

	public void put(K mainKey, V value) {

		//关系对象 
		RelationEntry<K, V> entry;
		entry = new RelationEntry<K, V>();
		List<K> list = new ArrayList<K>();
		list.add(mainKey);
		//真正的值
		entry.setValue(value);
		//主key
		entry.setMainKey(mainKey);
		//所有的key
		entry.setList(list);
		try {
			lock.lock();
			//两个关系一致
			valueMap.put(mainKey, entry);
			keyMap.put(mainKey, mainKey);
		} finally {
			lock.unlock();
		}
	}

	public V updateRelation(K mainKey, K oldKey, K newKey) {

		RelationEntry<K, V> entry;
		try {
			lock.lock();
			entry = valueMap.get(mainKey);
			if (entry == null)
				return null;
			keyMap.remove(oldKey);
			keyMap.put(newKey, mainKey);
			List<K> list = entry.getList();
			for (K key : list) {
				if (key.equals(oldKey) || key == oldKey) {
					list.remove(key);
					break;
				}
			}
			list.add(newKey);
		} finally {
			lock.unlock();
		}
		return entry.getValue();
	}

	public V addRelation(K mainKey, K key) {
		RelationEntry<K, V> entry;
		try {
			lock.lock();
			entry = valueMap.get(mainKey);
			if (entry == null)
				return null;
			entry.getList().add(key);
			keyMap.put(key, mainKey);
		} finally {
			lock.unlock();
		}
		return entry.getValue();
	}

	public V remove(K mainKey) {
		RelationEntry<K, V> entry;
		try {
			lock.lock();
			entry = valueMap.remove(mainKey);
			if (entry == null)
				return null;
			List<K> list = entry.getList();
			for (K k : list) {
				try {
					keyMap.remove(k);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} finally {
			lock.unlock();
		}
		return entry.getValue();
	}

	public V get(K key) {
		V value = null;
		try {
			lock.lock();
			K mainkey = keyMap.get(key);
			if(mainkey==null)
				return null;
			RelationEntry<K, V> entry = valueMap.get(mainkey);
			value = entry.getValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return value;

	}

	public K getMainKey(K key) {
		K mainKey = null;
		try {
			lock.lock();
			mainKey = keyMap.get(key);
		} finally {
			lock.unlock();
		}
		return mainKey;
	}

	public boolean contains(K key) {
		boolean result = false;
		try {
			lock.lock();
			result = keyMap.containsKey(key);
		} finally {
			lock.unlock();
		}
		return result;
	}

	private class RelationEntry<RK, RV> {
		private RK mainKey; //主key
		private List<RK> list = new ArrayList<RK>(); //关联所有Key
		private RV value; //value

		@SuppressWarnings("unused")
		public RK getMainKey() {
			return mainKey;
		}

		/**
		 * @Description 设置mainKey属性
		 */
		public void setMainKey(RK mainKey) {
			this.mainKey = mainKey;
		}

		/**
		 * @Description 获取list属性
		 */
		public List<RK> getList() {
			return list;
		}

		/**
		 * @Description 设置list属性
		 */
		public void setList(List<RK> list) {
			this.list = list;
		}

		/**
		 * @Description 获取value属性
		 */
		public RV getValue() {
			return value;
		}

		/**
		 * @Description 设置value属性
		 */
		public void setValue(RV value) {
			this.value = value;
		}

	}

}
