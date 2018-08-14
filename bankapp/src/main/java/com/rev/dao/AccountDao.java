package com.rev.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Account;
import com.rev.pojos.SavingsAccount;
import com.rev.pojos.User;
import com.rev.service.AccountService;
import com.rev.util.ConnectionFactory;

public class AccountDao {
	public static void main(String[] args) {

//		User testUser = new User();
//		testUser.setUserid(5);

//		List<Account> accounts = findAllOfUsersAccounts(5); //String userid
//		for (Account a : accounts) {
//			System.out.println(a);
//		}

//		System.out.println(findOne(5));
	}

	public static List<Account> findAllOfUsersAccounts(int UserId) {
		
		List<Account> accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from accounts where userid = ?";
			// where userid = ?

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, UserId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Account temp = new Account();

				temp.setAccountid(rs.getInt(1));

				int userid = rs.getInt(2);
				temp.setUserid(userid);

				String accounttype = rs.getString(3);
				temp.setAccounttype(accounttype);

				double amount = rs.getDouble(4);
				temp.setAmount(amount);

				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	public static Account findAccountToGetID(String username, String password) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from users where username = ? and userpassword = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				u = new User();

				u.setUserid(info.getInt(1));
				u.setFirstname(info.getString(2));
				u.setLastname(info.getString(3));
				u.setUsername(info.getString(4));
				u.setUserpassword(info.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errors Happened!!!");
		}
		return u;
	}

	public static Account save(Account newAccount, User loggedInUser) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into accounts(userid, accounttype, amount) values (?, ?, ?)";
			String[] keys = { "accountid" };

			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setInt(1, loggedInUser.getUserid());
			ps.setString(2, newAccount.getAccounttype());
			ps.setDouble(3, 0d);
			ps.executeUpdate();

			ResultSet pk = ps.getGeneratedKeys();

//			while (pk.next()) {
//				obj.setAccountid(pk.getInt(1));
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Account Created!");
		return newAccount;
	}
	
	public static void Deposit(int accountToDepositInto, double amountToDeposit) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "update accounts set amount = amount + ? where accountid = ?";
			String[] keys = { "accountid" };

			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setDouble(1, amountToDeposit);
			ps.setInt(2, accountToDepositInto);
			ps.executeUpdate();

//			ResultSet pk = ps.getGeneratedKeys();

//			while (pk.next()) {
//				obj.setAccountid(pk.getInt(1));
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean Withdraw(int accountToWithdrawFrom, double amountToWithdraw, User loggedInUser) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "update accounts set amount = amount - ? where accountid = ?";
			String[] keys = { "accountid" };

			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setDouble(1, amountToWithdraw);
			ps.setInt(2, accountToWithdrawFrom);
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Can't withdraw that much!");
			AccountService.makeWithdrawal(loggedInUser);
			return false;
//			e.printStackTrace();
		}
		return true;
	}
	
}