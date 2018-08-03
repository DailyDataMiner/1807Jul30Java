package com.revature.threads;

public class ImplementsRunnable implements Runnable {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("In ImplementsRunnable");
		for (int i = 0; i< 50; i++) {
			System.out.println("IR -> " + i);
		}
	}
}
