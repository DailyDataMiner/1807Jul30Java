package com.rev.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.User;
import com.rev.util.ConnectionFactory;

public class UserDao {

	public static List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from users";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				User temp = new User();

				temp.setUserid(rs.getInt(1));

				String firstName = rs.getString(2);
				temp.setFirstname(firstName);

				String lastName = rs.getString(3);
				temp.setLastname(lastName);

				String Username = rs.getString(4);
				temp.setUsername(Username);

				String UserPassword = rs.getString(5);
				temp.setUserpassword(UserPassword);

				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public static User findOne(Integer userid) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from users where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				u = new User();

				u.setUserid(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setUserpassword(info.getString(5));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static User findUser(String username) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				u = new User();

				u.setUserid(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setUserpassword(info.getString(5));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static User findForLogin(String username, String password) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from users where username = ? and userpassword = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				u = new User();

				u.setUserid(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setUserpassword(info.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errors Happened!!!");
		}
		return u;
	}

	public static User save(User obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into users(firstname, lastname, username, userpassword) values (?, ?, ?, ?)";
			String[] keys = { "userid" };

			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setString(1, obj.getFirstname());
			ps.setString(2, obj.getLastname());
			ps.setString(3, obj.getUsername());
			ps.setString(4, obj.getUserpassword());
			ps.executeUpdate();

			ResultSet pk = ps.getGeneratedKeys();

			while (pk.next()) {
				obj.setUserid(pk.getInt(1));
			}
		}
		catch (SQLException e) {
			return null;
		}
		return obj;
	}
}