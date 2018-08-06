package com.revature.q5;

public class BabyString {
	public static String mag(String singleMom, int ingred){
			String embString = "testing the Pool";
			StringBuilder off = new StringBuilder();
			for(int i= 0;i<ingred;i++) {
				off.append(singleMom.charAt(i));
			}
			return off.toString();
		}
	public static void main(String[] args) {
		String param1 = args[0];
		int param2 = Integer.parseInt(args[1]);
		//System.out.println(param2);
		//System.out.println(param1);
		System.out.print("You must want: " + mag(param1,param2)); 
	}
}
