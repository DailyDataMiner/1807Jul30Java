package com.revature.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import com.revature.model.Reimbursement;
import com.revature.model.RequestObj;
import com.revature.model.UserInformation;
import com.revature.util.ConnectionFactory;

public class ReimbDao {
	
	private static ReimbDao instance;
	private ReimbDao() {}
	
	public static ReimbDao getInstance() {
		if (instance == null) 
			instance = new ReimbDao();
			return instance;
	}	

//	public void addRiemb(RequestObj reqObj) {
//		try(Connection conn = ConnectionFactory.getConnection()) {
//			PreparedStatement ps = conn.prepareStatement("insert into reimbursement (amount, submit_time, r_desc, author, resolver, rs_id, rt_id) "
//					+ "values (?,sysdate, ?, ?, 1, ?");
//
//			ps.setDouble(1, amount);
//			ps.setString(3, description);
//			ps.setString(4, resolver);
//			ps.setString(6, type);
//		
//	} catch (SQLException e) {
//		System.err.println(e.getErrorCode() + e.getSQLState());
//	}
//	}		
	
	public List<Reimbursement> getReimb(UserInformation ui) {
		Reimbursement r = null;
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();
		int index = 0;
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT R.R_ID, R.AMOUNT, R.SUBMIT_TIME, R.RESOLVED_TIME, R.R_DESC, R.AUTHOR, R.RESOLVER, RS.R_STATUS, RT.R_TYPE FROM REIMBURSEMENT R \r\n" + 
					"INNER JOIN R_STATUS RS ON R.RS_ID=RS.RS_ID INNER JOIN R_TYPE RT ON R.RT_ID=RT.RT_ID WHERE AUTHOR = ?\r\n" + 
					"ORDER BY SUBMIT_TIME desc");
			
			ps.setString(++index, ui.getUsername());
			ResultSet info = ps.executeQuery();
			while (info.next()) {
		

				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Costa_Rica"));
				r = new Reimbursement();
				r.setReimbbId(info.getInt(1));
				r.setAmount(info.getDouble(2));
				r.setSubmitted(info.getTimestamp(3, cal));
				r.setResolved(info.getTimestamp(4, cal));
				r.setDescription(info.getString(2));
				r.setAuthor(info.getString(6));
				r.setResolver(info.getString(7));
				r.setStatus(info.getString(8));
				r.setType(info.getString(9));
				reimb.add(r);
				System.out.println(reimb.size());
			
			}
			} catch (SQLException e) {
				System.err.println(e.getErrorCode() + e.getSQLState());
			}
			return reimb;
			
	}
	

	public List<Reimbursement> getAllReimb(UserInformation ui) {
		Reimbursement r = null;
		List<Reimbursement> reimb = new ArrayList<Reimbursement>();
		int index = 0;
		try(Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT R.R_ID, R.AMOUNT, R.SUBMIT_TIME, R.RESOLVED_TIME, R.R_DESC, R.AUTHOR, R.RESOLVER, RS.R_STATUS, RT.R_TYPE FROM REIMBURSEMENT R \r\n" + 
					"INNER JOIN R_STATUS RS ON R.RS_ID=RS.RS_ID INNER JOIN R_TYPE RT ON R.RT_ID=RT.RT_ID\r\n" + 
					"ORDER BY SUBMIT_TIME desc");
			
			ps.setString(++index, ui.getUsername());
			ResultSet info = ps.executeQuery();
			while (info.next()) {
		

				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Costa_Rica"));
				r = new Reimbursement();
				r.setReimbbId(info.getInt(1));
				r.setAmount(info.getDouble(2));
				r.setSubmitted(info.getTimestamp(3, cal));
				r.setResolved(info.getTimestamp(4, cal));
				r.setDescription(info.getString(2));
				r.setAuthor(info.getString(6));
				r.setResolver(info.getString(7));
				r.setStatus(info.getString(8));
				r.setType(info.getString(9));
				reimb.add(r);
				System.out.println(reimb.size());
			
			}
			} catch (SQLException e) {
				System.err.println(e.getErrorCode() + e.getSQLState());
			}
			return reimb;
					
		}
}
