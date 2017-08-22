package com.et.terminalserver.t808.process;


import com.et.terminalserver.protocols.protocols.Message;
import com.et.terminalserver.protocols.protocols.util.BytesUtil;
import com.et.terminalserver.t808.T808_MessageHeader;
import com.et.terminalserver.t808.T808_Process;
import com.et.terminalserver.t808.messagebody.T808_0x8801;
import com.et.terminalserver.t808.util.T808_Util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8801_Process
 * @Description: 摄像头立即拍摄命令协议解析
 * @author: lijz
 * @date: 2014年4月28日 下午4:09:26
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8801_Process extends T808_Process<T808_MessageHeader, T808_0x8801> {
	// 初始化log4j

	@Override
	public Message<T808_MessageHeader, T808_0x8801> unpackData(byte[] data) {
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
	public byte[] packData(Message<T808_MessageHeader, T808_0x8801> message) {

		byte[] head = T808_Util.getInitNoPackHeadr();
		// 消息ID拼接
		head[0] = (byte) 0x88;
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

		// 消息体
		byte[] body = new byte[12];
		byte channelID = BytesUtil.parseIntToByte(((T808_0x8801) message.getMessageBody()).getChannelID());// 通道ID
		body[0] = channelID;

		byte[] shootCommand = BytesUtil.int2bytes2(((T808_0x8801) message.getMessageBody()).getShootCommand());// 拍摄命令
		body[1] = shootCommand[0];
		body[2] = shootCommand[1];

		byte[] recordTime = BytesUtil.int2bytes2(((T808_0x8801) message.getMessageBody()).getRecordTime());// 拍照间隔，录像时间
		body[3] = recordTime[0];
		body[4] = recordTime[1];

		byte keepSign = BytesUtil.parseIntToByte(((T808_0x8801) message.getMessageBody()).getKeepSign());// 保持标志
		body[5] = keepSign;

		byte resolution = BytesUtil.parseIntToByte(((T808_0x8801) message.getMessageBody()).getResolution());// 分辨率
		body[6] = resolution;

		byte imageQuality = BytesUtil.parseIntToByte(((T808_0x8801) message.getMessageBody()).getImageQuality());// 图像/视频质量
		body[7] = imageQuality;

		byte brightness = BytesUtil.parseIntToByte(((T808_0x8801) message.getMessageBody()).getBrightness());// 亮度
		body[8] = brightness;

		byte contrast = BytesUtil.parseIntToByte(((T808_0x8801) message.getMessageBody()).getContrast());// 对比度
		body[9] = contrast;

		byte saturability = BytesUtil.parseIntToByte(((T808_0x8801) message.getMessageBody()).getSaturability());// 饱和度
		body[10] = saturability;

		byte chrmaticity = BytesUtil.parseIntToByte(((T808_0x8801) message.getMessageBody()).getChrmaticity());// 色度
		body[11] = chrmaticity;

//		// 打印log
//		log.debug("messageID:0x8801|sim:" + ((T808_MessageHeader) message.getMessageHeader()).getSimNum() + "|runningNum:"
//				+ ((T808_MessageHeader) message.getMessageHeader()).getRunningNum() + "|ChannelID:"
//				+ ((T808_0x8801) message.getMessageBody()).getChannelID() + "|ShootCommand:"
//				+ ((T808_0x8801) message.getMessageBody()).getShootCommand() + "|RecordTime:"
//				+ ((T808_0x8801) message.getMessageBody()).getRecordTime() + "|KeepSign:" + ((T808_0x8801) message.getMessageBody()).getKeepSign()
//				+ "|Resolution:" + ((T808_0x8801) message.getMessageBody()).getResolution() + "|ImageQuality:"
//				+ ((T808_0x8801) message.getMessageBody()).getImageQuality() + "|Brightness:"
//				+ ((T808_0x8801) message.getMessageBody()).getBrightness() + "|Contrast:" + ((T808_0x8801) message.getMessageBody()).getContrast()
//				+ "|Saturability:" + ((T808_0x8801) message.getMessageBody()).getSaturability() + "|Chrmaticity:"
//				+ ((T808_0x8801) message.getMessageBody()).getChrmaticity());

		// 消息头
		byte[] length = BytesUtil.int2bytes2(12);
		head[2] = length[0];
		head[3] = length[1];

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

		return mes;
	}

}