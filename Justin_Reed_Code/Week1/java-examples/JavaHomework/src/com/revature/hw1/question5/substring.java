package com.revature.hw1.question5;

public class substring {

	//This method takes a string value and an index
	//if the index is higher than the length of string 
	//output string, if it is not output all values in between 
	//and specified index
    static String substring(String str, int idx) {

          if (idx > str.length()) {

                return str;

          }

          String substring = "";

          for (int i = 0; i < idx; i++) {

                substring += str.charAt(i);

          }
          return substring;

    }

    public static void main(String[] args) {

          String string="I was too lazy to implement a scanner ";

          System.out.println("Original: "+string);

          System.out.println("substring to index 5: "+substring(string, 10));
          System.out.println("substring(string,50): "+substring(string, 27)); 
          System.out.println("substring(string,50): "+substring(string, 100));

    }

}