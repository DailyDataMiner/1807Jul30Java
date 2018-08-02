// Logan Smith, 8/2/2018
// A program to create a substring

package SubStringPackage;

public class Substring {

	public static void main(String[] args) {
		
		Substring sub = new Substring(); // Creating object to perform substring
		
		String pug = "Pugs are great!"; // String to substring
		int max = 8; // Cutoff point
		
		pug = sub.subStringer(pug, max); // substrings the string
		
		System.out.println(pug);
		

	}
	
	// Method to create a substring by taking a string and an index, then cutting up until the index
	public String subStringer(String str, int idx) {
		
		String output = ""; // output string
		for (int i = 0; i < idx; i++) { // loops through string until index
			output = output + str.charAt(i); // adds the characters of the input string to the output string
		}
		return output;
	}

}
