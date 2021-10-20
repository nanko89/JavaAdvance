package LinearDataStructuresExercises;

import java.util.*;

public class P11Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(";");

        String[] robotsName = new String[data.length];
        int[] robotsTime = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            String robotName = data[i].split("-")[0];
            int robotTime = Integer.parseInt(data[i].split("-")[1]);
            robotsTime[i] = robotTime;
            robotsName[i] = robotName;
        }

        String[] startTime = scanner.nextLine().split(":");

        int hour = Integer.parseInt(startTime[0]);
        int minutes = Integer.parseInt(startTime[1]);
        int seconds = Integer.parseInt(startTime[2]);
        int timeInSec = seconds + (minutes * 60) + (hour * 3600);


        String input = scanner.nextLine();
        ArrayDeque<String> products = new ArrayDeque<>();
        while (!input.equals("End")) {
            String product = input;
            products.add(product);
            input = scanner.nextLine();
        }

        int[] robotsWorkTime = new int[robotsTime.length];
        while (!products.isEmpty()) {
            timeInSec++;
            String product = products.poll();

            int index = -1;

            for (int i = 0; i < robotsWorkTime.length; i++) {
                if (robotsWorkTime[i] > 0) {
                    robotsWorkTime[i]--;
                }

                if (robotsWorkTime[i] == 0 && index == -1) {
                    index = i;
                }
            }
            if (index != -1) {
                robotsWorkTime[index] = robotsTime[index];
                printRobotData(robotsName[index], product, timeInSec);
            } else {
                products.offer(product);
            }
        }
    }

    public static void printRobotData(String robotsName, String product, int timeInSec) {
        int currentHour = (timeInSec / 3600) % 24;
        int currentMinutes = (timeInSec / 60) % 60;
        int currentSec = timeInSec % 60;

        String time = String.format("[%02d:%02d:%02d]",
                currentHour, currentMinutes, currentSec);

        System.out.println(robotsName + " - " + product + " " + time);
    }
}
