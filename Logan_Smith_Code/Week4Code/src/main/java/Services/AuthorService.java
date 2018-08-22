package Services;

import java.util.List;

import DAOs.AuthorDAO;
import DAOs.Dao;
import POJOs.Author;
import POJOs.Book;

public class AuthorService {

static Dao<Author, Integer> aDao = new AuthorDAO();
	
	public List<Author> getAll() {
		return aDao.findAll();
	}
	public Author findOne(int id) {
		return aDao.findOne(id);
	}
	public Author addAuthor(Author a) {
		return (Author) aDao.save(a);
	}
}
