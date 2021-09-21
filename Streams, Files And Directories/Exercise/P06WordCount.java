package Exersice;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("C:\\Users\\User" +
                "\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\words.txt");
        List<String> lines = Files.readAllLines(path);

        LinkedHashMap<String,Integer> words = new LinkedHashMap<>();
        for (String line : lines) {
            String[] word = line.split("\\s+");
            for (String s : word) {
                words.put(s, 0);
            }
        }
        Path pathSearched = Path.of("C:\\Users\\User\\Downloads" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        List<String> searchLines = Files.readAllLines(pathSearched);

        for (String searchLine : searchLines) {
            Arrays.stream(searchLine.split("\\s+")).forEach(
                    word -> {
                if (words.containsKey(word)){
                    words.put(word, words.get(word) +1 );
                }
            });
        }
        PrintWriter writer = new PrintWriter("word-count.txt");
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            writer.println(entry.getKey() + " - " + entry.getValue());
        }
        writer.close();
    }
}
