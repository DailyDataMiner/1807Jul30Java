package hw.q9;

import java.util.ArrayList;

public class Primes 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> aList = new ArrayList<Integer>();
		
		for (int i = 1; i <= 100; i++)
		{
			aList.add(i);
		}
		
		for (int i: aList)
		{
			if (isPrime(i))
			{
				System.out.println(i);
			}
		}
	}
	
	public static boolean isPrime(int num)
	{
		boolean isPrime = true;
		
		if (num == 1)
		{
			return false;
		}
		
		for (int i = 2; i <= num/2; i++)
		{
			if (num % i == 0)
			{
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}

}
