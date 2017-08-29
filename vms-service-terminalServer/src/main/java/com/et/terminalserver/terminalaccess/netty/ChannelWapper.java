package com.et.terminalserver.terminalaccess.netty;

import io.netty.channel.Channel;

/**
 * @Description 通道绑定一系列关系 1.协议类型 2.通道Key 3.终端标识 4.通道 5.终端连接状态 6.终端编号 7.sim卡号
 *              8.车辆ID
 * @author jakiro
 * @version V1.0
 * @Date 2015年7月24日 上午9:49:19
 * @mail terrorbladeyang@gmail.com
 */
public class ChannelWapper {

	private String protocolName;// 协议类型
	private String channelKey; // 通道标识
	private String terminalKey; // 终端标识
	private Channel channel; // 通道
	private int channelState = 1; // 相对于终端的连接状态 ，0是连接，1是上线，-1是下线
	private long onLineTime = System.currentTimeMillis(); // 创建时，定下的誓言

//	String terminalCode;// 终端编号，等待一个包，之后填充
//	String simNum; // sim卡，等待一个包，之后填充
//	String vechileId; // 车辆id，等待一个包，之后填充
	private RelationInfo relationInfo;
	
	public ChannelWapper(String protocolName, String channelKey, String terminalKey,
                         Channel channel) {
		this.protocolName = protocolName;
		this.channelKey = channelKey;
		this.terminalKey = terminalKey;
		this.channel = channel;
	}

	/**
	 * 创建这个对象的时候，是刚上线的时候，有一个初始时间，用当前时间与初始时间计算在线时长。
	 * 
	 * @Date 2015年9月18日 上午10:00:00
	 */
	public long getOnLineTime() {
		if (channelState >= 0) {
			return System.currentTimeMillis() - onLineTime;
		}
		return 0;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public String getChannelKey() {
		return channelKey;
	}

	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}

	public String getTerminalKey() {
		return terminalKey;
	}

	public void setTerminalKey(String terminalKey) {
		this.terminalKey = terminalKey;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public int getChannelState() {
		return channelState;
	}

	public void setChannelState(int channelState) {
		this.channelState = channelState;
	}

	public RelationInfo getRelationInfo() {
		return relationInfo;
	}

	public void setRelationInfo(RelationInfo relationInfo) {
		this.relationInfo = relationInfo;
	}

}
