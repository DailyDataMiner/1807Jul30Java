package com.revature.threads;

public class Threads101 {
	/*
	 * Thread - a single path of execution in your code
	 * Multithreading - multiple flows of control in program execution
	 *  - each thread gets its own stack and follows its own
	 *    sequence of method calls with associated variables
	 * We create a separate thread of execution by either
	 * implementing the Runnable interface or by extending 
	 * the thread class. There are nuances associated w/ both
	 * 
	 * Types of threads:
	 *  - user - main() or any other explicitly processes
	 *  - daemon threads - background processes ie garbage collector
	 *  
	 *  isAlive() - checks if thread is active
	 *  join() - allows one thread to wait for completion of another
	 *  
	 *  --> JVM terminates when no more user threads are active
	 *  
	 *  synchronization - a method or statement is synchronized if 
	 *  only one thread may access it at a time.
	 *  
	 *  Threads have state. they are: 
	 *  new - thread is new
	 *  runnable - when ready to run(may be running or simply
	 *  	ready to run at anytime)
	 *  blocked - aka waiting state
	 *  	when a thread is temporarily inactive it is either
	 *  	blocked or waiting
	 *  	A thread is in the blocked state when it tries to
	 *  	access a protected section of code that is currently
	 *  	locked in another thread
	 *  waiting - Threads can be made to wait for other actions
	 *  timed waiting - can call a timed wait method in threads
	 *  terminated - a thread terminate because either it 
	 *  	completes its tak naturally or because some
	 *  	unusual or exceptional event occurs.
	 *  
	 *  Related topics: deadlock, starvation and the producer-consumer problem.
	 */
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		Runnable anonymous = new Runnable() {
			@Override
			public void run() {
				System.out.println("in anon class implementation");
				for(int i = 0; i < 50; i++) {
					System.out.println("ANON: " + i);
				}				
			}			
		};
		Thread anonThread = new Thread(anonymous);
		
		//Lambdas only work with 1 (functional) method interfaces
		Runnable lambda = () ->{
			System.out.println("In Lambda");
			for(int i = 0; i < 50; i++) {
				System.out.println("Lamda: " + i);
			}
		};
		Thread l = new Thread(lambda);
		isThread.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		l.start();
		System.out.println("State of Lambda thread: " + l.getState());
		isThread.start();
		anonThread.start();
		et.start();
		System.out.println("State of Lambda thread: " + l.getState());
		System.out.println("State of isThread thread: " + isThread.getState());
		System.out.println("State of anonThread thread: " + anonThread.getState());
		
		
	}

}
