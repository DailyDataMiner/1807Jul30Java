package com.revature.project0.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.projectobjects.Account;
import com.revature.project0.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AccountDAO implements Dao<Account, Integer> {

	public List<Account> findAll() {
		List<Account> Accounts = new ArrayList<Account>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call getAllAccounts(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				Account temp = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
				// or rs.getString("Name"); Either col num or col name
				Accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Accounts;
	}

	public Account findOne(Integer id) {
		Account a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from account where accountid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Account save(Account obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call insertAccount(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, obj.getAccountType().getAccountTypeID());
			cs.setDouble(2, obj.getBalance());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				String query = "select accountid from account where accountid = (select max(accountid) from account)";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					obj.setAccountID(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public Account updateAccountBalance(Account obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call updateAccountBalance(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, obj.getBalance());
			cs.setInt(2, obj.getAccountID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void delete(Account obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call deleteAccount(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, obj.getAccountID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}