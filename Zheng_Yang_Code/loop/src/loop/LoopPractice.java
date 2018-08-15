package loop;

public class LoopPractice {
	public static void main() {

        //create an array1 with for loop
        int arr[] = {1,2,3};
        for(int i = 0; i < arr.length; i++) {
        	System.out.println(arr[i]);
        }   
        //go over array1, then print it
        for (int i=0; i<arr.length; i++) 
        { 
            int var = arr[i];
            System.out.println(var);
        }
        
        //while loop
        int i=10;
        while(i>1){
             System.out.println(i);
             i--;
        }
        
        
        //dowhile loop
        int j = 5;
        do{
            System.out.println(j);
            j--;
       }while(j>1);
       
        //if statement 
        if(3>2) {
        	System.out.println("haha");
        }
        
        //if else if statement
        int k = 10;
        if(k>2) {
        	System.out.println("haha");
        } else if(k<2) {
        	System.out.println("yoyo");
        } else {
        	System.out.println("yes!!");
        }
        
        
        //switch 
        int day = 5;
        String dayString;
         
        // switch statement with int data type
        switch (day) 
        {
            case 1:  dayString = "Monday";
                     break;
            case 2:  dayString = "Tuesday";
                     break;
            case 3:  dayString = "Wednesday";
                     break;
            case 4:  dayString = "Thursday";
                     break;
            case 5:  dayString = "Friday";
                     break;
            case 6:  dayString = "Saturday";
                     break;
            case 7:  dayString = "Sunday";
                     break;
            default: dayString = "Invalid day";
                     break;
        }
        System.out.println(dayString);
        
        
    }
}
