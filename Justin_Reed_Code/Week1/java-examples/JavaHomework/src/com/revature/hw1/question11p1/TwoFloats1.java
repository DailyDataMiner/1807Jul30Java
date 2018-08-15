package com.revature.hw1.question11p1;


import com.revature.hw1.question11p2.TwoFloats2;

public class TwoFloats1 {
	//its possible to call variables from the second package because we imported it
	//AND the variables are public, if one was private the code would not compile
	//I tried
	public static void main(String[] args) {
	       TwoFloats2 tf2 = new TwoFloats2();
	       System.out.println("Float Variable 1: "+tf2.var);
	       System.out.println("Float Variable 2: "+tf2.var2);
	   }


}
