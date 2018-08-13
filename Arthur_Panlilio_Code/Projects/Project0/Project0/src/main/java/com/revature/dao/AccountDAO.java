package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.revature.pojo.Account;
import com.revature.util.ConnectionFactory;

/**
 * The DAO of an account
 * 
 * @author Arthur Panlilio
 *
 */
public class AccountDAO implements DAO<Account, Integer>{
	
	@Override
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
	
	/**
	 * Finds all the accounts of a user
	 * 
	 * @param userId is the id of the user
	 * @return a list of the user's account
	 */
	public List<Account> findAllMine(int userId, LocalDate currDate, double interest){
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
				Account a = updateDate(temp, currDate, interest);
				temp.setBalance(a.getBalance());
				temp.setLastUpdate(a.getLastUpdate());
				accounts.add(temp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	public Account updateDate(Account a, LocalDate newDate, double interest) {
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "UPDATE account SET lastUpdated = ?, balance = ? WHERE accountId = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			int daysPassed = getDifferenceDays(a.getLastUpdate(), Date.valueOf(newDate));
			double newBalance = a.getBalance();
			if(findAccountTypeName(a.getAccountTypeId()).equals("Savings") && daysPassed > 0) {
				newBalance =  newBalance + (daysPassed * (newBalance * interest/100));
			}
			ps.setDate(1, Date.valueOf(newDate));
			ps.setDouble(2, newBalance);
			ps.setInt(3, a.getAccountId());
			ps.executeQuery();
			a.setBalance(newBalance);
			a.setLastUpdate(Date.valueOf(newDate));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * Finds a specific account
	 * 
	 * @param userId the account's user id
	 * @param accTypeId the accounts type id
	 * @return an account
	 */
	public Account findOne(int userId, int accTypeId){
		Account a = null;
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM account WHERE userId = ? AND accTypeId = ?";
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
	
	/**
	 * Finds the account type based on int
	 * 
	 * @param accTypeId is the id of the account type
	 * @return the account type string
	 */
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
	
	@Override
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
	
	/**
	 * Deposits an amount in the account
	 * 
	 * @param dep the amount to be deposited
	 * @param accId is the account's id
	 */
	public void deposit(double dep, int accId){
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "{call deposit(?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1,dep);
			cs.setInt(2, accId);
			cs.execute();		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Withdraw and amount from the account
	 * 
	 * @param wit is the amount to be withdrawn
	 * @param accId is the id the account
	 */
	public void withdraw(double wit, int accId){
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "{call withdraw(?, ?)}";
			
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1,wit);
			cs.setInt(2, accId);
			cs.execute();		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static int  getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	

}
