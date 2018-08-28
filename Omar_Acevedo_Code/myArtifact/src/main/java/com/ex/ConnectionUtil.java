package com.ex;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.ex.ConnectionUtil;

public class ConnectionUtil {

	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() {

		Connection conn = null;
		
		try {
			
			Properties props = new Properties();
			
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
//			Class.forName(props.getProperty("driver"));
				
				conn = DriverManager.getConnection( props.getProperty("url"), 
													props.getProperty("usr"),
													props.getProperty("pwd"));
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
			
		} catch(SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionUtil.getConnection();
		System.out.println(conn);
	}
	
}
