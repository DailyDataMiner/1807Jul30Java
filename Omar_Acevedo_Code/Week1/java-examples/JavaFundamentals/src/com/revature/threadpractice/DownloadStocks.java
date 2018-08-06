package com.revature.threadpractice;
import com.revature.helpers.HelperFunctions;

// This is basically the "runnable" class.
// The one that does the job. (in a new call stack)
public class DownloadStocks extends HelperFunctions implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		print("Invoking a new thread of execution [new call stack] run(): " + 
				"ID: " + Thread.currentThread().getId() + ", " +
				Thread.currentThread().getName());
		downloadStocks(500);
	}
	private void downloadStocks(int p_stock_number) {
		for (int i = 0; i <= p_stock_number; i++) {
			print(Thread.currentThread().getId() + ", " + Thread.currentThread().getName() + ": -loop iter -> " + i);
		}
	}
}
