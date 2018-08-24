package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.Book;
import com.ex.services.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
	
	static BookService bs = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Book> books = bs.getAllBooks();
		
		if (books.size() > 0) {
			
			ObjectMapper mapper = new ObjectMapper();		// from the jackson api
			String json = mapper.writeValueAsString(books);
			
			PrintWriter out = resp.getWriter();
			
			resp.setContentType("application/json");
			out.write(json);
			
		} else {
			resp.setStatus(404);
		}
		
		//-------

//		System.out.println("IN HTTP SERVLET DOGET");
//		PrintWriter out = resp.getWriter();
//		resp.setContentType("text/html");
//		
//		//Servlet Config is any configuration detail about this particular servlet
////		String info = getServletConfig().getInitParameter("info");
//		out.write("<h1> Hello <b>Genesis</b> ! </h1>"
//				+ "<br> Random init params: <i>" + "..." + "</i>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		PrintWriter out = resp.getWriter();
		
		// Read JSON from client side (bookView)
		BufferedReader br = new BufferedReader(new InputStreamReader( req.getInputStream() ));
		String json = "";
		
		if (br != null) {
			json = br.readLine();
		}
		
		// aadd the aut
		
		System.out.println("JSON line is -> ");
		System.out.println(json);
		
//		{"isbn":"839-99-41382-20-4","title":"My New Title","price":"90.11","genre":"10"}
		System.out.println(Book.class);
		ObjectMapper mapper = new ObjectMapper();

//		String isbn, String title, double price, int genre_id, int author_id

		Book b = mapper.readValue(json, Book.class);
		
		System.out.println(b.toString());
		BookService bookSrv = new BookService();

		bookSrv.addBook(b);
		
		
//-----------------**********************
//		String name = req.getParameter("username");
//		String pass = req.getParameter("password");
//		
//		System.out.println("LOGGING IN USER " + name  + ":" + pass);
//		
////		User u = uService.getByUsername(name);
//		
//		PrintWriter out = resp.getWriter();
//		if(u == null) {
//			//out.println("Sorry, invalid username");
//			resp.sendRedirect("login");
//		}
//		else if(!u.getPassword().equals(pass)) {
//			out.println("Sorry, invalid passsword");
//		}
//		else {
			//valid login getSession() - returns 
			//current session or creates new one if none exists
//			HttpSession session = req.getSession();
//			session.setAttribute("user", u);
//			System.out.println(session.getId());
			//out.println("Welcome, " + name + "!");
//			resp.sendRedirect("home");
//		}
		
		
	}

}
