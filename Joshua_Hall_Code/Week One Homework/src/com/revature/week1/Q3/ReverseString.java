package com.revature.week1.Q3;

public class ReverseString {

	public static String reverse(String str) {
		if(str.length() > 1) {
			// split string in half and make the two halves swap positions
			int center = str.length() / 2;
			str = str.concat(str.substring(0, center));
			str = str.substring(center);
			// the center shifts when you reverse Strings of odd length
			center += str.length() % 2;
			// recursively call reverse function on each half-string
			str = str.replace(str.substring(0, center), reverse(str.substring(0, center)));
			str = str.substring(0, center) + 
					str.substring(center).replace(str.substring(center), reverse(str.substring(center)));
		}
		return str;
	}

	// test driver
	public static void main(String[] args) {
		//String str = "The quick brown fox jumps over the lazy dogs.";
		String str = "1234567890987654321";
		System.out.println(reverse(str));
	}

}
