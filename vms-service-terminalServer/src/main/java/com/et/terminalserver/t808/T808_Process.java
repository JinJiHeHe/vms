package com.et.terminalserver.t808;

import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.Process;

/**
 * @Project: CNPC_VMS
 * @Title: T808_Process
 * @Description: 808消息处理过程抽象类
 * @author: guanhl
 * @date: 2014年3月24日 下午2:37:15
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public abstract class T808_Process<A extends T808_MessageHeader,B extends T808_MessageBody> implements Process<A,B> {
    
	/**
	 * @Description:终端上传指令的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public abstract Message<A, B> unpackData(byte[] data);

	/**
	 * @Description:平台下发指令的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public abstract byte[] packData(Message<A,B> message);
}
