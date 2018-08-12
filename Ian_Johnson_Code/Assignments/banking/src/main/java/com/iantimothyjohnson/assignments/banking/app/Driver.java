package com.iantimothyjohnson.assignments.banking.app;

import java.io.EOFException;
import java.math.BigDecimal;
import java.util.List;

import com.iantimothyjohnson.assignments.banking.exceptions.AccountAlreadyOwnedByUserException;
import com.iantimothyjohnson.assignments.banking.exceptions.AccountNotFoundException;
import com.iantimothyjohnson.assignments.banking.exceptions.AuthenticationFailureException;
import com.iantimothyjohnson.assignments.banking.exceptions.InsufficientFundsException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserAlreadyExistsException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.pojos.User;
import com.iantimothyjohnson.assignments.banking.service.AccountService;
import com.iantimothyjohnson.assignments.banking.service.SessionManager;
import com.iantimothyjohnson.assignments.banking.service.UserService;
import com.iantimothyjohnson.assignments.banking.ui.AbstractTUI;
import com.iantimothyjohnson.assignments.banking.ui.StandardTUI;

public class Driver {
	/**
	 * The TUI to use to interact with the user.
	 */
	private static AbstractTUI tui;
	/**
	 * The welcome message to show to the user when the program starts.
	 */
	private static final String WELCOME = "Welcome to ITJBank!\n" + "The bank's interface is textual and menu-driven. "
			+ "If you need any help understanding a prompt, just enter '?' (without the quotes) and further instructions will be provided.";

	// We wouldn't want anyone to actually construct one of these!
	private Driver() {
	}

	public static void main(String[] args) {
		// Set up the TUI. In the future, we might try to detect terminal
		// features and provide a nicer interface where the user's terminal can
		// support it.
		tui = new StandardTUI();
		tui.printLine(WELCOME);
		// The program should just keep trying to log users in until one of them
		// enters EOF.
		try {
			while (true) {
				String option = tui.selectValue("Please select an option", "Log in", "Create account", "Exit program");
				switch (option) {
				case "Log in":
					login();
					break;
				case "Create account":
					createUserAccount();
					break;
				case "Exit program":
					return;
				}
			}
		} catch (EOFException e) {
			// Just exit the program if we get EOF.
			return;
		}
	}

	/**
	 * Present the login menu.
	 */
	private static void login() throws EOFException {
		// Keep trying to log the user in until successful.
		while (true) {
			String username = tui.promptNonEmptyLine("Username");
			char[] password = tui.promptPassword("Password");

			// Now, let's try to actually log the user in.
			try {
				User user = SessionManager.getInstance().login(username, password);
				userSession(user);
				SessionManager.getInstance().logout(user);
				return;
			} catch (UserNotFoundException | AuthenticationFailureException e) {
				tui.printLine(e.getMessage());
			}
		}
	}

	/**
	 * Presents the create account menu. After successfully creating a new user, the
	 * user will be logged in.
	 */
	private static void createUserAccount() throws EOFException {
		// Keep trying to create an account until successful.
		while (true) {
			User user = new User();
			String username = tui.promptNonEmptyLine("Username");
			if (!UserService.getInstance().isUsernameAvailable(username)) {
				tui.printLine("Username already taken. Please choose another.");
				continue;
			}
			user.setUsername(username);
			char[] password = tui.promptPasswordWithConfirmation("Password");
			user.setFirstName(tui.promptNonEmptyLine("First name"));
			user.setLastName(tui.promptNonEmptyLine("Last name"));
			try {
				SessionManager.getInstance().createUser(user, password);
			} catch (UserAlreadyExistsException e) {
				System.err.println("User already exists despite previous check succeeding:");
				e.printStackTrace();
				continue;
			}

			// Now, we can run a session with the newly-created user.
			userSession(user);
			SessionManager.getInstance().logout(user);
			return;
		}
	}

	/**
	 * Runs a session for the given (logged-in) user.
	 * 
	 * @param user The user whose session to run.
	 */
	private static void userSession(User user) throws EOFException {
		while (true) {
			String option = tui.selectValue("Please select an activity", "View/update existing account",
					"Create new account", "Logout");
			switch (option) {
			case "View/update existing account":
				chooseAccount(user);
				break;
			case "Create new account":
				createBankAccount(user);
				break;
			case "Logout":
				return;
			}
		}
	}

	private static void chooseAccount(User user) throws EOFException {
		List<Account> accounts = AccountService.getInstance().findAllForUser(user);
		if (accounts.isEmpty()) {
			tui.printLine("You do not have any accounts yet.");
			if (tui.promptYesOrNo("Would you like to create an account?")) {
				createBankAccount(user);
			}
			// There are no accounts to display, so we return back to the
			// previous menu.
			return;
		}

		// We can now display a list of accounts for the user to pick from.
		String[] menuItems = accounts.stream().map(Account::getName).toArray(String[]::new);
		int choice = tui.select("Please choose an account to view or update", menuItems);
		Account selected = accounts.get(choice);
		manipulateAccount(user, selected);
	}

	private static void createBankAccount(User user) throws EOFException {
		Account account = new Account();
		account.setName(tui.promptNonEmptyLine("Account name"));
		try {
			AccountService.getInstance().insert(account, user);
		} catch (UserNotFoundException e) {
			System.err.println("Logged-in user could not be found in the database:");
			e.printStackTrace();
		}
	}

	private static void manipulateAccount(User user, Account account) throws EOFException {
		// Print out some stats about the account.
		tui.printLine("Selected account: " + account.getName() + " (account ID " + account.getId() + ")");
		tui.printLine("Balance: " + account.getBalanceString());

		String option = tui.selectValue("Please choose an action", "Deposit", "Withdraw", "Transfer", "Add owner",
				"Return to activity selection");
		switch (option) {
		case "Deposit":
			BigDecimal depositAmount = tui.promptDollarAmount("Amount to deposit (in dollars)");
			account.deposit(depositAmount);
			try {
				AccountService.getInstance().update(account);
			} catch (AccountNotFoundException e) {
				System.err.println("The account that the user selected could not be found:");
				e.printStackTrace();
			}
			break;
		case "Withdraw":
			BigDecimal withdrawAmount = tui.promptDollarAmount("Amount to withdraw (in dollars)");
			try {
				account.withdraw(withdrawAmount);
				AccountService.getInstance().update(account);
			} catch (InsufficientFundsException e) {
				tui.printLine(e.getMessage());
			} catch (AccountNotFoundException e) {
				System.err.println("The account that the user selected could not be found:");
				e.printStackTrace();
			}
			break;
		case "Transfer":
			transfer(user, account);
			break;
		case "Add owner":
			String username = tui.promptNonEmptyLine("Username of new account holder");
			try {
				AccountService.getInstance().addOwnerToAccount(account, username);
			} catch (UserNotFoundException e) {
				tui.printLine("User " + username + " does not exist; owner not added.");
			} catch (AccountAlreadyOwnedByUserException e) {
				tui.printLine("User " + username + " already owns this account.");
			} catch (AccountNotFoundException e) {
				System.err.println("Already selected account does not exist somehow:");
				e.printStackTrace();
			}
			break;
		case "Return to activity selection":
			return;
		}
	}

	private static void transfer(User user, Account from) throws EOFException {
		// First, let's get the account we want to transfer to.
		List<Account> accounts = AccountService.getInstance().findAllForUser(user);
		String[] menuItems = accounts.stream().map(account -> account.getName()).toArray(String[]::new);
		int selectedIndex = tui.select("Please choose an account to which to transfer", menuItems);
		Account to = accounts.get(selectedIndex);
		// Make sure that the two accounts involved are actually different; if
		// not, unexpected results will ensue, because the two account objects
		// will *not* be the same (resulting in inconsistent results when one is
		// saved and then the other).
		if (from.getId() == to.getId()) {
			tui.printLine("Money can only be transferred between distinct accounts.");
			return;
		}

		// Now, we get the amount of money to transfer.
		BigDecimal amount = tui.promptDollarAmount("Amount to transfer (in dollars)");
		// Perform the withdrawal and then deposit to the other account.
		try {
			from.withdraw(amount);
		} catch (InsufficientFundsException e) {
			tui.printLine(e.getMessage());
			return;
		}
		to.deposit(amount);

		// We now have to be sure to save the changes to the accounts.
		try {
			AccountService.getInstance().update(to);
			AccountService.getInstance().update(from);
		} catch (AccountNotFoundException anfe) {
			System.err.println("The account which the user chose somehow did not exist:");
			anfe.printStackTrace();
		}
	}
}
