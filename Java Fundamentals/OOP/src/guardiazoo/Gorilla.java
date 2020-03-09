package guardiazoo;

public class Gorilla extends Mammal{
	public void throwSomething() {
		System.out.println("El Gorila ha lanzado algo");
		this.energyLevel -= 5;
		
	}
	public void eatBananas() {
		System.out.println("El Gorila esta comiendo unas bananas");
		this.energyLevel += 10;
	}
	public void climb() {
		System.out.println("El Gorila escalo hasta la cima de un arbol");
		this.energyLevel -= 10;
	}

}
