package com.revature.threads;

public class Treads101 {
	/*
	 * Thread - a single path of execution in your code
	 * Multithreading - multple flows of control in program execution
	 * -each thred gets its own stack and follows its own sequence of method calls with associated variables
	 * We create a seperate thread of execution by either implementing the runnable interface or by extending the thread class
	 * there are nuances with both
	 * 
	 * types of threads
	 * user - main() or any other expicitly requested processes
	 * daemon threads - background process ie garbage collector
	 * 
	 * isAlive() - checks if a thread is actuve
	 * join() allows one thread to wait for the completeion of another
	 * 
	 * jvm terminates whem no more user threads are active
	 * 
	 * synchromization a method or statement is synchronized if only one thread may aces it at a ntime
	 * 
	 * threads have state, they are
	 * new - thread is new
	 * Runnable - whe ready to run(may be running or simply ready to run at any time)
	 * blocked - aka waiting state
	 * when a threa is temporarily inactive it is either blocked or waiting
	 * a thread is in the blocked state when it tries to acess a protected section of code that is currently locked in another thread
	 * waiting - threads can be made to wait for other ations
	 * timed waiting - can call a timed wait method in threads
	 * Terminated - a thread terminates because eithrer it cmpletes its teask naturally or because some unsusual or exceptional event occurs
	 * 
	 * related topics: deadlok, starvation, producer-consumer problem
	 * 

*/
	public static void main(String[] args) {
	ExtendsThread et = new ExtendsThread();
	et.start();
	
	ImplementsRunnable ir = new ImplementsRunnable();
	Thread isThread =	new Thread(ir);	
	isThread.start ();					
			
	
	
	Runnable Anonymous = new Runnable() {

		@Override
		public void run() {
System.out.println("In anon class implementation");
for(int i=0; i < 50;i++) {
	System.out.println("Anon: " + i);
}
		}
		
	};
	Thread anonThread = new Thread(Anonymous);
	anonThread.start();
	}
	
	Runnable lamda = () ->{
	System.out.println("In Lamds");
	for(int i=0; i < 50;i++) {
		System.out.println("Lamda: " + i);
	Thread l = new Thread(lamda);
		l.start();
	System.out.println("State of Lamda Thread" + l.getstate());
		
	}
	};
	
	

}


	
	

