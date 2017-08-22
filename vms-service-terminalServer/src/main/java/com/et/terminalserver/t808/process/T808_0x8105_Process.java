package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8105;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8105_Process
 * @Description: 终端控制
 * @author: lijz
 * @date: 2014年8月6日 下午9:29:34
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8105_Process extends T808_Process<T808_MessageHeader, T808_0x8105> {
	// 初始化log4j
//	private static Log log = LogFactory.getLog(T808_0x8105_Process.class);

	@Override
	public Message<T808_MessageHeader, T808_0x8105> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8105> message) {
		// 获取消息体
		byte[] head = T808_Util.getInitNoPackHeadr();

		// 消息ID拼接
		head[0] = (byte) 0x81;
		head[1] = 0x05;

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

		// 消息体
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		byte[] result = null;
		int command = ((T808_0x8105) message.getMessageBody()).getCommand();
		byte commandByte = BytesUtil.parseIntToByte(command);
		// 传输过来多个ID，进行处理
		List<String> list = ((T808_0x8105) message.getMessageBody()).getList();// 区域ID
		String[] controlParams = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			controlParams[i] = list.get(i) ;
		}
		if (command == 1 || command == 2) {
			result = controlStringToBytes(command, controlParams);
			try {
				bos.write(result);
			} catch (IOException e) {
			}
		}

		// result = bos.toByteArray();

		// log.debug("messageID:0x8105|sim:" + ((T808_MessageHeader)
		// message.getMessageHeader()).getSimNum() + "|runningNum:"
		// + ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() +
		// "|AreaNumber:" + areaNumbers + "|AreaIDCounts:" + list.size());
		// byte[] msg = null;
		// try {
		// msg = "0;bj;cmnet;l;l;114.161.37.21;6000;8888;20".getBytes("GBK");
		// } catch (UnsupportedEncodingException e1) {
		// e1.printStackTrace();
		// }
		// 消息头 消息体长度:1 + 4 * list.size()
		// byte[] length = BytesUtil.int2bytes2(1 + msg.length);//34
		byte[] length = null;
		if (command == 1 || command == 2)
			length = BytesUtil.int2bytes2(1 + result.length);
		else
			length = BytesUtil.int2bytes2(1);
		head[2] = length[0];
		head[3] = length[1];

		// 合成消息体
		try {
			bos.reset();
			bos.write(0x00);
			bos.write(head);
			bos.write(commandByte);
			if (command == 1 || command == 2)
				bos.write(result);
			// bos.write((byte) 0x02);
			// bos.write(msg);
			bos.write(0x00);
			bos.write(0x00);
			byte check = T808_Util.check(bos.toByteArray());
			byte[] bosBytes = bos.toByteArray();
			bosBytes[bosBytes.length - 2] = check;
			mes = T808_Util.escapeData(bosBytes);
			mes[0] = 0x7e;
			mes[mes.length - 1] = 0x7e;
			bos.close();
		} catch (IOException e) {
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
				}
			}
		}

		// 生成log
	//	log.debug("data hex answer " + BytesUtil.bytesToHexString(mes));
		return mes;
	}

	/**
	 * @Description:字符串转化为字节的方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private static byte[] controlStringToBytes(int command, String[] controlParams) {
		int length = 0;
		byte[] messageContent = null;
		byte[] result = null;
		int paramLength = 0;
		String[] control = null;
		switch (command) {

		case 1://无线升级
			control = new String[controlParams.length];
			for (int i = 0; i < controlParams.length; i++) {
				control[i] = controlParams[i];
				paramLength += controlParams[i].getBytes().length;
			}

			result = new byte[paramLength];

			// for (String string : control) {
			//
			// }

			try {
				messageContent = control[0].getBytes("GBK");// 地址
			} catch (UnsupportedEncodingException e) {
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[1].getBytes("GBK");// 拨号点名称
			} catch (UnsupportedEncodingException e) {
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[2].getBytes("GBK");// 拨号用户名
			} catch (UnsupportedEncodingException e) {
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[3].getBytes("GBK");// 拨号密码
			} catch (UnsupportedEncodingException e) {
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[4].getBytes("GBK");// 地址
			} catch (UnsupportedEncodingException e) {
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[5].getBytes("GBK");// TCP端口
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[6].getBytes("GBK");// UDP端口
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[7].getBytes("GBK");// 连接到指定服务器时限
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[8].getBytes("GBK");// 连接到指定服务器时限
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[9].getBytes("GBK");// 连接到指定服务器时限
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}

			length += messageContent.length;
			try {
				messageContent = control[10].getBytes("GBK");// 连接到指定服务器时限
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < messageContent.length; i++) {
				result[length + i] = messageContent[i];
			}
			break;
		case 2://控制终端连接指定服务器
			if (controlParams.length == 1) {//：1：切换回原缺省监控平台服务器，并恢复正常状态。
				result = new byte[paramLength + 1];
				byte controlByte = BytesUtil.parseIntToByte(Integer.parseInt(controlParams[0]));
				
				result[length] = controlByte;
			} else {
				control = new String[controlParams.length];
				for (int i = 0; i < controlParams.length; i++) {
					control[i] = controlParams[i] ;
					paramLength += controlParams[i].getBytes().length;
				}

				result = new byte[paramLength];
                byte controlByte = BytesUtil.parseIntToByte(Integer.parseInt(controlParams[0].replace(";", "")));
				
				result[0] = controlByte; //0

				length += 1;
				
				result[length] = ';';
				length += 1;
				
				try {
					messageContent = control[1].getBytes("GBK");// 终端鉴权码
				} catch (UnsupportedEncodingException e) {
				}
				for (int i = 0; i < messageContent.length; i++) {
					result[length + i] =messageContent[i];
				}

				length += messageContent.length;
				result[length] = ';';
				length += 1;
				try {
					messageContent = control[2].trim().getBytes("GBK");// 拨号点名称
				} catch (UnsupportedEncodingException e) {
				}
				for (int i = 0; i < messageContent.length; i++) {
					result[length + i] = messageContent[i];
				}

				length += messageContent.length;
				result[length] = ';';
				length += 1;
				try {
					messageContent = control[3].trim().getBytes("GBK");// 拨号用户名
				} catch (UnsupportedEncodingException e) {
				}
				for (int i = 0; i < messageContent.length; i++) {
					result[length + i] = messageContent[i];
				}

				length += messageContent.length;
				result[length] = ';';
				length += 1;
				try {
					messageContent = control[4].trim().getBytes("GBK");// 拨号密码
				} catch (UnsupportedEncodingException e) {
				}
				for (int i = 0; i < messageContent.length; i++) {
					result[length + i] = messageContent[i];
				}

				length += messageContent.length;
				result[length] = ';';
				length += 1;
				try {
					messageContent = control[5].trim().getBytes("GBK");// 地址
				} catch (UnsupportedEncodingException e) {
				}
				for (int i = 0; i < messageContent.length; i++) {
					result[length + i] = messageContent[i];
				}

				length += messageContent.length;
				result[length] = ';';
				length += 1;
				// TCP端口
                byte[] tcpPort = BytesUtil.int2bytes2(Integer.parseInt(control[6].replace(";", "")));
				result[length] = tcpPort[0];
				result[length + 1] = tcpPort[1];

				length += 2;
				
				
				result[length] = ';';
				length += 1;
				// UDP端口
                byte[] udpPort = BytesUtil.int2bytes2(Integer.parseInt(control[7].replace(";", "")));
				result[length] = udpPort[0];
				result[length + 1] = udpPort[1];
				length += 2;
				
				result[length] = ';';
				length += 1;
				// UDP端口
                byte[] serverLimitTime = BytesUtil.int2bytes2(Integer.parseInt(control[8].replace(";", "")));
				result[length] = serverLimitTime[0];
				result[length + 1] = serverLimitTime[1];
				
				break;
			}
		}
		result = BytesUtil.cutBytes(0, length+2, result);
//		System.out.println(new String(result));
		return result;

	}

	public static void main(String[] args) {
		String msg = "0;bj;cmnet;ljz;ljz;10.185.224.99;9999;8888;20";
		String[] controlParams = msg.split(";");
		controlStringToBytes(6, controlParams);
	}
}