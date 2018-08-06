package com.revature.intro;

public class Primitives {
	/* 
	 * Java has primitives datatypes, which represent raw data in an organized form.
	 * int, boolean, byte, char, short, double, long , float 
	 * boolean True or Flase
	 * byte -128 to 127
	 * char 0 to 65536
	 * double 1.7e-308 to 1.7e+308
	 * int -2147483648 to 2147483647
	 * long -9223372036854755808 to 9223372036854775807
	 * float 3.4e-308 to 3.4+308
	 * short -32768 to 32767
	 * 
	 * When a number/string/array/etc i actually written out, it is called a literal
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int var; //declaring variable 
		var = 5;  //intializing variable
		var  = 100; //reassigning variable
		int x = 10; // declaring AND initializing var
		x = 100; // cannot declare the same var twice in the same scope
		
		char ch = 'a';
		
		int _num = 0;
		int $dolla = 50;
		
		boolean namingConventionIsCamelCAse = true;
		
		double riches = 10_1414_400.99;
		int million = 1_000_000;
		
		//number literals are interpreted as ints. must specify L or l to
		long longNum = 100000000000000000L;
		
		//CASTING
		// - to change the reference type of an entity
		
		char charAsNum = 100;
		System.out.println(charAsNum);
		
		int toChar = 80;
		char c = (char) toChar;
		System.out.println("int value - " + toChar + "\ncharacter value - " + toChar);
		
		short isShort = 10;
		int shortAsInt = isShort;
		
		
		int notShort = 10_000_000;
		short sh = (short) notShort;
		System.out.println("casted int 10,000,000 to short: " + sh);
		
		// non decimal number representations
		
		//Decimal - base 10 
		int decimal = 10; 
		//Binary - base 2;
		int binary = 0b101001101;
		System.out.println("binary: " +binary);
		//Octal - base 8/ 0-7
		int octal = 0107624;
		System.out.println("octal: " + octal);
		//Hexadecimal - base 16/ 0-9,a-f
		int hex = 0xa3f19d2b;
		System.out.println("hex: " + hex);
		
		//WRAPPER CLASSES
		//entity gives object functionality for primitive data types
		
		//Self
		char myBonnie = 8;
		System.out.println(myBonnie);
	}

}

//Static vs instance
//Arrays
