package LinearDataStructuresExercises;

import java.util.*;

public class P15InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stackID = new ArrayDeque<>();
        ArrayDeque<String> queueName = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(stackID::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(queueName::offer);

        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String[] token = input.split(" ");
            switch (token[0]) {
                case "add-ID":
                    stackID.push(token[1]);
                    break;
                case "add-agent":
                    queueName.offer(token[1]);
                    break;
                case "remove-ID":
                    System.out.println(stackID.pop() + " has been removed.");
                    break;
                case "remove-agent":
                    System.out.println(queueName.pollLast() + " has left the queue.");
                    break;
                case "sort-ID":
                    sorted(stackID);
                    break;
            }
            input = scanner.nextLine();
        }
        while (!stackID.isEmpty() || !queueName.isEmpty()) {
            if (!stackID.isEmpty() && !queueName.isEmpty()) {
                System.out.println(queueName.poll() + " takes ID number: " + stackID.pop());
            } else if (!stackID.isEmpty()) {
                System.out.println("No more agents left.");
                while (!stackID.isEmpty()) {
                    System.out.println("ID number: " + stackID.pop());
            }
        }else{
            System.out.println(queueName.poll() + " does not have an ID.");
        }
    }

}

    private static void sorted(ArrayDeque<String> stackID) {
        List<String> ids = new ArrayList<>();
        while (!stackID.isEmpty()) {
            ids.add(stackID.pop());
        }
        Collections.sort(ids);

        for (String id : ids) {
            stackID.push(id);
        }
    }
}
