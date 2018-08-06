package Q6;

public class EvenOrOdd {
public static void main(String[] args) {
	String num = args[0];
	int n = Integer.parseInt(num);
	// A dumb way I thought of
//	while (n >2) {n = n-2;}
	// Bitwise
	int x = 0;
	n = n & x;
	if (n==2) {
		System.out.println("Even");
	} else System.out.println("Odd");

	
}
}
