package ExerciseP06PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while (!input.equals("Tournament")) {
            //"<TrainerName> <PokemonName> <PokemonElement> <PokemonHealth>"
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).addPokemon(pokemon);

            input = scanner.nextLine();

        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String element = command;
            for (Trainer trainer : trainers.values()) {
                if (trainer.elementType(element)) {
                    trainer.incrementBadges(1);
                }else {
                    trainer.damagePokemons(10);
                }
            }
            command = scanner.nextLine();

        }
        trainers
                .entrySet()
                .stream()
                .sorted((f,s) -> s.getValue().getNumberOfBadges() - f.getValue().getNumberOfBadges())
                .forEach(e -> System.out.println( e.getValue().toString()));
    }
}
