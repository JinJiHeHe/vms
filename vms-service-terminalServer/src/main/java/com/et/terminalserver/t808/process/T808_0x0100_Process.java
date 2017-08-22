package com.et.terminalserver.t808.process;

import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0100;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.UnsupportedEncodingException;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0100_Process
 * @Description: 终端注册消息解析类 起始字节 字段 数据类型 描述及要求 0 省域ID WORD
 *               标示终端安装车辆所在的省域，0保留，由平台取默认值。省域ID采用GB/T 2260中规定的行政区划代码六位中前两位。 2
 *               市县域ID WORD 标示终端安装车辆所在的市域和县域，0保留，由平台取默认值。市县域ID采用GB/T
 *               2260中规定的行政区划代码六位后四位。 4 制造商ID BYTE[5] 五个字节，终端制造商编码。 9终端型号
 *               BYTE[20] 二十个字节，此终端型号由制造商自行定义，位数不足时，后补“0X00”。 29终端ID BYTE[7]
 *               七个字节，由大写字母和数字组成，此终端ID由制造商自行定义。 36 车牌颜色 BYTE 车牌颜色，按照JT/T
 *               415-2006的5.4.12 37 车牌 STRING 公安交通管理部门颁发的机动车号牌
 * @author: guanhl
 * @date: 2014年3月31日 上午1:03:11
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0100_Process extends
		T808_Process<T808_MessageHeader, T808_0x0100> {

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0100> unpackData(byte[] data) {
		new String(data);
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_REQUEST);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		// 获取消息体
		T808_0x0100 body = new T808_0x0100();
		
		byte[] proviceID = BytesUtil.getWord(0 + bodyindex, data);
		byte[] cityID = BytesUtil.getWord(2 + bodyindex, data);
		byte[] providerID = BytesUtil.cutBytes(4 + bodyindex, 5, data);
		byte[] terminalVersion = BytesUtil.cutBytes(9 + bodyindex, 20, data);
		byte[] terminalID = BytesUtil.cutBytes(29 + bodyindex, 7, data);
		byte color = BytesUtil.getByte(36 + bodyindex, data);
		byte[] licensePlate = BytesUtil.cutBytes(37 + bodyindex, data.length
				- 37 - bodyindex - 2, data);

		// 车牌颜色 BYTE
		body.setColor(color);
		body.setProvinceID(BytesUtil.parseBytesToInt(proviceID));
		// 市县域ID WORD
		body.setCityID(BytesUtil.parseBytesToInt(cityID));
		try {// 制造商ID BYTE[5]
			body.setProviderID(new String(providerID, "US-ASCII"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {// 车牌 STRING
			body.setTerminalID(new String(terminalID, "US-ASCII"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {// 终端ID BYTE[7]
			body.setTerminalVersion(new String(terminalVersion, "US-ASCII"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		// 车牌颜色 BYTE
		body.setColor(color);
		try {// 终端型号 BYTE[20]
			body.setLicensePlate(new String(licensePlate, "GBK"));
		} catch (UnsupportedEncodingException e) {
		}

		// // 打印log
		// log.debug("proviceID:" + body.getProvinceID() + "|cityID:" +
		// body.getCityID() + "|providerID:" + body.getProviderID() +
		// "|terminalVersion:"
		// + body.getTerminalVersion() + "|terminalID:" + body.getTerminalID() +
		// "|color:" + body.getColor() + "|license:"
		// + body.getLicensePlate());
		return new T808_Message<T808_MessageHeader, T808_0x0100>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0100> message) {
		//
		return null;
	}

}
