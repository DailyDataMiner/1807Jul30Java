package com.revature.project0.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.project0.myexceptions.InvalidUsernameException;
import com.revature.project0.myexceptions.NotEnoughMoneyException;
import com.revature.project0.myexceptions.UsernameTakenException;
import com.revature.project0.projectobjects.Account;
import com.revature.project0.projectobjects.AccountType;
import com.revature.project0.projectobjects.User;
import com.revature.project0.service.AccountService;
import com.revature.project0.service.AccountTypeService;
import com.revature.project0.service.UserService;
import com.revature.project0.service.UserToAccountService;

public class App {
	/*
	 * Logan Smith's Virtual Bank Driver
	 */
	
	UserInteraction ui = new UserInteraction(this);

	static Scanner scanner = new Scanner(System.in);
	static AccountService accountService = new AccountService();
	static UserService userService = new UserService();
	static UserToAccountService utaService = new UserToAccountService();
	static AccountTypeService atService = new AccountTypeService();

	public static void main(String[] args) {
		System.out.println("Welcome to Logan Smith's Virtual Banking App!");
		App app = new App();
		app.menu();
	}

	// The menu controls the user sign in / sign up. It also allows exit from the program.
	void menu() {
		System.out.println("\nPlease select an option:");
		System.out.println("1: Login \n" + "2: Sign Up\n" + "3: Exit");
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input.");
			}
		}
		switch (option) {
		case 1:
			ui.login();
			break;
		case 2:
			ui.createUser();
			break;
		case 3:
			System.out.println("\nThank you for using the banking app!");
			System.out.println("Goodbye!");
			System.exit(0);
		default:
			System.out.println("Not a valid input.");
			break;
		}
		menu();
	}

	public void userMenu(User currentUser) {
		System.out.println("\nHello " + currentUser.getFirstName());
		System.out.println("What would you like to do?");
		System.out.println("1: Access Accounts\n" + "2: Add Account\n" + "3: Change Username\n" + "4: Change Password\n"
				+ "5: Change Name\n" + "6: Logout");
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input.");
			}
		}
		switch (option) {
		case 1:
			ui.accessAccounts(currentUser);
			break;
		case 2: {
			ui.createAccount(currentUser);
			break;
		}
		case 3: {
			ui.changeUsername(currentUser);
			break;
		}
		case 4: {
			ui.changePassword(currentUser);
			break;
		}
		case 5: {
			ui.changeName(currentUser);
			break;
		}
		case 6:
			menu();
			break;
		default:
			System.out.println("Not a valid option.");
			break;
		}
		userMenu(currentUser);
	}

	public void accountMenu(User currentUser, Account currentAccount) {

		System.out.println("\nYour account balance is: " + currentAccount.getBalance());
		System.out.println("What would you like to do with this account?");
		System.out.println("1: Deposit Funds\n" + "2: Withdraw Funds\n" + "3: Transfer Funds\n" + "4: Remove Account\n"
				+ "5: Add a User to this Account\n" + "6: Remove a User from this Account\n" + "7: Exit Account");
		int option = 0;
		while (option == 0) {
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input.");
			}
		}
		switch (option) {
		case 1: {
			ui.deposit(currentUser, currentAccount);
			break;
		}
		case 2: {
			ui.withdraw(currentUser, currentAccount);
			break;
		}
		case 3: {
			ui.transfer(currentUser, currentAccount);
			break;
		}
		case 4: {
			ui.deleteAccount(currentUser, currentAccount);
			break;
		}
		case 5: {
			ui.addUserToAccount(currentUser, currentAccount);
			break;
		}
		case 6: {
			ui.removeUserFromAccount(currentUser, currentAccount);
			break;
		}
		case 7:
			userMenu(currentUser);
			break;
		}
		accountMenu(currentUser, currentAccount);
	}
}
