package revaturepro.com;

public final class Pikachu extends Pokemon{
	
	private int spirit;
	String name = "";
	
	public Pikachu(int spirit) {
		this.spirit = spirit;
	}
	
	public Pikachu( String name) {
		
		this.name = name;
	}
	
	
	void attackthunder() {
		this.spirit -= 3;
	}
	
	void setSpirit(int spirit) {
		this.spirit = spirit; 
	}
	
	int getSpirit() {
		return this.spirit;
	}
	
	
	void print() {
		System.out.println("Pokemon: "+this.name + ", with spirit of " +this.spirit);
	}
	
	
	
}
