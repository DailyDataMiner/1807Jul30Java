package homework1.q13;


import java.util.LinkedList;



//Uses Linked list to create the triangle to display
public class Triangle {

	public static void main(String[] args) {
	
		LinkedList<String> lList = new LinkedList<String>();
		
		for(int i = 0;i < 4; i++) {
			if(lList.isEmpty()) {
				lList.add("0");
			}
			else if(i%2 == 0) {
				//add to end
				if(lList.getLast() == "0") {
					//add 1 to end
					lList.addLast("1");
				}
				else {
					//add 0 to end
					lList.addLast("0");
				}
			}
			else {
				//add to beginning
				if(lList.getLast() == "1") {
					//add 0 to beginning
					lList.addFirst("0");
				}
				else {
					//add 1 to beginning
					lList.addFirst("1");
				}
			}
			System.out.println(lList);
		}
	}

}
