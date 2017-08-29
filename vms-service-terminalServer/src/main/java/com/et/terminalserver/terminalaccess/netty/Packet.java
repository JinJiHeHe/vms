package com.et.terminalserver.terminalaccess.netty;

import com.et.terminalserver.protocols.business.bo.BusinessObject;

/**
 * @Description 内部传输的包
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月8日 上午10:19:37
 * @mail terrorbladeyang@gmail.com
 */
public class Packet {

	private String terminalKey; //唯一标识

	private byte[] data; //数据

	private String remoteAddress;//地址

	private String protocolName;//协议名

	private BusinessObject businessObj;//业务对象

	private int channelState = 0; //状态
	
	private int opts = 0; //流水号
	
	private int holdTime = 0;//持续时长
	
	private ChannelWapper channelWapper;//绑定对象
	
	public Packet(String terminalKey, byte[] data, String remoteAddress,
                  String protocolName, int state) {
		this.terminalKey = terminalKey;
		this.data = data;
		this.remoteAddress = remoteAddress;
		this.protocolName = protocolName;
		this.channelState = state;
	}

	public String getTerminalKey() {
		return terminalKey;
	}

	public void setTerminalKey(String terminalKey) {
		this.terminalKey = terminalKey;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public BusinessObject getBusinessObj() {
		return businessObj;
	}

	public void setBusinessObj(BusinessObject businessObj) {
		this.businessObj = businessObj;
	}

	public int getChannelState() {
		return channelState;
	}

	public void setChannelState(int channelState) {
		this.channelState = channelState;
	}

	public int getOpts() {
		return opts;
	}

	public void setOpts(int opts) {
		this.opts = opts;
	}

	public int getHoldTime() {
		return holdTime;
	}

	public void setHoldTime(int holdTime) {
		this.holdTime = holdTime;
	}

	public ChannelWapper getChannelWapper() {
		return channelWapper;
	}

	public void setChannelWapper(ChannelWapper channelWapper) {
		this.channelWapper = channelWapper;
	}


}
