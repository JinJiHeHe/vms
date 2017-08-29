package com.et.terminalserver.common.datastore;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Project CNPC_VMS
 * @Title IPoolManager
 * @Description 连接池管理接口
 * @author guanhl
 * @date 2014年8月7日 上午9:23:07
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public interface IPoolManager {

	/**
	 * @Description 获取数据库连接
	 */
	public Connection getConnection() throws SQLException;

	/**
	 * @Description 关闭连接
	 */
	public void closeConnection(Connection conn) throws SQLException;

	/**
	 * @Description 关闭池
	 */
	public void close() throws SQLException;
}
