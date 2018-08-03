package com.revature.intro;

public class Wrappers {
	
	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		int five = Integer.parseInt("5");
		//int willCauseException = Integer.parseInt("one hundred");
		
		Integer i = new Integer(80);
		int eight = i; //unboxing
		
		int x = 10;
		Integer wrapped = x; //autoboxing
	}

}