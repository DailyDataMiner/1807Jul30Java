package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.service.ReimbService;

@WebServlet("/reimbursement")
public class ReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Logger log = 
			Logger.getLogger(LoginServlet.class);
	
	public static ReimbService rService = new ReimbService();
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		log.trace("Initializing ReimbServlet");
	}

//    public ReimbServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Reimb");
		response.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
	
		
		PrintWriter pw = response.getWriter();
	//	Timestamp time = new Timestamp(System.currentTimeMillis());
		//pw.write(time.toString());
		pw.write(mapper.writeValueAsString(rService.getAll()));
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
