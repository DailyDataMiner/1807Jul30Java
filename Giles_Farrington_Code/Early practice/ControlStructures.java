package com.revature.assignments;

public class ControlStructures {

	public static void main(String[] args) {
		//Deck contains only number values of cards for simplicity.
		int[] deck = {1,2,3,4,5,6,7,8,9,10,11,12};
		int[] hand = new int[5];
		int winningCard = 5;
		int jack = 11;
		int queen = 12;
		int king = 13;
		int ace = 1;
		boolean win = false;
		
		int card = 3;
		String cardString;
		
		//Draw 5 cards using for loop:
		for(int i = 0; i < hand.length; i++) {
			hand[i] = deck[i];
		}
		System.out.println("Current hand: " + hand[0] + "," + hand[1] + "," + hand[2] + "," + hand[3] + "," + hand[4]);
		
		//checks for good cards in your hand using for-each loop
		for(int cards:hand) {
			if(cards == winningCard) {
				System.out.println("You have the winning card in your hand!");
			}
			else if(cards == jack) {
				System.out.println("You got the Jack!");
			}
			else if(cards == queen) {
				System.out.println("You got the Queen!");
			}
			else if(cards == king) {
				System.out.println("You got the King!");
			}
			else if(cards == ace) {
				System.out.println("You got the Ace!");
			}
		}
		
		//checks for winning card (5), using do while loop
		do {
			if(card == 5) {
				System.out.println("You WIN!! (do while)");
				win = true;
			}
			card ++;
			
		}while(win == false);
		win = false;
		
		//checks for winning card(5), using while loop
		while(win == false) {
			if(card == 5) {
				System.out.println("You WIN!! (while)");
				win = true;
			}
			else if(card == 13) {
				System.out.println("You lose, sorry! (while)");
				break;
			}
			card++;
		}
		
		//Gets your current card value using switch statement
		switch (card) {
        	case 1:  cardString = "Ace";
                 break;
        	case 2:  cardString = "Two";
                 break;
        	case 3:  cardString = "Three";
                 break;
        	case 4:  cardString = "Four";
                 break;
        	case 5:  cardString = "Five";
                 break;
        	case 6:  cardString = "Six";
                 break;
        	case 7:  cardString = "Seven";
                 break;
        	case 8:  cardString = "Eight";
                 break;
        	case 9:  cardString = "Nine";
                 break;
        	case 10: cardString = "Ten";
                 break;
        	case 11: cardString = "Jack";
                 break;
        	case 12: cardString = "Queen";
                 break;
        	case 13: cardString = "King";
            	break;
        	default: cardString = "Your card doesn't exist, cheater.";
                 break;
		}
		System.out.println("Your card is: " + cardString);

	}

}
