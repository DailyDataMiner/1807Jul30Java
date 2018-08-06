package homework1.q19;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {
	static int total = 0;
	static int count = 0;
	static int[] toRemove = new int[20];
	static boolean primeCheck = true;

	public static void main(String[] args) {
		
		//Creates new array list and adds numbers 1-10
		List<Integer> practice = new ArrayList<Integer>();
		for(int i = 1; i < 11; i++) {
			practice.add(i);
		}
		System.out.println(practice);
		
		addEvens(practice);
		addOdds(practice);
		rmvPrimes(practice);

	}

	//Adds all even numbers in array list by checking each element within and seeing if divisible by 2 and if so then adding them together
	public static void addEvens(List<Integer> practice) {
		
		practice.forEach(num ->{
			int n = (int) num;
			if(n % 2 == 0) {
				total = total + n;
			}
		});
		System.out.println(total);
	}
	
	//Checks each element within array list, if not divisible by 2 then adds each one together.
	public static void addOdds(List<Integer> practice) {
		total = 0;
		practice.forEach(num ->{
			int n = (int) num;
			if(n % 2 != 0) {
				total = total + n;
			}
		});
		System.out.println(total);
	}
	
	//Checks for prime numbers by looking at each element within the array list 
	//For each element, it loops through all possible values to determine if it's divisible.
	//If so it breaks immediately and determines primenumber is false.
	//If loop completes without being divisible, then removes number from array list since it's a real number.
	public static void rmvPrimes(List<Integer> practice) {
		//total = 0;
		practice.forEach(num ->{
			primeCheck = true;
			count ++;
			for(int i = 2; i < num; i++) {
				if(num % i == 0) {
					primeCheck = false;
					break;
				}
			}
			if(primeCheck == true && num != 1) {
				toRemove[count] = num;
			}
		});
		for(int i = 0; i < toRemove.length; i++) {
			if(toRemove[i] != 0) {
				practice.remove((Object)toRemove[i]);
			}
		}
		System.out.println(practice);
	}
	
	

}
