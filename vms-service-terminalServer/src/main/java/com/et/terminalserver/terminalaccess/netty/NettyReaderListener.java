package com.et.terminalserver.terminalaccess.netty;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/**
 * @Description netty正式处理坚挺类
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月7日 下午11:59:26
 * @mail terrorbladeyang@gmail.com
 */
@Sharable
public class NettyReaderListener extends ChannelHandlerAdapter {

	//netty事件处理类
	NettyHandle handler;

	/**
	 * netty读 监听
	 * */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// netty读取数据的事件被调用了
		handler.read(ctx.channel(), (byte[]) msg);
	}

	/**
	 * 关闭的监听
	 * */
	@Override
	public void close(ChannelHandlerContext ctx, ChannelPromise promise)
			throws Exception {
		// netty关闭连接事件被调用了
		handler.close(ctx.channel());
	}

	/**
	 * 异常处理监听
	 * */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		handler.close(ctx.channel());
		super.exceptionCaught(ctx, cause);
	}

	public NettyHandle getHandler() {
		return handler;
	}

	public void setHandler(NettyHandle handler) {
		this.handler = handler;
	}

	
}
