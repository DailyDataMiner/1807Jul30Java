// Logan Smith, 8/2/2018
// Simple BubbleSort

package question1;

public class BubbleSort {

	public static void main(String[] args) {

		// Creating array
		int[] toSort = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

		// Maximum number of array length sorts possible, so we need that many loops
		for (int i = 0; i <= toSort.length - 1; i++) {
			boolean finished = true; // If we don't need to switch anything, finished will break out of the loop early
			for (int j = 1; j <= toSort.length - 1; j++) { // We need to loop through each element in the list and evaluate them
				if (toSort[j - 1] > toSort[j]) { // If the numbers are out of order, we need to switch them
					int placeholder = toSort[j]; // We need a placeholder for this value since we're switching
					toSort[j] = toSort[j - 1]; // Switching!
					toSort[j - 1] = placeholder; // Switching!
					finished = false; // If we do need to switch something, then finished is false
				}
			}
			// If we go through the list without switching, then we can break
			if (finished == true) {
				break;
			}
		}
		System.out.println("The Final Array: ");
		for (int i = 0; i <= toSort.length - 1; i++) {
			System.out.print(toSort[i] + " ");
		}

	}

}
