package com.et.terminalserver.terminalaccess.encode;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.MessageBody;
import com.et.terminalserver.protocols.protocols.MessageHeader;
import com.et.terminalserver.terminalaccess.netty.Packet;

/**
 *  编码接口
 * */
public interface Encode {

	Message<MessageHeader, MessageBody> encode(Packet packet);

}
