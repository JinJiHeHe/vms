package com.et.terminalserver.common.cache;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CopyOfLimitedCache implements ICache {

	private ConcurrentHashMap<Object, LinkedNode> hashTable = new ConcurrentHashMap<Object, LinkedNode>();
	private LinkedNode headNode;
	private final int size;
	private final int keeptime;
	private LinkedNode endNode;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock rLock = lock.readLock();
	private final Lock wLock = lock.writeLock();
	private RemoveLimited removed;

	protected CopyOfLimitedCache(int size, int keeptime, RemoveLimited removed) {
		this.size = size;
		this.keeptime = keeptime;
		this.removed = removed;
		LinkedNode lastNode;
		try {
			wLock.lock();
			/**
			 * Node1->Node1 => Node1->Node2->Node1 => Node1->Node2->Node3->Node1
			 */
			if (this.size > 0) {
				headNode = new LinkedNode(null);
				lastNode = headNode;
				for (int i = 0; i < size - 1; i++) {
					lastNode = insertNode(lastNode, lastNode.getNextNode(),
							new LinkedNode(null));
				}
				endNode = headNode;
			}
		} finally {
			wLock.unlock();
		}

	}

	@Override
	public int size() {
		return hashTable.size();
	}

	@Override
	public boolean isEmpty() {
		return hashTable.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return hashTable.containsKey(key);
	}

	/**
	 * 迭代实现
	 */
	@Override
	public boolean containsValue(Object value) {
		try {
			rLock.lock();
			Set<Entry<Object, LinkedNode>> set = hashTable.entrySet();
			for (Entry<Object, LinkedNode> entry : set) {
				if (entry.getValue() == value)
					return true;
			}
			return false;
		} finally {
			rLock.unlock();
		}
	}

	@Override
	public Object get(Object key) {
		return hashTable.get(key).getValue();
	}

	@Override
	public Object put(Object key, Object value) {
		RemoveEvent event;
		try {
			wLock.lock();
			event = putBeforeEvent(key, value);
		} finally {
			wLock.unlock();
		}
	//	removed.onRemove(event.getKey(), event.getValue(), event.getReason());
		return event.getValue();

	}

	public void validateTime() {
		long now = System.currentTimeMillis();//这一刻
		LinkedNode checkNode = headNode;
		for (; (checkNode.getUpdateTime() < (now - keeptime)); checkNode = checkNode
				.getNextNode())
			;
		if (checkNode != headNode) {
			headNode = checkNode;
		}

	}

	public RemoveEvent putBeforeEvent(Object key, Object value) {
		LinkedNode oldNode;
		int reason = 3;// 覆盖掉的
		// 创建新结点
		LinkedNode newNode = new LinkedNode(null, null, value, key);

		newNode.setUpdateTime(System.currentTimeMillis());
		// 存放hash表
		oldNode = hashTable.put(key, newNode);
		// 这里是加了一条新的数据
		if (null == oldNode) {
			reason = -1; // 无数据被删除
			oldNode = endNode.getNextNode();
			// 这就是链表满了,需要把头指针向前移,然后从hash表中清除
			if (oldNode == headNode) {
				headNode = headNode.getNextNode();
				// if (null != oldNode.getKey())
				hashTable.remove(oldNode.getKey());
				reason = 1;// 队列满被挤掉的
			}
			// 这是移动尾结点
			endNode = newNode;
		} else {
			// 头被删掉，要向后移
			if (oldNode == headNode) {
				headNode = headNode.getNextNode();
			}
		}
		// 不是增加的直接就替换
		// 替换旧数据
		replaceNode(oldNode, newNode);
		return new RemoveEvent(oldNode.getKey(), oldNode.getValue(), reason);
	}

	private final class RemoveEvent {
		private Object key;
		private Object value;
		private int reason;

		public RemoveEvent(Object key, Object value, int reason) {
			this.value = value;
			this.reason = reason;
			this.key = key;
		}

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public int getReason() {
			return reason;
		}

	}

	@Override
	public Object remove(Object key) {
		Object result;
		try {
			wLock.lock();
			// 先从hash表删除,然后考虑以下几种情况，hash表中没有，那么就不考虑，考虑的是hash中存在的情况
			// 一是，删除的结点是头结点，那么这个结点清了以后，需要后移头结点
			// 二是，不是头结点的时候，干掉此结点，然后在头结点之前补上一个新结点
			LinkedNode rmNode = hashTable.remove(key);
			if (null == rmNode)
				return null;
			result = rmNode.getValue();
			if (rmNode == headNode) {
				headNode = headNode.getNextNode();
				rmNode.setValue(null);
			} else {
				removeNode(rmNode);
				insertNode(headNode.getPrevNode(), headNode, new LinkedNode(
						null));
			}

		} finally {
			wLock.unlock();
		}
		return result;
	}

	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {

		List<RemoveEvent> list = new ArrayList<RemoveEvent>();
		try {
			wLock.lock();
			Set<?> set = m.entrySet();
			for (Object entry : set) {
				list.add(putBeforeEvent(((Entry<?, ?>) entry).getKey(),
						((Entry<?, ?>) entry).getValue()));
			}
		} finally {
			wLock.unlock();
		}
		for (RemoveEvent removeEvent : list) {
			try {
		//		removed.onRemove(removeEvent.getKey(), removeEvent.getValue(),
//						removeEvent.getReason());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void clear() {
		try {
			wLock.lock();
			hashTable.clear();
			// 把头尾结点搞在一起 ，沿途的结点全部清空
			for (;;) {
				if (endNode == headNode) {
					break;
				}
				headNode.setValue(null);
				headNode = headNode.getPrevNode();
			}
		} finally {
			wLock.unlock();
		}
	}

	@Override
	public Set<Object> keySet() {
		return hashTable.keySet();
	}

	@Override
	public Collection<Object> values() {
		Collection<LinkedNode> values = hashTable.values();
		Collection<Object> result = new ArrayList<Object>();
		for (LinkedNode v : values) {
			result.add(v.getValue());
		}
		return result;
	}

	@Override
	public Set<Entry<Object, Object>> entrySet() {
		return new LimitedEntrySet(hashTable.entrySet());
	}

	private LinkedNode insertNode(LinkedNode prevNode, LinkedNode nextNode,
			LinkedNode insertNode) {
		insertNode.setPrevNode(prevNode);
		insertNode.setNextNode(nextNode);
		prevNode.setNextNode(insertNode);
		nextNode.setPrevNode(insertNode);
		return insertNode;
	}

	private void replaceNode(LinkedNode oldNode, LinkedNode newNode) {
		// 把结点替换
		newNode.setPrevNode(oldNode.getPrevNode());
		newNode.setNextNode(oldNode.getNextNode());
		oldNode.getPrevNode().setNextNode(newNode);
		oldNode.getNextNode().setPrevNode(newNode);
	}

	private void removeNode(LinkedNode rmNode) {
		LinkedNode prevNode = rmNode.getPrevNode();
		LinkedNode nextNode = rmNode.getNextNode();
		prevNode.setNextNode(nextNode);
		nextNode.setPrevNode(prevNode);
	}

	private final class LimitedEntryIterator implements
			Iterator<Entry<Object, Object>> {

		Iterator<Entry<Object, LinkedNode>> it;

		public LimitedEntryIterator(Iterator<Entry<Object, LinkedNode>> it) {
			this.it = it;
		}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public Entry<Object, Object> next() {
			return new LimitedEntry(it.next());
		}

		@Override
		public void remove() {
			it.remove();
		}

	}

	private final class LimitedEntrySet extends
			AbstractSet<Entry<Object, Object>> implements
			Set<Entry<Object, Object>> {

		Set<Entry<Object, LinkedNode>> set;

		public LimitedEntrySet(Set<Entry<Object, LinkedNode>> set) {
			this.set = set;
		}

		@Override
		public Iterator<Entry<Object, Object>> iterator() {
			return new LimitedEntryIterator(set.iterator());
		}

		@Override
		public boolean contains(Object o) {
			return set.contains(o);
		}

		@Override
		public boolean remove(Object o) {
			return set.remove(o);
		}

		@Override
		public int size() {
			return set.size();
		}

		@Override
		public void clear() {
			set.clear();
		}
	}

	private final class LimitedEntry implements Entry<Object, Object> {

		private Entry<Object, LinkedNode> entry;

		public LimitedEntry(Entry<Object, LinkedNode> entry) {
			this.entry = entry;
		}

		@Override
		public Object getKey() {
			return entry.getKey();
		}

		@Override
		public Object getValue() {
			return entry.getValue().getValue();
		}

		@Override
		public Object setValue(Object value) {
			Object returnObject = entry.getValue().getValue();
			entry.getValue().setValue(value);
			return returnObject;
		}

	}

	private final class LinkedNode {

		private LinkedNode prevNode;
		private LinkedNode nextNode;
		private Object value;
		private long updateTime;
		private int state;
		private Object key;

		public LinkedNode(Object value) {
			this.prevNode = this;
			this.nextNode = this;
		}

		public LinkedNode(LinkedNode prevNode, LinkedNode nextNode,
				Object value, Object key) {
			this.prevNode = prevNode;
			this.nextNode = nextNode;
			this.value = value;
			this.key = key;
		}

		public Object getKey() {
			return key;
		}

		public LinkedNode getPrevNode() {
			return prevNode;
		}

		public void setPrevNode(LinkedNode prevNode) {
			this.prevNode = prevNode;
		}

		public LinkedNode getNextNode() {
			return nextNode;
		}

		public void setNextNode(LinkedNode nextNode) {
			this.nextNode = nextNode;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public long getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(long updateTime) {
			this.updateTime = updateTime;
		}

	}

	public static void main(String[] args) {
//		CopyOfLimitedCache cache = new CopyOfLimitedCache(3, 2000000000,
//				new RemoveLimited() {
//
//					@Override
//					public void onRemove(Object key, Object data, int reason) {
//						// TODO Auto-generated method stub
//
//					}
//				});
//
//		cache.put("1", "1");
	}
		
}
