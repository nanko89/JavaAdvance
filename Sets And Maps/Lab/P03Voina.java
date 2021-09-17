package Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int round = 50;
        while (round-- > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()){

            int first = firstPlayer.iterator().next();//взимаме следващата стойност в сета
            int second = secondPlayer.iterator().next();

            firstPlayer.remove(first);
            secondPlayer.remove(second);

            if (first > second){
                firstPlayer.add(first);
                firstPlayer.add(second);
            }else if (first < second){
                secondPlayer.add(first);
                secondPlayer.add(second);
            }


        }
        if (firstPlayer.size() == secondPlayer.size()){
            System.out.println("Draw!");
        }else if (secondPlayer.size() < firstPlayer.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Second player win!");
        }
    }
}
