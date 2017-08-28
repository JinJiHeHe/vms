package com.et.terminalserver.terminalaccess.encode;

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
 * @Description 编码处理实现类
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月7日 下午5:34:13
 * @mail terrorbladeyang@gmail.com
 */
public class Encoder implements Encode {

	//日志引用
	Log log = LogFactory.getLog(Encoder.class);

	/**
	 * 编码处理方法 通过来的包获取该包对应的协议处理类 打包成对应的message<MessageHeader,MessageBody>对象
	 * 然后传入Netty回写的通道。
	 * */
	public Message<MessageHeader, MessageBody> encode(Packet packet) {
		ProtocolAnalysis<MessageHeader, MessageBody> analysis = ProtocolAnalysisManager
				.getAnalysis(packet.getProtocolName());

		Message<MessageHeader, MessageBody> message = null;
		log.info("-------packet:" + packet.getBusinessObj().getBusinessCode());
		if (packet.getBusinessObj().getResponseCode() != BusinessObject.PR_NO_RESPONSE) {

			message = analysis.mapBusinessObject(packet.getBusinessObj(),
					packet.getOpts());
			log.info("-----------------------Encoder BEGIN--------------------------");
			if (null != message) {
				log.info("-----------------------Encoder CONTINUE--------------------------" + packet.getBusinessObj().getBusinessCode());
				byte[] response = analysis.pack(message);
				packet.setData(response);
				Command command = new Command();
				command.setParam(packet);
				command.setCode(0x2000);
				BusManager.sendCommand(BusConnectName.NETTY_WRITER, command);
			} else {
				log.warn("No mapper for business code "
						+ packet.getBusinessObj().getResponseCode());
			}
		} else {
			log.info("No response needed business for code "
					+ packet.getBusinessObj().getBusinessCode());
		}
		return message;
	}

}
