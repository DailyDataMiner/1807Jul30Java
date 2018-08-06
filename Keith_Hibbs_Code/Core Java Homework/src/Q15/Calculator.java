package Q15;

public class Calculator {
	static int ans;
public static void main(String[] args) {
	System.out.println("1: Addition");
	System.out.println("2: Subtraction");
	System.out.println("3: Multiplication");
	System.out.println("4: Division");		
	System.out.println("Choose  what type of Equasion: ");	
	String selectr = args[0];
	int n = Integer.parseInt(selectr);
	System.out.println("Enter 1st integer: ");
	String num1 = args[0];
	int x = Integer.parseInt(num1);
	System.out.println("Enter 2nd Integer: ");
	String num2 = args[0];
	int y = Integer.parseInt(num2);
	switch (n) {
		case 1: ans = x + y;
			break;
		case 2: ans = x - y;
			break;
		case 3: ans = x * y;
			break;
		case 4: ans = x / y;
			break;
	default: System.out.println("Error");
	System.out.println(ans);
	
	
	}
}
}
