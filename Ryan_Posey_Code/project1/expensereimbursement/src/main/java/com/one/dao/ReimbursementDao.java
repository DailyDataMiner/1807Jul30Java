package com.one.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.one.pojos.Reimbursement;
import com.one.util.ConnectionFactory;

public class ReimbursementDao implements Dao<Reimbursement, Integer> {

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String query = "select * from ers_reimbursement";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getTimestamp(3));
				temp.setResolved(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor_id(rs.getInt(7));
				temp.setResolver_id(rs.getInt(8));
				temp.setStatus_id(rs.getInt(9));
				temp.setType_id(rs.getInt(10));
				reimbursements.add(temp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public List<Reimbursement> findOne(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String query = "select * from ers_reimbursement where reimb_author = " + id;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setId(rs.getInt(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitted(rs.getTimestamp(3));
				temp.setResolved(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor_id(rs.getInt(7));
				temp.setResolver_id(rs.getInt(8));
				temp.setStatus_id(rs.getInt(9));
				temp.setType_id(rs.getInt(10));
				reimbursements.add(temp);
			}

		} catch (SQLException e) {
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
		return null;
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
