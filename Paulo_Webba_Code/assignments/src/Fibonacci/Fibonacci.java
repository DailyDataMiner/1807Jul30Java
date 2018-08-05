package Fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
	   int i = 0, sum=0;
	   int n = 0, nextn = 1;
	   while(i < 25) {
		   System.out.print( n + " ");
		   sum = n + nextn;
		   n = nextn;
		   nextn = sum;
		   i++;
		   
	   }
	   
        
	}

}
