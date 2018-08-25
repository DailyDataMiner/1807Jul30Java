package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ex.model.User;
import com.ex.model.UserInfo;
import com.ex.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance;

	private UserDaoImpl() {
	}

	public static UserDaoImpl getInstance() {
		if (instance == null)
			instance = new UserDaoImpl();
		return instance;
	}

	@Override
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement cs = conn.prepareStatement("select GET_USER_HASH(?,?) as HASH from dual");
			cs.setString(++index, user.getUsername());
			cs.setString(++index, user.getPassword());
			ResultSet rs = cs.executeQuery();
			if (rs.next())
				return rs.getString("HASH");
		} catch (SQLException sql) {
			System.err.println(sql.getSQLState());
			System.err.println(sql.getErrorCode());
		}
		return null;
	}

	@Override
	public UserInfo getUserInfo(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement(
					"Select username, firstname, lastname, email from example_user_information where username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return new UserInfo(rs.getString("username"), rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("email"));
		} catch (SQLException sql) {
			System.err.println("Sql state gui: " + sql.getSQLState());
			System.err.println("Sql error gui: " + sql.getErrorCode());

		}
		return null;
	}

	@Override
	public User getUser(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("Select * from example_users where username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return new User(rs.getString(1), rs.getString(2));
		} catch (SQLException sql) {
			System.err.println("Sql state gu: " + sql.getSQLState());
			System.err.println("Sql error gu: " + sql.getErrorCode());

		}
		return null;

	}

	public static void main(String[] args) {
		System.out.println(UserDaoImpl.getInstance().getUser("Mike").toString());
		System.out.println(UserDaoImpl.getInstance().getUserInfo("Mike").toString());
	}

}
