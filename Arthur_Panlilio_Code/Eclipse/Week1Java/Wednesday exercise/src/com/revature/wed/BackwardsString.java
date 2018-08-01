package com.revature.wed;

public class BackwardsString {
	
	
	public static void main(String[] args) {
		System.out.println(reverse("abcdefghijk"));
	}
	
	
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}

}
