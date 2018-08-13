package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Users;
import com.revature.util.ConnectionFactory;

public class UsersDao implements Dao<Users, Integer>{

//	public static void main(String[] args) {
//		findAll();
//	}
	
	public List<Users> findAll(){
		List<Users> Users = new ArrayList<Users>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "select * from users order by name asc";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				Users temp = new Users();
				String Fname = rs.getString(2);
				temp.setFname(Fname);
				Users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}
	public Users findOne(Integer id){
		Users u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from users where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(6, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			u = new Users();
			u.setUser_id(info.getInt(1));
			u.setFname(info.getString(2));
			u.setLname(info.getString(3));
			u.setUsername(info.getString(4));
			u.setPassword(info.getString(5));
			u.setDob(info.getString(6));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public Users save(Users u) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into users(name) values(?)";
			
			String[] keys = {"Users_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1,u.getFname());
			//ps.getString(2,u.getLname());
			
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.toString());
					u.setUser_id(pk.getInt(1));
				}
				
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
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