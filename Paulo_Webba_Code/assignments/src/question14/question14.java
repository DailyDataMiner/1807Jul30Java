package question14;

import java.util.Date;




public class question14 {

	public static void main(String[] args) {
	
		int n = 3;
		int number = 144;
		String str = new String("I am learning Core Java");
		Date date = new Date();
		switch (n) {
		   case 1:{ System.out.println(Math.sqrt(number)); break;}
		   case 2:{ System.out.println(date); break;}
		   case 3:{ String [] arrOfStrings = str.split(" ", 5);
		      for (String a : arrOfStrings)System.out.println(a); break;}
		    default: { System.out.println("\n");}
		}
		
	}

}
