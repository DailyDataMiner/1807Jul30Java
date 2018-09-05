package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.dao.ReimbDao;
import com.rev.pojos.Reimb;
import com.rev.pojos.Users;
import com.rev.service.ReimbService;
import com.rev.service.UsersService;

@WebServlet("/*")
public class MasterDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// logging to check for where at any time
	private static Logger log = Logger.getLogger(MasterDispatcher.class);

	public static ReimbService rService = new ReimbService();
	public static UsersService uService = new UsersService();
	public static ReimbDao rDao = new ReimbDao();

	static int author;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		log.trace("Initializing MasterServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		switch (request.getRequestURI()) {
		case "/Reimb/reimbursement":
			pw.write(mapper.writeValueAsString(rService.getAll()));
			break;
		case "/Reimb/pending":
			pw.write(mapper.writeValueAsString(rService.getPending()));
			break;
		case "/Reimb/approved":
			pw.write(mapper.writeValueAsString(rService.getApproved()));
			break;
		case "/Reimb/denied":
			pw.write(mapper.writeValueAsString(rService.getDenied()));
			break;
		}

	}

	// Will use this for
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		ObjectMapper mapper = new ObjectMapper();
		res.setContentType("application/json");
		Users usa = null;
		PrintWriter pw = res.getWriter();
		switch(req.getRequestURI()){
		case "/Reimb/login":
			System.out.println("login");
			try {
				System.out.println("insidelogin");
				res.getWriter().write(mapper.writeValueAsString(UsersService.login(req, res)));
				//usa = mapper.readValue(req.getReader(), Users.class);
				System.out.println("afterread");
				//author = usa.getId();
				} catch (NullPointerException np) {
					res.getWriter().write(mapper.writeValueAsString("Invalid Credentials"));
				}
			break;
		case "/Reimb/update":
			Reimb rec = null;
			
			try {
				rec = mapper.readValue(req.getReader(), Reimb.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(rec.getStatusid() + rec.getAuthor() + rec.getId());
			rDao.update(rec.getStatusid(), 2, rec.getId());
			break;
		case "/Reimb/add":
			Reimb bec = null;
			try {
				bec = mapper.readValue(req.getReader(), Reimb.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(bec.getAmount() + bec.getDescription() + bec.getAuthor() + " "+ bec.getTypeid());
			rDao.addReimb(bec.getAmount(), bec.getDescription(), 1, bec.getTypeid());
			res.getWriter().write(mapper.writeValueAsString(bec));
			break;
		case "/Reimb/checksesh":
			Users ubec = null;
			try {
				ubec = mapper.readValue(req.getReader(), Users.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			res.getWriter().write(mapper.writeValueAsString(ubec));
			break;
		case "/Reimb/logout":
			UsersService.logout(req, res);
			break;
		case "/Reimb/empreimb":
			Reimb jec = null;
			try {
				jec = mapper.readValue(req.getReader(), Reimb.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			res.getWriter().write(mapper.writeValueAsString(rDao.checkAcc(jec.getAuthor())));
			break;
		
		}
	
//		String json = "";
//		Reimb obj = mapper.readValue(json, Reimb.class);
//		double amount = obj.getAmount();
//		String description = obj.getDescription();
//		int typeid = obj.getTypeid();
//		int author = uService.getAccInfo()
//		
//		if()
		
		
//		rService.addR(amount, description, author, typeid);
//		
	}

}
