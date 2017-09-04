package com.et.terminalserver.terminalaccess.web.pushgps;


import com.et.terminalserver.common.bus.BusListener;
import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.protocols.business.bo.TUGpsInfo;

/**
 * @Description web接收gps点的监听
 * @author jakiro
 * @version V1.0
 * @Date 2016年4月9日 上午1:12:44
 * @mail terrorbladeyang@gmail.com
 */
public class WebReceiveListener implements BusListener {
      //处理类
	  WebReceive webReceiveHandler;

	/**
	 * 接收指令的通道接口实现类
	 * */
	@Override
	public void commandReceived(Command command, String connectName) {
		//pushToRedisHandler.pubToRedis((TUGpsInfo) command.getParam());
         webReceiveHandler.pushGpsToWeb((TUGpsInfo) command.getParam());
	}

	public WebReceive getWebReceiveHandler() {
		return webReceiveHandler;
	}

	public void setWebReceiveHandler(WebReceive webReceiveHandler) {
		this.webReceiveHandler = webReceiveHandler;
	}
}
