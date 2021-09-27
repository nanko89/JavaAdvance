package ExerciseP06PokemonTrainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private Map<String, List<Pokemon>> pokemon;

    public Trainer(String name){
        this.name = name;
        this.setPokemon();
        this.numberOfBadges = 0;
    }

    public String getName() {
        return name;
    }

    private void setPokemon() {
        this.pokemon = new HashMap<>();
        this.pokemon.put("Fire", new ArrayList<>());
        this.pokemon.put("Water" ,new ArrayList<>());
        this.pokemon.put("Electricity" ,new ArrayList<>());

    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemon.putIfAbsent(pokemon.getElement(), new ArrayList<>());
        this.pokemon.get(pokemon.getElement()).add(pokemon);
    }

    public boolean elementType(String element) {
        return this.pokemon.get(element).size() != 0;
    }

    public void incrementBadges(int increment) {
        this.numberOfBadges += increment;
    }

    public void damagePokemons(int damage) {
        for (List<Pokemon> pokemonList : pokemon.values()) {
            for (Pokemon pokemon : pokemonList) {
                pokemon.getDamage(damage);
            }
        }
        clearPokemon();
    }

    private void clearPokemon (){

        for (List<Pokemon> pokemons : pokemon.values()) {
            pokemons.removeIf(p -> p.getHealth() <= 0);
        }
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public int getPokemonCount(){
        int size =0;
        for (List<Pokemon> pokemons : pokemon.values()) {
            size += pokemons.size();
        }
        return size;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.getPokemonCount());
    }
}
