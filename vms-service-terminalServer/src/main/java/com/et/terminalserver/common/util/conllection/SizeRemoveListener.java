package com.et.terminalserver.common.util.conllection;

/**
 * @Project CNPC_VMS
 * @Title SizeRemoveListener
 * @Description 数量监听器
 * @author guanhl
 * @date 2014年10月3日 下午7:38:41
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public abstract class SizeRemoveListener<T extends ICollection> {

	// 集合中数量大小，默认1
	private int size = 1;

	/**
	 * @Description 构造方法
	 * @param size - 触发数量
	 */
	public SizeRemoveListener(int size) {
		this.size = size;
	}

	/**
	 * @Description 抽象方法，时间触发时，自定义处理该集合，应用见{@link BatchList}
	 * @param collection - 监听的目标集合
	 */
	public abstract void onSizeRemove(T collection);

	/**
	 * @Description 获取数量
	 * @return 数量
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @Description 设置数量
	 * @param size 数量
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
