package BubbleSort;

public class BubbleSort {

	public static void bubbleSort(int [] list) {
		boolean goToNextPosition = true;
		for(int np =1; np < list.length && goToNextPosition; np++) {
			goToNextPosition = false;
			for(int i= 0; i < list.length - np; i++) {
				if(list[i] > list[i+1]) {
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					goToNextPosition = true; 
				}
			}	
		}
			
	}
	
	
	public static void main(String[] args) {
		int [] list = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(list);
		System.out.println("The sorted list is: ");
		for(int i = 0; i < list.length; i++) {
			System.out.print( list[i] + " " );
		}
	}

}