package com.revature.week1q2;

public class fibonacci {
	
	static int fibonacci(int num)
    {
		
		
    if (num <= 1)
    	
       return num;
    
    return fibonacci(num-1) + fibonacci(num-2);
    }

	
	public static void main(String[] args) {
		
		
		
		for (int i = 0; i < 25; i++) {
			
			System.out.println( fibonacci(i) );
			
		}
		
		
		
	}
	
	
}



