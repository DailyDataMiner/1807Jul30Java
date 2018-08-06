package homework1.q3;

public class ReverseString {

	public static void main(String[] args) {
		String str = "Going To Reverse This!";
		reverseString(str);
	}
	
	//Reverses String by converting to char array and re-arranging the characters.
	//Prints out newly reversed string
	public static void reverseString(String str) {
		
		char[] orig = str.toCharArray();
		char[] reversed = new char[orig.length];
		
		for(int i = 0; i < orig.length; i++) {
			reversed[i] = orig[(orig.length - 1) - i];
		}
		String completed = new String(reversed);
		System.out.println(completed);
	}
}
