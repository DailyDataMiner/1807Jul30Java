package com.revature.threadpractice;

// The "worker" runs the "runnable" class.
// The work is who makes the "job" possible.
public class Worker {

	public static void main(String[] args) {
		
		System.out.println("main method thread name -> " + Thread.currentThread().getName());
		
		// This is the "runnable"; the target to a thread or to multiple threads.
		// The instance with the "job" to do.
		DownloadStocks getStocks = new DownloadStocks();
		
		// Pass the runnable to various threads, so it becomes the target of multiple threads.
		Thread thread1 = new Thread(getStocks);
		Thread thread2 = new Thread(getStocks);
		Thread thread3 = new Thread(getStocks);
		Thread thread4 = new Thread(getStocks);
		
//		thread1.setName("thread1");
		thread1.start();
		
//		thread2.setName("thread2");
		thread2.start();
		
//		thread3.setName("thread3");
		thread3.start();
		
//		thread4.setName("thread4");
		thread4.start();
		
	}

}
