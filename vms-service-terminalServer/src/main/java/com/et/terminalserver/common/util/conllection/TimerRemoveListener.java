package com.et.terminalserver.common.util.conllection;

/**
 * @Project: CNPC_VMS
 * @Title: TimerRemoveListener
 * @Description: 时间监听器
 * @author: yangjl
 * @date: 2014年8月7日 上午10:08:31
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

public abstract class TimerRemoveListener<T extends ICollection> {

	private int period;// 重复时间 单位s
	private int delay;// 延迟时间 单位s

	/**
	 * @Description 构造方法
	 * @param period - 重复时间
	 * @param delay - 延迟时间
	 */
	protected TimerRemoveListener(int period, int delay) {
		this.period = period;
		this.delay = delay;
	}

	/**
	 * @Description 抽象方法，自定义实现处理该集合
	 * @param collection - 监听的集合或副本
	 */
	public abstract void onTimeRemove(T collection);

	/**
	 * @Description 获取重复时间
	 * @return 重复时间
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * @Description 获取延迟时间
	 * @return 延迟时间
	 */
	public int getDelay() {
		return delay;
	}
}
