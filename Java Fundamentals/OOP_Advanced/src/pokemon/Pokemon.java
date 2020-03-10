package pokemon;

public class Pokemon {
	private String name;
	private int health;
	private String type;
	private static int count = 0;
	
	public Pokemon(String nombre, int salud,String tipo) {
		setName(nombre);
		setHealth(salud);
		setType(tipo);
		count++;
	}
	
	public void attackPokemon(Pokemon pokemon) {
		System.out.println(this.name + " ha atacado a " + pokemon.getName());
		pokemon.health -= 10;
	}
	
	public String getName() {
		return name;
	}
	public static int getCounts() {
		return count;
	}
	public int getHealth() {
		return health;
	}
	public String getType() {
		return type;
	}
	public void setName(String nombre) {
		this.name = nombre;
	}
	public void setHealth(int salud) {
		this.health = salud;
	}
	public void setType(String tipo) {
		this.type = tipo;
	}
}
