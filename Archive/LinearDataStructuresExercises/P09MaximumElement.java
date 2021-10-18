package LinearDataStructuresExercises;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;


public class P09MaximumElement {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");
            switch (command[0]){
                case "1":
                    int num = Integer.parseInt(command[1]);
                    stack.push(num);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":

                    System.out.println(Collections.max(stack));
                    break;
            }
        }

    }
}
