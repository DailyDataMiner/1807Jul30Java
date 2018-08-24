package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import beans.Reimbursement;
import beans.ReimbursementStatus;
import beans.ReimbursementType;
import beans.User;
import oracle.jdbc.internal.OracleTypes;
import utils.ConnectionFactory;

public class ReimbursementDAO implements DAO<Reimbursement> {

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		final String sql = "SELECT * FROM Ers_Reimbursements";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				reimbs.add(parseResultSet(rs));
			}
			return reimbs;
		} catch (SQLException e) {
//			log.error("SQL exception while trying to retrieve users", e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement findOne(int id) {
		final String sql = "SELECT * FROM Ers_Reimbursements WHERE Reimb_Id = ?";
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

	public List<Reimbursement> findAllByAuthor(String username) {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{CALL Find_Reimbs_By_Username(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, username);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while (rs.next()) {
				reimbs.add(parseResultSet(rs));
			}
		} catch (SQLException e) {
			// logger here
			e.printStackTrace();
		}
		return reimbs;
	}

	public List<Reimbursement> findAllByStatus(ReimbursementStatus status) {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{CALL Find_Reimbs_By_Status(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, status.getId());
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while (rs.next()) {
				reimbs.add(parseResultSet(rs));
			}
		} catch (SQLException e) {
			// logger here
			e.printStackTrace();
		}
		return reimbs;
	}

	public List<Reimbursement> findAllByType(ReimbursementType type) {
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{CALL Find_Reimbs_By_Type(?, ?)}";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, type.getId());
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while (rs.next()) {
				reimbs.add(parseResultSet(rs));
			}
		} catch (SQLException e) {
			// logger here
			e.printStackTrace();
		}
		return reimbs;
	}

	// TODO: incorporate receipt blob
	// insert: status always pending
	// resolvedTime and resolver are always null until resolve() is called
	@Override
	public boolean insert(Reimbursement ri) {
		final String sql = "INSERT INTO Ers_Reimbursements "
				+ "(Reimb_Amount, Reimb_Submitted, Reimb_Description, Reimb_Author, Reimb_Status_Id, Reimb_Type_Id) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String[] keys = { "Reimb_Id" };
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			ps.setDouble(1, ri.getAmount());
			ps.setTimestamp(2, ri.getSubmittedTime());
//			ps.setTimestamp(3, ri.getResolvedTime());
			ps.setString(3, ri.getDescription());
//			ps.setBlob(5, ri.getReceipt());
			ps.setInt(4, ri.getAuthorId());
//			ps.setInt(7, ri.getResolverId());
			ps.setInt(5, ReimbursementStatus.PENDING.getId());
			ps.setInt(6, ri.getType().getId());

			int n = ps.executeUpdate();
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (n == 1 && generatedKeys.next()) {
				ri.setId(generatedKeys.getInt(1));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Reimbursement ri) {
		final String sql = "UPDATE Ers_Reimbursements SET "
				+ "Reimb_Amount = ?, Reimb_Submitted = ?, Reimb_Resolved = ?, Reimb_Description = ?, Reimb_Receipt = ?, Reimb_Author = ?, Reimb_Resolver = ?, Reimb_Status_Id = ?, Reimb_Type_Id = ? "
				+ "WHERE Reimb_Id = ?";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, ri.getAmount());
			ps.setTimestamp(2, ri.getSubmittedTime());
			ps.setTimestamp(3, ri.getResolvedTime());
			ps.setString(4, ri.getDescription());
			ps.setBlob(5, ri.getReceipt());
			ps.setInt(6, ri.getAuthorId());
			ps.setInt(7, ri.getResolverId());
			ps.setInt(8, ri.getStatus().getId());
			ps.setInt(9, ri.getType().getId());
			ps.setInt(10, ri.getId());

			int rowsUpdated = ps.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
//			log.error("SQL exception when updating user " + u.getUsername(), e);
		}
		return false;
	}

	@Override
	public boolean delete(Reimbursement ri) {
		final String sql = "DELETE FROM Ers_Reimbursements WHERE Reimb_Id = ?";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ri.getId());
			int rowsDeleted = ps.executeUpdate();
			return rowsDeleted > 0;
		} catch (SQLException e) {
//			log.error("SQL exception when deleting user " + u.getUsername(), e);
		}
		return false;
	}

	private Reimbursement parseResultSet(ResultSet rs) throws SQLException {
		Reimbursement ri = new Reimbursement();
		ri.setId(rs.getInt("Reimb_Id"));
		ri.setAmount(rs.getDouble("Reimb_Amount"));
		ri.setSubmittedTime(rs.getTimestamp("Reimb_Submitted"));
		ri.setResolvedTime(rs.getTimestamp("Reimb_Resolved"));
		ri.setDescription(rs.getString("Reimb_Description"));
		ri.setReceipt(rs.getBlob("Reimb_Receipt"));
		ri.setAuthorId(rs.getInt("Reimb_Author"));
		ri.setResolverId(rs.getInt("Reimb_Resolver"));
		ri.setStatus(ReimbursementStatus.getStatusById(rs.getInt("Reimb_Status_Id")));
		ri.setType(ReimbursementType.getTypeById(rs.getInt("Reimb_Type_Id")));
		return ri;
	}
}
