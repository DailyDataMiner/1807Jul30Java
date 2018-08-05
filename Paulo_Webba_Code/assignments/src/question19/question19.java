package question19;

import java.util.ArrayList;

//import Primes.primeNumbers;

public class question19 {
	
	public static void main(String [] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i =1; i <= 10; i++) {
			numbers.add(i);
		}
		System.out.print(numbers);
		System.out.println();
		ArrayList<Integer> EvenNumbers = new ArrayList<Integer>();
		int sum =0;
		for (int i =1; i <= 10; i++) {
			if(i%2 ==0) {
			EvenNumbers.add(i);
			sum += i;
			}
		}
		System.out.print(sum);
		System.out.println();
		ArrayList<Integer> remaining = new ArrayList<Integer>(numbers);
	 int index = 0; 
		   for(int i= 1; i <= remaining.size(); i++){
			   if(Primes.primeNumbers.primeNumba(i)) {
				   remaining.remove(remaining.get(index));
				   remaining.trimToSize();
				 }else index++;
		}System.out.println(remaining);
	}
}
