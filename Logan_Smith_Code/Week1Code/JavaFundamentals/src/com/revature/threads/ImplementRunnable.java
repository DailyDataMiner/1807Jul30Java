package com.revature.threads;

public class ImplementRunnable implements Runnable {

	public void run() {
		System.out.println("In implements runnable");
		for (int i = 1000; i > 0; i--) {
			System.out.println("IR: " + i);
		}
	}
	
}
