import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Set<Character> separator = new HashSet<>();
        separator.add('.');
        separator.add(',');
        separator.add('?');
        separator.add('!');
        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("output.txt");

        while (nextByte != -1){
        char symbol = (char)nextByte;

        if (!separator.contains(symbol)){
            printStream.print(symbol);
        }

            nextByte = inputStream.read();
        }

    }
}
