package hw.q10;

public class FindMinimum 
{
	public static void main(String[] args) 
	{
		System.out.println(findMinimum(20, 9));
	}
	
	public static int findMinimum(int a, int b)
	{
		return a < b ? a : b;
	}
}
