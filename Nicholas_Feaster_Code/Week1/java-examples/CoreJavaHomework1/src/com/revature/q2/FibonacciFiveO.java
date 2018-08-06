package com.revature.q2;

public class FibonacciFiveO {

	public static void main(String[] args) {
		int count = 0; // to keep count in the generating array
		int count2 = 25;// to keep count in the printing array
		//now that i think about it, could just reset the generating counter
		int[] quick = {0,1}; //The first two numbers of the the Fibonacci sequence
		int[] fibonacciNums = new int[50];// array with more than enough space to hold 25 number in the sequence
		while(count<30) {
			int temp1 = quick[0];
			int temp2 = quick[1];
			int newValue = temp1+temp2;
			fibonacciNums[count] = quick[0];
			count++;
			quick[0]=quick[1];
			quick[1]=newValue;
		}//loop uses a swap to generate the sequence iteratively 
		System.out.println("The Fibonacci sequence ");//For readablity
		//for(int it:fibonacciNums) {
			//if(it<25) {
		for(int printLoop=0; printLoop<count2;printLoop++) {
			System.out.print(fibonacciNums[printLoop] + " ");
		}//the printing loop
			//}
		//}
	}

}
