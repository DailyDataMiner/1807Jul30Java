package com.revature.advancedtopics;

public class GarbageDriver {
	
	public static void main(String[] args) {
		System.out.println("Instantiating an unused object");
		
		GarbageDriver obj = new GarbageDriver();
		
		System.out.println("Object created, about to sleep...");
		obj = null;
		System.gc();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("At end of main method");
	}
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
		System.out.println("Goodbye cruel world! I am leaving you!");
	}
	
}
