package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ConnectionFactory is actually a singleton that gets connections
 * 
 * @author Arthur Panlilio
 *
 */
public class ConnectionFactory {
	
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
		
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(build) {
			cf = new ConnectionFactory();
		}
		return cf;
	}
	
	public static Connection getConnection() {
		Connection conn = null; //Will instantiate in a try block 
		Properties prop = new Properties();
		//Can change between 'ApplicationOffline' and 'Application' for a local database and aws
		String path = "C:/Users/Panli/my_git_repos/1807Jul30Java/Arthur_Panlilio_Code/Projects/Project0/Project0/src/main/resources/Application.properties";
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));
			/*The DriverManager provides a basic service for ma
			 * set of JDBC drivers. As part of its initialization
			 * DriverManager class will attempt to load the driv
			 */
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("usr"), 
					prop.getProperty("pwd"));
		} catch(FileNotFoundException e) {	
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
