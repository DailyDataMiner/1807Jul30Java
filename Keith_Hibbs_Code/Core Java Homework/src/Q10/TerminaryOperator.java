package Q10;

public class TerminaryOperator {

	public static void main(String[] args) {
//reads numbers
		String num = args[0];
		int n1 = Integer.parseInt(num);

		String num2 = args[0];
		int n2 = Integer.parseInt(num2);

	System.out.println("Number 1: " + n1 + "     Number 2: " +n2);
	System.out.println("The smaller number is: " + Min(n1,n2));
	}

	//terminary operator
	public static int Min(int n1, int n2) {
		return (n1 < n2) ? n1:n2;
}
}
