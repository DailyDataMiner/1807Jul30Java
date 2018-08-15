package com.revature.hw1.question1;

public class bubblesort {
			
		
		//create a bubblesort
		
		public static void bubbleSort(int[] myArray)
		{
			 int n = myArray.length;  
		     int temp = 0;  
		     
		     // traverse through array
		     for(int i=0; i < n; i++){  
		     
		    	 for(int j=1; j < (n-i); j++){  
		                          
		    		 if(myArray[j-1] > myArray[j]){  
		                                 
		    			 //swap elements in Arrays  
		                 temp = myArray[j-1];  
		                 myArray[j-1] = myArray[j];  
		                 myArray[j] = temp;  
		                         }          
		                 }
		    	 }
		}

		public static void main(String[] args) {
			
			    int myArray[] = {1, 0, 5, 3, 2, 3, 7, 9, 8, 4};
			 
			    System.out.println("presort: ");
			    for(int i = 0; i < myArray.length; i++) {
			    	
			    	
			    	 System.out.print(myArray[i]);
			    }		
			    System.out.println();
			    System.out.println("postsort: ");
				bubbleSort(myArray);
				
				for(int i = 0; i < myArray.length; i++) {
			    	
			    	 System.out.print(myArray[i]);
			    }
	
				
		}
}