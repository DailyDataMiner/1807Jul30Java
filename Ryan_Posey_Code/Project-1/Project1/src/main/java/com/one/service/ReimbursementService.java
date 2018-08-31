package com.one.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.one.dao.ReimbursementDao;
import com.one.pojos.Reimbursement;
import com.one.pojos.User;

public class ReimbursementService {
	static ReimbursementDao rDao = new ReimbursementDao();
	
	public Reimbursement addReimb(Reimbursement reimb) {
		return null;
	}
	
	public static List<Reimbursement> getReimbs(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		User user = null;
		try {
			user = mapper.readValue(request.getReader(), User.class);
		}
		catch (IOException io) {
			io.printStackTrace();
		}
		
		return (rDao.findOne(user.getId()));
	}
	
	public static List<Reimbursement> getAllReimbs(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException io) {
			io.getStackTrace();
		}
		return rDao.findAll();
	}
	
	public static Reimbursement addReimb(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = null;
		try {
			reimb = mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException io) {
			io.printStackTrace();
		}
		
		rDao.save(reimb);
		return reimb;
	}
	
	//approve
	public static Reimbursement approveReimb(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = null;
		try {
			reimb = mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException io) {
			io.printStackTrace();
		}
		
		rDao.approve(reimb);
		return reimb;
	}
	
	//deny
	public static Reimbursement denyReimb(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = null;
		try {
			reimb = mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException io) {
			io.printStackTrace();
		}
		
		rDao.deny(reimb);
		return reimb;
	}
	
}
