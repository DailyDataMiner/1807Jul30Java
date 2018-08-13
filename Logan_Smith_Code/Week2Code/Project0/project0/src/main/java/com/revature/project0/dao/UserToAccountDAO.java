package com.revature.project0.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.projectobjects.Account;
import com.revature.project0.projectobjects.User;
import com.revature.project0.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;


public class UserToAccountDAO {
	
	public List<User> findAllLinkedUsers(int accountid) {
		List<User> Users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call getAllLinkedUsers(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, accountid);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				User temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				Users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}

	public List<Account> findAllLinkedAccounts(int userid) {
		List<Account> Accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call getAllLinkedAccounts(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, userid);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				Account temp = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
				Accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Accounts;
	}

	public void save(User user, Account account) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call insertUserToAccount(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, user.getUserID());
			cs.setInt(2, account.getAccountID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(User user, Account account) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call deleteUserToAccount(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, user.getUserID());
			cs.setInt(2, account.getAccountID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
