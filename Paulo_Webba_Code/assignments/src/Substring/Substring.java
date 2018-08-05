package Substring;

public class Substring {
    public static void substring(String str, int idx) {
         int i =0;
           while (i < idx) {
        		System.out.print(str.charAt(i));
        		i++;
           }	
     }
public static void main(String[] args) {
		substring(" Paulinho", 5);
	}
}
