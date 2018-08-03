package com.revature.staticlass;

public class StaticStuff {
	
	static {
		System.out.println("in Block before main");
	}
	public static void main(String[] args) {
		System.out.println("MAIN");
	}
	
	static {
		System.out.println("in block after main");
	}

}
