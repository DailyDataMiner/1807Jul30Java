package com.revature.designpatterns;
import java.util.Scanner;

import com.revature.helpers.HelperFunctions;

public class Driver extends HelperFunctions {

	public static void main(String[] args) {
		
//		// Singleton Demonstration
//		Singleton s = Singleton.getInstance();
//		s.name = "first instance";
//
//		Singleton s2 = Singleton.getInstance();
//		s2.name = "second instance";
//		
//		print(s.name);
//		print(s2.name);
//		print(s == s2);
//		
//		s = null;
//		s2= null;
//		
//		Singleton s3 = Singleton.getInstance();
//		print(s3.name);
//		
//		LazySingleton lazy = LazySingleton.getInstance();
//		lazy.test();
//		
//		LazySingleton lazy2 = LazySingleton.getInstance();
		
		// Factory Demo
		/*
		 * Here, we will instantiate an object without
		 * exposing creation logic to the client.
		 * We refer to the newly created object using a common interface
		 */
		print("Hey Bob! What tool would you like to build with?");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		
		Tool t = ToolFactory.instantiate(tool);
		print(t.work());
		print(t.getClass());
		
	}
}