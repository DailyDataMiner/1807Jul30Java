package Q4;

public class Factorial {
public static void main(String[] args) {
//gets user input
	String num = args[0];
	int n = Integer.parseInt(num);
//gets the factorial
	int x = 1;
		for (int i = n; i > 1; i--)
			x *= i;
		System.out.println(x);		
}
}
