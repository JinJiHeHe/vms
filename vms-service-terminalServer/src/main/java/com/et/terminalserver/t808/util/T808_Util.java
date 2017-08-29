package com.et.terminalserver.t808.util;

import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: CNPC_VMS
 * @Title: T808_Util
 * @Description: 部标808工具类
 * @author: lijz
 * @date: 2014年8月6日 下午9:34:39
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_Util {
	// 初始化log4j
	private final static String HEX_NAME_L4 = "T808_0x";// 拼接消息头
	private final static String HEX_NAME_L3 = "T808_0x0";// 拼接消息头
	private final static String HEX_NAME_L2 = "T808_0x00";// 拼接消息头
	private final static String HEX_NAME_L1 = "T808_0x000";// 拼接消息头

	/**
	 * 转义还原
	 * 
	 * @param data
	 * @return
	 * @throws ProtocolEscapeExeption
	 * @throws IOException
	 */
	public static byte[] reverseEscapeData(byte[] data) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] reverseEscapedDatabytes;
		for (int i = 0; i < (data.length - 1); i++) {
			// 判断消息尾/头 0x7d --> 0x7e
			if (data[i] == 0x7d && data[i + 1] == 0x02) {
				// 转义
				bos.write((byte) 0x7e);
				i++;
			} else if (data[i] == 0x7d && data[i + 1] == 0x01) {
				// 转义
				bos.write((byte) 0x7d);
				i++;
			} else if ((data[i] == 0x7d && data[i + 1] != 0x02)
					|| (data[i] == 0x7d && data[i + 1] != 0x01)) {
				reverseEscapedDatabytes = null;
				try {
					// 关闭数据流
					bos.close();
				} catch (IOException e) {
				}

				// 抛出异常
			} else {
				bos.write(data[i]);
			}
		}
		// 如果数据倒数第二位不是数据位
		if (data[data.length - 2] != 0x7d) {
			if (data[data.length - 1] != 0x7d) {
				bos.write(data[data.length - 1]);
			} else {
				reverseEscapedDatabytes = null;
				try {
					// 关闭数据流
					bos.close();
				} catch (IOException e) {
				}
				// 抛出异常
			}
		} else {
			// 倒数第二位等于125 则最后一位是转义位，不需要写入转以后的数据中
		}
		reverseEscapedDatabytes = bos.toByteArray();
		try {
			// 关闭数据流
			bos.close();
		} catch (IOException e) {
		}
		return reverseEscapedDatabytes;
	}

	/**
	 * @Description:此方法的作用是处理消息头、消息体和校验码里面的常规的0xXX和不常规的0x7d、0x7e的处理
	 * @param :data 每一个data都表示一个8位的字节数组
	 * @return
	 * @throws Exception
	 */
	public static byte[] escapeData(byte[] data) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] escapedDatabytes;
		for (int i = 0; i < data.length; i++) {
			// 判断数据头
			if (data[i] == 0x7e) {
				// 转义
				bos.write((byte) 0x7d);
				bos.write((byte) 0x02);
			} else if (data[i] == 0x7d) {
				// 转义
				bos.write((byte) 0x7d);
				bos.write((byte) 0x01);
			} else {
				// 写入数据流
				bos.write(data[i]);
			}
		}
		// 获取byte数组
		escapedDatabytes = bos.toByteArray();
		try {
			// 关闭数据流
			bos.close();
		} catch (IOException e) {
		}
		// 返回byte数组
		return escapedDatabytes;
	}

	/**
	 * @Description:此方法的作用是获取校验码
	 * @param :data 每一个data都表示一个8位的字节数组
	 * @return
	 * @throws Exception
	 */
	public static byte check(byte[] data) {
		// 计算校验码
		byte checked = (byte) (data[0] ^ data[1]);
		for (int i = 2; i < (data.length - 2); i++) {
			checked = (byte) (checked ^ data[i]);
		}
		return checked;
	}

	/**
	 * @Description:获取MessageID
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public static int getMessageID(byte[] data) {

		// 获取消息id字节段
		byte[] messageIDBytes = BytesUtil.getWord(1, data);
		// 解析消息id
		return BytesUtil.parseBytesToInt(messageIDBytes);
	}

	/**
	 * @Description:获取消息长度
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public static int getMessageLength(byte[] data) {
		// 获取消息头
		// 获取消息体信息字节段
		byte[] messageInfoBytes = BytesUtil.getBigWord(3, data);
		// 解析消息体长度
		int bodyLength = BytesUtil.getBitsValue(0, 9, messageInfoBytes);
		// 解析是否分包
		// boolean subpackage = BytesUtil.getBooleanValue(1, 5,
		// messageInfoBytes);
		boolean subpackage = BytesUtil.getBooleanValue(1, 5, messageInfoBytes);
		if (subpackage) {// 分包
			return 14 + bodyLength + 3;
		} else {// 不分包
			return 12 + bodyLength + 3;
		}
	}

	public static void main(String[] args) {
		byte[] data = BytesUtil
				.toStringHex("7e0200002e01599940325200ce000000050000180301cb998e068251210322029e001e15042411362601040001e848020200640302029e04020004fc7e");
		T808_MessageHeader h = T808_Util.getHeader(data);
		System.out.println(h);
	}

	/**
	 * @Description:获取消息头
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public static T808_MessageHeader getHeader(byte[] data) {

		T808_MessageHeader header = new T808_MessageHeader();
		// 获取消息头
		byte[] headBytes = BytesUtil.cutBytes(1, 12, data);
		// 获取消息id字节段
		byte[] messageIDBytes = BytesUtil.getWord(0, headBytes);
		// 解析消息id
		int messageID = BytesUtil.parseBytesToInt(messageIDBytes);
		// 获取消息体信息字节段
		byte[] messageInfoBytes = BytesUtil.getWord(2, headBytes);
		// 解析消息体长度
		int bodyLength = BytesUtil.getBitsValue(0, 10, messageInfoBytes);// 从右面取9位
		// 解析加密类型
		int encrypt = BytesUtil.getBitsValue(10, 3, messageInfoBytes);
		// 解析是否分包
		boolean subpackage = BytesUtil.getBooleanValue(0, 5, messageInfoBytes);
		// 获取电话字节段
		byte[] simNumBytes = BytesUtil.cutBytes(4, 6, headBytes);
		// 解析电话号码
		String simNum = bcdToStr(simNumBytes);

		// 获取流水号字节段
		byte[] runningNumBytes = BytesUtil.getWord(10, headBytes);
		// 解析流水号
		int runningNum = BytesUtil.parseBytesToInt(runningNumBytes);
		// 拼装消息头对象
		int packageCounts = 0;
		// 解析包序号
		int packageNum = 0;
		if (subpackage) {
			// 获取分包数字节段
			byte[] packageCountsBytes = BytesUtil.getWord(13, data);
			// 获取包序号字节段
			byte[] packageNumBytes = BytesUtil.getWord(15, data);
			// 解析分包数
			packageCounts = BytesUtil.parseBytesToInt(packageCountsBytes);
			// 解析包序号
			packageNum = BytesUtil.parseBytesToInt(packageNumBytes);
		}
		// 解析消息体长度
		header.setBodyLength(bodyLength);
		// 解析加密类型
		header.setEncrypt(encrypt);
		// 解析消息id
		header.setMessageID(messageID);
		// 解析分包数
		header.setPackageCounts(packageCounts);
		// 解析包序号
		header.setPackageNum(packageNum);
		// 解析流水号
		header.setRunningNum(runningNum);
		// 解析电话号码
		header.setSimNum(simNum);
		// 解析包序号
		header.setSubpackage(subpackage);

		return header;
	}

	public static byte[] getInitNoPackHeadr() {
		return new byte[12];
	}

	public static byte[] getInitHasPackHeader() {
		return new byte[16];
	}

	/**
	 * @Description:将数字类型转换为系统可识别的字符串
	 * @param :num 消息ID的数字
	 * @return 可是别的字符串
	 * @throws Exception
	 */
	public static String hexToUpperCaseString(int num) {

		String numStr = Integer.toHexString(num).toUpperCase();
		// 获取数据长度
		int length = numStr.length();
		if (length > 4) {
		}
		// 判断长度
		switch (length) {
		case 1:
			// 如果长度等于1，拼接HEX_NAME_L1字符串
			numStr = HEX_NAME_L1 + numStr;
			break;
		case 2:
			// 如果长度等于2，拼接HEX_NAME_L2字符串
			numStr = HEX_NAME_L2 + numStr;
			break;
		case 3:
			// 如果长度等于3，拼接HEX_NAME_L3字符串
			numStr = HEX_NAME_L3 + numStr;
			break;
		case 4:
			// 如果长度等于4，拼接HEX_NAME_L4字符串
			numStr = HEX_NAME_L4 + numStr;
			break;
		default:
			numStr = null;
		}
		return numStr;
	}

	/**
	 * @Description:字节数组转化为字符串
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public static String bcdToStr(byte[] bytes) {

		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			// 移位操作
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		// 返回计算结果
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
				.toString().substring(1) : temp.toString();
	}

	/**
	 * 二进制数组按指定下标数进行转换（统一转强转成Int） 因为最长不会超过四个字节数组
	 * 
	 * @param bs
	 *            指导定数组
	 * @param offset
	 *            开始下标
	 * @param end
	 *            结束下标
	 * @param littleEndian
	 *            是否低位在前
	 * @return 转换完成的数
	 */
	public static int bytesToIntegerAccordNumber(byte[] bs, int offset,
			int end, boolean littleEndian) {
		int ret = 0;
		if (!littleEndian) {
			// 移位操作
			for (int i = offset; i <= end; i++) {
				ret = ret << 8 | (bs[i] & 0xFF);
			}
		} else {
			// 移位操作
			for (int i = end; i >= offset; i--) {
				ret = ret << 8 | (bs[i] & 0xFF);
			}
		}
		return ret;
	}

	/**
	 * 整型转化为二进制数组
	 * 
	 * @param src
	 *            整型变量，可以是byte,short,int
	 * @param bytesLen
	 *            共取几个字节
	 * @param littleEndian
	 *            是否低位在前
	 * @return
	 */
	public static byte[] integer2Bytes(int src, int bytesLen,
			boolean littleEndian) {
		byte[] bytes = new byte[bytesLen];
		if (littleEndian) {// 低位在前
			for (int i = 0; i < bytes.length; i++) {
				bytes[i] = (byte) ((src >> 8 * i) & 0xFF);
			}
		} else {// 低位不在前
			int j = 0;
			for (int i = bytes.length - 1; i >= 0 && j < bytes.length; i--, j++) {
				bytes[i] = (byte) ((src >> 8 * j) & 0xFF);
			}
		}
		return bytes;
	}

	/**
	 * convert the string as [0xFFFEDADB] to the bytes array : {0xFF, 0xFE,
	 * 0xDA, 0xDB}
	 * 
	 * @param hex
	 *            the hex string
	 * @return the bytes array
	 */
	public static byte[] toBytesHex(String hex) {
		hex = hex.toUpperCase();
		/*
		 * if (hex.startsWith("[")) { hex = hex.substring(1); } if
		 * (hex.endsWith("]")) { hex = hex.substring(0, hex.length() - 1); } if
		 * (hex.startsWith("0X")) { hex = hex.substring(2); }
		 */
		char[] chars = hex.toString().toCharArray();
		byte[] bytes = new byte[chars.length / 2];
		for (int i = 0; i < chars.length; i += 2) {
			bytes[i / 2] = (byte) Integer.parseInt(
					"" + chars[i] + chars[i + 1], 16);
		}
		return bytes;
	}

	/**
	 * @Description:字节转化为16进制
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	public static String byte6hex(byte[] bs, int index, int len) {

		StringBuffer hex = new StringBuffer();
		if (bs == null || index > bs.length || index < 0 || len <= 0
				|| index + len > bs.length) {
			return hex.toString();
		}
		// 拼接字符串
		for (int i = 0; i < len; i++) {
			hex.append(Integer.toHexString(bs[i + index]));
		}
		return hex.toString();
	}

	/**
	 * @Description:此方法用于和809协议进行交互的方法，主要作用用于转换日期的格式的方法 ：实时定位的那个指令，用于圈车的那个业务
	 *                                                  日月年（dmyy），时分秒都是10进制的字符串
	 * @param :日期类型的参数
	 * @return ： 字符串
	 * @throws Exception
	 */
	public static String[] dateFormatToDecimalFormat(Timestamp date) {
		return new SimpleDateFormat("ddMMyyyy:HHmmss").format(date).split(":");
	}

	/**
	 * @Description:此方法用于和809协议进行交互的方法，主要作用用于转换日期的格式的方法 ：实时定位的那个指令，用于圈车的那个业务
	 *                                                  日月年（dmyy），
	 *                                                  年的表示是先将年转换成2为十六进制数
	 *                                                  ，如2009标识为0x070xD9.
	 *                                                  时分秒（hms）
	 * @param :日期类型的参数
	 * @return ： 字符串
	 * @throws Exception
	 */
	public static String dateFormat808To809(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		String timeFormat = format.format(date);
		String[] times = timeFormat.split("-");
		String hexTime = "";
		// 拼接字符串
		for (int i = 0; i < times.length; i++) {
			String hex = Integer.toHexString(Integer.parseInt(times[i]));
			if (hex.length() < 2) {
				hex = "0" + hex;
			} else if (hex.length() == 3) {
				hex = "0" + hex;
			}
			// 拼接字符串
			hexTime = hexTime + hex + ",";
		}
		return hexTime;
	}

	public static void encryptRSA(int bodyindex, byte[] data) {
		
	}

	// /**
	// * @Description:合成809所需有的GPS实时信息格式(GPS最新的那条信息)
	// * @param :GPSInfo：部标上传的GPS信息对象
	// * @return：809所需的信息格式
	// * @throws Exception
	// */
	// public static String temporaryGPSTo809(GpsInfoFromTerminal gpsInfo) {
	//
	// String[] dateTime = dateFormatToDecimalFormat(new
	// Timestamp(gpsInfo.getGpsTime().getTime()));
	// // String dmyy = dateTime.substring(0, 10).replace(",", "");//
	// // 日月年（dmyy），年的表示是先将年转换成2为十六进制数，如2009标识为0x070xD9.
	// // String hms = dateTime.substring(11, 20).replace(",", "");// 时分秒（hms）
	// // String dmyy = "13082014";
	// // String hms = "173055";
	// String dmyy = dateTime[0];
	// String hms = dateTime[1];
	// // Math.pow(10, 6)
	// int lon = (int) (gpsInfo.getLongitude() * 1000000);// 经度，单位为1*10^-6度。
	//
	// int lat = (int) (gpsInfo.getLatitude() * 1000000);// 纬度，单位为1*10^-6度。
	// int speed = (int) gpsInfo.getSpeed();// 速度
	// int driveSpeed = (int) gpsInfo.getSpeed();// 行驶记录速度
	// int mileage = (int) gpsInfo.getMileage();//
	// 车辆当前总里程数，值车辆上传的行车里程数。单位单位为千米（km）
	// int direction = gpsInfo.getDirection();// 方向，0-359，单位为度（。），正北为0，顺时针。
	// int alt = (int) gpsInfo.getAltitude();// 海拔高度，单位为米（m）
	// // int status = 1;// Integer.parseInt(gpsInfo.getStatus());//
	// // 车辆状态，二进制表示，B31B30B29。。。。。。B2B1B0.具体定义按照JT/T808-2011中表17的规定
	// int status = gpsInfo.getOriStatus();
	// int alarmStatus = gpsInfo.getHasAlarm();// 报警状态，二进制表示，0标识正常，1表示报警
	//
	// String circleVehicleContents = null;
	// circleVehicleContents = "0;" + dmyy + ";" + hms + ";" + lon + ";" + lat +
	// ";" + speed + ";" + driveSpeed + ";" + mileage + ";" + direction
	// + ";" + alt + ";" + status + ";" + alarmStatus;
	//
	// return circleVehicleContents;
	// }

	// /**
	// * @Description:合成809所需有的GPS实时信息格式(GPS最新的那条信息)
	// * @param :GPSInfo：部标上传的GPS信息对象
	// * @return：809所需的信息格式
	// * @throws Exception
	// */
	// public static String realGPSTo809(GPSInfo gpsInfo) {
	// // String dateTime = dateFormat808To809(gpsInfo.getgTime());
	// // String dmyy = dateTime.substring(0, 10).replace(",", "");//
	// // 日月年（dmyy），年的表示是先将年转换成2为十六进制数，如2009标识为0x070xD9.
	// // String hms = dateTime.substring(11, 20).replace(",", "");// 时分秒（hms）
	// Timestamp gpsInfoTime = new Timestamp(gpsInfo.getgTime().getTime());
	// String[] dateTime = dateFormatToDecimalFormat(gpsInfoTime);
	// String dmyy = dateTime[0];
	// String hms = dateTime[1];
	// // Math.pow(10, 6)
	// int lon = (int) (gpsInfo.getLon() * 1000000);// 经度，单位为1*10^-6度。
	//
	// int lat = (int) (gpsInfo.getLat() * 1000000);// 纬度，单位为1*10^-6度。
	// int speed = (int) gpsInfo.getSpeed();// 速度
	// int driveSpeed = (int) gpsInfo.getDriveSpeed();// 行驶记录速度
	// int mileage = (int) gpsInfo.getMileage();//
	// 车辆当前总里程数，值车辆上传的行车里程数。单位单位为千米（km）
	// int direction = gpsInfo.getDirection();// 方向，0-359，单位为度（。），正北为0，顺时针。
	// int alt = (int) gpsInfo.getAlt();// 海拔高度，单位为米（m）
	// int status = gpsInfo.getStatus();//
	// 车辆状态，二进制表示，B31B30B29。。。。。。B2B1B0.具体定义按照JT/T808-2011中表17的规定
	// int alarmStatus = (int) gpsInfo.getAlarmTag();
	// String circleVehicleContents = null;
	// circleVehicleContents = "0;" + dmyy + ";" + hms + ";" + lon + ";" + lat +
	// ";" + speed + ";" + driveSpeed + ";" + mileage + ";" + direction
	// + ";" + alt + ";" + status + ";" + alarmStatus;
	// return circleVehicleContents;
	// }

}
