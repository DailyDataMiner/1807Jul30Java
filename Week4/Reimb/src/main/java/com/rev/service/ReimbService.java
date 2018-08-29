package com.rev.service;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import com.rev.dao.ReimbDao;
import com.rev.pojos.Reimb;

public class ReimbService {

	static ReimbDao rDao = new ReimbDao();
	
	//Employee check their Reimbursements only
	public List<Reimb> checkAccount(int userid){
		return rDao.checkAcc(userid);
	}
	
	//Employee can add a Reimb request
	public void addR (double amount, Timestamp submitted, Timestamp resolved, String Description, Blob Receipt, int author, int resolver, int statusid, int typeid) {
		rDao.addReimb(amount, submitted, resolved, Description, Receipt, author, resolver, statusid, typeid);
	}
	
	//Manager can view all
	public List<Reimb> getAll(){
		return rDao.findAll();
	}
}
