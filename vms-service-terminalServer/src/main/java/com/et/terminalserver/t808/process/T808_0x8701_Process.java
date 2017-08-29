package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8701;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8701_Process
 * @Description: 行驶记录仪参数下达命令协议解析类
 * @author: lijz
 * @date: 2014年6月1日 上午9:24:45
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8701_Process extends T808_Process<T808_MessageHeader, T808_0x8701> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8701> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8701> message) {
		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x87;
		head[1] = 0x01;

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

		/**
		 * 行驶记录仪参数下传 0x8701 指令参数: 1、 设置驾驶员代码、驾驶证号码；（0x81） 2、
		 * 设置记录仪中的车辆VIN号、车牌号码、分类；（0x82） 3、 设置记录仪时钟；（0xC2） 4、 设置车辆特征系数。（0xC3）
		 */

		// 根据各自的消息id 拼接消息体
		Map<String, String[]> map = ((T808_0x8701) message.getMessageBody()).getMapContent();

		// 返回此映射中包含的键的 Set 视图 获得map里面的key
		Set<String> getKey = map.keySet();

		// 创建ByteArrayOutputStream以及合成消息体
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// 消息体
		byte[] mes = null;
		byte[] result = null;
		int len = 0;// 求参数长度
		for (String key1 : getKey) {
			// 获得key 和 value 此时key是String类型的 把它转化为Integer类型的
			// 定义key为Integer的目的是便于做case判断
			int key = Integer.parseInt(key1);
			result = subProtocolData(key, map.get(key1));

			if (key == 1) {
				len = 22;
			} else if (key == 2) {
				len = 42;
			} else if (key == 3) {
				len = 7;
			} else if (key == 4) {
				len = 4;
			}

			try {
				baos.write(result);
			} catch (IOException e) {
			}
		}
		result = baos.toByteArray();

//		// 打印log
//		log.debug("messageID:0x8701|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|ParamsLength:");

		// 消息头 消息体长度:
		byte[] length = BytesUtil.int2bytes2(len);
		head[2] = length[0];
		head[3] = length[1];

		try {
			baos.reset();
			baos.write(0x00);
			baos.write(head);
			baos.write(result);
			baos.write(0x00);
			baos.write(0x00);
			byte check = T808_Util.check(baos.toByteArray());
			byte[] bosBytes = baos.toByteArray();
			bosBytes[bosBytes.length - 2] = check;
			mes = T808_Util.escapeData(bosBytes);
			mes[0] = 0x7e;
			mes[mes.length - 1] = 0x7e;
			baos.close();
		} catch (IOException e) {
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
			}
		}

		return mes;
	}

	private byte[] subProtocolData(int key, String[] params) {
		byte paramLength = 1;
		byte bCmdID = 0x00;
		byte[] result = null;

		if (key == 1) {
			bCmdID = (byte) 0x81;
			paramLength += 21;
			result = new byte[paramLength];

			// 设置命令字
			result[0] = bCmdID;

			// 驾驶员代码
			int iDriverCode = Integer.parseInt(params[1]);
			byte[] szDriverCode = T808_Util.integer2Bytes(iDriverCode, 3, false);
			result[1] = szDriverCode[0];
			result[2] = szDriverCode[1];
			result[3] = szDriverCode[2];

			// 驾驶证代码
			String strLicense = params[2];
			byte[] szLicense = BytesUtil.cutBytes(0, 18, strLicense.getBytes());
			result[4] = szLicense[0];
			result[5] = szLicense[1];
			result[6] = szLicense[2];
			result[7] = szLicense[3];
			result[8] = szLicense[4];
			result[9] = szLicense[5];
			result[10] = szLicense[6];
			result[11] = szLicense[7];
			result[12] = szLicense[8];
			result[13] = szLicense[9];
			result[14] = szLicense[10];
			result[15] = szLicense[11];
			result[16] = szLicense[12];
			result[17] = szLicense[13];
			result[18] = szLicense[14];
			result[19] = szLicense[15];
			result[20] = szLicense[16];
			result[21] = szLicense[17];

		} else if (key == 2) {
			// 2、 设置记录仪中的车辆VIN号、车牌号码、分类；（0x82）
			paramLength += 41;
			result = new byte[paramLength];

			// 设置行驶记录仪命令字
			bCmdID = (byte) 0x82;
			result[0] = bCmdID;

			// 设置记录仪中的车辆VIN号
			String strVIN = params[1];
			byte[] tempVIN = null;
			try {
				tempVIN = strVIN.getBytes("US-ASCII");
			} catch (UnsupportedEncodingException e) {
			}
			byte[] szVIN = BytesUtil.cutBytes(0, 17, tempVIN);

			result[1] = szVIN[0];
			result[2] = szVIN[1];
			result[3] = szVIN[2];
			result[4] = szVIN[3];
			result[5] = szVIN[4];
			result[6] = szVIN[5];
			result[7] = szVIN[6];
			result[8] = szVIN[7];
			result[9] = szVIN[8];
			result[10] = szVIN[9];
			result[11] = szVIN[10];
			result[12] = szVIN[11];
			result[13] = szVIN[12];
			result[14] = szVIN[13];
			result[15] = szVIN[14];
			result[16] = szVIN[15];
			result[17] = szVIN[16];

			// 设置车牌号码
			String strLicense = params[2];
			byte[] tempLicense = null;
			try {
				tempLicense = strLicense.getBytes("GBK");
			} catch (UnsupportedEncodingException e) {
			}
			byte[] szLicense = BytesUtil.cutBytes(0, 8, tempLicense);
			result[18] = szLicense[0];
			result[19] = szLicense[1];
			result[20] = szLicense[2];
			result[21] = szLicense[3];
			result[22] = szLicense[4];
			result[23] = szLicense[5];
			result[24] = szLicense[6];
			result[25] = szLicense[7];
			/*
			 * result[26] = szLicense[8]; result[27] = szLicense[9]; result[28]
			 * = szLicense[10]; result[29] = szLicense[11];
			 */

			// 设置分类
			String strType = params[3];
			byte[] tempType = null;
			try {
				tempType = strType.getBytes("GBK");
			} catch (UnsupportedEncodingException e) {
			}
			byte[] szType = BytesUtil.cutBytes(0, 8, tempType);
			result[30] = szType[0];
			result[31] = szType[1];
			result[32] = szType[2];
			result[33] = szType[3];
			result[34] = szType[4];
			result[35] = szType[5];
			result[36] = szType[6];
			result[37] = szType[7];
			/*
			 * result[38] = szType[8]; result[39] = szType[9]; result[40] =
			 * szType[10]; result[41] = szType[11];
			 */
		} else if (key == 3) {
			// 3、 设置记录仪时钟；（0xC2）
			bCmdID = (byte) 0xC2;
			paramLength += 6;
			result = new byte[paramLength];
			// 设置行驶记录仪命令字
			result[0] = bCmdID;

			// 设置记录仪时钟
			Date now = new Date();
			DateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			byte[] szTime = new byte[6];
			szTime = T808_Util.toBytesHex(df.format(now));
			result[1] = szTime[0];
			result[2] = szTime[1];
			result[3] = szTime[2];
			result[4] = szTime[3];
			result[5] = szTime[4];
			result[6] = szTime[5];

		} else if (key == 4) {
			// 4、 设置车辆特征系数。（0xC3）
			bCmdID = (byte) 0xC3;
			paramLength += 3;
			result = new byte[paramLength];

			// 设置行驶记录仪命令字
			result[0] = bCmdID;

			// 设置车辆特征系数
			int iValue = Integer.parseInt(params[1]);
			byte[] szValue = BytesUtil.int2bytes2(iValue);
			result[2] = szValue[0];
			result[3] = szValue[1];
		}
		return result;
	}
}
