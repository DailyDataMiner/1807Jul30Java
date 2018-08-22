package DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import POJOs.ReimbStatus;
import oracle.jdbc.OracleTypes;
import util.ConnectionFactory;

public class ReimbStatusDAO {

	public List<ReimbStatus> findAll() {
		List<ReimbStatus> ReimbStatuss = new ArrayList<ReimbStatus>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_reimbursement_statuses(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				ReimbStatus temp = new ReimbStatus(rs.getInt(1), rs.getString(2));
				// or rs.getString("Name"); Either col num or col name
				ReimbStatuss.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ReimbStatuss;
	}

	public ReimbStatus findOne(Integer id) {
		ReimbStatus a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement_status where reimb_status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new ReimbStatus(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public ReimbStatus save(ReimbStatus obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call insert_reimb_status(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, obj.getReimbStatusName());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				String query = "select reimb_status_id from ers_reimbursement_status where reimb_status_id = (select max(reimb_status_id) from ers_reimbursement_status)";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					obj.setReimbStatusID(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
