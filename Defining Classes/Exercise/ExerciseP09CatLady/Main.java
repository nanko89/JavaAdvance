package ExerciseP09CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Cat> cats = new HashMap<>();
        while (!input.equals("End")){
            String[] token = input.split("\\s+");
            String breed = token[0];
            String name = token[1];
            Cat cat = null;
            switch (breed){
                case "StreetExtraordinaire":
                    double decibelsOfMeows = Double.parseDouble(token[2]);
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name,decibelsOfMeows);
                    cat = new Cat(breed,streetExtraordinaire);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(token[2]);
                    Cymric cymric = new Cymric(name,furLength);
                    cat = new Cat(breed, cymric);
                    break;
                case "Siamese":
                    double earSize = Double.parseDouble(token[2]);
                    Siamese siamese = new Siamese(name,earSize);
                    cat = new Cat(breed, siamese);
                    break;
            }
                    cats.put(name,cat);

            input = scanner.nextLine();

        }
            String currentCat = scanner.nextLine();
        for (String s : cats.keySet()) {
            if (s.equals(currentCat)){
                System.out.println(cats.get(s).toString());
            }
        }
    }
}
