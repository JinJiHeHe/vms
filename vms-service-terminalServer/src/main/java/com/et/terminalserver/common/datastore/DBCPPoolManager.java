package com.et.terminalserver.common.datastore;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.impl.GenericObjectPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Project CNPC_VMS
 * @Title DBCPPoolManager
 * @Description 数据库连接池管理
 * @author zhouyu
 * @date 2014年8月7日 上午9:22:29
 * @company Beijing Huayou Information andCommunication Technology Co.,Ltd
 * @Copyright Copyright (c) 2014
 * @version V2.0
 */
public class DBCPPoolManager implements IPoolManager {
	// private static DBCPPoolManager poolManager = null;// 管理单例
	private DataSource ds; // 数据源
	private ObjectPool connectionPool; // 连接池
	// private static String configFilePath;
	private String driver = "oracle.jdbc.OracleDriver";// 驱动
	private String url = "jdbc:oracle:thin:@//10.185.161.74:1521:c5testdb";// URL
	private String name = "c5web",// 用户名
			password = "c5web";// 密码

	boolean logAbandoned = true;// 是否在自动回收超时连接的时候打印连接的超时错误
	boolean removeAbandoned = true;// 是否自动回收超时连接

	int initialSize = 10;// 初始化连接
	int maxIdle = 20;// 最大空闲连接
	int minIdle = 5;// 最小空闲连接
	int maxActive = 50;// 最大连接数量
	int removeAbandonedTimeout = 180;// 超时时间(以秒数为单位)
	int maxWait = 1000;// 超时等待时间以毫秒为单位 6000毫秒/1000等于60秒

	// 实例化log4j
	private static Log log = LogFactory.getLog(DBCPPoolManager.class);

	/**
	 * @Description 初始化
	 */
	public void init() {

		try {
			System.out.println(driver);
			Class.forName(driver);
			// 连接池初始化
			connectionPool = new GenericObjectPool(null, maxActive, (byte) 1,
					maxWait, maxIdle, minIdle, true, true, 1000, 5, 5000, true);

			// 连接工厂创建
			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
					url, name, password);
			// 连接测试
			new PoolableConnectionFactory(connectionFactory, connectionPool,
					null, "select count(*) from dual", false, true);
			// 创建数据源
			ds = new PoolingDataSource(connectionPool);
			log.info("JDBC Pool DataSource inited : " + driver + ";" + url
					+ ";" + name);
		} catch (Exception ex) {
			log.warn("JDBC Pool DataSource init failed!", ex);
		}
	}

	/**
	 * @Description 获取连接
	 */
	@Override
	synchronized public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/**
	 * @Description 关闭池
	 */
	@Override
	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
	}

	/**
	 * @Description 关闭连接
	 */
	@Override
	public void close() throws SQLException {
		try {
			connectionPool.close();
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogAbandoned() {
		return logAbandoned;
	}

	public void setLogAbandoned(boolean logAbandoned) {
		this.logAbandoned = logAbandoned;
	}

	public boolean isRemoveAbandoned() {
		return removeAbandoned;
	}

	public void setRemoveAbandoned(boolean removeAbandoned) {
		this.removeAbandoned = removeAbandoned;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getRemoveAbandonedTimeout() {
		return removeAbandonedTimeout;
	}

	public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

}
