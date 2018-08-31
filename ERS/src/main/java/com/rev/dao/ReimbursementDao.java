package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Reimbursement;
import com.rev.pojos.User;
import com.rev.util.ConnectionUtil;

public class ReimbursementDao {

	public static void main(String[] args) throws SQLException {

//		List<Reimbursement> reimbursements = findAllReimbursements();
//		for(Reimbursement r : reimbursements) {
//			System.out.println(r);
//		}

//		List<Reimbursement> reimbursements = findReimbursementsByUsername("JohnSmith");
//		for(Reimbursement r : reimbursements) {
//			System.out.println(r);
//		}

//		System.out.println(findReimbursementsByUsername("JohnSmith"));

//		System.out.println(findForLogin("JohnSmith", "password"));

//		approveRequest(4);
//		denyRequest(5);

	}

	public static List<Reimbursement> findAllReimbursements() throws SQLException {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

//		try (
				Connection conn = ConnectionUtil.getConnection();
//				) {
			String query = "select * from ers_reimbursements";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();

				temp.setReimbId(rs.getInt(1));

				Double reimbAmount = rs.getDouble(2);
				temp.setReimbAmount(reimbAmount);

				String reimbSubmitted = rs.getString(3);
				temp.setReimbSubmitted(reimbSubmitted);

				String reimbResolved = rs.getString(4);
				temp.setReimbResolved(reimbResolved);

				String reimbDescription = rs.getString(5);
				temp.setReimbDescription(reimbDescription);

				String reimbAuthor = rs.getString(6);
				temp.setReimbAuthor(reimbAuthor);

				String reimbResolver = rs.getString(7);
				temp.setReimbResolver(reimbResolver);

				String reimbStatusId = rs.getString(8);
				temp.setReimbStatusId(reimbStatusId);

				String reimbTypeId = rs.getString(9);
				temp.setReimbTypeId(reimbTypeId);

				reimbursements.add(temp);
			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return reimbursements;
	}

	public static List<Reimbursement> findReimbursementsByUsername(String username) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_reimbursements where reimbAuthor = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				Reimbursement temp = new Reimbursement();

				temp.setReimbId(info.getInt(1));

				Double reimbAmount = info.getDouble(2);
				temp.setReimbAmount(reimbAmount);

				String reimbSubmitted = info.getString(3);
				temp.setReimbSubmitted(reimbSubmitted);

				String reimbResolved = info.getString(4);
				temp.setReimbResolved(reimbResolved);

				String reimbDescription = info.getString(5);
				temp.setReimbDescription(reimbDescription);

				String reimbAuthor = info.getString(6);
				temp.setReimbAuthor(reimbAuthor);

				String reimbResolver = info.getString(7);
				temp.setReimbResolver(reimbResolver);

				String reimbStatusId = info.getString(8);
				temp.setReimbStatusId(reimbStatusId);

				String reimbTypeId = info.getString(9);
				temp.setReimbTypeId(reimbTypeId);

				reimbursements.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	public static Reimbursement saveNewReimbursement(Reimbursement obj) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "insert into ers_reimbursements (reimbAmount, reimbDescription, reimbAuthor, reimbResolver, reimbStatusId, reimbTypeId) values(?, ?, ?, 'admin', 'pending', ?)";

			String[] keys = { "reimbId" };

			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setDouble(1, obj.getReimbAmount());
			ps.setString(2, obj.getReimbDescription());
			ps.setString(3, obj.getReimbAuthor());
			ps.setString(4, obj.getReimbTypeId());

			ps.executeUpdate();

			ResultSet pk = ps.getGeneratedKeys();

			while (pk.next()) {
				obj.setReimbId(pk.getInt(1));
			}
		} catch (SQLException e) {
			return null;
		}
		return obj;
	}

	public static void approveRequest(int reimbId) throws SQLException {

//		try (
		Connection conn = ConnectionUtil.getConnection();
//				) {
		String sql = "update ers_reimbursements set reimbStatusId = 'Approved' where reimbId = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reimbId);
		ResultSet info = ps.executeQuery();

//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public static void denyRequest(int reimbId) throws SQLException {

//		try (
		Connection conn = ConnectionUtil.getConnection();
//				) {
		String sql = "update ers_reimbursements set reimbStatusId = 'Denied' where reimbId = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reimbId);
		ResultSet info = ps.executeQuery();

//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
