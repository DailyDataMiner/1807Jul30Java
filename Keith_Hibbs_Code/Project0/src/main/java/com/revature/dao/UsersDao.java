package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.main.app;
import com.revature.pojos.Users;
import com.revature.util.ConnectionFactory;



public class UsersDao implements Dao<Users, Integer>{
	
	
	public Users addOne(Users users) {
		Users u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO USERS (FNAME, LNAME, USERNAME, PASSWORD) VALUES (?,?,?,?)";
			String[] keys = {"User_ID"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1,users.getfName());
			ps.setString(2, users.getLname());
			ps.setString(3,users.getUsername());
			ps.setString(4,users.getPassword());
			int rowsUpdated = ps.executeUpdate();
			if(rowsUpdated>0) {
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next()) {
					System.out.println(pk.getInt(1));
					users.setId(pk.getInt(1));
					
				}
				conn.commit();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		}
		return users;	
	}	

	public Users findOne(String username, String password) {
		Users u = null;
//		List<Users> user = new ArrayList<Users>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM USERS WHERE LOWER(USERNAME) = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase());
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				u = new Users();
				u.setId(info.getInt(1));
				u.setfName(info.getString(2));
				u.setLname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setPassword(info.getString(5));
//				user.add(u);
			}

		} catch (SQLException e) {
			System.out.println("Invalid, please try again");
			app.login();
		}

		return u;
	}
	public Users findOneAfter(String username) {
		Users u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM USERS u"
					+ "WHERE LOWER(USERNAME) = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase());
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				u = new Users();
				u.setId(info.getInt(1));
				u.setfName(info.getString(2));
				u.setLname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setPassword(info.getString(5));
//				user.add(u);
			}

		} catch (SQLException e) {
			app.login();
		} catch (NullPointerException e) {
			app.login();
		}

		return u;
	}
	
	public void deleteOne(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "DELETE FROM USERS WHERE LOWER(USERNAME) = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase());
			ps.setString(2, password);
			ps.executeUpdate();
			System.out.println("account deleted");
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Invalid, please try again");
			app.delete();
		} 

		
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users save(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users update(Users obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Users obj) {
		// TODO Auto-generated method stub
		
	}
	
}