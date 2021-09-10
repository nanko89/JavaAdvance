import java.util.ArrayDeque;
import java.util.Scanner;

public class P08SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> memoryStack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String currentCommand = command[0];

            if (currentCommand.equals("1")){
                String appends = command[1];
                memoryStack.push(text.toString());
                text.append(appends);
            }else if (currentCommand.equals("2")){
                memoryStack.push(text.toString());
                int count = Integer.parseInt(command[1]);
                int startIndex = text.length() - count;
                text.delete(startIndex,startIndex+count);
            }else if (currentCommand.equals("3")){
                int index = Integer.parseInt(command[1]);
                System.out.println(text.charAt(index - 1));
            }else if (currentCommand.equals("4")){
                if (!memoryStack.isEmpty()){
                   text = new StringBuilder( memoryStack.pop());
                }
            }

        }

    }
}
