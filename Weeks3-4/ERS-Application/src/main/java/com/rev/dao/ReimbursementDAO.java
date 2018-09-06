package com.rev.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Reimbursement;
import com.rev.util.ConnectionFactory;

public class ReimbursementDAO implements Dao {

	public List<Reimbursement> findAll() {
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from ERS_Reimbursement";

			// STATEMENT INTERFACE
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				// iterate through each row of result set
				Reimbursement temp = new Reimbursement();
				temp.setReimbID(rs.getInt(1)); // can access cols of RS by either col name or id
				int name = rs.getInt(2);
				temp.setAuthor(name);
				reimb.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	public Reimbursement findOneID(Integer id) {
		Reimbursement r = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from ERS_Reimbursement where User_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			r = new Reimbursement();
			r.setReimbID(info.getInt(1));
			}
			// more code
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public Object findOne(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reimbursement save(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "Insert into ERS_REIMBURSEMENT(reimb_amount, "
					+ "reimb_SUBMITTED, reimb_description, Reimb_author, "
					+ "reimb_type_id) values(?,CURRENT_TIMESTAMP,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setDouble(1, obj.getAmount());
			ps.setDate(2, obj.getSubmitted());
			ps.setString(3, obj.getDescription());
			ps.setInt(4, obj.getAuthor());
			ps.setInt(5, obj.getReimbTypeID());			
			
			
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			
			
				conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public Reimbursement update(Reimbursement obj) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "Update ERS_REIMBURSEMENT SET"
					+ "reimb_resolved = CURRENT_TIMESTAMP, "
					+ "reimb_description = ?, reimb_resolver = ?, "
					+ "reimb_status_id = ? where reimb_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			
			ps.setDate(1, obj.getResolved());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getResolver());
			ps.setInt(4, obj.getReimbStatusID());
			ps.setInt(5, obj.getReimbID());			
			
			
			
			//UPDATES return num rows added/updated/deleted
			//QUERIES return result sets
			int numRowsAffected = ps.executeUpdate();
			
			
				conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object insert(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Object obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object save(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findOneID(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
