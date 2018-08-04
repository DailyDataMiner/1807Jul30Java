package hw.q6;

public class Evens 
{
	public static void main(String[] args) 
	{
		int test = 10;
		System.out.println(isEven(test));
	}
	
	public static boolean isEven(int num)
	{
		String s = Integer.toBinaryString(num);
		return s.substring(s.length() - 1).equals("0");
	}
}
