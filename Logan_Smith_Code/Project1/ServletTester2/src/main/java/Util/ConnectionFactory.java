package Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	/*
	 * Establish a connection with DB. Singleton design. In order to establish, we
	 * need 4 things: Driver, URL, username, password
	 */

	private static ConnectionFactory cf = null;
	private static boolean build = true;

	private ConnectionFactory() {
		build = false;
	}

	public static synchronized ConnectionFactory getInstance() {
		if (build)
			cf = new ConnectionFactory();
		return cf;
	}

	/*
	 * 
	 * Connection
	 * -manages out connection to the database
	 * -Allows us to execute SQL statements and return results
	 * -Has information about db tables, sotred procedures, and oher details of the db
	 * -Use getMetaData() method
	 */
	
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		String path = "C:/Users/lorga/my_git_repos/1807Jul30Java/Logan_Smith_Code/Project1/ServletTester2/src/main/resources/application.properties";
		try {
			prop.load(new FileReader(path));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"),
					prop.getProperty("pwd"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("SQL state: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

		return conn;
	}
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.getConnection();
		System.out.println(conn);
	}
	
}