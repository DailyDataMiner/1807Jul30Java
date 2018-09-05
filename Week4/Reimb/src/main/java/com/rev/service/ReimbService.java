package com.rev.service;

import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.rev.dao.ReimbDao;
import com.rev.pojos.Reimb;

public class ReimbService {

	static ReimbDao rDao = new ReimbDao();
	
	//Employee check their Reimbursements only using strings
	public List<Reimb> checkAccount(int userid){
		return rDao.checkAcc(userid);
	}
	
	//Employee can add a Reimb request
	public void addR (double amount, String description, Blob receipt, int author, int typeid) {
		rDao.addReimb(amount, description, receipt, author, typeid);
	}
	
	//Employee can add a Reimb request w/o blob
		public void addR (double amount, String description, int author, int typeid) {
			rDao.addReimb(amount, description, author, typeid);
		}
	
	//Finance Manager can view all
	public List<Reimb> getAll(){
		return rDao.findAll();
	}
	
	//Manager wants to filter by Status
	
//	public static List<Reimb> findByStatus(HttpServletRequest req, HttpServlet res){
//		
//		
//		return rDao
//	}
//	public List<Reimb> findByStatus(int statusid){
//		return rDao.findAllByStatus(statusid);
//	}
	
	//Manager wants to update ticket status
	public void updateTicket(int statusid, int resolverid, int reimbid) {
		rDao.update(statusid, resolverid, reimbid);
	}
	
	public List<Reimb> getPending() {
		return rDao.findAllByStatus("Pending");
	}
	
	public List<Reimb> getApproved() {
		return rDao.findAllByStatus("Approved");
	}
	public List<Reimb> getDenied() {
		return rDao.findAllByStatus("Denied");
	}
	
}
