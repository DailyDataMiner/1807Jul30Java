package com.ex.service;

import java.util.List;

import com.ex.dao.AuthorDAO;
import com.ex.dao.BookDAO;
import com.ex.dao.Dao;
import com.ex.pojos.Author;
import com.ex.pojos.Book;

public class AuthorService {
	/*
	 * Service layer is business logic
	 * maybe need two dao methods at once
	 * or dao methods from different classes
	 * or some sort of  manipulation of data either pre or post dao method call should go here
	 */
	
	static Dao<Author, Integer> aDao = new AuthorDAO();
	
	public List<Author> getAll(){
		return aDao.findAll();
	}
	
	public Author save(Author a) {
		return aDao.save(a);
	}

}
