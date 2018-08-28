package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.Genre;
import com.ex.service.GenreService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/genres")
public class GenreServlet extends HttpServlet {
	
	static GenreService gs = new GenreService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Genre> genres = gs.getAll();
		if(genres.size() > 0) {
			//return books
			
			//Jackson Api
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(genres);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
		} else {
			resp.setStatus(404);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Put book json string into java objct
	}

}
