import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        List<Integer> plants = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> indexPlants = new ArrayDeque<>();

        int dayCounter = 0;

        while (true){
            dayCounter++;
            int diedFlower = 0;
            for (int i = plants.size() - 1; i >= 1 ; i--) {
                int leftPlant = plants.get(i - 1);
                int rightPlant = plants.get(i);
                if (rightPlant > leftPlant){
                    diedFlower = 1;
                    indexPlants.offer(i);
                }
            }
            while (!indexPlants.isEmpty()){

                plants.remove(indexPlants.poll()+1 -1);
            }
            if (diedFlower == 0){
                dayCounter--;
                System.out.println(dayCounter);
                return;
            }
        }
    }
}

