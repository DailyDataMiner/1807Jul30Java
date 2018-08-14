package com.ex.main;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.BookDao;
import com.ex.dao.GenreDao;
import com.ex.helpers.HelperFunctions;
import com.ex.pojos.Book;
import com.ex.pojos.Genre;

public class App extends HelperFunctions {

	private static GenreDao genreDao;
	private static BookDao bookDao;
	
	private static Genre genre;
	private static List<Genre> genresList;
	private static Book book;
	private static List<Book> booksList;

	private static boolean success = false;
	private static String genreName = "Motivation8";
	private static String[] genreList;
	
//	public class Test{     
//		public static void testInts(Integer obj, int var){         
//			obj = var++;         
//			obj++;     
//			}     public static void main(String[] args) {         Integer val1 = new Integer(5);         int val2 = 9;         testInts(val1++, ++val2);         System.out.println(val1+" "+val2);     } }            
//	
//	
	
	public static void main(String[] args) {
		
		 
		// when there is no connection to db.
		// try and catch exception SQLRecoverableException
        

		
		
// 		Display genres
		showGenreData();
		
//	 	Create genre
//		if ( success = createGenre(genreName) ) {
			int genreId = createGenre(genreName);
			print(genreName + ", id: " + genreId + " successfully created. ");
			success = false;
//		} else {
//			print("Uh oh, something occured :(");
//		}
		
//		genreList = new ArrayList<String>();
//		createGenre(genreList);

		
// 		Display specific genre through id.
		showSpecificGenre(1);
		
		
//		Display books
		showBooks();
		
//		Create book
		int bookId = createBook(new Book("829-70-41322-30-1", "Highly Effective People", 31.99, genreId, 1));
		print("Book id: " + bookId + " successfully created.");

	}

	private static void showGenreData() {
		
		genresList = new ArrayList<Genre>();
		genreDao = new GenreDao();
		
		genresList = genreDao.findAll();
		for ( int i = 0; i < genresList.size(); i++ ) {
			print( "Show info for genre: " + genresList.get(i).getName() );
			print( genresList.get(i).toString() );
		}
		
	}
	
	private static int createGenre(String p_genre) {
		
		genre = new Genre(p_genre);
		genre = genreDao.save(genre);
		print(genre.toString());
		
		return genre.getId();	
	}
	
	// Overloading fn with array
	private static int createGenre(String[] p_genre) {
		// Create Genre objects based on String[] elements.
		
		return 0;
	}
	
	private static void showSpecificGenre(int p_genreid) {
		
		genreDao = new GenreDao();
		genre = new Genre();
		
		genre = genreDao.findOne(p_genreid);
		print(genre.toString());
		
	}
	
	private static void showBooks() {
		
		bookDao = new BookDao();
		booksList = bookDao.findAll();
		
		for ( int i = 0; i < booksList.size(); i++ ) {
			
			print( "Book ISBN: " + booksList.get(i).getIsbn() );
			print( i + ": " + booksList.get(i).toString() );
		}
		
	}
	
	private static int createBook(Book p_book) {
		
		book = new Book();
		book = bookDao.save(p_book);
		
		print(book.toString());
		
		return book.getBook_id();
	}

}
