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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.User;
import com.revature.service.UserService;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	
	private static Logger log = Logger.getLogger(LoginServlet.class);
	UserService uService = new UserService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String body = getRequestBody(req);

		String[] ss = parse(body);

		String name = ss[1].replace("\"", "");
		String pass = ss[3].replace("\"", "");

		log.trace("Logging in user: " + name + ";" + pass);
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		// create HTML response
		PrintWriter writer = resp.getWriter();
		
		
		User u = uService.find(name);
		if(u == null) {
			writer.append("invalid");
			writer.flush();
		} else if (uService.checkLogin(pass, u)) {
			 HttpSession oldSession = req.getSession(false);
	            if (oldSession != null) {
	                oldSession.invalidate();
	            }
	            //generate a new session
	            HttpSession newSession = req.getSession(true);
	            newSession.setAttribute("user", u);

				writer.append("valid");
				writer.flush();
			
		} else {
			writer.append("invalid");
			writer.flush();
		}
	
	}
	
	private String[] parse(String s) {
		s = s.replace("{", "");
		s = s.replace("}", "");
		s = s.replace(":", ",");
		String[] ss = s.split(",");
		for(String sss : ss) {
			sss = sss.replace("\"", "");
		}
		return ss;
	}
	
	@SuppressWarnings("null")
	private String getRequestBody(final HttpServletRequest request) {
	    final StringBuilder builder = new StringBuilder();
	    try (BufferedReader reader = request.getReader()) {
	        if (reader == null) {
	        	reader.close();
	            return null;
	        }
	        String line;
	        while ((line = reader.readLine()) != null) {
	            builder.append(line);
	        }
	        reader.close();
	        return builder.toString();
	    } catch (final Exception e) {

	        return null;
	    }
	}


}
