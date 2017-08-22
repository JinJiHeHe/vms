package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8600;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8600_Process
 * @Description: 设置圆形区域协议解析
 * @author: lijz
 * @date: 2014年4月16日 下午7:33:27
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8600_Process extends T808_Process<T808_MessageHeader, T808_0x8600> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8600> unpackData(byte[] data) {
		return null;
	}

	/**
	 * @Description:打包消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x8600> message) {
		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x86;
		head[1] = 0x00;

		// 终端手机号
		byte[] phone = BytesUtil.strToBcd(((T808_MessageHeader) message.getMessageHeader()).getSimNum());
		head[4] = phone[0];
		head[5] = phone[1];
		head[6] = phone[2];
		head[7] = phone[3];
		head[8] = phone[4];
		head[9] = phone[5];

		// 消息流水号
		byte[] seiralnum = BytesUtil.int2bytes2(((T808_MessageHeader) message.getMessageHeader()).getRunningNum());
		head[10] = seiralnum[0];
		head[11] = seiralnum[1];

		// 区域属性(本项目实现的功能是单个圆)
		int areaAttribute = ((T808_0x8600) message.getMessageBody()).getAreaAttribute();

		byte length = 20;
		if ((areaAttribute & 0x0001) > 0) {// 根据时间
			length += 12;
		}
		if ((areaAttribute & 0x0002) > 0) {// 限速
			length += 3;
		}
		if ((areaAttribute & 0x0003) > 0) {// 进区域报警给驾驶员
			length += 0;
		}
		if ((areaAttribute & 0x0004) > 0) {// 进区域报警给平台
			length += 0;
		}
		if ((areaAttribute & 0x0005) > 0) {// 出区域报警给驾驶员
			length += 0;
		}
		if ((areaAttribute & 0x0006) > 0) {// 出区域报警给平台
			length += 0;
		}
		if ((areaAttribute & 0x0007) > 0) {// 南纬
			length += 0;
		}
		if ((areaAttribute & 0x0002) > 0) {// 西经
			length += 0;
		}

		// 消息体
		byte[] body = new byte[length];
		// 操作,总数,区域ID;区域属性;中心点纬度;中心点经度;半径;起始时间;结束时间;最高速度;超速持续时间
		// 设置属性
		byte setAttribute = BytesUtil.parseIntToByte(((T808_0x8600) message.getMessageBody()).getSetAttribute());// 设置属性
		body[0] = setAttribute;

		// byte areaTotality = BytesUtil.parseIntToByte(((T808_0x8600)
		// message.getMessageBody()).getAreaTotality());// 区域总数 // (总数)
		// body[1] = areaTotality;

		// 区域总数
		byte packageAreaNumber = BytesUtil.parseIntToByte(((T808_0x8600) message.getMessageBody()).getPackageAreaNumber());// 包区域数(当前数据包中区域个数)个数
		body[1] = packageAreaNumber;

		// 区域ID
		byte[] areaID = BytesUtil.int2bytes4(((T808_0x8600) message.getMessageBody()).getAreaID());
		body[2] = areaID[3];
		body[3] = areaID[2];
		body[4] = areaID[1];
		body[5] = areaID[0];

		// int areaAttribute = ((T808_0x8600)
		// message.getMessageBody()).getAreaAttribute();
		// 区域属性
		byte[] areaAttributes = BytesUtil.int2bytes2(areaAttribute);
		body[6] = areaAttributes[0];
		body[7] = areaAttributes[1];
		// 中心点纬度
		byte[] centerLat = BytesUtil.int2bytes4(((T808_0x8600) message.getMessageBody()).getCenterLat());
		body[8] = centerLat[3];
		body[9] = centerLat[2];
		body[10] = centerLat[1];
		body[11] = centerLat[0];
		// 中心点经度
		byte[] centerLon = BytesUtil.int2bytes4(((T808_0x8600) message.getMessageBody()).getCenterLon());
		body[12] = centerLon[3];
		body[13] = centerLon[2];
		body[14] = centerLon[1];
		body[15] = centerLon[0];
		// 半径
		byte[] radius = BytesUtil.int2bytes4(((T808_0x8600) message.getMessageBody()).getRadius());
		body[16] = radius[3];
		body[17] = radius[2];
		body[18] = radius[1];
		body[19] = radius[0];

		if (length == 23) {//区域属性1位为1
			// 最高速度
			byte[] highestSpeed = BytesUtil.int2bytes2(((T808_0x8600) message.getMessageBody()).getHighestSpeed());
			body[20] = highestSpeed[0];
			body[21] = highestSpeed[1];
			// 超速持续时间
			byte overspeedContinueTime = BytesUtil.parseIntToByte(((T808_0x8600) message.getMessageBody()).getOverspeedContinueTime());
			body[22] = overspeedContinueTime;
		}
		if (length == 32) {//区域属性0位为1
			// 起始时间
			DateFormat dfold = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			Date startDate = null;
			try {
				startDate = dfold.parse(((T808_0x8600) message.getMessageBody()).getBeginTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// 结束时间
			Date endDate = null;
			try {
				endDate = dfold.parse(((T808_0x8600) message.getMessageBody()).getEndTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// // byte[] start = new byte[6];
			// 开始时间
			byte[] startTime = BytesUtil.strToBcd(df.format(startDate));
			body[20] = startTime[0];
			body[21] = startTime[1];
			body[22] = startTime[2];
			body[23] = startTime[3];
			body[24] = startTime[4];
			body[25] = startTime[5];

			// 结束时间
			byte[] endTime = BytesUtil.strToBcd(df.format(endDate));
			body[26] = endTime[0];
			body[27] = endTime[1];
			body[28] = endTime[2];
			body[29] = endTime[3];
			body[30] = endTime[4];
			body[31] = endTime[5];
		}
		if (length == 35) {//区域属性0位为1和区域属性1位为1
			// 最高速度
			byte[] highestSpeed = BytesUtil.int2bytes2(((T808_0x8600) message.getMessageBody()).getHighestSpeed());
			body[32] = highestSpeed[0];
			body[33] = highestSpeed[1];
			// 超速持续时间
			byte overspeedContinueTime = BytesUtil.parseIntToByte(((T808_0x8600) message.getMessageBody()).getOverspeedContinueTime());
			body[34] = overspeedContinueTime;

			DateFormat dfold = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			// 起始时间
			Date startDate = null;
			try {
				startDate = dfold.parse(((T808_0x8600) message.getMessageBody()).getBeginTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// 结束时间
			Date endDate = null;
			try {
				endDate = dfold.parse(((T808_0x8600) message.getMessageBody()).getEndTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// // byte[] start = new byte[6];
			// 开始时间
			byte[] startTime = BytesUtil.strToBcd(df.format(startDate));
			body[20] = startTime[0];
			body[21] = startTime[1];
			body[22] = startTime[2];
			body[23] = startTime[3];
			body[24] = startTime[4];
			body[25] = startTime[5];

			// 结束时间
			byte[] endTime = BytesUtil.strToBcd(df.format(endDate));
			body[26] = endTime[0];
			body[27] = endTime[1];
			body[28] = endTime[2];
			body[29] = endTime[3];
			body[30] = endTime[4];
			body[31] = endTime[5];

		}

		// 打印log
//		log.debug("messageID:0x8600|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|SetAttribute:"
//				+ ((T808_0x8600) message.getMessageBody()).getSetAttribute() + "|AreaTotality:"
//				+ ((T808_0x8600) message.getMessageBody()).getAreaTotality() + "|PackageAreaNumber:"
//				+ ((T808_0x8600) message.getMessageBody()).getPackageAreaNumber() + "|AreaID:" + ((T808_0x8600) message.getMessageBody()).getAreaID()
//				+ "|AreaAttribute:" + ((T808_0x8600) message.getMessageBody()).getAreaAttribute() + "|CenterLat:"
//				+ ((T808_0x8600) message.getMessageBody()).getCenterLat() + "|CenterLot:" + ((T808_0x8600) message.getMessageBody()).getCenterLon()
//				+ "|Radius:" + ((T808_0x8600) message.getMessageBody()).getRadius() + "|BeginTime:"
//				+ ((T808_0x8600) message.getMessageBody()).getBeginTime() + "|EndTime:" + ((T808_0x8600) message.getMessageBody()).getEndTime()
//				+ "|Hightest:" + ((T808_0x8600) message.getMessageBody()).getHighestSpeed() + "|OverspeedContinueTime:"
//				+ ((T808_0x8600) message.getMessageBody()).getOverspeedContinueTime());

		// byte[] bytes = new byte[] { 0x01, 0x01, 0x00, 0x00, 0x00, 0x02, 0x00,
		// 0x28, 0x02, 0x60, (byte) 0xED, (byte) 0x93, 0x06, (byte) 0xF1,
		// (byte) 0x86, (byte) 0xCE, 0x00, 0x00, 0x00, 0x14 };
		// 消息头
		byte[] lengths = BytesUtil.int2bytes2(length);
		head[2] = lengths[0];
		head[3] = lengths[1];

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		try {
			bos.write(0x00);
			bos.write(head);
			bos.write(body);
			// bos.write(bytes);
			// bos.write(msg.getBytes());
			bos.write(0x00);
			bos.write(0x00);
			byte check = T808_Util.check(bos.toByteArray());
			byte[] bosBytes = bos.toByteArray();
			bosBytes[bosBytes.length - 2] = check;
			mes = T808_Util.escapeData(bosBytes);
			mes[0] = 0x7e;
			mes[mes.length - 1] = 0x7e;
		} catch (IOException e) {
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
				}
			}
		}

		// 打印log
		return mes;
	}

}
