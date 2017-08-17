package com.et.terminalserver.terminalaccess.netty;

import com.et.terminalserver.common.bus.BusListener;
import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.protocols.business.bo.BusinessObject;
import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.MessageBody;
import com.et.terminalserver.protocols.protocols.MessageHeader;
import com.et.terminalserver.protocols.protocols.ProtocolAnalysis;
import com.et.terminalserver.protocols.protocols.common.ProtocolAnalysisManager;

/**
 * @Description socket写监听
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月8日 上午8:49:56
 * @mail terrorbladeyang@gmail.com
 */
public class NettyWriterListener implements BusListener {

	//netty事件处理接口
	NettyHandle nettyWriter;

	/**
	 * 接收信息处理接口
	 * */
	@Override
	@SuppressWarnings("unchecked")
	public void commandReceived(Command command, String connectName) {

		//拿到Code
		int code = command.getCode();

		//看看来的code的内容
		switch (code) {
		
		//填充信息
		case BusinessObject.OP_FILLINFO:
			//创建一个关系对象
			RelationInfo relation = (RelationInfo) command.getParam();
			//刷新车辆状态
			nettyWriter.refreshState(relation.getTerminalKey());
			//填充车辆信息
			nettyWriter.fillChannelWapper(relation.getTerminalKey(), relation
					.getVehicleInfo().getVechileId(), relation
					.getTerminalInfo().getTerminalCode(), relation.getSimInfo()
					.getSimNum(),relation.getVehicleInfo().getPlate(),relation.getVehicleInfo().getVehicleColor());
			break;
			
		//发送数据
		case BusinessObject.OP_SEND_DATA:
			//拿到消息包
			Packet packet_send = (Packet) command.getParam();
			//直接写还给socket
			nettyWriter.write(packet_send.getTerminalKey(),
					packet_send.getData());
			break;
			
		//指令下发
		case BusinessObject.OP_COMMAND:
			//获得 消息参数
			Message<MessageHeader, MessageBody> msg = (Message<MessageHeader, MessageBody>) command
					.getParam();
			//拿到唯一标识
			String terminalKey = msg.getMessageHeader().getTerminalKey();
			//获得绑定对象
			ChannelWapper wapper = nettyWriter.getWapper(terminalKey);
			//获得协议名
			String protocolName = wapper.getProtocolName();
			//拿到对应的解析类
			ProtocolAnalysis<MessageHeader, MessageBody> analysis = ProtocolAnalysisManager.getAnalysis(protocolName);
			//打包成要发送的消息
			byte[] pack_data = analysis.pack(msg);
			//写给对应车的通道
			nettyWriter.write(terminalKey, pack_data);
			break;
			
			
		case BusinessObject.OP_UPDATE:
			//刷新状态为下线
			nettyWriter.refreshState1((String) command.getParam());
			break;
		default:
			break;
		}
	}

	public NettyHandle getNettyWriter() {
		return nettyWriter;
	}

	public void setNettyWriter(NettyHandle nettyWriter) {
		this.nettyWriter = nettyWriter;
	}

}
