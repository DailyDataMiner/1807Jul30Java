package com.revature.advancedtopics;

public class GarbageDriver {
	
	public static void main(String[] args) {
		System.out.println("instantiate unused object");
		
		GarbageDriver obj = new GarbageDriver();
		
		System.out.println("object created. about to sleep...");
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
			
		}
		obj = null;
		System.gc();
		System.out.println("at the end of the main method");
		
		
		
		}
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("Goodbye Cruel world!!");
	}

}
