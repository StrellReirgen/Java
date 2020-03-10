package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokedex extends AbstractPokemon{
	
	//private static int myPokemons = Pokemon.getCounts();
	List<Pokemon> lista = new ArrayList<Pokemon>();
	
	public void listPokemon() {
		for (Pokemon pokemon : lista) {
			System.out.println(pokemon.getName());
		}
	}
	
	public void cantidad() {
		System.out.println("Hay: " + Pokemon.getCounts() + " Pokemones encontrados");
	}
	
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon nuevoPokemon= super.createPokemon(name,health,type);
		lista.add(nuevoPokemon);
		return nuevoPokemon;
		
	}
}
