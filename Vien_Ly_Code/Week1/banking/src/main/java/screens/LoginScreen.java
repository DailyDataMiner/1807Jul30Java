package screens;

import java.util.Scanner;

public class LoginScreen implements Screen {
	
	private Screen previousScreen;
	private final String screenName = "Login Screen";
	private Scanner scan = new Scanner(System.in);
	
	public LoginScreen(Screen previous) {
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
		System.out.println("login");
		System.out.print("Username: ");
		String userName = scan.nextLine();
		System.out.print("Password: ");
		String password = scan.nextLine();
		
		//verification logic here, if we query the database with no match, prompt again
		
		System.out.println("No such user");
		System.out.println("1 to retry authentication");
		System.out.println("0 to cancel and go back to " + this.previousScreen.getScreenName());		
		int userInput = Integer.parseInt(scan.nextLine());
				
		switch(userInput) {
		case 0:
			this.previousScreen.setPreviousScreen(this);
			return this.previousScreen;
		
		case 1:
			return this;
			
		default:
			System.out.println("Invalid Input");
			break;
			
		}
			
		return this;
	}

}
