package guardiazoo;

public class Mammal {
	public int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println("La energia del Mamifero es: " + energyLevel);
		return energyLevel;
	}
}
