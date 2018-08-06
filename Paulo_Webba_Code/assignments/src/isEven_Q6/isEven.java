package isEven_Q6;

public class isEven {
     static boolean evenCheck(int number){
    	boolean checking = true;
    	for(int i=1; i <= number; i++ ) 
    		checking = !checking;		
    	
    	if(checking)
    		System.out.println(" The number is even. ");
    	else
    		System.out.println(" The number is not even. ");
    	return checking;
    }
   
	public static void main(String[] args) {
	      evenCheck(48);
	}

}
