package com.et.terminalserver.terminalaccess.main;

import com.et.terminalserver.common.netty.NettyServer;
import com.et.terminalserver.common.server.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TerminalAccessServer implements Server {

	// 日志 拿的是log4j2
	private final static Logger log = LogManager.getLogger(TerminalAccessServer.class);

//	// 通道监听表 <通道名,通道监听类>
//	private Map<String, BusListener> busListeners;

	// Netty socket服务启动类
	private NettyServer nettyServer;

//	// Redis 监听表 <Redis通道名,Redis监听类>
//	private Map<String, JedisPubSub> redisListeners;
//	// Redis 消费者接口
//	private RedisConsumer redisConsumer;

	@Override
	public boolean init(Object param) {

//		// 初始化内部组件监听
//		Set<String> keys = busListeners.keySet();
//		for (String key : keys) {
//			BusManager.createConnect(key);
//			BusManager.registerListener(key, busListeners.get(key), 8);
//		}
//		// 初始化redis连接池的连接
//		if (!redisConsumer.init())
//			return false;
	//	Class<ArrayList<String>> a = ArrayList.class;
		return true;
	}

	@Override
	public boolean start(Object param) {

//		// 启动内部组件监听
//		Set<String> keys = busListeners.keySet();
//		for (String key : keys) {
//			BusManager.startConnect(key);
//		}
//
//		// 启动redis通道监听
//		for (Map.Entry<String, JedisPubSub> entry : redisListeners.entrySet()) {
//			redisConsumer.sub(entry.getKey(), entry.getValue());
//		}

		// 启动socket服务
		try {
			nettyServer.start();
			log.info("netty server started succeed at port " + nettyServer.getPort());
		} catch (InterruptedException e) {
			log.warn("netty server started failed at port " + nettyServer.getPort(), e);
			return false;
		}

		
		return true;
	}

	@Override
	public boolean stop(Object param) {

//		// 关闭内部组件监听
//		Set<String> keys = busListeners.keySet();
//		for (String key : keys) {
//			BusManager.stopConnect(key);
//		}
//		// 关闭redis通道监听
//		for (Map.Entry<String, JedisPubSub> entry : redisListeners.entrySet()) {
//			redisConsumer.unsub(entry.getKey());
//		}
//		// 关闭redis连接池
//		RedisPoolManager.closePool();
		// 关闭socket服务
		nettyServer.shutdown();

		return true;
	}

//	public Map<String, BusListener> getBusListeners() {
//		return busListeners;
//	}
//
//	public void setBusListeners(Map<String, BusListener> busListeners) {
//		this.busListeners = busListeners;
//	}

	public NettyServer getNettyServer() {
		return nettyServer;
	}

	public void setNettyServer(NettyServer nettyServer) {
		this.nettyServer = nettyServer;
	}

//	public Map<String, JedisPubSub> getRedisListeners() {
//		return redisListeners;
//	}
//
//	public void setRedisListeners(Map<String, JedisPubSub> redisListeners) {
//		this.redisListeners = redisListeners;
//	}
//
//	public RedisConsumer getRedisConsumer() {
//		return redisConsumer;
//	}
//
//	public void setRedisConsumer(RedisConsumer redisConsumer) {
//		this.redisConsumer = redisConsumer;
//	}

}
