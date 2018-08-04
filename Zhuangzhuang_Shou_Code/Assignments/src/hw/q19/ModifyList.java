package hw.q19;

import java.util.ArrayList;

public class ModifyList 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> aList = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
		{
			aList.add(i);
		}
		System.out.println(aList.toString());
		
		int sum = 0;
		for (int num: aList)
		{
			if (num % 2 == 0)
			{
				sum += num;
			}
		}
		System.out.println(sum);
		
		sum = 0;
		for (int num: aList)
		{
			if (num % 2 == 1)
			{
				sum += num;
			}
		}
		System.out.println(sum);
		
		int[] primes = new int[aList.size()];
		int index = 0;
		for (int num: aList)
		{
			if (hw.q9.Primes.isPrime(num))
			{
				primes[index] = num;
				index++;
			}
		}
		for (int num: primes)
		{
			aList.remove((Integer)num);
		}
		System.out.println(aList.toString());
	}
}
