package com.et.terminalserver.protocols.protocols;

import com.et.terminalserver.protocols.business.bo.BusinessObject;
import io.netty.buffer.ByteBuf;

/**
 * @Project: CNPC_VMS
 * @Title: IProtocolAnalysis
 * @Description: 协议解析接口
 * @author: guanhl
 * @date: 2014年4月3日 下午5:05:21
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public interface ProtocolAnalysis<A extends MessageHeader, B extends MessageBody> {

	Message<A, B> unpack(byte[] data);

	byte[] pack(Message<A, B> message);

	boolean doCase(Object data);

	String getTerminalKey(byte[] data);

	BusinessObject mapBusinessObject(Message<A, B> message);

	Message<A, B> mapBusinessObject(BusinessObject bo, int opts);

	Object disassembly(io.netty.channel.Channel channel, ByteBuf in);

}
