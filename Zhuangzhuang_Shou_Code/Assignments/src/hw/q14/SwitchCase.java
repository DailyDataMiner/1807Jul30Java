package hw.q14;

import java.time.LocalDate;
import java.util.Arrays;

public class SwitchCase 
{
	public static void main(String[] args) 
	{
		int choice = 1;
		
		switch(choice)
		{
		case 1:
			System.out.println(Math.sqrt(16));
			break;
		case 2:
			System.out.println(LocalDate.now());
			break;
		case 3:
			String s = "I am learning Core Java";
			String[] a = s.split(" ");
			System.out.println(Arrays.toString(a));
			break;	
		}
	}

}
