package com.revature.advancedtopics;
import com.revature.helpers.HelperFunctions;

public class GarbageDriver extends HelperFunctions {

	public static void main(String[] args) {
		
		print("instantiating an unused object");
		
		GarbageDriver obj = new GarbageDriver();
		
		print("object created. about to sleep...");
		
//		obj = null;
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		obj = null;
		System.gc();
		print("at end of main method");
		
	}
	
	//finalize() = method called by GC before object gets garbage collect...
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		print("at finalize()... goodbye");
	}

}
