package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojo.Account;
import com.rev.util.ConnectionFactory;

public class AccountDao {

	public List<Account> checkAcc(int userid) {
		List<Account> cl = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from Account where UserId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet info = ps.executeQuery();

			while (info.next()) {

				Account temp = new Account();
				temp.setUserid(info.getInt(1));
				temp.setAccname(info.getString(2));
				temp.setAcctype(info.getString(3));
				temp.setBalance(info.getDouble(4));
				cl.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cl;
	}

	public void makeAccount(int usid, String accName, String accType) {
		Account k = new Account(usid, accName, accType);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "Insert into Account(UserId, AccName, AccType) values (?,?,?)";

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, k.getUserid());
			ps.setString(2, k.getAccname());
			ps.setString(3, k.getAcctype());

			ps.executeUpdate();
			conn.commit();
			System.out.println("Account created...\n");
		}

		catch (SQLException e) {

			e.printStackTrace();
		}
	} 

	public void update(int id, String accName, String accType, double amount){
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "Update Account set Balance = ? where UserId = ? and AccName = ?";
			
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, amount);
			ps.setInt(2, id);
			ps.setString(3, accName);
		
			
			ps.executeUpdate();
			
			conn.commit();
			
			System.out.println("Account updated...");
			System.out.println("Balance: " + amount);
		
			
		}

		catch (SQLException e) {

			e.printStackTrace();
		

		}


	}
	
	
	


	
}


