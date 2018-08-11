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

public class UserDAO {
	
	
	public List<User> findAll(){
		List<User> users = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "SELECT * FROM users";
			//Only use statements for get all.
			// STATEMENT INTERFACE NOT OBJECTS
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				//iterate through each row
				User temp = new User();
				
				temp.setId(rs.getInt(1));
				temp.setFirstName(rs.getString(2));
				temp.setLastName(rs.getString(3));
				temp.setPassword(rs.getString(4));
				temp.setUserName(rs.getString(5));
				users.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	

	public User findOne(String uName){
		User u = null;
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uName);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				u = new User();
				u.setId(info.getInt(1));
				u.setFirstName(info.getString(2));
				u.setLastName(info.getString(3));
				u.setPassword(info.getString(4));
				u.setUserName(info.getString(5));
			}
			
		} catch (SQLException e) {
		}
		return u;
	}
	
	
	public User save(User u) {
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory
				.getConnection()){
			//connections automatically commit after tx is complete, set to false to do some sort of validation
			conn.setAutoCommit(false);					
			String sql = "INSERT INTO users (firstname, lastname, pwd, username) VALUES (?, ?, ? , ?)";
			//code to get back auto-generated PK (other columns can be auto generated too)
			String[] keys = {"userId"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getUserName());
			
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
		}
		return u;
	}
	
	
	

}
