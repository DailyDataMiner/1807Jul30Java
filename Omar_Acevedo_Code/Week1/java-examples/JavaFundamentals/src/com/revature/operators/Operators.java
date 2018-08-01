package com.revature.operators;
import com.revature.helpers.HelperFunctions;

public class Operators extends HelperFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 100;
		int y = 6;
		print(toBinary(x));
		print(toBinary(x>>2));
		print(toBinary(x<<2));
		print(toBinary(x>>>2));

		x = 5;		
		if (x++ == 5 && y-- == x) {
			print(x + ", " + y);
		} else {
			print(false);
		}

		// TERNARY --> [expression]
		boolean value = true;
		String greeting = value ? "hi" : "bye";
		print(value);
		
	}
	
	
	
	static StringBuilder toBinary(int x) {
		
		String out = "";
		
		while (x > 0) {
			out += x % 2;
			x = x / 2;
		}
		
		StringBuilder sb = new StringBuilder(out);
		
		return sb;
	}

}
