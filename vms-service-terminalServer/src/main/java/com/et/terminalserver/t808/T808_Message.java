package com.et.terminalserver.t808;

import com.et.terminalserver.protocols.protocols.common.CommonMessage;

/**
 * @Description 808消息传递
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月9日 下午11:30:40
 * @mail terrorbladeyang@gmail.com
 */
public class T808_Message<A extends T808_MessageHeader, B extends T808_MessageBody> extends CommonMessage<A, B> {

	public T808_Message(A header, B body) {
		super(header, body);
	}

	@Override
	public String toString() {
		return "T808_Message [getMessageHeader()=" + getMessageHeader()
				+ ", getMessageBody()=" + getMessageBody() + "]";
	}

	
	
}
