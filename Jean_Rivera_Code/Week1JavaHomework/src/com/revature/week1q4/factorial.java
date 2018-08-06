package com.revature.week1q4;

public class factorial {
	
	
	long factorial(long N) {
		
				
		if(N==0) {
				
			return 1;
					
					
			}else {
					
				return N * factorial(N-1);
					
					
				}
	}
	
	
	
	
	public static void main(String[] args) {
		
		long N = 15;
		
		factorial ob = new factorial();
		
		
		System.out.println("factorial "+ N + " is: ");
		N = ob.factorial(N);
		
		System.out.println(N);
		
		

		
		
		
	}
	
	

}
