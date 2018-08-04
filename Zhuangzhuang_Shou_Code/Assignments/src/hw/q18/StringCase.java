package hw.q18;

public class StringCase 
{
	public static void main(String[] args) 
	{
		SCaseChild child = new SCaseChild();
		System.out.println(child.hasUppercase("Hi"));
		System.out.println(child.toUppercase("hi"));
		System.out.println(child.addToString("0"));
	}
}

abstract class SCaseParent
{
	abstract boolean hasUppercase(String s);
	abstract String toUppercase(String s);
	abstract int addToString(String s);
}

class SCaseChild extends SCaseParent
{
	public boolean hasUppercase(String s)
	{
		return !s.equals(s.toLowerCase());
	}
	
	public String toUppercase(String s)
	{
		return s.toUpperCase();
	}
	
	public int addToString(String s)
	{
		return 10 + Integer.parseInt(s);
	}
}
