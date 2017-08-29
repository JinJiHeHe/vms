package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8602;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8602_Process
 * @Description: 设置矩形区域协议解析
 * @author: lijz
 * @date: 2014年4月30日 下午2:36:52
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8602_Process extends T808_Process<T808_MessageHeader, T808_0x8602> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8602> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8602> message) {

		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x86;
		head[1] = 0x02;

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

		int areaAttribute = ((T808_0x8602) message.getMessageBody()).getAreaAttribute();

		byte length = 24;
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
		byte setAttribute = BytesUtil.parseIntToByte(((T808_0x8602) message.getMessageBody()).getSetAttribute());
		body[0] = setAttribute;

		// byte areaTotality = BytesUtil.parseIntToByte(((T808_0x8600)
		// message.getMessageBody()).getAreaTotality());// 区域总数 // (总数)
		// body[1] = areaTotality;
		// 包区域数(当前数据包中区域个数)个数
		byte packageAreaNumber = BytesUtil.parseIntToByte(((T808_0x8602) message.getMessageBody()).getPackageAreaNumber());
		body[1] = packageAreaNumber;
		// 区域ID
		// (注意是大端问题)
		byte[] areaID = BytesUtil.int2bytes4(((T808_0x8602) message.getMessageBody()).getAreaID());
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

		// 左上点纬度
		byte[] upperLeftLon = BytesUtil.int2bytes4(((T808_0x8602) message.getMessageBody()).getUpperLeftLon());
		body[8] = upperLeftLon[3];
		body[9] = upperLeftLon[2];
		body[10] = upperLeftLon[1];
		body[11] = upperLeftLon[0];
		// 左上点经度
		byte[] upperLeftLat = BytesUtil.int2bytes4(((T808_0x8602) message.getMessageBody()).getUpperLeftLat());
		body[12] = upperLeftLat[3];
		body[13] = upperLeftLat[2];
		body[14] = upperLeftLat[1];
		body[15] = upperLeftLat[0];
		// 右下点纬度
		byte[] lowerRightLon = BytesUtil.int2bytes4(((T808_0x8602) message.getMessageBody()).getLowerRightLon());
		body[16] = lowerRightLon[3];
		body[17] = lowerRightLon[2];
		body[18] = lowerRightLon[1];
		body[19] = lowerRightLon[0];
		// 右下点经度
		byte[] lowerRightLat = BytesUtil.int2bytes4(((T808_0x8602) message.getMessageBody()).getLowerRightLat());
		body[20] = lowerRightLat[3];
		body[21] = lowerRightLat[2];
		body[22] = lowerRightLat[1];
		body[23] = lowerRightLat[0];

		if (length == 27) {//区域属性1位为1
			byte[] highestSpeed = BytesUtil.int2bytes2(((T808_0x8602) message.getMessageBody()).getHighesSpeed());// 最高速度
			body[24] = highestSpeed[0];
			body[25] = highestSpeed[1];

			byte overspeedContinueTime = BytesUtil.parseIntToByte(((T808_0x8602) message.getMessageBody()).getOverspeedContinueTime());// 超速持续时间
			body[26] = overspeedContinueTime;
		}
		if (length == 36) {//区域属性0位为0
			DateFormat dfold = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			// 起始时间
			Date startDate = null;
			try {
				startDate = dfold.parse(((T808_0x8602) message.getMessageBody()).getBeginTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// 结束时间
			Date endDate = null;
			try {
				endDate = dfold.parse(((T808_0x8602) message.getMessageBody()).getEndTime());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// // byte[] start = new byte[6];
			byte[] startTime = BytesUtil.strToBcd(df.format(startDate));
			body[24] = startTime[0];
			body[25] = startTime[1];
			body[26] = startTime[2];
			body[27] = startTime[3];
			body[28] = startTime[4];
			body[29] = startTime[5];

			byte[] endTime = BytesUtil.strToBcd(df.format(endDate));
			body[30] = endTime[0];
			body[31] = endTime[1];
			body[32] = endTime[2];
			body[33] = endTime[3];
			body[34] = endTime[4];
			body[35] = endTime[5];
		}
		if (length == 39) {//区域属性0位为1和区域属性1位为1
			DateFormat dfold = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			Date startDate = null;
			try {
				startDate = dfold.parse(((T808_0x8602) message.getMessageBody()).getBeginTime());// 起始时间
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Date endDate = null;
			try {
				endDate = dfold.parse(((T808_0x8602) message.getMessageBody()).getEndTime());// 结束时间
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			// // byte[] start = new byte[6];
			// 开始时间
			byte[] startTime = BytesUtil.strToBcd(df.format(startDate));
			body[24] = startTime[0];
			body[25] = startTime[1];
			body[26] = startTime[2];
			body[27] = startTime[3];
			body[28] = startTime[4];
			body[29] = startTime[5];

			// 结束时间
			byte[] endTime = BytesUtil.strToBcd(df.format(endDate));
			body[30] = endTime[0];
			body[31] = endTime[1];
			body[32] = endTime[2];
			body[33] = endTime[3];
			body[34] = endTime[4];
			body[35] = endTime[5];

			byte[] highestSpeed = BytesUtil.int2bytes2(((T808_0x8602) message.getMessageBody()).getHighesSpeed());// 最高速度
			body[36] = highestSpeed[0];
			body[37] = highestSpeed[1];

			byte overspeedContinueTime = BytesUtil.parseIntToByte(((T808_0x8602) message.getMessageBody()).getOverspeedContinueTime());// 超速持续时间
			body[38] = overspeedContinueTime;

		}


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
