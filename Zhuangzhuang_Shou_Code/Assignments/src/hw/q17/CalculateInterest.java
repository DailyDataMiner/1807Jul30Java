package hw.q17;

import java.util.Scanner;

public class CalculateInterest 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		double principal;
		double rate;
		int years;
		
		System.out.println("Principal:");
		principal = in.nextDouble();
		System.out.println("Interest Rate:");
		rate = in.nextDouble();
		System.out.println("Years: ");
		years = in.nextInt();
		
		System.out.println(principal * rate * years);
	}
}
