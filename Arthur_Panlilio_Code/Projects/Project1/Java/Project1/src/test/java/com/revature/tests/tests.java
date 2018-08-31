package com.revature.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

public class tests {

	@Test
	public void testGetReimbursements() {
		ReimbursementService rService = new ReimbursementService();
		List<Reimbursement> r = rService.getAll();
		assertTrue(r.size() > 0);
	}
	
	@Test
	public void testGetPendingReimbursements() {
		ReimbursementService rService = new ReimbursementService();
		List<Reimbursement> r = rService.getAllPending();
		assertTrue(r.size() > 0);
	}
	
	@Test
	public void testGetUsers() {
		UserService uService = new UserService();
		List<User> u = uService.getAll();
		assertTrue(u.size() > 0);
	}
	
	@Test
	public void testDateConvert() {
		ReimbursementService rService = new ReimbursementService();
		LocalDate inputDate = LocalDate.of(2000,7,25);
		assertTrue(rService.getRealDate(inputDate).equals(LocalDate.of(1740,7,25)));
	}
	


}
