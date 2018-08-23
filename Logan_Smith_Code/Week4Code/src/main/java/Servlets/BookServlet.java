package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import POJOs.Book;
import Services.BookService;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

	static BookService bs = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> books = bs.getAll();
		if(books.size() > 0) {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(books);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		}
		else {
			resp.setStatus(404);
		}
	}
	
}
