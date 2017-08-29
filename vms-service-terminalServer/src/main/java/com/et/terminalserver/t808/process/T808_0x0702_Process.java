package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0702;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0702_Process
 * @Description: 驾驶员身份信息采集上报
 * @author: guanhl
 * @date: 2014年7月28日 下午3:32:57
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0702_Process extends T808_Process<T808_MessageHeader, T808_0x0702> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0702> unpackData(byte[] data) {
		// 获取消息体
		T808_0x0702 body = new T808_0x0702();
		
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_REQUEST);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		
		int index = bodyindex;
		byte status = BytesUtil.getByte(index, data);
		if (status < 3) {
			// byte driverCode = BytesUtil.getByte(index, data);
			index++;
			byte[] cardTimes = BytesUtil.cutBytes(index, 6, data);
			String cardTime = BytesUtil.BcdToStr(cardTimes);
			if (status == 1) {
				body.setICardTime(cardTime);
			} else {
				body.setECardTime(cardTime);
			}
			// TODO 明白为什么+7 而不是+6 因为那一位不知道表示的是什么
			index = index + 7;
		}
		// byte driverCode = BytesUtil.getByte(index, data);
		// index++;
		// byte[] cardTimes = BytesUtil.cutBytes(index, 6, data);
		// String cardTime = BytesUtil.BcdToStr(cardTimes);
		// TODO 明白为什么+7 而不是+6 因为那一位不知道表示的是什么
		// index = index + 7;
		// 驾驶员姓名长度
		byte driverNameLength = BytesUtil.getByte(index, data);
		body.setDriverNameLength(driverNameLength);
		index++;
		// 驾驶员姓名
		byte[] driverName = BytesUtil.cutBytes(index, driverNameLength, data);
		try {
			body.setDriverName(new String(driverName, "GBK"));
		} catch (UnsupportedEncodingException e) {
		}

		index += driverNameLength;
		byte[] driverIdCode = BytesUtil.cutBytes(index, 20, data);
		try {
			body.setDriverIdCode(new String(driverIdCode, "GBK"));
		} catch (UnsupportedEncodingException e) {
		}
		index += 20;
		// TODO 这个属性有点问题，目前传上来的数据不够，这个数据没有值，用个临时的替换

		byte[] jobCode = BytesUtil.cutBytes(index, 40, data);
		try {
			body.setQualificationCode(new String(jobCode, "GBK"));
		} catch (UnsupportedEncodingException e) {
		}
		index += 40;

		// try {// 驾驶员身份证编码
		// body.setQualificationCode(new String(driverIdCode, "GBK"));
		// } catch (UnsupportedEncodingException e) {
		// log.warn("", e);
		// }
		// 发证机构名称长度
		byte certificationOrgLength = BytesUtil.getByte(index, data);
		body.setCertificationOrgLength(certificationOrgLength);
		index++;
		// 发证机构名称
		byte[] orgName = BytesUtil
				.cutBytes(index, certificationOrgLength, data);
		try {
			body.setCertificationOrg(new String(orgName, "GBK"));
		} catch (UnsupportedEncodingException e) {
		}
		index += certificationOrgLength;
		if (status < 3) {
			byte[] certificateValids = BytesUtil.cutBytes(index, 4, data);
			String certificateValid = BytesUtil.BcdToStr(certificateValids);
			body.setValidDate(certificateValid);
		}

		// 设置时间
		Date time = new Date();
		body.setTime(time);
		// 打印log
		// log.debug(body.getMessageID() + body.getCertificationOrg()
		// + body.getDriverName());
		return new T808_Message<T808_MessageHeader, T808_0x0702>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0702> message) {

		return null;
	}

	public static void main(String[] args) {
		String msg = "01,14,07,28,16,16,12,00,04,D5,C5,C8,FD,30,30,30,30,30,31,00,00,00,00,00,00,00,00,00,00,00,00,00,00,06,30,30,30,30,30,31,20,20,01,01";
		System.out.println(msg.split(",").length);
		String name = "D5,C5,C8,FD";
		String[] bytes = name.split(",");
		byte[] arr = new byte[] { (byte) 213, (byte) 197, (byte) 200,
				(byte) 253 };
		try {
			String names = new String(arr, "GBK");
			System.out.println(names);
		} catch (UnsupportedEncodingException e) {
		}
	}

}
