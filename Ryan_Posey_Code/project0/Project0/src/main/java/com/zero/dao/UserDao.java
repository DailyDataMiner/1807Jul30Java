package com.zero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zero.pojos.User;
import com.zero.util.ConnectionFactory;

public class UserDao implements Dao<User, Integer>{

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "select * from UserInfo order by user_name asc";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				//iterate through each row of result set
				User temp = new User();
				temp.setId(rs.getInt(1)); // can access cols of RS by either col name or id
				String firstname = rs.getString(2);
				temp.setFirstname(firstname);
				String lastname = rs.getString(3);
				temp.setLastname(lastname);
				String username = rs.getString(4);
				temp.setUsername(username);
				String password = rs.getString(5);
				temp.setPassword(password);
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findOne(Integer id) {
		User u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()) {
			String sql = "select * from UserInfo where User_ID = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			while(info.next()) {
				u = new User();
				u.setId(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setPassword(info.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User save(User u) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()) {
			String sql = "insert into UserInfo(first_name, last_name, user_name, pass_word) values(?, ?, ?, ?)";
			
			String[] keys = {"User_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, u.getFirstname());
			ps.setString(2, u.getLastname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					u.setId(pk.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User update(User obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findSpecific(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
