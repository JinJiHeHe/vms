package com.et.terminalserver.terminalaccess.protoloader;


public interface ProtoLoad {

	/**
	 * 根据目录读取多个jar包
	 * 
	 * @param dir
	 *            目录
	 * @return
	 */
	void loadProtocolsInDir(String dir);

	/**
	 * 根据指定jar包位置读取jar包
	 * 
	 * @param path
	 *            位置
	 */
	void loadProtocolByPath(String path);


	/**
	 * 不使用已加载的协议
	 * 
	 * @param protocolName
	 *            协议
	 */
	void dropProtocol(String protocolName);

}
