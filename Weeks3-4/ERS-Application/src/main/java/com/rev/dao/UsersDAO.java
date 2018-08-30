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

	
	
	
	public Users findOneID(Integer id) {
		Users u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from ERS_Users where User_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			u = new Users();
			u.setUsersID(info.getInt(1));
			u.setFirstName(info.getString(2));
			}
			// more code
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public Users findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users save(Users b) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "Insert into ERS_USERS(ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME,"
					+ "USER_LAST_NAME,USER_EMAIL) values (?,?,?,?,?)"; 
			
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, b.getUsername());
			ps.setString(2, b.getPassword());
			ps.setString(3, b.getFirstName());
			ps.setString(4, b.getLastName());
			ps.setString(5, b.getEmail());
			
			
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			
			
				conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public Users update(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Users insert(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Users obj) {
		// TODO Auto-generated method stub
		
	}


	public Users findOneID(Users obj) {
		Users u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from ERS_Users where username = ? AND password = ?" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			u = new Users();
			u.setUsersID(info.getInt(1));
			u.setFirstName(info.getString(2));
			u.setLastName(info.getString(3));
			u.setEmail(info.getString(4));
			u.setUsername(info.getString(5));
			u.setPassword(info.getString(6));
			}
			// more code
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

		
}