package com.revature.datatypes;

public class primatives {

		//number/character/string written out is called a literal
	public static void main(String[] args) {
		int var; //declaring variable
		var = 5; //initializing
		var = 10; //reassigning
		
		int x = 10; //delcaring & initialziing
		x = 100; // cannot declare same var twice in the same scope
		
		char ch = 'a';
		
		int _num = 0;
		int $dolla = 50;
		
		boolean namingConventionIsCamelCase = true;
		double riches = 10_141_400.99;
		int million = 1_000_000;
		
		//number literals are interpreted as ints. must specify Long or 1
		long  longNum = 10000000000L;
		
		//Casting
		// - to change the refernce type of an entity
		
		char charAsNum = 100;
		System.out.println(charAsNum);
		
		int toChar = 80;
		char c = (char) toChar;
		System.out.println("int value - " + toChar + "\ncharacter value - " + c);
		
		short isShort = 10;
		int shortAsInt = isShort;
		
		int notShort = 10_000_000;
		short sh = (short) notShort;
		System.out.println("casted in 10,000,000 to short: " + sh);
		
		//non decimal number representations
		
		//Decimal - base 10
		int decimal = 10;
		
		//Binary - base 2
		int binary = 0b1011;
		System.out.println(binary);
		
		//Octal - base 8 / 0-7
		int octal = 0107624;  //0 puts in into octal
		System.out.println("octal: " + octal);
		
		//Hexadecimal - base 16 / 0-9, a-f
		int hex = 0X3F19d2b;
		System.out.println("hex: " + hex);
		
		
		
		
		
		
		
		
		
		//wrapper classes
		
		
		

	}

}
