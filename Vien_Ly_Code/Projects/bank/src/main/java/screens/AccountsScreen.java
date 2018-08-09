package screens;

import java.util.Scanner;

import dao.UserDAO;

public class AccountsScreen implements Screen{
	private UserDAO userDAO;
	private Screen previousScreen;
	private final String screenName = "Account Screen";
	Scanner scan = new Scanner(System.in);
	
	public AccountsScreen(Screen previous, UserDAO userDAO) {
		this.previousScreen = previous;
		this.userDAO = userDAO;
	}
	
	public String getScreenName() {
		return screenName;
	}
	public void setPreviousScreen(Screen previous) {
		// TODO Auto-generated method stub
		this.previousScreen = previous;
	}
	
	// display all accounts this user has
	// select specific accounts to operate on (considering making a factory of all of the user's accounts)
	// transfer funds between accounts
	// logout logic (going back to StartScreen screen)
	public Screen display() {
		System.out.println("ACCOUNTS");
//		for(Account acc : user.getAccounts()) {
//			System.out.println(acc);
//		}
		System.out.println("1 to withdraw");
		System.out.println("2 to deposit");
		System.out.println("3 to transfer");
		System.out.println("0 to logout");
		int input = Integer.parseInt(scan.nextLine());
		double amount;
		switch(input) {
		case 1:
			System.out.println("WITHDRAW");
			System.out.print("Amount: $");
			amount = Double.parseDouble(scan.nextLine());
			System.out.println("amount to be deposit: $" + amount);
			//TODO: add server logic
			break;
			
		case 2:
			System.out.println("DEPOSIT");
			System.out.print("Amount: $");
			amount = Double.parseDouble(scan.nextLine());
			System.out.println("amount requested: $" + amount);
			//TODO: add server logic
			break;
			
		case 3:
			System.out.println("TRANSFER");
			System.out.print("Account FROM: ");
			int acctFrom = Integer.parseInt(scan.nextLine());
			System.out.print("Account TO: ");
			int acctTo = Integer.parseInt(scan.nextLine());
			System.out.print("Amount: $");
			amount = Double.parseDouble(scan.nextLine());
			System.out.println("Transferring " + amount + " from account #" + acctFrom + " to account #" + acctTo);
			//TODO: add server logic
			break;
			
		case 0:
			System.out.println("logged out");
//			this.user = null;
			return new StartScreen();
			
		default:
			return this;
		}
		return this;
	}

}
