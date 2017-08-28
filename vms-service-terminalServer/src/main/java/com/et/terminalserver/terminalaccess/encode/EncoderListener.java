package com.et.terminalserver.terminalaccess.encode;


import com.et.terminalserver.common.bus.BusListener;
import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.terminalaccess.netty.Packet;

/**
 * @Description 编码通道监听类
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月7日 下午5:33:53
 * @mail terrorbladeyang@gmail.com
 */
public class EncoderListener implements BusListener {

	// 编码处理接口
	Encode encoder;

	/**
	 * 通道监听接口实现方法
	 * */
	@Override
	public void commandReceived(Command command, String connectName) {

		// 拿到接收到的包
		Packet packet = (Packet) command.getParam();

		// 接口处理
		encoder.encode(packet);
	}

	public void setEncoder(Encoder encoder) {
		this.encoder = encoder;
	}

}
