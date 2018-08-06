package primes_Q9;
import java.util.ArrayList;

public class primeNumbers {
	
	 public static boolean primeNumba(int n) {
		boolean isPrime = true;
	    int i, m;
	    m= n/2;
	    if(n==0 || n==1) {
	    	//System.out.println(n + "not prime");
	    	isPrime = false;
	    }else {
	    	for(i =2; i <= m; i++) {
	    		if(n%i == 0) {
	    			//System.out.println(n + " is not prime number");
	    			isPrime = false;
	    			break;
	    		}
	    	}
	    	if(isPrime) {
	    		//System.out.println(n + " prime number");
	    		return isPrime;
	    		}
	    	
	    } return isPrime;
	
	}
    
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(100);
		int n =100;
		for(int i=0; i < n; i++){
		    if(primeNumba(i)) {
		    	numbers.add(i);
		    };
		} System.out.println(numbers);
	}

}
