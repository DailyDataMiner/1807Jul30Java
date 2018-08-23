package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loadHome")
public class LoadHomeViewServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.addHeader("Access-Control-Allow-Origin", "*");
		//resp.addHeader("Access-Control-Allow-Methods", "GET, POST, HEAD");
		System.out.println("here");
		req.getRequestDispatcher("Partials/HomeView.html").forward(req, resp);
	}
	
}
