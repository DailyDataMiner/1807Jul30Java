package Q19;
import java.util.ArrayList;
import Q9.Prime;

public class ArrayListManipulation {
public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<>();
		int total = 0;
		
		for (int i = 1 ; i <= 10 ; i++)
			nums.add(i);
		
		System.out.println("Array List: " + nums);
		System.out.println(nums);
		for (int i = 0 ; i < 10 ; i++) {
			if (nums.get(i) % 2 == 0) {
				total += nums.get(i);
			}
		}
		
		System.out.println("Sum of Even Numbers: " + total);

		total = 0;
		
		for (int i = 0 ; i < 10 ; i++ ) {
			if (nums.get(i) % 2 != 0) {
				total += nums.get(i);
			}
		}
		System.out.println("Sum of Odd Numbers: " + total);

		total = 0;
		
		for (int i = nums.size() - 1 ; i >= 0 ; i-- ) {
			if (((Prime.primeNum(nums.get(i))))) {
				continue;
			}
			else {
				nums.remove(i);
			}
			
		}
		
		System.out.println("List of Prime Numbers: " + nums);
	}
	

}

