/**
 * 2016-07-09
 * @author 罗伟凡
 * 数据库连接
 * */
package com.pratra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @数据库连接类
 * @技术：反射机制
 */
public class DBUtil {
	private DBUtil() {
	}

	private static String url = "jdbc:mysql://localhost:3306/db_pratra";
	private static String user = "root";
	private static String pass = "123";

	static {
		try {
			// 注册驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	// 创建连接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	// 关闭相关配置
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
