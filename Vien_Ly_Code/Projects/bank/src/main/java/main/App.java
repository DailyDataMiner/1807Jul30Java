package main;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

import beans.Customer;
import services.AccountService;
import services.CustomerService;
import utils.Password;

public class App {
	static AccountService accService = new AccountService();
	static CustomerService custService = new CustomerService();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		menu();
	}
	
	static void menu() throws NoSuchAlgorithmException, InvalidKeySpecException {
		int option = 0;
		System.out.println("1 new user");
		System.out.println("2 login");
		
		try {
			option = Integer.parseInt(scan.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("input must be 1-6");
			menu();
		}
		
		switch(option) {
			case 1:
				createNewCustomer();
				break;
			case 2:
				logIn();
				break;
			default:
				return;
		}
	}
	
	static void createNewCustomer() throws NoSuchAlgorithmException, InvalidKeySpecException {
		System.out.println("username");
		String username = scan.nextLine();
		System.out.println("first name");
		String firstName = scan.nextLine();
		System.out.println("last name");
		String lastName = scan.nextLine();
		System.out.println("password");
		String password = scan.nextLine();
		String passwordHash = Password.getHash(password);
		Customer newCustomer = new Customer(username, firstName, lastName, passwordHash);
		custService.save(newCustomer);
	}
	
	static void logIn() throws NoSuchAlgorithmException, InvalidKeySpecException {
		System.out.println("Login");
		System.out.println("username");
		String username = scan.nextLine();
		System.out.println("password");
		String userInputPwd = scan.nextLine();
		Customer test = custService.findOne(username);
		if(test.getId() > 0) {
			if(Password.validatePassword(userInputPwd, test.getPasswordHash())) {
				System.out.println("authenticated");
			} else {
				System.out.println("password does not match");
				logIn();
			}
		}
	}

}
