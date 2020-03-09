package objectmaster;

public class Wizard extends Human{
	public Wizard() {
		this.intelligence = 8;
		this.health = 50;
	}
		
	public Human heal(Human healed) {
		healed.health += this.intelligence;
		return this;	
	}
	
	public Human fireBall(Human burned) {
		burned.health -= this.intelligence * 3;
		return this;	
	}
}
