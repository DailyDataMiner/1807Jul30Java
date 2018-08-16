package com.ex.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


import com.ex.pojos.User;

import com.ex.util.ConnectionFactory;

public class userDao implements InterDao<User, Integer>{
	//static personService  pservice = new personService();
	static Scanner scanner = new Scanner(System.in);
	
	public userDao (){}
	@Override
	public User findOne(Integer id) {
			User g = null;
			try(Connection conn = ConnectionFactory
					.getInstance().getConnection()){
				String sql = "select * from bankuser where Userid = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet info = ps.executeQuery();
				while(info.next()) {
				g = new User();
				g.setId(info.getInt(1));
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return g;
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User obj) {
		     
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into bankUser(userID,firstname, lastname, email, username, pwd) "+
			"values(user_seq.nextval,?,?,?,?,?)";
			
			//code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = {"userID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, obj.getFirstname());
			ps.setString(2, obj.getLastname());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getUsername());
			ps.setString(5, obj.getPwd());
			//ps.setInt(3, obj.getPersonID());
			
			int numRowsAffected = ps.executeUpdate();
			//System.out.println("NumAFFECTED: " + numRowsAffected);
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					//System.out.println(pk.toString());
					obj.setId(pk.getInt(1));
				}
				conn.commit();
			}
			
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
		
		return obj;
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

	

}
