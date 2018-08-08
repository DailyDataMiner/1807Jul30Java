import beans.Account;
import screens.Screen;
import screens.StartScreen;

public class Launcher {

	public static void main(String[] args) {
		Screen currentScreen = new StartScreen();
	
		while(true) {
			currentScreen = currentScreen.display();
		}
	}

}
