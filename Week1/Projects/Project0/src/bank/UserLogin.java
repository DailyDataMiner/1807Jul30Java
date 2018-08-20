package bank;

import java.util.Scanner;

public class UserLogin {


		static String userLogin {	
	
			String temp = "bob";
			String temp2 = "grimble";
		

			System.out.println("Hi! Please Sign in. If you don't yet have an account with us, press 0");
			System.out.println("Username: ");
			Scanner user = new Scanner(System.in);
			String userLogin = user.nextLine();
			System.out.println("Password: ");
			Scanner pass = new Scanner(System.in);
			String passWord = pass.nextLine();


			if (userLogin.equals(temp) && passWord.equals(temp2)){
				System.out.print("You've signed in");
			}
			else {
				System.out.print("Invalid Username or Password");
				
			}

		}
	
}
