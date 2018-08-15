package main;

import java.util.List;
import java.util.Scanner;

import beans.Account;
import beans.Customer;
import exceptions.NoSuchAccountException;
import services.AccountService;
import services.CustomerService;
import utils.Password;
import exceptions.*;

public class App {
	static AccountService accService = new AccountService();
	static CustomerService custService = new CustomerService();
	static Scanner scan = new Scanner(System.in);
	
	private static Customer currentCustomer;
	
	public static void main(String[] args) {
		while (true) {
			if (currentCustomer == null) {
				mainMenu();
			} else {
				menu();
			}
		}
	}
	
	static void mainMenu() {
		System.out.println("---MENU---");
		System.out.println("1 new user");
		System.out.println("2 login");
		System.out.println("-1 to exit the program");

		int option = 0;
		try {
			option = Integer.parseInt(scan.nextLine());
			if (option != -1 && option != 1 && option != 2) {
				throw new NumberFormatException();
			}
		} catch(NumberFormatException e) {
			System.out.println("input must be 1 or 2");
			mainMenu();
		}
		
		switch(option) {
		case 1:
			createNewCustomer();
			break;
		case 2:
			logIn();
			break;
		case -1:
			System.exit(0);
		default:
			mainMenu();
		}
		mainMenu();
	}
	
	static void menu(){
		int option = 0;
		System.out.println("---USER CONTROL PANEL---");
		System.out.println("1 register account");
		System.out.println("2 show all accounts");
		System.out.println("3 check specific account");
		System.out.println("4 to withdraw from an account");
		System.out.println("5 to deposit to an account");
		System.out.println("6 to transfer");
		System.out.println("7 to close an account");
		System.out.println("0 logout");
		System.out.println("-1 to exit the program");

		try {
			option = Integer.parseInt(scan.nextLine());
			if (option < -1 || option > 7) {
				throw new NumberFormatException();
			}
		} catch(NumberFormatException e) {
			System.out.println("input must be -1 to 7");
			menu();
		}
		
		switch(option) {
			case 1:
				registerNewAccount();
				break;
			case 2:
				getAllCustomerAccounts();
				break;
			case 3:
				findAccountById();
				break;
			case 4:
				withdraw();
				break;
			case 5:
				deposit();
				break;
			case 6:
				transfer();
				break;
			case 7:
				delete();
				break;
			case 0:
				logOut();
				break;
			case -1:
				System.exit(0);
			default:
				return;
		}
		menu();
	}

	static void withdraw() {
		System.out.println("id of account to withdraw from: ");
		int id = Integer.parseInt(scan.nextLine());
		Account acc = findInAccounts(id);
		System.out.println(acc);
		if (acc != null) {
			System.out.println("Enter the amount to withdraw");
			double amount = Double.parseDouble(scan.nextLine());
			if (amount > acc.getBalance()) {
				try {
					throw new NotEnoughFundException(id);
				} catch (NotEnoughFundException e) {
					System.out.println(e.getMessage());
				}
			} else {
				acc.setBalance(acc.getBalance() - amount);
				acc = accService.update(acc);
				System.out.println("after withdrawal: " + acc);
			}
		} else {
			try {
				throw new NoSuchAccountException(id);
			} catch (NoSuchAccountException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	static void deposit() {
		System.out.println("id of account to deposit to: ");
		int id = Integer.parseInt(scan.nextLine());
		Account acc = findInAccounts(id);
		if (acc != null) {
			double amount = Double.parseDouble(scan.nextLine());
			acc.setBalance(acc.getBalance() + amount);
			acc = accService.update(acc);
			System.out.println("after deposit: " + acc);
		} else {
			try {
				throw new NoSuchAccountException(id);
			} catch (NoSuchAccountException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	static Account findInAccounts(int id) {
		for (Account acc : currentCustomer.getAccounts()) {
			if (acc.getId() == id) {
				return acc;
			}
		}
		return null;
	}
	
	static void delete() {
		System.out.println("account to be closed");
		int id = Integer.parseInt(scan.nextLine());
		Account closing = findInAccounts(id);
		if (closing != null) {
			if (closing.getBalance() > 0) {
				System.out.println("choose an account to transfer funds to or -1 to withdraw");
				int input = Integer.parseInt(scan.nextLine());
				System.out.println(input);
				Account to = findInAccounts(input);
				if (input > -1 && to != null) {
					to.setBalance(to.getBalance() + closing.getBalance());
					accService.update(to);
				}
				accService.delete(closing);
				currentCustomer.removeAccount(closing);
			}
		} else {
			try {
				throw new NoSuchAccountException(id);
			} catch (NoSuchAccountException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	static void transfer() {
		System.out.println("from");
		int fromId = Integer.parseInt(scan.nextLine());
		Account from = findInAccounts(fromId);
		if (from != null) {
			System.out.println("to");
			int toId = Integer.parseInt(scan.nextLine());
			Account to = accService.findOne(toId);
			if (!to.equals(from) && to != null) {
				System.out.println("amount");
				double amount = Double.parseDouble(scan.nextLine());
				if (from.getBalance() < amount) {
					try {
						throw new NotEnoughFundException(fromId);
					} catch (NotEnoughFundException e) {
						System.out.println(e.getMessage());
					}
				} else {
					from.setBalance(from.getBalance() - amount);
					to.setBalance(to.getBalance() + amount);
					accService.update(from);
					accService.update(to);
				}
			} else {
				try {
					throw new Exception("Invalid destination account");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			try {
				throw new NoSuchAccountException(fromId);
			} catch (NoSuchAccountException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	static void findAccountById() {
		System.out.println("Enter id of the account you'd like to see the details of");
		int id = Integer.parseInt(scan.nextLine());
		for (Account acc : currentCustomer.getAccounts()) {
			if (acc.getId() == id) {
				System.out.println(acc);
				return;
			}
		}
		System.out.println("no account found");
	}
	
	static List<Account> getAllCustomerAccounts() {
		List<Account> accs = accService.findAllByCustomerId(currentCustomer.getId());
		for (Account acc : accs) {
			System.out.println(acc);
		}	
		return accs;
	}
	
	static void registerNewAccount() {
		System.out.println("Initial account deposit: ");
		double amount = Double.parseDouble(scan.nextLine());
		if (amount < 0) {
			try {
				throw new Exception("Please specify a positive value to be the base fund");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				registerNewAccount();
			}
		}

		Account newAccount = accService.save(new Account(amount, currentCustomer.getId()));
		currentCustomer.addAccount(newAccount);
	}
	
	static void createNewCustomer() {
		System.out.println("username (at least 4 characters)");
		String username = scan.nextLine();
		try {
			if (username.length() < 4) {
				throw new ShortInputException(username);

			}
		} catch (ShortInputException e) {
			System.out.println(e.getMessage());
			createNewCustomer();
		}
		if (custService.findOne(username) != null) {
			try {
				throw new UsernameNotAvailableException(username);
			} catch (UsernameNotAvailableException e) {
				System.out.println(e.getMessage());
				return;
			}
		}
		System.out.println("first name");
		String firstName = scan.nextLine();
		if (firstName.length() < 1) {
			try {
				throw new ShortInputException(firstName);
			} catch (ShortInputException e) {
				System.out.println(e.getMessage());
				System.out.println("Cannot have empty name fields");
				createNewCustomer();
			}
		}
		System.out.println("last name");
		String lastName = scan.nextLine();
		if (lastName.length() < 1) {
			try {
				throw new ShortInputException(lastName);
			} catch (ShortInputException e) {
				System.out.println(e.getMessage());
				System.out.println("Cannot have empty name fields");
				createNewCustomer();
			}
		}
		System.out.println("password (at least 4 characters");
		String password = scan.nextLine();
		if (password.length() < 4) {
			try {
				throw new ShortInputException(password);
			} catch (ShortInputException e) {
				System.out.println(e.getMessage());
				createNewCustomer();
			}
		}
		String passwordHash = Password.getHash(password);
		Customer newCustomer = new Customer(username, firstName, lastName, passwordHash);
		custService.save(newCustomer);
	}
	
	static void logIn() {
		System.out.println("Login");
		System.out.println("username");
		String username = scan.nextLine();
		Customer cust = custService.findOne(username);
		
		if(cust == null) {
			try {
				throw new NoSuchUserException(username);
			} catch(NoSuchUserException e) {
				return;
			}
		}
		
		System.out.println("password");
		String userInputPwd = scan.nextLine();
		if(Password.validatePassword(userInputPwd, cust.getPasswordHash())) {
			System.out.println("authenticated");
			currentCustomer = cust;
			currentCustomer.setAccounts(getAllCustomerAccounts());
			menu();
		} else {
			try {
				throw new PasswordMismatchException();
			} catch(PasswordMismatchException e) {
				System.out.println(e.getMessage());
				logIn();
			}
		}
	}
	
	static void logOut() {
		currentCustomer = null;
		mainMenu();
	}

}
