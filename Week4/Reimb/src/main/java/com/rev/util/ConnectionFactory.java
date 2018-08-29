package com.rev.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	/*
	 * Class used to establish a connection with DB
	 * Uses *lazy* singleton design pattern as to return 
	 * 		same single connection each time one is
	 * 		requested. 
	 * In order to establish a connection, we need 4 
	 * things: Driver, URL(location of DB), username, pw
	 */

	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(build) cf = new ConnectionFactory();
		return cf;
	}
	
	/*
	 * Connection
	 *  -manages our connection to (session with) the database
	 *  -allows us to execute
	 */
	
	public Connection getConnection() {
		Connection conn = null; // will instantiate in a try block
		Properties prop = new Properties();
		String path = "C:\\Users\\knisp\\my_git_repos\\1807Jul30Java\\Week4\\Reimb\\src\\main\\resources\\application.properties";
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver")); //is returning oracle.jdbc.driver.OracleDriver
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
			//System.out.println("cant find it");
			e.printStackTrace();
		} catch (IOException e) {
			//System.out.println("ioexception");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	
	}
}