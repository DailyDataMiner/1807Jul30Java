package Q4;

public class factorial {

	public void factorial(int f) {
		int theFactOfTheMatter = f;								//creating a variable to work with that will be the factorial
		System.out.println("your integer to be factorialed is: " + "\n" + f);
		
		while(f > 1) {											//while the number is greater than 1
			theFactOfTheMatter = theFactOfTheMatter * (f-1);	//multiply by one less than itself
			f--;												//decrement
		}

		System.out.println("\n" + "your factorial is: " + "\n" + theFactOfTheMatter);
	}
	
	public static void main(String[] args) {
		int facto = 5;
		factorial f = new factorial();
		f.factorial(facto);
		
	}

}
