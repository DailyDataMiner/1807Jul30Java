package Q2;

public class fibonacci {

public void fibonacci(int count) {
		
		int fib1 = 0; 						//first Fibonacci number
		System.out.println(fib1); 			//print it
		int fib2 = 1; 						//second Fibonacci number
		System.out.println(fib2); 			//print it
		int fib3;							//third Fibonacci number to be used later
		
		for(int i = 1; i < (count - 1); i++) {	
			fib3 = fib1 + fib2;				//third number is equal to first plus second
			System.out.println(fib3);		//print it
			fib1 = fib2;					//new second is old first
			fib2 = fib3;					/*new third is old second (so the next fib3 will be the 
											  fourth element in the Fibonacci sequence, and so on...)*/
		}  
		
	}
	
	public static void main(String[] args) {
		fibonacci fb = new fibonacci();
		fb.fibonacci(25);
	}

}
