package com.revature.intro;

public class ControlStatementsExample1 {
	
	public static void main(String[] args) {
		
		
			
			
			int listOfRandomNumbers[];
			
			listOfRandomNumbers = new int[100];
			
			
			int counter = 99;
			
			for (int i : listOfRandomNumbers) {
				
				listOfRandomNumbers[(int) i] = (int) Math.round(100*Math.random());
				
				System.out.println(listOfRandomNumbers[(int) i]);
				
			}
			
			
			do {
				
				if (listOfRandomNumbers[counter]%2==1) {
					
					listOfRandomNumbers[counter] = listOfRandomNumbers[counter]+1;
				}
	
				
			counter--;
				
				
			} while (counter>0);
			
			
			
			
			while (counter<100) {
				if (listOfRandomNumbers[counter]%2==0) {
					
					listOfRandomNumbers[counter] =  listOfRandomNumbers[counter]-1;
				}
				
				
			}
			
			
			if (listOfRandomNumbers[99]>=50) {
				
				listOfRandomNumbers[99]=0;
				
				
			} else {
				
				if (listOfRandomNumbers[0]>=50) {
					listOfRandomNumbers[0]=100;
					
				}

			}
		
		
		for (int i : listOfRandomNumbers) {
			
			System.out.println(listOfRandomNumbers[i]);
			
		}
		
		}
		
		
		
		
	}
	
	


