package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0800;
import com.et.terminalserver.t808.util.T808_Util;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0800_Process
 * @Description: 多媒体事件信息上传
 * @author: lijz
 * @date: 2014年8月6日 下午9:31:49
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0800_Process extends T808_Process<T808_MessageHeader, T808_0x0800> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0800> unpackData(byte[] data) {
		
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_REQUEST);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		// 获取消息体
		T808_0x0800 body0800 = new T808_0x0800();
		// 多媒体数据ID
		byte[] mutiMedioID = BytesUtil.getDWord(0+bodyindex, data);
		// 多媒体类型
		byte type = BytesUtil.getByte(4+bodyindex, data);
		// 多媒体格式编码
		byte format = BytesUtil.getByte(5+bodyindex, data);
		// 事件项编码
		byte event = BytesUtil.getByte(6+bodyindex, data);
		// 通道ID
		byte channelID = BytesUtil.getByte(7+bodyindex, data);
		body0800.setMutiMideoID(BytesUtil.parseBytesToInt(mutiMedioID));
		body0800.setType(type);
		body0800.setFormat(format);
		body0800.setEvent(event);
		body0800.setChannelID(channelID);
		// 打印log
//		log.debug("MutiMedioID : " + body.getMutiMideoID() + "Type :" + body.getType() + "Format :" + body.getFormat() + "Event :" + body.getEvent()
//				+ "ChannelID :" + body.getChannelID());
		return new T808_Message<T808_MessageHeader, T808_0x0800>(header,
				body0800);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0800> message) {
		//
		return null;
	}

}
