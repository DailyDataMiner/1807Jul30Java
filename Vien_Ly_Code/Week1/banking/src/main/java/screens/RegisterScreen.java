package screens;

import java.util.Scanner;

public class RegisterScreen implements Screen {
	private final String screenName = "Register Screen";
	private Screen previousScreen;
	private Scanner scan = new Scanner(System.in);

	public RegisterScreen() {
		previousScreen = null;
	}
	
	public RegisterScreen(Screen previous) {
		this.previousScreen = previous;
	}

	public Screen getPreviousScreen() {
		return previousScreen;
	}

	public void setPreviousScreen(Screen previousScreen) {
		this.previousScreen = previousScreen;
	}

	public String getScreenName() {
		return this.screenName;
	}

	public Screen display() {
		System.out.println("register");
		
		System.out.print("Username: ");
		String userName = scan.nextLine();
		System.out.print("Password: ");
		String password1 = scan.nextLine();
		System.out.print("Confirm password: ");
		String password2 = scan.nextLine();
		if(password1.equals(password2)) {
			// create an User object,
			// register the user
			// update SQL
			// return confirmation then go to AccountsScreen
		}
		
		System.out.println("Registration successful");
		// cannot go back to register screen from login screen without logging out first
		// null "previous screen" arg will route back to startscreen when needed
		return new LoginScreen();
	}

}
