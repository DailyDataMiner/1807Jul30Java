package DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import POJOs.UserRole;
import oracle.jdbc.OracleTypes;
import util.ConnectionFactory;

public class UserRoleDAO {

	public List<UserRole> findAll() {
		List<UserRole> UserRoles = new ArrayList<UserRole>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_user_roles(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				UserRole temp = new UserRole(rs.getInt(1), rs.getString(2));
				// or rs.getString("Name"); Either col num or col name
				UserRoles.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UserRoles;
	}

	public UserRole findOne(Integer id) {
		UserRole a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_user_roles where ers_user_role_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new UserRole(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public UserRole save(UserRole obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call insert_user_roles(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getUserRoleName());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				String query = "select ers_user_role_id from ers_user_roles where ers_user_role_id = (select max(ers_user_role_id) from ers_user_roles)";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					obj.setUserRoleID(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
