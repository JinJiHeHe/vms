package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8604;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8604_Process
 * @Description: 设置多边形区域
 * @author: lijz
 * @date: 2014年8月6日 下午9:27:35
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8604_Process extends T808_Process<T808_MessageHeader, T808_0x8604> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8604> unpackData(byte[] data) {
		//
		return null;
	}

	/**
	 * @Description:打包消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x8604> message) {
		// 获取消息体
		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x86;
		head[1] = 0x04;

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

		int areaAttribute = ((T808_0x8604) message.getMessageBody()).getAreaAttribute();

		int length = 8;
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

		byte[] areaID = BytesUtil.int2bytes4(((T808_0x8604) message.getMessageBody()).getAreaID());// 区域ID
		body[0] = areaID[3];
		body[1] = areaID[2];
		body[2] = areaID[1];
		body[3] = areaID[0];

		byte[] areaAttributes = BytesUtil.int2bytes2(((T808_0x8604) message.getMessageBody()).getAreaAttribute());// 区域属性
		body[4] = areaAttributes[0];
		body[5] = areaAttributes[1];

		if (length == 11) {
			byte[] highestSpeed = BytesUtil.int2bytes2(((T808_0x8604) message.getMessageBody()).getHighestSpeed());// 最高速度
			body[6] = highestSpeed[0];
			body[7] = highestSpeed[1];

			byte overspeedContinueTime = BytesUtil.parseIntToByte(((T808_0x8604) message.getMessageBody()).getOverspeedContinueTime());// 超速持续时间
			body[8] = overspeedContinueTime;
		}
		if (length == 20) {
			DateFormat dfold = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			Date startDate = null;
			try {
				startDate = dfold.parse(((T808_0x8604) message.getMessageBody()).getBeginTime());// 起始时间
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Date endDate = null;
			try {
				endDate = dfold.parse(((T808_0x8604) message.getMessageBody()).getEndTime());// 结束时间
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// // byte[] start = new byte[6];
			byte[] startTime = BytesUtil.strToBcd(df.format(startDate));
			body[6] = startTime[0];
			body[7] = startTime[1];
			body[8] = startTime[2];
			body[9] = startTime[3];
			body[10] = startTime[4];
			body[11] = startTime[5];

			byte[] endTime = BytesUtil.strToBcd(df.format(endDate));
			body[12] = endTime[0];
			body[13] = endTime[1];
			body[14] = endTime[2];
			body[15] = endTime[3];
			body[16] = endTime[4];
			body[17] = endTime[5];
		}
		if (length == 23) {
			DateFormat dfold = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			Date startDate = null;
			try {
				startDate = dfold.parse(((T808_0x8604) message.getMessageBody()).getBeginTime());// 起始时间
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Date endDate = null;
			try {
				endDate = dfold.parse(((T808_0x8604) message.getMessageBody()).getEndTime());// 结束时间
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// // byte[] start = new byte[6];
			byte[] startTime = BytesUtil.strToBcd(df.format(startDate));
			body[6] = startTime[0];
			body[7] = startTime[1];
			body[8] = startTime[2];
			body[9] = startTime[3];
			body[10] = startTime[4];
			body[11] = startTime[5];

			byte[] endTime = BytesUtil.strToBcd(df.format(endDate));
			body[12] = endTime[0];
			body[13] = endTime[1];
			body[14] = endTime[2];
			body[15] = endTime[3];
			body[16] = endTime[4];
			body[17] = endTime[5];

			byte[] highestSpeed = BytesUtil.int2bytes2(((T808_0x8604) message.getMessageBody()).getHighestSpeed());// 最高速度
			body[18] = highestSpeed[0];
			body[19] = highestSpeed[1];
			// 超速持续时间
			byte overspeedContinueTime = BytesUtil.parseIntToByte(((T808_0x8604) message.getMessageBody()).getOverspeedContinueTime());
			body[20] = overspeedContinueTime;

		}
		// 区域总定点数
		byte[] areaPointsCount = BytesUtil.int2bytes2(((T808_0x8604) message.getMessageBody()).getAreaPointsCount());
		body[length - 2] = areaPointsCount[0];
		body[length - 1] = areaPointsCount[1];

		// byte packageVertexNumber = BytesUtil.parseIntToByte(((T808_0x8604)
		// message.getMessageBody()).getPackageVertexNumber());// 包顶点数
		// body[8] = packageVertexNumber;

		// 根据各自的消息id 拼接消息体
		Map<Integer, Integer> map = ((T808_0x8604) message.getMessageBody()).getVertexMap();

		// 返回此映射中包含的键的 Set 视图 获得map里面的key
		Set<Integer> getKey = map.keySet();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		byte[] result = null;

		for (Integer key : getKey) {
			// 获得key 和 value 此时key是String类型的 把它转化为Integer类型的
			// 定义key为Integer的目的是便于做case判断
			result = vertexLatLonMap(key, map.get(key));

			try {
				baos.write(result);
			} catch (IOException e) {
			}
		}

		result = baos.toByteArray();

//		log.debug("messageID:0x8604|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|AreaID:"
//				+ ((T808_0x8604) message.getMessageBody()).getAreaID() + "|AreaAttribute:"
//				+ ((T808_0x8604) message.getMessageBody()).getAreaAttribute() + "|BeginTime:"
//				+ ((T808_0x8604) message.getMessageBody()).getBeginTime() + "|EndTime:" + ((T808_0x8604) message.getMessageBody()).getEndTime()
//				+ "|HighestSpeed:" + ((T808_0x8604) message.getMessageBody()).getHighestSpeed() + "|OverspeedContinueTime:"
//				+ ((T808_0x8604) message.getMessageBody()).getOverspeedContinueTime() + "|AreaPointsCount:"
//				+ ((T808_0x8604) message.getMessageBody()).getAreaPointsCount());

		// byte[] bytes = { 0x00, 0x00, 0x00, 0x02, 0x00, 0x28, 0x00, 0x03,
		// 0x02, 0x61, (byte) 0xA2, (byte) 0xD3, 0x06, (byte) 0xEE, 0x23, (byte)
		// 0xF5, 0x02, 0x61, (byte) 0x85, (byte) 0xE0,
		// 0x06, (byte) 0xEE, 0x1E, (byte) 0xEC, 0x02, 0x61, (byte) 0x89, 0x7E,
		// 0x06, (byte) 0xEE, 0x66, (byte) 0xAB };

		// 消息头
		length = length + result.length;
		byte[] lengths = BytesUtil.int2bytes2(length);
		head[2] = lengths[0];
		head[3] = lengths[1];

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		// byte[] mes = null;
		try {
			bos.write(0x00);
			bos.write(head);
			// bos.write(bytes);
			bos.write(body);
			bos.write(result);
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

		return mes;
	}

	/**
	 * @Description:此方法进行解析key和value
	 * @param :id key params values
	 * @return
	 * @throws Exception
	 */
	private byte[] vertexLatLonMap(int vertexLon, Integer vertexLat) {

		byte[] result = new byte[8];
		byte[] vertexLons = BytesUtil.int2bytes4(vertexLon);
		result[0] = vertexLons[3];
		result[1] = vertexLons[2];
		result[2] = vertexLons[1];
		result[3] = vertexLons[0];

		byte[] vertexLats = BytesUtil.int2bytes4(vertexLat);
		result[4] = vertexLats[3];
		result[5] = vertexLats[2];
		result[6] = vertexLats[1];
		result[7] = vertexLats[0];

		return result;
	}

}
