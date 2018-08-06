package interest_Q17;

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
       double principal, rate, time, interest=0.0;
       int years;
       System.out.println("Enter the numbers of years, principal, rate(%), then time(years): ");
       Scanner sc = new Scanner(System.in);
       years = sc.nextInt();
       Scanner sc1 = new Scanner(System.in);
       principal = sc1.nextDouble();
       Scanner sc2 = new Scanner(System.in);
       rate = (sc2.nextDouble()*(.01));
       Scanner sc3 = new Scanner(System.in);
       time = sc3.nextDouble();
        
       interest = principal* rate* time;
       
       
       System.out.println("The simple interest is: " + interest );
       
       
	}

}
