package com.et.terminalserver.terminalaccess.protoloader;

import com.et.terminalserver.common.bus.BusListener;
import com.et.terminalserver.common.bus.Command;

/**
 * @Description 协议加载通道监听
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月8日 下午4:01:48
 * @mail terrorbladeyang@gmail.com
 */
public class ProtoLoaderListener implements BusListener {

	//协议加载处理类
	private ProtoLoad protoLoader;

	/**
	 * 通道监听接口实现
	 * */
	@Override
	public void commandReceived(Command command, String connectName) {

		switch (command.getCode()) {
		case 1://动态加载
			break;
		default:
			break;
		}

	}

	public ProtoLoad getProtoLoader() {
		return protoLoader;
	}

	public void setProtoLoader(ProtoLoad protoLoader) {
		this.protoLoader = protoLoader;
	}

}
