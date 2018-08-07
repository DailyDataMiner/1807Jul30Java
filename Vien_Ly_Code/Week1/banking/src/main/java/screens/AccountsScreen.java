package screens;

import models.Account;
import models.User;

public class AccountsScreen implements Screen{
	private User user;
	private Screen previousScreen;
	private final String screenName = "Account Screen";
	
	public AccountsScreen() {
		previousScreen = null;
	}
	
	// display all accounts this user has
	// select specific accounts to operate on (considering making a factory of all of the user's accounts)
	// transfer funds between accounts
	// logout logic (going back to StartScreen screen)
	public Screen display() {
		System.out.println("ACCOUNTS");
		for(Account acc : user.getAccounts()) {
			System.out.println(acc);
		}
		System.out.println();
		// TODO Auto-generated method stub
		return null;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setPreviousScreen(Screen previous) {
		// TODO Auto-generated method stub
		this.previousScreen = previous;
	}
}
