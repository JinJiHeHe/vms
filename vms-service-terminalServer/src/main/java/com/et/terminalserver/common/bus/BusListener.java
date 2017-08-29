package com.et.terminalserver.common.bus;

/**
 * @Description 监听接口
 * @author maple
 * @version V1.0
 * @Date 2015年7月3日 下午5:27:37
 * @mail rw222222@126.com
 */
public interface BusListener {

	void commandReceived(Command command, String connectName);
}
