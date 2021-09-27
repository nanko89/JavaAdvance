package ExerciseP03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = new Car(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2]));
            cars.put(input[0], car);
        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String model = command.split("\\s+")[1];
            int distance = Integer.parseInt(command.split("\\s+")[2]);

            Car carToDrive = cars.get(model);
            if (!carToDrive.drive(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }
        for (Car car : cars.values()) {
            System.out.println(car.toString());
        }
    }
}
