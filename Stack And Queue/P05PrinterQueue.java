import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> printingFile = new ArrayDeque<>();

        while (!input.equals("print")){
                if (input.equals("cancel")){
                    if (printingFile.isEmpty()){
                        System.out.println("Printer is on standby");
                    }else {
                        System.out.println("Canceled " + printingFile.poll());
                    }
                }else {
                    printingFile.offer(input);
                }
            input = scanner.nextLine();

        }
        while (!printingFile.isEmpty()){
            System.out.println(printingFile.poll());
        }

    }
}
