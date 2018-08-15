package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.rev.util.ConnectionFactory;
import com.rev.pojos.BankUser;

public class BankUserDAO implements Dao<BankUser, Integer>{

	@Override
	public List<BankUser> findAll() {
		List<BankUser> bUser = new ArrayList<BankUser>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "select * from BankUsers order by first_Name asc";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				//iterate through each row of result set
				BankUser temp = new BankUser();
				temp.setUserID(rs.getInt(1)); // can access cols of RS by either col name or id
				String name = rs.getString(2);
				temp.setFirstName(name);
				bUser.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bUser;
	}
	/*
	 * PREPARED STATEMENT
	 * - executes a pre-compiled SQL statement 
	 * - efficient for statements that will execute multiple times
	 */
	public BankUser findOne(Integer id){
		BankUser u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from BankUser where User_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			u = new BankUser();
			u.setUserID(info.getInt(1));
			u.setFirstName(info.getString(2));
			}
			// more code
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public BankUser save(BankUser obj) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "Insert Into BankUsers(first_Name,last_Name,email,user_Name, pass_word) values(?,?,?,?,?)"; 
			
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getEmail());
			ps.setString(4, obj.getUserName());
			ps.setString(5, obj.getPassword());
			
			
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			
			System.out.println("Welcome to Our Bank "+ obj.getFirstName());
				conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public BankUser update(BankUser obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(BankUser obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public BankUser insert(BankUser obj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BankUser findOneID(BankUser obj) {
		BankUser u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from BankUsers where user_Name = ? AND pass_Word = ?" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, obj.getUserName());
			ps.setString(2, obj.getPassword());
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			u = new BankUser();
			u.setUserID(info.getInt(1));
			u.setFirstName(info.getString(2));
			u.setLastName(info.getString(3));
			u.setEmail(info.getString(4));
			u.setUserName(info.getString(5));
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
