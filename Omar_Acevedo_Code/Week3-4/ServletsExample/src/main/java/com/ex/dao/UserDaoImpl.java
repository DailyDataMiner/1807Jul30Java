package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.model.User;
import com.ex.model.UserInformation;
import com.ex.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance;
	private UserDaoImpl() {}
	
	public static UserDaoImpl getInstance() {
		
//		v1
//		if (instance == null)
//			instance = new UserDaoImpl();
//		return instance;

//		v2
		return (instance = (instance == null) ? new UserDaoImpl() : instance);
		
	}
	
	@Override
	public String getPasswordHash(User user) {
		
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			
//			CallableStatement cs = conn.prepareCall("{ GET_USER_HASH(?, ?) } ");
			
			PreparedStatement cs = conn.prepareStatement("select GET_USER_HASH(?, ?) as hash from dual");
			
			cs.setString(++index, user.getUsername());
			cs.setString(++index, user.getPassword());
			
			ResultSet rs = cs.executeQuery();
			
			if (rs.next()) {
				return rs.getString("hash");
			}
			
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		
		return null;
	}

	@Override
	public UserInformation getUserInformation(String username) {
		
		int index = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			PreparedStatement stmt = conn.prepareStatement("select username, firstname, lastname, email from example_user_information where username = ?");
			
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new UserInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(UserDaoImpl.getInstance().getPasswordHash(new User("omarace", "password")));
//		System.out.println(instance);
	}
	@Override
	public User getUser(String username) {
		
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			
//			PreparedStatement stmt = conn.prepareStatement("select * from example_users where username = ?");
			PreparedStatement stmt = conn.prepareStatement("select username, password from example_users where username = ?");
			
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			
			System.out.println("We are in getUser: username -> " + username);
			
			if (rs.next()) {
				System.out.println(rs.getString(1) + ", " + rs.getString(2));
				return new User(rs.getString(1), rs.getString(2));
			}
			
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		
		return null;
	}

}
