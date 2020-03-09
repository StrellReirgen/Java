package objectmaster;

public class Ninja extends Human{
	public Ninja() {
		this.stealth = 10;
		this.health = 100;
	}
		
	public Human steal(Human stealed) {
		stealed.health -= this.stealth;
		this.health += this.stealth;
		return this;	
	}
	
	public void runAway() {
		this.health -= 10;	
	}
}
