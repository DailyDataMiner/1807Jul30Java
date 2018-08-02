package question19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListStuffs {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		int evenSum = 0;
		int oddSum = 0;
		
		for(int i = 1; i <= 10; i++) {
			li.add(Integer.valueOf(i));
		}
		
		System.out.println(li.toString());
		
		for(Integer i : li) {
			if (i.intValue() % 2 == 0) {
				evenSum += i.intValue();
			} else {
				oddSum += i.intValue();		
			}
		}
		
		for(Integer i : li) {
			int temp = i.intValue();
			if (isPrime(temp))
				li.remove(i);
		}
		
		
		System.out.println("Sum of even numbers: " + evenSum);
		System.out.println("Sum of odd numbers: " + oddSum);
		System.out.println(li.toString());
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
