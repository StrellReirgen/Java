package objectmaster;

public class Samurai extends Human{
	private static int contador;
	public Samurai() {
		this.health = 200;
		contador++;
	}
		
	public Human deathBlow(Human victim) {
		victim.health = 0;
		this.health -= this.health / 2;
		return this;	
	}
	
	public void meditate() {
		this.health += this.health / 2;	
	}
	public int howMany() {
		return contador;	
	}
}
