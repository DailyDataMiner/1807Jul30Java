package com.revature.projectZero.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.projectZero.POJO.Account;
import com.revature.projectZero.POJO.User;
import com.revature.projectZero.util.ConnectionFactory;
import com.revature.projectZero.util.SQL;

public class UserDAO implements DAO<User, Integer> {

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			ResultSet info = SQL.queryDatabase(conn, "select user_id from users");
			while (info.next()) {
				users.add(findOne(info.getInt(1), conn));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findOne(Integer id) {
		User u = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			u = findOne(id, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	private User findOne(Integer id, Connection conn) throws SQLException {
		User u = null;
		Account a = null;
		ResultSet info = SQL.queryDatabase(conn, "select * from users where user_id = ?", id);
		while (info.next()) {
			u = new User(info.getInt(1), info.getString(2), info.getString(3), info.getString(4), info.getString(5));
		}
		info = SQL.queryDatabase(conn, "select * from accounts where user_id = ?", id);
		while (info.next()) {
			a = new Account(info.getInt(1), info.getInt(2), info.getInt(3), info.getString(4), info.getDouble(5));
			u.getAccounts().add(a);
		}
		return u;
	}

	public User login(String usr, String pwd) throws SQLException {
		int id = -1;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			final String query = "select user_id from users where username = ? and password = ?";
			ResultSet info = SQL.queryDatabase(conn, query, usr, pwd);
			while(info.next()) {
				id = info.getInt(1);
			}
			User u = findOne(id, conn);
			return u;
		}
	}

	@Override
	public User save(User u) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// connections automatically commit after tx is complete/right before connection
			// closes set to false to do some sort of validation before committing
			conn.setAutoCommit(false);
			String sql = "insert into users values(id_gen.nextval, ?, ?, ?, ?)";
			// code to get back auto-generated PK (other columns can be auto generated too!)
			String[] keys = { "User_ID" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getLastName());
			ps.setString(3, u.getUserName());
			ps.setString(4, u.getPassword());

			// UPDATES return num rows added/updated/deleted
			// QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			if (numRowsAffected > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while (pk.next()) {
					System.out.println(pk.toString());
					u.setUserId(pk.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return u;
	}

	@Override
	public User update(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub

	}

}
