package LinearDataStructuresExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P14SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> textPrev = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            switch (data[0]){
                case "1":
                    String text = data[1];
                    textPrev.push(sb.toString());
                    sb.append(text);
                    break;
                case "2":
                    int count = Integer.parseInt(data[1]);
                    textPrev.push(sb.toString());
                    for (int j = 0; j <count ; j++) {
                        sb.deleteCharAt(sb.length()-1);
                    }
                    break;
                case "3":
                    int index = Integer.parseInt(data[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;
                case "4":
                   String prev = textPrev.pop();
                   sb = new StringBuilder(prev);
                    break;
            }
         }

    }
}
