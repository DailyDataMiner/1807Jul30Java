package Q12;

public class Evens {
	
	public static void main(String[] args) {
		int[] array = new int[100];
//assigns variable
		for(int i = 0; i < 100; i++) {
			array[i] = i;}
//prints even values
		for(int i:array) {
		if (Even(i)==true) {
		System.out.println(array[i]);
		}
	}
}
//Determines if it's even
	static Boolean Even(int i) {
		if ((i % 2) == 0) {return true;}
		else {return false;}
	}
}