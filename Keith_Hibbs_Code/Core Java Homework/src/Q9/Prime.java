package Q9;

public class Prime {

	public static void main(String[] args) {
		int[] array = new int[100];
//assigns variable
		for(int i = 0; i < 100; i++) {
			array[i] = i;}
// prints prime numbers
		for(int i:array) {
			if (primeNum(i)==true) {
			System.out.println(array[i]);
			}}
	}
//determines if a value is prime
public static  boolean primeNum (int i) {
		for (int x = 2; x<i; x++) { 
		if (i % x == 0) {return false;
		}}return true;
		

}
}
