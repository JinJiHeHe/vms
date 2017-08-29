package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8103;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8103_Process
 * @Description: 设置终端参数协议解析类
 * @author: lijz
 * @date: 2014年5月6日 上午9:12:29
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8103_Process extends
		T808_Process<T808_MessageHeader, T808_0x8103> {
	private static final String String = null;

	// 初始化log4j

	// 获得实体类里面的key
	// private static Set<String> STRINGSET = new HashSet<String>();

	@Override
	public Message<T808_MessageHeader, T808_0x8103> unpackData(byte[] data) {
		//
		return null;
	}

	/**
	 * @Description:打包消息体
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.com.cnpc.vms.terminalaccess.protocols.tcp.T808.T808_Process#packData
	 * (cn.com.cnpc.vms.common.protocols.common.CommonMessage)
	 */
	@Override
	public byte[] packData(Message<T808_MessageHeader, T808_0x8103> message) {

		// 组装头
		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x81;
		head[1] = 0x03;

		// 终端手机号
		byte[] phone = BytesUtil.strToBcd(((T808_MessageHeader) message
				.getMessageHeader()).getSimNum());
		head[4] = phone[0];
		head[5] = phone[1];
		head[6] = phone[2];
		head[7] = phone[3];
		head[8] = phone[4];
		head[9] = phone[5];

		// 消息流水号
		byte[] seiralnum = BytesUtil.int2bytes2(((T808_MessageHeader) message
				.getMessageHeader()).getRunningNum());
		head[10] = seiralnum[0];
		head[11] = seiralnum[1];

		// 消息体
		byte paramCount = BytesUtil.parseIntToByte(((T808_0x8103) message
				.getMessageBody()).getParamCount());// 参数总数
		byte packageCount = BytesUtil.parseIntToByte(((T808_0x8103) message
				.getMessageBody()).getPackageCount());// 包参数个数

		// 根据各自的消息id 拼接消息体
		Map<String, String[]> map = ((T808_0x8103) message.getMessageBody())
				.getSettings();

		// 返回此映射中包含的键的 Set 视图 获得map里面的key
		Set<String> getKey = map.keySet();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] mes = null;
		byte[] result = null;
		for (String key : getKey) {
			// 获得key 和 value 此时key是String类型的 把它转化为Integer类型的
			// 定义key为Integer的目的是便于做case判断
			result = packChildData(Integer.parseInt(key), map.get(key));
			// 转化为Integer进行写
			/*
			 * Integer length = key.length(); String str = key.substring(2,
			 * length); Integer key1 = Integer.parseInt(str, 16); byte[] result
			 * = packChildData(key1, map.get(key), message);
			 */
			// 转化为字符串进行求解 但是必须用if....else
			// byte[] result = packChildData(key, map.get(key));
			try {
				baos.write(result);
			} catch (IOException e) {
				// .warn("", e);
			}
		}
		result = baos.toByteArray();

		// 消息头
		byte[] length = BytesUtil.int2bytes2(1 + result.length);
		head[2] = length[0];
		head[3] = length[1];
		// 合成消息体
		try {

			// 0x7e
			// head
			// body
			// check
			// 0x7e
			baos.reset();
			baos.write(0x00);
			baos.write(head);
			baos.write(paramCount);
			// baos.write(packageCount);//通过调试打断点，发现直接不写入这个packageCount才能调试成功。
			baos.write(result);
			baos.write(0x00);
			baos.write(0x00);
			byte check = T808_Util.check(baos.toByteArray());
			byte[] bosBytes = baos.toByteArray();
			bosBytes[bosBytes.length - 2] = check;
			mes = T808_Util.escapeData(bosBytes);
			mes[0] = 0x7e;
			mes[mes.length - 1] = 0x7e;
		} catch (IOException e) {
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
			}
		}

		// 打印log
		// log.debug("messageID:0x8103|sim:" + ((T808_MessageHeader)
		// message.getMessageHeader()).getSimNum() + "|runningNum:"
		// + ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() +
		// "|ParamCount:"
		// + ((T808_0x8103) message.getMessageBody()).getParamCount() +
		// "|PackageCount:"
		// + ((T808_0x8103) message.getMessageBody()).getPackageCount());
		// byte[] datas =
		// BytesUtil.toStringHex("7e8103001301234567000203e8020000005504000000640000005604000000031e7e");
		// log.debug(BytesUtil.bytesToHexString(mes));
		// 7e8103001301234567000203e8020000005504000000640000005604000000031e7e
		// 7e81030013012345670002003a02000000550400000064000000560400000003cf7e
		return mes;
	}

	/**
	 * @Description:此方法进行解析key和value
	 * @param :id key params values
	 * @return
	 * @throws Exception
	 */
	private byte[] packChildData(int id, String[] params) {
		byte[] paramsID = new byte[4];
		byte paramLength = 9;
		byte[] messageContent = null;
		byte[] result = null;
		switch (id) {

		case 0x0001:
			/** 终端心跳发送间隔，单位为秒(s) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 终端心跳发送间隔，单位为秒(s)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0002:
			/** TCP消息应答超时时间，单位为秒(s) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING TCP消息应答超时时间，单位为秒(s)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0003:
			/** TCP消息重传次数 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING TCP消息重传次数
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0004:
			/** UDP消息应答超时时间，单位为秒(s) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING UDP消息应答超时时间，单位为秒(s)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0005:
			/** UDP消息重传次数 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING UDP消息重传次数
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0006:
			/** SMS消息应答超时时间，单位为秒(s) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING SMS消息应答超时时间，单位为秒(s)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0007:
			/** SMS消息重传次数 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING SMS消息重传次数
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0010:
			/** 主服务器APN，无线通信拨号访问点。若网络制式为CDMA，则该处为PPP拨号号码 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 主服务器APN，无线通信拨号访问点。若网络制式为CDMA，则该处为PPP拨号号码
			 **/
			messageContent = params[0].getBytes();

			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}

			break;
		case 0x0011:
			/** 主服务器无线通信拨号用户名 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 主服务器无线通信拨号用户名
			 **/
			messageContent = params[0].getBytes();

			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}

			break;
		case 0x0012:// TODO:不知道什么作用
			/** 主服务器无线通信拨号密码 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 主服务器无线通信拨号密码
			 **/
			messageContent = params[0].getBytes();

			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0013:
			/** 主服务器地址，IP或域名 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 主服务器地址，IP或域名
			 **/
			try {
				messageContent = params[0].getBytes("GBK");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}

			break;
		case 0x0014:
			/** 备份服务器APN，无线通信拨号访问点 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 备份服务器APN，无线通信拨号访问点
			 **/
			messageContent = params[0].getBytes();

			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0015:
			/** 备份服务器无线通信拨号用户名 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 备份服务器无线通信拨号用户名
			 **/
			messageContent = params[0].getBytes();

			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0016:
			/** 备份服务器无线通信拨号密码 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 备份服务器无线通信拨号密码
			 **/
			messageContent = params[0].getBytes();

			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0017:
			/** 备份服务器地址，IP或域名 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 主服务器地址，IP或域名
			 **/
			try {
				messageContent = params[0].getBytes("GBK");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}

			break;
		case 0x0018:// 服务器TCP端口
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/** 参数值DWORD或STRING **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));// 参数ID
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0019:// 服务器UDP端口
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/** 参数值DWORD或STRING **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));// 参数ID
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0020:
			/*** 位置回报策略 ***/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/** 参数值DWORD或STRING 位置汇报策略，0：定时汇报；1：定距汇报；2：定时和定距汇报 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0021:
			/** 位置汇报方案 **/
			/** 位置汇报方案 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING
			 * 位置汇报方案，0：根据ACC状态；1：根据登录状态和ACC状态，先判断登录状态，若登录再根据ACC状态
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0022:
			/** 驾驶员未登录汇报时间间隔 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 驾驶员未登录汇报时间间隔，单位为秒(s),>0
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0027:
			/** 休眠时汇报时间间隔，单位为秒(s),>0 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 休眠时汇报时间间隔，单位为秒(s),>0
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0028:
			/** 紧急报警时汇报时间间隔，单位为秒(s),>0 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 紧急报警时汇报时间间隔，单位为秒(s),>0
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0029:
			/** 缺省时间汇报间隔，单位为秒(s),>0 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 缺省时间汇报间隔，单位为秒(s),>0
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x002C:
			/** 缺省距离汇报间隔，单位为米(m),>0 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 缺省距离汇报间隔，单位为米(m),>0
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x002D:
			/** 驾驶员未登录汇报距离间隔，单位为米(m),>0 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 驾驶员未登录汇报距离间隔，单位为米(m),>0
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x002E:
			/** 休眠时汇报距离间隔，单位为米(m),>0 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 休眠时汇报距离间隔，单位为米(m),>0
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x002F:
			/** 紧急报警时汇报距离间隔，单位为米(m),>0 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 紧急报警时汇报距离间隔，单位为米(m),>0
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0030:
			/** 拐点补传角度，<180° **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 拐点补传角度，<180°
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0040:
			/** 监控平台电话号码 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 监控平台电话号码
			 **/
			messageContent = params[0].getBytes();
			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}

			break;
		case 0x0041:
			/** 复位电话号码，可采用此电话号码拨打终端电话让终端复位 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 复位电话号码，可采用此电话号码拨打终端电话让终端复位
			 **/
			messageContent = params[0].getBytes();
			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0042:
			/** 恢复出厂设置电话号码，可采用此电话号码拨打终端电话让终端恢复出厂设置 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 恢复出厂设置电话号码，可采用此电话号码拨打终端电话让终端恢复出厂设置
			 **/
			messageContent = params[0].getBytes();
			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}

			break;
		case 0x0043:
			/** 监控平台SMS电话号码 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 监控平台SMS电话号码
			 **/
			messageContent = params[0].getBytes();
			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0044:
			/** 接收终端SMS文本报警号码 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 接收终端SMS文本报警号码
			 **/
			messageContent = params[0].getBytes();
			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0045:
			/** 终端电话接听策略，0：自动接听；1：ACC ON时自动接听，OFF时手动接听 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 终端电话接听策略，0：自动接听；1：ACC ON时自动接听，OFF时手动接听
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0046:
			/** 每次最长通话时间，单位为秒(s),0为不允许通话，0xFFFFFFFF为不限制 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 每次最长通话时间，单位为秒(s),0为不允许通话，0xFFFFFFFF为不限制
			 **/
			messageContent = BytesUtil
					.int2bytes4(Integer.parseInt(params[0]) * 60);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0047:
			/** 当月最长通话时间，单位为秒(s),0为不允许通话，0xFFFFFFFF为不限制 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 当月最长通话时间，单位为秒(s),0为不允许通话，0xFFFFFFFF为不限制
			 **/
			messageContent = BytesUtil
					.int2bytes4(Integer.parseInt(params[0]) * 3600);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0048:
			/** 监听电话号码 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 监听电话号码
			 **/
			messageContent = params[0].getBytes();
			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0049:
			/** 监管平台特权短信号码 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 监管平台特权短信号码
			 **/
			messageContent = params[0].getBytes();
			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0050:
			/** 报警屏蔽字。与位置信息汇报消息中的报警标志相对应，相应位为1则相应报警被屏蔽 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 报警屏蔽字。与位置信息汇报消息中的报警标志相对应，相应位为1则相应报警被屏蔽
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0051:
			/** 报警发送文本SMS开关，与位置信息汇报消息中的报警标志相对应，相应位为1则相应报警时发送文本SMS **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 报警发送文本SMS开关，与位置信息汇报消息中的报警标志相对应，相应位为1则相应报警时发送文本SMS
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0052:
			/** 报警拍摄开关，与位置信息汇报消息中的报警标志相对应，相应位为1则相应报警时摄像头拍摄 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 报警拍摄开关，与位置信息汇报消息中的报警标志相对应，相应位为1则相应报警时摄像头拍摄
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0053:
			/** 报警拍摄存储标志，与位置信息汇报消息中的报警标志相对应，相应位为1则对相应报警时牌的照片进行存储，否则实时长传 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING
			 * 报警拍摄存储标志，与位置信息汇报消息中的报警标志相对应，相应位为1则对相应报警时牌的照片进行存储，否则实时长传
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0054:
			/** 关键标志，与位置信息汇报消息中的报警标志相对应，相应位为1则对相应报警为关键报警 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 关键标志，与位置信息汇报消息中的报警标志相对应，相应位为1则对相应报警为关键报警
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0055:
			/** 最高速度，单位为公里每小时(km/h) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 最高速度，单位为公里每小时(km/h)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0056:
			/** 超速持续时间，单位为秒(s) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING超速持续时间，单位为秒(s)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0057:
			/** 连续驾驶时间门限，单位为秒(s) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 连续驾驶时间门限，单位为秒(s)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));// 参数ID
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0058:
			/** 当天累计驾驶时间门限，单位为秒(s) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING当天累计驾驶时间门限，单位为秒(s)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0059:
			/** 最小休息时间，单位为秒(s) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 最小休息时间，单位为秒(s)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x005A:
			/** 最长停车时间，单位为秒(s) **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 最长停车时间，单位为秒(s)
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3]; // 通过调试打断点，发现这样写符合条件。
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0070:
			/** 图像/视频质量，1-10,1最好 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 图像/视频质量，1-10,1最好
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0071:
			/** 亮度，0-255 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 亮度，0-255
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0072:
			/** 对比度，0-127 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 对比度，0-127
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0073:
			/** 饱和度，0-127 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 饱和度，0-127
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0074:
			/** 色度，0-255 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 色度，0-255
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0080:
			/** 车辆里程表读数，1/10km **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 车辆里程表读数，1/10km
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];
			break;
		case 0x0081:
			/** 车辆所在的省域ID **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 车辆所在的省域ID
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength - 2];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 7);
			result[5] = messageContent[1];
			result[6] = messageContent[0];
			break;
		case 0x0082:
			/** 车辆所在的市域ID **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 车辆所在的市域ID
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength - 2];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 7);
			result[5] = messageContent[1];
			result[6] = messageContent[0];
			break;
		case 0x0083:
			/** 公安交通管理部门颁发的机动车号牌 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 公安交通管理部门颁发的机动车号牌
			 **/
			try {
				messageContent = params[0].getBytes("GBK");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			paramLength = (byte) (messageContent.length + 5);
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];

			result[4] = (byte) (paramLength - 5);

			for (int i = 0; i < messageContent.length; i++) {
				result[5 + i] = messageContent[i];
			}
			break;
		case 0x0084:
			/** 车牌颜色，按照JT/T415-2006的5.4.12 1：蓝色；2：黄色；3：黑色；4：白色；9：其他 **/
			/*** 参数id是DWORD类型 ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 车牌颜色，按照JT/T415-2006的5.4.12
			 * 1：蓝色；2：黄色；3：黑色；4：白色；9：其他
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength - 3];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 8);
			// result[5] = messageContent[3];
			// result[6] = messageContent[2];
			// result[7] = messageContent[1];
			result[5] = messageContent[0];
			break;
		case 0x0085:
			// byte[] paramsID = new byte[4];
			// byte paramLength = 9;
			// byte[] messageContent = null;
			// byte[] result = null;
			/** 限速设置 **/
			/*** 最高速度(单位为公里每小时（km/h）);超速持续时间(单位为秒（s）) ***/
			paramsID = BytesUtil.int2bytes4(id);
			/**
			 * 参数值DWORD或STRING 车牌颜色，按照JT/T415-2006的5.4.12
			 * 1：蓝色；2：黄色；3：黑色；4：白色；9：其他
			 **/
			messageContent = BytesUtil.int2bytes4(Integer.parseInt(params[0]));
			result = new byte[paramLength];
			result[0] = paramsID[3];
			result[1] = paramsID[2];
			result[2] = paramsID[1];
			result[3] = paramsID[0];
			result[4] = (byte) (paramLength - 5);
			result[5] = messageContent[3];
			result[6] = messageContent[2];
			result[7] = messageContent[1];
			result[8] = messageContent[0];

			result = new byte[paramLength + 9];
			byte[] maxSpeedbyte = new byte[9];
			maxSpeedbyte = MaxSpeed(Integer.parseInt(params[0]));
			for (int i = 0; i < maxSpeedbyte.length; i++) {
				result[i + 1] = maxSpeedbyte[i];
			}
			byte[] overSpeedTimebyte = new byte[9];
			overSpeedTimebyte = overSpeedTime(Integer.parseInt(params[1]));
			for (int i = 0; i < overSpeedTimebyte.length; i++) {
				result[i + 10] = overSpeedTimebyte[i];
			}

			break;
		default:
			break;
		}
		return result;
	}

	/*** 关键标志 ***/
	public byte[] MaxSpeed(int n) {
		byte[] returndata = new byte[9];
		/*** 参数id是DWORD类型 ***/
		byte[] id = new byte[4];
		id = BytesUtil.int2bytes4(0x55);
		returndata[0] = id[0];
		returndata[1] = id[1];
		returndata[2] = id[2];
		returndata[3] = id[3];
		/*** 参数长度 ***/
		returndata[4] = 4;
		/*** 参数内容 ***/
		byte[] result = new byte[4];
		result = BytesUtil.int2bytes4(n);
		returndata[5] = result[0];
		returndata[6] = result[1];
		returndata[7] = result[2];
		returndata[8] = result[3];
		return returndata;
	}

	/*** 超速持续时间 ***/
	public byte[] overSpeedTime(int n) {
		byte[] returndata = new byte[9];
		/*** 参数id是DWORD类型 ***/
		byte[] id = new byte[4];
		id = BytesUtil.int2bytes4(0x56);
		returndata[0] = id[0];
		returndata[1] = id[1];
		returndata[2] = id[2];
		returndata[3] = id[3];
		/*** 参数长度 ***/
		returndata[4] = 4;
		/*** 参数内容 ***/
		byte[] result = new byte[4];
		result = BytesUtil.int2bytes4(n);
		returndata[5] = result[0];
		returndata[6] = result[1];
		returndata[7] = result[2];
		returndata[8] = result[3];
		return returndata;
	}
}

// 起始字节 字段 数据类型 描述及要求
// 0 参数总数 BYTE
// 1 包参数个数 BYTE
// 2 参数项列表 参数项格式见表10
// 表10终端参数项
// 字段 数据类型 描述及要求
// 参数ID DWORD 参数ID定义及说明表目
// 参数长度 BYTE
// 参数值 DWORD或STRING，若为多值参数，则消息中使用多个相同ID的参数项，如调度中心电话号码
// 表11终端参数设置各参数项定义及说明
// 参数ID 数据类型 描述及要求
// 0x0001 DWORD 终端心跳发送间隔，单位为秒(s)
// 0x0002 DWORD TCP消息应答超时时间，单位为秒(s)
// 0x0003 DWORD TCP消息重传次数
// 0x0004 DWORD UDP消息应答超时时间，单位为秒(s)
// 0x0005 DWORD UDP消息重传次数
// 0x0006 DWORD SMS消息应答超时时间，单位为秒(s)
// 0x0007 DWORD SMS消息重传次数
// 0x0008-0x000F 保留
// 0x0010 STRING 主服务器APN，无线通信拨号访问点。若网络制式为CDMA，则该处为PPP拨号号码
// 0x0011 STRING 主服务器无线通信拨号用户名
// 0x0012 STRING 主服务器无线通信拨号密码
// 0x0013 STRING 主服务器地址，IP或域名
// 0x0014 STRING 备份服务器APN，无线通信拨号访问点
// 0x0015 STRING 备份服务器无线通信拨号用户名
// 0x0016 STRING 备份服务器无线通信拨号密码
// 0x0017 STRING 备份服务器地址，IP或域名
// 0x0018 DWORD 服务器TCP端口
// 0x0019 DWORD 服务器UDP端口
// 0x001A-0x001F 保留
// 0x0020 DWORD 位置汇报策略，0：定时汇报；1：定距汇报；2：定时和定距汇报
// 0x0021 DWORD 位置汇报方案，0：根据ACC状态；1：根据登录状态和ACC状态，先判断登录状态，若登录再根据ACC状态
// 0x0022 DWORD 驾驶员未登录汇报时间间隔，单位为秒(s),>0
// 0x0023-0x0026 DWORD 保留
// 0x0027 DWORD 休眠时汇报时间间隔，单位为秒(s),>0
// 0x0028 DWORD 紧急报警时汇报时间间隔，单位为秒(s),>0
// 0x0029 DWORD 缺省时间汇报间隔，单位为秒(s),>0
// 0x002A-0x002B DWORD 保留
// 0x002C DWORD 缺省距离汇报间隔，单位为米(m),>0
// 0x002D DWORD 驾驶员未登录汇报距离间隔，单位为米(m),>0
// 0x002E DWORD 休眠时汇报距离间隔，单位为米(m),>0
// 0x002F DWORD 紧急报警时汇报距离间隔，单位为米(m),>0
// 0x0030 DWORD 拐点补传角度，<180°
// 0x0031-0x003F 保留
// 0x0040 STRING 监控平台电话号码
// 0x0041 STRING 复位电话号码，可采用此电话号码拨打终端电话让终端复位
// 0x0042 STRING 恢复出厂设置电话号码，可采用此电话号码拨打终端电话让终端恢复出厂设置
// 0x0043 STRING 监控平台SMS电话号码
// 0x0044 STRING 接收终端SMS文本报警号码
// 0x0045 DWORD 终端电话接听策略，0：自动接听；1：ACC ON时自动接听，OFF时手动接听
// 0x0046 DWORD 每次最长通话时间，单位为秒(s),0为不允许通话，0xFFFFFFFF为不限制
// 0x0047 DWORD 当月最长通话时间，单位为秒(s),0为不允许通话，0xFFFFFFFF为不限制
// 0x0048 STRING 监听电话号码
// 0x0049 STRING 监管平台特权短信号码
// 0x004A-0x004F 保留
// 0x0050 DWORD 报警屏蔽字。与位置信息汇报消息中的报警标志相对应，相应位为1则相应报警被屏蔽
// 0x0051 DWORD 报警发送文本SMS开关，与位置信息汇报消息中的报警标志相对应，相应位为1则相应报警时发送文本SMS
// 0x0052 DWORD 报警拍摄开关，与位置信息汇报消息中的报警标志相对应，相应位为1则相应报警时摄像头拍摄
// 0x0053 DWORD 报警拍摄存储标志，与位置信息汇报消息中的报警标志相对应，相应位为1则对相应报警时牌的照片进行存储，否则实时长传
// 0x0054 DWORD 关键标志，与位置信息汇报消息中的报警标志相对应，相应位为1则对相应报警为关键报警
// 0x0055 DWORD 最高速度，单位为公里每小时(km/h)
// 0x0056 DWORD 超速持续时间，单位为秒(s)
// 0x0057 DWORD 连续驾驶时间门限，单位为秒(s)
// 0x0058 DWORD 当天累计驾驶时间门限，单位为秒(s)
// 0x0059 DWORD 最小休息时间，单位为秒(s)
// 0x005A DWORD 最长停车时间，单位为秒(s)
// 0x005B-0x006F 保留
// 0x0070 DWORD 图像/视频质量，1-10,1最好
// 0x0071 DWORD 亮度，0-255
// 0x0072 DWORD 对比度，0-127
// 0x0073 DWORD 饱和度，0-127
// 0x0074 DWORD 色度，0-255
// 0x0075-0x007F DWORD
// 0x0080 DWORD 车辆里程表读数，1/10km
// 0x0081 DWORD 车辆所在的省域ID
// 0x0082 DWORD 车辆所在的市域ID
// 0x0083 DWORD 公安交通管理部门颁发的机动车号牌
// 0x0084 DWORD 车牌颜色，按照JT/T415-2006的5.4.12
