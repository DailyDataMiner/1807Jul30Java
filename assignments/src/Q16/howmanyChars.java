package Q16;

import java.util.Scanner;

public class howmanyChars {

	public static void main(String[] args) {
		
		System.out.println("please enter something here: ");
		
		Scanner iceCave = new Scanner(System.in);
		String s = iceCave.nextLine();
		
		System.out.println("you entered: " + s);
		
		System.out.println("number of characters you entered is: " + charCounter(s));
		
	}

	public static int charCounter(String str) {
		
		int numOfChars = 0;
		
		for(int i = 0; i < str.length(); i++) {
			numOfChars += 1;
		}
		return numOfChars;
	}
	
}
