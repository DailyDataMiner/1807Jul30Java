package com.revature.threads;

public class Threads101 {

	/*
	 * Types of Threads:
	 * - user - main() or any other explicitly requested processors
	 * - daemon threads - background processes (garbage collection)
	 * 
	 * --> JVM terminates when no more user threads are active
	 * Synchronization - a method or statement is synchronized if 
	 * only one thread may access it at a time
	 * 
	 * Threads have states:
	 * New - thread is new
	 * Runnable - when ready to run (or running)
	 * Blocked - aka waiting state : when a thread is temporarily inactive it is either blocked or waiting
	 * 		a thread is in the blocked state when it tries to access a protected section of code that is 
	 * 		currently blocked in another thread
	 * Waiting  thread can be made to wait for other actions
	 * Timed Waiting - can call a timed wait method in threads
	 * Terminated - a thread terminate because either it completes its task naturally or because some unusual 
	 * 		or exceptional event occurs
	 * 
	 * Related Topics: deadlock, starvation, producer-consumer problem
	 */
	
	public static void main(String[] args) {
		ExtendThread et = new ExtendThread();
		ImplementRunnable ir = new ImplementRunnable();
		Thread isThread = new Thread(ir);
		
		
		Runnable anonymous = new Runnable() { // Anonymous class :D

			@Override
			public void run() {
				System.out.println("Is anon class implementation");
				for (int i = 1000; i > 0; i--) {
					System.out.println("ANON: " + i);
				}
				
			}
			
		};
		Thread anonThread = new Thread(anonymous);
		
		
		// Lambda
		Runnable lambda = () -> {
				System.out.println("In lambda");
				for (int i = 1000; i > 0; i--) {
					System.out.println("Lambda: " + i);
				}
	};
		Thread l = new Thread(lambda);
		isThread.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		l.start();
		System.out.println("State of lambda " + l.getState());
		anonThread.start();
		et.start();
		isThread.start();
		System.out.println("State of lambda " + l.getState());
	}
	
}
