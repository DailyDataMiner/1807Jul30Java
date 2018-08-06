package homework1.q12;

public class EnhancedFor {

	public static void main(String[] args) {
		// array declaration
		int arr[] = new int[100];
		
		//Adds indexes 1-100 
		for(int i=0; i<arr.length;i++) {
			arr[i] = i + 1;
		}
		//enhanced for loop that prints all even numbers
		for(int index:arr) {
			if(index <= 99 && arr[index] %2 == 0) {
				System.out.println(arr[index]);
			}
		}
		
	}

}
