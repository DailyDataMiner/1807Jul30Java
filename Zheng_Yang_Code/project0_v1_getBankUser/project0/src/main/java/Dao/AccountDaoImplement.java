package Dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Util.JDBCConnection;
import model.BankAccount;

public class AccountDaoImplement implements AccountDao{
	
	public static AccountDaoImplement accountDao;
	
	private AccountDaoImplement() {};
	
	public static AccountDaoImplement getDao() {
		if(accountDao == null) {
			accountDao = new AccountDaoImplement();
		}
		return accountDao;
	}
	
	
	public BankAccount getBankAccount(int accountId, int userId) {

		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			
			
			String sql = "Select * from BankAccount where account_id = ? and user_id = ?";
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setInt(1, accountId);
			pss.setInt(2, userId);
			
			// excecute query and return result set to table
			ResultSet rs = pss.executeQuery(); 
			
			while(rs.next()) {
							
				return	new BankAccount(
						rs.getInt("account_id"),
						rs.getInt("user_id"),
						rs.getInt("balance"),
						rs.getString("account_type")
						);	
			}
			
			//test all other class is okay except while loop here 
			//return  new BankAccount(100,1,100, "saving");	
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	//get list of bankAccoumts belong to specific user
	public ArrayList<BankAccount> getListBankAccountsOfGivenUserDao( int userId) {
		
		ArrayList<BankAccount> alist = new ArrayList<BankAccount>();
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			
			
			String sql = "Select * from BankAccount where user_id = ?";
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
	
			pss.setInt(1, userId);
			
			// excecute query and return result set to table
			ResultSet rs = pss.executeQuery(); 
			
			while(rs.next()) {
				
				alist.add(new BankAccount(
						rs.getInt("account_id"),
						rs.getInt("user_id"),
						rs.getInt("balance"),
						rs.getString("account_type")
						));
					
			}
			return	alist;
			//test all other class is okay except while loop here 
			//return  new BankAccount(100,1,100, "saving");	
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	/*
	 * get total BankAccount#
	 * */
	public int getTotalBankAccountNumberDao() {
			
			
			
			try {
				//make a connection to JDBC
				Connection conn = JDBCConnection.getInstance().getConnection();
				
				
				String sql = "SELECT COUNT(*) FROM BankAccount";
				
				//connection object send sql statement string into database
				//pss is statement object , so that we can use it
				PreparedStatement pss = conn.prepareStatement(sql);
				
				ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
				
			
				while(rs.next()) {
					
	//				System.out.println();
					return rs.getInt("COUNT(*)");
					
				}
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
	}
	
	
	/*
	 * create new bank account
	 * */
	public void newBankAccount(int account_id, int user_id, int balance, String account_type) {
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			String sql = "INSERT INTO BankAccount (Account_id, User_id, Balance,Account_type) VALUES (?, ?, ?, ?)"; //insert inputs into DB
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setInt(1, account_id); //set 1st '?' to userid
			pss.setInt(2, user_id); //set 2nd '?' to first_name
			pss.setInt(3, balance); // so on ...
			pss.setString(4, account_type); 

			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/*
	 * create get specific bank account
	 * */
	public BankAccount getSpecificBankAccount(int account_id, int user_id, int balance, String account_type) {
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			String sql = "INSERT INTO BankAccount (Account_id, User_id, Balance,Account_type) VALUES (?, ?, ?, ?)"; //insert inputs into DB
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setInt(1, account_id); //set 1st '?' to userid
			pss.setInt(2, user_id); //set 2nd '?' to first_name
			pss.setInt(3, balance); // so on ...
			pss.setString(4, account_type); 

			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
			while(rs.next()) {
				
				return	new BankAccount(
						rs.getInt("account_id"),
						rs.getInt("user_id"),
						rs.getInt("balance"),
						rs.getString("account_type")
						);	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * update balance of give user account
	 * */
	public void updateBalanceOfGivenAccountDao(int account_id, int user_id, int balance) {
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			String sql = "UPDATE BankAccount SET balance = ?  WHERE account_id = ? and user_id = ?"; //insert inputs into DB
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setInt(1, balance); //set 1st '?' to userid
			pss.setInt(2, account_id); //set 2nd '?' to first_name
			pss.setInt(3, user_id); // so on ...

			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	/*
	 * drop all user bank account
	 * */
	public void deleteUserBankAccountsDao(int userId) {
		
		try {
			//make a connection to JDBC
			Connection conn = JDBCConnection.getInstance().getConnection();
			
			
			String sql = "DELETE FROM BankAccount WHERE user_id = ?";
			
			//connection object send sql statement string into database
			//pss is statement object , so that we can use it
			PreparedStatement pss = conn.prepareStatement(sql);
			
			pss.setInt(1, userId); //1 is first ?   this set question mark value
			
			ResultSet rs = pss.executeQuery(); // excecute query and return result set to table
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
