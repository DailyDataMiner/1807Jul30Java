package com.rev.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rev.pojos.Reimb;
import com.rev.util.ConnectionFactory;

public class ReimbDao {

	// check for singular user info based on author id from current session which is
	// reimb_author (Employee)
	public List<Reimb> checkAcc(int userid){
		List<Reimb> user = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from Ers_Reimbursement where Reimb_Author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				
				Reimb temp = new Reimb();
				temp.setId (info.getInt(1));
				temp.setAmount(info.getInt(2));
				temp.setSubmitted(info.getTimestamp(3));
				temp.setResolved(info.getTimestamp(4));
				temp.setDescription(info.getString(5));
				temp.setReceipt(info.getBlob(6));
				temp.setAuthor(info.getInt(7));
				temp.setResolver(info.getInt(8));
				temp.setStatusid(info.getInt(9));
				temp.setTypeid(info.getInt(10));
				user.add(temp);
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return user;
	}

	//add a reimbursement (Employee)
	public void addReimb(double amount, Timestamp submitted, Timestamp resolved, String Description, Blob Receipt, int author, int resolver, int statusid, int typeid) {
		Reimb r = new Reimb(amount, submitted, resolved, Description, Receipt,  author,  resolver,  statusid,  typeid);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "Insert into Ers_Reimbursement ("
					+ "reimb_amount, "
					+ "reimb_submitted, "
					+ "reimb_resolved, "
					+ "reimb_descripton, "
					+ "reimb_receipt, "
					+ "reimb_author, "
					+ "reimb_resolver, "
					+ "reimb_status_id, "
					+ "reimb_type_id) values (?,?,?,?,?,?,?,?,?)";
			conn.setAutoCommit(false);
			String[] key = { "REIMB_ID"};
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1, r.getAmount());
			ps.setTimestamp(2, r.getSubmitted());
			ps.setTimestamp(3, r.getResolved());
			ps.setString(4,r.getDescription());
			ps.setBlob(5, r.getReceipt());
			ps.setInt(6, r.getAuthor());
			ps.setInt(7, r.getResolver());
			ps.setInt(8, r.getStatusid());
			ps.setInt(9, r.getTypeid());
			
			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				
				ResultSet pk = ps.getGeneratedKeys();
				
				while(pk.next()) {
					r.setId(1);
				}
			} conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
		}
	
	
	}
	
	//Finance Manager can see all accounts
	public List<Reimb> findAll(){
		List<Reimb> user = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from Ers_Reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				
				Reimb temp = new Reimb();
				temp.setId (info.getInt(1));
				temp.setAmount(info.getInt(2));
				temp.setSubmitted(info.getTimestamp(3));
				temp.setResolved(info.getTimestamp(4));
				temp.setDescription(info.getString(5));
				temp.setReceipt(info.getBlob(6));
				temp.setAuthor(info.getInt(7));
				temp.setResolver(info.getInt(8));
				temp.setStatusid(info.getInt(9));
				temp.setTypeid(info.getInt(10));
				user.add(temp);
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return user;
	}
	
	
	
	//Finance Manager wants to filter
	public List<Reimb> findAllByStatus(int statusid){
		List<Reimb> user = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select * from Ers_Reimbursement where Reimb_status_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusid);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				
				Reimb temp = new Reimb();
				temp.setId (info.getInt(1));
				temp.setAmount(info.getInt(2));
				temp.setSubmitted(info.getTimestamp(3));
				temp.setResolved(info.getTimestamp(4));
				temp.setDescription(info.getString(5));
				temp.setReceipt(info.getBlob(6));
				temp.setAuthor(info.getInt(7));
				temp.setResolver(info.getInt(8));
				temp.setStatusid(info.getInt(9));
				temp.setTypeid(info.getInt(10));
				user.add(temp);
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return user;
	}


	//Finance Manager wants to change ticket status by Update using new reimb_status_id, reimb_id, and reimb_resolver 
	public void update( int statusid, int resolverid, int reimbid) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "Update Ers_Reimbursement set reimb_status_id = ?, reimb_resolver = ? where reimb_id = ?";
			
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, statusid);
			ps.setInt(2, resolverid);
			ps.setInt(3, reimbid);
		
			
			ps.executeUpdate();
			
			conn.commit();
			
			System.out.println("Reimbursement Status Changed...");
		
			
		}

		catch (SQLException e) {

			e.printStackTrace();
		

		}


	}
	
	
	//Test stuff here
	public static void main(String[] args) {
		ReimbDao test = new ReimbDao();
		System.out.println(test.findAll());
		System.out.println(test.checkAcc(1));
		System.out.println(test.findAllByStatus(1));
		test.update(3,1,1);

	}
}




