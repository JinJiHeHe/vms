package com.et.terminalserver.terminalaccess.netty;

import com.et.terminalserver.common.netty.NettyChannelIniter;
import io.netty.channel.Channel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

/**
 * @Description 
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月8日 上午10:20:12
 * @mail terrorbladeyang@gmail.com
 */
public class TerminalChannelIniter extends NettyChannelIniter {

	//Server的handle 也不注入了 直接的new了
	private NettyReaderListener messageHandler = new NettyReaderListener();
	private NettyChannelManager channelManager = new NettyChannelManager();
	private NettyHandler nettyHandler;

	@Override
	protected void initChannel(Channel ch) throws Exception {
		NettySplitPacketChannelHandler split = new NettySplitPacketChannelHandler();
		split.setNettyHandler(nettyHandler);
		//先解析绑定一些关系,然后拆包,
		System.out.println("channelManager1 split2 messageHandler3");
		ch.pipeline().addLast(group, channelManager, split,
				new ByteArrayDecoder(), new ByteArrayEncoder(), messageHandler);
	}

	public NettyHandler getNettyHandler() {
		return nettyHandler;
	}

	public void setNettyHandler(NettyHandler nettyHandler) {
		this.nettyHandler = nettyHandler;
		messageHandler.setHandler(nettyHandler);
		channelManager.setNettyHandler(nettyHandler);
	}

}
