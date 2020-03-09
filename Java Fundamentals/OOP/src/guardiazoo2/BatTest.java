package guardiazoo2;

public class BatTest {

	public static void main(String[] args) {
		Bat dragon = new Bat();
		System.out.println("Hay un dragon suelto en la ciudad");
		dragon.fly();
		dragon.attackTown();
		dragon.attackTown();
		dragon.eatHumans();
		dragon.fly();
		dragon.attackTown();
		dragon.eatHumans();
		dragon.displayEnergy();

	}

}
