package com.ers.services;

import java.util.List;

import com.ers.dao.ReimbursementDao;
import com.ers.pojos.Reimbursement;

public class ReimbursementService extends ReimbursementDao {

	public List<Reimbursement> findAll() { return readAll(); }
	
}
