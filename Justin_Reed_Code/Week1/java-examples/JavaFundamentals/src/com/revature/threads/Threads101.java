package com.revature.threads;

public class Threads101 {
	/*
	 * Thread - a single path of execution in your code 
	 * Multi-threading - multiple flows of control in programming execution 
	 * - each thread gets its own stack and follow it own sequence of methods calls with associated vars 
	 * We create a separate thread of execution by either implementing the Runnable interface or by extending the thread class.
	 * There are nuances associated with both.
	 * 
	 * 
	 * Types of threads:
	 * -user -main () or any other explicitly requested process 
	 * -daemon threads - background process 
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
	        
	        
	        //LAMBDAS expressions can only be used with functional interfaces 
	        Runnable lambda = () -> {
	            System.out.println("In Lamda");
	            for(int i = 0; i < 50; i++) {
	                System.out.println("Lambda: " + i);
	            }
	        };
	        
	        Thread l = new Thread(lambda);
	        isThread.setPriority(Thread.MAX_PRIORITY);
	        l.setPriority(Thread.MIN_PRIORITY);
	        l.start();
	        System.out.println("State of Lambda Thread "+ l.getState());
	        anonThread.start();
	        et.start();
	        isThread.start();
	        System.out.println("State of Lambda Thread "+ l.getState());
	        System.out.println("State of IR Thread "+ isThread.getState());
	    }
	    
	    //anonymous instantiates one function and only one
	
}
