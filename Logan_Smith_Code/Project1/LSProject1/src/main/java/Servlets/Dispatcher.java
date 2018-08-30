package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Dispatcher
 */

@WebServlet("/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Dispatcher() {
        super();
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("reached here 1");
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		System.out.println(session.getId());
		out.write(mapper.writeValueAsString(MasterDispatcher.process(req, resp)));
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doPost(req, resp);
	}
}

