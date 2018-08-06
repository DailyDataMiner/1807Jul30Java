package com.revature.week1q5;

public class substringMethodExample {

	static String StringSplitter(String str, int idx) {

		char[] arr = str.toCharArray();

		StringBuilder stringToBeBuilt = new StringBuilder();

		for (int i = 0; i < idx - 1; i++) {
			stringToBeBuilt.append(arr[i]);

		}

		return stringToBeBuilt.toString();

	}

	public static void main(String[] args) {

		int x = 4;
		String str = "Example for strings";

		
		
		
		
		System.out.println(StringSplitter(str,x));
		
		

	}

}
