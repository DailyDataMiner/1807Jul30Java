package com.Rev.assoc.Proj0.DAO;

import java.sql.CallableStatement;
//import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Rev.assoc.Proj0.pojos.UserAcc;
import com.Rev.assoc.Proj0.util.ConnectionFactory;


public class UserDao{ //implements DAO<UserAcc, Integer>{
	
	public static UserAcc findOne(String uname) {
		UserAcc u = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			//String sql = "select * from UserAcc where username LIKE ?";
			String sql = "SELECT * FROM USERACC WHERE USERNAME LIKE ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			u = new UserAcc();
			u.setUID(info.getInt(1));
			u.setUUsername(info.getString(2));
			u.setUPass(info.getString(3));
			u.setUFirstName(info.getString(4));
			u.setULastName(info.getString(5));
			u.setUEmail(info.getString(6));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public UserAcc save(UserAcc obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			//String sql = "insert into UserAcc(userId, username, password, firstname, lastname, email) values (?, ?, ?, ?, ?, ?)";
			String sql = "insert into UserAcc(username, password, firstname, lastname, email) values (?, ?, ?, ?, ?)";
			String[] keys = {"UserAccId"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, obj.getUUsername());
			ps.setString(2, obj.getUPass());
			ps.setString(3, obj.getUFirstName());
			ps.setString(4, obj.getULastName());
			ps.setString(5, obj.getUEmail());
			ps.executeUpdate();
			ResultSet pk = ps.getGeneratedKeys();
			while(pk.next()) {
				obj.setUID(pk.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/*
	public UserAcc update(UserAcc obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void delete(UserAcc obj) {
		// TODO Auto-generated method stub
		
	}*/
	
	public void qp() {
		
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			Statement statement = conn.createStatement();
			statement.executeQuery(" INSERT INTO UserAcc(USER_ID,USERNAME,PASSWORD, FIRSTNAME, LASTNAME, EMAIL) VALUES(2,'LateTwoParty','3lectric8oots','Admin', 'One','BitterBenny@znb.com') ");
			System.out.println("as if");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	
	public ArrayList<UserAcc> findAll(){
		List<UserAcc> finding = new ArrayList<UserAcc>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM USERACC ");
			while(rs.next()) {
				UserAcc temp = new UserAcc();
				temp.setUID(rs.getInt(1));
				String username = rs.getString(2);
				temp.setUUsername(username);
				temp.setUPass(rs.getString(3));
				temp.setUFirstName(rs.getString(4));
				temp.setULastName(rs.getString(5));
				temp.setUEmail(rs.getString(6));
				finding.add(temp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (ArrayList<UserAcc>) finding;
	
	}

	}

