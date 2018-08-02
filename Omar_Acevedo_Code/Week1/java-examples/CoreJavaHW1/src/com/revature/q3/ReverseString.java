package com.revature.q3;
import com.revature.helpers.HelperFunctions;

// Q3.Reverse a string without using a temporary variable.  
// Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

public class ReverseString extends HelperFunctions {

	public static void main(String[] args) {
		
		String myStr = "omar";
//		String reverseStr = reverseString(myStr);
		
		print(reverseString(myStr));
		
	}
	
	private static String reverseString(String p_value) {
		
//		String myStr = "omar";
		String tempVar_shouldNotBeUsed = "";
		int str_len = p_value.length()-1;
		
		for (int i = str_len; i >= 0; i--) {
//			print(myStr.charAt(i));
			tempVar_shouldNotBeUsed += p_value.charAt(i);
		}
//		println(tempVar_shouldNotBeUsed);
		return tempVar_shouldNotBeUsed;
		
	}

}
