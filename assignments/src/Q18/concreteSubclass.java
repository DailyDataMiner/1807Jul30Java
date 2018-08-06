package Q18;

import java.util.Scanner;

public class concreteSubclass extends superclassAbstract {

	@Override
	public void uppercaseCheck(String myWord1) {
		
		boolean hasUppercase = !myWord1.equals(myWord1.toLowerCase());
		//boolean hasLowercase = !myWord1.equals(myWord1.toUpperCase());
		
		if(!hasUppercase) {
			System.out.println("FALSE: has no uppercase letters" + "\n");
		}
		
		if(hasUppercase) {
			System.out.println("TRUE: has uppercase letters" + "\n");
		}
		
	}

	@Override
	public void lowerToUpper(String myWord2) {
		
		System.out.println("you entered: " + myWord2);
		String myWord2Upper = myWord2.toUpperCase();
		System.out.println("in all caps, you now have: " + myWord2Upper + "\n");
		
	}

	@Override
	public void StringToInteger(String myNumberString) {
		
		Scanner numString = new Scanner(myNumberString);
		int justNumNow = numString.nextInt() + 10;
		System.out.println("your number plus 10 = " + justNumNow);
		
		
	}

}
