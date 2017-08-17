package com.et.terminalserver.common.bus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 消息总线类，静态变量全局使用，好好方便哦
 * @author maple
 * @version V0.5
 * @Date 2015年7月3日 下午4:39:47
 * @mail rw222222@126.com
 * @link {@link ListenerConfig} 监听配置类
 * @link {@link BusListener} 监听接口
 */
public class BusManager {

	final static private Log log = LogFactory.getLog(BusManager.class);
	// 这里绑定通道名称和监听器
	private static ConcurrentHashMap<String, BusConnect> busTables = new ConcurrentHashMap<String, BusConnect>();

	private static int syncTimeout = 3000;

	/**
	 * @Description 向总线注册监听器
	 * 
	 * @param connectName
	 *            通道名称
	 * @param listener
	 *            监听器
	 * @param threads
	 *            监听工作线程数
	 * @param threadName
	 *            线程名称
	 */
	public static void registerListener(String connectName,
			BusListener listener, int threads, String threadName) {
		busTables.get(connectName).getListeners()
				.add(new ListenerConfig(listener, threads, threadName));
	}

	/**
	 * @Description 向总线注册监听器，线程名称默认使用通道名称
	 * 
	 * @param connectName
	 *            通道名称
	 * @param listener
	 *            监听器
	 * @param threads
	 *            监听的工作线程数
	 */
	public static void registerListener(String connectName,
			BusListener listener, int threads) {
		registerListener(connectName, listener, threads, connectName);
	}

	/**
	 * @Description 向总线注册监听器，线程名称默认使用通道名称，监听工作线程数默认为1
	 * 
	 * @param connectName
	 *            通道名称
	 * @param listener
	 *            监听器
	 */
	public static void registerListener(String connectName, BusListener listener) {
		registerListener(connectName, listener, 1);
	}

	/**
	 * @Description 创建通道
	 * 
	 * @param cnnectName
	 *            所创建的通道名称
	 */
	public static void createConnect(String connectName) {
		BusConnect connect = new BusConnect();
		connect.setConnectName(connectName);
		busTables.put(connectName, connect);
	}

	public static void startConnect(String connectName) {
		busTables.get(connectName).start();
	}

	/**
	 * @Description 移除监听器
	 * 
	 * @param cnnectName
	 *            通道名称
	 * @param busListener
	 *            监听器
	 */
	public static void unRgisgerListener(String connectName,
			BusListener busListener) {
		busTables.get(connectName).getListeners().remove(busListener);
	}

	/**
	 * @Description 获取所有通道名称
	 * 
	 * @return 通道名称集合
	 */
	public static Set<String> getCreatedConnectNames() {
		return busTables.keySet();
	}

	public static void resoponseCommand(Command command) {
		if (command.isSync()) {
			// 我就是那个老娘们，我还得告诉下面那个混蛋，让他别等了
			synchronized (command) {
				command.notifyAll();
			}
		}
	}

	public static void sendCommand(String connectName, Command command) {
		if (busTables.containsKey(connectName)) {
			try {
				if (busTables.get(connectName).getStartFlag()) {
					busTables.get(connectName).getQueue().put(command);
					// 同步标志呀，等待上面那个老娘们告诉我不等了，我就不等了
					if (command.isSync()) {
						synchronized (command) {
							command.wait(syncTimeout);
						}
					}
				} else {
					log.warn("connect " + connectName + " has not started!");
				}
			} catch (InterruptedException e) {
				log.warn("put command " + command + " to " + connectName
						+ " failed");
			}
		} else {
			log.warn("connect " + connectName + " has not created!");
		}
	}

	public static void stopConnect(String connectName) {
		busTables.get(connectName).stop();
	}

}
