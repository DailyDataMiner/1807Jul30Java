package hw.q12;

public class PrintEvens 
{
	public static void main(String[] args) 
	{
		int[] intArray = new int[100];
		for (int i = 0; i < intArray.length; i++)
		{
			intArray[i] = i + 1;
		}
		
		for (int num: intArray)
		{
			if (num % 2 == 0)
			{
				System.out.println(num);
			}
		}
	}
}
