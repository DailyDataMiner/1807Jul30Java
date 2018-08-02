package question9;

import java.util.ArrayList;
import java.util.List;

public class PrintPrimes {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i <= 100; i++) {
			numbers.add(i);
		}
		
		for(int i : numbers) {
			if (i > 1 && isPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
