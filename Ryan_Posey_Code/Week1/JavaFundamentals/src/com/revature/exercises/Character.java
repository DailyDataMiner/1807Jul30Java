package com.revature.exercises;
//Base for a character
public abstract class Character {
	//all characters have health and a name
	private int health;
	private String name;
	
	//default constructor
	public Character() {
		health = 100;
		name = "Generic Name";
	}
	
	//initialize character with specific name
	public Character(String name) {
		health = 100;
		this.name = name;
	}
	
	//health getters and setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	// name getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// method to list the characters name and health
	public String listStats() {
		return "Name: " + name
				+ "\n"
				+ "Health: " + health
				+ "\n";
	}
	
	// abstract method to determine how character attacks
	public abstract String attack();
}

//warrior type character, sub-class of Character
class Warrior extends Character {
	
	//warriors use weapons, so another variable is added
	private String weapon;
	
	//constructor, pulls from Character for name
	public Warrior(String name, String weapon) {
		super(name);
		this.weapon = weapon;
	}
	
	//getters and setters for weapon
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	//overwritten method to list stats, adding weapon type
	public String listStats() {
		return super.listStats()
				+ "Class: Warrior"
				+ "\n"
				+ "Weapon: " + weapon;
	}
	
	//implementation of abstract method in Character
	public String attack() {
		if(weapon == "Sword") {
			return "Sword swipe!";
		}
		else if(weapon == "Hammer") {
			return "Hammer Down!";
		}
		else if(weapon == "Battleaxe") {
			return "May I AXE you a question?!";
		}
		else return "Forgot my weapon at home. /shrug";
	}
}

// a magic user, sub-class of character
class Mage extends Character {
	//defines type of magic spell
	private String magic;

	//constructor, pulls name from Character
	public Mage(String name, String magic) {
		super(name);
		this.magic = magic;
	}
	
	//getters and setters for magic type
	public String getMagic() {
		return magic;
	}
	
	public void setMagic(String magic) {
		this.magic = magic;
	}
	
	//overwritten method to list stats, adding magic spell
	public String listStats() {
		return (super.listStats()
				+ "Class: Mage"
				+ "\n"
				+ "Equipped Spell: " + magic);
	}
	
	//implementation of abstract method in Character
	public String attack() {
		if(magic == "Fireball") {
			return "Burn!";
		}
		else if(magic == "Glacier") {
			return "Freeze!";
		}
		else if(magic == "Lightning") {
			return "BZZZZZZT!";
		}
		else return "Welp, out of mana. /shrug";
	}
}