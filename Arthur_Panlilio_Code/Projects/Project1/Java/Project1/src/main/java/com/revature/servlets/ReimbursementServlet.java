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

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {
	
	ReimbursementService rService = new ReimbursementService();
	private static Logger log = Logger.getLogger(ReimbursementServlet.class);

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("In the get of reimbursement servlet");
		List<Reimbursement> reimbursements = new ArrayList<>();
		if(((User) req.getSession().getAttribute("user")).getRoleId() == 2) {
			reimbursements = rService.getAll();		
		} else {
			reimbursements = rService.getByAuthorId(((User) req.getSession().getAttribute("user")).getId());		
		}
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
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(
						req.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement re = mapper.readValue(json, Reimbursement.class);
		log.trace("Post reimbursement " + re.getTypeId());
		LocalDate now = LocalDate.now();
		
		re.setAuthor(((User) req.getSession().getAttribute("user")).getId());
		re.setSubmitted(now);
		re.setStatusId(1);
		
		rService.addReimbursement(re);
	}

}
