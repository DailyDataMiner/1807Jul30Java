package com.revature.classbasics;



/*static blocks run before main function
 * But if you do 
 * StaticStuff stuff = new StaticStuff();
 * stuff.instanceStuff();
 * 
 * the call happens later
*/
public class StaticStuff {

	static {
		System.out.println("block before main");
	}
	
	public static void main(String[] args) {
		System.out.println("in main method");

	}

	
	static {
		System.out.println("block after main");
	}
}
