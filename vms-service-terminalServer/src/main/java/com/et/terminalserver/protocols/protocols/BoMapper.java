package com.et.terminalserver.protocols.protocols;


import com.et.terminalserver.protocols.business.bo.BusinessObject;

public interface BoMapper {
	
	BusinessObject mapper(Message<? extends MessageHeader, ? extends MessageBody> message);
	
	Message<MessageHeader,MessageBody> mapper(BusinessObject bo, int opts);

}
