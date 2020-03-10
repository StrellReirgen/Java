package pokemon;

public class PokeTest {

	public static void main(String[] args) {
		Pokedex kanto = new Pokedex();
		
		Pokemon charmander = kanto.createPokemon("Charmander", 40, "Fuego");
		Pokemon bulbasaur = kanto.createPokemon("Bulbasaur", 40, "Planta");
		Pokemon squirtle = kanto.createPokemon("Squirtle", 40, "Agua");
		kanto.cantidad();
		kanto.listPokemon();
		System.out.println(kanto.pokemonInfo(bulbasaur));
		System.out.println(kanto.pokemonInfo(charmander));
		System.out.println(kanto.pokemonInfo(squirtle));
		charmander.attackPokemon(bulbasaur);
		charmander.attackPokemon(bulbasaur);
		charmander.attackPokemon(bulbasaur);
		squirtle.attackPokemon(charmander);
		squirtle.attackPokemon(charmander);
		bulbasaur.attackPokemon(squirtle);
		System.out.println(kanto.pokemonInfo(bulbasaur));
		System.out.println(kanto.pokemonInfo(charmander));
		System.out.println(kanto.pokemonInfo(squirtle));
		
	}

}
