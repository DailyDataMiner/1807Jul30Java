package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;
import com.revature.servlets.ReimbursementUpdateServlet.reUpdateInfo;

@WebServlet("/reimbursementPending")
public class ReimbursementPendingServlet extends HttpServlet {
	
	ReimbursementService rService = new ReimbursementService();
	private static Logger log = Logger.getLogger(ReimbursementPendingServlet.class);
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursement> reimbursements = new ArrayList<>();
			log.trace("In Get of ReimbursementPendingServlet");
			reimbursements = rService.getAllPending();		

			if(reimbursements.size() > 0) {
				ObjectMapper mapper = new ObjectMapper();
				String json = mapper.writeValueAsString(reimbursements);
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				out.write(json);
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
