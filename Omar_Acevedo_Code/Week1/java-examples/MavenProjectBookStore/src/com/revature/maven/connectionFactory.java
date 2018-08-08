package com.revature.maven;

public class connectionFactory {
	
	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if (build) cf = new ConnectionFactory();
		return cf;
	}
	
	public Connection getConnetion() {
		Connection conn = null;
		Properties prop = new Properties();
		
	}
	
	// DriverManager class will attempt to load the driver...
	// referenced in the jdb.drivers system property...
	conn = DriverManager.getConnection(
			
			);
	
	
}
