package com.ex.services;

import java.util.List;

import com.ex.dao.GenreDao;
import com.ex.pojos.Genre;

public class GenreService extends GenreDao {
	public List<Genre> getAllBooks() {
		return findAll();
	}
}
