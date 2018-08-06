package Q1;

public class bubbleSort {

	public void bubbleSort(int[] n) {
		System.out.println("length of array n is " + n.length);
		System.out.println("Original Array: ");

		for(int i = 0; i < n.length; i++) {	// loop to print array
			System.out.print(n[i] + " ");	//
		}									//
		
		int holder = 0;						//temporary variable to hold element values
		
		for(int j = 0; j < n.length; j++) {	//for loop that repeats as many times as the array has elements
			for(int i = 0; i < n.length - 1; i++) {	//inner for loop
				if(n[i] > n[i + 1]) {				//if the former element is greater than the latter,
					holder = n[i];					//set your temporary variable equal to the value of the former element
					n[i] = n[i+1];					//set your former element equal to the latter element
					n[i+1] = holder;				//set your latter element equal to the previous value of the 
				}									//first element, which was stored in holder
			}
		}
		
		System.out.println("\n" + "\n" + "length of new array n is " + n.length);		
		System.out.println("New Array: ");
		for(int i = 0; i < n.length; i++) {	// loop to print array
			System.out.print(n[i] + " ");	//
		}	
		
	}
	
	public static void main(String[] args) {
		int[] numbers = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		bubbleSort bub = new bubbleSort();
		bub.bubbleSort(numbers);
	}

}
