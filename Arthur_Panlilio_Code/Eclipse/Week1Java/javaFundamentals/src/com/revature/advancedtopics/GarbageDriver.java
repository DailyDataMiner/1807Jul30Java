package com.revature.advancedtopics;

public class GarbageDriver {

	public static void main(String[] args) {
		System.out.println("instantiating an unused object!");

		GarbageDriver obj = new GarbageDriver();
		
		System.out.println("object created. About to sleep....");
		
		obj = null;
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.gc();
		System.out.println("at end of main method");
		
	}
	
	//method called by gc before object gets collected
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Goodbye cruel world!");
	}

}
