package com.ex.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.dao.ReimbursementDao;
import com.ex.pojos.Employee;
import com.ex.pojos.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementService {

	static ReimbursementDao rd = new ReimbursementDao();

	public Reimbursement addReimbursement(Reimbursement r) {

		return (Reimbursement) rd.save(r);
	}

	public static List<Reimbursement> getReimbursement(HttpServletRequest request, HttpServletResponse response) {

		ObjectMapper mapper = new ObjectMapper();
		Employee employee = null;
		try {
			employee = mapper.readValue(request.getReader(), Employee.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (rd.findOne(employee.getEmpID()));

	}

	public static List<Reimbursement> getAllReimbursement(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rd.findAll();

	}
	public static List<Reimbursement> getAllReimbursementOrder(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimbursements = null;
		try {
			reimbursements = mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rd.findAllOrder(reimbursements.getDescription());

	}
	public static List<Reimbursement> getReimbursementOrder(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = null;
		try {
			employee = mapper.readValue(request.getReader(), Employee.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (rd.findOneOrder(employee.getEmpID(),employee.getLastname()));

	}

	public static Reimbursement submitReimbursement(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimbursements = null;
		try {
			reimbursements = mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		rd.save(reimbursements);
		return reimbursements;
	}
	
	public static Reimbursement approveReimbursement(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimbursements = null;
		try {
			reimbursements = mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		rd.ApproveReimbursement(reimbursements);
		return reimbursements;
	}
	public static Reimbursement denyReimbursement(HttpServletRequest request, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimbursements = null;
		try {
			reimbursements = mapper.readValue(request.getReader(), Reimbursement.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		rd.DenyReimbursement(reimbursements);
		return reimbursements;
	}

}
