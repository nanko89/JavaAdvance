import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);
        int count = 1;
        PrintStream printStream = new PrintStream("thirdLine-print.txt");
        while (scanner.hasNext()){
            if (count % 3 ==0){
                printStream.println(scanner.nextLine());
            }else {
                scanner.nextLine();
            }
            count++;
        }

    }
}
