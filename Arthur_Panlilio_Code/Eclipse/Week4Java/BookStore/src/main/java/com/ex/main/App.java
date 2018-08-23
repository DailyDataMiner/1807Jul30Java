package com.ex.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ex.pojos.Author;
import com.ex.pojos.Book;
import com.ex.pojos.Genre;
import com.ex.service.AuthorService;
import com.ex.service.BookService;
import com.ex.service.GenreService;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static AuthorService aService = new AuthorService();
	static GenreService gService = new GenreService();
	static BookService bService = new BookService();
	
	public static void main(String[] args) {
		/*
		 * Book store app driver
		 * Should NOT interact with dao layer
		 * only the service layer
		 */
		System.out.println("WELCOME!\n"
				+ "Ready to Read?!");
		menu();
	}
	
	static void menu() {
		System.out.println("--------------------------------Main Menu----------------\n"
				+ "1. View/Update Books\n"
				+ "2. View/Update Genres\n"
				+ "3. View/Update Authors\n"
				+ "4. Add Book\n"
				+ "5. Add Genre\n"
				+ "6. Add Author");
		int option = 0;
		try { //dont use scanner.next int!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException e){
			System.out.println("Sorry! must enter a number bewteen 1-6");
			menu();
		}
		switch(option) {
		case 1:
			viewBooks();
			break;
		case 2:
			viewGenres();
			break;
		case 3:
			viewAuthors();
			break;
		case 4:
			addBook();
			break;
		case 5:
			
			break;
		case 6:
			
			break;
			
		
		}
	}
	
	static void viewGenres() {
		System.out.println("Current Genres:");
		List<Genre> genres = gService.getAll();
		for(Genre g: genres) {
			System.out.println(g.getName());
		}
	}
	
	static void viewAuthors() {
		System.out.println("Current Authors:");
		List<Author> authors = aService.getAll();
		for(Author a: authors) {
			System.out.println(a.getfName() + " " + a.getlName());
		}
	}
	
	
	static void viewBooks() {
		System.out.println("Current Books:");
		List<Book> books = bService.getAll();
		for(Book b: books) {
			System.out.println(b);
		}
	}
	
	static void addBook() {
		System.out.println("Enter your book's title:");
		String title = scanner.nextLine();
		System.out.println("Enter the ISBN (10-digit)");
		String isbn = scanner.nextLine();
		System.out.println("Enter the price");
		Double price = Double.parseDouble(scanner.nextLine());
		System.out.println("Enter genre");
		int genreId = Integer.parseInt(scanner.nextLine());
		Book b = new Book(isbn, title, price, genreId);
		Book b2 = bService.save(b);
		
		
	}
	
}
