package com.revature.main;

import java.util.List;
import java.util.Scanner;

import com.jdbz.pojos.Book;
import com.jdbz.pojos.Genre;
import com.revature.services.BookService;

public class App {

	/*
	 * BOOK STORE APP AND DRIVER
	 */

	static Scanner scanner = new Scanner(System.in);
	static BookService bookService = new BookService();

	public static void main(String[] args) {
		System.out.println("Welcome!\n" + "Ready to read?");
		menu();
	}

	static void menu() {
		System.out.println("Main Menu\n" + "1. View Books\n" + "2. View Genres\n" + "3. View Authors\n"
				+ "4. Add Book\n" + "5. Add Genre\n" + "6. Add Author");
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Input a number.");
			}
		}
		switch (option) {
		case 1:
			getBooks();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			addBook();
			break;
		case 5:
			break;
		case 6:
			break;
		default:
			break;
		}
	}
	public static void getBooks() {
		System.out.println("Current Books:");
		List<Book> books = bookService.getAll();
		for (Book b : books) {
			System.out.println(b.toString());
		}
	}
	public static void addBook() {
		System.out.println("Enter your book's title:");
		String title = scanner.nextLine();
		System.out.println("Enter the ISBN");
		String isbn = scanner.nextLine();
		System.out.println("Enter the price:");
		double price = scanner.nextDouble();
		System.out.println("Select your genre(Enter Number):");
		List<Genre> genres = gService.getAll();
		for (int i = 0; i < genres.size(); i++) {
			System.out.println(i+1 + " : " + genres.get(i+1));
		}
		int genreIndex = Integer.parseInt(scanner.nextLine())-1;
		int genreID = genres.get(genreIndex).getId();
		Book b = new Book(isbn, title, price, genreID);
	}

}
