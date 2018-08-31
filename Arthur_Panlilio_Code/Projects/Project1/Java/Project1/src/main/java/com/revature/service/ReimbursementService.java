package com.revature.service;

import java.time.LocalDate;
import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.UserDAO;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class ReimbursementService {
	
	private ReimbursementDAO rDao = new ReimbursementDAO();
	private UserService uService = new UserService();
	
	public List<Reimbursement> getAll(){
		List<Reimbursement> reimbursements =  rDao.findAll();
		for(Reimbursement r: reimbursements) {
			r = appendInfo(r);
		}
		return reimbursements;
	}
	
	public Reimbursement find(int id) {
		Reimbursement r = rDao.findOne(id);
		return r;
	}
	
	public List<Reimbursement> getByAuthorId(int id){
		List<Reimbursement> reimbursements =  rDao.findByAuthorId(id);
		for(Reimbursement r: reimbursements) {
			r = appendInfo(r);
		}
		return reimbursements;
		
	}
	
	public void update(int rId, int resId, int status, LocalDate newDate, String response) {
		newDate = getRealDate(newDate);
		rDao.Update(rId, resId, status, newDate, response);
	}

	
	
	public Reimbursement addReimbursement(Reimbursement r) {
		r.setSubmitted(getRealDate(r.getSubmitted()));
		return appendInfo(rDao.save(r));
	}
	
	public Reimbursement appendInfo(Reimbursement r) {
		if(r.getAuthor() != 0) {
			User u2 = uService.find(r.getAuthor());
			User u = new User(u2.getUsername(), u2.getFirstname(), u2.getLastname(), u2.getEmail());
			r.setAuthorData(u);
		}
		
		if(r.getResolver() != 0) {
			User uu2 = uService.find(r.getResolver());
			User uu = new User(uu2.getUsername(), uu2.getFirstname(), uu2.getLastname(), uu2.getEmail());
			r.setResolverData(uu);
		}
		
		//r.setType(rDao.findType(r.getTypeId()));
		//r.setStatus(rDao.findStatus(r.getStatusId()));	
		return r;
	}

	public List<Reimbursement> getAllPending() {
		List<Reimbursement> reimbursements =  rDao.findAllStatus(1);
		for(Reimbursement r: reimbursements) {
			r = appendInfo(r);
		}
		return reimbursements;
	}
	
	public LocalDate getRealDate(LocalDate fakeDate) {	
		LocalDate realDate = fakeDate.minusYears(260);
		return realDate;
		
	}

}
