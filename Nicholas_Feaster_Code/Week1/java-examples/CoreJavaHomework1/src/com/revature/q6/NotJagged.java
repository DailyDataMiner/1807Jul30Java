package com.revature.q6;

public class NotJagged {

	public static void main(String[] args) {
		int input = Integer.parseInt(args[0]);
		//int test = input/2 ;
		//int yrt = Integer.compare(2,test);
		String yrt = Integer.toBinaryString(input) ;
		if(yrt.charAt(yrt.length()-1)=='0') {
			System.out.println("The integer is even.");
		}
		else 
			System.out.println("The integer is odd.");
		//System.out.println(yrt.charAt(yrt.length()-1));
		
	}

}
