package com.et.terminalserver.common.bus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Description 监听
 * @author jakiro
 * @version V1.0
 * @Date 2015年7月17日 下午10:37:55
 * @mail terrorbladeyang@gmail.com
 */
public class ListenerConfig {
	
	
	private BusListener listener; //指令监听端口
	private int threads;  //线程数
	private ExecutorService exec; //线程池对象

	/**
	 *  构造方法 放了接口 
	 * */ 
	protected ListenerConfig(BusListener listener, int threads, String threadName) {
		this.listener = listener; //绑定接口 
		this.threads = threads; //绑定线程数
		final String name = threadName; //绑定名
		exec = Executors.newFixedThreadPool(threads, new ThreadFactory() { //用线程工厂方式 命名线程
			AtomicInteger num = new AtomicInteger();
			@Override
			public Thread newThread(Runnable arg0) {
				Thread thread = new Thread(arg0);
				thread.setName(name + "_Listener-" + num.incrementAndGet());
				return thread;
			}
		});
	}

	protected BusListener getListener() {
		return listener;
	}

	protected int getThreads() {
		return threads;
	}
	
	protected ExecutorService exec() {
		return exec;
	}
	

}
