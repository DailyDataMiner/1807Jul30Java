package Q9;

import java.util.ArrayList;

public class primePrinter {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(); //creating an ArrayList to store numbers
		
		for(int i = 0; i <= 100; i++) { 		//for loop to add numbers to 100 to the ArrayList
			numbers.add(i);
		}
		
		for (int n : numbers) {					//for loop to cycle through the numbers in the ArrayList
			if (isItPrime(n)) {					//if statement to pass each number in the List to the method created below
				System.out.println(n + " is prime");	//printing the result if number is prime
			}
		}
	}
	
	public static boolean isItPrime(int n) {	//creating method to determine if argument is prime
		for(int i = 2; i < n; i++) {			//going from 2 to the integer argument
			if(n % i == 0) {					//checking to see if divisible by anything by itself
				return false;					//and if it is, returning false
			}
		}
		return true;							//returning true if it's prime
	}	
}