package com.revature.hw1.question3;

public class ReverseString {
	
	public static void main(String[] args) {
		//creates a string 
        String s="string";
        //Iterates through each char of string in reverse        
        for(int i=s.length()-1;i>=0;i--){
        	//
            s+=s.charAt(i);
        }
        s=s.substring(s.length()/2, s.length());
        System.out.println(s);
    }

}
