package com.revature.threads;

public class ExtendThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("In extends thread");
		for (int i = 1000; i > 0; i--) {
			System.out.println("ET: " + i);
		}
	}

}
