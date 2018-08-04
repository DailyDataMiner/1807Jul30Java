package hw.q13;

public class PrintPattern 
{
	public static void main(String[] args) 
	{
		int num = 10;
		for (int i = 1; i < 5; i++)
		{
			for (int j = 0; j < i; j++)
			{
				System.out.print(num%2 + " ");
				num--;
			}
			System.out.println();
		}
	}

}
