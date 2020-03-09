package guardiazoo2;

public class Bat {
	private int energyLevel;
	
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("El Dragon comenzo a volar!");
		this.energyLevel -= 50;
		
	}
	public void eatHumans() {
		System.out.println("OH NO, El Dragon se esta comiendo a unos Humanos!");
		this.energyLevel += 25;
	}
	public void attackTown() {
		System.out.println("El Dragon escupe fuego a unos Edificios!");
		this.energyLevel -= 100;
	}
	
	public int displayEnergy() {
		System.out.println("La energia del Dragon es: " + energyLevel);
		return energyLevel;
	}
}
