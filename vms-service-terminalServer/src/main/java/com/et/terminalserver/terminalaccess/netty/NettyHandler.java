package com.et.terminalserver.terminalaccess.netty;

import com.et.terminalserver.common.bus.BusManager;
import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.common.util.conllection.MoreKeyMap;
import com.et.terminalserver.protocols.business.bo.BusinessObject;
import com.et.terminalserver.protocols.business.bo.OPOffLine;
import com.et.terminalserver.protocols.protocols.MessageBody;
import com.et.terminalserver.protocols.protocols.MessageHeader;
import com.et.terminalserver.protocols.protocols.ProtocolAnalysis;
import com.et.terminalserver.protocols.protocols.common.ProtocolAnalysisManager;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.terminalaccess.util.BusConnectName;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * @Description 这里主要是对链路进行管理，然后支持收发数据，业务仅仅现定于此。
 * @author jakiro
 * @version V1.0
 * @Date 2015年7月24日 上午9:49:19
 * @mail terrorbladeyang@gmail.com
 */
public class NettyHandler implements NettyHandle {

	// 日志引用
	Log log = LogFactory.getLog(NettyReaderListener.class);
	// 终端标识 ：通道
	public static MoreKeyMap<String, ChannelWapper> channelMaps = new MoreKeyMap<String, ChannelWapper>();

	/**
	 * 第一步 读取数据的时候，要做的那堆事
	 * 
	 * 获取远程唯一标识remoteAddress 1.如果是首次进入 建立ChannelWapper实例 分析找到其协议解析类
	 * 将一系列绑定信息注册到内存channelMaps中 2.如果不是第一次 什么都不做。
	 */
	@Override
	public void initChannel(Channel channel, byte[] data) {

		// 远程的唯一标识
		String key = channel.remoteAddress().toString();
		// 如果不包含这个唯一标识
		if (!channelMaps.contains(key)) {
			// 拿到传过来的数据
			byte[] source = data;
			// channel key
			ChannelWapper channelInfo = channelMaps.get(key);

			// 协议名称
			String protocolName = null;
			// 终端标识 一般是sim卡(起码部标是)
			String terminalKey = null;
			// 是否首次连接
			channelInfo = new ChannelWapper(null, key, null, channel);
			// 缓存连接信息
			channelMaps.put(key, channelInfo);
			// 判断该连接的协议类型
			protocolName = ProtocolAnalysisManager.judegeProtocol(source);

			// 如果该协议不存在，打印日志，忽略数据，关闭连接，原因代码01
			if (null == protocolName) {
				log.fatal("IGNORE-01-" + BytesUtil.bytesToHexString(source));
				System.out.println("protocolName is null"+"IGNORE-01-" + BytesUtil.bytesToHexString(source));
				channelInfo.getChannel().close();
				return;
			}
			// 保存连接信息协议类型 protocol -- T808
			channelInfo.setProtocolName(protocolName);

			// 拿到该信息对应的协议的解析类
			ProtocolAnalysis<MessageHeader, MessageBody> analysis = ProtocolAnalysisManager
					.getAnalysis(protocolName);
			// 解析数据终端标识
			terminalKey = analysis.getTerminalKey(source);
			// 如果终端id为空，打印日志，忽略数据，关闭连接，原因代码02
			if (null == terminalKey) {
				log.fatal("IGNORE-02-" + BytesUtil.bytesToHexString(source));
				System.out.println("terminalKey is null:"+"IGNORE-02-" + BytesUtil.bytesToHexString(source));
				channelInfo.getChannel().close();
				return;
			}
			// 增加通道标识与终端标识的关系key，这里可以实现通过终端标识获取到ChannelWapper
			channelMaps.addRelation(key, terminalKey); // <key,<?,channelInfo>>-->>
			// 保存连接信息终端标识
			channelInfo.setTerminalKey(terminalKey);
			System.out.println("2:initchannel protocolname: "+protocolName+" terminalkey:"+terminalKey);
		}
	}

	/**
	 * 关闭连接
	 */
	@Override
	public void close(Channel channel) {
		// 获取通道标识
		String key = channel.remoteAddress().toString();
		// 断开连接，清除通道信息
		ChannelWapper info = channelMaps.remove(key);
		// 如果删除了这个连接，把状态变成下
		if (null != info) {
			info.setChannelState(-1);
		}
		log.info("Terminal channel is closed " + info.getTerminalKey());
		// 这里甩到业务类里，推送离线消息，跳到business包
		Command command = new Command();
		command.setOpts(BusinessObject.OP_OFFLINE);
		Packet packet = new Packet(info.getTerminalKey(), null,
				info.getChannelKey(), info.getProtocolName(),
				info.getChannelState());
		// 推送离线所用到的对象
		OPOffLine offLine = new OPOffLine();
//		offLine.setVid(info.getRelationInfo().getVehicleInfo().getVechileId());
		offLine.setTerminalKey(info.getTerminalKey());
		packet.setBusinessObj(offLine);
		packet.setChannelWapper(info);
		command.setParam(packet);

//		// 发送到业务通道去进行处理
//		BusManager.sendCommand(BusConnectName.BUSINESS, command);
	}

	/**
	 * 刷新连接状态为在线
	 */
	@Override
	public void refreshState(String terminalKey) {
		// 将终端从上线弄成在线的状态
		channelMaps.get(terminalKey).setChannelState(0);
		log.info("Terminal is on line " + terminalKey);
	}

	/**
	 * 刷新连接状态改为下线
	 */
	@Override
	public void refreshState1(String terminalKey) {
		// 将终端从上线弄成下线
		channelMaps.get(terminalKey).setChannelState(1);
		log.info("refresh state to get new info" + terminalKey);
	}

	/**
	 * 填充连接包装类里关联的车辆终端相关信息，和一堆乱七八糟的关系。
	 */
	@Override
	public void fillChannelWapper(String terminalKey, String vehicleID,
			String terminalCode, String sim,String vehicleNo ,String color) {
		// 上线后，将绑定信息补充一下
		ChannelWapper wapper = channelMaps.get(terminalKey);
		// 这里造成了，下面的write方法使用关于终端号、车辆id、sim卡任何一个串，都可以获取这个连接
		channelMaps.addRelation(wapper.getChannelKey(), vehicleID);
		channelMaps.addRelation(wapper.getChannelKey(), sim);
		channelMaps.addRelation(wapper.getChannelKey(), terminalCode);
		channelMaps.addRelation(wapper.getChannelKey(), vehicleNo+"-"+color);
		log.info("Terminal channel wapper is filled " + terminalKey);
	}

	


	/**
	 * 通过各种key，找到对应的通道包装类，然后将数据发下去 1.如果这个车辆不在线的话 异常 2.如果车辆在线的话 找到其所在的通道 下发指令
	 */
	@Override
	public void write(String terminalKey, byte[] data) {
		// 这就是向终端发送数据
		if (!channelMaps.contains(terminalKey)) {
			log.warn("Connection is not opened " + terminalKey);
		} else {
			channelMaps.get(terminalKey).getChannel().writeAndFlush(data);
			log.info("SENDIT-" + terminalKey + "-"
					+ BytesUtil.bytesToHexString(data));
		}
	}

	/**
	 * 通过各种key拿到对应的通道包装类
	 */
	@Override
	public ChannelWapper getWapper(String key_wapper) {
		return channelMaps.get(key_wapper);
	}

	/**
	 * 在socket服务端接收到数据的时候被调用 拿到数据后 拿到remoteAddress(远程地址),拿到之前的绑定对象
	 * 获取协议名,终端标识,协议处理类。 然后发送到解码通道处理。
	 * */
	@Override
	public void read(Channel channel, byte[] data) {
		byte[] source = data;
		// channel key
		String key = channel.remoteAddress().toString();

		// 通过终端标识得到绑定对象
		ChannelWapper channelInfo = channelMaps.get(key);
		// 直接获取协议名称
		String protocolName = channelInfo.getProtocolName();
		// 直接获取终端标识
		String terminalKey = channelInfo.getTerminalKey();
		// 接入数据的日志
		System.out.println("5:ACCEPT-" + "protocolname:"+protocolName+" terminalkey:"+terminalKey + "-"
				+ BytesUtil.bytesToHexString(source));
		// 根据协议获得解析类
		ProtocolAnalysis<MessageHeader, MessageBody> analysis = ProtocolAnalysisManager
				.getAnalysis(protocolName);
		if (null != analysis) {
			// 创建指令
			Command command = new Command();
			command.setParam(new Packet(terminalKey, source, key, protocolName,
					channelInfo.getChannelState()));
			// 存储秒到redis中，解决车辆在线650小时以上时值溢出问题
			((Packet) command.getParam()).setHoldTime((int) (channelInfo
					.getOnLineTime() / 1000));
			((Packet) command.getParam()).setChannelWapper(channelInfo);
			// 扔到解析组件，飞到decode包
			BusManager.sendCommand(BusConnectName.DECODER, command);

			 }

	}

	/**
	 * 第二步 拆包
	 * 
	 * 如果channel所在远程地址有问题(channel有问题),直接返回。
	 * 没问题拿到绑定对象-->拿到协议名-->拿到协议处理类-->走拆包方法-->都添加到list中。
	 * */
	@Override
	public void decode(Channel channel, ByteBuf in, List<Object> out) {

		if (channel.remoteAddress() == null)
			return;
		// 得到key 地址
		String key = channel.remoteAddress().toString();

		if (channelMaps.contains(key)) {
			// 得到绑定对象
			ChannelWapper channelInfo = channelMaps.get(key);
			// 得到协议名
			String protocolName = channelInfo.getProtocolName();
			System.out.println("3:decode "+protocolName);
			// 得到对应协议处理类
			ProtocolAnalysis<MessageHeader, MessageBody> analysis = ProtocolAnalysisManager
					.getAnalysis(protocolName);
			// 其实返回值是个ByteBuf
			Object frame = analysis.disassembly(channel, in);

			// 添加到netty框架中的指定list中。
			if (frame != null) {
				out.add(frame);
			}
		}
	}
	

	public static MoreKeyMap<String, ChannelWapper> getChannelMaps() {
		return channelMaps;
	}

	public static void setChannelMaps(MoreKeyMap<String, ChannelWapper> channelMaps) {
		NettyHandler.channelMaps = channelMaps;
	}

	public static void main(String[] args) {
		MoreKeyMap<String, String> morekey = new MoreKeyMap<String, String>();

		morekey.put("jakiro", "maple");

		morekey.addRelation("jakiro", "niubi");

		morekey.addRelation(morekey.getMainKey("niubi"), "aqi");
//		morekey.addRelation("jakiro", "aqi");

		// morekey.get("niubi");
		// morekey.get("jakiro");

		System.out.println(morekey.get("aqi") + " " + morekey.get("jakiro"));
	}


}
