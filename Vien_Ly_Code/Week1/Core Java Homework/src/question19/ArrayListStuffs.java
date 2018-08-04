package question19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		
		li = li.stream().filter(i -> !isPrime(i)).collect(Collectors.toList());
		
		System.out.println("Sum of even numbers: " + evenSum);
		System.out.println("Sum of odd numbers: " + oddSum);
		System.out.println(li.toString());
	}
	
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
