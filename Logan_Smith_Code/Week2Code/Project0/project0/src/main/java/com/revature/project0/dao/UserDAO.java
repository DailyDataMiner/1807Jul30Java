package com.revature.project0.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.project0.projectobjects.User;
import com.revature.project0.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class UserDAO implements Dao<User, Integer> {

	public List<User> findAll() {
		List<User> Users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call getAllBankUsers(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
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

	public User findOne(Integer id) {
		User a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from BankUser where Userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public User save(User obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call insertBankUser(?, ?, ?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getUsername());
			cs.setString(2, obj.getPassword());
			cs.setString(3, obj.getFirstName());
			cs.setString(4, obj.getLastName());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				String query = "select Userid from BankUser where Userid = (select max(Userid) from BankUser)";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					obj.setUserID(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public User updateUsername(User obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call updateUsername(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getUsername());
			cs.setInt(2, obj.getUserID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	public User updatePassword(User obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call updatePassword(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getPassword());
			cs.setInt(2, obj.getUserID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	public User updateName(User obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call updateName(?, ?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getFirstName());
			cs.setString(2, obj.getLastName());
			cs.setInt(3, obj.getUserID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public void delete(User obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call deleteBankUser(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, obj.getUserID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}