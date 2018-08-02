package com.revature.io;
import com.revature.helpers.HelperFunctions;
import java.util.Scanner;
import static java.lang.System.in;
// ^ static imports allow us to access static fields of a class w/o class..

public class ScannerExample extends HelperFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print("Hello there\nWrite your name here: ");
		Scanner scan = new Scanner(in);
		String name = scan.nextLine();
		
		print("Hey " + name + ", tell me your age.");
		
		int a;
		
		try {
			
			String age = scan.nextLine();
			a = Integer.parseInt(age);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			print("You did not enter a valid number.");
			a = 0;
		}
		
		print("Your age is -> " + a);
		
		scan.close();
	}

}
