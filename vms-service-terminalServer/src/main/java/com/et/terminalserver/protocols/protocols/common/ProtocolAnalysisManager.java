package com.et.terminalserver.protocols.protocols.common;

import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.MessageBody;
import com.et.terminalserver.protocols.protocols.MessageHeader;
import com.et.terminalserver.protocols.protocols.ProtocolAnalysis;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project: CNPC_VMS
 * @Title: ProtocolAnalysisFactory
 * @Description: 协议解析工厂，提供多重协议解析
 * @author: guanhl
 * @date: 2014年4月3日 上午11:55:19
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class ProtocolAnalysisManager {

	private final static ConcurrentHashMap<String, ProtocolAnalysis<MessageHeader,MessageBody>> protocolsCache = new ConcurrentHashMap<String, ProtocolAnalysis<MessageHeader,MessageBody>>();

	public static void addProtocol(String protocolName,
			ProtocolAnalysis<MessageHeader,MessageBody> analysis) {
		protocolsCache.put(protocolName, analysis);
	}

	public static void removeProtocol(String protocolName) {
		protocolsCache.remove(protocolName);
	}

	public static ProtocolAnalysis<MessageHeader,MessageBody> getAnalysis(String protocolName) {
		return protocolsCache.get(protocolName);
	}

	public static String judegeProtocol(byte[] data) {
		Set<String> keySet = protocolsCache.keySet();
		for (String key : keySet) {
			if (protocolsCache.get(key).doCase(data))
				return key;
		}
		return null;
	}

	public Object mapBusinessObject(Message<MessageHeader, MessageBody> message) {
		return protocolsCache.get(message.getMessageHeader().getProtocolName())
				.mapBusinessObject(message);
	}
}
