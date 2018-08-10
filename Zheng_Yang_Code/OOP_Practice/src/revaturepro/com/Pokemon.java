package revaturepro.com;

class Pokemon extends Animal{
	
	int spirit = 6;
	
	@Override
	public void breathe() {
		// TODO Auto-generated method stub
		this.spirit+= 1;
	}
	
	//overload
	public void breathe(int Healing) {
		// TODO Auto-generated method stub
		this.spirit+= Healing;
	}
	
	@Override
	void attack() {
		// TODO Auto-generated method stub
		spirit-=1;
	}
	
	void print() {
		System.out.println(this.spirit);
	}
	
	
	
	
	
}
