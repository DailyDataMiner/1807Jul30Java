package com.ex.main;

import java.util.List;
import java.util.Scanner;

import com.ex.pojos.Genre;
import com.ex.service.GenreService;

public class App {
	
	static Scanner scanner = new Scanner(System.in);
	static GenreService gService = new GenreService();

	public static void main(String[] args) {
		/*
		 * BOOK STORE APP DRIVER
		 * should NOT interact directly with DAO layer!
		 * only the service layer
		 */
		System.out.println("WELCOME!\n"
				+ "Ready to read?!");
		menu();
	}
	
	static void menu() {
		System.out.println("----------Main Menu----------\n"
				+ "1. View/Update Books\n"
				+ "2. View/Update Genres\n"
				+ "3. View/Update Authors\n"
				+ "4. Add Book\n"
				+ "5. Add Genre\n"
				+ "6. Add Author\n");
		int option = 0;
		try { // DON'T USE SCANNER.NEXTINT!!!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 and 6: ");
			menu();
		}
		
		switch(option ) {
		case 1:
			break;
		case 2:
			viewGenres();
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
	
	static void viewGenres() {
		System.out.println("Current Genres: ");
		List<Genre> genres = gService.getAll();
		for(Genre g : genres) {
			System.out.println(g.getName());
		}
	}
}
