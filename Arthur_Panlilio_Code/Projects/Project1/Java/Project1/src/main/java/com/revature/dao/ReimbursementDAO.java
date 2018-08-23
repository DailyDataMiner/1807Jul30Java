package com.revature.dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.revature.pojo.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO implements DAO<Reimbursement, Integer>{

	@Override
	public List<Reimbursement> findAll(){
		List<Reimbursement> reimbursements = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection()){
			String query = "SELECT * FROM reimbursements";
			//Only use statements for get all.
			// STATEMENT INTERFACE NOT OBJECTS
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setSubmitted(rs.getDate(3).toLocalDate());
				r.setResolved(rs.getDate(4).toLocalDate());
				r.setDescription(rs.getString(5));
				r.setReceipt(rs.getBlob(6));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatusId(rs.getInt(9));
				r.setTypeId(rs.getInt(10));
				
				reimbursements.add(r);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	

	@Override
	public Reimbursement save(Reimbursement r) {
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory
				.getConnection()){
			//connections automatically commit after tx is complete, set to false to do some sort of validation
			conn.setAutoCommit(false);					
			String sql = "INSERT INTO reimbursements (amount, submitted, resolved, description, receipt, author, resolver, statusId, typeId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//code to get back auto-generated PK (other columns can be auto generated too)
			String[] keys = {"id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
				
			ps.setDouble(1, r.getAmount());
			ps.setDate(2, Date.valueOf(r.getSubmitted()));
			ps.setDate(3, Date.valueOf(r.getResolved()));
			ps.setString(4, r.getDescription());
			ps.setBlob(5, r.getReceipt());
			ps.setInt(6, r.getAuthor());
			ps.setInt(7, r.getResolver());
			ps.setInt(8, r.getStatusId());
			ps.setInt(9, r.getTypeId());
			
			//Updates return num rows added/updated/delted
			//Queries return result sets
			int numRowsAffect  = ps.executeUpdate();
			if(numRowsAffect > 0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					r.setId(pk.getInt(1));
				}
			}
			
			conn.commit();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return r;
	}

}
