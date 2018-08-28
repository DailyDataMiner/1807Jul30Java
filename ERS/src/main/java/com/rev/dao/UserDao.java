package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.User;
import com.rev.util.ConnectionUtil;

public class UserDao {

	public static void main(String[] args) {
		
//		List<User> users = findAllUsers();
//		for(User u : users) {
//			System.out.println(u);
//		}
		
//		System.out.println(findUserByUsername("JohnSmith"));
		
		System.out.println(findForLogin("JohnSmith", "password"));
		
		
	}
	
	public static List<User> findAllUsers() {
		List<User> users = new ArrayList<User>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "select * from ers_users";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				User temp = new User();

				temp.setUserid(rs.getInt(1));

				String userName = rs.getString(2);
				temp.setUsername(userName);

				String password = rs.getString(3);
				temp.setPassword(password);

				String firstName = rs.getString(4);
				temp.setFirstname(firstName);

				String lastName = rs.getString(5);
				temp.setLastname(lastName);
				
				String email = rs.getString(6);
				temp.setEmail(email);
				
				String roleid = rs.getString(7);
				temp.setRoleid(roleid);

				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;		
	}
	
	public static User findUserByUserid(Integer userid) {
		User u = null;
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "select * from ers_users where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				u = new User();

				u.setUserid(info.getInt(1));
				u.setUsername(info.getString(2));
				u.setPassword(info.getString(3));
				u.setFirstname(info.getString(4));
				u.setLastname(info.getString(5));
				u.setEmail(info.getString(6));
				u.setRoleid(info.getString(7));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static User findUserByUsername(String username) {
		User u = null;
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "select * from ers_users where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
	
			while (info.next()) {
				u = new User();

				u.setUserid(info.getInt(1));
				u.setUsername(info.getString(2));
				u.setPassword(info.getString(3));
				u.setFirstname(info.getString(4));
				u.setLastname(info.getString(5));
				u.setEmail(info.getString(6));
				u.setRoleid(info.getString(7));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static User findForLogin(String username, String password) {
		User u = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				u = new User();

				u.setUserid(info.getInt(1));
				u.setUsername(info.getString(2));
				u.setPassword(info.getString(3));
				u.setFirstname(info.getString(4));
				u.setLastname(info.getString(5));
				u.setEmail(info.getString(6));
				u.setRoleid(info.getString(7));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static User saveNewUser(User obj) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "insert into ers_users (username, password, firstname, lastname, email, roleid) values (?, ?, ?, ?, ?, ?)";
			
			String[] keys = { "userid" };

			PreparedStatement ps = conn.prepareStatement(sql, keys);
			
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstname());
			ps.setString(4, obj.getLastname());
			ps.setString(5, obj.getEmail());
			ps.setString(6, obj.getRoleid());
			
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
