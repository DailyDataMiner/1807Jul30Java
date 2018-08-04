// Logan Smith 8/2/2018

package question3;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringReverse sr = new StringReverse(); // Will be used to reverse the string
		
		String pug = "Pugs are great!"; // String to reverse
		pug = sr.reverser(pug); // reverses string
		System.out.println(pug);
		
	}
	
	// Method to reverse a string without using a variable
	public String reverser(String s) {
		// Loops through string, starting at the second to last character
		for (int i = s.length()-2; i >= 0; i--) {
			s = s.substring(0, i) + s.substring(i+1, s.length()) + s.substring(i, i+1); // Removes the ith char and moves it to the end
		}
		
		return s; // returns last string
	}

}
