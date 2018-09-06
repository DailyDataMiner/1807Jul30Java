package com.rev.service;

import java.util.List;

import com.rev.dao.ReimbursementDAO;
import com.rev.pojos.Reimbursement;



public class ReimbursementService {
	
	public ReimbursementDAO bDao = new ReimbursementDAO();

	public List<Reimbursement> getAll() {
		return bDao.findAll();
	}

	public void insert(Reimbursement b) {

		bDao.save(b);

	}

	public Object findOneId(Integer b) {

		return bDao.findOneID(b);

	}

}
