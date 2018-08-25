package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rev.pojos.Reimb;
import com.rev.util.ConnectionFactory;

public class ReimbDao {

public Reimb addReimb(Reimb k) {
	
	

		

//		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
//			String sql = "Insert into Client (firstname, lastname, username, password) values (?,?,?,?)";
//			
//			conn.setAutoCommit(false);
//			// retrieve the auto-generated account_id key.
//			String[] key = { "UserId" };
//			PreparedStatement ps = conn.prepareStatement(sql, key);
//			ps.setString(1, k.getFirstname());
//			ps.setString(2, k.getLastname());
//			ps.setString(3, k.getUsername());
//			ps.setString(4, k.getPassword());
//			
//			int rowsUpdated = ps.executeUpdate();
//			if (rowsUpdated > 0) {
//				
//				ResultSet pk = ps.getGeneratedKeys();
//				
//				while (pk.next()) {
//					
//					k.setUserid(pk.getInt(1));
//
//				}
//				
//			}
//			conn.commit();
//
//		} catch (SQLException e) {
//			System.out.println("Please try again");
//			Driver.menu();
//		}
//		return k;
//	}
}
