package com.revature.services;

import java.util.List;

import com.jdbz.dao.BookDAO;
import com.jdbz.dao.Dao;
import com.jdbz.pojos.Book;

public class BookService {

	static Dao<Book, Integer> bDao = new BookDAO();
	
	public List<Book> getAll() {
		return bDao.findAll();
	}
}
