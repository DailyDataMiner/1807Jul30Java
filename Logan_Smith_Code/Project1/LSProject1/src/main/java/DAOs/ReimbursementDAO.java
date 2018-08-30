package DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import POJOs.Reimbursement;
import POJOs.User;
import oracle.jdbc.OracleTypes;
import util.ConnectionFactory;

public class ReimbursementDAO {

UserDAO userDAO = new UserDAO();
ReimbStatusDAO reimbStatusDAO = new ReimbStatusDAO();
ReimbTypeDAO reimbTypeDAO = new ReimbTypeDAO();
	
	public List<Reimbursement> findAll() {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_reimbursements(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), userDAO.findOne(rs.getInt(7)), userDAO.findOne(rs.getInt(8)), reimbStatusDAO.findOne(rs.getInt(9)), reimbTypeDAO.findOne(rs.getInt(10)));
				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(Reimbursements);
		return Reimbursements;
	}
	
	public List<Reimbursement> findAllByStatus(int statusID) {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_reimbs_by_status(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, statusID);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), userDAO.findOne(rs.getInt(6)), userDAO.findOne(rs.getInt(7)), reimbStatusDAO.findOne(rs.getInt(8)), reimbTypeDAO.findOne(rs.getInt(9)));
				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Reimbursements;
	}
	
	public List<Reimbursement> findAllByType(int typeID) {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_reimbs_by_type(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, typeID);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), userDAO.findOne(rs.getInt(6)), userDAO.findOne(rs.getInt(7)), reimbStatusDAO.findOne(rs.getInt(8)), reimbTypeDAO.findOne(rs.getInt(9)));
				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Reimbursements;
	}
	
	public List<Reimbursement> findAllByAuthor(int authorID) {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_reimbs_by_author(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, authorID);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), userDAO.findOne(rs.getInt(7)), userDAO.findOne(rs.getInt(8)), reimbStatusDAO.findOne(rs.getInt(9)), reimbTypeDAO.findOne(rs.getInt(10)));
				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Reimbursements;
	}
	
	public List<Reimbursement> findAllByResolver(int resolverID) {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_reimbs_by_resolver(?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.setInt(2, resolverID);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), userDAO.findOne(rs.getInt(6)), userDAO.findOne(rs.getInt(7)), reimbStatusDAO.findOne(rs.getInt(8)), reimbTypeDAO.findOne(rs.getInt(9)));
				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Reimbursements;
	}
	
	/*
	public List<Reimbursement> findAllFast() {
		List<Reimbursement> Reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{call get_all_reimbursements(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();

			ResultSet rs = (ResultSet) cs.getObject(1);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBlob(6), userDAO.findOne(rs.getInt(6)), userDAO.findOne(rs.getInt(7)), reimbStatusDAO.findOne(rs.getInt(8)), reimbTypeDAO.findOne(rs.getInt(9)));
				Reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Reimbursements;
	}
	*/
	
	public Reimbursement findOne(Integer id) {
		Reimbursement a = null;
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from ers_reimbursement where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getBlob(6), userDAO.findOne(rs.getInt(6)), userDAO.findOne(rs.getInt(7)), reimbStatusDAO.findOne(rs.getInt(8)), reimbTypeDAO.findOne(rs.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public Reimbursement save(Reimbursement obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call insert_reimbursement(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, obj.getReimbAmount());
			cs.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			cs.setTimestamp(3, obj.getReimbResolved());
			cs.setString(4, obj.getReimbDesc());
			cs.setBlob(5, obj.getReimbReceipt());
			if (obj.getReimbAuthor() != null) {
			cs.setInt(6, obj.getReimbAuthor().getUserID());
			}
			else {
			cs.setNull(6, java.sql.Types.BIGINT);
			}
			if (obj.getReimbResolver() != null) {
			cs.setInt(7, obj.getReimbResolver().getUserID());
			}
			else {
			cs.setNull(7, java.sql.Types.BIGINT);
			}
			if (obj.getReimbStatus() != null) {
			cs.setInt(8, obj.getReimbStatus().getReimbStatusID());
			}
			else {
			cs.setNull(8, java.sql.Types.BIGINT);
			}
			if (obj.getReimbType() != null) {
			cs.setInt(9, obj.getReimbType().getReimbTypeID());
			}
			else {
			cs.setNull(9, java.sql.Types.BIGINT);
			}
			int rows = cs.executeUpdate();

			if (rows != 0) {
				String query = "select reimb_id from ers_reimbursement where reimb_id = (select max(reimb_id) from ers_reimbursement)";
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					obj.setReimbID(rs.getInt(1));
				}
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public Reimbursement updateReimbursementResolved(Reimbursement obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call update_reimb_resolved(?, ?, ?, ?)}";
			System.out.println("This user: " + obj.getReimbResolver().getUserID());
			CallableStatement cs = conn.prepareCall(sql);
			cs.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			cs.setInt(2, obj.getReimbResolver().getUserID());
			cs.setInt(3, obj.getReimbStatus().getReimbStatusID());
			cs.setInt(4, obj.getReimbID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void delete(Reimbursement obj) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "{call delete_reimb(?)}";

			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, obj.getReimbID());
			int rows = cs.executeUpdate();

			if (rows != 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
