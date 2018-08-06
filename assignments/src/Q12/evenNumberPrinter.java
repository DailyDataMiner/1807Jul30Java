package Q12;

public class evenNumberPrinter {

	public static void main(String[] args) {
		
		int[] theArray = new int[100];					//creating an array which has 100 spots
		
		for(int i = 0; i < theArray.length; i++) {
			theArray[i] = i + 1;						//filling the array with the numbers to 100
		}
		
		for(int n : theArray) {
			if(n % 2 == 0) {							//checking if number in array is even
				System.out.print(n + " ");				//printing if even
			}
		}
	}
}
