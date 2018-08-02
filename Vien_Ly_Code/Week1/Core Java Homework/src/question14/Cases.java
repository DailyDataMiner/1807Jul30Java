package question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cases {

	public static void main(String[] args) {
		cases(2);
	}
	
	public static void cases(int n) {
		int number = 100;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String str = new String("I am learning Core Java");
		String[] res;

		switch(n) {
		case 1: System.out.println("sqrt of " + number + " is " + Math.sqrt(number));
				break;
		case 2: System.out.println(dateFormat.format(date));
				break;
		case 3: res = str.split(" ");
				System.out.println("split string array is: ");
				for (String item : res) {
					System.out.print(item + ", ");
				}
				break;
		}
	}

}
