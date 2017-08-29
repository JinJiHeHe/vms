package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8607
 * @Description: 删除路线类
 * @author: lijz
 * @date: 2014年5月6日 下午5:32:26
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8607 extends T808_MessageBody {

	private List<Integer> list;// 0 路线数 BYTE
								// 本条消息中，包含的区域数，不超过125个，多于125个建议用多条消息，0为删除所有矩形区域

	// 1 路线ID1 DWORD
	// …… DWORD
	// 路线IDn DWORD

	/**
	 * @Description 获得list
	 */
	public List<Integer> getList() {
		return list;
	}

	public T808_0x8607() {
		this.list = new ArrayList<Integer>();
	}

}
