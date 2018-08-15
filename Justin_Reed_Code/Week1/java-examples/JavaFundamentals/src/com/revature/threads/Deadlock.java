package com.revature.threads;

public class Deadlock extends Thread {
	
	//creates first thread 
	public static Thread firstThread = new Thread();
	
	
	@Override // 
	public void run() {
		System.out.println("Second Thread waits for First to complete");
		
		try {
			// Child thread waiting for completion
            // of main thread
			firstThread.join();
			
		}
		catch(InterruptedException e) {
			System.out.println("Child Threat excution is complete");
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Deadlock.firstThread = Thread.currentThread();
		firstThread.setPriority(Thread.MAX_PRIORITY);
		// creates second thread 
		Deadlock secondThread = new Deadlock();
		
		secondThread.start(); 
		System.out.println("Main thread us waiting second thread to complete");
		
		//main thread is waiting for the completion of Child thread
		secondThread.join();
		
		System.out.println("Main thread execution completes");
		
		
	}
	

}
