package Q3;

public class reverseString {

	public void reverseString(String stringy) {	//our function takes in a string and calls it stringy

		int leng = stringy.length();			//create length variable that holds the length of the string passed in
		System.out.println("the length of your string is: " + leng);
	    
		for (int i = (leng-1); i >= 0; --i) {	//going from the last index number to zero...
			stringy += stringy.charAt(i);		//our string is appended with its own characters in reverse order
		}
		
		System.out.println(stringy); 			//if you want to see the full palindrome, here it is
		
	    stringy = stringy.substring(leng);		//then we set our string equal to only its last half, which we just made

	    System.out.println("\n" + "your new reversed string is: " + "\n" + stringy);
		
	}
	
	public static void main(String[] args) {
		String str = "This is your string to be reversed!";
		reverseString rs = new reverseString();
		rs.reverseString(str);
	}

}
