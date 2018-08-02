package question12;

public class EnhancedForLoops {

	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i = 1; i <= 100; i++) {
			arr[i - 1] = i;
		}
		for (int n : arr) {
			if (n % 2 == 0) {
				System.out.println(n);
			}
		}
	}

}
