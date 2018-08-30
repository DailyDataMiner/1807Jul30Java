package DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import POJOs.User;
import oracle.jdbc.OracleTypes;
import util.ConnectionFactory;

public class UserDAO {

	UserRoleDAO userRoleDAO = new UserRoleDAO();
	
	public List<User> findAll() {
		List<User> Users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_users(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				User temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), userRoleDAO.findOne(rs.getInt(7)));
				// or rs.getString("Name"); Either col num or col name
				Users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}
	
	public static String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement cs = conn.prepareStatement("select get_user_hash(?,?) as HASH from dual");
			cs.setString(++index, user.getUsername());
			cs.setString(++index, user.getPassword());
			ResultSet rs = cs.executeQuery();
			if (rs.next())
			return rs.getString("HASH");
		}
		catch (SQLException sql) {
			System.err.println("SQL state: " + sql.getSQLState());
			System.err.println("Error code: " + sql.getErrorCode());
		}
		return null;
	}
	
	public List<User> findAllUsernames() {
		List<User> Users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_users(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				User temp = new User(rs.getString(2));
				// or rs.getString("Name"); Either col num or col name
				Users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Users;
	}
	
	public List<User> findAllByRole(int roleID) {
		List<User> Users = new ArrayList<User>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_users_by_role_id(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, roleID);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				User temp = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), userRoleDAO.findOne(rs.getInt(7)));
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
			String sql = "select * from ers_users where ers_users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), userRoleDAO.findOne(rs.getInt(7)));
			}
			//System.out.println(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public User save(User obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call insert_user(?, ?, ?, ?, ?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getUsername().toLowerCase());
			cs.setString(2, obj.getPassword());
			cs.setString(3, obj.getFirstname());
			cs.setString(4, obj.getLastname());
			cs.setString(5, obj.getEmail());
			cs.setInt(6, obj.getUserRole().getUserRoleID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				String query = "select ers_users_id from ers_users where ers_users_id = (select max(ers_users_id) from ers_users)";
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
			String sql = "{call update_username(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getUsername().toLowerCase());
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
			String sql = "{call update_password(?, ?)}";

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
			String sql = "{call update_name(?, ?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getFirstname());
			cs.setString(2, obj.getLastname());
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
	
	public User updateEmail(User obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call update_email(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getEmail());
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
	
	public User updateUserRole(User obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call update_user_role(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, obj.getUserRole().getUserRoleID());
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
	
	public void delete(User obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call delete_user(?)}";

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
