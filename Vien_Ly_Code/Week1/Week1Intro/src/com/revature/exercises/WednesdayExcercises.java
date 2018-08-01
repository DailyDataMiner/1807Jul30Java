package com.revature.exercises;

import java.util.Arrays;

public class WednesdayExcercises {

	public static void main(String[] args) {
		System.out.println(fib(9));
		System.out.println(reverse("vien"));
	}
	
	public static int fib(int n) {
		if (n <= 1) return n;
		return fib(n - 1) + fib(n - 2);
	}
	
	// StringBuilder has a build in reverse method
	public static String reverse(String str) {
		char[] arr = str.toCharArray();
		int iterations = arr.length/2;
		for (int i = 0; i < iterations; i++) {
			char temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		return String.valueOf(arr);
		
	}

}
