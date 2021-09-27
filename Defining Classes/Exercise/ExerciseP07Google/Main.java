package ExerciseP07Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input  = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!input.equals("End")){
        String[] tokens = input.split("\\s+");
        String name = tokens[0];
        String type = tokens[1];
        Person person = new Person(name);
            boolean hasPerson = false;
            for (Person currentPerson:people) {
                if (currentPerson.getName().equals(name)){
                    hasPerson = true;
                    person = currentPerson;
                    break;
                }
            }
        switch (type){
            case "company":
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                Company company = new Company(companyName,department,salary);
                person.setCompany(company);

                break;
            case "car":
               String model = tokens[2];
               int speed = Integer.parseInt(tokens[3]);
               Car car = new Car(model,speed);
               person.setCar(car);

                break;
            case "pokemon":
                String namePokemon = tokens[2];
                String typePokemon = tokens[3];
                Pokemon pokemon = new Pokemon(namePokemon,typePokemon);
                List<Pokemon> pokemons = person.getPokemons();
                pokemons.add(pokemon);
                person.setPokemons(pokemons);
                break;
            case "parents":
                String nameParent = tokens[2];
                String birthday = tokens[3];
                Parents parents = new Parents(nameParent,birthday);
                List<Parents> parentsList = person.getParents();
                parentsList.add(parents);
                person.setParents(parentsList);
                break;
            case "children":
                String nameChild = tokens[2];
                String birthdayChild = tokens[3];
                Children children = new Children(nameChild,birthdayChild);
                List<Children> childrenList = person.getChildren();
                childrenList.add(children);
                person.setChildren(childrenList);
                break;
        }

            if (hasPerson){
                for (int i = 0; i < people.size(); i++) {

                        if (people.get(i).getName().equals(name)){
                            hasPerson = true;
                            people.remove(i);
                            people.add(person);
                            break;

                    }
                }
            }else {
            people.add(person);
            }

            input = scanner.nextLine();

        }
        String targetName = scanner.nextLine();

        for (Person person : people) {
            if (person.getName().equals(targetName)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(person.getName()).append("\n");
                stringBuilder.append("Company:\n");
                if (person.getCompany() != null) {
                    stringBuilder.append(person.getCompany().toString());
                }
                stringBuilder.append("Car:\n");
                if (person.getCar() != null) {
                    stringBuilder.append(person.getCar().toString());
                }
                stringBuilder.append("Pokemon:\n");
                if (!person.getPokemons().isEmpty()) {
                    for (Pokemon pokemon : person.getPokemons()) {
                        stringBuilder.append(pokemon.toString());
                    }
                }
                stringBuilder.append("Parents:\n");
                if (!person.getParents().isEmpty()) {
                    for (Parents parents : person.getParents()) {
                        stringBuilder.append(parents.toString());
                    }
                }
                stringBuilder.append("Children:\n");
                if (!person.getChildren().isEmpty()) {
                    for (Children children : person.getChildren()) {
                        stringBuilder.append(children.toString());
                    }
                }
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
