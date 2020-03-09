package objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		//Human humano1 = new Human();
		//Human humano2 = new Human();
		//humano1.attack(humano2);
		//humano1.displayHealth();
		//humano2.displayHealth();
		Wizard merlin = new Wizard();
		Ninja raiden = new Ninja();
		Samurai kojiro = new Samurai();
		Samurai musashi = new Samurai();
		Samurai gintoki = new Samurai();
		raiden.steal(gintoki);
		raiden.runAway();
		merlin.fireBall(raiden);
		merlin.heal(gintoki);
		kojiro.deathBlow(musashi);
		kojiro.meditate();
		System.out.println(gintoki.howMany());
		merlin.displayHealth();
		raiden.displayHealth();
		kojiro.displayHealth();
		musashi.displayHealth();
		gintoki.displayHealth();
		
	}
}