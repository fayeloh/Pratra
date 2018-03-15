/**
 * 2016-07-09
 * @author ��ΰ��
 * ���ݿ�����
 * */
package com.pratra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @���ݿ�������
 * @�������������
 */
public class DBUtil {
	private DBUtil() {
	}

	private static String url = "jdbc:mysql://localhost:3306/db_pratra";
	private static String user = "root";
	private static String pass = "123";

	static {
		try {
			// ע������
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	// ��������
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	// �ر��������
	public static void free(Connection conn, Statement stat, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
