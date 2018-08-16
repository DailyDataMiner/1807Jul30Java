package com.revature.projectZero.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.projectZero.POJO.Account;
import com.revature.projectZero.util.ConnectionFactory;
import com.revature.projectZero.util.SQL;

public class AccountDAO implements DAO<Account, Integer> {

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			ResultSet info = SQL.queryDatabase(conn, "select account_id from accounts");
			while (info.next()) {
				accounts.add(findOne(info.getInt(1), conn));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account findOne(Integer id) {
		Account a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			a = findOne(id, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	private Account findOne(Integer id, Connection conn) throws SQLException {
		Account a = null;
		ResultSet info = SQL.queryDatabase(conn, "select * from accounts where account_id = ?", id);
		while (info.next()) {
			a = new Account(info.getInt(1), info.getInt(2), info.getInt(3), info.getString(4), info.getDouble(5));
		}
		return a;
	}

	@Override
	public Account save(Account a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// connections automatically commit after tx is complete/right before connection
			// closes set to false to do some sort of validation before committing
			conn.setAutoCommit(false);
			String sql = "insert into accounts values(id_gen.nextval, ?, ?, ?, ?)";
			// code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = { "Account_ID" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setInt(1, a.getUserId());
			ps.setInt(2, a.getAccountTypeId());
			ps.setString(3, a.getAccountName());
			ps.setDouble(4, a.getBalance());
			// UPDATES return num rows added/updated/deleted
			// QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			if (numRowsAffected > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					System.out.println(pk.toString());
					a.setAccountId(pk.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Account update(Account a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String query = "update accounts set balance = ? where account_id = ?";
			SQL.queryDatabase(conn, query, a.getBalance(), a.getAccountId());
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void delete(Account a) {
		// TODO Auto-generated method stub

	}

}
