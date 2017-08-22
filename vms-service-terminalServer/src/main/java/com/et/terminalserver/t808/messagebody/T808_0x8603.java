package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8603
 * @Description: 删除矩形区域
 * @author: lijz
 * @date: 2014年5月6日 下午4:58:53
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8603 extends T808_MessageBody{

	private List<Integer> list;// 0 区域数 BYTE
								// 本条消息中，包含的区域数，不超过125个，多于125个建议用多条消息，0为删除所有矩形区域

	// 1 区域ID1 DWORD
	// …… DWORD
	// 区域IDn DWORD

	/**
	 * @Description 获得 overspeedContinueTime
	 */
	public List<Integer> getList() {
		return list;
	}

	public T808_0x8603() {
		this.list = new ArrayList<Integer>();
	}

}
