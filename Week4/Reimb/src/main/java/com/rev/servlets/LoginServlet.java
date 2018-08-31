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
import com.rev.pojos.Users;
import com.rev.service.UsersService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	
	public static UsersService uService = new UsersService();
	public static Users dService = new Users();
	
	private static final long serialVersionUID = 1L;

	private static Logger log = 
			Logger.getLogger(LoginServlet.class);
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		log.trace("Initializing LoginServlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//request dispatcher, used for forwarding
		
		System.out.println("doGetLoginServlet");
		
		PrintWriter pw = resp.getWriter();
	
		ObjectMapper mapper = new ObjectMapper();
		resp.getWriter().write(mapper.writeValueAsString(UsersService.login(req, resp)));
		
		//req.getRequestDispatcher("/login").forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		resp.getWriter().write(mapper.writeValueAsString(UsersService.login(req, resp)));
		} catch (NullPointerException np) {
			resp.getWriter().write(mapper.writeValueAsString("Invalid Credentials"));
		}
//		System.out.println("im here post");
////		String name = req.getParameter("username");
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//		ObjectMapper mapper = new ObjectMapper();
//		String json = "";
//		if (br != null) {
//			json = br.readLine();
//		}
//		
//		System.out.println(json);
//        Users userObj = mapper.readValue(json, Users.class);
//        System.out.println(userObj.toString());
//        
//        System.out.println(uService.getAccInfo(userObj.getUsername()));
//		
		
//		
//		
    
	
		
		
//		pw.write(mapper.writeValueAsString(uService.getAccInfo(name)));
	}
}
//		String name = req.getParameter("username");
//		String pass = req.getParameter("password");
//
//		System.out.println("Logging in User " + name + ":" + pass);
//
//		Users u = uService.getAccInfo(name);
//
//		PrintWriter out = resp.getWriter();
//		if (u == null) {
//			out.println("Sorry, invalid username");
//			resp.sendRedirect("/login");
//		}
//		else if (!u.getPassword().equals(pass)) {
//			out.println("Sorry, invalid password");
//			resp.sendRedirect("/login");
//		}
//		else {
//			//valid login
//			//current session or creates a new one if none exists
//			HttpSession session = req.getSession();
//			session.setAttribute("user", u);
//			out.println("Welcome, " + name + "!");
//		}
//
//	}
//	}
