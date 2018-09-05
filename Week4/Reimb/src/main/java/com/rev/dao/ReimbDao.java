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
			String sql = "select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, a.USER_FIRST_NAME, b.USER_FIRST_NAME, s.reimb_status, u.reimb_type " + 
					"from ers_reimbursement r " + 
					"join ers_reimbursement_type u " + 
					"on r.REIMB_TYPE_ID = u.REIMB_TYPE_ID " + 
					"join ers_users a " + 
					"on r.reimb_author = a.ERS_USERS_ID " + 
					"left outer join ers_users b " + 
					"on r.reimb_resolver = a.ERS_USERS_ID " + 
					"full outer join ers_reimbursement_status s " + 
					"on r.reimb_status_id = s.reimb_status_id "
					+ "where a.ers_users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				
				Reimb temp = new Reimb();
				temp.setId (info.getInt(1));
				temp.setAmount(info.getDouble(2));
				temp.setSubmitted(info.getTimestamp(3));
				temp.setResolved(info.getTimestamp(4));
				temp.setDescription(info.getString(5));
				temp.setSauthor(info.getString(6));
				temp.setSresolver(info.getString(8));
				temp.setSstatusid(info.getString(8));
				temp.setStypeid(info.getString(9));
				user.add(temp);
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return user;
	}
	
	

	//add a reimbursement (Employee)
	public void addReimb(double amount,String description, Blob receipt, int author, int typeid) {
		Reimb r = new Reimb(amount, description, receipt, author, typeid);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "Insert into Ers_Reimbursement ("
					+ "reimb_amount, "
					+ "reimb_submitted, "
					+ "reimb_description, "
					+ "reimb_receipt, "
					+ "reimb_author, "
					+ "reimb_status_id, "
					+ "reimb_type_id) values (?,?,?,?,?,?,?)";
		
			conn.setAutoCommit(false);
			String[] key = {"REIMB_ID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, key);
		
			ps.setDouble(1, r.getAmount());
			ps.setTimestamp(2, time);
			ps.setString(3,r.getDescription());
			ps.setBlob(4, r.getReceipt());
			ps.setInt(5, r.getAuthor());
			ps.setInt(6, 1);
			ps.setInt(7, r.getTypeid());
			
			
			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				
				ResultSet pk = ps.getGeneratedKeys();
			
				while(pk.next()) {
					r.setId(pk.getInt(1));
					
					
				}
			} conn.commit();
			System.out.println("Adding Reimbursement...");
			} catch (SQLException e) {
				e.printStackTrace();
		}
	
	
	}
	
	//add a reimbursement (Employee) with no blob
		public Reimb addReimb(double amount, String description, int author, int typeid) {
			Reimb r = new Reimb(amount, description, author, typeid);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			try (Connection conn = ConnectionFactory.getInstance().getConnection()){
				String sql = "Insert into Ers_Reimbursement ("
						+ "reimb_amount, "
						+ "reimb_submitted, "
						+ "reimb_description, "
						+ "reimb_author, "
						+ "reimb_status_id, "
						+ "reimb_type_id) values (?,?,?,?,?,?)";
			
				conn.setAutoCommit(false);
				String[] key = {"REIMB_ID"};
				
				PreparedStatement ps = conn.prepareStatement(sql, key);
			
				ps.setDouble(1, r.getAmount());
				ps.setTimestamp(2, time);
				ps.setString(3,r.getDescription());
				ps.setInt(4, author);
				ps.setInt(5, 1);
				ps.setInt(6, r.getTypeid());
				
				
				int rowsUpdated = ps.executeUpdate();
				if (rowsUpdated > 0) {
					
					ResultSet pk = ps.getGeneratedKeys();
				
					while(pk.next()) {
						r.setId(pk.getInt(1));
						
						
					}
				} conn.commit();
				System.out.println("Adding Reimbursement...");
				} catch (SQLException e) {
					e.printStackTrace();
			}
			return r;
		}
	
	//Finance Manager can see all accounts
	public List<Reimb> findAll(){
		List<Reimb> full = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, a.USER_FIRST_NAME, b.USER_FIRST_NAME, s.reimb_status, u.reimb_type " + 
					"from ers_reimbursement r " + 
					"join ers_reimbursement_type u " + 
					"on r.REIMB_TYPE_ID = u.REIMB_TYPE_ID " + 
					"join ers_users a " + 
					"on r.reimb_author = a.ERS_USERS_ID " + 
					"left outer join ers_users b " + 
					"on r.reimb_resolver = a.ERS_USERS_ID " + 
					"full outer join ers_reimbursement_status s " + 
					"on r.reimb_status_id = s.reimb_status_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				
				Reimb temp = new Reimb();
				temp.setId (info.getInt(1));
				temp.setAmount(info.getDouble(2));
				temp.setSubmitted(info.getTimestamp(3));
				temp.setResolved(info.getTimestamp(4));
				temp.setDescription(info.getString(5));
				temp.setSauthor(info.getString(6));
				temp.setSresolver(info.getString(7));
				temp.setSstatusid(info.getString(8));
				temp.setStypeid(info.getString(9));
				full.add(temp);
				//System.out.println(temp);
				

			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return full;
	}
	
	
	
	//Finance Manager wants to filter
	public List<Reimb> findAllByStatus(String statusid){
		List<Reimb> user = new ArrayList<Reimb>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, a.USER_FIRST_NAME, b.USER_FIRST_NAME, s.reimb_status, u.reimb_type " + 
					"from ers_reimbursement r " + 
					"join ers_reimbursement_type u " + 
					"on r.REIMB_TYPE_ID = u.REIMB_TYPE_ID " + 
					"join ers_users a " + 
					"on r.reimb_author = a.ERS_USERS_ID " + 
					"left outer join ers_users b " + 
					"on r.reimb_resolver = a.ERS_USERS_ID " + 
					"full outer join ers_reimbursement_status s " + 
					"on r.reimb_status_id = s.reimb_status_id where s.reimb_status = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, statusid);
			ResultSet info = ps.executeQuery();
			
			while (info.next()) {
				
				Reimb temp = new Reimb();
				temp.setId (info.getInt(1));
				temp.setAmount(info.getDouble(2));
				temp.setSubmitted(info.getTimestamp(3));
				temp.setResolved(info.getTimestamp(4));
				temp.setDescription(info.getString(5));
				temp.setSauthor(info.getString(6));
				temp.setSresolver(info.getString(7));
				temp.setSstatusid(info.getString(8));
				temp.setStypeid(info.getString(9));
				user.add(temp);
				System.out.println(temp.getSstatusid());
		
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return user;
	}


	//Finance Manager wants to change ticket status by Update using new reimb_status_id, reimb_id, and reimb_resolver 
	public void update( int statusid, int resolverid, int reimbid) {
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "Update Ers_Reimbursement set reimb_status_id = ?, reimb_resolver = ?, reimb_resolved = ?  where reimb_id = ?";
			
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, statusid);
			ps.setInt(2, resolverid);
			ps.setTimestamp(3, time);
			ps.setInt(4, reimbid);
		
			
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
//		System.out.println(test.checkAcc("NotMichael"));
		System.out.println("statusfinda" + test.findAllByStatus("Approved"));
		System.out.println("statusfinds" + test.findAllByStatus("Denied"));
		System.out.println("statusfindp" + test.findAllByStatus("Pending"));
//		test.update(3,1,1);
//		test.addReimb(9.25,"Just for Testing", null , 1, 2);

	}
}




