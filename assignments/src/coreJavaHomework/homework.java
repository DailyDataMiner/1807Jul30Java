package coreJavaHomework;

import java.util.Comparator;

public class homework implements Comparator {

	public void bubbleSort(int[] n) {
		System.out.println("length of array n is " + n.length);
		System.out.println("Original Array: ");

		for(int i = 0; i < n.length; i++) {	// loop to print array
			System.out.print(n[i] + " ");	//
		}									//
		
		int holder = 0;						//temporary variable to hold element values
		
		for(int j = 0; j < n.length; j++) {	//for loop that repeats as many times as the array has elements
			for(int i = 0; i < n.length - 1; i++) {	//inner for loop
				if(n[i] > n[i + 1]) {				//if the former element is greater than the latter,
					holder = n[i];					//set your temporary variable equal to the value of the former element
					n[i] = n[i+1];					//set your former element equal to the latter element
					n[i+1] = holder;				//set your latter element equal to the previous value of the 
				}									//first element, which was stored in holder
			}
		}
		
		System.out.println("\n" + "\n" + "length of new array n is " + n.length);		
		System.out.println("New Array: ");
		for(int i = 0; i < n.length; i++) {	// loop to print array
			System.out.print(n[i] + " ");	//
		}	
		
	}
	
	public void fibonacci(int count) {
		
		int fib1 = 0; 						//first Fibonacci number
		System.out.println(fib1); 			//print it
		int fib2 = 1; 						//second Fibonacci number
		System.out.println(fib2); 			//print it
		int fib3;							//third Fibonacci number to be used later
		
		for(int i = 1; i < (count - 1); i++) {	
			fib3 = fib1 + fib2;				//third number is equal to first plus second
			System.out.println(fib3);		//print it
			fib1 = fib2;					//new second is old first
			fib2 = fib3;					/*new third is old second (so the next fib3 will be the 
											  fourth element in the Fibonacci sequence, and so on...)*/
		}  
		
	}
	
	public void reverseString(String stringy) {	//our function takes in a string and calls it stringy

		int leng = stringy.length();			//create length variable that holds the length of the string passed in
		System.out.println("the length of your string is: " + leng);
	    
		for (int i = (leng-1); i >= 0; --i) {	//going from the last index number to zero...
			stringy += stringy.charAt(i);		//our string is appended with its own characters in reverse order
		}
		
		System.out.println(stringy); 			//if you want to see the full palindrome, here it is
		
	    stringy = stringy.substring(leng);		//then we set our string equal to only its last half, which we just made

	    System.out.println("\n" + "your new reversed string is: " + "\n" + stringy);
		
	}
	
	public void factorial(int f) {
		int theFactOfTheMatter = f;								//creating a variable to work with that will be the factorial
		System.out.println("your integer to be factorialed is: " + "\n" + f);
		
		while(f > 1) {											//while the number is greater than 1
			theFactOfTheMatter = theFactOfTheMatter * (f-1);	//multiply by one less than itself
			f--;												//decrement
		}

		System.out.println("\n" + "your factorial is: " + "\n" + theFactOfTheMatter);
	}
	
	public void aSubstringMethod(String str, int idx) {
		
		for(int i = 0; i < idx; i++) {
			System.out.print(str.charAt(i));

		}
		
	}
	
	public void isItEven(int n) {
		
		System.out.println(n & 1);
		
		if((n & 1) == 0){										//comparing using bitwise operator last bit of number n and 1 and
			System.out.println("Even number"); 					//checking if equal to 0, which 
			}
		else {
			System.out.println("Odd number"); 
		}
	}
	
	public static void main (String[] args) {
		int[] numbers = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		String str = "This is your string to be reversed!";
		int facto = 10;
		int oddOrEven = 97;
		
		homework hw = new homework();
		//hw.fibonacci(25);
		//hw.bubbleSort(numbers);
		//hw.reverseString(str);
		//hw.factorial(facto);
		//hw.isItEven(oddOrEven);
		//hw.aSubstringMethod("testing the substring method", 10);
		hw.
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
