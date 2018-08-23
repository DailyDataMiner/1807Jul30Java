package Services;

import java.util.List;

import DAOs.BookDAO;
import DAOs.Dao;
import POJOs.Author;
import POJOs.Book;

public class BookService {

	public static void main(String[] args) {
		BookService bs = new BookService();
		List<Book> books = bs.getAll();
		System.out.println(books.get(1));
	}
	
	static Dao<Book, Integer> bDao = new BookDAO();
	
	public List<Book> getAll() {
		return bDao.findAll();
	}
	public Book findOne(int id) {
		return bDao.findOne(id);
	}
	public Book addBook(Book b) {
		return (Book) bDao.save(b);
	}
}