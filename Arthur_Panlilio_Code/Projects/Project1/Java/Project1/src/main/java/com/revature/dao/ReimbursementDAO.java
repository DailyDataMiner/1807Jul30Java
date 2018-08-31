package com.revature.dao;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
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
				if(rs.getDate(4) != null) {
					r.setResolved(rs.getDate(4).toLocalDate());
				}
				r.setDescription(rs.getString(5));
				r.setAuthor(rs.getInt(6));
				r.setResolver(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				r.setResponse(rs.getString(10));
				
				reimbursements.add(r);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public List<Reimbursement> findByAuthorId(int id){
		List<Reimbursement> reimbursements = new ArrayList<>();
		System.out.println("ID " + id );
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM reimbursements WHERE author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setSubmitted(rs.getDate(3).toLocalDate());
				if(rs.getDate(4) != null) {
					r.setResolved(rs.getDate(4).toLocalDate());
				}
				r.setDescription(rs.getString(5));
				r.setAuthor(rs.getInt(6));
				r.setResolver(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				r.setResponse(rs.getString(10));
				reimbursements.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public Reimbursement findOne(int id){
		Reimbursement r = null;
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM reimbursements WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r = new Reimbursement();
				r.setId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setSubmitted(rs.getDate(3).toLocalDate());
				r.setResolved(rs.getDate(4).toLocalDate());
				r.setDescription(rs.getString(5));
				r.setAuthor(rs.getInt(6));
				r.setResolver(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				r.setResponse(rs.getString(10));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public Reimbursement Update(int rId, int resId, int status, LocalDate newDate, String response ) {
		System.out.println(rId + " " + resId + " " + status + " " + Date.valueOf(newDate) +  " " + response);
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory
				.getConnection()){
			
			String sql = "{call UpdateRe(?, ?, ?, ?, ?)}";		
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1,rId);
			cs.setInt(2, resId);
			cs.setInt(3, status);
			cs.setDate(4, Date.valueOf(newDate));
			cs.setString(5, response);
			cs.execute();		
			System.out.println("A");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	@Override
	public Reimbursement save(Reimbursement r) {
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory
				.getConnection()){
			//connections automatically commit after tx is complete, set to false to do some sort of validation
			conn.setAutoCommit(false);					
			String sql = "INSERT INTO reimbursements (amount, submitted, description, author, statusId, typeId) VALUES (?, ?, ?, ?, ?, ?)";
			//code to get back auto-generated PK (other columns can be auto generated too)
			String[] keys = {"id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);
				
			ps.setDouble(1, r.getAmount());
			ps.setDate(2, Date.valueOf(r.getSubmitted()));
			//ps.setDate(3, Date.valueOf(r.getResolved()));
			ps.setString(3, r.getDescription());
			//ps.setBlob(5, r.getReceipt());
			ps.setInt(4, r.getAuthor());
			//ps.setInt(7, r.getResolver());
			ps.setInt(5, r.getStatusId());
			ps.setInt(6, r.getTypeId());
			
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
	
	public String findType(int typeId) {
		String type  = "";
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT type FROM reimbursementtype WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, typeId);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				type = info.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}
	
	public String findStatus(int statusId) {
		String status  = "";
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT status FROM reimbursementstatus WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
				status = info.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Reimbursement> findAllStatus(int status) {
		List<Reimbursement> reimbursements = new ArrayList<>();
		ConnectionFactory.getInstance();
		try(Connection conn = ConnectionFactory.getConnection()){
			String sql = "SELECT * FROM reimbursements WHERE statusId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setId(rs.getInt(1));
				r.setAmount(rs.getDouble(2));
				r.setSubmitted(rs.getDate(3).toLocalDate());
				if(rs.getDate(4) != null) {
					r.setResolved(rs.getDate(4).toLocalDate());
				}
				r.setDescription(rs.getString(5));
				r.setAuthor(rs.getInt(6));
				r.setResolver(rs.getInt(7));
				r.setStatusId(rs.getInt(8));
				r.setTypeId(rs.getInt(9));
				r.setResponse(rs.getString(10));
				reimbursements.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}


}
