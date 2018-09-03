package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbDao;
import com.revature.model.Reimbursement;
import com.revature.model.UserInformation;

public class ReimbService {
	private static ReimbDao rd = ReimbDao.getInstance();
	
	public static List<Reimbursement> GetReimb(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		
		Reimbursement reimb = null;
		List<Reimbursement> r = new ArrayList<Reimbursement>();
		UserInformation u = (UserInformation) session.getAttribute("user");
		r.addAll(rd.getReimb(u));
//		System.out.println(r.size());
		return r;
}
	public static List<Reimbursement> getAllReimb(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		
		Reimbursement reimb = null;
		List<Reimbursement> r = new ArrayList<Reimbursement>();
		UserInformation ui = (UserInformation) session.getAttribute("user");
		r.addAll(rd.getAllReimb(ui));
		return r;
		
	}
//	Create riemb
	
//	update riemb
}