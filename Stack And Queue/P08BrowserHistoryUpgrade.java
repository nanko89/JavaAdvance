import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> historyBack = new ArrayDeque<>();
        ArrayDeque<String> historyForward = new ArrayDeque<>();

        String command;


        while (!"Home".equals(command = scanner.nextLine())) {
            if (command.equals("back")) {
                if (historyBack.size() < 2) {
                    System.out.println("no previous URLs");
                } else {
                    historyForward.addFirst(historyBack.peek());
                    historyBack.pop();
                    System.out.println(historyBack.peek());
                }

            } else if (command.equals("forward")) {
                if (historyForward.size() < 1) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(historyForward.peek());
                    historyBack.push(historyForward.pop());
                }
            } else {
                System.out.println(command);
                historyBack.push(command);
                historyForward.clear();

            }
        }
    }

}

