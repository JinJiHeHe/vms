package com.et.terminalserver.common.server;

public interface Server {
	
	boolean init(Object param);
	
	boolean start(Object param);

	boolean stop(Object param);
	
}
