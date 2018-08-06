package homework1.q9;

import java.util.ArrayList;

public class PrimeNums {

	public static void main(String[] args) {
		
		ArrayList<Object> nums = new ArrayList<>();
		boolean prime = true;
		
		//adds integers 1-100 to array list
		for(int i = 0;i <= 100; i++) {
			nums.add(i);
		}
		
		//Finds prime numbers and prints them
		for(int i=1; i< nums.size(); i++) {
			int n = (int)nums.get(i);
			prime = true;
			for(int j=2; j < n; j++) {
				if(n % j == 0) {
					prime = false;
					break;
				}
			}
			if(prime == true && n != 1) {
				System.out.println(n);
			}
			
			
		}

	}

}
