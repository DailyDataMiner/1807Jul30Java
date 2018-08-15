package com.revature.threads;

public class Starvation extends Thread{
	int threadcount = 1;
	
	@Override
		public void run() {
		
		
		System.out.println(threadcount  + "st Child" + 
                 " Thread execution starts");
		 System.out.println("Child thread execution completes");
		 threadcount++;
			
		}



public static void main(String[] args) 
        throws InterruptedException
{
	System.out.println("Main thread execution starts");
	 
    // Thread priorities are set in a way that thread5
    // gets least priority.
    Starvation thread1 = new Starvation();
    thread1.setPriority(10);
    Starvation thread2 = new Starvation();
    thread2.setPriority(9);
    Starvation thread3 = new Starvation();
    thread1.setPriority(8);
    Starvation thread4 = new Starvation();
    thread1.setPriority(7);
    Starvation thread5 = new Starvation();
    thread1.setPriority(6);

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    // Here thread5 have to wait because of the
    // other thread. But after waiting for some
    // interval, thread5 will get the chance of 
    // execution. It is known as Starvation
    thread5.start();
}


}
