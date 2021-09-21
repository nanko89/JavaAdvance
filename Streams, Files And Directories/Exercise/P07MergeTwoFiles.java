package Exersice;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path firstPath = Path.of("C:\\Users\\User\\Downloads" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path secondPath = Path.of("C:\\Users\\User\\Downloads" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        List<String> firstLine = Files.readAllLines(firstPath);
        List<String> secodLine = Files.readAllLines(secondPath);

        PrintWriter writer = new PrintWriter("merge-file.txt");
        firstLine.forEach(writer::println);
        secodLine.forEach(writer::println);

        writer.close();
    }
}
