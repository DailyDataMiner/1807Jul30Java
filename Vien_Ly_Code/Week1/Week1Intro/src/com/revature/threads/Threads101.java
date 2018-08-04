package com.revature.threads;


public class Threads101 {
	
	/*
	 * thread - single path of execution in your code
	 * multithreading - multiple flows of control in program execution
	 * - each thread gets its own stack and follows its own sequence of method calls with associated variables
	 * We create a separate thread of execution by either implementing the Runnable interface or by extending the thread cladd
	 * Types of threads:
	 * 		user, main() or any other explicitly requested processes
	 * 		daemon - background processes ie. garbage collector
	 * 
	 * isAlive() - check if thread is active
	 * join() - allows one thread to wait for the completion of another
	 * 
	 * --> JVM terminates when no more user threads are active
	 * 
	 * Synchronization - a method of statement is synched if only one thread may access it at a time
	 * 
	 * States 
	 * 		New - thread is new
	 * 		Runnable - when ready to run(may be running or simply ready to run at any time)
	 * 		Blocked - waiting state, temporarily inactive
	 * 					A thread is blocked when it tries to access a protected section of code that is currently accessed by another thread
	 * 		Waiting - can be made to wait for other actions
	 * 		Timed Waiting - can call a timed wait method in threads
	 * 		Terminated - a thread terminate because it completes its task naturally or because of an exceptional event
	 * Related: deadlock, starvation, producer - consumer problem
	 * 
	 */

	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		
		Runnable anonymous = new Runnable() {
			@Override
			public void run() {
				System.out.println("in anon class");
				for (int i = 0; i < 50; i++) {
					System.out.println("ANON: " + i);
				}
			}
		};
		
		Thread at = new Thread(anonymous);
		
		//LAMBDA
		Runnable lambda = () -> {
			System.out.println("In LAMBDA");
			for (int i = 0; i < 50; i++) {
				System.out.println("LAMBDA: " + i);
			}
		};
		
		Thread lt = new Thread(lambda);
		
		System.out.println("STATE OF LAMBDA THREAD: " + lt.getState());
		isThread.setPriority(Thread.MAX_PRIORITY);
		lt.setPriority(Thread.MIN_PRIORITY);
		
		lt.start();
		at.start();
		et.start();
		isThread.start();
		System.out.println("STATE OF LAMBDA THREAD: " + lt.getState());
		System.out.println("STATE OF IR THREAD: " + isThread.getState());

		

	}

}
