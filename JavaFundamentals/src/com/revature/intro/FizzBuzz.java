package com.revature.intro;

public class FizzBuzz {
	
	public static void main(String[] args) {	
		int n = 100;
	
		for (int i=1; i<=n; i++){
			if (i%3 == 0 && i%5 == 0)                                   
	    		System.out.print("FizzBuzz" + "\r\n");
			else if (i%5==0)
				System.out.print("Buzz" + "\r\n");
			else if (i%3==0)     
	    		System.out.print("Fizz" + "\r\n");
			else 
	    		System.out.print(i + "\r\n");
		}	
	}
}