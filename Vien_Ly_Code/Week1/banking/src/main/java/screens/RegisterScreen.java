package screens;

import java.util.Scanner;

public class RegisterScreen implements Screen {
	private final String screenName = "Register Screen";
	private Screen previousScreen;
	private Scanner scan = new Scanner(System.in);
		
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
		
		//verification logic here, if we query the database with no match, prompt again
		
		System.out.println("No such user");
		System.out.println("1 to retry authentication");
		System.out.println("0 to cancel and go back to " + this.previousScreen.getScreenName());
		
		System.out.println("press 0 to go to " + this.previousScreen.getScreenName());
		
		int userInput = Integer.parseInt(scan.nextLine());
				
		switch(userInput) {
		case 0:
			this.previousScreen.setPreviousScreen(this);
			return this.previousScreen;
			
		default:
			System.out.println("Invalid Input");
			break;
			
		}
			
		return this;
	}

}
