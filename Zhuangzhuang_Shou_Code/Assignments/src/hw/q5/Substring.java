package hw.q5;

public class Substring 
{
	public static void main(String[] args) 
	{
		String s = "String";
		System.out.println(substring(s, 3));
	}
	
	public static String substring(String s, int idx)
	{
		String sub = "";
		
		for (int i = 0; i < idx; i++)
		{
			sub += s.charAt(i);
		}
		
		return sub;
	}
}
