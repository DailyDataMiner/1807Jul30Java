import java.util.*;

public class DogShow {

	public static void main (String args[]) {
		
		
		ArrayList<Dogs> dogList = new ArrayList<Dogs>();
		
		dogList.add(new Dogs(6, "Bluffy", "Orange", "Big"));
		dogList.add(new Dogs(3, "Luna", "Black", "Medium"));
		dogList.add(new Pug("Tori"));
		
		for(Dogs dog : dogList) {
			dog.prance();
		}
		
		System.out.println("There sure are a lot of dogs out there today! I counted " + Dogs.dognumber + ".");
		
		
		System.out.println("Are you trying to find your dog? What's its name?");
		Scanner dogFinder = new Scanner(System.in);
		String dogFinderName = dogFinder.nextLine();
		System.out.println("What's its age?");
		int dogFinderAge = dogFinder.nextInt();
		System.out.println("What color is it?");
		Scanner dogFinder2 = new Scanner(System.in);
		String dogFinderColor = dogFinder2.nextLine();
		System.out.println("What size is it?");
		Scanner dogFinder3 = new Scanner(System.in);
		String dogFinderSize = dogFinder3.nextLine();
		
		dogFinder.close();
		dogFinder2.close();
		dogFinder3.close();
		
		boolean dogFound = false;
		for(Dogs dog : dogList) {
			if (dog.getName().equals(dogFinderName)) {
				System.out.println("Your dog has been found! Its ID is " + dog.getID() + ".");
				dogFound = true;
				break;
			}
		}
		if (dogFound == false ) {
			Dogs newDog = new Dogs(dogFinderAge, dogFinderName, dogFinderColor, dogFinderSize);
			dogList.add(newDog);
			System.out.println("I think I just saw your dog!");
			newDog.prance();
			
		}
		
	}
	
}
