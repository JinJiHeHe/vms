package com.et.terminalserver.common.netty;

import com.et.terminalserver.common.cache.ICache;
import com.et.terminalserver.common.cache.LocalCacheManager;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultEventExecutorGroup;

import java.net.InetSocketAddress;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Description Netty客户端
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月10日 上午11:54:58
 * @mail terrorbladeyang@gmail.com
 */
public class NettyClient {
    //客户端引导程序
	private Bootstrap bootstrap;
	// 通过nio方式来接收连接和处理连接
	private EventLoopGroup eventLoopGroup;
	//I／O线程是不允许被阻塞的，也就是不能在ChannelHandler中进行任何阻塞式的处理，但是对此我们也有相应的解决方法.
	//就是在把ChannelHanders添加到ChannelPipeline的时候，指定一个EventExecutorGroup，ChannelHandler中所有的方法都将会在这个指定的EventExecutorGroup中运行。
	//而这个EVentExecutorGroup运行的线程与I/O线程不同，达到不阻塞I／O的目的。 
	private DefaultEventExecutorGroup defaultEventExecutorGroup;
    //线程数
	private int workerThreads;
	//端口
	private int port;
	//超时时间
	private int timeout = 10 * 1000 * 60;
	//接收信息的缓冲区大小
	private int receivebuf = 2048;
	//处理类们的代理类
	private NettyChannelIniter channelInitializer;
	//远程地址
	private String host;
	
	ICache platTable= LocalCacheManager.getCache("vms_xhpl_809_platTable");
	
	public void start() throws InterruptedException {

		this.bootstrap = new Bootstrap();
		this.eventLoopGroup = new NioEventLoopGroup();

		this.defaultEventExecutorGroup = new DefaultEventExecutorGroup(
				workerThreads, new ThreadFactory() {
					private AtomicInteger threadIndex = new AtomicInteger(0);

					@Override
					public Thread newThread(Runnable r) {
						return new Thread(r, "NettyClientWorkerThread_"
								+ this.threadIndex.incrementAndGet());
					}
				});
		
		channelInitializer.setGroup(defaultEventExecutorGroup);
		this.bootstrap
				.group(this.eventLoopGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 65536)
				.option(ChannelOption.SO_REUSEADDR, true)
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout)
				// 请求超时，客户端用的吧
				.option(ChannelOption.SO_TIMEOUT, timeout)
				// 等待超时
				.option(ChannelOption.SO_RCVBUF, receivebuf)
				.option(ChannelOption.RCVBUF_ALLOCATOR,
						new FixedRecvByteBufAllocator(receivebuf))
				.option(ChannelOption.TCP_NODELAY, true)
				.localAddress(new InetSocketAddress(port))
				.handler(channelInitializer);

//		this.bootstrap.bind().sync();
//        ChannelFuture f=this.bootstrap.connect(host,port);
        
//        this.channel=f.channel();
        //等待连接关闭
//        f.channel().closeFuture().sync();
	}
	
	public void connect(int port,String host) throws InterruptedException{
		//发起异步连接操作
		ChannelFuture f=this.bootstrap.connect(host,port).sync();
		//每次客户端出去连一个平台 就拿到一个双链路的控制类
		
	}

	public void shutdown() {
		try {
			this.eventLoopGroup.shutdownGracefully();

			if (this.defaultEventExecutorGroup != null) {
				this.defaultEventExecutorGroup.shutdownGracefully();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getWorkerThreads() {
		return workerThreads;
	}

	public void setWorkerThreads(int workerThreads) {
		this.workerThreads = workerThreads;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getReceivebuf() {
		return receivebuf;
	}

	public void setReceivebuf(int receivebuf) {
		this.receivebuf = receivebuf;
	}

	public NettyChannelIniter getChannelInitializer() {
		return channelInitializer;
	}

	public void setChannelInitializer(NettyChannelIniter channelInitializer) {
		this.channelInitializer = channelInitializer;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
