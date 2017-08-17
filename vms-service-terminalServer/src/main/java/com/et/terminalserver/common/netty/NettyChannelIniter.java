package com.et.terminalserver.common.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.util.concurrent.EventExecutorGroup;

public abstract class NettyChannelIniter extends ChannelInitializer<Channel> {

	protected EventExecutorGroup group;

	public void setGroup(EventExecutorGroup group) {
		this.group = group;
	}

}
