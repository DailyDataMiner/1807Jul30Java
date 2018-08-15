package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.JDBCConnection;
import model.BankUser;

//Singleton class: to ensure there's only one connection
public class UserDaoImplement implements UserDao{

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

}
