package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0700;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0700_Process
 * @Description: 行驶记录数据上传协议解析类
 * @author: lijz
 * @date: 2014年5月27日 下午7:29:51
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */

/**
 * @author Administrator
 * 
 * @param <B>
 */
public class T808_0x0700_Process extends
		T808_Process<T808_MessageHeader, T808_0x0700> {
	// 初始化log4j
	// 本地临时缓存 目的从序列号---->存储命令字
	private static ConcurrentHashMap recorderTemporaryCache = new ConcurrentHashMap();

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0700> unpackData(byte[] data) {
		// 获取消息体
		T808_0x0700 body = new T808_0x0700();

		// T808_MessageHeader header = null;
		T808_MessageHeader header = T808_Util.getHeader(data);

		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		/**
		 * 考虑是否分包
		 */
		boolean subPackage = ((T808_MessageHeader) header).getSubpackage();

		String timeFormat = "yyyy-MM-dd HH:mm";
		byte cmdID = 0;
		byte[] cmdContent = null;
		if (subPackage) {// 分包的情况
			int packageNum = ((T808_MessageHeader) header).getPackageNum();
			String simNum = ((T808_MessageHeader) header).getSimNum();
			if (packageNum == 1) {// 第一个包的情况
				byte[] plateSerialNumbers = BytesUtil.getWord(bodyindex + 0,
						data);// 序列号
				int plateSerialNumber = BytesUtil
						.parseBytesToInt(plateSerialNumbers);
				body.setSerialNumber(plateSerialNumber);
				cmdID = data[bodyindex + 2];// 命令字
				recorderTemporaryCache.put(bodyindex + simNum, cmdID);
				cmdContent = BytesUtil.cutBytes(bodyindex + 3, data.length - 3
						- bodyindex, data);// 原始数据
				body.setOrginalData(cmdContent);
				body.setCmdID(cmdID);
			} else {// 不是第一个包的情况
				cmdID = (Byte) recorderTemporaryCache.get(simNum);
				cmdContent = BytesUtil.cutBytes(bodyindex + 0, data.length,
						data);
				body.setOrginalData(cmdContent);
				body.setCmdID(cmdID);
			}
		} else {// 不分包的情况
			byte[] plateSerialNumbers = BytesUtil.getWord(bodyindex + 0, data);// 序列号
			int plateSerialNumber = BytesUtil
					.parseBytesToInt(plateSerialNumbers);
			body.setSerialNumber(plateSerialNumber);
			cmdID = data[bodyindex + 2];// 命令字
			cmdContent = BytesUtil.cutBytes(bodyindex + 3, data.length - 3
					- bodyindex, data);// 原始数据
			body.setOrginalData(cmdContent);
			body.setCmdID(cmdID);
		}
		SimpleDateFormat sf = new SimpleDateFormat(timeFormat);
		String currentTime = sf.format(new Date());
		// 解析记录仪数据
		switch (cmdID) {
		case 0x01:// 1、 采集驾驶员代码及对应的机动车驾驶证号码
		{
			byte[] driverCode = BytesUtil.cutBytes(0, 3, cmdContent);// 驾驶员代码
			int iDriverCode = T808_Util.bytesToIntegerAccordNumber(driverCode,
					0, 2, false);

			byte[] licenseNumber = BytesUtil.cutBytes(3, 18, cmdContent);// 机动车驾驶证号码
			String strLicense = null;
			try {
				strLicense = new String(licenseNumber, "US-ASCII");
			} catch (UnsupportedEncodingException e) {
			}
			// body.setContent(iDriverCode + "#" + strLicense);
			body.setContent(currentTime + "#驾驶员代码：" + iDriverCode
					+ ";机动车驾驶证号码: " + strLicense);
		}
			break;

		case 0x02:// 2、 采集记录仪的实时时钟
		{
			byte[] time = BytesUtil.cutBytes(0, 6, cmdContent);
			String strTime = BytesUtil.bcdToStr(time);
			String realTime = toDate("20" + strTime);
			body.setContent(realTime);
		}
			break;

		case 0x03:// 3、 采集最近360h内的累计行驶里程数据
		{
			byte[] distance = BytesUtil.cutBytes(0, 3, cmdContent);
			float iDistance = (float) ((Integer.parseInt(BytesUtil
					.bcdToStr(distance))) / 0.1);// BytesUtil.bcdToStr估计有点问题，如果不合适，再修改一下
			byte[] time = BytesUtil.cutBytes(3, 5, cmdContent);
			String strTime = BytesUtil.bcdToStr(time);
			String accumulateTime = toDate("20" + strTime);
			body.setContent(accumulateTime + "#" + iDistance); // 一期代码为什么设置个20
		}
			break;
		case 0x04:// 4、 采集记录仪中的车辆特征系数
		{
			byte[] codes = BytesUtil.cutBytes(0, 3, cmdContent);
			int iCode = T808_Util
					.bytesToIntegerAccordNumber(codes, 0, 2, false);
			body.setContent(iCode + "");
		}
			break;
		case 0x05:// 5、 采集最近360h内的行驶速度数据
		{
			int iCount = cmdContent.length / 6;
			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < iCount; i++) {
				/*
				 * byte[] time = new byte[5]; System.arraycopy(cmdContent,
				 * i*6,time, 0, 5);
				 */
				byte[] time = BytesUtil.cutBytes(i * 6, 5, cmdContent);
				// String strTime = bcd2Str(time);
				String strTime = BytesUtil.BcdToStr(time);
				String driveTime = toDate("20" + strTime + "00");
				byte speed = cmdContent[i * 6 + 5];
				String strSpeed = BytesUtil.bcdToStr(speed);
				if (i != (iCount - 1)) {
					sb.append(driveTime + "#" + strSpeed + "--");
				} else {
					sb.append(driveTime + "#" + strSpeed);
				}

				// sb.append(currentTime + "#" + "20" + strTime + ";" + strSpeed
				// + "--");
			}
			body.setContent(sb.toString());
		}
			break;
		case 0x06:// 6、采集车辆VIN号、车辆号码、车牌分类
		{
			/*
			 * byte[] vin = new byte[17]; System.arraycopy(cmdContent, 0, vin,
			 * 0, 17);
			 */
			byte[] vin = BytesUtil.cutBytes(0, 17, cmdContent);
			String strVin = null;
			try {
				strVin = new String(vin, "US-ASCII").trim();
			} catch (UnsupportedEncodingException e) {
			}
			/*
			 * byte[] licenseplate = new byte[12]; System.arraycopy(cmdContent,
			 * 17, licenseplate, 0, 12);
			 */
			byte[] licenseplate = BytesUtil.cutBytes(17, 8, cmdContent);
			String strLicenseplate = null;
			try {
				strLicenseplate = new String(licenseplate, "GBK").trim();
			} catch (UnsupportedEncodingException e) {
			}
			/*
			 * byte[] licensetype = new byte[12]; System.arraycopy(cmdContent,
			 * 29, licensetype, 0, 12);
			 */
			byte[] licensetype = BytesUtil.cutBytes(29, 8, cmdContent);
			String strLicensetype = null;
			try {
				strLicensetype = new String(licensetype, "GBK").trim();
			} catch (UnsupportedEncodingException e) {
			}

			body.setContent(strVin + "#" + strLicenseplate + "#"
					+ strLicensetype);
		}
			break;

		case 0x07:// 7、 采集记录仪中事故疑点数据 本来上传应该10次，部标上传4次 模拟终端6次
		{
			byte[] time = BytesUtil.cutBytes(0, 6, cmdContent);
			String strTime = BytesUtil.bcdToStr(time);

			int i = 6;
			String speed = "";
			String strStatu = "";
			// while (i < cmdContent.length - 1) {
			while (i < 7) {
				speed = cmdContent[i] + ""; // 获取速度
				byte status = cmdContent[i + 1];
				String strStatus = "";
				// D7 D6 D5 D4 D3 D2 D1 D0
				// 刹车 紧急 车门 远光灯 喇叭 右转向灯 左转向灯 ACC
				if ((status & 0x01) > 0)
					strStatus += "ACC开;";
				if ((status & 0x02) > 0)
					strStatus += "左转向灯;";
				if ((status & 0x04) > 0)
					strStatus += "右转向灯;";
				if ((status & 0x08) > 0)
					strStatus += "喇叭;";
				if ((status & 0x10) > 0)
					strStatus += "远光灯;";
				if ((status & 0x20) > 0)
					strStatus += "车门开;";
				if ((status & 0x40) > 0)
					strStatus += "紧急;";
				if ((status & 0x80) > 0)
					strStatus += "刹车;";

				if (i == 6) {
					strStatu = strStatu + "速度:"
							+ speed.concat("; 开关量信号状态:").concat(strStatus);
				} else if (i == (cmdContent.length - 2)) {
					strStatu = strStatu
							+ "; 速度:"
							+ speed.concat("; 开关量信号状态:").concat(strStatus)
									.concat("--");
				} else {
					strStatu = strStatu + "; 速度:"
							+ speed.concat("; 开关量信号状态:").concat(strStatus);
				}
				i = i + 2;
			}
			String distrustTime = toDate("20" + strTime + "00");
			body.setContent(distrustTime + "#" + strStatu);
		}
			break;
		case 0x08:// 8、 采集最近2个日历天内的累计行驶里程
		{
			/*
			 * byte[] distance = new byte[3]; System.arraycopy(cmdContent, 0,
			 * distance, 0, 3); floatiDistance =
			 * (float)((Integer.parseInt(bcd2Str(distance)))/0.1);
			 */
			byte[] distance = BytesUtil.cutBytes(0, 3, cmdContent);
			float iDistance = (float) ((Integer.parseInt(BytesUtil
					.bcdToStr(distance))) / 0.1);
			/*
			 * byte[] time = new byte[5]; System.arraycopy(cmdContent, 3, time,
			 * 0,5); String strTime = bcd2Str(time);
			 */
			byte[] time = BytesUtil.cutBytes(3, 5, cmdContent);
			String strTime = BytesUtil.bcdToStr(time);
			String recentlyTime = toDate("20" + strTime + "00");
			body.setContent(recentlyTime + "#" + iDistance);
		}
			break;
		case 0x09:// 9、 采集最近2个日历天内的行驶速度数据
		{
			int iCount = cmdContent.length / 6;
			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < iCount; i++) {
				/*
				 * byte[] time = new byte[5]; System.arraycopy(cmdContent, i *
				 * 6, time, 0, 5);
				 */
				// String strTime = bcd2Str(time);
				byte[] time = BytesUtil.cutBytes(0, 5, cmdContent);
				String strTime = BytesUtil.bcdToStr(time);
				byte speed = cmdContent[i * 6 + 5];
				// String strSpeed =bcd2Str(speed);
				String strSpeed = BytesUtil.bcdToStr(speed);
				String driverTime = toDate("20" + strTime);
				sb.append(driverTime + "--" + strSpeed + "#");
			}
			body.setContent(sb.toString());
		}
			break;
		case 0x11:// 9、 采集最近2个日历天内的同一驾驶员连续驾驶时间超过3小时的所有记录数据
		{
			byte[] licenseNumber = BytesUtil.cutBytes(0, 14, cmdContent);// 机动车驾驶证号码
			String strLicense = null;
			try {
				strLicense = new String(licenseNumber, "US-ASCII");
			} catch (UnsupportedEncodingException e) {
			}
			int iCount = (cmdContent.length - 18) / 10;
			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < iCount; i++) {
				byte[] startTimes = BytesUtil.cutBytes(18 + i * 5, 5,
						cmdContent);
				String startTime = BytesUtil.bcdToStr(startTimes);
				byte[] endTimes = BytesUtil.cutBytes(23 + i * 5, 5, cmdContent);
				String endTime = BytesUtil.bcdToStr(endTimes);
				String beginTime = toDate("20" + startTime + "00");
				String overTime = toDate("20" + endTime + "00");
				// TODO 每条里面属性与属性之间用“-”分开 条与条之间用“--”分开
				sb.append("超时开始时间：" + beginTime + "-" + "超时结束时间：" + overTime);
			}
			body.setContent(currentTime + "#机动车驾驶证号码:" + strLicense + ";"
					+ sb.toString());
		}
			break;
		}
		return new T808_Message<T808_MessageHeader, T808_0x0700>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0700> message) {

		return null;
	}

	public static String toDate(String str) {
		if (str == null || str.equals("")) {
			return null;
		}
		String formatTime = null;
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddhhmmss");
		try {
			date = simpleDateFormat.parse(str);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			formatTime = sf.format(date);
		} catch (Exception e) {
			formatTime = new Date() + "行驶记录仪上传时间格式有异常,请注意查看  ... ... ";
			new Exception("行驶记录仪上传时间格式有异常,请注意查看  ... ... ");
		}
		return formatTime;
	}

	public static void main(String[] args) {
		String dateStr = "201410352212";
		String format = "yyyy-MM-dd hh:mm:ss";
		String format1 = "yyyyMMddhhmmss";
		String formatDate = toDate(dateStr);
		System.out.println(formatDate);
	}

}
