package com.et.terminalserver.terminalaccess.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Description handle处理链 其中的链路管理
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月7日 下午5:45:01
 * @mail terrorbladeyang@gmail.com
 */
@Sharable
public class NettyChannelManager extends ChannelHandlerAdapter {

	//公用的nettyHandle接口
	NettyHandle nettyHandler;

	
	/**
	 * netty接收消息处理接口
	 * */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object data)
			throws Exception {
		//拿到信息所在channel
		final Channel channel = ctx.channel();
		//拷贝一份当前数据
		ByteBuf bf = ((ByteBuf) data).copy();
		//定义一个跟byte相同大小的byte[]数组
		byte[] source = new byte[bf.readableBytes()];
		//把buffer内容搞到byte[]里边
		bf.readBytes(source);
		//初始化一下channel
		nettyHandler.initChannel(channel, source);
		super.channelRead(ctx, data);
	}

	public NettyHandle getNettyHandler() {
		return nettyHandler;
	}

	public void setNettyHandler(NettyHandle nettyHandler) {
		this.nettyHandler = nettyHandler;
	}

}
