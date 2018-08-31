package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import beans.UserRole;
import exceptions.UsernameTakenException;
import utils.ConnectionFactory;

public class UserDAO implements DAO<User> {
	
	// TODO: remove main and static methods
	public static void main(String[] args) {
		
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		final String sql = "SELECT * FROM Ers_Users";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				users.add(parseResultSet(rs));
			}
			return users;
		} catch (SQLException e) {
//			log.error("SQL exception while trying to retrieve users", e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findOne(int id) {
		final String sql = "SELECT * FROM Ers_Users WHERE Ers_User_Id = ?";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return parseResultSet(rs);
			}
		} catch (SQLException e) {
//			log.error("SQL exception while trying to retrieve User by ID " + id, e);
			e.printStackTrace();
		}
		return null;
	}

	public User findByUsername(String username) {
		final String sql = "SELECT * FROM Ers_Users WHERE Ers_Username = ?";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return parseResultSet(rs);
			}
		} catch (SQLException e) {
//			log.error("SQL exception while trying to retrieve User by username " + username, e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(User u) throws UsernameTakenException {
		final String sql = "INSERT INTO Ers_Users "
				+ "(Ers_Username, Ers_Pwd_Hash, Ers_Pwd_Salt, User_First_Name, User_Last_Name, User_Email, User_Role_Id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String[] keys = { "Ers_User_Id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setString(1, u.getUsername());
			ps.setBytes(2, u.getPwdHash());
			ps.setBytes(3, u.getPwdSalt());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getLastName());
			ps.setString(6, u.getEmail());
			ps.setInt(7, u.getRole().getId());
			int n = 0;
			try {
				n = ps.executeUpdate();
			} catch (SQLIntegrityConstraintViolationException e) {
				throw new UsernameTakenException("username or email taken");
			}
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (n == 1 && generatedKeys.next()) {
				u.setId(generatedKeys.getInt(1));
				System.out.println("success");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean update(User u) {
		final String sql = "UPDATE Ers_Users SET "
				+ "Ers_Username = ?, Ers_Pwd_Hash = ?, Ers_Pwd_Salt = ?, User_First_Name = ?, User_Last_Name = ?, User_Email = ?, User_Role_Id = ? "
				+ "WHERE Ers_User_Id = ?";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setBytes(2, u.getPwdHash());
			ps.setBytes(3, u.getPwdSalt());
			ps.setString(4, u.getFirstName());
			ps.setString(5, u.getLastName());
			ps.setString(6, u.getEmail());
			ps.setInt(7, u.getRole().getId());
			ps.setInt(8, u.getId());
			int rowsUpdated = ps.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
//			log.error("SQL exception when updating user " + u.getUsername(), e);
		}
		return false;
	}

	@Override
	public boolean delete(User u) {
		final String sql = "DELETE FROM Ers_Users WHERE Ers_User_Id = ?";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			int rowsDeleted = ps.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
//			log.error("SQL exception when deleting user " + u.getUsername(), e);
		}
		return false;
	}

	private User parseResultSet(ResultSet rs) throws SQLException {
		User u = new User();
		u.setId(rs.getInt("Ers_User_Id"));
		u.setUsername(rs.getString("Ers_Username"));
		u.setPwdHash(rs.getBytes("Ers_Pwd_Hash"));
		u.setPwdSalt(rs.getBytes("Ers_Pwd_Salt"));
		u.setFirstName(rs.getString("User_First_Name"));
		u.setLastName(rs.getString("User_Last_Name"));
		u.setEmail(rs.getString("User_Email"));
		u.setRole(UserRole.getRoleById(rs.getInt("User_Role_Id")));
		return u;
	}
}
