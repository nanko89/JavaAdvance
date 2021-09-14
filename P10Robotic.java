import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

    public class P10Robotic {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<String> robots = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());

            int[] times = new int[robots.size()];
            String[] namesRobots = new String[robots.size()];


            for (int i = 0; i < robots.size(); i++) {
                String[] tokens = robots.get(i).split("-");
                String name = tokens[0];
                namesRobots[i] = name;
                int time = Integer.parseInt(tokens[1]);
                times[i] = time;
            }
            String[] startTime = scanner.nextLine().split(":");
            int hours = Integer.parseInt(startTime[0]);
            int minutes = Integer.parseInt(startTime[1]);
            int seconds = Integer.parseInt(startTime[2]);

            int startTimeInSec = hours * 3600 + minutes * 60 + seconds;

            ArrayDeque<String> productQueue = new ArrayDeque<>();
            String input;

            while (!"End".equals(input = scanner.nextLine())) {
                productQueue.offer(input);
            }
            int[] robotsWorkTime = new int[robots.size()];
            while (!productQueue.isEmpty()) {
                startTimeInSec++;
                String product = productQueue.poll();

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
                    robotsWorkTime[index] = times[index];
                    System.out.println(printRobotData(namesRobots[index],product,startTimeInSec));
                } else {
                    productQueue.offer(product);
                }

            }

        }

        public static String printRobotData(String namesRobot, String product, int beginTime) {
            int seconds  = beginTime % 60;
            int minutes = (beginTime / 60) % 60;
            int hour = (beginTime / (60 * 60)) % 24;

            String time = String.format("%02d:%02d:%02d", hour,minutes,seconds);
            return String.format("%s - %s [%s]",namesRobot, product, time);
        }
    }


