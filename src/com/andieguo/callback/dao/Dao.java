package com.andieguo.callback.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Function: 持久层callback实现 <br/>
 * 
 * @author duwei
 */
public class Dao {
	/**
	 * callback接口
	 */
	interface CallBack {
		Object doIt(Connection conn) throws SQLException;
	}

	/**
	 * 操作数据库(查询等)<br>
	 * 用这种回调模式把openConnection()和closeConnection()做了切片，从代码中剥离出来，使代码复用性更强，也更简洁
	 */
	private Object execute(CallBack callback) throws SQLException {
		// 打开连接
		Connection conn = openConnection();
		try {
			return callback.doIt(conn);
		} finally {
			// 关闭连接
			closeConnection(conn);
		}
	}

	/**
	 * 查询业务
	 */
	public Object sqlQuery(final String sql) throws SQLException {
		return execute(new CallBack() {
			@Override
			public Object doIt(Connection conn) throws SQLException {
				return conn.createStatement().execute(sql);
			}
		});
	}

	public Connection openConnection() throws SQLException {
		return DriverManager.getConnection("", null);
	}

	public void closeConnection(Connection conn) throws SQLException {
		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
}
