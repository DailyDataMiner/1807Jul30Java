package screens;

import java.util.Scanner;

public class StartScreen implements Screen{
	
	private Screen previousScreen;

	public Screen getPreviousScreen() {
		return previousScreen;
	}
	
	public void setPreviousScreen(Screen previous) {
		this.previousScreen = previous;
	}

	public final String screenName = "Start Screen";
	
	public String getScreenName() {
		return this.screenName;
	}

	private Scanner scan = new Scanner(System.in);

	public Screen display() {
		
		System.out.println("Welcome");
		System.out.println("1 to login");
		System.out.println("2 to register");
		int userInput = Integer.parseInt(scan.nextLine());
		
		switch(userInput) {
		case 1:
			return new LoginScreen(this);
		
		case 2:
			return new RegisterScreen(this);
			
		default:
			System.out.println("Invalid Input");
			break;
			
		}
			
		return this;
		
	}
	
	
}
