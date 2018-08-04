package hw.q15;

public class Operators implements Operations
{
	public static void main(String[] args) 
	{
		Operators o = new Operators();
		System.out.println(o.addition(1, 1));
	}
	
	public int addition(int a, int b)
	{
		return a + b;
	}
	
	public int subtraction(int a, int b)
	{
		return a - b;
	}
	
	public int multiplication(int a, int b)
	{
		return a * b;
	}
	
	public int division(int a, int b)
	{
		return a / b;
	}
}

interface Operations
{
	int addition(int a, int b);
	int subtraction(int a, int b);
	int multiplication(int a, int b);
	int division(int a, int b);
}