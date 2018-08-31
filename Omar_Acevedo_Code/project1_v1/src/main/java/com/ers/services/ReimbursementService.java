package com.ers.services;

import java.util.List;

import com.ers.dao.ReimbursementDao;
import com.ers.pojos.Reimbursement;

public class ReimbursementService extends ReimbursementDao {

	public List<Reimbursement> findAll() { return readAll(); }
	
	public void save(Reimbursement reimbObj) { 
		System.out.println("in service.save -> " + reimbObj.toString());
		create(reimbObj); 
	}
	
	public void store(Reimbursement reimbObj) {
		System.out.println("in service.store -> " + reimbObj.toString());
		update(reimbObj);
	}
	
}
