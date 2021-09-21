import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("output-byte.txt");

        while (nextByte != -1){

            if (nextByte == ' '){
                printStream.print((char) nextByte);
            }else if (nextByte == 10 ){
                printStream.println();
            }else{
                printStream.print(nextByte);
            }

            nextByte = inputStream.read();
        }

    }
}
