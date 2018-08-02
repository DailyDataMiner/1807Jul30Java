package cjh.question3;

import java.util.Stack;

public class Driver {
	/*
	 * Reverse a string without using a temporary variable. Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	 */
	
	public static void main(String[] args) {
		System.out.println("The reverse of Hello is: " + reverseString("Hello"));
		System.out.println("The reverse of Hi is: " + reverseString("Hi"));
	}
	
	static String reverseString(String str) {
		Stack<Character> strStack = new Stack<Character>(); //Stacks are good for reversing the order of objects
		for(Character c:str.toCharArray()) {
			strStack.push(c);
		}
		str = ""; //No temporary variables here
		while(!strStack.isEmpty()) {
			str += strStack.pop();
		}
		return str;
	}

}
