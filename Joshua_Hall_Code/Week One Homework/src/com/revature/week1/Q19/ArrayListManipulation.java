package com.revature.week1.Q19;

import java.util.ArrayList;

public class ArrayListManipulation {

	public static <T> void display(ArrayList<T> list) {
		for(T t : list) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
	
	public static void displayEven(ArrayList<Integer> list) {
		int sum = 0;
		for(int i : list) {
			sum += i * (1 - i % 2);
		}
		System.out.println(sum);
	}
	
	public static void displayOdd(ArrayList<Integer> list) {
		int sum = 0;
		for(int i : list) {
			sum += i * (i % 2);
		}
		System.out.println(sum);
	}
	
	public static void displayComposite(ArrayList<Integer> list) {
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i : list) {
			if(isPrime(i)) {
				primes.add(i);
			}
		}
		list.removeAll(primes);
		display(list);
	}
	
	private static boolean isPrime(int n) {
		final int sqrtN = (int) Math.sqrt(n);
		for(int i = 2; i <= sqrtN; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(10);
		for(int i = 1; i <= 10; i++) {
			list.add(i);
		}
		display(list);
		displayEven(list);
		displayOdd(list);
		displayComposite(list);
	}

}
