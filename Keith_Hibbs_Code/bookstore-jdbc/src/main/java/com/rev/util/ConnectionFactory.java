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
 * Class used to establish a connection with DBUses Singleton design pattern as to return same single connection each time
 * one is requested.
 * 
 * In order to establish a connection, we need things:
 * Driver, URL(location ofDB), username, password 
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
	public Connection getConnection() {
Connection conn = null;
Properties prop = new Properties();
String path = "C:/Users/keith/my_git_repos/1807Jul30Java/Keith_Hibbs_Code/bookstore-jdbc/src/main/resources/application.properties";
	
try {
	prop.load(new FileReader(path));
	Class.forName(prop.getProperty("driver"));
	conn = DriverManager.getConnection(
			prop.getProperty("url"),
			prop.getProperty("usr"),
			prop.getProperty("pwd"));
			
} catch (FileNotFoundException e) {
	e.printStackTrace();}
	catch (IOException e) {
		e.printStackTrace();}
		catch (ClassNotFoundException e ) {
			e.printStackTrace();}
			catch (SQLException e) {
				e.printStackTrace();
			}
	return conn;	
	
	}
	}

	


	
	
