package com.et.terminalserver.terminalaccess.decode;

import com.et.terminalserver.common.bus.BusManager;
import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.protocols.business.bo.BusinessObject;
import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.MessageBody;
import com.et.terminalserver.protocols.protocols.MessageHeader;
import com.et.terminalserver.protocols.protocols.ProtocolAnalysis;
import com.et.terminalserver.protocols.protocols.common.ProtocolAnalysisManager;
import com.et.terminalserver.terminalaccess.netty.Packet;
import com.et.terminalserver.terminalaccess.util.BusConnectName;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 解码实现类
 * */ 
public class Decoder implements Decode {

	//日志
	private final static Log log = LogFactory.getLog(Decoder.class);

	/**
	 * 接口方法实现 通过协议处理类工厂 得到包的对应的解析类 然后解析类对包进行拆包 返回有消息头有消息体的联合对象
	 * 1.如果是不需要回复的 发送到TERMINAL_RESPONSE通道。 
	 * 2.如果是需要应答的 发送到BUSINESS(业务)通道里。
	 * */
	@Override
	public BusinessObject decode(Packet packet) {
		// 动态获取解析类，根据协议
		ProtocolAnalysis<MessageHeader, MessageBody> analysis = ProtocolAnalysisManager
				.getAnalysis(packet.getProtocolName());
		// 解析数据变成消息对象
		Message<MessageHeader, MessageBody> message = analysis.unpack(packet
				.getData());
		BusinessObject businessObj = null;
		if (null != message) {
			// 映射成业务对象
			businessObj = analysis.mapBusinessObject(message);

			if (null != businessObj) {
				// 这里就要把业务对象丢给业务类处理了 ，跳到business包
				packet.setBusinessObj(businessObj);
				//设置流水号
				packet.setOpts(message.getMessageHeader().getOpts());
				Command command = new Command();
				// 这里业务对象带着业务标识哦，注意看到哦
				command.setCode(businessObj.getBusinessCode());
				command.setParam(packet);
				
                //这个是不需要应答的
				if (businessObj.getResponseCode() <= BusinessObject.PR_NO_RESPONSE) {
					BusManager.sendCommand(BusConnectName.TERMINAL_RESPONSE,
							command);
				} else {//这些是需要应答的
					BusManager.sendCommand(BusConnectName.BUSINESS, command);
				}

				log.info("Get busniess object "
						+ businessObj.getBusinessCode() + " of "
						+ packet.getProtocolName() + " "
						+ businessObj.getTerminalKey());
			} else {
				log.info("Message " + packet.getProtocolName() + " "
						+ message.getMessageHeader().getMessageID() + " by "
						+ packet.getProtocolName() + "mapper failed");
			}
		} else {
			log.info("Packet unpack failed by " + packet.getProtocolName()
					+ " and terminalKey is " + packet.getTerminalKey());
		}
		return businessObj;
	}
}