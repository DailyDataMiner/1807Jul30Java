package com.revature.q19;

import java.util.ArrayList;

/**
 * Creates an array
 * adds all evens; odds
 * Removes prime numbers from array
 * 
 * @author Arthur Panlilio
 *
 */
public class ArrayListQuestion {

	public static void main(String[] args) {
		//Initializes the array and populates it
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			arr.add(i);
		}
		//runs and prints the methods
		printArray(arr);
		addEven(arr);
		addOdds(arr);
		removePrimes(arr);
		printArray(arr);

	}
	
	/**
	 * Adds all the even integers
	 * 
	 * @param arr is the array
	 */
	public static void addEven(ArrayList<Integer> arr){
		int total = 0;
		for(Integer n: arr) {
			if(n%2==0) {
				total += n;
			}
		}
		System.out.println("Total sum of evens: " + total);
	}
	
	/**
	 * Adds all the odds
	 * 
	 * @param arr is the array
	 */
	public static void addOdds(ArrayList<Integer> arr){
		int total = 0;
		for(Integer n: arr) {
			if(n%2!=0) {
				total += n;
			}
		}
		System.out.println("Total sum of odds: " + total);
	}
	
	/**
	 * Iterates through the array to remove primes
	 * 
	 * @param arr is the array
	 */
	public static void removePrimes(ArrayList<Integer> arr){
		//Creates an array of all the integers to be removed
		ArrayList<Integer> remove = new ArrayList<>();
		System.out.println("Removing all prime numbers from array..");
		for(Integer n: arr) {
			if(checkIfPrime(n)) {
				remove.add(n);
			}
		}
		//removes all integers found in remove list
		arr.removeAll(remove);
	}
	
	/**
	 * Checks if the integer is prime
	 * 
	 * @param int n is the number to check
	 * @return a boolean true if prime
	 */
	public static boolean checkIfPrime(int n){
		//divide n by all numbers>1 below it to check if leaves a 0 remainder. If it does return false, if not return true.
	    if(n==1) {
	    	return false;
	    }
		for (int i = 2; i < n; i++) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	
	public static void printArray(ArrayList<Integer> arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i));
			if(i != arr.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
