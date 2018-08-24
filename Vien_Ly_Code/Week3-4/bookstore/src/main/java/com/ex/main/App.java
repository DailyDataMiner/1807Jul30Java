package com.ex.main;

import java.util.List;
import java.util.Scanner;

import com.ex.pojos.Book;
import com.ex.pojos.Genre;
import com.ex.service.BookService;
import com.ex.service.GenreService;

/*
 * should not interact with DAO layer
 * only service layer
 */
public class App {
	static Scanner scan = new Scanner(System.in);
	static GenreService gService = new GenreService();
	static BookService bService = new BookService();

	public static void main(String[] args) {
		System.out.println("welcome");
		menu();
	}
	
	static void menu() {
		int option = 0;
		System.out.println("1 books");
		System.out.println("2 genres");
		System.out.println("3 authors");
		System.out.println("4 update books");
		System.out.println("5 update genres");
		System.out.println("6 update authors");
		System.out.println("7 add book");
		
		try {
			option = Integer.parseInt(scan.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("input must be 1-6");
			menu();
		}
		
		switch(option) {
		case 1:
		case 2:
			viewGenres();
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			addBook();
		}
	}
	
	static void addBook() {
		System.out.println("isbn");
		String isbn = scan.nextLine();
		System.out.println("title");
		String title = scan.nextLine();
		System.out.println("price");
		double price = Double.parseDouble(scan.nextLine());
		System.out.println("select genre");
		for (Genre g : gService.getAll()) {
			System.out.println(g.getId() + ": " + g.getName());
		}
		int genreid = Integer.parseInt(scan.nextLine());
		Book b = new Book(isbn, title, price, genreid);
		bService.save(b);
		
	}
	
	static void viewGenres() {
		System.out.println("current genres: ");
		List<Genre> genres = gService.getAll();
		for (Genre g : genres) {
			System.out.println(g);
		}
	}
}
