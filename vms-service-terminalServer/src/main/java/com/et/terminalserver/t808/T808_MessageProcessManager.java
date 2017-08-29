package com.et.terminalserver.t808;

import com.et.terminalserver.t808.process.*;
import com.et.terminalserver.t808.util.T808_Util;

/**
 * @Project: CNPC_VMS
 * @Title: 808协议处理管理器
 * @Description: 808协议处理管理器
 * @author: lijz
 * @date: 2014年3月21日 上午11:12:44
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public enum T808_MessageProcessManager {
	
	T808_0x0001(new T808_0x0001_Process()),
	// 终端应答
	T808_0x0002(new T808_0x0002_Process()),
	// 终端心跳
	T808_0x0003(new T808_0x0003_Process()),
	// 终端注销
	T808_0x0100(new T808_0x0100_Process()),
	// 终端注册
	T808_0x0102(new T808_0x0102_Process()),
	// 终端注销
	T808_0x0104(new T808_0x0104_Process()),
	// 查询终端参数应答
	T808_0x0200(new T808_0x0200_Process()),
	// 位置上报
	T808_0x0201(new T808_0x0201_Process()),
	// 指令位置上报
	T808_0x0301(new T808_0x0301_Process()),
	// 事件报告
	T808_0x0302(new T808_0x0302_Process()),
	// 提问应答
	T808_0x0303(new T808_0x0303_Process()),
	// 信息点播与取消
	T808_0x0500(new T808_0x0500_Process()),
	// 车辆控制应答
	T808_0x0700(new T808_0x0700_Process()),
	// 行驶记录数据上传
	T808_0x0701(new T808_0x0701_Process()),
	// 电子运单上报
	T808_0x0702(new T808_0x0702_Process()),
	// 盲区补报
	T808_0x0704(new T808_0x0704_Process()), 
	// 驾驶员身份上报
	T808_0x0800(new T808_0x0800_Process()),
	// 多媒体事件信息上报
	T808_0x0801(new T808_0x0801_Process()),
	// 多媒体数据上传
	T808_0x0802(new T808_0x0802_Process()),
	// 存储多媒体数据检索应答
	T808_0x0900(new T808_0x0900_Process()),
	// 透行上传
	T808_0x0901(new T808_0x0901_Process()),
	// 压缩上报
	T808_0x8001(new T808_0x8001_Process()),
	// 平台通用应答
	T808_0x8100(new T808_0x8100_Process()),
	// 终端注册应答
	T808_0x8103(new T808_0x8103_Process()),
	// 设置终端参数
	T808_0x8104(new T808_0x8104_Process()),
	// 查询终端参数
	T808_0x8105(new T808_0x8105_Process()),
	// 终端控制
	T808_0x8201(new T808_0x8201_Process()),
	// 位置信息查询
	T808_0x8202(new T808_0x8202_Process()),
	// 位置信息查询
	T808_0x8203(new T808_0x8203_Process()),	
	// 临时位置跟踪控制
	T808_0x8300(new T808_0x8300_Process()),
	// 文本信息下发
	T808_0x8301(new T808_0x8301_Process()),
	// 事件设置
	T808_0x8302(new T808_0x8302_Process()),
	// 提问下发
	T808_0x8303(new T808_0x8303_Process()),
	// 信息点播菜单设置
	T808_0x8304(new T808_0x8304_Process()),
	// 信息服务
	T808_0x8400(new T808_0x8400_Process()),
	// 电话回拨
	T808_0x8401(new T808_0x8401_Process()),
	// 设置电话本
	T808_0x8500(new T808_0x8500_Process()),
	// 车辆控制
	T808_0x8600(new T808_0x8600_Process()),
	// 设置圆形区域
	T808_0x8601(new T808_0x8601_Process()),
	// 删除圆形区域
	T808_0x8602(new T808_0x8602_Process()),
	// 设置矩形区域
	T808_0x8603(new T808_0x8603_Process()),
	// 删除矩形区域
	T808_0x8604(new T808_0x8604_Process()),
	// 设置多边形区域
	T808_0x8605(new T808_0x8605_Process()),
	// 删除多边形区域
	T808_0x8606(new T808_0x8606_Process()),
	// 设置路线
	T808_0x8607(new T808_0x8607_Process()),
	// 删除路线
	T808_0x8700(new T808_0x8700_Process()),
	// 行驶记录仪数据采集命令
	T808_0x8701(new T808_0x8701_Process()),
	// 行驶记录仪参数下达命令
	T808_0x8800(new T808_0x8800_Process()),
	// 多媒体数据上传应答
	T808_0x8801(new T808_0x8801_Process()),
	// 存储多媒体数据上传
	T808_0x8802(new T808_0x8802_Process()),
	// 存储多媒体数据检索
	T808_0x8803(new T808_0x8803_Process()),
	// 存储多媒体数据上传
	T808_0x8804(new T808_0x8804_Process()),
	// 录音开始命令
	T808_0x8805(new T808_0x8805_Process());
	// 单条存储多媒体数据检索上传命令

	// 消息处理
	private T808_Process<?,?> process;

	/**
	 * @Description:构造方法
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	private <A extends T808_MessageHeader, B extends T808_MessageBody> T808_MessageProcessManager(
			T808_Process<A, B> process) {
		this.process = process;
	}

	/**
	 * @Description:获取解析类
	 * @param :args
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <A extends T808_MessageHeader, B extends T808_MessageBody> T808_Process<A, B> getProcess(
			int messgeID) {
		String key = T808_Util.hexToUpperCaseString(messgeID);
		return (T808_Process<A, B>) T808_MessageProcessManager.valueOf(key).process;
	}

}
