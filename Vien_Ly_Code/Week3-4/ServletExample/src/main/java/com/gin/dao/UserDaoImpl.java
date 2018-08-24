package com.gin.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gin.models.User;
import com.gin.models.UserInformation;
import com.gin.utils.ConnectionFactory;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
	}

	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select GET_USER_HASH(?, ?) AS HASH from dual");
			ps.setString(++index, user.getUsername());
			ps.setString(++index, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString("HASH");
			}
		} catch (SQLException e) {
			System.err.println("sql state: " + e.getSQLState());
			System.err.println("code: " + e.getErrorCode());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserInformation getUserInformation(String user) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from example_user_information where username = ?");
			ps.setString(++index, user);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new UserInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			System.err.println("sql state: " + e.getSQLState());
			System.err.println("code: " + e.getErrorCode());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select * from example_users where username = ?");
			ps.setString(++index, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			System.err.println("sql state: " + e.getSQLState());
			System.err.println("code: " + e.getErrorCode());
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(new UserDaoImpl().getPasswordHash(new User("vien", "ly")));
	}
}
