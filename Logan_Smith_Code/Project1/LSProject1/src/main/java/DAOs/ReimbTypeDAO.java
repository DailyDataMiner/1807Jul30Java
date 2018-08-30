package DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import POJOs.ReimbType;
import oracle.jdbc.OracleTypes;
import util.ConnectionFactory;

public class ReimbTypeDAO {

	public List<ReimbType> findAll() {
		List<ReimbType> ReimbTypes = new ArrayList<ReimbType>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_reimbursement_types(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				ReimbType temp = new ReimbType(rs.getInt(1), rs.getString(2));
				// or rs.getString("Name"); Either col num or col name
				ReimbTypes.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ReimbTypes;
	}

	public ReimbType findOne(Integer id) {
		ReimbType a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement_type where reimb_type_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new ReimbType(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	public ReimbType findByTypeName(String id) {
		ReimbType a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement_type where reimb_type = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new ReimbType(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public ReimbType save(ReimbType obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call insert_reimb_type(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getReimbTypeName());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				String query = "select reimb_type_id from ers_reimbursement_type where reimb_type_id = (select max(reimb_type_id) from ers_reimbursement_type)";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					obj.setReimbTypeID(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
}
