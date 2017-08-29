package com.et.terminalserver.api.model.ext;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @Description 5个数据的游标数组对象
 * @author jakiro
 * @version V1.0
 * @Date 2015年8月3日 下午3:42:41
 * @mail terrorbladeyang@gmail.com
 */
public abstract class BaseHistoryEntity<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 循环列表长度 默认为5
	 */
	private int length = 5;
	/**
	 * 循环列表数组
	 */
	private Object[] list;
	/**
	 * 当前列表游标
	 */
	private int index = 0;
	/**
	 * iterator游标
	 */
	private int cur = 0;
	/**
	 * 大小
	 */
	private int size = 0;

	/**
	 * 生成长度为length的list
	 * 
	 * @param length
	 */
	public BaseHistoryEntity(int length) {
		if (length < 1) {
			throw new IllegalStateException("length长度不能小于0");
		}
		this.length = length;
		list = new Object[length];
	}

	/**
	 * 向list中当前游标放数据
	 * 
	 * @param entity
	 */
	public void put(E entity) {
		index = ((index + 1) % length);
		if (size < length) {
			size++;
		}
		list[index] = entity;
	}

	@SuppressWarnings("unchecked")
	/**
	 * @Description:获得当前最新的数据
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public E get() {
		return (E) list[index];
	}

	/**
	 * @Description:获得指定位置的数据，0 表示当前数据，1表示前一条数据，2表示前2条数据。。。
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (0 > i || i >= length) {
			throw new IllegalStateException("游标超范围");
		}
		int tmp = ((index - i) % length);
		tmp = tmp >= 0 ? tmp : tmp + length;
		return (E) list[tmp];
	}

	/**
	 * 获得长度
	 * 
	 * @return
	 */
	public int length() {
		return length;
	}

	/**
	 * 获得Iterator
	 * 
	 * @return
	 */
	public Iterator<E> iterator() {
		return new HisIterator();
	}

	/**
	 * BaseHistoryEntity 的HisIterator实现
	 */
	private class HisIterator implements Iterator<E> {

		HisIterator() {
			cur = 0;
		}

		/**
		 * 是否存在下一个值
		 */
		@Override
		public boolean hasNext() {
			return cur < length;
		}

		/**
		 * 下一个值
		 */
		@Override
		public E next() {

			return get(cur++);
		}

		/**
		 * 不支持删除
		 */
		@Override
		public void remove() {
			throw new IllegalStateException("不支持删除");
		}

	}
}
