package Services;

import java.util.List;

import DAOs.Dao;
import DAOs.GenreDAO;
import POJOs.Book;
import POJOs.Genre;

public class GenreService {

static Dao<Genre, Integer> gDao = new GenreDAO();
	
	public List<Genre> getAll() {
		return gDao.findAll();
	}
	public Genre findOne(int id) {
		return gDao.findOne(id);
	}
	
}
