package com.ers.services;

import java.util.List;

import com.ers.dao.ReimbursementsDao;
import com.ers.pojos.Reimbursement;

public class ReimbursementService extends ReimbursementsDao {

	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		return findAll();
	}

	public List<Reimbursement> getAllReimbursements_ofType(String type) {
		// TODO Auto-generated method stub
		return findWhereType(type);
	}
	
}
