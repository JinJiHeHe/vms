package com.et.terminalserver.terminalaccess.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

import java.util.List;

/**
 * @Description 
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月7日 下午8:20:05
 * @mail terrorbladeyang@gmail.com
 */
public interface NettyHandle {

	/**
	 * 初始化channel
	 * */
	void initChannel(Channel channel, byte[] data);
	
	/**
	 * 读取来的信息
	 * */
	void read(Channel channel, byte[] data);

	/**
	 * 关闭通道
	 * */
	void close(Channel channel);

	/**
	 * 刷新状态
	 * */
	void refreshState(String terminalKey);
	
	/**
	 * 
	 * */
	void refreshState1(String terminalKey);
	/**
	 * 写信息给通道
	 * */
	void write(String terminalKey, byte[] data);
	
	/**
	 * 获取绑定对象
	 * */
	ChannelWapper getWapper(String key);

	/**
	 * 解码接口
	 * */
	void decode(Channel channel, ByteBuf in, List<Object> out);

	/**
	 * 填充绑定信息
	 * */
	void fillChannelWapper(String terminalKey, String vehicleID, String terminalCode, String sim, String vehicleNo, String color);
}
