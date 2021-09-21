package Exersice;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P03ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\User\\Downloads" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        List<String> list = Files.readAllLines(path);

        PrintWriter writer = new PrintWriter("upper-case.txt");

        list.forEach(line -> writer.println(line.toUpperCase()));
        writer.close();
    }
}
