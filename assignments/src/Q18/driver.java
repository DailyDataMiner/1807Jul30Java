package Q18;

import java.util.Scanner;

public class driver extends concreteSubclass {

	public static void main(String[] args) {
		
		String str = "gfda";
		
		concreteSubclass csc = new concreteSubclass();
		csc.uppercaseCheck(str);
		csc.lowerToUpper(str);
		
		System.out.print("please enter a number: ");
		Scanner numString = new Scanner(System.in);
		String str2 = numString.nextLine();
		System.out.println("you entered: " + str2);
		csc.StringToInteger(str2);
		
	}

}
