package com.iantimothyjohnson.assignments.banking.app;

import java.io.EOFException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.iantimothyjohnson.assignments.banking.exceptions.AccountAlreadyOwnedByUserException;
import com.iantimothyjohnson.assignments.banking.exceptions.AccountBalanceTooLargeException;
import com.iantimothyjohnson.assignments.banking.exceptions.AccountNotFoundException;
import com.iantimothyjohnson.assignments.banking.exceptions.AuthenticationFailureException;
import com.iantimothyjohnson.assignments.banking.exceptions.ConsoleNotSupportedException;
import com.iantimothyjohnson.assignments.banking.exceptions.InsufficientFundsException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserAlreadyExistsException;
import com.iantimothyjohnson.assignments.banking.exceptions.UserNotFoundException;
import com.iantimothyjohnson.assignments.banking.pojos.Account;
import com.iantimothyjohnson.assignments.banking.pojos.User;
import com.iantimothyjohnson.assignments.banking.service.AccountService;
import com.iantimothyjohnson.assignments.banking.service.SessionManager;
import com.iantimothyjohnson.assignments.banking.service.UserService;
import com.iantimothyjohnson.assignments.banking.ui.ConsoleTUI;
import com.iantimothyjohnson.assignments.banking.ui.StandardTUI;
import com.iantimothyjohnson.assignments.banking.ui.TUI;
import com.iantimothyjohnson.assignments.banking.util.Passwords;
import com.iantimothyjohnson.assignments.banking.util.StringUtils;

public class Driver {
	private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());

	/**
	 * The TUI to use to interact with the user.
	 */
	private static TUI tui;
	/**
	 * The header of the welcome message to show to the user when the program
	 * starts.
	 */
	private static final String WELCOME_HEADER = "Welcome to ITJBank!";
	/**
	 * The rest of the welcome message.
	 */
	private static final String WELCOME = "The bank's interface is textual and menu-driven. "
			+ "If you would like to see the options for a particular menu again, enter '?' (without the quotes) and the menu options will be re-shown.";

	// We wouldn't want anyone to actually construct one of these!
	private Driver() {
	}

	public static void main(String[] args) {
		// Set up the TUI. We try to use the fancier ConsoleTUI where supported,
		// but fall back to StandardTUI if this cannot be done.
		try {
			tui = new ConsoleTUI();
		} catch (ConsoleNotSupportedException e) {
			LOGGER.fine("Console I/O is not supported on this terminal; falling back to standard streams.");
			tui = new StandardTUI();
		}
		tui.printHeader(WELCOME_HEADER);
		tui.printLine();
		tui.printLine(WELCOME);
		tui.printLine();
		// The program should just keep trying to log users in until one of them
		// enters EOF.
		try {
			while (true) {
				String option = tui.selectValue("Please select an option", "Log in", "Create user account",
						"Exit program");
				switch (option) {
				case "Log in":
					login();
					break;
				case "Create user account":
					createUserAccount();
					break;
				case "Exit program":
					return;
				}
			}
		} catch (EOFException e) {
			LOGGER.log(Level.FINEST, "User exited the program via EOF.", e);
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
				tui.printError(e.getMessage());
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
				tui.printError("Username already taken. Please choose another.");
				continue;
			}
			user.setUsername(username);
			char[] password = tui.promptPasswordWithConfirmation("Password");
			user.setFirstName(tui.promptNonEmptyLine("First name"));
			user.setLastName(tui.promptNonEmptyLine("Last name"));
			try {
				SessionManager.getInstance().createUser(user, password);
				tui.printSuccess("Successfully created user " + user.getUsername() + ".");
			} catch (UserAlreadyExistsException e) {
				LOGGER.log(Level.SEVERE, "Attempted to create user with non-unique username.", e);
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
		tui.printSuccess("Welcome, " + user.getFirstName() + " " + user.getLastName() + "!");
		while (true) {
			String option = tui.selectValue("Please select an activity", "View/update existing account",
					"Create new account", "Change password", "Logout");
			switch (option) {
			case "View/update existing account":
				chooseAccount(user);
				break;
			case "Create new account":
				createBankAccount(user);
				break;
			case "Change password":
				char[] currentPassword = tui.promptPassword("For security, please enter your current password");
				byte[] currentHashedPassword = Passwords.hashPassword(currentPassword, user.getPasswordSalt());
				if (!Arrays.equals(user.getPasswordHash(), currentHashedPassword)) {
					tui.printError("Incorrect password.");
					break;
				}
				char[] newPassword = tui.promptPasswordWithConfirmation("Enter new password");
				// Give the user a new salt as well.
				user.setPasswordSalt(Passwords.generateSalt());
				user.setPasswordHash(Passwords.hashPassword(newPassword, user.getPasswordSalt()));
				// Update the user data so the new password is retained.
				try {
					UserService.getInstance().update(user);
					tui.printSuccess("Password successfully changed.");
				} catch (UserNotFoundException e) {
					LOGGER.log(Level.SEVERE, "Unable to update user who is known to exist.", e);
				}
				break;
			case "Logout":
				return;
			}
		}
	}

	private static void chooseAccount(User user) throws EOFException {
		List<Account> accounts = AccountService.getInstance().findAllForUser(user);
		if (accounts.isEmpty()) {
			tui.printError("You do not have any accounts yet.");
			if (tui.promptYesOrNo("Would you like to create an account?")) {
				createBankAccount(user);
			}
			// There are no accounts to display, so we return back to the
			// previous menu.
			return;
		}

		// We can now display a list of accounts for the user to pick from.
		String[] menuItems = accounts.stream().map(Account::getName).toArray(String[]::new);
		// Let's try to disambiguate any duplicates in the list by their ID.
		for (int i = 0; i < menuItems.length; i++) {
			// Let's construct a list of all the elements that have the same
			// name as this one.
			List<Integer> duplicateIndexes = new ArrayList<>();

			// We can assume without loss of generality that the index of the
			// first duplicate item is less than that of the second duplicate
			// (in a pair).
			for (int j = i + 1; j < menuItems.length; j++) {
				if (menuItems[i].equals(menuItems[j])) {
					duplicateIndexes.add(j);
				}
			}
			// Now let's rename any duplicates:
			if (!duplicateIndexes.isEmpty()) {
				// We should rename the first element as well, just for
				// consistency.
				duplicateIndexes.add(i);
			}
			for (int j : duplicateIndexes) {
				menuItems[j] += " (ID " + accounts.get(j).getId() + ")";
			}
		}
		int choice = tui.select("Please choose an account to view or update", menuItems);
		Account selected = accounts.get(choice);
		manipulateAccount(user, selected);
	}

	private static void createBankAccount(User user) throws EOFException {
		Account account = new Account();
		account.setType(tui.selectValue("Account type", Account.ACCOUNT_TYPES));
		account.setName(tui.promptNonEmptyLine("Account name"));
		try {
			AccountService.getInstance().insert(account, user);
			tui.printSuccess("Successfully created account " + account.getName() + ".");
		} catch (UserNotFoundException e) {
			LOGGER.log(Level.SEVERE, "Attempted to add new account to non-existent user.", e);
		}
	}

	private static void manipulateAccount(User user, Account account) throws EOFException {
		// Print out some stats about the account.
		tui.printHeader("Selected account: " + account.getName() + " (" + account.getType() + ", account ID "
				+ account.getId() + ")");
		tui.printHeader("Balance: " + account.getBalanceString());

		String option = tui.selectValue("Please choose an action", "Deposit", "Withdraw", "Transfer", "Add owner",
				"Delete account", "Return to activity selection");
		switch (option) {
		case "Deposit":
			BigDecimal depositAmount = tui.promptDollarAmount("Amount to deposit (in dollars)");
			try {
				account.deposit(depositAmount);
				AccountService.getInstance().update(account);
			} catch (AccountBalanceTooLargeException e) {
				tui.printError(e.getMessage());
				break;
			} catch (AccountNotFoundException e) {
				LOGGER.log(Level.SEVERE, "Attempted to deposit to non-existent account.", e);
				break;
			}
			tui.printSuccess("Successfully deposited " + StringUtils.formatDollarString(depositAmount) + ".");
			break;
		case "Withdraw":
			BigDecimal withdrawAmount = tui.promptDollarAmount("Amount to withdraw (in dollars)");
			try {
				account.withdraw(withdrawAmount);
				AccountService.getInstance().update(account);
			} catch (InsufficientFundsException e) {
				tui.printError(e.getMessage());
				break;
			} catch (AccountNotFoundException e) {
				LOGGER.log(Level.SEVERE, "Attempted to withdraw from non-existent account.", e);
				break;
			}
			tui.printSuccess("Successfully withdrew " + StringUtils.formatDollarString(withdrawAmount) + ".");
			break;
		case "Transfer":
			transfer(user, account);
			break;
		case "Add owner":
			String username = tui.promptNonEmptyLine("Username of new account holder");
			try {
				AccountService.getInstance().addOwnerToAccount(account, username);
			} catch (UserNotFoundException e) {
				tui.printError("User " + username + " does not exist; owner not added.");
				break;
			} catch (AccountAlreadyOwnedByUserException e) {
				tui.printError("User " + username + " already owns this account.");
				break;
			} catch (AccountNotFoundException e) {
				LOGGER.log(Level.SEVERE, "Attempted to add new owner to non-existent account.", e);
				break;
			}
			tui.printSuccess("Successfully added " + username + " as account holder for " + account.getName() + ".");
			break;
		case "Delete account":
			if (!account.getBalance().equals(BigDecimal.ZERO)) {
				tui.printError("This account has " + account.getBalanceString()
						+ " remaining. Please transfer these funds to another account before deleting this one.");
				break;
			}
			if (tui.promptYesOrNo("Are you sure you want to delete this account")) {
				try {
					AccountService.getInstance().delete(account);
				} catch (AccountNotFoundException e) {
					LOGGER.log(Level.SEVERE, "Unable to delete account that is known to exist.", e);
					break;
				}
				tui.printSuccess("Account successfully deleted.");
			} else {
				tui.printError("Account deletion cancelled.");
			}
			break;
		case "Return to activity selection":
			break;
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
			tui.printError("Money can only be transferred between distinct accounts.");
			return;
		}

		// Now, we get the amount of money to transfer.
		BigDecimal amount = tui.promptDollarAmount("Amount to transfer (in dollars)");
		// Perform the withdrawal and then deposit to the other account.
		try {
			from.withdraw(amount);
			to.deposit(amount);
		} catch (InsufficientFundsException e) {
			tui.printError(e.getMessage());
			return;
		} catch (AccountBalanceTooLargeException e) {
			tui.printError(e.getMessage());
			return;
		}

		// We now have to be sure to save the changes to the accounts.
		try {
			AccountService.getInstance().update(to);
			AccountService.getInstance().update(from);
			tui.printSuccess("Successfully transferred " + StringUtils.formatDollarString(amount) + " from "
					+ from.getName() + " to " + to.getName() + ".");
		} catch (AccountNotFoundException e) {
			LOGGER.log(Level.SEVERE, "Attempted to transfer between non-existent accounts.", e);
		}
	}
}
