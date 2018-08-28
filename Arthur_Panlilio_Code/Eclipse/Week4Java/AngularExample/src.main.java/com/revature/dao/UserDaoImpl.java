package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.models.UserInformation;
import com.revature.utl.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	
	private static UserDaoImpl instance;
	
	private UserDaoImpl() {
		
	}
	
	public static UserDaoImpl getInstance() {
		if(instance == null) 
			instance = new UserDaoImpl();
		return instance;
	}

	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement cs = conn.prepareStatement("SELECT GET_USER_HASH(?,?) as HASH FROM DUAL");
			cs.setString(++index, user.getUsername());
			cs.setString(++index, user.getPassword());
			ResultSet rs = cs.executeQuery();
			if(rs.next()) 
				return rs.getString("HASH");
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}

	@Override
	public UserInformation getUserInformation(String username) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT username, firstname, lastname, email FROM example_user_information WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return new UserInformation(rs.getString("username"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"));
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}
	
	

	@Override
	public User getUser(String username) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM example_users WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getString(1), rs.getString(2));
			}
		}catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		return null;
	}
	
	public static void main(String[] args) {
		
	}

}
