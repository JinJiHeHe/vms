
package com.et.terminalserver.common.util;

import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author hadoop
 * 
 */
public class DBUtils {

	private DataSource ds = null;
	private QueryRunner runner = null;

	public DBUtils() {
		try {
			this.ds = DbPoolConnection.getInstance().getDataSource();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (this.ds != null) {
			this.runner = new QueryRunner(this.ds);
		}
	}

	public DBUtils(DataSource ds) {
		this.ds = ds;
		this.runner = new QueryRunner(this.ds);
	}

	public QueryRunner getRunner() {
		return this.runner;
	}


}
