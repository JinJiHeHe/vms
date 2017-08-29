package com.et.terminalserver.common.util.conllection;

/**
 * @Project CNPC_VMS
 * @Title IListenerSupport
 * @Description 监听支持接口
 * @author guanhl
 * @date 2014年10月3日 下午7:43:04
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public interface IListenerSupport {

	/**
	 * @Description 增加监听
	 * @param listener - 监听器
	 */
	public void addListener(Object listener);

	/**
	 * @Description 删除监听
	 * @param listener - 删除监听
	 */
	public void removeListener(Object listener);
}
