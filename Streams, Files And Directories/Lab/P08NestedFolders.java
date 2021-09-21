import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\Documents" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources");

        ArrayDeque<File> files = new ArrayDeque();

        files.offer(file);

        PrintStream printStream = new PrintStream("nested-folders.txt");

        while (!files.isEmpty()) {
            File innerFile = files.poll();
            printStream.println(innerFile.getName());
            for (File f : innerFile.listFiles()) {
                if (f.isDirectory()) {
                    files.offer(f);
                } else {
                    printStream.println(f.getName());
                }
            }
        }

    }

}


