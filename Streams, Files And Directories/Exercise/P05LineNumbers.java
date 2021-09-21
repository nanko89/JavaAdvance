package Exersice;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\Users\\User\\Downloads" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        List<String> list = Files.readAllLines(path);
        int numberRow = 0;
        PrintWriter writer = new PrintWriter("line-num");

        for (String s : list) {
            numberRow++;
            writer.println(numberRow + ". " + s);
        }
        writer.close();
    }
}
