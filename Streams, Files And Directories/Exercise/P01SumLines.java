package Exersice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P01SumLines {
    public static void main(String[] args) throws IOException {
        String file = "C:\\Users\\User\\Downloads" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> list = Files.readAllLines(Path.of(file));

        //Или този вариант :
//        Path path = Path.of("C:\\Users\\User\\Downloads" +
//           "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
//        List<String> list = Files.readAllLines(path);
        list.stream().map(String::toCharArray).forEach(charArray -> {
        int sum = 0;
            for (char c : charArray) {
                sum += c;
            }
            System.out.println(sum);
        });

        }
    }

