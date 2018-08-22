package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.JDBCConnection;
import model.BankUser;

//Singleton class: to ensure there's only one connection
public class UserDaoImplement implements UserDao{
	
	
	public int usernumber = 0;
	
	public static UserDaoImplement userDao;
	
	private UserDaoImplement() {};
	
	public static UserDaoImplement getDao() {
		if(userDao == null) {
			userDao = new UserDaoImplement();
		}
		return userDao;
	}

	public BankUser getUser(int userId) {
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			
			
			String sql = "Select * from bankuser where user_id = ?";
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setInt(1, userId); //1 is first ?   this set question mark value
			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
			
			//we might have multiple 
			
			while(rs.next()) {
				return new BankUser(
						rs.getInt("user_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("pass_word")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/*
	 * create new user
	 * */
	public void newUser(int user_id, String first_name, String last_name, String username, String password) {
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			String sql = "INSERT INTO BANKUSER (user_id, first_name, last_name, username, pass_word) VALUES (?, ?, ?, ?, ?)"; //insert inputs into DB
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setInt(1, user_id); //set 1st '?' to userid
			pss.setString(2, first_name); //set 2nd '?' to first_name
			pss.setString(3, last_name); // so on ...
			pss.setString(4, username); 
			pss.setString(5, password);
			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * update existing user password
	 * */
	public void updatePassword(int user_id,  String password) {
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			
			
			String sql = "UPDATE BANKUSER SET pass_word = ?  WHERE user_id = ?"; //insert inputs into DB
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setString(1, password);
			pss.setInt(2, user_id); //set 1st '?' to userid
			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * drop user account
	 * */
	public void deleteUser(int userId) {
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			
			
			String sql = "DELETE FROM BANKUSER WHERE user_id = ?";
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setInt(1, userId); //1 is first ?   this set question mark value
			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * get specific user through user name and password
	 * */
	public BankUser getSpecificUser(String userName, String password) {
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			
			String sql = "Select * from bankuser where username = ? and pass_word = ?";
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setString(1, userName); //1 is first ?   this set question mark value
			pss.setString(2, password);
			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
			
			while(rs.next()) {
				return new BankUser(
						rs.getInt("user_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("username"),
						rs.getString("pass_word")
						);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	/*
	 * get list of user name
	 * */
	public String[] existingUsernameList() {
		
		
		String[] arrUsernameList= new String[500];
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			
			String sql = "select Username from BankUser";
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
			
			int i = 0;
			while(rs.next()) {
				
//				System.out.println();
				arrUsernameList[i] = rs.getString("username");
				i++;
			}
			
			return arrUsernameList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * get total user#
	 * */
	public int getTotalUserNumberDao() {
			
			
			
			try {
				//make a connection to JDBC
				Connection conn = JDBCConnection.getInstance().getConnection();
				
				
				String sql = "SELECT COUNT(*) FROM bankuser";
				
				//connection object send sql statement string into database
				//pss is statement object , so that we can use it
				PreparedStatement pss = conn.prepareStatement(sql);
				
				ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
				
			
				while(rs.next()) {
					
	//				System.out.println();
					return rs.getInt("COUNT(*)");
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
	}
		
		
		
}
