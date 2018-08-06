package Q17;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter principal: ");
		float p = s.nextFloat();
		System.out.println("Enter rate: ");
		float r = s.nextFloat();
		System.out.println("Enter time: ");
		float t = s.nextFloat();
		
		System.out.println();
		System.out.println("Interest: " + CalculateInterest(p, r, t));
		s.close();
	}

	public static float CalculateInterest(float principal, float rate, float time) {
		return principal * rate * time;
}
	
}
