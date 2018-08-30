//package com.ex.util;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class ConnectionFactory {
//	
//	private static ConnectionFactory cf = null;
//	private static Boolean build = true;
//	
//	private ConnectionFactory() {
//		build = false;
//	}
//	
//	public static synchronized ConnectionFactory getInstance() {
//		if(build) cf = new ConnectionFactory();
//		return cf;
//	}
//	
//	// CONNECTION
//	public Connection getConnection() {
//		Connection conn = null;
//		Properties prop = new Properties();
//		String path = "/Users/mollymerritt/my_git_repos/1807Jul30Java/"
//				+ "Molly_Merritt_Code/Week3and4/java_workspace/project1v1/src/main/"
//				+ "resources/application.properties";
//		try {
//			prop.load(new FileReader(path));
//			Class.forName(prop.getProperty("driver"));
//			conn = DriverManager.getConnection(
//					prop.getProperty("url"),
//					prop.getProperty("usr"),
//					prop.getProperty("pwd"));
//		
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return conn;
//	
//	}
//
//}

package com.ex.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static ConnectionFactory cf = null;
	private static Boolean build = true;

	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(build) cf = new ConnectionFactory();
		return cf;
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties props = new Properties();
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(
					"application.properties"));	// different way to do this
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty(
					"usr"), props.getProperty("pwd"));
			return conn;
		} catch(SQLException e) {
//			System.err.println("SQL State: " + sql.getSQLState());
//			System.err.println("Error Code: " + sql.getErrorCode());
			e.printStackTrace();
		} catch(IOException e) {
//			ioe.printStackTrace();
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
		System.out.println(conn);
	}

	
}
