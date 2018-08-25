package com.rev.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Account;
import com.rev.pojos.User;
import com.rev.service.AccountService;
import com.rev.util.ConnectionFactory;

public class AccountDao {

	public static List<Account> findAllOfUsersAccounts(int UserId) {
		
		List<Account> accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "select * from accounts where userid = ?";

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

	public static Account save(Account newAccount, User loggedInUser) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "insert into accounts(userid, accounttype, amount) values (?, ?, ?)";
			String[] keys = { "accountid" };

			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setInt(1, loggedInUser.getUserid());
			ps.setString(2, newAccount.getAccounttype());
			ps.setDouble(3, 0d);
			ps.executeUpdate();

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
		}
		return true;
	}
}