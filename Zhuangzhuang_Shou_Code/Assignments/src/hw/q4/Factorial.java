package hw.q4;

public class Factorial 
{
	public static void main(String[] args) 
	{
		int factorial = 1;
		int num = 10;
		
		for (int i = 1; i <= num; i ++)
		{
			factorial *= i;
		}
		
		System.out.println(factorial);
	}

}
