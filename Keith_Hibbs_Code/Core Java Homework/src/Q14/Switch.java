package Q14;

import java.util.Date;

public class Switch {
public static void main(String[] args) {
	String num = args[0];
	int n = Integer.parseInt(num);
	
	switch (n) {
	
	case 1:
		String num2 = args[0];
		int x = Integer.parseInt(num2);
		System.out.println(Math.sqrt(x));
		break;
	case 2:
		Date d = new Date();
		System.out.println(d.toString());
		break;
	case 3:
		
		String str = "I am learning Core Java";
		String[] words = str.split(" ");
		for (String s : words) {
			System.out.println(s);
		}
		break;
		}
		
		
	}
	

}

