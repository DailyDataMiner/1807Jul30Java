package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.User;
import com.revature.service.UserService;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(LogoutServlet.class);
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("in the get of LogoutServlet");
		if(req.getSession(false)!=null)
			req.getSession(false).removeAttribute("user");
		req.getSession().invalidate();
		req.getRequestDispatcher("partials/loginview.html").forward(req,resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.trace("in the post of LogoutServlet");
		PrintWriter writer = resp.getWriter();
		if(req.getSession(false)==null) {
			writer.append("in");
			writer.flush();
		} else {
			writer.append("out");
			writer.flush();
		}
	
	}
	


}
