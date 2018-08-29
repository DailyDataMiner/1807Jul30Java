package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Users;
import com.rev.util.ConnectionFactory;

public class UsersDAO implements Dao<Users, Integer> {

	public List<Users> findAll() {
		
		List<Users> ersUser = new ArrayList<Users>();
		try(Connection conn = ConnectionFactory.
				getInstance().getConnection()){
			String query = "select * from ESR_USERS order by first_Name asc";
			
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Users temp = new Users();
				temp.setUsersID(rs.getInt(1));
				String name = rs.getString(2);
				temp.setFirstName(name);
				ersUser.add(temp);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ersUser;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public Object findOneID(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users save(Users obj) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "Insert Into ERS_Users(first_Name,last_Name,email,user_Name, pass_word) values(?,?,?,?,?)"; 
			
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getUsername());
			ps.setString(5, obj.getPassword());
			
			
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			
			System.out.println("Welcome "+ obj.getFirstName());
				conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public Object update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object insert(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Object obj) {
		// TODO Auto-generated method stub
		
	}

	

	
}