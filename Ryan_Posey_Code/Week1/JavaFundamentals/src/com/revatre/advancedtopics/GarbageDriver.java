package com.revatre.advancedtopics;

public class GarbageDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("instantiating an unused object");
		
		GarbageDriver obj = new GarbageDriver();
		
		System.out.println("object created. about to sleep...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj = null;
		System.gc();
		System.out.println("At the end of main method");
	}

	//finalize() = method called by GC before object gets garbage collected
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("I have to go now. My planet needs me.");
	}
}
