package com.et.terminalserver.common.util.conllection;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project CNPC_VMS
 * @Title BatchList
 * @Description 批量集合，包含一个vector，简单的实现了支持时间监听器和数量监听器 ，实现了{@link List}、{@link IListenerSupport}、{@link ICollection}接口
 * @author guanhl
 * @date 2014年10月3日 下午7:49:25
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public class BatchList<E> implements List<E>, IListenerSupport, ICollection, Serializable {

	// 序列化ID
	private static final long serialVersionUID = -6194899008519779946L;

	/**
	 * @Description 无参构造方法
	 */
	public BatchList() {

	}

	/**
	 * @Description 私有构造方法
	 * @param list - 创造集合副本
	 */
	private BatchList(List<E> list) {
		this.list = list;
		this.size = list.size();
	}

	// 创建时间时间监听实例Map实例，存放监听
	private ConcurrentHashMap<TimerRemoveListener<BatchList<E>>, Timer> timerListeners = new ConcurrentHashMap<TimerRemoveListener<BatchList<E>>, Timer>();

	// 创建集合大小监听Set实例，存放监听
	private Set<SizeRemoveListener<BatchList<E>>> sizeListeners = Collections.synchronizedSet(new HashSet<SizeRemoveListener<BatchList<E>>>());

	// 判断有没有size监听标识
	private volatile boolean isSizeRemove;

	// BatchList 的大小计数
	private volatile int size = 0;

	// 创建一个Vector集合实例
	List<E> list = new Vector<E>();

	/**
	 * @Description 检查集合大小
	 */
	private void checkSize() {
		// 遍历集合size监听
		for (SizeRemoveListener<BatchList<E>> lis : sizeListeners) {
			// 如果集合的大小大于等于指定大小，触发监听事件
			if (lis.getSize() <= size) {
				// 新建Vector实例
				Vector<E> newList = new Vector<E>(list);
				// 清空旧集合
				list.clear();
				// size清0
				size = 0;
				// 执行监听方法
				lis.onSizeRemove(new BatchList<E>(newList));
			}
		}
	}

	/**
	 * @Description 重写Vector的add方法
	 * @param E arg0
	 * @return boolean
	 */
	@Override
	public boolean add(E arg0) {
		boolean result; // 声明标识
		synchronized (list) {
			result = list.add(arg0); // 添加成功返回true
			size++; // 集合大小自增
			if (isSizeRemove) { // 如果存在size监听 运行checkSize
				checkSize();
			}
		}
		return result; // 返回结果
	}

	/**
	 * @Description 重写Vector的add方法
	 * @param E arg0, E arg1
	 * 
	 */
	@Override
	public void add(int arg0, E arg1) {
		synchronized (list) {
			list.add(arg0, arg1); // 集合添加数据到指定索引位置
			if (isSizeRemove) // 判断是否有size监听
				checkSize(); // 执行该方法
		}
	}

	/**
	 * @Description 重写Vector的addAll方法
	 * @param Collection<? extends E> arg0
	 * @return boolean
	 */
	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		boolean result; // boolean标识
		synchronized (list) {
			result = list.addAll(arg0); // 成功返回true
			size += arg0.size(); // 累加集合大小
		}
		return result; // 返回标识
	}

	/**
	 * @Description 重写Vector的addAll方法
	 * @param argType
	 * @return return_type
	 * @throws Exception
	 */
	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		boolean result; // boolean标识
		synchronized (list) {
			result = addAll(arg0, arg1); // 添加成功返回true,添加到指定索引
			size += arg1.size(); // 累加size
		}
		return result; // 返回结果
	}

	/**
	 * @Description 重写Vector的clear方法
	 */
	@Override
	public void clear() {

		synchronized (list) {
			list.clear(); // 清空list数据
			size = 0; // 集合大小变为0
		}

	}

	/**
	 * @Description 重写Vector的contains方法
	 * @param Object arg0
	 * @return boolean
	 */
	@Override
	public boolean contains(Object arg0) {
		return list.contains(arg0); // 返回list的contains方法判断的返回值
	}

	/**
	 * @Description 重写Vector的contains方法
	 * @param Collection<?> arg0
	 * @return boolean
	 */
	@Override
	public boolean containsAll(Collection<?> arg0) {
		return list.containsAll(arg0); // 返回list的containsAll方法判断的返回值
	}

	/**
	 * @Description 重写Vector的get方法
	 * @param int 索引值
	 * @return E
	 */
	@Override
	public E get(int arg0) {
		return get(arg0); // 获取指定索引的值
	}

	/**
	 * @Description 重写Vector的get方法
	 * @param int
	 * @return E
	 */
	@Override
	public int indexOf(Object arg0) {
		return list.indexOf(arg0); // 返回list默认的indexOf方法
	}

	/**
	 * @Description 重写Vector的isEmpty方法
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty(); // 返回默认的isEmpty方法
	}

	/**
	 * @Description 重写Vector的iterator方法
	 * @return Iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return list.iterator(); // 返回默认的iterator方法
	}

	/**
	 * @Description 重写Vector的lastIndexOf方法
	 * @param Object
	 * @return int
	 */
	@Override
	public int lastIndexOf(Object arg0) {
		return list.lastIndexOf(arg0);// 返回默认的lastIndexOf方法
	}

	/**
	 * @Description 重写Vector的listIterator方法
	 * @return ListIterator<E>
	 */
	@Override
	public ListIterator<E> listIterator() {
		return list.listIterator(); // 返回默认的lastIndexOf方法
	}

	/**
	 * @Description 重写Vector的listIterator方法
	 * @param int 索引值
	 * @return ListIterator<E>
	 */
	@Override
	public ListIterator<E> listIterator(int arg0) {
		return list.listIterator(arg0);
	}

	/**
	 * @Description 重写Vector的remove方法
	 * @param int 索引值
	 * @return ListIterator<E>
	 */
	@Override
	public boolean remove(Object arg0) {
		boolean result; // 判断标识
		synchronized (list) {
			result = list.remove(arg0); // 删除数据成功返回true
			size--; // 集合大小自减
		}
		return result; // 返回判断标识
	}

	/**
	 * @Description 重写Vector的remove方法
	 * @param int 索引值
	 * @return ListIterator<E>
	 */
	@Override
	public E remove(int arg0) {
		E result;
		synchronized (list) {
			result = list.remove(arg0);
			size--;
		}
		return result;
	}

	/**
	 * @Description 重写Vector的removeAll方法
	 * @param Collection<?> arg0
	 * @return boolean
	 */
	@Override
	public boolean removeAll(Collection<?> arg0) {
		boolean result; // 判断标识
		synchronized (list) {
			result = list.removeAll(arg0); // 移除所有对象成功返回true
			size -= arg0.size(); // 计算删除后集合大小
		}
		return result; // 返回判断标识
	}

	/**
	 * @Description 重写Vector的retainAll方法
	 * @param Collection<?> arg0
	 * @return boolean
	 */
	@Override
	public boolean retainAll(Collection<?> arg0) {
		return list.retainAll(arg0); // 返回默认的retainAll方法
	}

	/**
	 * @Description 重写Vector的set方法
	 * @param int arg0, E arg1
	 * @return E 泛型
	 */
	@Override
	public E set(int arg0, E arg1) {
		E result; // 实例化泛型
		synchronized (list) { // 对List进行锁
			result = list.set(arg0, arg1); //
		}
		return result;
	}

	/**
	 * @Description 重写Vector的size方法
	 * @return int
	 */
	@Override
	public int size() {
		return size; // 返回当前size大小
	}

	/**
	 * @Description 重写Vector的subList方法
	 * @param int arg0, int arg1 两个索引值
	 * @return List<E>
	 */
	@Override
	public List<E> subList(int arg0, int arg1) {
		return list.subList(arg0, arg1); // 切分数据 按照两个索引
	}

	/**
	 * @Description 重写Vector的toArray方法
	 * @return Object[]
	 */
	@Override
	public Object[] toArray() {
		return list.toArray(); // 将list变为数据格式,默认方法
	}

	/**
	 * @Description 重写Vector的toArray方法
	 * @param T[] arg0
	 * @return T[]
	 */
	@Override
	public <T> T[] toArray(T[] arg0) {
		return list.toArray(arg0); // 使用Vector自己的方法
	}

	/**
	 * @Description 重写Vector的toString方法
	 * @return String
	 */
	@Override
	public String toString() {
		return list.toString(); // 返回默认的toString 方法
	}

	/**
	 * @Description 增加时间监听方法 来满足list定时监听触发业务
	 * @param 监听对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addListener(Object listener) {

		if (listener instanceof TimerRemoveListener) { // 判断是否是TimerRemoveListener类型的监听
			synchronized (timerListeners) { // 锁定时间监听器
				Timer timer = new Timer(); // 创建监听器
				timerListeners.put((TimerRemoveListener<BatchList<E>>) listener, timer);// 放入时间监听实例 以及监听器对象
				timer.schedule(new NewTimerTask((TimerRemoveListener<BatchList<E>>) listener) { // 创建时间监听任务
						}, ((TimerRemoveListener<BatchList<E>>) listener).getDelay(), ((TimerRemoveListener<BatchList<E>>) listener).getPeriod()); // 获取时间延迟和间隔时间
			}
		} else if (listener instanceof SizeRemoveListener) { // 判断listener是否是大小监听类型的监听器
			synchronized (sizeListeners) { // 对大小计数器加锁
				sizeListeners.add((SizeRemoveListener<BatchList<E>>) listener); // 监听器加入大小监听器实例
				isSizeRemove = true; // 是否有监听的判断表示位变为true
			}
		}
	}

	/**
	 * @Description 时间监听任务线程类，线程形式持续监听
	 */
	private class NewTimerTask extends TimerTask {

		TimerRemoveListener<BatchList<E>> listener; // 实例化时间监听实例

		/**
		 * @Description 构造方法
		 * @param 时间监听移除实例
		 */
		public NewTimerTask(TimerRemoveListener<BatchList<E>> listener) {
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
			synchronized (list) { // 对list加锁
				try {
					Vector<E> newList = new Vector<E>(list); // 创建Vector实例
					list.clear(); // list清空
					size = 0; // list计数清0
					((TimerRemoveListener<BatchList<E>>) listener).onTimeRemove(new BatchList<E>(newList));// 对list启动时间监听
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		}
	}

	/**
	 * @Description 移除监听方法,到指定时间对监听器做一次清空操 作，同时也检查SizeRemoveListener类型的监听
	 */
	@Override
	public void removeListener(Object listener) {
		if (listener instanceof TimerRemoveListener) { // 判断监听类型是否是TimerRemoveListener
			synchronized (timerListeners) { // 对监听进行加锁
				Timer timer = timerListeners.remove(listener); // 去掉已使用过的监听
				timer.cancel(); // 清除监听器
				timer.purge(); // timer实例销毁
			}
		} else if (listener instanceof SizeRemoveListener) { // 判断是否是SizeRemoveListener类型的监听器
			synchronized (sizeListeners) { // 对集合大小监听器加锁
				sizeListeners.remove(listener); // 移除已经使用过的监听器
				if (sizeListeners.size() == 0) { // 判断监听器数量
					isSizeRemove = false; // 如果满足条件 是否有判断监听器标识位清0
				}
			}
		}
	}

	public List<E> getList() {
		return list;
	}

}
