package com.Rev.assoc.Proj0.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Rev.assoc.Proj0.pojos.BankAccount;
import com.Rev.assoc.Proj0.pojos.UserAcc;
import com.Rev.assoc.Proj0.util.ConnectionFactory;

public class BankAccountDao{// implements DAO<BankAccount, Integer> {

	public BankAccount findOne(Integer id, String name) {
		BankAccount ba = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from accounts where user_id = ? and name LIKE ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			ba = new BankAccount();
			ba.setBAID(info.getInt(1));
			ba.setBAAccNAme(info.getString(2));
			ba.setBAType(info.getString(3));
			ba.setBABalance(info.getDouble(4));
			ba.setBAUserID(info.getInt(5));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ba;
	}
	
	public BankAccount findMultiple(Integer id, String type) {
		BankAccount ba = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from genre where genre_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			ba = new BankAccount();
			ba.setBAID(info.getInt(1));
			ba.setBAAccNAme(info.getString(2));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ba;
	}

	

	public BankAccount save(BankAccount ba) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into accounts(account-id, name,type,balance,user_id) values(?, ?, ?, ?, ?, ?)";
			int[] keys = {1,2,3,4,5};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, ba.getBAID());
			ps.setString(2, ba.getBAAccNAme());
			ps.setString(3, ba.getBAType());
			ps.setDouble(4, ba.getBABalance());
			ps.setInt(5, ba.getBAUserID());
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.toString());
					ba.setBAID(pk.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ba;
	}

	public BankAccount update(BankAccount ba) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			
			conn.setAutoCommit(false);
			String sql = "update  into accounts(balance) values(?)";
			
			
			//String[] keys = {"account_ID"};
			String[] keys = {"balance"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1,ba.getBABalance());
			
			int numRowsAffected = ps.executeUpdate();
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					System.out.println(pk.toString());
					ba.setBAID(pk.getInt(1));
				}
				
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ba;
	}
	public void affirmative(){
		
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			Statement statement = conn.createStatement();
			String sql = "CREATE TABLE ACCOUNTS "
					+ "(account_id INTEGER not NUll, "
					+ "name VARCHAR2(255), "
					+ "type VARCHAR2(255), "
					+ "balance NUMBER(14,2), "
					+ "userid INTEGER, "
					+ "PRIMARY KEY ( account_id ))";
			statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public void cutie() {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			Statement statement = conn.createStatement();
			String a = "INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, userid) VALUES(0,'HannahOneSavings', 'Savings', 7550.14, 0)";
			String b = "INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, userid) VALUES(2,'DifferentHatz', 'Checking', 196650.03, 1) ";
			String c = "INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, userid) VALUES(5,'LORDe', 'Checking', 811, 2) ";
			String d = "INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, userid) VALUES(6,'MercyMe', 'Savings', 811.02, 2) ";
			String e = "INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, userid) VALUES(7,'Test', 'Savings', 3000, 2) ";
			String f = "INSERT INTO Accounts(ACCOUNT_ID, NAME, TYPE, BALANCE, userid) VALUES(1,'Foreteen', 'Savings', 14000.36, 2) ";
			statement.addBatch(a);
			statement.addBatch(b);
			statement.addBatch(c);
			statement.addBatch(d);
			statement.addBatch(e);
			statement.addBatch(f);
			statement.executeBatch();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

}
