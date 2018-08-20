package com.rev.main;

import java.util.List;
import java.util.Scanner;

import com.rev.pojos.Client;
import com.rev.service.ClientService;

import com.rev.pojos.UserClient;
import com.rev.service.UserClientService;

import com.rev.pojos.UserClient;
import com.rev.service.UserClientService;

import com.rev.pojos.UserClient;
import com.rev.service.UserClientService;

import com.rev.pojos.UserClient;
import com.rev.service.UserClientService;

public class App {

	static Scanner scanner = new Scanner(System.in);
	static UserClientService ucService = new UserClientService();

	public static void main(String[] args) {
		/*
		 * BOOK STORE APP DRIVER
		 * should NOT interact directly with DAO layer!
		 * only the service layer
		 */
		System.out.println("WELCOME to the Revature Banking App!\n"
				+ "Please enter your username and password to log in");
		
		System.out.print("Username: ");
		String username = scanner.nextLine();
		
		System.out.println(ucService.itsnotHere(username));
		if (ucService.itsnotHere(username) == false ) {
			System.out.println("The username you have entered as already been taken");
		}
		
	
		
		
		/*try {
			//username = String.parseString(scanner.nextLine());
		}*/
		
		//menu();
	}

	/*static void menu() {
		System.out.println("---------Menu--------\n"
				+ "1. Deposit\n"
				+ "2. T\n"
				+ "3. View/Update Authors\n"
				+ "4. Add Book\n"
				+ "5. Add Genre\n"
				+ "6. Add Author");
		int option = 0;
		try { //DONT USE SCANNER.NEXT INT!!!!!!
			option = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Sorry, you must enter a number between 1 and 6 :)");
			menu();
		}
		
		switch(option) {
		case 1:
		case 2:
		
		break;
		case 3: 
			break;
		case 4:
			
			break;
			//
		}
	}*/
	
	static void addClient() {
		System.out.print("Enter your first name: ");
		String firstname = scanner.nextLine();
		System.out.print("Enter your last name: ");
		String lastname = scanner.nextLine();
		System.out.print("Enter your street address ");
		String streetaddress = scanner.nextLine();
		System.out.print("Enter your city: ");
		String city = scanner.nextLine();
		System.out.print("Enter your state: ");
		String state = scanner.nextLine();
		System.out.print("Enter your country: ");
		String country = scanner.nextLine();
		System.out.print("Enter your zipcode: ");
		
		int zipcode = 0;
		try {
				zipcode = Integer.parseInt(scanner.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("Please enter a valid zipcode");
			
		}
		System.out.print("Enter your your phone number: ");
		String phonenumber = scanner.nextLine();
		System.out.print("Enter your email: ");
		String email = scanner.nextLine();
		
		/*List<UserClient> genres = UserClientService.getAll();
		for(int i = 0; i < genres.size(); i++) {
			System.out.println(i+1 + ": " + genres.get(i));*/
	}
		
	}
	/*static void addBook() {
		System.out.println("Enter your book's title:");
		String title = scanner.nextLine();
		System.out.println("Enter the ISBN (10-digit number):");
		String isbn = scanner.nextLine();
		System.out.println("Enter the price:");
		double price = Double.parseDouble(scanner.nextLine()); //SURROUND IN TRY CATCH FOR NFE
		System.out.println("Select your Genre(Enter its number)");
		List<UserClient> genres = UserClientService.getAll();
		for(int i = 0; i < genres.size(); i++) {
			System.out.println(i+1 + ": " + genres.get(i));
		}
		int genreIndex = Integer.parseInt(scanner.nextLine())-1;
		int genreID = genres.get(genreIndex).getId();
		Book b = new Book(isbn, title, price, genreID);
		//call book service addBook() which calls dao addBook()
		//WE HAVE MAINTAINED REFERENTIAL INTEGRITY
		
	}
	static void viewGenres() {
		System.out.println("Current Genres:");
		List<Genre> genres = gService.getAll();
		for(Genre g : genres) {
			System.out.println(g.getName());
		}
	}*/

