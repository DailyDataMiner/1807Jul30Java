package Q19;

import java.util.ArrayList;

public class oddEvenPrime {

	public static void main(String[] args) {
		ArrayList<Integer> someNumbers = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++) { 			//for loop to add numbers to 10 to the ArrayList
			someNumbers.add(i);
		}
		
		int sumOfEven = 0;
		int sumOfOdd = 0;
		
		for (int n : someNumbers) {					//for loop to cycle through the numbers in the ArrayList
			if (isItEven(n)) {						//if statement to pass each number in the List to the method created below
				sumOfEven += n;
				System.out.println(n + " is even");	//printing the result if number is even
			}
			if(!isItEven(n)) {
				sumOfOdd += n;
				System.out.println(n + " is odd");
			}
		}
		
		System.out.println("sum of odd numbers in the range is " + sumOfOdd);
		System.out.println("sum of even numbers in the range is " + sumOfEven);
		System.out.println("\n" + "Original Array: ");
		
		for(int n : someNumbers) {				//printing ArrayList someNumbers created earlier
			System.out.print(n + " ");
		}
		
		System.out.println("\n" + "Array with primes removed: ");
		
		ArrayList<Integer> someComposites = new ArrayList<Integer>();
		
		for(int n : someNumbers) {
			if(!isItPrime(n)) {
				someComposites.add(n);
			}
		}
		
		for(int n : someComposites) {				//printing new ArrayList of Primes only
			System.out.print(n + " ");
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
	
	public static boolean isItEven(int num) {
		if(num % 2 == 0) {							//checking if number is even
			return true;						//printing if even
		}
		else {
			return false;
		}
	}
	
}
