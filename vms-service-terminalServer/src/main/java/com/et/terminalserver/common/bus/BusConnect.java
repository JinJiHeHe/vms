package com.et.terminalserver.common.bus;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.concurrent.*;

/**
 * @Description 业务通道
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月9日 下午11:31:57
 * @mail terrorbladeyang@gmail.com
 */
public class BusConnect {

	Log log = LogFactory.getLog(BusConnect.class);

	final private int QUEUE_SIZE = 100000;// 队列大小

	final private int BUS_TIME_OUT = 3000;

	private String connectName = "default_name";

	//通道是否被激活
	private boolean startFlag = false;

	//阻塞队列 无线等待接收来的指令
	final private BlockingQueue<Command> queue = new ArrayBlockingQueue<Command>(
			QUEUE_SIZE);

	//每一个通道配套的一个线程池
	private ExecutorService exec;

	//包装对象列表 线程池对象 线程数 自定义接口
	final private List<ListenerConfig> listeners = new CopyOnWriteArrayList<ListenerConfig>();

	protected String getConnectName() {
		return this.connectName;
	}

	protected void setConnectName(String connectName) {
		this.connectName = connectName;
	}

	protected List<ListenerConfig> getListeners() {
		return this.listeners;
	}

	protected BlockingQueue<Command> getQueue() {
		return this.queue;
	}

	protected boolean getStartFlag() {
		return startFlag;
	}

	/**
	 *  通道变成非激活状态 线程池关闭
	 * */
	public void stop() {
		startFlag = false;
		exec.shutdownNow();
		exec = null;
		log.warn("Connect " + connectName + " stop receiving command ");
	}

	/**
	 * 激活通道监听 激活一个守护线程 不断从阻塞队列里拿出指令对象 然后迅速丢给 ListenerConfig 里的线程池调度去执行
	 * 自定义的接口
	 * */
	public void start() {

		exec = Executors.newSingleThreadExecutor(new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r);
				thread.setName(connectName + "_receive");
				thread.setDaemon(true);
				return thread;
			}
		});

		startFlag = true;

		exec.submit(new Runnable() {
			@Override
			public void run() {
				while (startFlag) {
					try {
						final Command command = queue.poll(BUS_TIME_OUT,
								TimeUnit.MILLISECONDS);
						if (null != command) {
							if (listeners.size() > 0) {
								for (final ListenerConfig lis : listeners) {
									lis.exec().submit(new Runnable() {
										@Override
										public void run() {
											try {
												lis.getListener()
														.commandReceived(
																command,
																connectName);
											} catch (Exception e) {
												log.warn("Connect "
														+ connectName
														+ " get a Exception", e);
											}

										}
									});
								}
							} else {
								log.warn("No listener to get command "
										+ command.toString());
							}
						}
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						stop();
					}
				}
			}
		});

		log.info("Connect " + connectName + " start listening ");
	}

}
