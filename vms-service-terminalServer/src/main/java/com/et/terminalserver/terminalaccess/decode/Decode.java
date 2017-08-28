package com.et.terminalserver.terminalaccess.decode;

import com.et.terminalserver.protocols.business.bo.BusinessObject;
import com.et.terminalserver.terminalaccess.netty.Packet;

/**
 *  解码接口
 * */
public interface Decode {

	BusinessObject decode(Packet packet);

}
