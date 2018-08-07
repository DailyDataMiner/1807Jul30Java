import models.Account;
import screens.Screen;
import screens.StartScreen;

public class Launcher {

	public static void main(String[] args) {
		Screen currentScreen = new StartScreen();
		Account one = new Account(null, 100.00);
		System.out.println(one.getAccountNo());
		Account two = new Account(null, 100.00);
		System.out.println(two.getAccountNo());
		Account three = new Account(null, 100.00);
		System.out.println(three.getAccountNo());
//		while(true) {
//			currentScreen = currentScreen.display();
//		}
	}

}
