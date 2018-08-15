package com.revature.collections;
import java.util.LinkedList;
import java.util.Queue;

public class queue {
	
	public static void main(String[] args) {
	    // Create and initialize a Queue using a LinkedList
	    Queue<String> exampleQueue = new LinkedList<>();
	        
	    //Enqueue operation: add new elems to queue 
	    exampleQueue.add("Justin");
	    exampleQueue.add("Everett");
	    exampleQueue.add("Veronica");
	    exampleQueue.add("Briana");;
	    
	    System.out.println("exampleQueue : " + exampleQueue);    
	    //Removing an element from the Queue using remove() (The Dequeue operation)
	    //The remove() method throws NoSuchElementException if the Queue is empty
	    String name = exampleQueue.remove();
	    System.out.println("Removed from exampleWQueue : " + name + " | New exampleQueue : " + exampleQueue);

	    // Removing an element from the Queue using poll()
	    // The poll() method is similar to remove() except that it returns null if the Queue is empty.
	    name = exampleQueue.poll();
	    System.out.println("Removed from exampleQueue : " + name + " | New exampleQueue : " + exampleQueue);
	        
	        

}
}