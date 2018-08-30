package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.pojo.User;

/*Front-control design pattern
 * One servlet. load many views
 * 
 */
public class LoadViewServlet extends HttpServlet {
	

	
	@Override
	public void init() throws ServletException {
		super.init();
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("IN VIEW");
		String resource = "partials/" + process(req,resp) + ".html";
		System.out.println("resource: " + resource);
		req.getRequestDispatcher(resource).forward(req,resp);
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	}
	
	static String process(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getRequestURI());
      
        
		switch(req.getRequestURI()) {
			case "/Project1/test.view":
				return "testview";
			case "/Project1/profile.view":
				if(((User) req.getSession().getAttribute("user")).getRoleId() == 1) {
	        		return "profileuserview";
	        	} else {
	        		return "profilemanagerview";
	        	}
			case "/Project1/login.view":
				if(req.getSession(false)==null) {
		        	System.out.println("no session");
		        	return "loginview";
		        //} else if(req.getSession(false).getAttribute("user") == null) {
		        	//return "loginview";
		        } else {
		        	if(req.getSession(false).getAttribute("user") != null) {
			        	if(((User) req.getSession().getAttribute("user")).getRoleId() == 1) {
			        		return "profileuserview";
			        	} else {
			        		return "profilemanagerview";
			        	}
		        	} else {
		        		return "loginview";
		        	}
		        }
			case "/Project1/about.view":
				return "aboutview";
			case "/Project1/register.view":
				return "registerview";
			case "/Project1/reimuser.view":
				return "reimuserview";
			default:
				return "oopsview";
		}
		
	}
	
}