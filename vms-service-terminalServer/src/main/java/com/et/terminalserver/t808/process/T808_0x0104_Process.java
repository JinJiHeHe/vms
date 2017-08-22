package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_Message;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x0104;
import com.et.terminalserver.t808.messagebody.TerminalParameterInfo;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.UnsupportedEncodingException;

/**
 * @Project: CNPC_VMS车辆管理系统
 * @Title: T808_0x0104_Process
 * @Description: 查询终端参数应答处理类
 * @author: lijz
 * @date :2014年10月19日 下午1:18:35
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0104_Process extends
		T808_Process<T808_MessageHeader, T808_0x0104> {
	// 初始化log4j

	/**
	 * @Description:合成消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Message<T808_MessageHeader, T808_0x0104> unpackData(byte[] data) {
		T808_MessageHeader header = T808_Util.getHeader(data);
		header.setMessageType(MESSAGETYPE_RESPONSE);
		int bodyindex = 13;
		if (header.getSubpackage())
			bodyindex += 4;
		// 获取消息体
		T808_0x0104 body = new T808_0x0104();
		byte[] replaySerialNumbers = BytesUtil.getWord(0 + bodyindex, data);// 应答流水号

		byte packageParamsNumber = BytesUtil.getByte(2 + bodyindex, data);// 包参数个数
		body.setPackageParamsNumber(packageParamsNumber);
		body.setReplaySerialNumber(BytesUtil
				.parseBytesToInt(replaySerialNumbers));
		TerminalParameterInfo paraList = parseTerminalResponse(data);// 包参数个数
		body.setParaList(paraList);
		return new T808_Message<T808_MessageHeader, T808_0x0104>(header, body);
	}

	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x0104> message) {
		return null;
	}

	/**
	 * @description 生成参数列表响应
	 */
	public static TerminalParameterInfo parseTerminalResponse(byte[] Msgbody) {
		TerminalParameterInfo list = new TerminalParameterInfo();
		// 组合参数
		byte[] ParaList = new byte[Msgbody.length - 16];
		for (int i = 0; i < ParaList.length; i++) {
			ParaList[i] = Msgbody[16 + i];
		}
		// 选择参数
		judgeWhichParameter(ParaList, list);
		return list;
	}

	/** 判断何种参数 **/
	public static void judgeWhichParameter(byte[] Msg,
			TerminalParameterInfo list) {
		if (Msg.length >= 6 && Msg != null) {
			// 参数id
			byte[] id = new byte[4];
			id[0] = Msg[0];
			id[1] = Msg[1];
			id[2] = Msg[2];
			id[3] = Msg[3];
			// 转换id为int类型
			int idInt = BytesUtil.bytes2int4(id);
			switch (idInt) {
			case 0x0001: {// 心跳时长
				parseHeartBeatTime(Msg, list);
				break;
			}
			case 0x0002: {// tcp响应时长
				parseTcpResponseTime(Msg, list);
				break;
			}
			case 0x0003: {// tcp重连时长
				parseTcpReConn(Msg, list);
				break;
			}
			case 0x0101: { // tcp重连时长
				parseTcpReConn(Msg, list);
				break;
			}
			case 0x0004: {// udp响应时长
				parseUdpResponseTime(Msg, list);
				break;
			}
			case 0x0005: {// udp重连时长
				parseUdpReConn(Msg, list);
				break;
			}
			case 0x0006: {// sms响应时长
				parseSmsResponseTime(Msg, list);
				break;
			}
			case 0x0007: {// sms重连时长
				parseSmsReConn(Msg, list);
				break;
			}
			case 0x0010: { // 主apn
				parseMainAPN(Msg, list);
				break;
			}
			case 0x0011: { // 主用户
				parseMainuser(Msg, list);
				break;
			}
			case 0x0012: { // 主密码
				parseMainpassword(Msg, list);
				break;
			}
			case 0x0013: { // 主ip
				parseMainIP(Msg, list);
				break;
			}
			case 0x0014: {// 备份apn
				parseBackupAPN(Msg, list);
				break;
			}
			case 0x0015: {// 备份用户
				parseBackupuser(Msg, list);
				break;
			}
			case 0x0016: {// 备份密码
				parseBackuppassword(Msg, list);
				break;
			}
			case 0x0017: { // 备份ip
				parseBackupIP(Msg, list);
				break;
			}
			case 0x0018: { // 备份端口
				parsetcpport(Msg, list);
				break;
			}
			case 0x0019: { // udp端口
				parseudpport(Msg, list);
				break;
			}

			case 0x0020: { //
				parsepositionReturnPolicy(Msg, list);
				break;
			}
			case 0x0021: {//
				parsepositionReMethod(Msg, list);
				break;
			}
			case 0x0022: {//
				parseDriverNotLogTime(Msg, list);
				break;
			}
			case 0x0027: {//
				parseSleepime(Msg, list);
				break;
			}
			case 0x0028: { //
				parseEmergencyime(Msg, list);
				break;
			}
			case 0x0029: {//
				parsedefaulttime(Msg, list);
				break;
			}
			case 0x002C: {//
				parsedefaultdistance(Msg, list);
				break;
			}
			case 0x002D: {//
				parsedriverNotLogdistance(Msg, list);
				break;
			}
			case 0x002E: {//
				parsesleepdistance(Msg, list);
				break;
			}
			case 0x002F: {//
				parseEmergencydistance(Msg, list);
				break;
			}
			case 0x0030: {//
				parseInflectionPoint(Msg, list);
				break;
			}
			case 0x0031: {// 非法移动阀值
				parseElectricFence(Msg, list);
				break;
			}
			case 0x0040: {//
				parsePlatPhoneNum(Msg, list);
				break;
			}
			case 0x0041: {//
				parseResetPhoneNum(Msg, list);
				break;
			}
			case 0x0042: {//
				parseRestorefactoryPhoneNum(Msg, list);
				break;
			}
			case 0x0043: {//
				parseplatSmsPhone(Msg, list);
				break;
			}
			case 0x0044: {//
				parserecieveTerminalSMSnum(Msg, list);
				break;
			}
			case 0x0045: {//
				parseterminalphonePolicy(Msg, list);
				break;
			}
			case 0x0046: {// 每次最长通话时间
				parseperMaxphonetime(Msg, list);
				break;
			}
			case 0x0047: {//
				parseperMonthMaxphonetime(Msg, list);
				break;
			}
			case 0x0048: {//
				parseMonitorPhoneNum(Msg, list);
				break;
			}
			case 0x0049: {//
				parseMonitorMsgNum(Msg, list);
				break;
			}
			case 0x0050: {//
				parsealarmshield(Msg, list);
				break;
			}
			case 0x0051: {//
				parsealarmSMS(Msg, list);
				break;
			}
			case 0x0052: {//
				parsealarmphoto(Msg, list);
				break;
			}
			case 0x0053: {//
				parsealarmphotoSave(Msg, list);
				break;
			}
			case 0x0054: {//
				parseImportantFlag(Msg, list);
				break;
			}
			case 0x0055: {// 最大速度
				parseMaxSpeed(Msg, list);
				break;
			}
			case 0x0056: {// 超速时长
				parseOverSpeedTime(Msg, list);
				break;
			}
			case 0x0057: {// 最大超速时长
				parsemaxoverDriveTime(Msg, list);
				break;
			}
			case 0x0058: {
				parsemaxoverDrivePerday(Msg, list);
				break;
			}
			case 0x0059: {// 最小休息时长
				parseminResttime(Msg, list);
				break;
			}
			case 0x005A: {// 最大停车时长
				parsemaxparkTime(Msg, list);
				break;
			}
			case 0x0070: {// 图片质量
				parseImageQuality(Msg, list);
				break;
			}
			case 0x0071: { // 光线
				parseBrightness(Msg, list);
				break;
			}
			case 0x0072: {//
				parseContrast(Msg, list);
				break;
			}
			case 0x0073: {//
				parseSaturation(Msg, list);
				break;
			}
			case 0x0074: {// 颜色
				parseColor(Msg, list);
				break;
			}
			case 0x0080: {//
				parseOdometer_reading(Msg, list);
				break;
			}
			case 0x0081: {// 行政区id
				parseProvince_ID(Msg, list);
				break;
			}
			case 0x0082: {// 城市id
				parseCity_ID(Msg, list);
				break;
			}
			case 0x0083: {// 车辆号码
				parseCarNum(Msg, list);
				break;
			}
			case 0x0084: {// 车辆颜色
				parseCarColor(Msg, list);
				break;
			}

			default: {
				break;
			}
			}
		}
	}

	/**
	 * @description 心跳时长
	 */
	public static void parseHeartBeatTime(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] heartBeatT = new byte[4];
		for (int i = 0; i < heartBeatT.length; i++) {
			heartBeatT[i] = para[5 + i];
		}
		int heartbeatTint = BytesUtil.bytes2int4(heartBeatT);
		list.setHeartBeatTime(heartbeatTint);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseTcpResponseTime(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] tcptime = new byte[4];
		for (int i = 0; i < tcptime.length; i++) {
			tcptime[i] = para[5 + i];
		}
		int tcptimeint = BytesUtil.bytes2int4(tcptime);
		list.setTcpResponseTime(tcptimeint);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseTcpReConn(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] TcpReConn = new byte[4];
		for (int i = 0; i < TcpReConn.length; i++) {
			TcpReConn[i] = para[5 + i];
		}
		int tcpreconn = BytesUtil.bytes2int4(TcpReConn);
		list.setTcpReCon(tcpreconn);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseUdpResponseTime(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] udptime = new byte[4];
		for (int i = 0; i < udptime.length; i++) {
			udptime[i] = para[5 + i];
		}
		int udptimeint = BytesUtil.bytes2int4(udptime);
		list.setUdpResponseTime(udptimeint);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseUdpReConn(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] UdpReConn = new byte[4];
		for (int i = 0; i < UdpReConn.length; i++) {
			UdpReConn[i] = para[5 + i];
		}
		int udpreconn = BytesUtil.bytes2int4(UdpReConn);
		list.setUdpReCon(udpreconn);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseSmsResponseTime(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] smstime = new byte[4];
		for (int i = 0; i < smstime.length; i++) {
			smstime[i] = para[5 + i];
		}
		int smstimeint = BytesUtil.bytes2int4(smstime);
		list.setSmsResponseTime(smstimeint);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseSmsReConn(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] SmsReConn = new byte[4];
		for (int i = 0; i < SmsReConn.length; i++) {
			SmsReConn[i] = para[5 + i];
		}
		int smsreconn = BytesUtil.bytes2int4(SmsReConn);
		list.setSmsReCon(smsreconn);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseMainAPN(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] MainAPN = new byte[lenth];
			for (int i = 0; i < MainAPN.length; i++) {
				MainAPN[i] = para[5 + i];
			}
			String mainapn = new String(MainAPN);
			list.setMainApn(mainapn.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseMainuser(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] Mainuser = new byte[lenth];
			for (int i = 0; i < Mainuser.length; i++) {
				Mainuser[i] = para[5 + i];
			}
			String mainuser = new String(Mainuser);
			list.setMainwirelessUser(mainuser.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseMainpassword(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] Mainpassword = new byte[lenth];
			for (int i = 0; i < Mainpassword.length; i++) {
				Mainpassword[i] = para[5 + i];
			}
			String mainpsw = new String(Mainpassword);
			list.setMainwirelesspassword(mainpsw.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseMainIP(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] MainIP = new byte[lenth];
			for (int i = 0; i < MainIP.length; i++) {
				MainIP[i] = para[5 + i];
			}
			String mainIP = new String(MainIP);
			list.setMainIP(mainIP.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseBackupAPN(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] BackupAPN = new byte[lenth];
			for (int i = 0; i < BackupAPN.length; i++) {
				BackupAPN[i] = para[5 + i];
			}
			String backupapn = new String(BackupAPN);
			list.setBackupApn(backupapn.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseBackupuser(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] Backupuser = new byte[lenth];
			for (int i = 0; i < Backupuser.length; i++) {
				Backupuser[i] = para[5 + i];
			}
			String backupuser = new String(Backupuser);
			list.setBackupwirelessUser(backupuser.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseBackuppassword(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] Backuppassword = new byte[lenth];
			for (int i = 0; i < Backuppassword.length; i++) {
				Backuppassword[i] = para[5 + i];
			}
			String backuppsw = new String(Backuppassword);
			list.setBackupwirelesspassword(backuppsw.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseBackupIP(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] BackupIP = new byte[lenth];
			for (int i = 0; i < BackupIP.length; i++) {
				BackupIP[i] = para[5 + i];
			}
			String backIP = new String(BackupIP);
			list.setBackupIP(backIP.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsetcpport(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] tcpport = new byte[4];
		for (int i = 0; i < tcpport.length; i++) {
			tcpport[i] = para[5 + i];
		}
		int tcpportint = BytesUtil.bytes2int4(tcpport);
		list.setTcpport(tcpportint);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseudpport(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] udpport = new byte[4];
		for (int i = 0; i < udpport.length; i++) {
			udpport[i] = para[5 + i];
		}
		int udpportint = BytesUtil.bytes2int4(udpport);
		list.setUdpport(udpportint);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsepositionReturnPolicy(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] positionReturnPolicy = new byte[4];
		for (int i = 0; i < positionReturnPolicy.length; i++) {
			positionReturnPolicy[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(positionReturnPolicy);
		list.setPositionReturnPolicy(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsepositionReMethod(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] positionReMethod = new byte[4];
		for (int i = 0; i < positionReMethod.length; i++) {
			positionReMethod[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(positionReMethod);
		list.setPositionReMethod(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseDriverNotLogTime(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] DriverNotLogTime = new byte[4];
		for (int i = 0; i < DriverNotLogTime.length; i++) {
			DriverNotLogTime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(DriverNotLogTime);
		list.setDriverNotLogtime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseSleepime(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] Sleepime = new byte[4];
		for (int i = 0; i < Sleepime.length; i++) {
			Sleepime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(Sleepime);
		list.setSleepTime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseEmergencyime(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] Emergencyime = new byte[4];
		for (int i = 0; i < Emergencyime.length; i++) {
			Emergencyime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(Emergencyime);
		list.setEmergencytime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsedefaulttime(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] defaulttime = new byte[4];
		for (int i = 0; i < defaulttime.length; i++) {
			defaulttime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(defaulttime);
		list.setDefaulttime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsedefaultdistance(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] defaultdistance = new byte[4];
		for (int i = 0; i < defaultdistance.length; i++) {
			defaultdistance[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(defaultdistance);
		list.setDefaultdistance(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsedriverNotLogdistance(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] driverNotLogdistance = new byte[4];
		for (int i = 0; i < driverNotLogdistance.length; i++) {
			driverNotLogdistance[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(driverNotLogdistance);
		list.setDriverNotLogdistance(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsesleepdistance(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] sleepdistance = new byte[4];
		for (int i = 0; i < sleepdistance.length; i++) {
			sleepdistance[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(sleepdistance);
		list.setSleepDistance(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseEmergencydistance(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] Emergencydistance = new byte[4];
		for (int i = 0; i < Emergencydistance.length; i++) {
			Emergencydistance[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(Emergencydistance);
		list.setEmergencyDistance(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseInflectionPoint(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] InflectionPoint = new byte[4];
		for (int i = 0; i < InflectionPoint.length; i++) {
			InflectionPoint[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(InflectionPoint);
		list.setInflectionPoint(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsePlatPhoneNum(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] PlatPhoneNum = new byte[lenth];
			for (int i = 0; i < PlatPhoneNum.length; i++) {
				PlatPhoneNum[i] = para[5 + i];
			}
			String pr = new String(PlatPhoneNum);
			list.setPlatphoneNum(pr.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseResetPhoneNum(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] ResetPhoneNum = new byte[lenth];
			for (int i = 0; i < ResetPhoneNum.length; i++) {
				ResetPhoneNum[i] = para[5 + i];
			}
			String pr = new String(ResetPhoneNum);
			list.setResetPhoneNum(pr.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseRestorefactoryPhoneNum(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] RestorefactoryPhoneNum = new byte[lenth];
			for (int i = 0; i < RestorefactoryPhoneNum.length; i++) {
				RestorefactoryPhoneNum[i] = para[5 + i];
			}
			String pr = new String(RestorefactoryPhoneNum);
			list.setRestorefactoryPhoneNum(pr.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseplatSmsPhone(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] platSmsPhone = new byte[lenth];
			for (int i = 0; i < platSmsPhone.length; i++) {
				platSmsPhone[i] = para[5 + i];
			}
			String pr = new String(platSmsPhone);
			list.setPlatSMSnum(pr.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parserecieveTerminalSMSnum(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] recieveTerminalSMSnum = new byte[lenth];
			for (int i = 0; i < recieveTerminalSMSnum.length; i++) {
				recieveTerminalSMSnum[i] = para[5 + i];
			}
			String pr = new String(recieveTerminalSMSnum);
			list.setRecieveTerminalSMSnum(pr.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseterminalphonePolicy(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] terminalphonePolicy = new byte[4];
		for (int i = 0; i < terminalphonePolicy.length; i++) {
			terminalphonePolicy[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(terminalphonePolicy);
		list.setTerminalphonePolicy(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseperMaxphonetime(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] parseperMaxphonetime = new byte[4];
		for (int i = 0; i < parseperMaxphonetime.length; i++) {
			parseperMaxphonetime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(parseperMaxphonetime);
		list.setPerMaxphonetime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseperMonthMaxphonetime(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] perMonthMaxphonetime = new byte[4];
		for (int i = 0; i < perMonthMaxphonetime.length; i++) {
			perMonthMaxphonetime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(perMonthMaxphonetime);
		list.setPerMonthMaxphonetime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseMonitorPhoneNum(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] MonitorPhoneNum = new byte[lenth];
			for (int i = 0; i < MonitorPhoneNum.length; i++) {
				MonitorPhoneNum[i] = para[5 + i];
			}
			String pr = new String(MonitorPhoneNum);
			list.setMonitorPhoneNum(pr.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseMonitorMsgNum(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] MonitorMsgNum = new byte[lenth];
			for (int i = 0; i < MonitorMsgNum.length; i++) {
				MonitorMsgNum[i] = para[5 + i];
			}
			String pr = new String(MonitorMsgNum);
			list.setMonitorplatMessageNum(pr.trim());
		}
		for (int i = 0; i < para.length - 5 - lenth; i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsealarmshield(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] alarmshield = new byte[4];
		for (int i = 0; i < alarmshield.length; i++) {
			alarmshield[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(alarmshield);
		list.setAlarmshield(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsealarmSMS(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] alarmSMS = new byte[4];
		for (int i = 0; i < alarmSMS.length; i++) {
			alarmSMS[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(alarmSMS);
		list.setAlarmSMS(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsealarmphoto(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] alarmphoto = new byte[4];
		for (int i = 0; i < alarmphoto.length; i++) {
			alarmphoto[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(alarmphoto);
		list.setAlarmPhoto(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsealarmphotoSave(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] alarmphotoSave = new byte[4];
		for (int i = 0; i < alarmphotoSave.length; i++) {
			alarmphotoSave[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(alarmphotoSave);
		list.setAlarmphotoSave(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseImportantFlag(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] ImportantFlag = new byte[4];
		for (int i = 0; i < ImportantFlag.length; i++) {
			ImportantFlag[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(ImportantFlag);
		list.setImportantFlag(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseMaxSpeed(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] MaxSpeed = new byte[4];
		for (int i = 0; i < MaxSpeed.length; i++) {
			MaxSpeed[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(MaxSpeed);
		list.setMaxSpeed(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseOverSpeedTime(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] OverSpeedTime = new byte[4];
		for (int i = 0; i < OverSpeedTime.length; i++) {
			OverSpeedTime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(OverSpeedTime);
		list.setOverspeedTime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsemaxoverDriveTime(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] maxoverDriveTime = new byte[4];
		for (int i = 0; i < maxoverDriveTime.length; i++) {
			maxoverDriveTime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(maxoverDriveTime);
		list.setMaxoverDriveTime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsemaxoverDrivePerday(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] maxoverDrivePerday = new byte[4];
		for (int i = 0; i < maxoverDrivePerday.length; i++) {
			maxoverDrivePerday[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(maxoverDrivePerday);
		list.setMaxoverDrivePerday(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseminResttime(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] minResttime = new byte[4];
		for (int i = 0; i < minResttime.length; i++) {
			minResttime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(minResttime);
		list.setMinResttime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parsemaxparkTime(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] maxparkTime = new byte[4];
		for (int i = 0; i < maxparkTime.length; i++) {
			maxparkTime[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(maxparkTime);
		list.setMaxParktime(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseImageQuality(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] ImageQualit = new byte[4];
		for (int i = 0; i < ImageQualit.length; i++) {
			ImageQualit[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(ImageQualit);
		list.setImageQuality(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseBrightness(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] Brightness = new byte[4];
		for (int i = 0; i < Brightness.length; i++) {
			Brightness[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(Brightness);
		list.setBrightness(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseContrast(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] Contrast = new byte[4];
		for (int i = 0; i < Contrast.length; i++) {
			Contrast[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(Contrast);
		list.setContrast(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseSaturation(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] Saturation = new byte[4];
		for (int i = 0; i < Saturation.length; i++) {
			Saturation[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(Saturation);
		list.setSaturation(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseColor(byte[] para, TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] Color = new byte[4];
		for (int i = 0; i < Color.length; i++) {
			Color[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(Color);
		list.setColor(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseOdometer_reading(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 9;
		byte[] returnMsg = new byte[para.length - 9];
		byte[] Odometer_reading = new byte[4];
		for (int i = 0; i < Odometer_reading.length; i++) {
			Odometer_reading[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int4(Odometer_reading);
		list.setOdometerReading(pr);
		for (int i = 0; i < para.length - 9; i++) {
			returnMsg[i] = para[9 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseProvince_ID(byte[] para, TerminalParameterInfo list) {
		byte lenth = 7;
		byte[] returnMsg = new byte[para.length - 7];
		byte[] Province_ID = new byte[2];
		for (int i = 0; i < Province_ID.length; i++) {
			Province_ID[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int2(Province_ID);
		list.setProvinceId(pr);
		for (int i = 0; i < para.length - 7; i++) {
			returnMsg[i] = para[7 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseElectricFence(byte[] para,
			TerminalParameterInfo list) {
		byte lenth = 7;
		byte[] returnMsg = new byte[para.length - 7];
		byte[] ElectricFence_Radius = new byte[2];
		for (int i = 0; i < ElectricFence_Radius.length; i++) {
			ElectricFence_Radius[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int2(ElectricFence_Radius);
		list.setElectricFenceRadius(pr);
		for (int i = 0; i < para.length - 7; i++) {
			returnMsg[i] = para[7 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseCity_ID(byte[] para, TerminalParameterInfo list) {
		byte lenth = 7;
		byte[] returnMsg = new byte[para.length - 7];
		byte[] City_ID = new byte[2];
		for (int i = 0; i < City_ID.length; i++) {
			City_ID[i] = para[5 + i];
		}
		int pr = BytesUtil.bytes2int2(City_ID);
		list.setCityId(pr);
		for (int i = 0; i < para.length - 7; i++) {
			returnMsg[i] = para[7 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseCarNum(byte[] para, TerminalParameterInfo list) {
		byte lenth = para[4];
		byte[] returnMsg = new byte[para.length - 5 - lenth];
		if (lenth != 0) {
			byte[] CarNum = new byte[lenth];
			for (int i = 0; i < CarNum.length; i++) {
				CarNum[i] = para[5 + i];
			}
			String pr;
			try {
				pr = new String(CarNum, "GBK");
				list.setCarNum(pr.trim());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < (para.length - 5 - lenth); i++) {
			returnMsg[i] = para[5 + lenth + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

	public static void parseCarColor(byte[] para, TerminalParameterInfo list) {
		byte lenth = 6;
		byte[] returnMsg = new byte[para.length - 6];
		byte carcolor = para[5];
		// int i = (int) carcolor;
		// TODO:看看正确与否
		list.setCarColor((int) carcolor);
		for (int i = 0; i < para.length - 6; i++) {
			returnMsg[i] = para[6 + i];
		}
		if (returnMsg.length == 0) {

		} else if (returnMsg.length != 0) {
			judgeWhichParameter(returnMsg, list);
		}
	}

}
