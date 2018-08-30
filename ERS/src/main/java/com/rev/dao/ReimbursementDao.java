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

	public static void main(String[] args) {

//		List<Reimbursement> reimbursements = findAllReimbursements();
//		for(Reimbursement r : reimbursements) {
//			System.out.println(r);
//		}

		List<Reimbursement> reimbursements = findReimbursementsByUsername("JohnSmith");
		for(Reimbursement r : reimbursements) {
			System.out.println(r);
		}
		
//		System.out.println(findReimbursementsByUsername("JohnSmith"));

//		System.out.println(findForLogin("JohnSmith", "password"));

	}

	public static List<Reimbursement> findAllReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnection()) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

//	public static Reimbursement findReimbursementsByUserid(int userid) {
//		Reimbursement r = null;
//		try (Connection conn = ConnectionUtil.getConnection()) {
//
//			String sql = "select * from ers_reimbursements where reimbAuthor = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, userid);
//			ResultSet info = ps.executeQuery();
//
//			while (info.next()) {
//				r = new Reimbursement();
//
//				r.setReimbId(info.getInt(1));
//				r.setReimbAmount(info.getDouble(2));
//				r.setReimbSubmitted(info.getString(3));
//				r.setReimbResolved(info.getString(4));
//				r.setReimbDescription(info.getString(5));
//				r.setReimbAuthor(info.getString(6));
//				r.setReimbResolver(info.getString(7));
//				r.setReimbStatusId(info.getString(8));
//				r.setReimbTypeId(info.getString(9));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return r;
//	}

	public static List<Reimbursement> findReimbursementsByUsername(String username) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_reimbursements where reimbAuthor = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();

//			Statement statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(sql);

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

	
//	public static List<Reimbursement> findReimbursementsByUsername(String username) {
//		List<Reimbursement> r = new ArrayList<Reimbursement>();
//		try (Connection conn = ConnectionUtil.getConnection()) {
//
//			String sql = "select * from ers_reimbursements where reimbAuthor = ?";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, username);
//			ResultSet info = ps.executeQuery();
//
//			while (info.next()) {
//
//				r.setReimbId(info.getInt(1));
//				r.setReimbAmount(info.getDouble(2));
//				r.setReimbSubmitted(info.getString(3));
//				r.setReimbResolved(info.getString(4));
//				r.setReimbDescription(info.getString(5));
//				r.setReimbAuthor(info.getString(6));
//				r.setReimbResolver(info.getString(7));
//				r.setReimbStatusId(info.getString(8));
//				r.setReimbTypeId(info.getString(9));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return r;
//	}

	public static User findForLogin(String username, String password) {
		User u = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				u = new User();

				u.setUserid(info.getInt(1));
				u.setUsername(info.getString(2));
				u.setPassword(info.getString(3));
				u.setFirstname(info.getString(4));
				u.setLastname(info.getString(5));
				u.setEmail(info.getString(6));
				u.setRoleid(info.getString(7));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public static Reimbursement saveNewReimbursement(Reimbursement obj) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "insert into ers_reimbursements (reimbAmount, reimbDescription, reimbAuthor, reimbResolver, reimbStatusId, reimbTypeId) values(?, ?, ?, 'admin', 'unresolved', ?)";

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
}
