package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Dispatcher() {
        super();
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter out = resp.getWriter();
		out.write(mapper.writeValueAsString(MasterDispatcher.process(req, resp)));
	}
}
