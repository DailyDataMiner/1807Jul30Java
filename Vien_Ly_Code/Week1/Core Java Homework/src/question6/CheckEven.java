package question6;

public class CheckEven {
	public static void main(String[] args) {
		System.out.println(isEven(21));
	}

	
	public static boolean isEven(int n) {
		int i = n / 2;
		return i * 2 == n;
	}
}
