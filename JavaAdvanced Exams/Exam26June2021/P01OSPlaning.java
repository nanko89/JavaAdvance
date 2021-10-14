package Exam26June2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(taskStack::push);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(threadQueue::offer);

        int valueOfTask = Integer.parseInt(scanner.nextLine());

        boolean findValue = false;
        int thread = 0;
        while (!findValue) {
            int task = taskStack.peek();
            thread = threadQueue.peek();
            if (task == valueOfTask) {
                findValue = true;
                break;
            }
           threadQueue.poll();
            if (task <= thread) {
                taskStack.pop();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", thread, valueOfTask);
        System.out.println(threadQueue.toString().replaceAll("[\\[\\],]", ""));
    }
}
