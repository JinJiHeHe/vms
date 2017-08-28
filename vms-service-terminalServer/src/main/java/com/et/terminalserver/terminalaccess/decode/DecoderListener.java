package com.et.terminalserver.terminalaccess.decode;

import com.et.terminalserver.common.bus.BusListener;
import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.terminalaccess.netty.Packet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 解码通道监听类 
 * */
public class DecoderListener implements BusListener {
    
	//监听
	Log log = LogFactory.getLog(DecoderListener.class);
	//解码接口
	Decode decoder;

	/**
	 * 通道监听接口方法实现 
	 * */
	@Override
	public void commandReceived(Command command, String connectName) {
        
		// 这里拿到数据包对象
		Packet packet = (Packet) command.getParam();
		// 调用解析方法
		decoder.decode(packet);

	}

	public void setDecoder(Decode decoder) {
		this.decoder = decoder;
	}

}
