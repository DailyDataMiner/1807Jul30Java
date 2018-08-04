package com.revature.designpatterns;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Singleton s1 = Singleton.getInstance();
		s1.name = "first instance";
		
		Singleton s2 = Singleton.getInstance();
		s2.name = "second instance";

		System.out.println(s1.name);
		System.out.println(s2.name);
		
		s1 = null;
		s2 = null;
		Singleton s3 = Singleton.getInstance();
		s3.name = "third instance";
		System.out.println(s3.name);
		
		LazySingleton lazysingleton = LazySingleton.getInstance();
		LazySingleton lazysingleton2 = LazySingleton.getInstance();
		
		lazysingleton.test();
		lazysingleton2.test();
		
		
		
		
		System.out.println("Which tool are you using, huh?");
		Scanner scan = new Scanner(System.in);
		String tool = scan.nextLine();
		Tool t = ToolFactory.createTool(tool);
		System.out.println(t.work());
		System.out.println(t.getClass());
		
	}

}
