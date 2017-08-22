package com.et.terminalserver.t808.messagebody;

import com.et.terminalserver.t808.T808_MessageBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: CNPC_VMS
 * @Title: T808_0x8105
 * @Description: 终端控制
 * @author: lijz
 * @date: 2014年5月4日 下午4:54:24
 * @company: Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright: Copyright (c) 2014
 * @version V2.0
 */
public class T808_0x8105 extends T808_MessageBody {
	// 0 命令字 BYTE 终端控制命令字说明见表14
	// 1 命令参数 STRING 命令参数格式具体见后血描述，每个字段之间采用半角”;”分隔，每个STRING字段先按GBK编码处理后再组成消息
	// 表14终端控制命令字说明
	// 起始字节 命令参数 描述及要求
	// 1 命令参数格式见表15
	// 无线升级。参数之问采用半角分号分隔。指令如下：“地址;拨号点名称；拨号川户名;拨号密码；地址；TCP端口；UDP端口；制造商ID；硬件版本；固件版本；连接到指定服务器时限”，若某个参数无值，则放空
	// 2 命令参数格式见表15 控制终端连接指定服务器。参数之间采用半角分号分隔。控
	// 制指令如下：“连接控制；监管平台鉴权码；拨号点名称；拨号用户名；拨号密码；地址；TCP端口；UDP端口；连接到指定服务器时限”，若某个参数无值，则放空，若连接控制值为1，则无后继参数
	// 3 无 终端关机
	// 4 无 终端复位
	// 5 无 终端恢复出厂设置
	// 6 无 关闭数据通信
	// 7 无 关闭所有无线通信
	//
	// 表15 命令参数格式
	// 字段 数据类型 描述及要求
	// 连接控制 BYTE 0：切换到指定监管平台服务器，连按到该服务器后即进
	// 入应急状态，此状态下仅有下发控制指令的监管平台可发送包括短信在内的控制指令：1：切换回原缺省监控平台服务器，并恢复正常状态。
	// 拨号点名称 STRING 一般为服务器APN，无线通信拨号访问点，若网络制式为CDMA，则该值为PPP连接拨号号码
	// 拨号用户名 STRING 服务器无线通信拨号用户名
	// 拨号密码 STRING 服务器无线通信拨号密码
	// 地址 STRING 服务器地址，IP或域名
	// TCP端口 WORD 服务器TCP端口
	// UDP端口 WORD 服务器UDP端口
	// 制造商ID BYTE[5] 终端制造商编码
	// 监管平台鉴权码 STRING 监管平台下发的鉴权码，仅用于终端连接到.监管平台之后的鉴权，终端连接回原监控平台还用原鉴权码
	// 硬件版本 STRING 终端的硬件版本号，由制造商自定
	// 固件版本 STRING 终端的固件版本号，由制造商自定
	// URL地址 STRING 完整URL地址
	// 连接到指定服务
	// 器时限 WORD
	// 单位:分(min),值非0表示在终端接收到升级或连接指定服务器指令后的有效期截止前，终端应连回原地址。若值为0，则表示一直连接指定服务器
	private int command;// 命令字 BYTE
	// private String commandParams;
	private List<String> list;// 命令参数 STRING

	/**
	 * @Description 获得 command
	 */
	public int getCommand() {
		return command;
	}

	/**
	 * @Description:设置 command
	 */
	public void setCommand(int command) {
		this.command = command;
	}

	/**
	 * @Description 获得 list
	 */
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public T808_0x8105() {
		this.list = new ArrayList<String>();
	}

}
