package com.ex.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Reimbursement;
import com.ex.util.ConnectionFactory;

public class ReimbursementDao implements Dao<Reimbursement, Integer> {

	public static void main(String[] args) {
		ReimbursementDao rd = new ReimbursementDao();
//		System.out.println(rd.findAll());
//		System.out.println(rd.findAll());
		Reimbursement temp = new Reimbursement();
		temp.setAuthor(1);
		temp.setAmount(6969);
		temp.setTypeID(2);
		temp.setDescription("test5");
		temp.setResolver(2);
		temp.setRbID(35);
		rd.ApproveReimbursement(temp);
		rd.DenyReimbursement(temp);
		System.out.println("start");
	}

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String query = "select * from Reimbursement order by REIMB_ID";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setRbID(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getTimestamp(3));
				temp.setResolved(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatusID(rs.getInt(9));
				temp.setTypeID(rs.getInt(10));
				reimbursements.add(temp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public List<Reimbursement> findAllOrder(String order) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String query = "select * from Reimbursement Order by " + order;

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setRbID(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getTimestamp(3));
				temp.setResolved(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatusID(rs.getInt(9));
				temp.setTypeID(rs.getInt(10));
				reimbursements.add(temp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public Reimbursement ApproveReimbursement(Reimbursement obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String query = "{call approveReimbursement(?,?)}";

			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(1, obj.getRbID());
			cs.setDouble(2, obj.getResolver());
			cs.executeUpdate();
			conn.commit();
			System.out.println("sent");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public Reimbursement DenyReimbursement(Reimbursement obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String query = "{call denyReimbursement(?,?)}";

			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(1, obj.getRbID());
			cs.setDouble(2, obj.getResolver());
			cs.executeUpdate();
			conn.commit();
			System.out.println("sent");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public List<Reimbursement> findOne(int empid) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String query = "select * from Reimbursement WHERE REIMB_AUTHOR = " + empid;

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setRbID(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getTimestamp(3));
				temp.setResolved(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatusID(rs.getInt(9));
				temp.setTypeID(rs.getInt(10));
				reimbursements.add(temp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public List<Reimbursement> findOneOrder(int empid, String order) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String query = "select * from Reimbursement WHERE REIMB_AUTHOR = "+ empid +" ORDER BY " + order;

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setRbID(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getTimestamp(3));
				temp.setResolved(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatusID(rs.getInt(9));
				temp.setTypeID(rs.getInt(10));
				reimbursements.add(temp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement save(Reimbursement obj) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String query = "{call addReimbursement(?,?,?,?)}";

			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(1, obj.getAuthor());
			cs.setDouble(2, obj.getAmount());
			cs.setInt(3, obj.getTypeID());
			cs.setString(4, obj.getDescription());
			cs.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Reimbursement update(Reimbursement obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Reimbursement obj) {
		// TODO Auto-generated method stub

	}

}
