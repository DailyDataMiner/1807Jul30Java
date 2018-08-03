package com.revature.threads;
import com.revature.helpers.HelperFunctions;

public class Threads101 extends HelperFunctions {
	public static void main(String[] args) {
		
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		Thread isThread = new Thread(ir);
		
		// Anonymous class (that implements Runnable and instiantate* it (the class) at the same time.
		Runnable anonymous = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				print("In anon class implementation");
				for (int i = 0; i < 50; i++) {
					print("ANON: " + i);
				}
			}
		};
		
		Thread anonThread = new Thread(anonymous);
		
		// LAMBDASSS
		Runnable lambda = () -> {
			print("In LAMBDA");
			for (int i = 0; i < 50; i++) {
				print("Lambda: " + i);
			}
		};
		
		Thread l = new Thread(lambda);
		isThread.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		l.start();
		
		print("STATE OF LAMBDA THREAD " + l.getState());

		anonThread.start();
		et.start();
		isThread.start();
		print("STATE OF LAMBDA THREAD " + l.getState());
		print("STATE OF IR THREAD " + isThread.getState());
		
	}
}
