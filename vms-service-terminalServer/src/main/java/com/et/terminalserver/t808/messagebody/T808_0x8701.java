package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8701
 * @Description: 行驶记录仪参数下达命令类
 * @author: lijz
 * @date: 2014年6月1日 上午9:24:45
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8701 extends T808_MessageBody {
	private Map<String, String[]> mapContent;

	/**
	 * 行驶记录仪参数下传 0x8701 指令参数: 1、 设置驾驶员代码、驾驶证号码；（0x81） 2、
	 * 设置记录仪中的车辆VIN号、车牌号码、分类；（0x82） 3、 设置记录仪时钟；（0xC2） 4、 设置车辆特征系数。（0xC3）
	 */
	public Map<String, String[]> getMapContent() {
		return mapContent;
	}

	public T808_0x8701() {
		this.mapContent = new TreeMap<String, String[]>();
	}

}
