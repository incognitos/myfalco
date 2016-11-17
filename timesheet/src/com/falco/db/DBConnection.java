package com.falco.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Gino Juliano Please remember to always close the database Connection
 */
public class DBConnection {
	private Connection conn;

	public DBConnection() {
	}

	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conn = DriverManager.getConnection(
				"<url>",
				"<user>", "<pass>");
		return conn;
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}
}