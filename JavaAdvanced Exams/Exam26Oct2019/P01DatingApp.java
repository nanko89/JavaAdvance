package Exam26Oct2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] male = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] female = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        for (int i = 0; i < male.length; i++) {
           if (male[i] % 25 == 0 && i < male.length - 1){
               i += 2;
           }else if (male[i] % 25 == 0 ){
               i++;
            }else {
               maleStack.push(male[i]);
           }
        }

        for (int i = 0; i < female.length; i++) {
            if (female[i] % 25 == 0 && i < female.length - 1){
                i += 2;
            }else if (female[i] % 25 == 0 ){
                i++;
            }else {
                femaleQueue.offer(female[i]);
            }
        }

        int successfulMatches = 0;

        while (!maleStack.isEmpty() || !femaleQueue.isEmpty()){

            chackValue(maleStack,femaleQueue);
            if (maleStack.isEmpty() || femaleQueue.isEmpty()){
                break;
            }
            int femaleValue = femaleQueue.peek();
            int maleValue = maleStack.peek();

            if (femaleValue == maleValue){
                successfulMatches++;
                femaleQueue.poll();
                maleStack.poll();
            }else {
                femaleQueue.poll();
                maleStack.poll();
                maleStack.push(maleValue - 2);
            }

        }
        System.out.printf("Matches: %d%n", successfulMatches);
        if (maleStack.isEmpty()){
            System.out.println("Males left: none");
        }else {
            System.out.println("Males left: " + maleStack.toString().replaceAll("[\\[\\]]", ""));
        }
        if (femaleQueue.isEmpty()){
            System.out.println("Females left: none");
        }else {
            System.out.println("Females left: " + femaleQueue.toString().replaceAll("[\\[\\]]", ""));
        }
    }

    private static void chackValue(ArrayDeque<Integer> maleStack, ArrayDeque<Integer> femaleQueue) {
        while (!maleStack.isEmpty() && maleStack.peek() <= 0){
            maleStack.pop();
        }
        if (maleStack.size() >= 2 && maleStack.peek() % 25 == 0){
            maleStack.pop();
            maleStack.pop();
        }else if (maleStack.size() == 1 && maleStack.peek() % 25 == 0){
            maleStack.clear();
        }

        while (!femaleQueue.isEmpty() && femaleQueue.peek() <= 0 ){
            femaleQueue.poll();
        }
        if (femaleQueue.size() >= 2 && femaleQueue.peek() % 25 == 0){
            femaleQueue.poll();
            femaleQueue.poll();
        }else if (femaleQueue.size() == 1 && femaleQueue.peek() % 25 == 0){
            femaleQueue.clear();
        }
    }
}
