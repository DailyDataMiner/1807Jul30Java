package hw.q3;

public class ReverseString 
{
	public static void main(String[] args) 
	{
		System.out.println(reverse("TestString"));
	}

	public static String reverse(String s)
	{
		for (int i = 0; i < s.length()/2; i++)
		{
			if (i == 0)
			{
				s = s.substring(s.length() - 1 - i, s.length() - i) + 
						s.substring(1 + i, s.length() - 1 - i) +
						s.substring(i, i + 1);
			}
			else
			{
				s = s.substring(0, i) +
						s.substring(s.length() - 1 - i, s.length() - i) + 
						s.substring(1 + i, s.length() - 1 - i) +
						s.substring(i, i + 1) +
						s.substring(s.length() - i, s.length());
			}
		}
		return s;
	}
}
