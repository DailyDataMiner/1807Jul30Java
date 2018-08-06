package Q3;

import java.util.Scanner;

public class Reverse {
public static void main(String[] args) {

//tried getting it to read a string but had some trouble and already spent too much time on this
	
//String input[] = args;
	String input = "This is the string that will be reversed";

	System.out.println(input);
System.out.println(Reverser(input));
}
	
	
	
public static String Reverser (String input ) {

String tupni = "";
	for (int i=input.length()-1; i>=0; i--)
tupni += input.charAt(i);
return tupni;}

	
}
