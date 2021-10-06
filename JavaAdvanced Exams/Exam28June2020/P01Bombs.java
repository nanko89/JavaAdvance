package Exam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Stack FIFO
        ArrayDeque<Integer> bombEffects = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        // Queue LIFO
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(bombCasing::push);
        Map <String,Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        int daturaBomb = 40;
        int cherryBomb = 60;
        int smokeDecoyBom = 120;
        boolean haveBomb = false;
        while (!bombCasing.isEmpty() && !bombEffects.isEmpty() && !haveBomb){

            int sumBomb = bombEffects.peek() + bombCasing.peek();

            if (sumBomb == daturaBomb){
                bombs.put("Datura Bombs", bombs.get("Datura Bombs") + 1);
                bombEffects.poll();
                bombCasing.pop();
            }else if (sumBomb == cherryBomb){
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs") + 1);
                bombEffects.poll();
                bombCasing.pop();
            }else if (sumBomb == smokeDecoyBom){
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs") + 1);
                bombEffects.poll();
                bombCasing.pop();
            }else {
                int newBombCasting = bombCasing.pop()- 5;
                bombCasing.push(newBombCasting);
            }

            if (bombs.get("Datura Bombs") >= 3 &&
                    bombs.get("Cherry Bombs") >= 3 &&
                    bombs.get("Smoke Decoy Bombs") >= 3){
                haveBomb = true;
            }
        }
        if (haveBomb){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffects.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.println("Bomb Effects: " + bombEffects.toString().replaceAll("[\\[\\]]",""));
        }
        if (bombCasing.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.println("Bomb Casings: " + bombCasing.toString().replaceAll("[\\[\\]]", ""));
        }
        bombs.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
