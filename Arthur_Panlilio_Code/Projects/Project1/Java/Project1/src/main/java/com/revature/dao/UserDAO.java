package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class UserDAO implements DAO<User, Integer>{

	@Override
	public List<User> findAll(){
		List<User> users = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "SELECT * FROM users";
			//Only use statements for get all.
			// STATEMENT INTERFACE NOT OBJECTS
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setFirstname(rs.getString(4));
				u.setLastname(rs.getString(5));
				u.setEmail(rs.getString(6));
				u.setRoleId(rs.getInt(7));
				users.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	

	@Override
	public User save(User u) {
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory
				.getConnection()){
			//connections automatically commit after tx is complete, set to false to do some sort of validation
			conn.setAutoCommit(false);					
			String sql = "INSERT INTO users (username, password, firstname, lastname, email, roleId) VALUES (?, ?, ?, ?, ?, ?)";
			//code to get back auto-generated PK (other columns can be auto generated too)
			String[] keys = {"id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstname());
			ps.setString(4, u.getLastname());
			ps.setString(5, u.getEmail());
			ps.setInt(6,u.getRoleId());
			
			//Updates return num rows added/updated/delted
			//Queries return result sets
			int numRowsAffect  = ps.executeUpdate();
			if(numRowsAffect > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					u.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return u;
	}

}
