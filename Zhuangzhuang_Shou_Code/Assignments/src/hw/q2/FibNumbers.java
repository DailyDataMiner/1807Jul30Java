package hw.q2;

public class FibNumbers 
{
	public static void main(String[] args) 
	{
		for (int i = 0; i < 25; i++)
		{
			System.out.println(getFibNumber(i));
		}
	}
	
	public static int getFibNumber(int i)
	{
		if (i < 1)
		{
			return 0;
		}
		else if (i == 1)
		{
			return 1;
		}
		else
		{
			return getFibNumber(i - 1) + getFibNumber(i - 2);
		}
	}
}
