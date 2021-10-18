package LinearDataStructuresExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P08BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");

        int countNum = Integer.parseInt(data[0]);
        int countPopNum = Integer.parseInt(data[1]);
        int searchNum = Integer.parseInt(data[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .forEach(stack::push);

        for (int i = 0; i < countPopNum; i++) {
            stack.pop();
        }
        boolean findNum = false;
        boolean isEmpty= false;
        int minNum = Integer.MAX_VALUE;
        if (stack.isEmpty()){
           isEmpty = true;
        }
        while (!stack.isEmpty()){
            int number = stack.pop();
            if (number == searchNum){
                findNum = true;
                System.out.println(true);
                break;
            }else {
                if (minNum > number){
                    minNum = number;
                }
            }
        }
        if (!findNum && ! isEmpty){
            System.out.println(minNum);
        }else if (isEmpty){
            System.out.println(0);
        }
    }
}
