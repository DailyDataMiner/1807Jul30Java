package com.Rev.assoc.Proj0.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
	public Connection getConnection() {
		Connection conn = null; // will instantiate in a try block
		Properties prop = new Properties();
		String path = "C:/Users/Student0011/Documents/watchme/R1/Local_git_staging_ground/1807Jul30Java/Week2/jdbc/bookstore-jdbc/src/main/resources/application.properties";
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver")); //prop.getproperty("Driver") is returning oracle.jdbc.driver.OracleDriver
			/* The DriverManager provides a basic service for managing a 
			 * set of JDBC drivers. As part of its initialization, the 
			 * DriverManager class will attempt to load the driver classes
			 * referenced in the jdbc.drivers system property
			 */
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"),
					prop.getProperty("pwd"));
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	
	}
	
}
