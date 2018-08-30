package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.ers.pojos.User;
import com.ers.utils.ConnectionFactory;

public class UserDaoImplementation implements UserDao<User> {

	@Override
	public String getUserPW_hash(User userObj) {

		String hashValue = "";
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String getHashValueFn = "{ ? = call get_user_hash(?, ?) }";
			
			CallableStatement cStatement = conn.prepareCall(getHashValueFn);
			
// 			TransactionDao from bankapp0-jdbc
			cStatement.registerOutParameter(1, Types.VARCHAR);	
			cStatement.setString(2, userObj.getUsername());
			cStatement.setString(3, userObj.getPassword());
			
			cStatement.execute();
			
			hashValue = cStatement.getString(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hashValue;
	}

	@Override
	public User getUserInfo(String username) {
		
		int index = 0;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
//			PreparedStatement stmt = conn.prepareStatement("select user_id, username, password, user_role_id from p1_users where username = ?");
			String sql = "select user_id, username, password, user_role_id, ";
			sql += "(select rolename from p1_user_roles where p1_user_roles.user_role_id = p1_users.user_role_id) as user_role_name ";
			sql += "from p1_users where username = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			
			System.out.println("We are in getUser: username -> " + username);
			
			if (rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " +rs.getInt(4) + ", " + rs.getString(5));
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
			
		} catch (SQLException sql) {
			System.err.println("SQL State: " + sql.getSQLState());
			System.err.println("Error Code: " + sql.getErrorCode());
		}
		
		return null;
	}

}
