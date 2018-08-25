package com.ex.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private ConnectionFactory() {
		super();
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
			return conn;
		}catch (SQLException sql) {
			System.err.println(("SQL State: " + sql.getSQLState()));
			System.err.println("Error Code: " + sql.getErrorCode());
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}


 	public static void main(String[] args) {
 		Connection conn = ConnectionFactory.getConnection();
 		System.out.print(conn);
 	}
}