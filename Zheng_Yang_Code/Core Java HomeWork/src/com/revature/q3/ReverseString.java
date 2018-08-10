package com.revature.q3;

public class ReverseString {
	public static void main(String[] args) {
		
		
		
		
		String str = "Revature234";
		//turn string into array
		String arr[] = str. split("");
 
        //swap front and back element in array with temperary variable
        for(int i = 0; i < arr.length/2; i++) {
        	String temp = arr[i];
        	arr[i] = arr[arr.length - 1 - i] ;
        	arr[arr.length - 1 - i] = temp;
        }
        
        for (String s : arr) {
			System.out.print(""+ s);
		}
				
	}
}
