package com.et.terminalserver.terminalaccess.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Description 拆包的监听类
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月8日 上午8:44:24
 * @mail terrorbladeyang@gmail.com
 */
public class NettySplitPacketChannelHandler extends ByteToMessageDecoder {

	//netty处理接口
	NettyHandle nettyHandler;

	/**
	 * 拆包方法
	 * */
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		nettyHandler.decode(ctx.channel(), in, out);
	}

	public NettyHandle getNettyHandler() {
		return nettyHandler;
	}

	public void setNettyHandler(NettyHandle nettyHandler) {
		this.nettyHandler = nettyHandler;
	}

}
