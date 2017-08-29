package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x0901
 * @Description: 数据压缩上报
 * @author: guanhl
 * @date: 2014年8月6日 下午6:54:53
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x0901 extends T808_MessageBody {

	private int length;// 0 压缩消息长度 DWORD
	private byte[] zipfile;// 4 压缩消息体 压缩消息体为需要压缩的消息经过GZIP压缩算法后的消息。

	/**
	 * @Description 获得 length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @Description:设置 length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @Description 获得 zipfile
	 */
	public byte[] getZipfile() {
		return zipfile;
	}

	/**
	 * @Description:设置 zipfile
	 */
	public void setZipfile(byte[] zipfile) {
		this.zipfile = zipfile;
	}

	public T808_0x0901() {
	}

}
