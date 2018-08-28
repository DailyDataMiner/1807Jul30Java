package DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJOs.User;
import POJOs.UserInformation;
import Util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

	private static UserDAOImpl instance;
	
	private UserDAOImpl() {}
	
	public static UserDAOImpl getInstance() {
		if (instance == null) {
			instance = new UserDAOImpl();
		}
		return instance;
	}
	
	public String getPasswordHash(User user) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
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

	public UserInformation getUserInformation(String username) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stat = conn.prepareStatement("SELECT * FROM example_user_information WHERE username = ?");
			stat.setString(++index, username);
			ResultSet rs = stat.executeQuery();
			if (rs.next())
			return new UserInformation(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		catch (SQLException sql) {
			System.err.println("SQL state: " + sql.getSQLState());
			System.err.println("Error code: " + sql.getErrorCode());
		}
		return null;
	}

	@Override
	public User getUser(String input) {
		int index = 0;
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement stat = conn.prepareStatement("SELECT * FROM example_users WHERE username = ?");
			stat.setString(++index, input);
			ResultSet rs = stat.executeQuery();
			if (rs.next())
			return new User(rs.getString(1), rs.getString(2));
		}
		catch (SQLException sql) {
			System.err.println("SQL state: " + sql.getSQLState());
			System.err.println("Error code: " + sql.getErrorCode());
		}
		return null;
	}
	
	

}
