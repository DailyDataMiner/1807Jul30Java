package com.revature.intro;

public class Primitives {
	/*
	 * Java has 8 primitive datatypes, which represent raw data
	 * in an organized form. 
	 * int, boolean, byte, char, short, double, long
	 * 
	 * When a number/string/array/etc is actually written out,
	 * it is called a literal
	 */
	
	public static void main(String[] args) {
		int var; //declaring variable;
		var = 5; //initializing variable
		int x = 10;
		x = (int)5.21; //reassigning variable
		System.out.println(x);
		char ch = 'a';//Initializing and declaring variable
		
		short isShort = 10;
		int shortAsInt = isShort;
		
		int notShort = 100000;
		short sh = (short) notShort;
		System.out.println("casted in 100000 to short: " + sh);;
		
		
		int decimal = 10;
		
		int binary = 0B10001101;
		System.out.println(binary);
		
		int octal = 0107624;
		System.out.println("octal " +  octal);
		
		
	}

}