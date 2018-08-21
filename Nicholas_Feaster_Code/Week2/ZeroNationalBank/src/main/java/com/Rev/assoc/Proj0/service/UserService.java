package com.Rev.assoc.Proj0.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.Rev.assoc.Proj0.DAO.UserDao;
import com.Rev.assoc.Proj0.pojos.UserAcc;

public class UserService {
	static UserDao uw = new UserDao();
	static Scanner userScanner = new Scanner(System.in);
	public void createAccount() {
		
		UserAcc makey = new UserAcc();
		/*ArrayList<UserAcc> repo = uw.findAll();
		ArrayList<String> unrepo = new ArrayList<String>();
		for(UserAcc lvar : repo) {
			unrepo.add(lvar.getUUsername());
		}/*/
		System.out.println("Please enter your desired username");
		String careful = userScanner.nextLine();
		/*if(unrepo.contains(careful)) {
			System.out.println("The desired username already exists! Please enter another desired username: ");
			createAccount();
		}
		else {*/
			makey.setUUsername(careful);
			System.out.println("Enter the desired password: ");
			makey.setUPass(userScanner.nextLine());
			System.out.println("Enter your first name: ");
			makey.setUFirstName(userScanner.nextLine());
			System.out.println("Enter your last name: ");
			makey.setULastName(userScanner.nextLine());
			System.out.println("Almost done! Enter your email address ");
			makey.setUEmail(userScanner.nextLine());
			System.out.println();
			
			uw.save(makey);

	//}
		
		
	
}	
	public static Boolean egg = false;
	public Boolean login() {
		UserAcc makey = new UserAcc();
		ArrayList<UserAcc> repo =  uw.findAll();
		ArrayList<String> unrepo = new ArrayList<String>();
		ArrayList<String> pwrepo = new ArrayList<String>();

		for(UserAcc lvar : repo) {
			unrepo.add(lvar.getUUsername());
			pwrepo.add(lvar.getUPass());
		}
		System.out.println("Welcome, valued customer! Please enter your username: ");
		String unaltered = userScanner.nextLine();
		String naturals = unaltered;//.toLowerCase();
		if(!unrepo.contains(naturals)){
			System.out.println("We could not find that username. Please try again.");
		}
		else {
			makey.setUUsername(unaltered);
			System.out.println("Please enter your password: ");
			String thisToo = userScanner.nextLine();
			if(pwrepo.contains(thisToo)) {
				makey.setUPass(thisToo);
				egg = true;
				System.out.println("Login successful!");
			}
			
		}
		return egg;
	}
	public static void logout() {
		egg = false;
		uw = null;
		System.out.println("You have been logged out;");
	}
}

