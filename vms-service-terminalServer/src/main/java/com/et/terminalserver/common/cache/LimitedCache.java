package com.et.terminalserver.common.cache;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description 实现guavaCache的定时超时触发接口的触发式缓存
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月10日 上午11:37:42
 * @mail terrorbladeyang@gmail.com
 */
public class LimitedCache implements ICache {

	final public static String TIMEDELETE = "TIMEDELETE";
	final public static String PUTDELETE = "PUTDELETE";
	final public static String NOPUT = "NOPUT";
	final public static String COMMONDELETE = "COMMONDELETE";

	//节点列表
	Map<Object, LinkedNode> nodesTable = new HashMap<Object, LinkedNode>();
	LimitedEntry[] hashTable = null; // 散列表
	private LinkedNode headNode; // 时序链表
	private final int keeptime;
	private LinkedNode endNode;
	private LinkedNode lastNode;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock rLock = lock.readLock();
	private final Lock wLock = lock.writeLock();
	private RemoveLimited removed;
	private volatile int size = 0;

	// final private static int threadTimeout = 3000;

	protected LimitedCache(int length, int keeptime, RemoveLimited removed) {
		this.keeptime = keeptime;
		this.removed = removed;
		this.hashTable = new LimitedEntry[length];
		/**
		 * 初始化一个链表容器 Node1->null => Node1->Node2->null =>
		 * Node1->Node2->Node3->null
		 */
		try {
			wLock.lock();
			if (length > 0) {
				headNode = new LinkedNode();
				// headNode.num = 0;
				LinkedNode currentNode = headNode;
				for (int i = 1; i < length; i++) {
					LinkedNode next = new LinkedNode();
					// next.num = i;
					currentNode.nextNode = next;
					next.prevNode = currentNode;
					currentNode = next;
				}
				lastNode = currentNode;
			}
		} finally {
			wLock.unlock();
		}
		// else {
		// throw new Exception("no size , yong ge diao");
		// }
	}

	/**
	 * 大小
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * 是否空
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0 ? true : false;
	}

	/**
	 * 包含 key
	 */
	@Override
	public boolean containsKey(Object key) {
		if (size == 0) {
			return false;
		}
		if (null == key)
			return false;
		return getEntry(key) != null;
	}

	/**
	 * 计算 hash,计算 index ,监测冲撞数据，反正就是找数据
	 * 
	 * @param key
	 * @return
	 */
	public LimitedEntry getEntry(Object key) {
		if (null == key)
			return null;
		int hash = hash(key);

		try {
			rLock.lock();
			for (LimitedEntry e = hashTable[indexFor(hash, hashTable.length)]; e != null; e = e.next) {
				Object k;
				if (e.hash == hash
						&& ((k = e.key) == key || (key != null && key.equals(k))))
					return e;
			}
		} finally {
			rLock.unlock();
		}
		return null;
	}

	/**
	 * 迭代实现
	 */
	@Override
	public boolean containsValue(Object value) {
		if (null == value)
			return false;
		try {
			rLock.lock();
			for (LinkedNode currentNode = headNode; null != currentNode.nextNode
					&& currentNode != endNode.nextNode; currentNode = currentNode.nextNode) {
				if (currentNode.entry.value == value
						|| currentNode.entry.value.equals(value))
					return true;
			}
		} finally {
			rLock.unlock();
		}
		return false;
	}

	@Override
	public Object get(Object key) {
		if (null == key)
			return null;
		LimitedEntry e = getEntry(key);
		return e == null ? null : e.value;
	}

	@Override
	public Object put(Object key, Object value) {
		Object r = put0(key, value);
		if (r != null) {
			if (r == value) {
				if (removed != null)
					removed.onRemove(key, r, NOPUT);
			} else {
				if (removed != null)
					removed.onRemove(key, r, PUTDELETE);
			}

		}
		return r;
	}

	public Object put0(Object key, Object value) {
		if (null == key) // 空key
			return null;
		int hash = hash(key);

		try {
			wLock.lock();
			int i = indexFor(hash, hashTable.length);// index
			LimitedEntry e = hashTable[i];
			LimitedEntry le = null;
			// 找这个key，找啊找找朋友
			for (; e != null; e = e.next) {
				if (e.hash == hash && e.key == key || key.equals(e.key)) {
					// 这里的node，也要移动到
					LinkedNode node = e.node;
					Object oldValue = e.value;
					e.value = value;
					refreshNode(node);
					return oldValue;
				} else if (e.next == null) {
					le = e;
				}
			}
			// 创建 entry，还要将entry中额 node指向新的node
			LinkedNode newNode = getNewLinkedNode();
			if (newNode == null) {// 链表已满，无法加入，直接返回
				return value;
			} else {
				if (le == null)
					hashTable[i] = new LimitedEntry(key, value, newNode, null,
							hash);
				else
					le.next = new LimitedEntry(key, value, newNode, null, hash);
				size++;
			}
		} finally {
			wLock.unlock();
		}
		return null;
	}

	/**
	 * 从链表里获取下一个可用的 node
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public LinkedNode getNewLinkedNode() {
		LinkedNode newNode = null;
		if (endNode != null) {
			newNode = endNode.nextNode;
		} else {
			newNode = headNode;
		}
		if (null == newNode)
			return null;
		endNode = newNode;
		endNode.updateTime = System.currentTimeMillis();
		return newNode;
	}

	public void validateTime() {

		if (removed != null && keeptime > 0 && endNode != null) {
			long currentTime = System.currentTimeMillis();
			List list = new ArrayList();
			try {
				wLock.lock();
				LinkedNode checkNode = headNode;
				for (; checkNode != null && checkNode.entry != null;) {
					if (checkNode.updateTime + keeptime <= currentTime) {
						LimitedEntry e = checkNode.entry;
						list.add(new Object[] { e.key, e.value });
						checkNode = checkNode.nextNode;
						remove0(e.key);
					} else {
						checkNode = checkNode.nextNode;
					}

				}

			} finally {
				wLock.unlock();
			}

			for (Object ob : list) {
				Object[] rv = (Object[]) ob;
				removed.onRemove(rv[0], rv[1], TIMEDELETE);
			}
		}

	}

	// public RemoveEventi putBeforeEvent(Object key, Object value) {
	// return null;
	// }

	// private final class RemoveEvent {
	// public Object key;
	// public Object value;
	// public int reason;
	//
	// public RemoveEvent(Object key, Object value, int reason) {
	// this.value = value;
	// this.reason = reason;
	// this.key = key;
	// }
	//
	// }

	@Override
	public Object remove(Object key) {
		LimitedEntry ob = remove0(key);
		if (ob != null && removed != null)
			removed.onRemove(ob.key, ob.value, COMMONDELETE);
		return ob == null ? null : ob.value;
	}

	public LimitedEntry remove0(Object key) {
		if (size == 0)
			return null;
		if (key == null)
			return null;
		int hash = hash(key);
		LimitedEntry e;
		try {
			wLock.lock();
			int i = indexFor(hash, hashTable.length);
			LimitedEntry prev = hashTable[i];
			e = prev;
			while (e != null) {
				LimitedEntry next = e.next;
				Object k;
				if (e.hash == hash
						&& ((k = e.key) == key || (key != null && key.equals(k)))) {
					size--;
					if (prev == e)
						hashTable[i] = next;
					else
						prev.next = next;
					clearNode(e.node);
					return e;
				}
				prev = e;
				e = next;
			}
		} finally {
			wLock.unlock();
		}
		return e;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {
		if (m.size() <= 0)
			return;
		List list = new ArrayList();
		try {
			wLock.lock();
			Set set = m.entrySet();
			for (Object e : set) {
				Entry entry = (Entry) e;
				Object rv = put0(entry.getKey(), entry.getValue());
				list.add(new Object[] { entry.getKey(), rv,
						rv == entry.getValue() });
			}
		} finally {
			wLock.unlock();
		}
		if (removed != null)
			for (Object ob : list) {
				Object[] rv = (Object[]) ob;

				try {
					if (rv[0] != null && rv[1] != null) {
						if ((Boolean) rv[2] == true)
							removed.onRemove(rv[0], rv[1], NOPUT);
						else
							removed.onRemove(rv[0], rv[1], PUTDELETE);
					}
				} catch (Exception e) {
				}
			}

	}

	@Override
	public void clear() {
		List list = new ArrayList();
		try {
			wLock.lock();
			Arrays.fill(hashTable, null);
			if (endNode != null) {

				// headNode.entry = null;
				for (LinkedNode n = headNode; n != endNode; n = n.nextNode) {
					list.add(n.entry);
					n.entry = null;
				}
				list.add(endNode.entry);
				endNode.entry = null;
				endNode = null;
			}
			size = 0;

		} finally {
			wLock.unlock();
		}
		if (removed != null)
			for (Object ob : list) {
				Entry e = (Entry) ob;
				try {
					if (e.getKey() != null && e.getValue() != null) {
						removed.onRemove(e.getKey(), e.getValue(), COMMONDELETE);
					}
				} catch (Exception e1) {
				}
			}

	}

	@Override
	public Set<Object> keySet() {
		return new LimitedKeySet();
	}

	@Override
	public Collection<Object> values() {
		return new Values();
	}

	@Override
	public Set<Entry<Object, Object>> entrySet() {
		return new LimitedEntrySet();
	}

	// private LinkedNode insertNode(LinkedNode prevNode, LinkedNode nextNode,
	// LinkedNode insertNode) {
	// insertNode.prevNode = prevNode;
	// insertNode.nextNode = nextNode;
	// prevNode.prevNode = insertNode;
	// nextNode.prevNode = insertNode;
	// return insertNode;
	// }
	//
	// private void replaceNode(LinkedNode oldNode, LinkedNode newNode) {
	// // 把结点替换
	// newNode.prevNode = oldNode.prevNode;
	// newNode.nextNode = oldNode.nextNode;
	// oldNode.prevNode.nextNode = newNode;
	// oldNode.nextNode.prevNode = newNode;
	// }

	/**
	 * 将node时间刷新，放到链表正确的时序位置
	 *
	 * @param rmNode
	 */
	private void refreshNode(LinkedNode node) {
		if (node == headNode) {// 如果刷新头结点，那么需要把第二位弄成头结点，把头结点变为尾节点
			headNode = node.nextNode;
			headNode.prevNode = null;
			node.prevNode = endNode;
			node.nextNode = endNode.nextNode;
			endNode.nextNode = node;
			endNode = node;
			if (endNode.nextNode == null) // 满员结点
				lastNode = endNode;
		} else if (node == endNode) {// 如果是最后一个结点，不做其他操作

		} else {// 中间的结点，需要变为尾节点
			node.prevNode.nextNode = node.nextNode;
			node.nextNode.prevNode = node.prevNode;
			node.prevNode = endNode;
			node.nextNode = endNode.nextNode;
			endNode.nextNode = node;
			endNode = node;
			if (endNode.nextNode == null)// 满员结点
				lastNode = endNode;
		}
		node.updateTime = System.currentTimeMillis();
	}

	private void clearNode(LinkedNode node) {
		node.entry = null;
		if (node == headNode) {
			headNode = node.nextNode;
			headNode.prevNode = null;
			node.prevNode = lastNode;
			node.nextNode = null;
			lastNode.nextNode = node;
			lastNode = node;
			if (endNode == node)
				endNode = null;
		} else if (node.nextNode == null) {
			if (endNode == node)
				endNode = node.prevNode;
		} else {
			node.prevNode.nextNode = node.nextNode;
			node.nextNode.prevNode = node.prevNode;
			if (endNode == node)
				endNode = node.prevNode;
			node.prevNode = lastNode;
			node.nextNode = lastNode.nextNode;
			lastNode.nextNode = node;
			lastNode = node;
		}

	}

	private abstract class LimitedIterator<E> implements Iterator<E> {

		LinkedNode node = null;

		public LimitedIterator() {
			node = new LinkedNode();
			node.nextNode = headNode;
		}

		@Override
		public boolean hasNext() {
			return node.nextNode != null && node.nextNode.entry != null;
		}

		public Entry<Object, Object> getNext() {
			LinkedNode n = node;
			node = node.nextNode;
			return n.nextNode != null ? n.nextNode.entry : null;
		}

		@Override
		public void remove() {
			LimitedCache.this.remove(node.entry.key);
		}

	}

	private final class LimitedEntryIterator extends
			LimitedIterator<Entry<Object, Object>> {
		@Override
		public Entry<Object, Object> next() {
			return getNext();
		}
	}

	private final class LimitedKeyIterator extends LimitedIterator<Object> {
		@Override
		public Object next() {
			return getNext().getKey();
		}
	}

	private final class LimitedValueIterator extends LimitedIterator<Object> {
		@Override
		public Object next() {
			return getNext().getValue();
		}
	}

	private final class Values extends AbstractCollection<Object> {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Iterator iterator() {
			return new LimitedValueIterator();
		}

		public int size() {
			return size;
		}

		public boolean contains(Object o) {
			return containsValue(o);
		}

		public void clear() {
			LimitedCache.this.clear();
		}
	}

	private final class LimitedKeySet extends AbstractSet<Object> implements
			Set<Object> {
		@Override
		public Iterator<Object> iterator() {
			return new LimitedKeyIterator();
		}

		@Override
		public boolean contains(Object o) {
			return containsKey(o);
		}

		@Override
		public boolean remove(Object o) {
			return LimitedCache.this.remove(o) != null;
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public void clear() {
			LimitedCache.this.clear();
		}
	}

	private final class LimitedEntrySet extends
			AbstractSet<Entry<Object, Object>> implements
			Set<Entry<Object, Object>> {

		@Override
		public Iterator<Entry<Object, Object>> iterator() {
			return new LimitedEntryIterator();
		}

		@Override
		public boolean contains(Object o) {
			return containsKey(o);
		}

		@Override
		public boolean remove(Object o) {
			return LimitedCache.this.remove(o) != null;
		}

		@Override
		public int size() {
			return size;
		}

		@Override
		public void clear() {
			LimitedCache.this.clear();
		}
	}

	/**
	 * 
	 * entry
	 * 
	 */
	private final class LimitedEntry implements Entry<Object, Object> {
        
		private Object key;
		private Object value;
		private LinkedNode node;
		private LimitedEntry next;
		private int hash;

		LimitedEntry(Object k, Object v, LinkedNode node, LimitedEntry n, int h) {
			this.key = k;
			this.value = v;
			this.next = n;
			this.hash = h;
			this.node = node;
			node.entry = this;
		}

		@Override
		public Object getKey() {
			return this.key;
		}

		@Override
		public Object getValue() {
			return this.value;
		}

		@Override
		public Object setValue(Object value) {
			Object oldValue = this.value;
			this.value = value;
			return oldValue;
		}

	}

	/**
	 * 时序链表
	 * 
	 * @author hadoop
	 * 
	 */
	private final class LinkedNode {
          
		public LinkedNode prevNode;
		public LinkedNode nextNode;
		public long updateTime;
		public LimitedEntry entry;

	}

	int hashSeed;

	/**
	 * 随机一个hash种子
	 * 
	 * @param capacity
	 */
	final void initHashSeedAsNeeded(int capacity) {
		hashSeed = 1 + Double.valueOf((Math.random() * (hashTable.length - 1)))
				.intValue();
	}

	/**
	 * hash算法 {@link HashMap#hash}
	 * 
	 * @param 一个对象实力
	 *            ,字符串特殊处理
	 * @return hashcode
	 */
	@SuppressWarnings("restriction")
	final int hash(Object k) {
		int h = hashSeed;
		if (0 != h && k instanceof String) {
			return sun.misc.Hashing.stringHash32((String) k);
		}
		h ^= k.hashCode();
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	/**
	 * 这就是个把hash变成数组索引的一个方法
	 * 
	 * @param h
	 * @param length
	 * @return
	 */
	static int indexFor(int h, int length) {
		return h & (length - 1);
	}

	/**
	 * 简简单单toString
	 */
	@Override
	public String toString() {
		try {
			rLock.lock();
			Iterator i = entrySet().iterator();
			if (!i.hasNext())
				return "{}";

			StringBuilder sb = new StringBuilder();
			sb.append('{');
			for (;;) {
				Entry e = (Entry) i.next();
				Object key = e.getKey();
				Object value = e.getValue();
				sb.append(key == this ? "(this Map)" : key);
				sb.append('=');
				sb.append(value == this ? "(this Map)" : value);
				if (!i.hasNext())
					return sb.append('}').toString();
				sb.append(',').append(' ');
			}
		} finally {
			rLock.unlock();
		}
	}

	public static void main(String[] args) {
		LimitedCache cache = new LimitedCache(10, 5000, new RemoveLimited() {

			@Override
			public void onRemove(Object key, Object data, String reason) {
				System.out.println("on remove :" + key + "," + data + ","
						+ reason);
			}
		});

		cache.put("1", "1");
		System.out.println("put 1,1:" + cache);
		System.out.println("containsKey 1:" + cache.containsKey("1"));
		System.out.println("containsKey 3:" + cache.containsKey("3"));
		System.out.println("containsValue 2:" + cache.containsValue("2"));
		System.out.println("containsValue 3:" + cache.containsValue("3"));
		cache.remove("1");
		System.out.println("remove 1:" + cache);
		Map map = new HashMap();
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		map.put("5", 5);
		cache.putAll(map);
		System.out.println("put 2,2;3,3;4,4;5,5:" + cache);
		cache.remove("2");
		System.out.println("remove 2:" + cache);
		cache.put("4", 6);
		System.out.println("put 4,6:" + cache);
		System.out.println("values:" + cache.values());
		System.out.println("size:" + cache.size());
		System.out.println("get 4:" + cache.get("4"));
		cache.clear();
		System.out.println("clear:" + cache);

		cache.put("1", "1");
		cache.put("2", "1");
		cache.put("3", "1");
		cache.put("4", "1");
		cache.put("5", "1");
		cache.put("6", "1");
		cache.put("7", "1");
		cache.put("8", "1");
		cache.put("9", "1");
		cache.put("0", "1");
		cache.put("a", "1");
		cache.put("b", "1");
		cache.put("c", "1");
		cache.put("d", "1");
		System.out.println("put 1-d:" + cache);
		cache.validateTime();
		System.out.println("timecheck:" + cache);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cache.put("3", "2");
		System.out.println("put 3,2:" + cache);
		cache.put("9", "2");
		System.out.println("put 9,2:" + cache);
		cache.validateTime();
		System.out.println("timecheck:" + cache);

		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
