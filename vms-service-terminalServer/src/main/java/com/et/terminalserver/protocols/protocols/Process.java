package com.et.terminalserver.protocols.protocols;


/**
 * @Project: CNPC_VMS
 * @Title: IProcess
 * @Description: 流程接口
 * @author: guanhl
 * @date: 2014年4月3日 下午11:45:54
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public interface Process<A extends MessageHeader,B extends MessageBody> {
	
	public final static int MESSAGETYPE_REQUEST = 0;
	public final static int MESSAGETYPE_RESPONSE = 1;
	/**
	 * @Description:终端上传指令的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	 Message<A, B> unpackData(byte[] data);

	/**
	 * @Description:平台下发指令的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
     byte[] packData(Message<A, B> message);

}
