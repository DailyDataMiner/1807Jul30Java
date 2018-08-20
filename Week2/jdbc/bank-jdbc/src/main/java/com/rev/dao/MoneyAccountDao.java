package com.rev.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.MoneyAccount;
import com.rev.pojos.MoneyAccount;
import com.rev.pojos.MoneyAccount;
import com.rev.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class MoneyAccountDao implements Dao<MoneyAccount, Integer> {

	/*
	 * STATEMENT - takes an SQL statement as a string, executes it, and returns the
	 * result - allows SQL injection so is bad to use. if you MUST, only use it for
	 * queries with no variables
	 * 
	 */

	// Most sensitive part of the structure so NEVER INTERACT DIRECTLY BY USER

	// Retrieves all rows from MoneyAccount
	public List<MoneyAccount> findAll() {
		List<MoneyAccount> MoneyAccounts = new ArrayList<MoneyAccount>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from MoneyAccount order by name asc";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// iterate through each row of result set
				MoneyAccount temp = new MoneyAccount();
				temp.setcustomerId(rs.getInt(1)); // can access cols of RS by either col name or id
				int name = rs.getInt(2);
				temp.setSavingsbalance(name);
				MoneyAccounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MoneyAccounts;
	}

	/*
	 * PREPARED STATEMENT - executes a pre-compiled SQL statement - efficient for
	 * statements that will execute multiple times
	 */
	public MoneyAccount findOne(Integer id) {
		MoneyAccount g = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from MoneyAccount where MoneyAccount_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				g = new MoneyAccount();
				g.setcustomerId(info.getInt(1));
				g.setSavingsbalance(info.getInt(2));
				g.setcustomerId(info.getInt(3));
			}
			// more code
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	public MoneyAccount getAccount(String username) {
		List<MoneyAccount> ma = new ArrayList<MoneyAccount>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_books(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);
			while (rs.next()) {
				MoneyAccount temp = new MoneyAccount();
				temp.setcustomerId(rs.getInt("CustomerId"));
				temp.setSavingsbalance(rs.getDouble("SavingsBalance"));
				temp.setCheckingbalance(rs.getDouble("CheckingBalance"));

				ma.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return (MoneyAccount) ma;
	}

	public MoneyAccount save(MoneyAccount obj) {
		// New empty account object

		// establish connection
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// turn off autocommit until we're sure we want to commit
			conn.setAutoCommit(false);
			// prepared statement with blank values for inserting a new field
			String query = "insert into account(AccountId, Savings, Checking) values(?, ?, ?)";

			// load prepared statement and key
			PreparedStatement ps = conn.prepareStatement(query);
			// setting ? values of statement to one passed from object in parameter
			ps.setInt(1, obj.getcustomerId());
			ps.setDouble(2, obj.getSavingsbalance());
			ps.setDouble(3, obj.getCheckingbalance());

			// executes statement
			int rows = ps.executeUpdate();

			if (rows != 0)
				conn.commit();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;

	}

	// find max
	public int getMax() {

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			String sql = "{call get_max_custid(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();

			int pr = cs.getInt(1);

			// ResultSet rs = (ResultSet) cs.getObject(1); // out cursor

			return pr;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public MoneyAccount update(MoneyAccount obj) {
		// New empty account object

		// establish connection
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			// turn off autocommit until we're sure we want to commit
			conn.setAutoCommit(false);
			// prepared statement with blank values for inserting a new field
			String query = "insert into account(SavingsBalance, CheckingBalance) values(?, ?)";

			// load prepared statement and key
			PreparedStatement ps = conn.prepareStatement(query);
			// setting ? values of statement to one passed from object in parameter
		
			ps.setDouble(1, obj.getSavingsbalance());
			ps.setDouble(2, obj.getCheckingbalance());

			// executes statement
			int rows = ps.executeUpdate();
			if (rows != 0) {
				ResultSet pk = ps.getGeneratedKeys();
				
				while (pk.next()) {
					obj.setcustomerId(pk.getInt(1));
				}

			if (rows != 0)
				conn.commit();
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	public boolean isUnique(String s) {
	
		return true;

	}

	

	

}
