package com.revature.threads;

public class ExtendsThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("In Extends Thread");
		for (int i = 0; i< 50; i++) {
			System.out.println("ET -> " + i);
		}
	}
}
