package com.ex.service;

import java.util.List;

import com.ex.dao.DAO;
import com.ex.dao.genreDAO;
import com.ex.pojos.Genre;

/*
 * service layer is business logic
 * need 2 different DAOs
 * or some sort of manipulation of data
 * either pre or post dao method call
 */
public class GenreService {
	static DAO<Genre, Integer> gDAO = new genreDAO();
	
	public List<Genre> getAll() {
		return gDAO.getAll();
	}
 }
