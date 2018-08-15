package com.revature.designpatterns;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
		/*
		Singleton s = Singleton.getInstance();
		s.name = "First Instance";
		
		Singleton s2 = Singleton.getInstance();
		s2.name = "second Instance";
		
		System.out.println(s.name);
		System.out.println(s2.name);
		System.out.println(s == s2);
		
		s = null;
		s2 = null;
		Singleton s3 = Singleton.getInstance();
		
		
		LazySingleton lazy = LazySingleton.getInstance();
		lazy.test();
		LazySingleton lazy2 = LazySingleton.getInstance();
		
		*/
		
		
		System.out.println("Hey Bob! What tool would you like to build with?");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		Tool t = ToolFactory.instantiate(tool);
		System.out.println(t.work());
		System.out.println(t.getClass());
		
		
		
		
		
		
	}

}
