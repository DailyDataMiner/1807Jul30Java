package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAO {
	
	
	public List<Account> findAll(){
		List<Account> accounts = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "SELECT * FROM account";
			//Only use statements for get all.
			// STATEMENT INTERFACE NOT OBJECTS
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				//iterate through each row
				Account temp = new Account();
				
				temp.setAccountId(rs.getInt(1));
				temp.setUserId(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				temp.setAccountTypeId(rs.getInt(4));
				temp.setLastUpdate(rs.getDate(5));
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	public List<Account> findAllMine(int userId){
		List<Account> accounts = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "SELECT * FROM account WHERE userId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				//iterate through each row
				Account temp = new Account();
				
				temp.setAccountId(rs.getInt(1));
				temp.setUserId(rs.getInt(2));
				temp.setBalance(rs.getDouble(3));
				temp.setAccountTypeId(rs.getInt(4));
				temp.setLastUpdate(rs.getDate(5));
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	
	public Account findOne(int userId, int accTypeId){
		Account a = null;
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM account WHERE userId = ? AND accountTypeId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userId);
			ps.setInt(2,  accTypeId);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				a = new Account();
				a.setAccountId(info.getInt(1));
				a.setUserId(info.getInt(2));
				a.setBalance(info.getDouble(3));
				a.setAccountTypeId(info.getInt(4));
				a.setLastUpdate(info.getDate(5));
			}
			
		} catch (SQLException e) {
		}
		return a;
	}
	
	public String findAccountTypeName(int accTypeId) {
		String s = null;
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT name FROM accountType WHERE accountTypeID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, accTypeId);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				s = info.getString(1);
			}
		} catch (SQLException e) {
		}
		return s;
	}
	
	public Account save(Account a) {
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory
				.getConnection()){
			//connections automatically commit after tx is complete, set to false to do some sort of validation
			conn.setAutoCommit(false);					
			String sql = "INSERT INTO account (userId, balance, accTypeId, lastUpdated) VALUES (?, ?, ? , ?)";
			//code to get back auto-generated PK (other columns can be auto generated too)
			String[] keys = {"accountId"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, a.getUserId());
			ps.setDouble(2, a.getBalance());
			ps.setInt(3, a.getAccountTypeId());
			ps.setDate(4, a.getLastUpdate());

			
			//Updates return num rows added/updated/delted
			//Queries return result sets
			int numRowsAffect  = ps.executeUpdate();
			if(numRowsAffect > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					a.setAccountId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
		}
		return a;
	}

}
