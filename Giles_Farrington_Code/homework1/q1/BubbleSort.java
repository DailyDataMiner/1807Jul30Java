package homework1.q1;

public class BubbleSort {

	public static void main(String[] args) {
		
		int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		displayArray(arr);
		bubbleSort(arr);
		
		
	}
	
	//Sorts integer array by value
	static void bubbleSort(int[] arr) {
		int length = arr.length;
		int temp = 0;
		
		for(int i = 0; i < length; i++) {
			for(int j = 1; j < (length - i); j++) {
				if(arr[j - 1] > arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("\nArray after bubblesort: ");
		displayArray(arr);
	}
	
	//displays array
	static void displayArray(int[] arr) {
		int length = arr.length;
		
		for(int i = 0; i < length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
}
