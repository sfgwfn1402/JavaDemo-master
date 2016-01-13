package com.andieguo.callback.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Function: �־ò�callbackʵ�� <br/>
 * 
 * @author duwei
 */
public class Dao {
	/**
	 * callback�ӿ�
	 */
	interface CallBack {
		Object doIt(Connection conn) throws SQLException;
	}

	/**
	 * �������ݿ�(��ѯ��)<br>
	 * �����ֻص�ģʽ��openConnection()��closeConnection()������Ƭ���Ӵ����а��������ʹ���븴���Ը�ǿ��Ҳ�����
	 */
	private Object execute(CallBack callback) throws SQLException {
		// ������
		Connection conn = openConnection();
		try {
			return callback.doIt(conn);
		} finally {
			// �ر�����
			closeConnection(conn);
		}
	}

	/**
	 * ��ѯҵ��
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
