package Exam17Dec2019;

import java.util.*;

public class P01SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] materialsBoxes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] magicalValue = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> toys = new TreeMap<>();
        int doll = 150;
        int teddyBear = 300;
        int woodenTrain = 250;
        int bicycle = 400;
        ArrayDeque<Integer> stackMaterial = new ArrayDeque<>();
        ArrayDeque<Integer> queueMagic = new ArrayDeque<>();

        for (int material : materialsBoxes) {
            if (material != 0) {
                stackMaterial.push(material);
            }
        }

        for (int magic : magicalValue) {
            if (magic != 0) {
                queueMagic.offer(magic);
            }
        }

        while (!stackMaterial.isEmpty() && !queueMagic.isEmpty()) {
            int material = stackMaterial.peek();
            int magic = queueMagic.peek();
            int result = material * magic;

            boolean haveToys = checkResult(result, toys, doll, teddyBear, woodenTrain, bicycle);
            stackMaterial.pop();
            queueMagic.poll();
            if (!haveToys) {
                if (result < 0) {
                    result = material + magic;
                    if (result != 0) {
                        stackMaterial.push(result );

                    }
                } else if (result > 0) {
                    stackMaterial.push(material + 15);
                }
            }
        }

        if ((toys.containsKey("Doll") && toys.containsKey("Wooden train"))
        || (toys.containsKey("Teddy bear") && toys.containsKey("Bicycle"))) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!stackMaterial.isEmpty()) {
            System.out.println("Materials left: " + stackMaterial.toString().replaceAll("[\\[\\]]", ""));
        }
        if (!queueMagic.isEmpty()) {
            System.out.println("Magic left: " + queueMagic.toString().replaceAll("[\\[\\]]", ""));
        }
        toys.forEach((key, value) -> System.out.println(key + ": " + value));


    }

    private static boolean checkResult(int result, Map<String, Integer> toys, int dollMagic, int teddyBearMagic, int woodenTrain, int bicycle) {
        if (result == dollMagic) {
            toys.putIfAbsent("Doll", 0);
            toys.put("Doll", toys.get("Doll") + 1);
            return true;
        } else if (result == teddyBearMagic) {
            toys.putIfAbsent("Teddy bear", 0);
            toys.put("Teddy bear", toys.get("Teddy bear") + 1);
            return true;
        } else if (result == woodenTrain) {
            toys.putIfAbsent("Wooden train", 0);
            toys.put("Wooden train", toys.get("Wooden train") + 1);
            return true;
        } else if (result == bicycle) {
            toys.putIfAbsent("Bicycle", 0);
            toys.put("Bicycle", toys.get("Bicycle") + 1);
            return true;
        }
        return false;
    }
}
