package main;

import java.util.List;
import java.util.Scanner;

import beans.Account;
import beans.Customer;
import services.AccountService;
import services.CustomerService;
import utils.Password;

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
		System.out.println("-999 end program");
		System.out.println("1 new user");
		System.out.println("2 login");
		int option = Integer.parseInt(scan.nextLine());
		switch(option) {
		case 1:
			createNewCustomer();
			break;
		case 2:
			logIn();
			System.out.println(currentCustomer);
			break;
		default:
			break;
		}
		mainMenu();
	}
	
	static void menu(){
		int option = 0;
		System.out.println("3 register account");
		System.out.println("4 show all accounts");
		System.out.println("5 check specific account");
		System.out.println("6 to withdraw from an account");
		System.out.println("7 to deposit to an account");
		System.out.println("8 to transfer");
		System.out.println("0 logout");
		try {
			option = Integer.parseInt(scan.nextLine());
		} catch(NumberFormatException e) {
			System.out.println("input must be 1-6");
			menu();
		}
		
		switch(option) {
			case 3:
				registerNewAccount();
				break;
			case 4:
				getAllCustomerAccounts();
				break;
			case 5:
				findAccountById();
				break;
			case 6:
				withdraw();
				break;
			case 7:
				deposit();
				break;
			case 8:
				transfer();
				break;
			case 0:
				logOut();
				break;
			case -999:
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
		if (acc != null) {
			double amount = Double.parseDouble(scan.nextLine());
			if (amount > acc.getBalance()) {
				System.out.println("that's more than you have bud");
			} else {
				acc.setBalance(acc.getBalance() - amount);
				acc = accService.update(acc);
				System.out.println("after withdrawal: " + acc);
			}
		} else {
			System.out.println("you do have any account with this accountid");
		}
		menu();
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
			System.out.println("you do have any account with this accountid");
		}
		menu();
	}
	
	static Account findInAccounts(int id) {
		for (Account acc : currentCustomer.getAccounts()) {
			if (acc.getId() == id) {
				return acc;
			}
		}
		return null;
	}
	
	static void transfer() {
		System.out.println("from");
		int fromId = Integer.parseInt(scan.nextLine());
		Account from = findInAccounts(fromId);
		if (from != null) {
			System.out.println("to");
			int toId = Integer.parseInt(scan.nextLine());
			Account to = findInAccounts(toId);
			if (to != null) {
				System.out.println("amount");
				double amount = Double.parseDouble(scan.nextLine());
				if (from.getBalance() < amount) {
					System.out.println("amount exceeds your available fund in account# " + from.getId());
				} else {
					from.setBalance(from.getBalance() - amount);
					to.setBalance(to.getBalance() + amount);
					accService.update(from);
					accService.update(to);
					System.out.println(currentCustomer.getAccounts());
				}
			}
		}
		menu();
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
		Account newAccount = accService.save(new Account(amount, currentCustomer.getId()));
		currentCustomer.addAccount(newAccount);
		for (Account acc : currentCustomer.getAccounts()) {
			System.out.println(acc);
		}
	}
	
	static void createNewCustomer() {
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
	
	static void logIn() {
		System.out.println("Login");
		System.out.println("username");
		String username = scan.nextLine();
		System.out.println("password");
		String userInputPwd = scan.nextLine();
		Customer cust = custService.findOne(username);
		if(cust.getId() > 0) {
			if(Password.validatePassword(userInputPwd, cust.getPasswordHash())) {
				System.out.println("authenticated");
				currentCustomer = cust;
				currentCustomer.setAccounts(getAllCustomerAccounts());
				menu();
			} else {
				System.out.println("password does not match");
				logIn();
			}
		}
	}
	
	static void logOut() {
		currentCustomer = null;
		mainMenu();
	}

}
