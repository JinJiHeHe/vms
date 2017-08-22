package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8606;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8606_Process
 * @Description: 设置路线
 * @author: lijz
 * @date: 2014年8月6日 下午9:26:44
 * @company: Beijing Huayou Information andCommunication Technology Co.,0xLtd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8606_Process extends T808_Process<T808_MessageHeader, T808_0x8606> {
	// 初始化log4j
	private static T808_0x8606 t8606 = new T808_0x8606();// 临时使用

	@Override
	public Message<T808_MessageHeader, T808_0x8606> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8606> message) {

		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x86;
		head[1] = 0x06;

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

		int lineAttribute = ((T808_0x8606) message.getMessageBody()).getLineAttribute();

		int length = 8;
		if ((lineAttribute & 0x0001) > 0) {// 根据时间
			length += 12;
		}
		if ((lineAttribute & 0x0003) > 0) {// 进路线报警给驾驶员
			length += 0;
		}
		if ((lineAttribute & 0x0004) > 0) {// 进路线报警给平台
			length += 0;
		}
		if ((lineAttribute & 0x0005) > 0) {// 出路线报警给驾驶员
			length += 0;
		}
		if ((lineAttribute & 0x0006) > 0) {// 出路线报警给平台
			length += 0;
		}

		// 消息体
		byte[] body = new byte[length];
		byte[] lineID = BytesUtil.int2bytes4(((T808_0x8606) message.getMessageBody()).getLineID());// 路线ID
		body[0] = lineID[3];
		body[1] = lineID[2];
		body[2] = lineID[1];
		body[3] = lineID[0];

		byte[] lineAttributes = BytesUtil.int2bytes2(lineAttribute);// 路线属性
		body[4] = lineAttributes[0];
		body[5] = lineAttributes[1];
		if (length == 20) {// 格式化时间
			DateFormat dfold = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			Date startDate = null;
			try {
				startDate = dfold.parse(((T808_0x8606) message.getMessageBody()).getBeginTime());// 起始时间
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Date endDate = null;
			try {
				endDate = dfold.parse(((T808_0x8606) message.getMessageBody()).getEndTime());// 结束时间
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

		byte[] lineInflexionCount = BytesUtil.int2bytes2(((T808_0x8606) message.getMessageBody()).getLineInflexionCount());// 路线总拐点数
		body[length - 2] = lineInflexionCount[0];
		body[length - 1] = lineInflexionCount[1];

		// byte packageInflexionCount = BytesUtil
		// .parseIntToByte(((T808_0x8606) message.getMessageBody())
		// .getPackageInflexionCount());// 包拐点数
		// body[length - 1] = packageInflexionCount;

		byte[] mes = null;
		byte[] result = null;

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		List<String> list = ((T808_0x8606) message.getMessageBody()).getInflexionListItems();
		// int counts = list.size();
		// int lengths = counts / packageInflexionCount;
		for (int i = 0; i < list.size(); i++) {
			String[] inflexionItems = list.get(i).split(",");
			result = inflexionListItems(inflexionItems);
			try {
				baos.write(result);
			} catch (IOException e) {
			}
		}
		result = baos.toByteArray();

		// 打印log
//		log.debug("messageID:0x8606|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|LineID:"
//				+ ((T808_0x8606) message.getMessageBody()).getLineID() + "|LineAttribute:"
//				+ ((T808_0x8606) message.getMessageBody()).getLineAttribute() + "|BeginTime:"
//				+ ((T808_0x8606) message.getMessageBody()).getBeginTime() + "|EndTime:" + ((T808_0x8606) message.getMessageBody()).getEndTime()
//				+ "|LineInflexionCount:" + ((T808_0x8606) message.getMessageBody()).getLineInflexionCount() + "|PackageInflexionCount:"
//				+ ((T808_0x8606) message.getMessageBody()).getPackageInflexionCount());

		byte[] bytes = { 0x00, 0x00, 0x00, 0x02, 0x00, 0x3D, 0x14, 0x09, 0x03, 0x00, 0x00, 0x00, 0x14, 0x09, 0x03, 0x18, 0x36, 0x46, 0x00, 0x03,
				0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x01, 0x02, 0x61, (byte) 0xFA, 0x27, 0x06, (byte) 0xF0, (byte) 0x93, 0x17, 0x64, 0x02,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x78, 0x0A, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00, 0x02, 0x02, 0x62, 0x20, 0x21, 0x06, (byte) 0xF0,
				(byte) 0xB2, (byte) 0x8E, 0x50, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x50, 0x0A, 0x00, 0x00, 0x00, 0x03, 0x00, 0x00, 0x00, 0x03, 0x02,
				0x62, 0x09, 0x77, 0x06, (byte) 0xF0, (byte) 0xDD, (byte) 0xAB, 0x5A, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x5A, 0x0A, (byte) 0xFC,
				0x00, 0x00 };
		// int len = bytes.length;
		// byte[] lengths = BytesUtil.int2bytes2(bytes.length);
		// head[2] = lengths[0];
		// head[3] = lengths[1];

		// 消息头长度和消息头
		length += result.length;
		byte[] lengths = BytesUtil.int2bytes2(length);
		head[2] = lengths[0];
		head[3] = lengths[1];

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		// byte[] mes = null;
		try {
			bos.write(0x00);
			bos.write(head);
			bos.write(body);
			bos.write(result);
			// bos.write(bytes);
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
	 * @Description:此方法进行解析线拐点项数据
	 * @param :String[] inflexionItems代表“拐点项数据”数据集合
	 * @return:“拐点项数据”数据集合拼成的字节
	 * @throws Exception
	 */
	protected static byte[] inflexionListItems(String[] inflexionItems) {
		int length = 18;

		// 路段属性
		byte roadAttribute = BytesUtil.parseIntToByte(Integer.parseInt(inflexionItems[5]));
		// 行驶时间
		if ((roadAttribute & 0x0001) > 0) {
			length += 4;
		}
		// 限速
		if ((roadAttribute & 0x0002) > 0) {
			length += 3;
		}

		byte[] result = new byte[length];

		// 拐点ID
		byte[] inflexionID = BytesUtil.int2bytes4(Integer.parseInt(inflexionItems[0]));
		result[0] = inflexionID[3];
		result[1] = inflexionID[2];
		result[2] = inflexionID[1];
		result[3] = inflexionID[0];
		// 路段ID
		byte[] roadID = BytesUtil.int2bytes4(Integer.parseInt(inflexionItems[1]));
		result[4] = roadID[3];
		result[5] = roadID[2];
		result[6] = roadID[1];
		result[7] = roadID[0];

		// 拐点纬度
		byte[] inflexionLat = BytesUtil.int2bytes4(Integer.parseInt(inflexionItems[2]));
		result[8] = inflexionLat[3];
		result[9] = inflexionLat[2];
		result[10] = inflexionLat[1];
		result[11] = inflexionLat[0];

		// 拐点经度
		byte[] inflexionLon = BytesUtil.int2bytes4(Integer.parseInt(inflexionItems[3]));
		result[12] = inflexionLon[3];
		result[13] = inflexionLon[2];
		result[14] = inflexionLon[1];
		result[15] = inflexionLon[0];

		// 拐点宽度
		byte roadWeight = BytesUtil.parseIntToByte(Integer.parseInt(inflexionItems[4]));
		result[16] = roadWeight;

		// 路段属性
		result[17] = roadAttribute;

		if (length == 22) {
			// 路段行驶过长阈值
			byte[] roadRunningTimeOverlong = BytesUtil.int2bytes2(Integer.parseInt(inflexionItems[6]));
			result[18] = roadRunningTimeOverlong[0];
			result[19] = roadRunningTimeOverlong[1];
			// 路段行驶不足阈值
			byte[] roadRunningTimeShortof = BytesUtil.int2bytes2(Integer.parseInt(inflexionItems[7]));
			result[20] = roadRunningTimeShortof[0];
			result[21] = roadRunningTimeShortof[1];
		}
		if (length == 23) {
			// 路段最高速度
			byte[] roadHighestSpeed = BytesUtil.int2bytes2(Integer.parseInt(inflexionItems[6]));
			result[18] = roadHighestSpeed[0];
			result[19] = roadHighestSpeed[1];
			// 路段超速持续时间
			byte roadOverSpeedContinueTime = BytesUtil.parseIntToByte(Integer.parseInt(inflexionItems[7]));
			result[20] = roadOverSpeedContinueTime;
			// 路段行驶不足阈值
			byte[] roadRunningTimeShortof = BytesUtil.int2bytes2(Integer.parseInt(inflexionItems[8]));
			result[21] = roadRunningTimeShortof[0];
			result[22] = roadRunningTimeShortof[1];
		}
		if (length == 25) {
			// 路段行驶时长
			byte[] roadRunningTime = BytesUtil.int2bytes2(Integer.parseInt(inflexionItems[6]));
			result[18] = roadRunningTime[0];
			result[19] = roadRunningTime[1];
			// 路段最高速度
			byte[] roadHighestSpeed = BytesUtil.int2bytes2(Integer.parseInt(inflexionItems[7]));
			result[20] = roadHighestSpeed[0];
			result[21] = roadHighestSpeed[1];
			// 路段超速持续时间
			byte roadOverSpeedContinueTime = BytesUtil.parseIntToByte(Integer.parseInt(inflexionItems[8]));
			result[22] = roadOverSpeedContinueTime;
			// 路段行驶不足阈值
			byte[] roadRunningTimeShortof = BytesUtil.int2bytes2(Integer.parseInt(inflexionItems[9]));
			result[23] = roadRunningTimeShortof[0];
			result[24] = roadRunningTimeShortof[1];
		}

		return result;
	}
}
