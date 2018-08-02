package com.revature.q5;
import com.revature.helpers.HelperFunctions;

/*
 * Q5.Write a substring method that accepts a string str and an integer idx and returns 
 * the substring  contained  between  0  and  idx-1 inclusive.
 * Do  NOT  use  any  of  the  existing substring methods in the String, StringBuilder, 
 * or StringBuffer APIs.
 * 
 * */

public class SubtringMethod extends HelperFunctions {

	public static void main(String[] args) {
		String myStr = "omar";
		substring(myStr, 0);
		substring(myStr, 1);
		substring(myStr, 2);
		substring(myStr, 3);
	}
	
	private static String substring(String p_str, int p_idx) {
		for (int i = 0; i <= p_idx; i++) {
			print(p_str.charAt(i));
		}
		println("");
		return "";
	}

}
