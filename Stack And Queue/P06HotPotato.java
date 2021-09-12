import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> namesChild = new ArrayDeque<>();

        for (String child : children) {
            namesChild.offer(child);
        }

        while (namesChild.size() > 1){
            for (int i = 1; i < n; i++) {
                namesChild.offer(namesChild.poll());
            }
            System.out.println("Removed " + namesChild.poll());
        }
        System.out.println("Last is " + namesChild.poll());
    }
}
