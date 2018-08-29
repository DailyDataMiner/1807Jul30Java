package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.rev.pojos.Account;
import com.rev.pojos.BankUser;
import com.rev.util.ConnectionFactory;

public class AccountDAO implements Dao<Account ,Integer >{

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public double findOne(Account obj) {
		
		double balance = 0;
	
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select Balance from Accounts where user_ID = ? AND type_ID = ?" ;
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, obj.getUserID());
			ps.setInt(2, obj.getTypeID());
			ResultSet info = ps.executeQuery();
			
			
			while(info.next()) {
				
					balance = info.getDouble("Balance");
					
			}
				
	}catch(SQLException e) {
		
		e.printStackTrace();
		
		}
		return balance;
	}

	@Override
	public Account save(Account obj) {
			
		
		int x;
		
		
		
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			

			
			String sql = "Insert Into Accounts(user_ID, type_ID) values(?,?)"; 
			
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, obj.getUserID());
			
			ps.setInt(2, obj.getTypeID() );
			
			
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			
				
				conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void update(Account obj, double usrInput, int type) {
		
		double balance =0;
		double total =0;
		
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			
			String sql1= "Select * from Accounts where Account_ID=? AND User_ID = ?";
			
			PreparedStatement ps1 = conn.prepareStatement(sql1);
		
			ps1.setInt(1, obj.getAccountID() );
			
			ps1.setInt(2, obj.getUserID() );
			
			
			
			
			ResultSet rs1 = ps1.executeQuery();
			
			
		
			while(rs1.next()) {
				
				
				balance = rs1.getDouble("balance");
				
				
			}
			if(type  == 1) {
				total = (balance - usrInput);
				if (total < 0 ) {
					total = balance;
					System.out.println("You cannot withdraw that much\n"+
					"Your Balance is "+balance);
				}else
					System.out.println("Your balance is: "+total);
				
				
				
			}else {
			total = (balance + usrInput);
			if (total > Double.MAX_VALUE ) {
				total = balance;
				System.out.println("You cannot deposit that much\n"+
				"Your Balance is "+balance);
			}else
				System.out.println("Your balance is: "+total);
				
				
			
			
			}
			
			
			
			String sql = "Update Accounts set Balance = ? Where User_ID = ? AND Type_ID = ? AND Account_ID =?"; 
						
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setDouble(1, total);
			ps.setInt(2, obj.getUserID() );
			ps.setInt(3, obj.getTypeID() );
			ps.setInt(4, obj.getAccountID());
			ps.executeUpdate();
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			//int numRowsAffected = ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void delete(Account obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account insert(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findOneID(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account update(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}

}