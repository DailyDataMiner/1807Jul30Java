package question17;

import java.text.NumberFormat;
import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);  
	   System.out.print("Enter principal as a double: ");
	   double principal = sc.nextDouble();
	   System.out.println();
	   
	   System.out.print("Enter rate as a double: ");
	   double rate = sc.nextDouble();
	   System.out.println();
	   
	   System.out.print("Enter time(years) as an integer: ");
	   int time = sc.nextInt();
	   System.out.println();
	   
	   NumberFormat formatter = NumberFormat.getCurrencyInstance();
	   
	   System.out.println("Your simple interest is: " + formatter.format(principal * rate * time));
	}

}
