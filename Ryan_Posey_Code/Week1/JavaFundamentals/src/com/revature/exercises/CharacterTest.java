package com.revature.exercises;
public class CharacterTest {

	public static void main(String[] args) {
		//create instances of characters
		Character warrior = new Warrior("Erdric", "Sword");
		Character mage = new Mage("Merith", "Fireball");
		
		//list warrior's stats
		System.out.println(warrior.listStats());
		System.out.println("\n");
		
		//list mage's stats
		System.out.println(mage.listStats());
		System.out.println("\n");
		
		//Warrior, attack!
		System.out.println(warrior.attack());
		
		//Mage, attack!
		System.out.println(mage.attack());
	}
}
