package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Account;
import com.revature.util.ConnectionFactory;

public class AccountDao implements Dao<Account, Integer>{
	Account a = null;


	public Account findAccounts(String username) {
		Account a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT A.ACCOUNT_NUMB, A.BALANCE, A.ACCOUNT_TYPE FROM ACCOUNTS A"
					+ "INNER JOIN CUSTOMER_ACCOUNT CA"
					+ "ON A.ACCOUNT_NUMB = CA.ACCOUNT_ID"
					+ "INNER JOIN USERS U"
					+ "ON U.USER_ID = CA.CUSTOMER_ID"
					+ "WHERE LOWER(U.USERNAME) =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username.toLowerCase());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Account();
				a.setAccountid(rs.getInt(1));
				a.setBalance(rs.getDouble(3));
				a.setAccounType(rs.getString(2));
			


				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	


	public Account addOne(int account_numb, double intldepo) {
		String sql = "INSERT INTO ACCOUNTS (ACCOUNT_NUMB, BALANCE) VALUES (?,?)";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String[] key = { "ACCOUNT_NUMB" };
			PreparedStatement ps = conn.prepareStatement(sql, key);
			ps.setInt(1, account_numb);
			ps.setDouble(2, intldepo);
			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				a = new Account();
				while (pk.next()) {
					a.setAccountid(pk.getInt(1));

				}
				conn.commit();
			}
			conn.commit();

		} catch (SQLException se) {
			System.err.println("Got SQLException:");
			se.printStackTrace();
		}
		return a;
	}

	public void addJnct(int aid, int atid) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "INSERT INTO CUSTOMER_ACCOUNT (CUSTOMER_ID, ACCOUNT_ID) VALUES (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, aid);
			ps.setDouble(2, atid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void withdraw(int aid, int withdrwamt) throws SQLException {
		Connection conn = ConnectionFactory.getInstance().getConnection(); 
			String sql = "UPDATE ACCOUNTS SET BALANCE = BALANCE - ? WHERE ACCOUNT_NUMB = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, withdrwamt);
			ps.setDouble(2, aid);
			ps.executeUpdate();
		
	}

	public void deposit(int uaid, int deposit) throws SQLException {
			Connection conn = ConnectionFactory.getInstance().getConnection(); 
			String sql = "UPDATE ACCOUNTS SET BALANCET = BALANCE + ? WHERE ACCOUNT_NUMB_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, deposit);
			ps.setDouble(2, uaid);
			ps.executeUpdate();
		
		
	}
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account save(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account update(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(Account obj) {
		// TODO Auto-generated method stub
		
	}
	
	

}